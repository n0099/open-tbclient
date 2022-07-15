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
import com.kwad.sdk.utils.as;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
@KsJson
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat c;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public int b;

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
        c = new SimpleDateFormat("yyyy-MM-dd");
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
        this.a = -1L;
        this.b = 0;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String b = as.b();
            if (TextUtils.isEmpty(b)) {
                return 0;
            }
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(b));
                if (a(aVar.a, System.currentTimeMillis())) {
                    return aVar.b;
                }
                return 0;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            String b = as.b();
            a aVar = new a();
            if (TextUtils.isEmpty(b)) {
                aVar.b = 1;
                aVar.a = System.currentTimeMillis();
                as.g(context, aVar.toJson().toString());
                return;
            }
            try {
                aVar.parseJson(new JSONObject(b));
                if (a(aVar.a, System.currentTimeMillis())) {
                    aVar.b++;
                } else {
                    aVar.b = 1;
                    aVar.a = System.currentTimeMillis();
                }
                as.g(context, aVar.toJson().toString());
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
            }
        }
    }

    public static boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j > 0 && j2 > 0) {
                try {
                    return c.format(new Date(j)).equals(c.format(new Date(j2)));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.b(e);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
