package com.kwad.yoga;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.proguard.annotations.DoNotStrip;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@DoNotStrip
/* loaded from: classes2.dex */
public final class YogaEdge {
    public static final /* synthetic */ YogaEdge[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final YogaEdge ALL;
    public static final YogaEdge BOTTOM;
    public static final YogaEdge END;
    public static final YogaEdge HORIZONTAL;
    public static final YogaEdge LEFT;
    public static final YogaEdge RIGHT;
    public static final YogaEdge START;
    public static final YogaEdge TOP;
    public static final YogaEdge VERTICAL;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1307588789, "Lcom/kwad/yoga/YogaEdge;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1307588789, "Lcom/kwad/yoga/YogaEdge;");
                return;
            }
        }
        LEFT = new YogaEdge("LEFT", 0, 0);
        TOP = new YogaEdge("TOP", 1, 1);
        RIGHT = new YogaEdge("RIGHT", 2, 2);
        BOTTOM = new YogaEdge("BOTTOM", 3, 3);
        START = new YogaEdge("START", 4, 4);
        END = new YogaEdge("END", 5, 5);
        HORIZONTAL = new YogaEdge("HORIZONTAL", 6, 6);
        VERTICAL = new YogaEdge("VERTICAL", 7, 7);
        YogaEdge yogaEdge = new YogaEdge("ALL", 8, 8);
        ALL = yogaEdge;
        $VALUES = new YogaEdge[]{LEFT, TOP, RIGHT, BOTTOM, START, END, HORIZONTAL, VERTICAL, yogaEdge};
    }

    public YogaEdge(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIntValue = i3;
    }

    public static YogaEdge fromInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            switch (i2) {
                case 0:
                    return LEFT;
                case 1:
                    return TOP;
                case 2:
                    return RIGHT;
                case 3:
                    return BOTTOM;
                case 4:
                    return START;
                case 5:
                    return END;
                case 6:
                    return HORIZONTAL;
                case 7:
                    return VERTICAL;
                case 8:
                    return ALL;
                default:
                    throw new IllegalArgumentException("Unknown enum value: " + i2);
            }
        }
        return (YogaEdge) invokeI.objValue;
    }

    public static YogaEdge valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (YogaEdge) Enum.valueOf(YogaEdge.class, str) : (YogaEdge) invokeL.objValue;
    }

    public static YogaEdge[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (YogaEdge[]) $VALUES.clone() : (YogaEdge[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
    }
}
