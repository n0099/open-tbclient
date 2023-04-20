package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import com.baidu.tieba.d9b;
@Keep
/* loaded from: classes9.dex */
public class PayFinishInfo extends d9b {
    public int code;
    public String message;
    public int step;

    public String toString() {
        return "PayFinishInfo {step=" + this.step + ", code=" + this.code + ", message='" + this.message + "'}";
    }
}
