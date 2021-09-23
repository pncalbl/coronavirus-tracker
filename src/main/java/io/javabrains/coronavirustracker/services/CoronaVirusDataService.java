package io.javabrains.coronavirustracker.services;


import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * @author pncalbl
 * @date 2021/9/23 20:03
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Service
public class CoronaVirusDataService {

	// 国内通过 HttpClient 访问 GitHub 报错 - 连接错误 / 连接超时
	// 故将数据上传至 gitee 间接获取
	// 源地址为: https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv
	private static final String VIRUS_DATA_URL = "https://gitee.com/pncalbl/diagrams/raw/main/time_series_covid19_confirmed_global.csv";


	@PostConstruct
	public void fetchVirusData() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(VIRUS_DATA_URL))
				.timeout(Duration.ofMillis(50000))
				.build();
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(httpResponse.body());
	}
}
