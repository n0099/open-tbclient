package tv.athena.revenue.payui.model;

import android.app.Activity;
import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.util.Map;
@Keep
/* loaded from: classes9.dex */
public class ThirdPartPayParams {
    public Activity act;
    public Map<String, String> appClientExpand;
    public PayType payType;
    public String payload;

    public String toString() {
        return "ThirdPartPayParams{act=" + this.act + "appClientExpand=" + this.appClientExpand + ", verpayTypesion=" + this.payType + ", payload='" + this.payload + "'}";
    }
}
