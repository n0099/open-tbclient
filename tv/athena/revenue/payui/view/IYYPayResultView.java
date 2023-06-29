package tv.athena.revenue.payui.view;

import com.baidu.tieba.a1c;
import com.baidu.tieba.h2c;
import com.baidu.tieba.n2c;
import com.baidu.tieba.w0c;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import java.util.List;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes2.dex */
public interface IYYPayResultView extends h2c {

    /* loaded from: classes2.dex */
    public enum Result {
        PAY_LOADING,
        PAY_SUUCESS,
        PAY_FAIL
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(w0c w0cVar);

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
        public w0c e;
        public PayFlowType f;
        public a1c g;
        public IPayCallback<CurrencyChargeMessage> h;
        public boolean i;
        public n2c.b j;
        public String k;
        public PayCallBackBean l;

        public String toString() {
            return "ViewParams{payResult=" + this.a + ", viewEventListener=" + this.b + ", windowParams=" + this.c + ", splitRecordItemList=" + this.d + ", payAmount=" + this.e + ", payWay='" + this.g + "', payCallback='" + this.h + "', isQuickPay='" + this.i + "', payWayViewParams='" + this.j + "', splitOrderScene='" + this.k + "', payFlowType='" + this.f + "', payCallBackBean='" + this.l + "'}";
        }
    }
}
