package d.a.o0.a.e2.d;

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
import d.a.o0.a.e2.c.j.a;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.j2.k;
import d.a.o0.a.p.d.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean p;
    public static final Map<String, a> q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f44901a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44902b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44903c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44904d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d.a.o0.a.v2.e1.b<a>> f44905e;

    /* renamed from: f  reason: collision with root package name */
    public TaskState f44906f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f44907g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44908h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.a.a2.e f44909i;
    public final d.a.o0.a.q2.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final d.a.o0.a.v2.d1.a o;

    /* renamed from: d.a.o0.a.e2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0701a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44910e;

        public RunnableC0701a(a aVar) {
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
            this.f44910e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f44910e.f44905e) {
                    for (d.a.o0.a.v2.e1.b bVar : this.f44910e.f44905e) {
                        bVar.onCallback(this.f44910e);
                    }
                    this.f44910e.f44905e.clear();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.o0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f44911f;

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
            this.f44911f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44911f.I();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44912e;

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
            this.f44912e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && (jSONObject = iVar.f44872a) != null) {
                    d.a.o0.a.e0.d.a("OpenData", "opendata=", jSONObject);
                    this.f44912e.j.b(iVar.f44872a.optInt("errno", 10001));
                    this.f44912e.j.e(iVar.f44872a.optString("errmsg", "internal error"));
                    if (0 != this.f44912e.j.g()) {
                        d.a.o0.a.e2.c.d.j("by errno", Boolean.TRUE);
                        this.f44912e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f44912e.B();
                        this.f44912e.z(10001);
                        return;
                    }
                    JSONObject optJSONObject = iVar.f44872a.optJSONObject("data");
                    if (optJSONObject == null) {
                        d.a.o0.a.e2.c.d.j("by data parse", Boolean.TRUE);
                        this.f44912e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f44912e.B();
                        this.f44912e.z(10001);
                        return;
                    }
                    d.a.o0.a.e2.c.f e2 = d.a.o0.a.e2.c.f.e(optJSONObject.optJSONObject("scope"));
                    if (e2 == null) {
                        d.a.o0.a.e2.c.d.j("illegal scope", Boolean.TRUE);
                        this.f44912e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f44912e.B();
                        this.f44912e.z(10001);
                        return;
                    }
                    this.f44912e.f44907g = optJSONObject.optJSONObject("opendata");
                    if (!this.f44912e.f44904d && (i2 = e2.j) < 0) {
                        if (i2 == -2) {
                            this.f44912e.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                        } else {
                            this.f44912e.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                            this.f44912e.A(10005, e2);
                        }
                        this.f44912e.B();
                        return;
                    } else if (e2.j > 0) {
                        if (!this.f44912e.f44908h || !TextUtils.equals(e2.f44831b, "mobile") || (jSONObject2 = this.f44912e.f44907g) == null || jSONObject2.optInt("errno") != 1129) {
                            this.f44912e.B();
                            return;
                        } else {
                            this.f44912e.w(e2, false);
                            return;
                        }
                    } else if (!this.f44912e.f44909i.d0()) {
                        if (!this.f44912e.f44908h && e2.c()) {
                            if (!TextUtils.equals(e2.f44831b, "mobile") || d.a.o0.a.s.a.f.f47712d.f()) {
                                this.f44912e.G();
                            } else {
                                this.f44912e.H();
                            }
                            k.N(this.f44912e.n, "phoneNumberLogin");
                            return;
                        } else if (TextUtils.equals(e2.f44831b, "mobile")) {
                            this.f44912e.v(e2);
                            return;
                        } else {
                            this.f44912e.L(e2);
                            return;
                        }
                    } else {
                        this.f44912e.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        this.f44912e.B();
                        this.f44912e.A(10005, e2);
                        return;
                    }
                }
                d.a.o0.a.e2.c.d.j("bad MaOpenData response", Boolean.TRUE);
                this.f44912e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                this.f44912e.B();
                this.f44912e.z(10001);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.e2.c.f f44913a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f44914b;

        public d(a aVar, d.a.o0.a.e2.c.f fVar) {
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
            this.f44914b = aVar;
            this.f44913a = fVar;
        }

        @Override // d.a.o0.a.p.d.n.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d.a.o0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onSuccess isBind = " + z + ". needAuth = true");
                if (z) {
                    this.f44914b.L(this.f44913a);
                } else {
                    this.f44914b.w(this.f44913a, true);
                }
            }
        }

        @Override // d.a.o0.a.p.d.n.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.o0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onFail. needAuth = true");
                this.f44914b.L(this.f44913a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f44915a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.e2.c.f f44916b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f44917c;

        /* renamed from: d.a.o0.a.e2.d.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0702a implements n.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f44918a;

            public C0702a(e eVar) {
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
                this.f44918a = eVar;
            }

            @Override // d.a.o0.a.p.d.n.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    d.a.o0.a.e0.d.g("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.f44918a.f44915a);
                    if (z) {
                        this.f44918a.f44917c.m = true;
                        this.f44918a.f44917c.K();
                        return;
                    }
                    this.f44918a.f44917c.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    this.f44918a.f44917c.B();
                }
            }

            @Override // d.a.o0.a.p.d.n.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d.a.o0.a.e0.d.g("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.f44918a.f44915a);
                    e eVar = this.f44918a;
                    if (eVar.f44915a) {
                        eVar.f44917c.L(eVar.f44916b);
                    } else {
                        eVar.f44917c.B();
                    }
                }
            }
        }

        public e(a aVar, boolean z, d.a.o0.a.e2.c.f fVar) {
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
            this.f44917c = aVar;
            this.f44915a = z;
            this.f44916b = fVar;
        }

        @Override // d.a.o0.a.p.d.n.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.e0.d.g("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.f44915a);
                d.a.o0.a.c1.a.a0().g(new C0702a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.o0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f44919a;

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
            this.f44919a = aVar;
        }

        @Override // d.a.o0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f44919a.j.b(LightappBusinessClient.SVC_ID_H5_TRANSERECORD);
                }
                this.f44919a.J(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements d.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44920e;

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
            this.f44920e = aVar;
        }

        @Override // d.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                d.a.o0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    d.a.o0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f44920e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f44920e.B();
                } else if (i2 != 0) {
                    d.a.o0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f44920e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f44920e.B();
                } else {
                    d.a.o0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f44920e.f44908h = true;
                    this.f44920e.l = true;
                    this.f44920e.K();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements d.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44921e;

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
            this.f44921e = aVar;
        }

        @Override // d.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                d.a.o0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    d.a.o0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f44921e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f44921e.B();
                } else if (i2 != 0) {
                    d.a.o0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f44921e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f44921e.B();
                } else {
                    d.a.o0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f44921e.f44908h = true;
                    this.f44921e.K();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44922e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f44923f;

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
            this.f44923f = aVar;
            this.f44922e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!this.f44922e && !this.f44923f.k) {
                    this.f44923f.B();
                } else if (iVar != null && iVar.c() && (bVar = iVar.f44872a) != null && bVar.f44877c != null) {
                    a aVar = this.f44923f;
                    aVar.f44907g = bVar.f44877c;
                    aVar.B();
                } else {
                    d.a.o0.a.q2.a aVar2 = this.f44923f.j;
                    aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar2.e("bad Accredit response");
                    this.f44923f.B();
                    this.f44923f.z(10002);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44924e;

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
            this.f44924e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c()) {
                    d.a.o0.a.q2.a aVar = this.f44924e.j;
                    aVar.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar.e("bad authorize response");
                    this.f44924e.z(10002);
                }
                this.f44924e.B();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2136876944, "Ld/a/o0/a/e2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2136876944, "Ld/a/o0/a/e2/d/a;");
                return;
            }
        }
        p = d.a.o0.a.k.f46335a;
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
        this.f44905e = new HashSet();
        this.f44906f = TaskState.INIT;
        this.f44908h = false;
        d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
        aVar.j(8L);
        aVar.e("OpenData");
        this.j = aVar;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new b(this);
        this.f44901a = activity;
        this.f44902b = str;
        this.f44903c = str2;
        this.f44904d = z;
        this.n = str3;
    }

    public static void C(Activity activity, String str, String str2, boolean z, String str3, d.a.o0.a.v2.e1.b<a> bVar) {
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
                    d.a.o0.a.e0.d.g("OpenData", "reuse session : " + aVar.toString());
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

    public final void A(int i2, d.a.o0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, fVar) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            if (Q == null) {
                if (p) {
                    Log.e("OpenData", "failedStatistic-swanApp is null");
                    return;
                }
                return;
            }
            d.a.o0.a.j2.p.d dVar = new d.a.o0.a.j2.p.d();
            dVar.o(i2);
            dVar.r(Q.N());
            dVar.q(k.m(Q.l()));
            dVar.m(Q.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Q.getAppId());
                jSONObject.put("msg", d.a.o0.a.e2.c.d.f(i2));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f44831b);
                    jSONObject.put("scopeData", fVar.f44830a);
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
                q.remove(D(this.f44902b, this.f44904d));
            }
            this.f44906f = TaskState.FINISHED;
            if (this.f44907g == null && 0 == this.j.a()) {
                if (this.f44908h) {
                    this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                } else {
                    this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                }
            }
            d.a.o0.a.e0.d.g("OpenData", "onFinish" + toString());
            d.a.o0.a.e2.c.d.k(new RunnableC0701a(this));
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.FINISHED == this.f44906f && 0 == this.j.a() && this.f44907g != null : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TaskState.FINISHED == this.f44906f && this.f44907g != null : invokeV.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f44909i.j().f(this.f44901a, null, new h(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.o0.a.c1.a.a0().j(new g(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f44908h = this.f44909i.j().e(this.f44901a);
            K();
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (TextUtils.isEmpty(this.f44903c)) {
                d.a.o0.a.e2.c.j.a a2 = d.a.o0.a.a2.d.g().y().a().b().a(this.f44901a, z, this.f44902b, this.f44903c);
                a2.r(this.n);
                a2.p(new i(this, z));
                a2.a();
                return;
            }
            d.a.o0.a.e2.c.j.b d2 = d.a.o0.a.a2.d.g().y().a().b().d(this.f44901a, true, z, new String[]{this.f44902b}, this.f44903c, true);
            d2.r(this.n);
            d2.p(new j(this));
            d2.a();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k.N(this.n, "requestOpenData");
            d.a.o0.a.e2.c.j.g c2 = d.a.o0.a.a2.d.g().y().a().b().c(this.f44901a, this.f44902b, this.f44903c, this.f44904d, this.f44908h);
            c2.r(this.n);
            c2.p(new c(this));
            c2.a();
        }
    }

    public final void L(@NonNull d.a.o0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            d.a.o0.a.e2.c.d.t(this.f44901a, this.f44909i, fVar, this.f44907g, new f(this));
        }
    }

    public final void M(d.a.o0.a.v2.e1.b<a> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            d.a.o0.a.e0.d.g("OpenData", "start session : " + this.f44902b);
            this.f44906f = TaskState.CALLING;
            this.k = TextUtils.equals(this.f44902b, "snsapi_userinfo");
            u(bVar);
            d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
            this.f44909i = i2;
            if (i2 == null) {
                d.a.o0.a.e2.c.d.j("SwanApp is null", Boolean.TRUE);
                this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                B();
                z(10001);
                return;
            }
            i2.T().f44704f.d(this.o);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f44902b, Boolean.valueOf(E()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
            if (this.f44907g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f44907g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f44906f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final a u(d.a.o0.a.v2.e1.b<a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bVar)) == null) {
            if (bVar == null) {
                return this;
            }
            synchronized (this.f44905e) {
                this.f44905e.add(bVar);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void v(d.a.o0.a.e2.c.f fVar) {
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

    public final void w(d.a.o0.a.e2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, fVar, z) == null) {
            d.a.o0.a.c1.a.a0().a(new e(this, z, fVar));
        }
    }

    public final void y(d.a.o0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            d.a.o0.a.c1.a.a0().g(new d(this, fVar));
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            A(i2, d.a.o0.a.e2.c.f.d(this.f44902b, new JSONObject()));
        }
    }
}
