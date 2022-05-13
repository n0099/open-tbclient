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
import com.repackage.rk1;
import com.repackage.y53;
import com.repackage.z53;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class g63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public static final Map<String, g63> q;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity a;
    public final String b;
    public final String c;
    public boolean d;
    public final Set<nf3<g63>> e;
    public TaskState f;
    public JSONObject g;
    public boolean h;
    public u03 i;
    public final nc3 j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final if3 o;

    /* loaded from: classes6.dex */
    public class a extends if3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 b;

        public a(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.H();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nf3<x53<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public b(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<JSONObject> x53Var) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (x53Var != null && x53Var.c() && (jSONObject = x53Var.a) != null) {
                    ux1.b("OpenData", "opendata=", jSONObject);
                    this.a.j.b(x53Var.a.optInt("errno", 10001));
                    this.a.j.f(x53Var.a.optString("errmsg", "internal error"));
                    if (0 != this.a.j.h()) {
                        s53.k("by errno", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    JSONObject optJSONObject = x53Var.a.optJSONObject("data");
                    if (optJSONObject == null) {
                        s53.k("by data parse", Boolean.TRUE);
                        this.a.j.b(10001L);
                        this.a.A();
                        this.a.y(10001);
                        return;
                    }
                    u53 g = u53.g(optJSONObject.optJSONObject("scope"));
                    if (g == null) {
                        s53.k("illegal scope", Boolean.TRUE);
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
                    } else if (!this.a.i.m0()) {
                        if (!this.a.h && g.e()) {
                            if (!TextUtils.equals(g.b, "mobile") || SwanAppAllianceLoginHelper.d.f()) {
                                this.a.F();
                            } else {
                                this.a.G();
                            }
                            n73.T(this.a.n, "phoneNumberLogin");
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
                s53.k("bad MaOpenData response", Boolean.TRUE);
                this.a.j.b(10001L);
                this.a.A();
                this.a.y(10001);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements rk1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ u53 b;
        public final /* synthetic */ g63 c;

        /* loaded from: classes6.dex */
        public class a implements rk1.c {
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

            @Override // com.repackage.rk1.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    ux1.i("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.a.a);
                    if (z) {
                        this.a.c.m = true;
                        this.a.c.J();
                        return;
                    }
                    this.a.c.j.b(10006L);
                    this.a.c.A();
                }
            }

            @Override // com.repackage.rk1.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    ux1.i("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.a.a);
                    c cVar = this.a;
                    if (cVar.a) {
                        cVar.c.K(cVar.b);
                    } else {
                        cVar.c.A();
                    }
                }
            }
        }

        public c(g63 g63Var, boolean z, u53 u53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var, Boolean.valueOf(z), u53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g63Var;
            this.a = z;
            this.b = u53Var;
        }

        @Override // com.repackage.rk1.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux1.i("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.a);
                bk2.h0().g(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements p53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public d(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        @Override // com.repackage.p53
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

    /* loaded from: classes6.dex */
    public class e implements gh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public e(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        @Override // com.repackage.gh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                s53.k("onResult :: " + i, Boolean.FALSE);
                if (i == -2) {
                    s53.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else if (i != 0) {
                    s53.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else {
                    s53.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.a.h = true;
                    this.a.l = true;
                    this.a.J();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements gh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public f(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        @Override // com.repackage.gh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                s53.k("onResult :: " + i, Boolean.FALSE);
                if (i == -2) {
                    s53.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else if (i != 0) {
                    s53.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.a.j.b(10004L);
                    this.a.A();
                } else {
                    s53.k("Login Preparation ok, is already login", Boolean.FALSE);
                    this.a.h = true;
                    this.a.J();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements nf3<x53<y53.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ g63 b;

        public g(g63 g63Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g63Var;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<y53.b> x53Var) {
            y53.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (!this.a && !this.b.k) {
                    this.b.A();
                } else if (x53Var != null && x53Var.c() && (bVar = x53Var.a) != null && bVar.c != null) {
                    g63 g63Var = this.b;
                    g63Var.g = bVar.c;
                    g63Var.A();
                } else {
                    nc3 nc3Var = this.b.j;
                    nc3Var.b(10002L);
                    nc3Var.f("bad Accredit response");
                    this.b.A();
                    this.b.y(10002);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public h(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (x53Var == null || !x53Var.c()) {
                    nc3 nc3Var = this.a.j;
                    nc3Var.b(10002L);
                    nc3Var.f("bad authorize response");
                    this.a.y(10002);
                }
                this.a.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g63 a;

        public i(g63 g63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g63Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.e) {
                    for (nf3 nf3Var : this.a.e) {
                        nf3Var.onCallback(this.a);
                    }
                    this.a.e.clear();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755726131, "Lcom/repackage/g63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755726131, "Lcom/repackage/g63;");
                return;
            }
        }
        p = eh1.a;
        q = new HashMap();
    }

    public g63(Activity activity, String str, String str2, boolean z, String str3) {
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
        nc3 nc3Var = new nc3();
        nc3Var.k(8L);
        nc3Var.f("OpenData");
        this.j = nc3Var;
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

    public static void B(Activity activity, String str, String str2, boolean z, String str3, nf3<g63> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{activity, str, str2, Boolean.valueOf(z), str3, nf3Var}) == null) {
            synchronized (q) {
                String C = C(str, z);
                g63 g63Var = q.get(C);
                if (g63Var == null) {
                    g63 g63Var2 = new g63(activity, str, str2, z, str3);
                    q.put(C, g63Var2);
                    g63Var2.L(nf3Var);
                } else {
                    ux1.i("OpenData", "reuse session : " + g63Var.toString());
                    g63Var.u(nf3Var);
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
            ux1.i("OpenData", "onFinish" + toString());
            s53.l(new i(this));
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
            this.i.M().f(this.a, null, new f(this));
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bk2.h0().j(new e(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.h = this.i.M().e(this.a);
            J();
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (TextUtils.isEmpty(this.c)) {
                y53 a2 = t03.J().y().a().b().a(this.a, z, this.b, this.c);
                a2.q(this.n);
                a2.o(new g(this, z));
                a2.call();
                return;
            }
            z53 d2 = t03.J().y().a().b().d(this.a, true, z, new String[]{this.b}, this.c, true);
            d2.q(this.n);
            d2.o(new h(this));
            d2.call();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            n73.T(this.n, "requestOpenData");
            e63 c2 = t03.J().y().a().b().c(this.a, this.b, this.c, this.d, this.h);
            c2.q(this.n);
            c2.o(new b(this));
            c2.call();
        }
    }

    public final void K(@NonNull u53 u53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, u53Var) == null) {
            s53.u(this.a, this.i, u53Var, this.g, new d(this));
        }
    }

    public final void L(nf3<g63> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, nf3Var) == null) {
            ux1.i("OpenData", "start session : " + this.b);
            this.f = TaskState.CALLING;
            this.k = TextUtils.equals(this.b, "snsapi_userinfo");
            u(nf3Var);
            u03 L = u03.L();
            this.i = L;
            if (L == null) {
                s53.k("SwanApp is null", Boolean.TRUE);
                this.j.b(10001L);
                A();
                y(10001);
                return;
            }
            L.d0().f.d(this.o);
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

    public final g63 u(nf3<g63> nf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, nf3Var)) == null) {
            if (nf3Var == null) {
                return this;
            }
            synchronized (this.e) {
                this.e.add(nf3Var);
            }
            return this;
        }
        return (g63) invokeL.objValue;
    }

    public final void v(u53 u53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, u53Var) == null) {
            if (this.l) {
                I(true);
            } else if (this.m) {
                K(u53Var);
            } else {
                JSONObject jSONObject = this.g;
                if (jSONObject != null && jSONObject.optInt("errno") == 1129) {
                    w(u53Var, true);
                } else {
                    K(u53Var);
                }
            }
        }
    }

    public final void w(u53 u53Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, u53Var, z) == null) {
            bk2.h0().a(new c(this, z, u53Var));
        }
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            z(i2, u53.f(this.b, new JSONObject()));
        }
    }

    public final void z(int i2, u53 u53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, u53Var) == null) {
            u03 a0 = u03.a0();
            if (a0 == null) {
                if (p) {
                    Log.e("OpenData", "failedStatistic-swanApp is null");
                    return;
                }
                return;
            }
            v73 v73Var = new v73();
            v73Var.o(i2);
            v73Var.r(a0.X());
            v73Var.q(n73.n(a0.l()));
            v73Var.m(a0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", a0.getAppId());
                jSONObject.put("msg", s53.f(i2));
                if (u53Var != null) {
                    jSONObject.put("scope", u53Var.b);
                    jSONObject.put("scopeData", u53Var.a);
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
            v73Var.e(jSONObject);
            n73.R(v73Var);
        }
    }
}
