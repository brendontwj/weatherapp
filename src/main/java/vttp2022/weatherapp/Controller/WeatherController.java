package vttp2022.weatherapp.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.weatherapp.model.Weather;
import vttp2022.weatherapp.service.WeatherService;

@Controller
@RequestMapping
public class WeatherController {
    @Autowired
    private WeatherService weatherSvc;

    @GetMapping(path = "/weather")
    public String getWeather(@RequestParam(required = true) String city, Model model) {
        Optional<Weather> opt = weatherSvc.getWeather(city);
        if(opt.isEmpty()) {
            return "weather";
        }
        model.addAttribute("weather", opt.get());
        return "weather";
    }
}
