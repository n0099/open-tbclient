package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
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
public class c extends com.kwad.sdk.core.response.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat em;
    public transient /* synthetic */ FieldHolder $fh;
    public long en;
    public int eo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1461866017, "Lcom/kwad/components/ad/splashscreen/local/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1461866017, "Lcom/kwad/components/ad/splashscreen/local/c;");
                return;
            }
        }
        em = new SimpleDateFormat("yyyy-MM-dd");
    }

    public c() {
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
        this.en = 0L;
        this.eo = 0;
    }

    public static void V(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            String zB = w.zB();
            c cVar = new c();
            if (TextUtils.isEmpty(zB)) {
                cVar.eo = 1;
                cVar.en = System.currentTimeMillis();
                w.I(context, cVar.toJson().toString());
                return;
            }
            try {
                cVar.parseJson(new JSONObject(zB));
                if (a(cVar.en, System.currentTimeMillis())) {
                    cVar.eo++;
                } else {
                    cVar.eo = 1;
                }
                cVar.en = System.currentTimeMillis();
                w.I(context, cVar.toJson().toString());
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
}
