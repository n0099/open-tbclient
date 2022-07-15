package com.repackage;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ek1;
import com.repackage.l53;
import com.repackage.m53;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class t53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public static final Map<String, t53> q;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final String b;
    public final String c;
    public boolean d;
    public final Set<af3<t53>> e;
    public TaskState f;
    public JSONObject g;
    public boolean h;
    public h03 i;
    public final ac3 j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final ve3 o;

    /* loaded from: classes7.dex */
    public class a extends ve3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t53 b;

        public a(t53 t53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t53Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.H();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements af3<k53<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t53 a;

        public b(t53 t53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<JSONObject> k53Var) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (k53Var != null && k53Var.c() && (jSONObject = k53Var.a) != null) {
                    hx1.b("OpenData", "opendata=", jSONObject);
                    this.a.j.b(k53Var.a.optInt("errno", 10001));
                    this.a.j.f(k53Var.a.optString("errmsg", "internal error"));
                    if (0 != this.a.j.h()) {
                        f53.k("by errno", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    JSONObject optJSONObject = k53Var.a.optJSONObject("data");
                    if (optJSONObject == null) {
                        f53.k("by data parse", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    h53 g = h53.g(optJSONObject.optJSONObject("scope"));
                    if (g == null) {
                        f53.k("illegal scope", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    this.a.g = optJSONObject.optJSONObject("opendata");
                    if (!this.a.d && (i = g.j) < 0) {
                        if (i == -2) {
                            this.a.j.b(10006L);
                        } else {
                            this.a.j.b(10005L);
                            this.a.z(10005, g);
                        }
                        this.a.A();
                        return;
                    } else if (g.j > 0) {
                        if (!this.a.h || !TextUtils.equals(g.b, "mobile") || (jSONObject2 = this.a.g) == null || jSONObject2.optInt("errno") != 1129) {
                            this.a.A();
                            return;
                        } else {
                            this.a.w(g, false);
                            return;
                        }
                    } else if (!this.a.i.n0()) {
                        if (!this.a.h && g.e()) {
                            if (!TextUtils.equals(g.b, "mobile") || SwanAppAllianceLoginHelper.d.f()) {
                                this.a.F();
                            } else {
                                this.a.G();
                            }
                            a73.T(this.a.n, "phoneNumberLogin");
                            return;
                        } else if (TextUtils.equals(g.b, "mobile")) {
                            this.a.v(g);
                            return;
                        } else {
                            this.a.K(g);
                            return;
                        }
                    } else {
                        this.a.j.b(10005L);
                        this.a.A();
                        this.a.z(10005, g);
                        return;
                    }
                }
                f53.k("bad MaOpenData response", Boolean.TRUE);
                this.a.j.b(10001L);
                this.a.A();
                this.a.y(10001);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ek1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ h53 b;
        public final /* synthetic */ t53 c;

        /* loaded from: classes7.dex */
        public class a implements ek1.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.repackage.ek1.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    hx1.i("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.a.a);
                    if (z) {
                        this.a.c.m = true;
                        this.a.c.J();
                        return;
                    }
                    this.a.c.j.b(10006L);
                    this.a.c.A();
                }
            }

            @Override // com.repackage.ek1.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    hx1.i("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.a.a);
                    c cVar = this.a;
                    if (cVar.a) {
                        cVar.c.K(cVar.b);
                    } else {
                        cVar.c.A();
                    }
                }
            }
        }

        public c(t53 t53Var, boolean z, h53 h53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t53Var, Boolean.valueOf(z), h53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t53Var;
            this.a = z;
            this.b = h53Var;
        }

        @Override // com.repackage.ek1.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hx1.i("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.a);
                oj2.h0().g(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t53 a;

        public d(t53 t53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t53Var;
        }

        @Override // com.repackage.c53
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.j.b(10003L);
                }
                this.a.I(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements tg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t53 a;

        public e(t53 t53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t53Var;
        }

        @Override // com.repackage.tg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                f53.k("onResult :: " + i, Boolean.FALSE);
                if (i == -2) {
                    f53.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else if (i != 0) {
                    f53.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else {
                    f53.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.a.h = true;
                    this.a.l = true;
                    this.a.J();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements tg1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t53 a;

        public f(t53 t53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t53Var;
        }

        @Override // com.repackage.tg1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                f53.k("onResult :: " + i, Boolean.FALSE);
                if (i == -2) {
                    f53.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else if (i != 0) {
                    f53.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else {
                    f53.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.a.h = true;
                    this.a.J();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements af3<k53<l53.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ t53 b;

        public g(t53 t53Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t53Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t53Var;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<l53.b> k53Var) {
            l53.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (!this.a && !this.b.k) {
                    this.b.A();
                } else if (k53Var != null && k53Var.c() && (bVar = k53Var.a) != null && bVar.c != null) {
                    t53 t53Var = this.b;
                    t53Var.g = bVar.c;
                    t53Var.A();
                } else {
                    ac3 ac3Var = this.b.j;
                    ac3Var.b(10002L);
                    ac3Var.f("bad Accredit response");
                    this.b.A();
                    this.b.y(10002);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t53 a;

        public h(t53 t53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (k53Var == null || !k53Var.c()) {
                    ac3 ac3Var = this.a.j;
                    ac3Var.b(10002L);
                    ac3Var.f("bad authorize response");
                    this.a.y(10002);
                }
                this.a.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t53 a;

        public i(t53 t53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t53Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.e) {
                    for (af3 af3Var : this.a.e) {
                        af3Var.a(this.a);
                    }
                    this.a.e.clear();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755339809, "Lcom/repackage/t53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755339809, "Lcom/repackage/t53;");
                return;
            }
        }
        p = rg1.a;
        q = new HashMap();
    }

    public t53(Activity activity, String str, String str2, boolean z, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, Boolean.valueOf(z), str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new HashSet();
        this.f = TaskState.INIT;
        this.h = false;
        ac3 ac3Var = new ac3();
        ac3Var.k(8L);
        ac3Var.f("OpenData");
        this.j = ac3Var;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new a(this);
        this.a = activity;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.n = str3;
    }

    public static void B(Activity activity, String str, String str2, boolean z, String str3, af3<t53> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{activity, str, str2, Boolean.valueOf(z), str3, af3Var}) == null) {
            synchronized (q) {
                String C = C(str, z);
                t53 t53Var = q.get(C);
                if (t53Var == null) {
                    t53 t53Var2 = new t53(activity, str, str2, z, str3);
                    q.put(C, t53Var2);
                    t53Var2.L(af3Var);
                } else {
                    hx1.i("OpenData", "reuse session : " + t53Var.toString());
                    t53Var.u(af3Var);
                }
            }
        }
    }

    public static String C(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            sb.append(z ? "1" : "0");
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, null) == null) {
            synchronized (q) {
                q.clear();
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o.a();
            synchronized (q) {
                q.remove(C(this.b, this.d));
            }
            this.f = TaskState.FINISHED;
            if (this.g == null && 0 == this.j.a()) {
                if (this.h) {
                    this.j.b(10001L);
                } else {
                    this.j.b(10004L);
                }
            }
            hx1.i("OpenData", "onFinish" + toString());
            f53.l(new i(this));
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TaskState.FINISHED == this.f && 0 == this.j.a() && this.g != null : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.FINISHED == this.f && this.g != null : invokeV.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i.N().f(this.a, null, new f(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            oj2.h0().j(new e(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.h = this.i.N().e(this.a);
            J();
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (TextUtils.isEmpty(this.c)) {
                l53 a2 = g03.K().x().a().b().a(this.a, z, this.b, this.c);
                a2.q(this.n);
                a2.o(new g(this, z));
                a2.call();
                return;
            }
            m53 d2 = g03.K().x().a().b().d(this.a, true, z, new String[]{this.b}, this.c, true);
            d2.q(this.n);
            d2.o(new h(this));
            d2.call();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            a73.T(this.n, "requestOpenData");
            r53 c2 = g03.K().x().a().b().c(this.a, this.b, this.c, this.d, this.h);
            c2.q(this.n);
            c2.o(new b(this));
            c2.call();
        }
    }

    public final void K(@NonNull h53 h53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h53Var) == null) {
            f53.u(this.a, this.i, h53Var, this.g, new d(this));
        }
    }

    public final void L(af3<t53> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, af3Var) == null) {
            hx1.i("OpenData", "start session : " + this.b);
            this.f = TaskState.CALLING;
            this.k = TextUtils.equals(this.b, "snsapi_userinfo");
            u(af3Var);
            h03 M = h03.M();
            this.i = M;
            if (M == null) {
                f53.k("SwanApp is null", Boolean.TRUE);
                this.j.b(10001L);
                A();
                y(10001);
                return;
            }
            M.e0().f.d(this.o);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.b, Boolean.valueOf(D()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
            if (this.g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final t53 u(af3<t53> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, af3Var)) == null) {
            if (af3Var == null) {
                return this;
            }
            synchronized (this.e) {
                this.e.add(af3Var);
            }
            return this;
        }
        return (t53) invokeL.objValue;
    }

    public final void v(h53 h53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, h53Var) == null) {
            if (this.l) {
                I(true);
            } else if (this.m) {
                K(h53Var);
            } else {
                JSONObject jSONObject = this.g;
                if (jSONObject != null && jSONObject.optInt("errno") == 1129) {
                    w(h53Var, true);
                } else {
                    K(h53Var);
                }
            }
        }
    }

    public final void w(h53 h53Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, h53Var, z) == null) {
            oj2.h0().a(new c(this, z, h53Var));
        }
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            z(i2, h53.f(this.b, new JSONObject()));
        }
    }

    public final void z(int i2, h53 h53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, h53Var) == null) {
            h03 b0 = h03.b0();
            if (b0 == null) {
                if (p) {
                    Log.e("OpenData", "failedStatistic-swanApp is null");
                    return;
                }
                return;
            }
            i73 i73Var = new i73();
            i73Var.o(i2);
            i73Var.r(b0.Y());
            i73Var.q(a73.n(b0.k()));
            i73Var.m(b0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", b0.getAppId());
                jSONObject.put("msg", f53.f(i2));
                if (h53Var != null) {
                    jSONObject.put("scope", h53Var.b);
                    jSONObject.put("scopeData", h53Var.a);
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
            i73Var.e(jSONObject);
            a73.R(i73Var);
        }
    }
}
