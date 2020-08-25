<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>发布文章</title>

    <!-- Bootstrap -->
  	<link rel="stylesheet" type="text/css" href="/libs/bootstrap/css/bootstrap.min.css"/>
    <link href="/libs/summernote/summernote.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/css/cms.css"/>
    <script type="text/javascript" src="/libs/jquery/jquery-3.5.1.js"></script>
    <script src="/libs/summernote/popper.js" type="text/javascript"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/inc/top.jsp"/>
	
	<!-- 横幅 -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12 my_banner">
			</div>
		</div>
	</div>
	<br/>
	<!-- 主体内容区 -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<jsp:include page="/WEB-INF/inc/my_left.jsp">
				<jsp:param value="blog" name="module"/></jsp:include>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
				  <div class="panel-body">
				    	<h1>发布文章</h1>
				    	<hr/>
				    	<form:form modelAttribute="article" action="/my/article/save" enctype="multipart/form-data" method="post" >
				    	<form:hidden path="id"/>
				    	<p align="center" class="red"><form:errors path="id"/> </p>
				    	<p>
				    		<form:input path="title" class="form-control" placeholder="博客标题"/>
				    		<span class="red"><form:errors path="title"/></span>
				    	</p>
				    	
				    	<p>
				    		<form:textarea path="content" id="content" rows="20" class="form-control"/>
				    		<span class="red"><form:errors path="content"/></span>
				    	</p>
				    	
				    	<p>
				    		<form:textarea path="summary" rows="3" class="form-control" placeholder="摘要"/>
				    		<span class="red"><form:errors path="summary"/></span>
				    	</p>

						<p>
							<form:select path="channel.id" class="form-control" id="channel">
								<option value="">选择栏目</option>
								<form:options items="${channels}" itemLabel="name" itemValue="id"/>
							</form:select>
							<span class="red"><form:errors path="channel"/></span>
						</p>
				    	
				    	<p>
				    		<form:select path="category.id" class="form-control" id="category">
				    			<option value="">选择分类</option>
							</form:select>
				    		<span class="red"><form:errors path="category"/></span>
				    	</p>
				    	
				    	<p>上传封面：<input type="file" name="file"/>
					    	<c:if test="${not empty blog.cover}">
					    		<img alt="图片预览" src="${blog.cover}" height="50">
					    		<form:hidden path="cover"/>
					    		<a href="#">删除图片</a>
					    	</c:if>
				    	</p>
				    	
				    	<p>
				    		<button type="submit" class="btn btn-info btn-block">保存</button> 
				    	</p>
				    	
				    	</form:form>
				  </div>
				</div>
				
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/inc/footer.jsp"/>
	
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
	<script type="text/javascript">
		$("#content").summernote({
			placeholder:'博客内容',
			height:300
		});

		$("#channel").change(function () {
			// 清空二级下拉框
			$("#category option:gt(0)").remove();
			let id = $(this).val();

			$.post("/my/queryCategoriesById", {"id":id}, function (obj) {
				let str = "";
				for (let x in obj) {
					str = "<option value='"+ obj[x].id +"'>"+ obj[x].name +"</option>";
					$("#category").append(str);
				}
			},"json");
		});
	</script>
  </body>
</html>