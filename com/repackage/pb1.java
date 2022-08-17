package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pb1 {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public ArrayList<C0555a> b;

        /* renamed from: com.repackage.pb1$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0555a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public long a;
            public long b;

            public C0555a(long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j;
                this.b = j2;
            }

            public boolean a(long j) {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? j >= this.a && j <= this.b : invokeJ.booleanValue;
            }
        }

        public a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new ArrayList<>();
            this.a = jSONObject.optLong("expires", 0L);
            JSONArray optJSONArray = jSONObject.optJSONArray("schedule");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    this.b.add(new C0555a(optJSONObject.optLong("start", 0L), optJSONObject.optLong("end", 0L)));
                }
            }
        }

        @Nullable
        public static a c(@Nullable JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    return new a(jSONObject);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (a) invokeL.objValue;
        }

        public final boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? e(System.currentTimeMillis() / 1000) : invokeV.booleanValue;
        }

        public final boolean e(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                if (wx0.k(this.b) == 0) {
                    return false;
                }
                Iterator<C0555a> it = this.b.iterator();
                while (it.hasNext()) {
                    C0555a next = it.next();
                    if (next != null && next.a(j)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public final boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? g(System.currentTimeMillis() / 1000) : invokeV.booleanValue;
        }

        public final boolean g(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? this.a > j : invokeJ.booleanValue;
        }
    }

    public static void A(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65536, null, f) == null) {
            ey0.a().b("splash_sp_name").f("hot_update_split_time", f);
        }
    }

    public static void B(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ey0.a().b("splash_sp_name").j("inner_monitor_host", str, false);
    }

    public static void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            ey0.a().b("splash_sp_name").g("md5_check_switch", i);
        }
    }

    public static void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            ey0.a().b("splash_sp_name").g("monitor_log_switch", i);
        }
    }

    public static void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            ey0.a().b("splash_sp_name").g("query_host_opt", i);
        }
    }

    public static void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, null, i) == null) {
            ey0.a().b("splash_sp_name").g("query_time_out_advance", i);
        }
    }

    public static void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            ey0.a().b("splash_sp_name").g("request_count", i);
        }
    }

    public static void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            String str2 = "";
            if (!TextUtils.isEmpty(str)) {
                try {
                    str2 = new JSONObject(str).optString("server_block_reason", "");
                } catch (JSONException unused) {
                }
            }
            ey0.a().b("splash_sp_name").i("server_block_reason", str2);
        }
    }

    public static void I(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("freq");
            if (optJSONObject != null) {
                w(optJSONObject);
            }
            F(jSONObject.optInt("query_time_out_advance", 100));
            A((float) jSONObject.optDouble("hot_update_split_time", 5.0d));
            t(jSONObject.optInt("open_bes_switch", 0));
            C(jSONObject.optInt("md5_check_switch", 0));
            G(jSONObject.optInt("request_count", 10));
            D(jSONObject.optInt("monitor_log_switch", 1));
            B(jSONObject.optString("inner_monitor_host", "https://sp0.baidu.com"));
            v(jSONObject.optInt("crash_opt", 1));
            u(jSONObject.optString("cpt_config", ""));
            E(jSONObject.optInt("query_host_opt", 0));
        } catch (JSONException unused) {
        }
    }

    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? ey0.a().b("splash_sp_name").getInt("query_host_opt", 0) == 1 : invokeV.booleanValue;
    }

    public static boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            JSONObject d = cb1.a().d();
            if (d == null || !d.has("cpc_show_scene")) {
                return true;
            }
            int optInt = d.optInt("cpc_show_scene", 0);
            return optInt != 1 ? optInt != 2 || i == 1 : i == 0;
        }
        return invokeI.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? c(false) : invokeV.booleanValue;
    }

    public static boolean c(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65548, null, z)) == null) {
            a e = e();
            if (e == null) {
                i = 13001;
            } else if (e.f()) {
                i = e.d() ? 13003 : 0;
            } else {
                i = TaskResponseData.ERROR_NO_TASK_OFFLINE_02;
            }
            if (i != 0 && z) {
                BaseVM.k(i);
            }
            return i == 0;
        }
        return invokeZ.booleanValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            JSONObject d = cb1.a().d();
            if (d == null || !d.has("cpc_show_times")) {
                return Integer.MAX_VALUE;
            }
            return d.optInt("cpc_show_times");
        }
        return invokeV.intValue;
    }

    @Nullable
    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (a == null) {
                a = f();
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    @Nullable
    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            String string = ey0.a().b("splash_sp_name").getString("cpt_config", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return a.c(xx0.c(string));
        }
        return (a) invokeV.objValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? ey0.a().b("splash_sp_name").getInt("hot_splash_max_count", 3) : invokeV.intValue;
    }

    public static float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? ey0.a().b("splash_sp_name").getFloat("hot_background_time", 5.0f) : invokeV.floatValue;
    }

    public static float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? ey0.a().b("splash_sp_name").getFloat("hot_update_split_time", 5.0f) : invokeV.floatValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? ey0.a().b("splash_sp_name").getString("inner_monitor_host", "https://sp0.baidu.com") : (String) invokeV.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? ey0.a().b("splash_sp_name").getInt("monitor_log_switch", 1) == 1 : invokeV.booleanValue;
    }

    @NonNull
    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (r()) {
                return n();
            }
            return cb1.a().e();
        }
        return (String) invokeV.objValue;
    }

    public static int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? ey0.a().b("splash_sp_name").getInt("query_time_out_advance", 100) : invokeV.intValue;
    }

    @NonNull
    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            JSONObject d = cb1.a().d();
            return (d == null || !d.has("query_unite_pid")) ? "" : d.optString("query_unite_pid", "");
        }
        return (String) invokeV.objValue;
    }

    public static int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? ey0.a().b("splash_sp_name").getInt("request_count", 10) : invokeV.intValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? ey0.a().b("splash_sp_name").getString("server_block_reason", "") : (String) invokeV.objValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? qk0.b().a().a("cmd_uniform_enable", 0) != 0 : invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? qk0.b().a().a("query_uniform_enable", 0) == 1 && !TextUtils.isEmpty(n()) : invokeV.booleanValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? qk0.b().a().a("query_url_cache_opt", 0) == 1 : invokeV.booleanValue;
    }

    public static void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65565, null, i) == null) {
            ey0.a().b("splash_sp_name").g("open_bes_switch", i);
        }
    }

    public static void u(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65566, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        a = a.c(xx0.c(str));
        ey0.a().b("splash_sp_name").i("cpt_config", str);
    }

    public static void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65567, null, i) == null) {
            ey0.a().b("splash_sp_name").g("crash_opt", i);
        }
    }

    public static void w(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, jSONObject) == null) {
            z((float) jSONObject.optDouble("hot_background_time", 5.0d));
            x(jSONObject.optInt("hot_splash_max_count", 3));
            y(jSONObject.optInt("hot_switch", 1));
        }
    }

    public static void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65569, null, i) == null) {
            ey0.a().b("splash_sp_name").g("hot_splash_max_count", i);
        }
    }

    public static void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65570, null, i) == null) {
            ey0.a().b("splash_sp_name").g("hot_switch", i);
        }
    }

    public static void z(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65571, null, f) == null) {
            ey0.a().b("splash_sp_name").f("hot_background_time", f);
        }
    }
}
