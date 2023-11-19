package LoginSystem.domain.model;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SignupForm {
	
	//必須入力、メールアドレス形式
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    @Email(groups = ValidGroup2.class, message = "{email_check}")
    private String userId; // ユーザーID

    //必須入力、長さ4から100桁まで、半角英数字のみ
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    @Length(groups = ValidGroup2.class, message = "{length_check}")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup3.class, message = "{pattern_check}")
    private String password; // パスワード

    //必須入力
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    private String userName; // ユーザー名

    //必須入力
    @NotNull(groups = ValidGroup1.class, message = "{require_check}")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday; // 誕生日

    //値が20から100まで
    @Min(value = 20, groups = ValidGroup2.class, message = "{min_check}")
    @Max(value = 100, groups = ValidGroup2.class, message = "{max_check}")
    private int age; // 年齢

    //falseのみ可能
    @AssertFalse(groups = ValidGroup2.class, message = "{false_check}")
    private boolean marriage; // 結婚ステータス
}
