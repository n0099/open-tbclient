package tv.athena.revenue.payui.view;

import com.baidu.tieba.a9c;
import com.baidu.tieba.hac;
import com.baidu.tieba.nac;
import com.baidu.tieba.w8c;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import java.util.List;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes2.dex */
public interface IYYPayResultView extends hac {

    /* loaded from: classes2.dex */
    public enum Result {
        PAY_LOADING,
        PAY_SUUCESS,
        PAY_FAIL
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(w8c w8cVar);

        void b();

        boolean c();
    }

    void a();

    void setCallback(a aVar);

    /* loaded from: classes2.dex */
    public static class b {
        public Result a;
        public CurrencyChargeMessage b;
        public int c;
        public String d;

        public b(Result result, CurrencyChargeMessage currencyChargeMessage) {
            this.a = result;
            this.b = currencyChargeMessage;
        }

        public void a(int i) {
            this.c = i;
        }

        public void b(String str) {
            this.d = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public b a;
        public AbsViewEventHandler b;
        public WindowParams c;
        public List<SplitRecordItem> d;
        public w8c e;
        public PayFlowType f;
        public a9c g;
        public IPayCallback<CurrencyChargeMessage> h;
        public boolean i;
        public nac.b j;
        public String k;
        public PayCallBackBean l;

        public String toString() {
            return "ViewParams{payResult=" + this.a + ", viewEventListener=" + this.b + ", windowParams=" + this.c + ", splitRecordItemList=" + this.d + ", payAmount=" + this.e + ", payWay='" + this.g + "', payCallback='" + this.h + "', isQuickPay='" + this.i + "', payWayViewParams='" + this.j + "', splitOrderScene='" + this.k + "', payFlowType='" + this.f + "', payCallBackBean='" + this.l + "'}";
        }
    }
}
