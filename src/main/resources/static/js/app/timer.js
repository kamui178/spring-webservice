

var realDate = new Date();
var endDate = new Date('2019-12-31 23:59:59')
var stDate = new Date().getTime();
var edDate = new Date('2019-12-31 23:59:59').getTime();

var remindTime = (edDate - stDate) * 0.001 ;



		function msg_time() {	
			

			
			m = Math.floor(remindTime / (3600 ) ) +  " : "  +  Math.floor((remindTime%3600) / 60) + " : " + Math.floor((remindTime % 60));	
			
			var msg = "Web renewal left time :  <font color='red'>" + m + "</font> ";
			
			document.all.ViewTimer.innerHTML = msg;	
					
			remindTime --;				
			
			if (remindTime < 0) {		
				
				clearInterval(tid);		
				alert("종료");
			}
			
		}

		window.onload = function TimerStart(){ tid=setInterval('msg_time()',1000) };


