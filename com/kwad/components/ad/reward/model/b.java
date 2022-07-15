package com.kwad.components.ad.reward.model;

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
    public static SimpleDateFormat c;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(306677862, "Lcom/kwad/components/ad/reward/model/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(306677862, "Lcom/kwad/components/ad/reward/model/b;");
                return;
            }
        }
        c = new SimpleDateFormat("yyyy-MM-dd");
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
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String d = as.d();
            if (TextUtils.isEmpty(d)) {
                return 0;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(d));
                if (a(bVar.a, System.currentTimeMillis())) {
                    return bVar.b;
                }
                return 0;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            String d = as.d();
            b bVar = new b();
            if (TextUtils.isEmpty(d)) {
                bVar.b = 1;
                bVar.a = System.currentTimeMillis();
                as.i(context, bVar.toJson().toString());
                return;
            }
            try {
                bVar.parseJson(new JSONObject(d));
                if (a(bVar.a, System.currentTimeMillis())) {
                    bVar.b++;
                } else {
                    bVar.b = 1;
                    bVar.a = System.currentTimeMillis();
                }
                as.i(context, bVar.toJson().toString());
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
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
                    com.kwad.sdk.core.d.b.a(e);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
