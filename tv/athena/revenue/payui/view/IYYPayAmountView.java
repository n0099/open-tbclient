package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.view.View;
import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import i.a.a.e.o.a;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
@Keep
/* loaded from: classes8.dex */
public interface IYYPayAmountView extends a {

    @Keep
    /* loaded from: classes8.dex */
    public interface Callback {
        void onRefreshViewFail(int i2, String str);

        void showInputNumberDialog(Activity activity, List<PayWayInfo> list);

        void toPayWayDialog(i.a.a.e.l.a aVar, List<PayWayInfo> list);
    }

    @Keep
    /* loaded from: classes8.dex */
    public static class ViewParams {
        public AppCustomExpand appCustomExpand;
        public boolean closeOnSuccess = false;
        public String payAmountDialogTitle;
        public int targetAmount;
        public AbsViewEventHandler viewEventListener;
    }

    @Override // i.a.a.e.o.a
    /* synthetic */ View getContentView();

    @Override // i.a.a.e.o.a
    /* synthetic */ void refreshView();

    void setCallback(Callback callback);
}
