package tv.athena.revenue.payui.view.dialog;

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
public final class CancelType {
    public static final /* synthetic */ CancelType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CancelType BUTTOM_AREA_CLICK;
    public static final CancelType EMPTY_AREA_CLICK;
    public static final CancelType ON_DIALOG_CANCEL;
    public static final CancelType ON_DIALOG_DISMISS;
    public static final CancelType ON_START_SHOW_FAIL;
    public static final CancelType ON_THIRD_PART_TO_YYPAT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-535866791, "Ltv/athena/revenue/payui/view/dialog/CancelType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-535866791, "Ltv/athena/revenue/payui/view/dialog/CancelType;");
                return;
            }
        }
        ON_START_SHOW_FAIL = new CancelType("ON_START_SHOW_FAIL", 0, 0);
        BUTTOM_AREA_CLICK = new CancelType("BUTTOM_AREA_CLICK", 1, 1);
        EMPTY_AREA_CLICK = new CancelType("EMPTY_AREA_CLICK", 2, 2);
        ON_DIALOG_DISMISS = new CancelType("ON_DIALOG_DISMISS", 3, 3);
        ON_DIALOG_CANCEL = new CancelType("ON_DIALOG_CANCEL", 4, 4);
        CancelType cancelType = new CancelType("ON_THIRD_PART_TO_YYPAT", 5, 5);
        ON_THIRD_PART_TO_YYPAT = cancelType;
        $VALUES = new CancelType[]{ON_START_SHOW_FAIL, BUTTOM_AREA_CLICK, EMPTY_AREA_CLICK, ON_DIALOG_DISMISS, ON_DIALOG_CANCEL, cancelType};
    }

    public CancelType(String str, int i, int i2) {
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

    public static CancelType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (CancelType) Enum.valueOf(CancelType.class, str);
        }
        return (CancelType) invokeL.objValue;
    }

    public static CancelType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (CancelType[]) $VALUES.clone();
        }
        return (CancelType[]) invokeV.objValue;
    }
}
