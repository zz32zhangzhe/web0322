<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/commen/head.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>

    <link rel="stylesheet" href="${bathpath}/css/pintuer.css">
    <link rel="stylesheet" href="${bathpath}/css/admin.css">
    <script src="${bathpath}/js/jquery.js"></script>
    <script src="${bathpath}/js/pintuer.js"></script>

</head>
<body>
<form method="post" action="" id="listform">
    <div  id="app" class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li> <a class="button border-main icon-plus-square-o" href="add.html"> 添加内容</a> </li>
                <li>搜索：</li>
                <li>首页
                    <select name="s_ishome" class="input" onchange="changesearch()" style="width:60px; line-height:17px; display:inline-block">
                        <option value="">选择</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                    &nbsp;&nbsp;
                    推荐
                    <select name="s_isvouch" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
                        <option value="">选择</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                    &nbsp;&nbsp;
                    置顶
                    <select name="s_istop" class="input" onchange="changesearch()"  style="width:60px; line-height:17px;display:inline-block">
                        <option value="">选择</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </li>
                <if condition="$iscid eq 1">
                    <li>
                        <select name="cid" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
                            <option value="">请选择分类</option>
                            <option value="">产品分类</option>
                            <option value="">产品分类</option>
                            <option value="">产品分类</option>
                            <option value="">产品分类</option>
                        </select>
                    </li>
                </if>
                <li>
                    <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <thead>
            <tr>
                <th >登录名</th>
                <th >用户名</th>
                <th>电话</th>
                <th>性别</th>
                <th>生日</th>
                <th>email</th>
                <th >地址</th>
            </tr>
            </thead>
            <tbody>
                <tr v-for="user in list">
                    <td>{{user.loginId}}</td>
                    <td>{{user.name}}</td>
                    <td>{{user.phone}}</td>
                    <td>
                        <template v-if="user.sex==1">男</template>
                        <template v-else>女</template>
                    </td>
                    <td>{{user.birthday}}</td>
                    <td>{{user.email}}</td>
                    <td>{{user.address}}</td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        <div class="pagelist">
            <a href="javascript:void(0)">首页</a>
            <a href="javascript:void(0)">上一页</a>
            <template v-if="max<=5">
                <template v-for="n in max">
                    <span v-if="n==pageNumber" class="current">{{n}}</span>
                    <a v-else href="javascript:void(0)" @click="changePageNumber(n)">{{n}}</a>
                </template>
            </template>
            <template v-else>
                <template v-for="n in 5">
                    <span v-if="(n+size.start-1)==pageNumber" class="current">{{n+size.start-1}}</span>
                    <a  v-else href="javascript:void(0)" @click="changePageNumber(n+size.start-1)">{{n+size.start-1}}</a>
                </template>
            </template>
            <a href="javascript:void(0)">下一页</a>
            <a href="javascript:void(0)">尾页</a>
        </div>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
    <script>
        new Vue({
            el:"#app",
            data(){
                return{
                    list:[],
                    pageNumber:1,
                    max:0
                }
            },
            computed:{
                size(){
                    let start=this.pageNumber-2;
                    let end=this.pageNumber+2;
                    if(start<=0){
                        start=1;
                        end=5;
                    }
                    if(end>this.max){
                        end=this.max;
                        start=end-4;
                    }
                    return {start:start,end:end}
                }
            },
            created(){
                this.getList();
            },
            methods:{
                changePageNumber(n){
                   this.pageNumber=n;
                   this.getList();
                },
                getList(){
                    let vue=this;
                    $.ajax({
                        url:"${bathpath}/user/getList",
                        dataType:"json",
                        data:{pageNumber:vue.pageNumber},
                        success:function(result){
                            console.log(result);
                            vue.list=result.message.list;
                            vue.pageNumber=result.message.pageNo;
                            vue.max=result.message.maxSize;

                        }
                    });
                }
            }
        })
    </script>
</body>
</html>