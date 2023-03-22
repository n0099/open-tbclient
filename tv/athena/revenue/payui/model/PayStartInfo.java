package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import com.baidu.tieba.eza;
@Keep
/* loaded from: classes9.dex */
public class PayStartInfo extends eza {
    public int code;
    public String message;

    public PayStartInfo(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public String toString() {
        return "PayStartInfo { code=" + this.code + ", message='" + this.message + "'}";
    }
}
