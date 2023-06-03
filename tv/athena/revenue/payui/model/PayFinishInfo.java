package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import com.baidu.tieba.bub;
@Keep
/* loaded from: classes2.dex */
public class PayFinishInfo extends bub {
    public int code;
    public String message;
    public int step;

    public String toString() {
        return "PayFinishInfo {step=" + this.step + ", code=" + this.code + ", message='" + this.message + "'}";
    }
}
