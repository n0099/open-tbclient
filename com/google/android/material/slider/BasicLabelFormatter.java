package com.google.android.material.slider;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes7.dex */
public final class BasicLabelFormatter implements LabelFormatter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BILLION = 1000000000;
    public static final int MILLION = 1000000;
    public static final int THOUSAND = 1000;
    public static final long TRILLION = 1000000000000L;
    public transient /* synthetic */ FieldHolder $fh;

    public BasicLabelFormatter() {
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

    @Override // com.google.android.material.slider.LabelFormatter
    public String getFormattedValue(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            if (f >= 1.0E12f) {
                return String.format(Locale.US, "%.1fT", Float.valueOf(f / 1.0E12f));
            }
            if (f >= 1.0E9f) {
                return String.format(Locale.US, "%.1fB", Float.valueOf(f / 1.0E9f));
            }
            if (f >= 1000000.0f) {
                return String.format(Locale.US, "%.1fM", Float.valueOf(f / 1000000.0f));
            }
            if (f >= 1000.0f) {
                return String.format(Locale.US, "%.1fK", Float.valueOf(f / 1000.0f));
            }
            return String.format(Locale.US, "%.0f", Float.valueOf(f));
        }
        return (String) invokeF.objValue;
    }
}
