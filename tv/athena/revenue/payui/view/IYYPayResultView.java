package tv.athena.revenue.payui.view;

import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.payui.model.PaySource;
/* loaded from: classes8.dex */
public interface IYYPayResultView extends i.a.a.e.o.a {

    /* loaded from: classes8.dex */
    public enum Result {
        PAY_LOADING,
        PAY_SUUCESS,
        PAY_FAIL
    }

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Result f72916a;

        /* renamed from: b  reason: collision with root package name */
        public CurrencyChargeMessage f72917b;

        public b(Result result, CurrencyChargeMessage currencyChargeMessage) {
            this.f72916a = result;
            this.f72917b = currencyChargeMessage;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public b f72918a;

        /* renamed from: b  reason: collision with root package name */
        public AbsViewEventHandler f72919b;

        public c() {
            PaySource paySource = PaySource.UNKNOW;
        }
    }

    void setCallback(a aVar);
}
