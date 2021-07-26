package d.a.o0.a.n1.q.d;

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
import d.a.o0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46892e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f46893f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f46894a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f46895b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46896c;

    /* renamed from: d  reason: collision with root package name */
    public a f46897d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(86604279, "Ld/a/o0/a/n1/q/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(86604279, "Ld/a/o0/a/n1/q/d/b;");
                return;
            }
        }
        f46892e = k.f46335a;
        f46893f = new b();
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
        this.f46894a = new ArrayList();
        this.f46895b = new HashMap();
        this.f46896c = false;
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f46893f : (b) invokeV.objValue;
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
            if (this.f46896c) {
                return null;
            }
            if (f46892e) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
            d dVar = new d(str);
            dVar.a(currentTimeMillis);
            synchronized (this.f46894a) {
                this.f46895b.put(str2, dVar);
            }
            if (f46892e) {
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
            this.f46896c = true;
            synchronized (this.f46894a) {
                this.f46894a.clear();
                this.f46895b.clear();
            }
            if (f46892e) {
                Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f46896c) {
            return;
        }
        if (f46892e) {
            Log.d("MaUpdateRecorder", "end update uni tag - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f46894a) {
            d dVar = this.f46895b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.f46894a.add(dVar);
                this.f46895b.remove(str);
            }
        }
        if (f46892e) {
            Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
        }
    }

    public final JSONArray e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            synchronized (this.f46894a) {
                try {
                    for (d dVar : this.f46894a) {
                        if (dVar != null && (this.f46897d == null || this.f46897d.a(dVar))) {
                            jSONArray.put(dVar.d());
                        }
                    }
                } catch (Exception e2) {
                    if (f46892e) {
                        e2.printStackTrace();
                    }
                }
            }
            if (f46892e) {
                Log.d("MaUpdateRecorder", jSONArray.toString());
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f46896c = false;
            synchronized (this.f46894a) {
                this.f46894a.clear();
                this.f46895b.clear();
            }
            if (f46892e) {
                Log.d("MaUpdateRecorder", "reset");
            }
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f46897d = aVar;
        }
    }
}
