package LoginSystem.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import LoginSystem.domain.model.GroupOrder;
import LoginSystem.domain.model.SignupForm;

@Controller
public class SignupController {

    //ラジオボタン用変数
    private Map<String, String> radioMarriage;

    /**
     * ラジオボタンの初期化メソッド.
     */
    private Map<String, String> initRadioMarrige() {

        Map<String, String> radio = new LinkedHashMap<>();

        // 既婚、未婚をMapに格納
        radio.put("既婚", "true");
        radio.put("未婚", "false");

        return radio;
    }

    /**
     * ユーザー登録画面のGETメソッド用処理.
     */
    @GetMapping("/signup")
    public String getSignUp(Model model, @ModelAttribute SignupForm form) {

        // ラジオボタンの初期化メソッド呼び出し
        radioMarriage = initRadioMarrige();

        // ラジオボタン用のMapをModelに登録
        model.addAttribute("radioMarriage", radioMarriage);

        // signup.htmlに画面遷移
        return "signup";
    }

    /**
     * ユーザー登録画面のPOSTメソッド用処理.
     */
    @PostMapping("/signup")
    public String postSignUp(Model model, @Validated(GroupOrder.class) @ModelAttribute SignupForm form, BindingResult result) {
    	
    	if (result.hasErrors()) {
    		return getSignUp(model,form);
    	}
    	
        // login.htmlにリダイレクト
        return "redirect:login";
    }
}