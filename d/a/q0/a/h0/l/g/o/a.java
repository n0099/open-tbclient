package d.a.q0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48237c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f48238d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<C0794a> f48239a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0794a> f48240b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1343265901, "Ld/a/q0/a/h0/l/g/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1343265901, "Ld/a/q0/a/h0/l/g/o/a;");
                return;
            }
        }
        f48237c = k.f49133a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48239a = d.a.q0.a.v2.z0.a.a(new C0794a[0]);
        this.f48240b = d.a.q0.a.v2.z0.a.a(new C0794a[0]);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f48238d == null) {
                synchronized (a.class) {
                    if (f48238d == null) {
                        f48238d = new a();
                    }
                }
            }
            return f48238d;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b(true);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (f48237c) {
                Log.d("PreloadAppsRecorder", "clear all");
            }
            synchronized (this.f48239a) {
                this.f48239a.clear();
                this.f48240b.clear();
            }
            if (z) {
                k();
            }
        }
    }

    public Set<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashSet a2 = d.a.q0.a.v2.z0.a.a(new String[0]);
            synchronized (this.f48239a) {
                for (C0794a c0794a : this.f48239a) {
                    a2.add(c0794a.f48241a);
                }
                for (C0794a c0794a2 : this.f48240b) {
                    a2.add(c0794a2.f48241a);
                }
            }
            return a2;
        }
        return (Set) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48240b.size() > 0 : invokeV.booleanValue;
    }

    public boolean f(C0794a c0794a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c0794a)) == null) {
            synchronized (this.f48239a) {
                contains = this.f48239a.contains(c0794a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public boolean g(C0794a c0794a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c0794a)) == null) {
            synchronized (this.f48239a) {
                contains = this.f48240b.contains(c0794a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && f48237c) {
            Log.d(str, "all apps in recorder :");
            synchronized (this.f48239a) {
                Iterator<C0794a> it = this.f48239a.iterator();
                while (it.hasNext()) {
                    Log.d(str, "loaded:" + it.next());
                }
                Iterator<C0794a> it2 = this.f48240b.iterator();
                while (it2.hasNext()) {
                    Log.d(str, "loading:" + it2.next());
                }
            }
        }
    }

    public void i(C0794a c0794a, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, c0794a, z) == null) && c0794a != null && c0794a.a()) {
            if (f48237c) {
                StringBuilder sb = new StringBuilder();
                sb.append("record one app status - ");
                sb.append(z ? "loaded" : "loading");
                Log.d("PreloadAppsRecorder", sb.toString());
                Log.d("PreloadAppsRecorder", "record one app - " + c0794a);
            }
            synchronized (this.f48239a) {
                (z ? this.f48239a : this.f48240b).add(c0794a);
            }
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f48237c) {
            Log.d("PreloadAppsRecorder", "get multi preload status - " + jSONObject);
        }
        synchronized (this.f48239a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0794a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0794a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.q0.a.v1.b.b v = d.a.q0.a.v1.b.c.E("swan_multi_preload_on_server").z("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).v("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
            v.K(true);
            v.L();
            if (f48237c) {
                Log.d("PreloadAppsRecorder", "send all prefetch records to server");
            }
        }
    }

    /* renamed from: d.a.q0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0794a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f48241a;

        /* renamed from: b  reason: collision with root package name */
        public final String f48242b;

        public C0794a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48241a = str;
            this.f48242b = String.valueOf(j);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f48241a) || TextUtils.isEmpty(this.f48242b)) ? false : true : invokeV.booleanValue;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof C0794a) {
                    C0794a c0794a = (C0794a) obj;
                    return TextUtils.equals(this.f48241a, c0794a.f48241a) && TextUtils.equals(this.f48242b, c0794a.f48242b);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.f48241a;
                int hashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f48242b;
                return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Item{appKey='" + this.f48241a + "', version='" + this.f48242b + "'}";
            }
            return (String) invokeV.objValue;
        }

        public C0794a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (jSONObject == null) {
                this.f48242b = null;
                this.f48241a = null;
                return;
            }
            this.f48241a = jSONObject.optString("appKey");
            this.f48242b = jSONObject.optString("version");
        }
    }
}
