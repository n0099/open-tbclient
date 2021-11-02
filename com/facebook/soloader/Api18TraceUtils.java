package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
@DoNotOptimize
@TargetApi(18)
/* loaded from: classes11.dex */
public class Api18TraceUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SECTION_NAME_LENGTH = 127;
    public transient /* synthetic */ FieldHolder $fh;

    public Api18TraceUtils() {
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

    public static void beginTraceSection(String str, @Nullable String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            String str4 = str + str2 + str3;
            if (str4.length() > 127 && str2 != null) {
                int length = (127 - str.length()) - str3.length();
                str4 = str + str2.substring(0, length) + str3;
            }
            Trace.beginSection(str4);
        }
    }

    public static void endSection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            Trace.endSection();
        }
    }
}
