package tv.athena.revenue.payui.view;

import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import i.a.a.e.l.c;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PaySource;
/* loaded from: classes8.dex */
public interface IYYPayWayView extends i.a.a.e.o.a {

    /* loaded from: classes8.dex */
    public enum PayViewState {
        SELECTING_VIEW_STATE,
        WAITING_VIEW_STATE
    }

    /* loaded from: classes8.dex */
    public interface a {
        void a(c cVar, i.a.a.e.l.a aVar, AppCustomExpand appCustomExpand);

        void onRefreshViewFail(int i2, String str);
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<PayWayInfo> f72920a;

        /* renamed from: b  reason: collision with root package name */
        public i.a.a.e.l.a f72921b;

        /* renamed from: c  reason: collision with root package name */
        public AppCustomExpand f72922c;

        /* renamed from: e  reason: collision with root package name */
        public AbsViewEventHandler f72924e;

        /* renamed from: d  reason: collision with root package name */
        public boolean f72923d = false;

        /* renamed from: f  reason: collision with root package name */
        public PaySource f72925f = PaySource.UNKNOW;
    }

    void setCallback(a aVar);

    void setViewState(PayViewState payViewState);
}
