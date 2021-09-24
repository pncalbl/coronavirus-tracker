package io.javabrains.coronavirustracker.controllers;

import io.javabrains.coronavirustracker.models.LocationStats;
import io.javabrains.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pncalbl
 * @date 2021/9/24 16:52
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Controller
public class HomeController {

	@Resource
	CoronaVirusDataService service;

	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = service.getAllStats();
		int totalCases = allStats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
		int newCases = allStats.stream().mapToInt(LocationStats::getDiffFromPrevDay).sum();
		model.addAttribute("locationSats", allStats);
		model.addAttribute("totalReportedCases", totalCases);
		model.addAttribute("totalNewCases", newCases);
		return "home";
	}
}
