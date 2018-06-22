package com.zheng;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ApiAutomation {

	@Test(priority = 0)
	public void checkServiceStatus() throws IOException {
		OkHttpClient client = new OkHttpClient();
		
		Request request = new Request.Builder()
				.url("http://localhost:8081/index.php")
				.get()
				.build();
		
		Response response = client.newCall(request).execute();
		
		assertTrue(response.isSuccessful(), "service is not available");
	}
	
	@Test(priority = 1)
	public void checkTasksNotCategory() throws IOException {	
		
		OkHttpClient client = new OkHttpClient();
		
		Request request = new Request.Builder()
				.url("http://localhost:8081/fake-API-call.php")
				.get()
				.build();
		
		Response response = client.newCall(request).execute();
		
		assertTrue(response.isSuccessful(), "service is not available");	
		
		Gson gson = new Gson();
		
		TaskJson[] tasks = gson.fromJson(response.body().string(), TaskJson[].class);
		
		Reporter.log(">>> Total tasks: " + tasks.length, true);
		
		assertTrue(tasks.length > 0, "not tasks found");
		
		
	}
	
	public class TaskJson {
		private String id;
		private String status;
		private String taskName;
		private String category;
		private String dueDate;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getTaskName() {
			return taskName;
		}
		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getDueDate() {
			return dueDate;
		}
		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}
		
		
	}
}
