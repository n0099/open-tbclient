package tv.athena.revenue.payui.view;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Keep
/* loaded from: classes9.dex */
public final class PaySplitOrderViewSource {
    public static final /* synthetic */ PaySplitOrderViewSource[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PaySplitOrderViewSource SOURCE_FROM_INPUAT_DIALOG;
    public static final PaySplitOrderViewSource SOURCE_FROM_PAY_WAY_DIALOG;
    public transient /* synthetic */ FieldHolder $fh;
    public final String source;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-365399912, "Ltv/athena/revenue/payui/view/PaySplitOrderViewSource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-365399912, "Ltv/athena/revenue/payui/view/PaySplitOrderViewSource;");
                return;
            }
        }
        SOURCE_FROM_INPUAT_DIALOG = new PaySplitOrderViewSource("SOURCE_FROM_INPUAT_DIALOG", 0, "支付输入弹框");
        PaySplitOrderViewSource paySplitOrderViewSource = new PaySplitOrderViewSource("SOURCE_FROM_PAY_WAY_DIALOG", 1, "支付渠道弹窗");
        SOURCE_FROM_PAY_WAY_DIALOG = paySplitOrderViewSource;
        $VALUES = new PaySplitOrderViewSource[]{SOURCE_FROM_INPUAT_DIALOG, paySplitOrderViewSource};
    }

    public PaySplitOrderViewSource(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.source = str2;
    }

    public static PaySplitOrderViewSource valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PaySplitOrderViewSource) Enum.valueOf(PaySplitOrderViewSource.class, str);
        }
        return (PaySplitOrderViewSource) invokeL.objValue;
    }

    public static PaySplitOrderViewSource[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PaySplitOrderViewSource[]) $VALUES.clone();
        }
        return (PaySplitOrderViewSource[]) invokeV.objValue;
    }
}
