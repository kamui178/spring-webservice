//
////$(document).ready(function() {
////	tid = setInterval('msg_time()', 1000);
////})
//
//window.onload = function TimerStart(){
//	tid = setInterval('msg_time()',1000);
//}
//
//var stDate = new Date().getTime();
//var edDate = new Date('2019-12-31 23:59:59').getTime(); // 종료일
//
//var remindTime = edDate - stDate;
//
//function msg_time() {
//	var h = Math.floor((remindTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
//	var m = Math.floor((remindTime % (1000 * 60 * 60)) / (1000 * 60));
//	var s = Math.floor((remindTime % (1000 * 60)) / 1000);
//	
//	var leftTime = h + " : " + m + " : " + s;
//	
//	console.log ('leftTime : ' + leftTime);
//	
//	document.all.Timer.innerHTML = leftTime;
//	
//	if(remindTime < 0) {
//		clearInterval(tid);
//	} else {
//		remindTime = remindTime - 1000;
//	}
//	 
//}

var realDate = new Date();
var endDate = new Date('2019-12-31 23:59:59')
var stDate = new Date().getTime();
var edDate = new Date('2019-12-31 23:59:59').getTime();

var remindTime = (edDate - stDate) * 0.001 ;

//	var SetTime = 5;		// 최초 설정 시간(기본 : 초)

		function msg_time() {	// 1초씩 카운트
			
//			console.log(realDate);
//			console.log(endDate);
//			console.log("re : " + remindTime);
			
			m = Math.floor(remindTime / (3600 ) ) +  " : "  +  Math.floor((remindTime%3600) / 60) + " : " + Math.floor((remindTime % 60));	// 남은 시간 계산
			
			var msg = "Web renewal left time :  <font color='red'>" + m + "</font> ";
			
			document.all.ViewTimer.innerHTML = msg;		// div 영역에 보여줌 
					
			remindTime --;					// 1초씩 감소
			
			if (remindTime < 0) {			// 시간이 종료 되었으면..
				
				clearInterval(tid);		// 타이머 해제
				alert("종료");
			}
			
		}

		window.onload = function TimerStart(){ tid=setInterval('msg_time()',1000) };


