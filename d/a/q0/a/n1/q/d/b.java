package d.a.q0.a.n1.q.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49690e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f49691f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f49692a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f49693b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49694c;

    /* renamed from: d  reason: collision with root package name */
    public a f49695d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-924512971, "Ld/a/q0/a/n1/q/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-924512971, "Ld/a/q0/a/n1/q/d/b;");
                return;
            }
        }
        f49690e = k.f49133a;
        f49691f = new b();
    }

    public b() {
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
        this.f49692a = new ArrayList();
        this.f49693b = new HashMap();
        this.f49694c = false;
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f49691f : (b) invokeV.objValue;
    }

    public void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) || hybridUbcFlow == null) {
            return;
        }
        JSONArray e2 = e();
        if (e2 != null && e2.length() > 0) {
            hybridUbcFlow.A("ma_update_recorder", e2.toString());
        }
        c();
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f49694c) {
                return null;
            }
            if (f49690e) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
            d dVar = new d(str);
            dVar.a(currentTimeMillis);
            synchronized (this.f49692a) {
                this.f49693b.put(str2, dVar);
            }
            if (f49690e) {
                Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49694c = true;
            synchronized (this.f49692a) {
                this.f49692a.clear();
                this.f49693b.clear();
            }
            if (f49690e) {
                Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f49694c) {
            return;
        }
        if (f49690e) {
            Log.d("MaUpdateRecorder", "end update uni tag - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f49692a) {
            d dVar = this.f49693b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.f49692a.add(dVar);
                this.f49693b.remove(str);
            }
        }
        if (f49690e) {
            Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
        }
    }

    public final JSONArray e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            synchronized (this.f49692a) {
                try {
                    for (d dVar : this.f49692a) {
                        if (dVar != null && (this.f49695d == null || this.f49695d.a(dVar))) {
                            jSONArray.put(dVar.d());
                        }
                    }
                } catch (Exception e2) {
                    if (f49690e) {
                        e2.printStackTrace();
                    }
                }
            }
            if (f49690e) {
                Log.d("MaUpdateRecorder", jSONArray.toString());
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f49694c = false;
            synchronized (this.f49692a) {
                this.f49692a.clear();
                this.f49693b.clear();
            }
            if (f49690e) {
                Log.d("MaUpdateRecorder", "reset");
            }
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f49695d = aVar;
        }
    }
}
