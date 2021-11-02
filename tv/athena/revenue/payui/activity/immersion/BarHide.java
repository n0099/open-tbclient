package tv.athena.revenue.payui.activity.immersion;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class BarHide {
    public static final /* synthetic */ BarHide[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BarHide FLAG_HIDE_BAR;
    public static final BarHide FLAG_HIDE_NAVIGATION_BAR;
    public static final BarHide FLAG_HIDE_SMART_BAR_ONLY;
    public static final BarHide FLAG_HIDE_STATUS_BAR;
    public static final BarHide FLAG_SHOW_BAR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(483567961, "Ltv/athena/revenue/payui/activity/immersion/BarHide;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(483567961, "Ltv/athena/revenue/payui/activity/immersion/BarHide;");
                return;
            }
        }
        FLAG_HIDE_STATUS_BAR = new BarHide("FLAG_HIDE_STATUS_BAR", 0);
        FLAG_HIDE_NAVIGATION_BAR = new BarHide("FLAG_HIDE_NAVIGATION_BAR", 1);
        FLAG_HIDE_BAR = new BarHide("FLAG_HIDE_BAR", 2);
        FLAG_SHOW_BAR = new BarHide("FLAG_SHOW_BAR", 3);
        BarHide barHide = new BarHide("FLAG_HIDE_SMART_BAR_ONLY", 4);
        FLAG_HIDE_SMART_BAR_ONLY = barHide;
        $VALUES = new BarHide[]{FLAG_HIDE_STATUS_BAR, FLAG_HIDE_NAVIGATION_BAR, FLAG_HIDE_BAR, FLAG_SHOW_BAR, barHide};
    }

    public BarHide(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
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

    public static BarHide valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BarHide) Enum.valueOf(BarHide.class, str) : (BarHide) invokeL.objValue;
    }

    public static BarHide[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BarHide[]) $VALUES.clone() : (BarHide[]) invokeV.objValue;
    }
}
