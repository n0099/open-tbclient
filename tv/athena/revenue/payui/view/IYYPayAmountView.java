package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import j.a.a.e.l.c;
import j.a.a.e.o.a;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayScene;
@Keep
/* loaded from: classes4.dex */
public interface IYYPayAmountView extends a {

    @Keep
    /* loaded from: classes4.dex */
    public interface Callback {
        Dialog getPayAmountDialog();

        void onRefreshViewFail(int i2, String str);

        void showInputNumberDialog(Activity activity, List<PayWayInfo> list);

        void toPayWayDialog(c cVar, List<PayWayInfo> list);
    }

    @Keep
    /* loaded from: classes4.dex */
    public static class ViewParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AppCustomExpand appCustomExpand;
        public boolean closeOnSuccess;
        public String payAmountDialogTitle;
        public PayScene payScene;
        public int targetAmount;
        public AbsViewEventHandler viewEventListener;

        public ViewParams() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.closeOnSuccess = false;
        }
    }

    @Override // j.a.a.e.o.a
    /* synthetic */ View getContentView();

    @Override // j.a.a.e.o.a
    /* synthetic */ void refreshView();

    void setCallback(Callback callback);
}
