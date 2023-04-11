package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import com.baidu.tieba.v8b;
@Keep
/* loaded from: classes9.dex */
public class PayFinishInfo extends v8b {
    public int code;
    public String message;
    public int step;

    public String toString() {
        return "PayFinishInfo {step=" + this.step + ", code=" + this.code + ", message='" + this.message + "'}";
    }
}
