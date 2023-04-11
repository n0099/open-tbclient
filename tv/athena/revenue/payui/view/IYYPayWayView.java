package tv.athena.revenue.payui.view;

import com.baidu.tieba.a9b;
import com.baidu.tieba.b9b;
import com.baidu.tieba.cab;
import com.baidu.tieba.y8b;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes9.dex */
public interface IYYPayWayView extends cab {

    /* loaded from: classes9.dex */
    public enum PayViewState {
        SELECTING_VIEW_STATE,
        WAITING_VIEW_STATE
    }

    /* loaded from: classes9.dex */
    public interface a {
        void a(b9b b9bVar, y8b y8bVar, AppCustomExpand appCustomExpand);

        void b(b9b b9bVar, y8b y8bVar, AppCustomExpand appCustomExpand);

        void c(a9b a9bVar);

        void onRefreshViewFail(int i, String str);

        void toHelpCenterPage();
    }

    void a();

    boolean d();

    void setCallback(a aVar);

    void setViewState(PayViewState payViewState);

    /* loaded from: classes9.dex */
    public static class b {
        public List<PayWayInfo> a;
        public String b;
        public y8b c;
        public AppCustomExpand d;
        public Map<String, String> e;
        public AbsViewEventHandler g;
        public PayFlowType h;
        public WindowParams i;
        public String k;
        public boolean f = false;
        public boolean j = false;

        public String toString() {
            return "ViewParams{payAmount=" + this.c + ", payFlowType=" + this.h + ", showFaqPage=" + this.j + ", appCustomExpand=" + this.d + ", closeOnSuccess='" + this.f + "', clientInfoExpand='" + this.e + "', windowParams='" + this.i + "', viewEventListener='" + this.g + "', bubbleActMsg='" + this.b + "', splitOrderScene='" + this.k + "'}";
        }
    }
}
