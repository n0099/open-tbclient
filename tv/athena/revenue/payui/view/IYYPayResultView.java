package tv.athena.revenue.payui.view;

import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes8.dex */
public interface IYYPayResultView extends i.a.a.e.m.a {

    /* loaded from: classes8.dex */
    public enum Result {
        PAY_LOADING,
        PAY_SUUCESS,
        PAY_FAIL
    }

    /* loaded from: classes8.dex */
    public interface a {
        void onClose();
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Result f69603a;

        /* renamed from: b  reason: collision with root package name */
        public CurrencyChargeMessage f69604b;

        public b(Result result, CurrencyChargeMessage currencyChargeMessage) {
            this.f69603a = result;
            this.f69604b = currencyChargeMessage;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public b f69605a;
    }

    void setCallback(a aVar);
}
