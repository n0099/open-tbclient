package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.baidu.tieba.e5a;
import com.baidu.tieba.f6a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayScene;
/* loaded from: classes9.dex */
public interface IYYPayAmountView extends f6a {

    /* loaded from: classes9.dex */
    public interface Callback {
        void onRefreshViewFail(int i, String str);

        void showInputNumberDialog(Activity activity, List list, String str);

        void toHelpCenterPage();

        void toPayWayDialog(e5a e5aVar, List list, String str);
    }

    @Override // com.baidu.tieba.f6a
    /* synthetic */ void attachWindow(Window window);

    @Override // com.baidu.tieba.f6a
    /* synthetic */ View getContentView();

    @Override // com.baidu.tieba.f6a
    /* synthetic */ void refreshView();

    @Override // com.baidu.tieba.f6a
    /* synthetic */ void refreshWindow(WindowParams windowParams);

    void setCallback(Callback callback);

    /* loaded from: classes9.dex */
    public class ViewParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AppCustomExpand appCustomExpand;
        public Map clientInfoExpand;
        public boolean closeOnSuccess;
        public String payAmountDialogTitle;
        public PayScene payScene;
        public boolean showFaqPage;
        public int targetAmount;
        public AbsViewEventHandler viewEventListener;
        public WindowParams windowParams;

        public ViewParams() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.closeOnSuccess = false;
            this.showFaqPage = false;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "ViewParams{targetAmount=" + this.targetAmount + ", payScene=" + this.payScene + ", showFaqPage=" + this.showFaqPage + ", payAmountDialogTitle=" + this.payAmountDialogTitle + ", appCustomExpand=" + this.appCustomExpand + ", closeOnSuccess='" + this.closeOnSuccess + "', clientInfoExpand='" + this.clientInfoExpand + "', windowParams='" + this.windowParams + "'}";
            }
            return (String) invokeV.objValue;
        }
    }
}
