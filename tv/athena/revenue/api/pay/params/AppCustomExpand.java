package tv.athena.revenue.api.pay.params;

import androidx.annotation.Keep;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class AppCustomExpand {
    public Map<String, String> appClientExpand;
    public Map<String, String> appServerExpand;
    public IAppServerExpand iAppServerExpand;

    public String toString() {
        return "AppCustomExpand{appClientExpand=" + this.appClientExpand + "appServerExpand=" + this.appServerExpand + ", iAppServerExpand='" + this.iAppServerExpand + "'}";
    }
}
