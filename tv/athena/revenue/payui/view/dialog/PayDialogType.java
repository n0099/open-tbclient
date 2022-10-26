package tv.athena.revenue.payui.view.dialog;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class PayDialogType {
    public static final /* synthetic */ PayDialogType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PayDialogType PAY_AMOUNT_DIALOG;
    public static final PayDialogType PAY_CONFIRM_FINISH_DIALOG;
    public static final PayDialogType PAY_INPUT_DIALOG;
    public static final PayDialogType PAY_NONE_DIALOG;
    public static final PayDialogType PAY_RESULT_DIALOG;
    public static final PayDialogType PAY_SHOW_GIFT_DIALOG;
    public static final PayDialogType PAY_WAY_DIALOG;
    public static final PayDialogType THIRD_PART_PAY_WAY_DIALOG;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-363254689, "Ltv/athena/revenue/payui/view/dialog/PayDialogType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-363254689, "Ltv/athena/revenue/payui/view/dialog/PayDialogType;");
                return;
            }
        }
        PAY_AMOUNT_DIALOG = new PayDialogType("PAY_AMOUNT_DIALOG", 0, 1);
        PAY_INPUT_DIALOG = new PayDialogType("PAY_INPUT_DIALOG", 1, 2);
        PAY_WAY_DIALOG = new PayDialogType("PAY_WAY_DIALOG", 2, 3);
        PAY_RESULT_DIALOG = new PayDialogType("PAY_RESULT_DIALOG", 3, 4);
        PAY_CONFIRM_FINISH_DIALOG = new PayDialogType("PAY_CONFIRM_FINISH_DIALOG", 4, 5);
        PAY_SHOW_GIFT_DIALOG = new PayDialogType("PAY_SHOW_GIFT_DIALOG", 5, 6);
        PAY_NONE_DIALOG = new PayDialogType("PAY_NONE_DIALOG", 6, 7);
        PayDialogType payDialogType = new PayDialogType("THIRD_PART_PAY_WAY_DIALOG", 7, 8);
        THIRD_PART_PAY_WAY_DIALOG = payDialogType;
        $VALUES = new PayDialogType[]{PAY_AMOUNT_DIALOG, PAY_INPUT_DIALOG, PAY_WAY_DIALOG, PAY_RESULT_DIALOG, PAY_CONFIRM_FINISH_DIALOG, PAY_SHOW_GIFT_DIALOG, PAY_NONE_DIALOG, payDialogType};
    }

    public PayDialogType(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PayDialogType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PayDialogType) Enum.valueOf(PayDialogType.class, str);
        }
        return (PayDialogType) invokeL.objValue;
    }

    public static PayDialogType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PayDialogType[]) $VALUES.clone();
        }
        return (PayDialogType[]) invokeV.objValue;
    }
}
