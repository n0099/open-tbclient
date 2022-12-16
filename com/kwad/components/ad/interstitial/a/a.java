package com.kwad.components.ad.interstitial.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
@KsJson
/* loaded from: classes8.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat em;
    public transient /* synthetic */ FieldHolder $fh;
    public long en;
    public int fS;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(228429938, "Lcom/kwad/components/ad/interstitial/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(228429938, "Lcom/kwad/components/ad/interstitial/a/a;");
                return;
            }
        }
        em = new SimpleDateFormat("yyyy-MM-dd");
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.en = -1L;
        this.fS = 0;
    }

    public static void I(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            String zz = w.zz();
            a aVar = new a();
            if (TextUtils.isEmpty(zz)) {
                aVar.fS = 1;
                aVar.en = System.currentTimeMillis();
                w.G(context, aVar.toJson().toString());
                return;
            }
            try {
                aVar.parseJson(new JSONObject(zz));
                if (a(aVar.en, System.currentTimeMillis())) {
                    aVar.fS++;
                } else {
                    aVar.fS = 1;
                    aVar.en = System.currentTimeMillis();
                }
                w.G(context, aVar.toJson().toString());
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
    }

    public static boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j > 0 && j2 > 0) {
                try {
                    return em.format(new Date(j)).equals(em.format(new Date(j2)));
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static int cp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String zz = w.zz();
            if (TextUtils.isEmpty(zz)) {
                return 0;
            }
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(zz));
                if (a(aVar.en, System.currentTimeMillis())) {
                    return aVar.fS;
                }
                return 0;
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                return 0;
            }
        }
        return invokeV.intValue;
    }
}
