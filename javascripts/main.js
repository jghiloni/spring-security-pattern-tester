/**************************************************************************
 * Copyright 2015 ECS Team, Inc.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **************************************************************************/
(function() {
	var checkHealth = function() {
		var showForm = false;
		var showError = false;
		$.ajax({
			url: BASE_URL + ALIVE_URI,
			type: 'HEAD'
		}).done(function() {
			showForm = true;
			showError = false;
		}).fail(function() {
			showForm = false;
			showError = true;
		}).always(function() {
			$('#dead').toggle(showError);
			$('#alive').toggle(showForm);
			$('#results').hide();
		});
	};
	
	var postTest = function() {

		var postData = {};
		postData['pattern'] = $('#pattern').val();
		postData['type'] = $('#type').val();
		postData['testUri'] = $('#testUri').val();
		
		var settings = {
			url: BASE_URL + TEST_URI,
			data: JSON.stringify(postData),
			contentType: 'application/json',
			type: 'POST',
			dataType: 'json',
			processData: false
		};
		
		//$.post(BASE_URL + TEST_URI, postData).done(showResults).fail(errorResult);
		$.ajax(settings).done(showResults).fail(errorResult);
	}
	
	var errorResult = function(jqXHR, textStatus, errorThrown) {
		showResults(errorThrown, textStatus, jqXHR, true);
	}
	
	var showResults = function(data, textStatus, jqXHR, isError) {
		if (isError) {
			$('#results').html('<h3>An unexpected error occured</h3><p>' + data + '</p>');
		} else {
			
			var message = [];
			message.push('<div class="clear"></div><h3>Results</h3>');
			message.push('<p><strong>Pattern: </strong>');
			message.push('<code>');
			message.push(data.pattern);
			message.push('</code></p>');
			message.push('<p><strong>Type: </strong>');
			message.push('<code>');
			message.push(data.type);
			message.push('</code></p>');
			message.push('<p><strong>URI: </strong>');
			message.push('<code>');
			message.push(data.testUri);
			message.push('</code></p>');
			message.push('<p><strong>Does it match the pattern? </strong>');
			message.push(data.matched ? "Yes!" : "No");
			message.push('</p>');
			
			$('#results').html(message.join(''));
		}
		
		$('#results').show();
	}
	
	var validate = function() {
		return true;
	}
	
	$(function() {
		$('#firetest').click(function() {
			if (validate()) {
				$('#firetest').attr('disabled','disabled');
				postTest();
				$('#firetest').removeAttr('disabled');
			}
		});
		
		checkHealth();
	});
})();