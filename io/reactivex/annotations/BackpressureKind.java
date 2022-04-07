package io.reactivex.annotations;

import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class BackpressureKind {
    public static final /* synthetic */ BackpressureKind[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BackpressureKind ERROR;
    public static final BackpressureKind FULL;
    public static final BackpressureKind NONE;
    public static final BackpressureKind PASS_THROUGH;
    public static final BackpressureKind SPECIAL;
    public static final BackpressureKind UNBOUNDED_IN;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-356783101, "Lio/reactivex/annotations/BackpressureKind;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-356783101, "Lio/reactivex/annotations/BackpressureKind;");
                return;
            }
        }
        PASS_THROUGH = new BackpressureKind("PASS_THROUGH", 0);
        FULL = new BackpressureKind(PolyActivity.FULL_PANEL_TYPE, 1);
        SPECIAL = new BackpressureKind("SPECIAL", 2);
        UNBOUNDED_IN = new BackpressureKind("UNBOUNDED_IN", 3);
        ERROR = new BackpressureKind("ERROR", 4);
        BackpressureKind backpressureKind = new BackpressureKind("NONE", 5);
        NONE = backpressureKind;
        $VALUES = new BackpressureKind[]{PASS_THROUGH, FULL, SPECIAL, UNBOUNDED_IN, ERROR, backpressureKind};
    }

    public BackpressureKind(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BackpressureKind valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BackpressureKind) Enum.valueOf(BackpressureKind.class, str) : (BackpressureKind) invokeL.objValue;
    }

    public static BackpressureKind[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BackpressureKind[]) $VALUES.clone() : (BackpressureKind[]) invokeV.objValue;
    }
}
