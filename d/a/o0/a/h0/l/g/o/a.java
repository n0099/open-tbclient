package d.a.o0.a.h0.l.g.o;

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
import d.a.o0.a.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45439c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f45440d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<C0752a> f45441a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0752a> f45442b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-322197547, "Ld/a/o0/a/h0/l/g/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-322197547, "Ld/a/o0/a/h0/l/g/o/a;");
                return;
            }
        }
        f45439c = k.f46335a;
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
        this.f45441a = d.a.o0.a.v2.z0.a.a(new C0752a[0]);
        this.f45442b = d.a.o0.a.v2.z0.a.a(new C0752a[0]);
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f45440d == null) {
                synchronized (a.class) {
                    if (f45440d == null) {
                        f45440d = new a();
                    }
                }
            }
            return f45440d;
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
            if (f45439c) {
                Log.d("PreloadAppsRecorder", "clear all");
            }
            synchronized (this.f45441a) {
                this.f45441a.clear();
                this.f45442b.clear();
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
            HashSet a2 = d.a.o0.a.v2.z0.a.a(new String[0]);
            synchronized (this.f45441a) {
                for (C0752a c0752a : this.f45441a) {
                    a2.add(c0752a.f45443a);
                }
                for (C0752a c0752a2 : this.f45442b) {
                    a2.add(c0752a2.f45443a);
                }
            }
            return a2;
        }
        return (Set) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45442b.size() > 0 : invokeV.booleanValue;
    }

    public boolean f(C0752a c0752a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c0752a)) == null) {
            synchronized (this.f45441a) {
                contains = this.f45441a.contains(c0752a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public boolean g(C0752a c0752a) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c0752a)) == null) {
            synchronized (this.f45441a) {
                contains = this.f45442b.contains(c0752a);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && f45439c) {
            Log.d(str, "all apps in recorder :");
            synchronized (this.f45441a) {
                Iterator<C0752a> it = this.f45441a.iterator();
                while (it.hasNext()) {
                    Log.d(str, "loaded:" + it.next());
                }
                Iterator<C0752a> it2 = this.f45442b.iterator();
                while (it2.hasNext()) {
                    Log.d(str, "loading:" + it2.next());
                }
            }
        }
    }

    public void i(C0752a c0752a, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, c0752a, z) == null) && c0752a != null && c0752a.a()) {
            if (f45439c) {
                StringBuilder sb = new StringBuilder();
                sb.append("record one app status - ");
                sb.append(z ? "loaded" : "loading");
                Log.d("PreloadAppsRecorder", sb.toString());
                Log.d("PreloadAppsRecorder", "record one app - " + c0752a);
            }
            synchronized (this.f45441a) {
                (z ? this.f45441a : this.f45442b).add(c0752a);
            }
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f45439c) {
            Log.d("PreloadAppsRecorder", "get multi preload status - " + jSONObject);
        }
        synchronized (this.f45441a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0752a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0752a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.o0.a.v1.b.b v = d.a.o0.a.v1.b.c.E("swan_multi_preload_on_server").z("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).v("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
            v.K(true);
            v.L();
            if (f45439c) {
                Log.d("PreloadAppsRecorder", "send all prefetch records to server");
            }
        }
    }

    /* renamed from: d.a.o0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0752a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f45443a;

        /* renamed from: b  reason: collision with root package name */
        public final String f45444b;

        public C0752a(String str, long j) {
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
            this.f45443a = str;
            this.f45444b = String.valueOf(j);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f45443a) || TextUtils.isEmpty(this.f45444b)) ? false : true : invokeV.booleanValue;
        }

        public boolean equals(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof C0752a) {
                    C0752a c0752a = (C0752a) obj;
                    return TextUtils.equals(this.f45443a, c0752a.f45443a) && TextUtils.equals(this.f45444b, c0752a.f45444b);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.f45443a;
                int hashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f45444b;
                return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Item{appKey='" + this.f45443a + "', version='" + this.f45444b + "'}";
            }
            return (String) invokeV.objValue;
        }

        public C0752a(JSONObject jSONObject) {
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
                this.f45444b = null;
                this.f45443a = null;
                return;
            }
            this.f45443a = jSONObject.optString("appKey");
            this.f45444b = jSONObject.optString("version");
        }
    }
}
