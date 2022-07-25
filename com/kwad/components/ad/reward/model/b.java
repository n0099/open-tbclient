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
    public long pg;
    public int ph;

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
        this.pg = -1L;
        this.ph = 0;
    }

    public static void P(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            String zC = w.zC();
            b bVar = new b();
            if (TextUtils.isEmpty(zC)) {
                bVar.ph = 1;
                bVar.pg = System.currentTimeMillis();
                w.J(context, bVar.toJson().toString());
                return;
            }
            try {
                bVar.parseJson(new JSONObject(zC));
                if (a(bVar.pg, System.currentTimeMillis())) {
                    bVar.ph++;
                } else {
                    bVar.ph = 1;
                    bVar.pg = System.currentTimeMillis();
                }
                w.J(context, bVar.toJson().toString());
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
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
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static int gK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String zC = w.zC();
            if (TextUtils.isEmpty(zC)) {
                return 0;
            }
            b bVar = new b();
            try {
                bVar.parseJson(new JSONObject(zC));
                if (a(bVar.pg, System.currentTimeMillis())) {
                    return bVar.ph;
                }
                return 0;
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
                return 0;
            }
        }
        return invokeV.intValue;
    }
}
