package com.repackage;

import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e21 a;
    public boolean b;
    public int c;
    public final JSONObject d;

    public b21() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = -1;
        this.d = new JSONObject();
        e21 e21Var = new e21();
        this.a = e21Var;
        e21Var.a = System.currentTimeMillis();
    }

    public String a(String str, long j, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.KEYS.AD_INFO, str);
                jSONObject.put("isbrowser", String.valueOf(j));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aderrorcode", String.valueOf(j2));
                jSONObject2.put("multipleaccess", String.valueOf(z));
                jSONObject2.put(PrefetchEvent.MODULE, "0");
                jSONObject.put("adext", jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public void b(String str, String str2, String str3, String str4, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) || this.a == null) {
            return;
        }
        if (str3 == null) {
            str3 = "";
        }
        yx0 f = new yx0().f("1006");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ext", str2);
            f.a("f1", jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timing", str);
            f.a("f2", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        long currentTimeMillis = System.currentTimeMillis();
        e21 e21Var = this.a;
        f.a("f3", str4);
        f.a("f4", String.valueOf(j));
        f.a("f6", String.valueOf(this.c));
        f.a("f7", LaunchStatsUtils.AD);
        f.a("f14", "");
        f.a("f15", String.valueOf(this.a.a));
        f.a("f16", String.format(Locale.CHINA, "%.3f", Float.valueOf((((float) ((currentTimeMillis - e21Var.d) + e21Var.e)) * 1.0f) / 1000.0f)));
        f.a("f17", str3);
        f.a("f18", String.valueOf(this.a.b));
        f.a("f19", String.valueOf(this.a.c));
        f.a("f20", String.valueOf(this.a.d));
        f.a("f21", String.valueOf(this.a.f));
        f.b("f23", this.d);
        rx0.c(f);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            e21 e21Var = this.a;
            e21Var.a = 0L;
            e21Var.e = 0L;
            e21Var.f = 0L;
            e21Var.d = 0L;
            e21Var.c = 0L;
            e21Var.b = 0L;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.d = System.currentTimeMillis();
            e21 e21Var = this.a;
            long j = e21Var.d - e21Var.c;
            if (j < 0) {
                j = 0;
            }
            this.a.e += j;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.c = System.currentTimeMillis();
            if (this.b) {
                e21 e21Var = this.a;
                long j = e21Var.c - e21Var.a;
                if (j < 0) {
                    j = 0;
                }
                this.a.e = j;
                this.b = false;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.b = System.currentTimeMillis();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.f = System.currentTimeMillis();
        }
    }
}
