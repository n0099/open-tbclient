package tv.athena.revenue.payui.view;

import com.baidu.tieba.hza;
import com.baidu.tieba.jza;
import com.baidu.tieba.kza;
import com.baidu.tieba.l0b;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes9.dex */
public interface IYYPayWayView extends l0b {

    /* loaded from: classes9.dex */
    public enum PayViewState {
        SELECTING_VIEW_STATE,
        WAITING_VIEW_STATE
    }

    /* loaded from: classes9.dex */
    public interface a {
        void a(kza kzaVar, hza hzaVar, AppCustomExpand appCustomExpand);

        void b(kza kzaVar, hza hzaVar, AppCustomExpand appCustomExpand);

        void c(jza jzaVar);

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
        public hza c;
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
