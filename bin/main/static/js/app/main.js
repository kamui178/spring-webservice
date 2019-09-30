var main = {
	init : function() {
		var _this = this;
		$('#btn-save').on('click', function() {
			_this.save();
		});
	},
	save : function () {
		var data = {
			title: $('#title').val(),
			author : $('#author').val(),
			content : $('#content').val()
		};

		var encode = encodeURI('/posts');

		$.ajax({
			type : 'POST',
			url : '/posts',
			// url : encode,
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(data)
		}).done(function() {
			alert('글이 등록되었습니다.');
			location.reload();
		}).fail(function (error) {
			alert("에러뜸");
		})
	}
};

main.init();