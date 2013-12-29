package uk.co.keithsjohnson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.keithsjohnson.entity.Build;

@Controller
public class BuildController {

	@RequestMapping("/build")
	public @ResponseBody
	Build build(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		return new Build(name);
	}
}