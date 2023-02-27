package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
@Keep
/* loaded from: classes9.dex */
public class PayFlowModel {
    public AppCustomExpand appCustomExpand;
    public Map<String, String> clientInfoExpand;
    public AbsViewEventHandler viewEventListener;

    public String toString() {
        return "PayFlowModel{appCustomExpand=" + this.appCustomExpand + ", clientInfoExpand=" + this.clientInfoExpand + ", viewEventListener='" + this.viewEventListener + "'}";
    }
}
