package d.a.o0.a.r1.k.g;

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
import d.a.o0.a.r1.l.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.a.o0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f47608f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f47609b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, JSONObject> f47610c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f47611d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.a.r1.r.c.a f47612e;

    /* renamed from: d.a.o0.a.r1.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0883a implements d.a.o0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f47613b;

        public C0883a(a aVar) {
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
            this.f47613b = aVar;
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f47613b.g();
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f47613b.g();
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f47613b.f47609b = System.currentTimeMillis();
            }
        }

        @Override // d.a.o0.a.r1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "LaunchApiCache" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f47614a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1243373889, "Ld/a/o0/a/r1/k/g/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1243373889, "Ld/a/o0/a/r1/k/g/a$b;");
                    return;
                }
            }
            f47614a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1275035455, "Ld/a/o0/a/r1/k/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1275035455, "Ld/a/o0/a/r1/k/g/a;");
                return;
            }
        }
        f47608f = e.c();
    }

    public /* synthetic */ a(C0883a c0883a) {
        this();
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? b.f47614a : (a) invokeV.objValue;
    }

    public JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && e()) {
                JSONObject jSONObject = this.f47610c.get(str);
                if (d.a.o0.a.f1.f.a.f44988a && jSONObject != null) {
                    Integer num = this.f47611d.get(str);
                    if (num == null) {
                        num = 0;
                    }
                    this.f47611d.put(str, Integer.valueOf(num.intValue() + 1));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f47608f > 0 && this.f47609b != -1 && System.currentTimeMillis() - this.f47609b <= ((long) f47608f) : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f47608f <= 0) {
                if (d.a.o0.a.f1.f.a.f44988a) {
                    Log.d("SwanPerformance", "cache api close, can't register. duration = " + f47608f);
                    return;
                }
                return;
            }
            d.a.o0.a.r1.r.a.f().h(this.f47612e, f47608f);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f47609b = -1L;
            if (d.a.o0.a.f1.f.a.f44988a) {
                StringBuilder sb = new StringBuilder();
                sb.append("adopt cache api = [ ");
                for (Map.Entry<String, Integer> entry : this.f47611d.entrySet()) {
                    sb.append((Object) entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(" ");
                }
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                Log.d("SwanPerformance", sb.toString());
            }
            this.f47611d.clear();
            this.f47610c.clear();
        }
    }

    public void h(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, jSONObject) == null) && !TextUtils.isEmpty(str) && e()) {
            this.f47610c.put(str, jSONObject);
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
        this.f47609b = -1L;
        this.f47610c = new ConcurrentHashMap<>(10);
        this.f47611d = new ConcurrentHashMap<>(10);
        this.f47612e = new C0883a(this);
    }
}
