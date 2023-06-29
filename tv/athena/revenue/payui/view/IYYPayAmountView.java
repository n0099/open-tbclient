package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.annotation.Keep;
import com.baidu.tieba.a1c;
import com.baidu.tieba.f2c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.h2c;
import com.baidu.tieba.w0c;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.model.PayScene;
@Keep
/* loaded from: classes2.dex */
public interface IYYPayAmountView extends h2c, g2c {

    @Keep
    /* loaded from: classes2.dex */
    public interface Callback {
        void onRefreshViewFail(int i, String str);

        void onStartPay(a1c a1cVar, w0c w0cVar, AppCustomExpand appCustomExpand, List<PayWayInfo> list, String str);

        void onStartSignPay(a1c a1cVar, w0c w0cVar, AppCustomExpand appCustomExpand, List<PayWayInfo> list, String str);

        void showInputNumberDialog(Activity activity, List<PayWayInfo> list, String str);

        void toBannerConfigWebPage(String str);

        void toHelpCenterPage();

        void toPayWayDialog(w0c w0cVar, List<PayWayInfo> list, String str);
    }

    @Override // com.baidu.tieba.h2c
    /* synthetic */ void attachWindow(Window window);

    @Override // com.baidu.tieba.h2c
    /* synthetic */ View getContentView();

    @Override // com.baidu.tieba.h2c
    /* synthetic */ void refreshView();

    @Override // com.baidu.tieba.h2c
    /* synthetic */ void refreshWindow(WindowParams windowParams);

    void release();

    void setCallback(Callback callback);

    @Override // com.baidu.tieba.g2c
    /* synthetic */ void setViewState(PayViewState payViewState);

    @Keep
    /* loaded from: classes2.dex */
    public static class ViewParams {
        public AppCustomExpand appCustomExpand;
        public Map<String, String> clientInfoExpand;
        public String payAmountDialogTitle;
        public List<Integer> payFailedRetryCode;
        public PayFlowType payFlowType;
        public f2c payResultViewRetryApi;
        public PayScene payScene;
        public int targetAmount;
        public AbsViewEventHandler viewEventListener;
        public WindowParams windowParams;
        @Deprecated
        public boolean closeOnSuccess = false;
        public boolean showFaqPage = false;
        public String splitOrderPayScene = "0";
        public boolean showAmountViewCloseBtn = true;

        public String toString() {
            return "ViewParams{targetAmount=" + this.targetAmount + ", payScene=" + this.payScene + ", showAmountViewCloseBtn=" + this.showAmountViewCloseBtn + ", payFlowType=" + this.payFlowType + ", showFaqPage=" + this.showFaqPage + ", payAmountDialogTitle=" + this.payAmountDialogTitle + ", appCustomExpand=" + this.appCustomExpand + ", closeOnSuccess='" + this.closeOnSuccess + "', clientInfoExpand='" + this.clientInfoExpand + "', windowParams='" + this.windowParams + "', viewEventListener='" + this.viewEventListener + "', splitOrderPayScene='" + this.splitOrderPayScene + "', payFailedRetryCode='" + this.payFailedRetryCode + "', payResultViewRetryApi='" + this.payResultViewRetryApi + "'}";
        }
    }
}
