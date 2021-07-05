package d.a.q0.a.r1.k.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.r1.l.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements d.a.q0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f50406f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f50407b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, JSONObject> f50408c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f50409d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.a.r1.r.c.a f50410e;

    /* renamed from: d.a.q0.a.r1.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0925a implements d.a.q0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f50411b;

        public C0925a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50411b = aVar;
        }

        @Override // d.a.q0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // d.a.q0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f50411b.g();
            }
        }

        @Override // d.a.q0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f50411b.g();
            }
        }

        @Override // d.a.q0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f50411b.f50407b = System.currentTimeMillis();
            }
        }

        @Override // d.a.q0.a.r1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "LaunchApiCache" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f50412a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(222305535, "Ld/a/q0/a/r1/k/g/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(222305535, "Ld/a/q0/a/r1/k/g/a$b;");
                    return;
                }
            }
            f50412a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(263918205, "Ld/a/q0/a/r1/k/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(263918205, "Ld/a/q0/a/r1/k/g/a;");
                return;
            }
        }
        f50406f = e.c();
    }

    public /* synthetic */ a(C0925a c0925a) {
        this();
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? b.f50412a : (a) invokeV.objValue;
    }

    public JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && e()) {
                JSONObject jSONObject = this.f50408c.get(str);
                if (d.a.q0.a.f1.f.a.f47786a && jSONObject != null) {
                    Integer num = this.f50409d.get(str);
                    if (num == null) {
                        num = 0;
                    }
                    this.f50409d.put(str, Integer.valueOf(num.intValue() + 1));
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f50406f > 0 && this.f50407b != -1 && System.currentTimeMillis() - this.f50407b <= ((long) f50406f) : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f50406f <= 0) {
                if (d.a.q0.a.f1.f.a.f47786a) {
                    Log.d("SwanPerformance", "cache api close, can't register. duration = " + f50406f);
                    return;
                }
                return;
            }
            d.a.q0.a.r1.r.a.f().h(this.f50410e, f50406f);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f50407b = -1L;
            if (d.a.q0.a.f1.f.a.f47786a) {
                StringBuilder sb = new StringBuilder();
                sb.append("adopt cache api = [ ");
                for (Map.Entry<String, Integer> entry : this.f50409d.entrySet()) {
                    sb.append((Object) entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(" ");
                }
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                Log.d("SwanPerformance", sb.toString());
            }
            this.f50409d.clear();
            this.f50408c.clear();
        }
    }

    public void h(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, jSONObject) == null) && !TextUtils.isEmpty(str) && e()) {
            this.f50408c.put(str, jSONObject);
        }
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
        this.f50407b = -1L;
        this.f50408c = new ConcurrentHashMap<>(10);
        this.f50409d = new ConcurrentHashMap<>(10);
        this.f50410e = new C0925a(this);
    }
}
