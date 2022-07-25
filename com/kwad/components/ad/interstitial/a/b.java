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
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat em;
    public transient /* synthetic */ FieldHolder $fh;
    public long en;
    public int fT;
    public int fU;

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
        em = new SimpleDateFormat("yyyy-MM-dd");
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
        this.en = -1L;
        this.fT = 0;
        this.fU = 0;
    }

    public static void I(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            String zy = w.zy();
            b bVar = new b();
            if (TextUtils.isEmpty(zy)) {
                bVar.fT = 1;
                bVar.en = System.currentTimeMillis();
                w.F(context, bVar.toJson().toString());
                return;
            }
            try {
                bVar.parseJson(new JSONObject(zy));
                if (a(bVar.en, System.currentTimeMillis())) {
                    bVar.fT++;
                } else {
                    bVar.fT = 1;
                    bVar.fU = 0;
                    bVar.en = System.currentTimeMillis();
                }
                w.F(context, bVar.toJson().toString());
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
    }

    public static void J(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            String zy = w.zy();
            b bVar = new b();
            if (TextUtils.isEmpty(zy)) {
                bVar.fU = 1;
                bVar.en = System.currentTimeMillis();
                w.F(context, bVar.toJson().toString());
                return;
            }
            try {
                bVar.parseJson(new JSONObject(zy));
                if (a(bVar.en, System.currentTimeMillis())) {
                    bVar.fU++;
                } else {
                    bVar.fU = 1;
                    bVar.fT = 0;
                    bVar.en = System.currentTimeMillis();
                }
                w.F(context, bVar.toJson().toString());
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
    }

    public static boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String zy = w.zy();
            if (TextUtils.isEmpty(zy)) {
                return 0;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(zy));
                return bVar.fT;
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static int cq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String zy = w.zy();
            if (TextUtils.isEmpty(zy)) {
                return 0;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(zy));
                return bVar.fU;
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                return 0;
            }
        }
        return invokeV.intValue;
    }
}
