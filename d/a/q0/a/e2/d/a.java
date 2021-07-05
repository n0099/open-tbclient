package d.a.q0.a.e2.d;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.setting.oauth.TaskState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import d.a.q0.a.e2.c.j.a;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.j2.k;
import d.a.q0.a.p.d.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public static final Map<String, a> q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f47699a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47700b;

    /* renamed from: c  reason: collision with root package name */
    public final String f47701c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47702d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d.a.q0.a.v2.e1.b<a>> f47703e;

    /* renamed from: f  reason: collision with root package name */
    public TaskState f47704f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f47705g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47706h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.a.a2.e f47707i;
    public final d.a.q0.a.q2.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final d.a.q0.a.v2.d1.a o;

    /* renamed from: d.a.q0.a.e2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0743a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47708e;

        public RunnableC0743a(a aVar) {
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
            this.f47708e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f47708e.f47703e) {
                    for (d.a.q0.a.v2.e1.b bVar : this.f47708e.f47703e) {
                        bVar.onCallback(this.f47708e);
                    }
                    this.f47708e.f47703e.clear();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.q0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47709f;

        public b(a aVar) {
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
            this.f47709f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47709f.I();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47710e;

        public c(a aVar) {
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
            this.f47710e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && (jSONObject = iVar.f47670a) != null) {
                    d.a.q0.a.e0.d.a("OpenData", "opendata=", jSONObject);
                    this.f47710e.j.b(iVar.f47670a.optInt("errno", 10001));
                    this.f47710e.j.e(iVar.f47670a.optString("errmsg", "internal error"));
                    if (0 != this.f47710e.j.g()) {
                        d.a.q0.a.e2.c.d.j("by errno", Boolean.TRUE);
                        this.f47710e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f47710e.B();
                        this.f47710e.z(10001);
                        return;
                    }
                    JSONObject optJSONObject = iVar.f47670a.optJSONObject("data");
                    if (optJSONObject == null) {
                        d.a.q0.a.e2.c.d.j("by data parse", Boolean.TRUE);
                        this.f47710e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f47710e.B();
                        this.f47710e.z(10001);
                        return;
                    }
                    d.a.q0.a.e2.c.f e2 = d.a.q0.a.e2.c.f.e(optJSONObject.optJSONObject("scope"));
                    if (e2 == null) {
                        d.a.q0.a.e2.c.d.j("illegal scope", Boolean.TRUE);
                        this.f47710e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f47710e.B();
                        this.f47710e.z(10001);
                        return;
                    }
                    this.f47710e.f47705g = optJSONObject.optJSONObject("opendata");
                    if (!this.f47710e.f47702d && (i2 = e2.j) < 0) {
                        if (i2 == -2) {
                            this.f47710e.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                        } else {
                            this.f47710e.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                            this.f47710e.A(10005, e2);
                        }
                        this.f47710e.B();
                        return;
                    } else if (e2.j > 0) {
                        if (!this.f47710e.f47706h || !TextUtils.equals(e2.f47629b, "mobile") || (jSONObject2 = this.f47710e.f47705g) == null || jSONObject2.optInt("errno") != 1129) {
                            this.f47710e.B();
                            return;
                        } else {
                            this.f47710e.w(e2, false);
                            return;
                        }
                    } else if (!this.f47710e.f47707i.d0()) {
                        if (!this.f47710e.f47706h && e2.c()) {
                            if (!TextUtils.equals(e2.f47629b, "mobile") || d.a.q0.a.s.a.f.f50510d.f()) {
                                this.f47710e.G();
                            } else {
                                this.f47710e.H();
                            }
                            k.N(this.f47710e.n, "phoneNumberLogin");
                            return;
                        } else if (TextUtils.equals(e2.f47629b, "mobile")) {
                            this.f47710e.v(e2);
                            return;
                        } else {
                            this.f47710e.L(e2);
                            return;
                        }
                    } else {
                        this.f47710e.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        this.f47710e.B();
                        this.f47710e.A(10005, e2);
                        return;
                    }
                }
                d.a.q0.a.e2.c.d.j("bad MaOpenData response", Boolean.TRUE);
                this.f47710e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                this.f47710e.B();
                this.f47710e.z(10001);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.e2.c.f f47711a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f47712b;

        public d(a aVar, d.a.q0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47712b = aVar;
            this.f47711a = fVar;
        }

        @Override // d.a.q0.a.p.d.n.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d.a.q0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onSuccess isBind = " + z + ". needAuth = true");
                if (z) {
                    this.f47712b.L(this.f47711a);
                } else {
                    this.f47712b.w(this.f47711a, true);
                }
            }
        }

        @Override // d.a.q0.a.p.d.n.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.q0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onFail. needAuth = true");
                this.f47712b.L(this.f47711a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f47713a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.e2.c.f f47714b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f47715c;

        /* renamed from: d.a.q0.a.e2.d.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0744a implements n.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f47716a;

            public C0744a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47716a = eVar;
            }

            @Override // d.a.q0.a.p.d.n.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    d.a.q0.a.e0.d.g("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.f47716a.f47713a);
                    if (z) {
                        this.f47716a.f47715c.m = true;
                        this.f47716a.f47715c.K();
                        return;
                    }
                    this.f47716a.f47715c.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    this.f47716a.f47715c.B();
                }
            }

            @Override // d.a.q0.a.p.d.n.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d.a.q0.a.e0.d.g("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.f47716a.f47713a);
                    e eVar = this.f47716a;
                    if (eVar.f47713a) {
                        eVar.f47715c.L(eVar.f47714b);
                    } else {
                        eVar.f47715c.B();
                    }
                }
            }
        }

        public e(a aVar, boolean z, d.a.q0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z), fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47715c = aVar;
            this.f47713a = z;
            this.f47714b = fVar;
        }

        @Override // d.a.q0.a.p.d.n.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.e0.d.g("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.f47713a);
                d.a.q0.a.c1.a.a0().g(new C0744a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.q0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f47717a;

        public f(a aVar) {
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
            this.f47717a = aVar;
        }

        @Override // d.a.q0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f47717a.j.b(LightappBusinessClient.SVC_ID_H5_TRANSERECORD);
                }
                this.f47717a.J(z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47718e;

        public g(a aVar) {
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
            this.f47718e = aVar;
        }

        @Override // d.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                d.a.q0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    d.a.q0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f47718e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f47718e.B();
                } else if (i2 != 0) {
                    d.a.q0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f47718e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f47718e.B();
                } else {
                    d.a.q0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f47718e.f47706h = true;
                    this.f47718e.l = true;
                    this.f47718e.K();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements d.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47719e;

        public h(a aVar) {
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
            this.f47719e = aVar;
        }

        @Override // d.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                d.a.q0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    d.a.q0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f47719e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f47719e.B();
                } else if (i2 != 0) {
                    d.a.q0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f47719e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f47719e.B();
                } else {
                    d.a.q0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f47719e.f47706h = true;
                    this.f47719e.K();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47720e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47721f;

        public i(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47721f = aVar;
            this.f47720e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!this.f47720e && !this.f47721f.k) {
                    this.f47721f.B();
                } else if (iVar != null && iVar.c() && (bVar = iVar.f47670a) != null && bVar.f47675c != null) {
                    a aVar = this.f47721f;
                    aVar.f47705g = bVar.f47675c;
                    aVar.B();
                } else {
                    d.a.q0.a.q2.a aVar2 = this.f47721f.j;
                    aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar2.e("bad Accredit response");
                    this.f47721f.B();
                    this.f47721f.z(10002);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f47722e;

        public j(a aVar) {
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
            this.f47722e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c()) {
                    d.a.q0.a.q2.a aVar = this.f47722e.j;
                    aVar.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar.e("bad authorize response");
                    this.f47722e.z(10002);
                }
                this.f47722e.B();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1899924914, "Ld/a/q0/a/e2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1899924914, "Ld/a/q0/a/e2/d/a;");
                return;
            }
        }
        p = d.a.q0.a.k.f49133a;
        q = new HashMap();
    }

    public a(Activity activity, String str, String str2, boolean z, String str3) {
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
        this.f47703e = new HashSet();
        this.f47704f = TaskState.INIT;
        this.f47706h = false;
        d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
        aVar.j(8L);
        aVar.e("OpenData");
        this.j = aVar;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new b(this);
        this.f47699a = activity;
        this.f47700b = str;
        this.f47701c = str2;
        this.f47702d = z;
        this.n = str3;
    }

    public static void C(Activity activity, String str, String str2, boolean z, String str3, d.a.q0.a.v2.e1.b<a> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{activity, str, str2, Boolean.valueOf(z), str3, bVar}) == null) {
            synchronized (q) {
                String D = D(str, z);
                a aVar = q.get(D);
                if (aVar == null) {
                    a aVar2 = new a(activity, str, str2, z, str3);
                    q.put(D, aVar2);
                    aVar2.M(bVar);
                } else {
                    d.a.q0.a.e0.d.g("OpenData", "reuse session : " + aVar.toString());
                    aVar.u(bVar);
                }
            }
        }
    }

    public static String D(String str, boolean z) {
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

    public final void A(int i2, d.a.q0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, fVar) == null) {
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q == null) {
                if (p) {
                    Log.e("OpenData", "failedStatistic-swanApp is null");
                    return;
                }
                return;
            }
            d.a.q0.a.j2.p.d dVar = new d.a.q0.a.j2.p.d();
            dVar.o(i2);
            dVar.r(Q.N());
            dVar.q(k.m(Q.l()));
            dVar.m(Q.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Q.getAppId());
                jSONObject.put("msg", d.a.q0.a.e2.c.d.f(i2));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f47629b);
                    jSONObject.put("scopeData", fVar.f47628a);
                }
            } catch (JSONException e2) {
                if (p) {
                    e2.printStackTrace();
                }
            }
            dVar.e(jSONObject);
            k.L(dVar);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o.a();
            synchronized (q) {
                q.remove(D(this.f47700b, this.f47702d));
            }
            this.f47704f = TaskState.FINISHED;
            if (this.f47705g == null && 0 == this.j.a()) {
                if (this.f47706h) {
                    this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                } else {
                    this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                }
            }
            d.a.q0.a.e0.d.g("OpenData", "onFinish" + toString());
            d.a.q0.a.e2.c.d.k(new RunnableC0743a(this));
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.FINISHED == this.f47704f && 0 == this.j.a() && this.f47705g != null : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TaskState.FINISHED == this.f47704f && this.f47705g != null : invokeV.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f47707i.j().f(this.f47699a, null, new h(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.q0.a.c1.a.a0().j(new g(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f47706h = this.f47707i.j().e(this.f47699a);
            K();
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (TextUtils.isEmpty(this.f47701c)) {
                d.a.q0.a.e2.c.j.a a2 = d.a.q0.a.a2.d.g().y().a().b().a(this.f47699a, z, this.f47700b, this.f47701c);
                a2.r(this.n);
                a2.p(new i(this, z));
                a2.a();
                return;
            }
            d.a.q0.a.e2.c.j.b d2 = d.a.q0.a.a2.d.g().y().a().b().d(this.f47699a, true, z, new String[]{this.f47700b}, this.f47701c, true);
            d2.r(this.n);
            d2.p(new j(this));
            d2.a();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k.N(this.n, "requestOpenData");
            d.a.q0.a.e2.c.j.g c2 = d.a.q0.a.a2.d.g().y().a().b().c(this.f47699a, this.f47700b, this.f47701c, this.f47702d, this.f47706h);
            c2.r(this.n);
            c2.p(new c(this));
            c2.a();
        }
    }

    public final void L(@NonNull d.a.q0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            d.a.q0.a.e2.c.d.t(this.f47699a, this.f47707i, fVar, this.f47705g, new f(this));
        }
    }

    public final void M(d.a.q0.a.v2.e1.b<a> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            d.a.q0.a.e0.d.g("OpenData", "start session : " + this.f47700b);
            this.f47704f = TaskState.CALLING;
            this.k = TextUtils.equals(this.f47700b, "snsapi_userinfo");
            u(bVar);
            d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
            this.f47707i = i2;
            if (i2 == null) {
                d.a.q0.a.e2.c.d.j("SwanApp is null", Boolean.TRUE);
                this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                B();
                z(10001);
                return;
            }
            i2.T().f47502f.d(this.o);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f47700b, Boolean.valueOf(E()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
            if (this.f47705g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f47705g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f47704f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final a u(d.a.q0.a.v2.e1.b<a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bVar)) == null) {
            if (bVar == null) {
                return this;
            }
            synchronized (this.f47703e) {
                this.f47703e.add(bVar);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void v(d.a.q0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fVar) == null) {
            if (this.l) {
                J(true);
            } else if (this.m) {
                L(fVar);
            } else {
                y(fVar);
            }
        }
    }

    public final void w(d.a.q0.a.e2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, fVar, z) == null) {
            d.a.q0.a.c1.a.a0().a(new e(this, z, fVar));
        }
    }

    public final void y(d.a.q0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            d.a.q0.a.c1.a.a0().g(new d(this, fVar));
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            A(i2, d.a.q0.a.e2.c.f.d(this.f47700b, new JSONObject()));
        }
    }
}
