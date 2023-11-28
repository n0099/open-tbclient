package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import com.baidu.tieba.oed;
@Keep
/* loaded from: classes2.dex */
public class PayStartInfo extends oed {
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
