<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

.news-box {
  width: 400px;
  background: white;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0,0,0,0.1);
  padding: 20px;
}
h2 {
  text-align: center;
  color: #2563eb;
}
ul {
  list-style: none;
  padding: 0;
}
li {
  margin: 10px 0;
  padding: 10px;
  border-bottom: 1px solid #eee;
}
a {
  text-decoration: none;
  color: #333;
}
a:hover {
  color: #2563eb;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
		const ws=new WebSocket("ws://192.168.0.35/JSPLastProject/news")
		const newList=document.getElementById("newsList")
		ws.onopen=()=>console.log("서버 연결 완료")
		ws.onclose=()=>console.log("서버 연결 종료")
		ws.onerror=(e)=>colsole.error("에러:",e)
		ws.onmessage=(event)=>{
	try {
		const data=JSON.parse(event.data);
		console.log(data)
		newList.innerHTML=""
		// $().html()
		data.map(news=>{
			const li=document.createElement("li")
			// <li> </li>
			li.innerHTML='<a href="'+news.link+'" target="_blank">'+news.title+'</a>'
			newsList.appendChild(li);
		})
	} catch (err) {
		console.error("JSON 파싱 실패:",err,event.data)
	}
}
})

</script>
</head>
<body>
  <div class="news-box">
    <h2>📰실시간 뉴스</h2>
    <ul id="newsList">
    
    </ul>
  </div>
</body>
</html>