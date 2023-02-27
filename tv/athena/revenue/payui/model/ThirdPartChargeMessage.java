package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.util.Map;
@Keep
/* loaded from: classes9.dex */
public class ThirdPartChargeMessage {
    public Map<String, String> appClientExpand;
    public int code;
    public String msg;
    public PayType payType;

    public String toString() {
        return "ThirdPartChargeMessage{code=" + this.code + "payType=" + this.payType + "appClientExpand=" + this.appClientExpand + ", msg='" + this.msg + "'}";
    }
}
