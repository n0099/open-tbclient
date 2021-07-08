package com.google.android.material.slider;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes6.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.google.android.material.slider.LabelFormatter
    @NonNull
    public String getFormattedValue(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? f2 >= 1.0E12f ? String.format(Locale.US, "%.1fT", Float.valueOf(f2 / 1.0E12f)) : f2 >= 1.0E9f ? String.format(Locale.US, "%.1fB", Float.valueOf(f2 / 1.0E9f)) : f2 >= 1000000.0f ? String.format(Locale.US, "%.1fM", Float.valueOf(f2 / 1000000.0f)) : f2 >= 1000.0f ? String.format(Locale.US, "%.1fK", Float.valueOf(f2 / 1000.0f)) : String.format(Locale.US, "%.0f", Float.valueOf(f2)) : (String) invokeF.objValue;
    }
}
