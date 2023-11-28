package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import com.baidu.tieba.agd;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
@Keep
/* loaded from: classes2.dex */
public class PayFlowModel {
    public AppCustomExpand appCustomExpand;
    public Map<String, String> clientInfoExpand;
    public List<Integer> payFailedRetryCode;
    public agd payResultViewRetryApi;
    public AbsViewEventHandler viewEventListener;

    public String toString() {
        return "PayFlowModel{, payResultViewRetryApi=" + this.payResultViewRetryApi + ", payFailedRetryCode=" + this.payFailedRetryCode + "appCustomExpand=" + this.appCustomExpand + ", clientInfoExpand=" + this.clientInfoExpand + ", viewEventListener='" + this.viewEventListener + "'}";
    }
}
