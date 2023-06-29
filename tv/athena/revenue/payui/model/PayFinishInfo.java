package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import com.baidu.tieba.t0c;
@Keep
/* loaded from: classes2.dex */
public class PayFinishInfo extends t0c {
    public int code;
    public String message;
    public int step;

    public String toString() {
        return "PayFinishInfo {step=" + this.step + ", code=" + this.code + ", message='" + this.message + "'}";
    }
}
