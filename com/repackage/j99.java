package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i99;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j99 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public static volatile j99 o;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public File b;
    public boolean c;
    public boolean d;
    public long e;
    public int f;
    public int g;
    public long h;
    public long i;
    public long j;
    public int k;
    public int l;
    public HashMap<String, i99> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755633689, "Lcom/repackage/j99;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755633689, "Lcom/repackage/j99;");
                return;
            }
        }
        n = AppConfig.isDebug();
    }

    public j99() {
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
        n();
    }

    public static j99 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (o == null) {
                synchronized (j99.class) {
                    if (o == null) {
                        o = new j99();
                    }
                }
            }
            return o;
        }
        return (j99) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        i99 i99Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.c;
            }
            HashMap<String, i99> hashMap = this.m;
            if (hashMap != null && (i99Var = hashMap.get(str)) != null) {
                return i99Var.e();
            }
            return this.c;
        }
        return invokeL.booleanValue;
    }

    public long b(String str) {
        InterceptResult invokeL;
        i99 i99Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.i;
            }
            HashMap<String, i99> hashMap = this.m;
            if (hashMap != null && (i99Var = hashMap.get(str)) != null) {
                return i99Var.a();
            }
            return this.i;
        }
        return invokeL.longValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        i99 i99Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.l;
            }
            HashMap<String, i99> hashMap = this.m;
            if (hashMap != null && (i99Var = hashMap.get(str)) != null) {
                return i99Var.b();
            }
            return this.l;
        }
        return invokeL.intValue;
    }

    public long d(String str) {
        InterceptResult invokeL;
        i99 i99Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.h;
            }
            HashMap<String, i99> hashMap = this.m;
            if (hashMap != null && (i99Var = hashMap.get(str)) != null) {
                return i99Var.d();
            }
            return this.h;
        }
        return invokeL.longValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        i99 i99Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.g;
            }
            HashMap<String, i99> hashMap = this.m;
            if (hashMap != null && (i99Var = hashMap.get(str)) != null) {
                return i99Var.c();
            }
            return this.g;
        }
        return invokeL.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : invokeV.intValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.longValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.g : invokeV.intValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.e : invokeV.longValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f : invokeV.intValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "/config/");
            this.b = file;
            if (!file.exists()) {
                this.b.mkdirs();
            }
            File file2 = new File(this.b, "voyager_config.txt");
            this.a = file2;
            if (file2.exists()) {
                q();
            } else {
                r();
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String f = ca9.f(this.a);
            if (n) {
                Log.d("VoyagerConfig", "read from local: " + f);
            }
            if (TextUtils.isEmpty(f)) {
                r();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(f);
                this.c = jSONObject.optBoolean("en", k99.a);
                this.d = jSONObject.optBoolean("c", k99.c);
                this.e = jSONObject.optLong("ui", k99.e);
                this.f = jSONObject.optInt("utc", k99.f);
                this.i = jSONObject.optLong("et", k99.g);
                this.k = jSONObject.optInt("mfc", k99.i);
                this.j = jSONObject.optLong("mfs", k99.h);
                this.l = jSONObject.optInt("an", k99.l);
                this.g = jSONObject.optInt("stmc", k99.j);
                this.h = jSONObject.optLong("stms", k99.k);
                JSONObject optJSONObject = jSONObject.optJSONObject("set");
                if (optJSONObject == null || optJSONObject.length() <= 0) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                    if (optJSONObject2 != null && optJSONObject2.length() != 0) {
                        i99 g = new i99.b(next).g();
                        if (optJSONObject2.optInt("en") != k99.n) {
                            g.f(k99.a);
                        } else {
                            g.f(k99.b);
                        }
                        long optInt = optJSONObject2.optInt("et", 0);
                        if (optInt > 0) {
                            g.g(optInt);
                        } else {
                            g.g(this.i);
                        }
                        int optInt2 = optJSONObject2.optInt("stmc", 0);
                        if (optInt2 > 0) {
                            g.i(optInt2);
                        } else {
                            g.i(this.g);
                        }
                        long optLong = optJSONObject2.optLong("stms", 0L);
                        if (optLong > 0) {
                            g.j(optLong);
                        } else {
                            g.j(this.h);
                        }
                        if (optJSONObject2.optInt("an") != k99.m) {
                            g.h(k99.l);
                        } else {
                            g.h(k99.m);
                        }
                        if (!g.e() || g.a() != this.i || g.c() != this.g || g.d() != this.h || g.b() != this.l) {
                            if (this.m == null) {
                                this.m = new HashMap<>();
                            }
                            this.m.put(next, g);
                        }
                    }
                }
            } catch (JSONException e) {
                if (n) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c = k99.a;
            this.d = k99.c;
            this.e = k99.e;
            this.f = k99.f;
            this.i = k99.g;
            this.k = k99.i;
            this.j = k99.h;
            this.g = k99.j;
            this.h = k99.k;
            this.l = k99.l;
        }
    }
}
