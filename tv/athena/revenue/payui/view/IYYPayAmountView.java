package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.annotation.Keep;
import com.baidu.tieba.hza;
import com.baidu.tieba.l0b;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayScene;
@Keep
/* loaded from: classes9.dex */
public interface IYYPayAmountView extends l0b {

    @Keep
    /* loaded from: classes9.dex */
    public interface Callback {
        void onRefreshViewFail(int i, String str);

        void showInputNumberDialog(Activity activity, List<PayWayInfo> list, String str);

        void toBannerConfigWebPage(String str);

        void toHelpCenterPage();

        void toPayWayDialog(hza hzaVar, List<PayWayInfo> list, String str);
    }

    @Override // com.baidu.tieba.l0b
    /* synthetic */ void attachWindow(Window window);

    @Override // com.baidu.tieba.l0b
    /* synthetic */ View getContentView();

    @Override // com.baidu.tieba.l0b
    /* synthetic */ void refreshView();

    @Override // com.baidu.tieba.l0b
    /* synthetic */ void refreshWindow(WindowParams windowParams);

    void setCallback(Callback callback);

    @Keep
    /* loaded from: classes9.dex */
    public static class ViewParams {
        public AppCustomExpand appCustomExpand;
        public Map<String, String> clientInfoExpand;
        public String payAmountDialogTitle;
        public PayScene payScene;
        public int targetAmount;
        public AbsViewEventHandler viewEventListener;
        public WindowParams windowParams;
        public boolean closeOnSuccess = false;
        public boolean showFaqPage = false;
        public String splitOrderPayScene = "0";

        public String toString() {
            return "ViewParams{targetAmount=" + this.targetAmount + ", payScene=" + this.payScene + ", showFaqPage=" + this.showFaqPage + ", payAmountDialogTitle=" + this.payAmountDialogTitle + ", appCustomExpand=" + this.appCustomExpand + ", closeOnSuccess='" + this.closeOnSuccess + "', clientInfoExpand='" + this.clientInfoExpand + "', windowParams='" + this.windowParams + "', viewEventListener='" + this.viewEventListener + "', splitOrderPayScene='" + this.splitOrderPayScene + "'}";
        }
    }
}
