package tv.athena.revenue.payui.model;

import android.app.Activity;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o0a;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.util.Map;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
@Keep
/* loaded from: classes9.dex */
public class ThirdPartPayDialogParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity act;
    public Map<String, String> appClientExpand;
    public PayType defaultType;
    public String payWayDialogTitle;
    public double targetAmount;
    public o0a thirdPartOrderRequest;
    public AbsViewEventHandler viewEventListener;

    public ThirdPartPayDialogParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "ThirdPartPayDialogParams{act=" + this.act + "defaultType=" + this.defaultType + "appClientExpand=" + this.appClientExpand + ", payWayDialogTitle=" + this.payWayDialogTitle + ", targetAmount=" + this.targetAmount + ", thirdPartOrderRequest='" + this.thirdPartOrderRequest + "'}";
        }
        return (String) invokeV.objValue;
    }
}
