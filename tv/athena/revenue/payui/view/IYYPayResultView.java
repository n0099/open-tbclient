package tv.athena.revenue.payui.view;

import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes7.dex */
public interface IYYPayResultView extends i.a.a.e.m.a {

    /* loaded from: classes7.dex */
    public enum Result {
        PAY_LOADING,
        PAY_SUUCESS,
        PAY_FAIL
    }

    /* loaded from: classes7.dex */
    public interface a {
        void onClose();
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Result f68878a;

        /* renamed from: b  reason: collision with root package name */
        public CurrencyChargeMessage f68879b;

        public b(Result result, CurrencyChargeMessage currencyChargeMessage) {
            this.f68878a = result;
            this.f68879b = currencyChargeMessage;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public b f68880a;
    }

    void setCallback(a aVar);
}
