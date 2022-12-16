package com.kwad.components.ad.reward.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.w;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static long oT = -1;
    public static int oU;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(818320651, "Lcom/kwad/components/ad/reward/e/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(818320651, "Lcom/kwad/components/ad/reward/e/a;");
        }
    }

    public static void I(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            b bVar = new b();
            if (e(System.currentTimeMillis())) {
                oU++;
            } else {
                oU = 1;
            }
            long currentTimeMillis = System.currentTimeMillis();
            oT = currentTimeMillis;
            bVar.oV = oU;
            bVar.en = currentTimeMillis;
            w.H(context, bVar.toJson().toString());
        }
    }

    public static int cp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!e(System.currentTimeMillis())) {
                oU = 0;
            }
            return oU;
        }
        return invokeV.intValue;
    }

    public static boolean e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? gw() > 0 && j > 0 && gw() / 2460601000L == j / 2460601000L : invokeJ.booleanValue;
    }

    public static long gw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            long j = oT;
            if (j == -1) {
                String zA = w.zA();
                if (TextUtils.isEmpty(zA)) {
                    return 0L;
                }
                b bVar = new b();
                try {
                    bVar.parseJson(new JSONObject(zA));
                    oT = bVar.en;
                    oU = bVar.oV;
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                }
                return oT;
            }
            return j;
        }
        return invokeV.longValue;
    }
}
