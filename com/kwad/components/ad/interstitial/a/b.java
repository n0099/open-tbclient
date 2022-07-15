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
public class b extends com.kwad.sdk.core.response.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat d;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public int b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(228429969, "Lcom/kwad/components/ad/interstitial/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(228429969, "Lcom/kwad/components/ad/interstitial/a/b;");
                return;
            }
        }
        d = new SimpleDateFormat("yyyy-MM-dd");
    }

    public b() {
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
        this.c = 0;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String a = as.a();
            if (TextUtils.isEmpty(a)) {
                return 0;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(a));
                return bVar.b;
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
            String a = as.a();
            b bVar = new b();
            if (TextUtils.isEmpty(a)) {
                bVar.b = 1;
                bVar.a = System.currentTimeMillis();
                as.f(context, bVar.toJson().toString());
                return;
            }
            try {
                bVar.parseJson(new JSONObject(a));
                if (a(bVar.a, System.currentTimeMillis())) {
                    bVar.b++;
                } else {
                    bVar.b = 1;
                    bVar.c = 0;
                    bVar.a = System.currentTimeMillis();
                }
                as.f(context, bVar.toJson().toString());
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
                    return d.format(new Date(j)).equals(d.format(new Date(j2)));
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.b(e);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String a = as.a();
            if (TextUtils.isEmpty(a)) {
                return 0;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(a));
                return bVar.c;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            String a = as.a();
            b bVar = new b();
            if (TextUtils.isEmpty(a)) {
                bVar.c = 1;
                bVar.a = System.currentTimeMillis();
                as.f(context, bVar.toJson().toString());
                return;
            }
            try {
                bVar.parseJson(new JSONObject(a));
                if (a(bVar.a, System.currentTimeMillis())) {
                    bVar.c++;
                } else {
                    bVar.c = 1;
                    bVar.b = 0;
                    bVar.a = System.currentTimeMillis();
                }
                as.f(context, bVar.toJson().toString());
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.b(e);
            }
        }
    }
}
