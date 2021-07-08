package d.a.n0.a.e2.d;

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
import d.a.n0.a.e2.c.j.a;
import d.a.n0.a.e2.c.j.b;
import d.a.n0.a.j2.k;
import d.a.n0.a.p.d.n;
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
    public final Activity f44397a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44398b;

    /* renamed from: c  reason: collision with root package name */
    public final String f44399c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44400d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<d.a.n0.a.v2.e1.b<a>> f44401e;

    /* renamed from: f  reason: collision with root package name */
    public TaskState f44402f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f44403g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44404h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.a.a2.e f44405i;
    public final d.a.n0.a.q2.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public final d.a.n0.a.v2.d1.a o;

    /* renamed from: d.a.n0.a.e2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0692a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44406e;

        public RunnableC0692a(a aVar) {
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
            this.f44406e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f44406e.f44401e) {
                    for (d.a.n0.a.v2.e1.b bVar : this.f44406e.f44401e) {
                        bVar.onCallback(this.f44406e);
                    }
                    this.f44406e.f44401e.clear();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.n0.a.v2.d1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f44407f;

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
            this.f44407f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44407f.I();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44408e;

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
            this.f44408e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<JSONObject> iVar) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && (jSONObject = iVar.f44368a) != null) {
                    d.a.n0.a.e0.d.a("OpenData", "opendata=", jSONObject);
                    this.f44408e.j.b(iVar.f44368a.optInt("errno", 10001));
                    this.f44408e.j.e(iVar.f44368a.optString("errmsg", "internal error"));
                    if (0 != this.f44408e.j.g()) {
                        d.a.n0.a.e2.c.d.j("by errno", Boolean.TRUE);
                        this.f44408e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f44408e.B();
                        this.f44408e.z(10001);
                        return;
                    }
                    JSONObject optJSONObject = iVar.f44368a.optJSONObject("data");
                    if (optJSONObject == null) {
                        d.a.n0.a.e2.c.d.j("by data parse", Boolean.TRUE);
                        this.f44408e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f44408e.B();
                        this.f44408e.z(10001);
                        return;
                    }
                    d.a.n0.a.e2.c.f e2 = d.a.n0.a.e2.c.f.e(optJSONObject.optJSONObject("scope"));
                    if (e2 == null) {
                        d.a.n0.a.e2.c.d.j("illegal scope", Boolean.TRUE);
                        this.f44408e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                        this.f44408e.B();
                        this.f44408e.z(10001);
                        return;
                    }
                    this.f44408e.f44403g = optJSONObject.optJSONObject("opendata");
                    if (!this.f44408e.f44400d && (i2 = e2.j) < 0) {
                        if (i2 == -2) {
                            this.f44408e.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                        } else {
                            this.f44408e.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                            this.f44408e.A(10005, e2);
                        }
                        this.f44408e.B();
                        return;
                    } else if (e2.j > 0) {
                        if (!this.f44408e.f44404h || !TextUtils.equals(e2.f44327b, "mobile") || (jSONObject2 = this.f44408e.f44403g) == null || jSONObject2.optInt("errno") != 1129) {
                            this.f44408e.B();
                            return;
                        } else {
                            this.f44408e.w(e2, false);
                            return;
                        }
                    } else if (!this.f44408e.f44405i.d0()) {
                        if (!this.f44408e.f44404h && e2.c()) {
                            if (!TextUtils.equals(e2.f44327b, "mobile") || d.a.n0.a.s.a.f.f47208d.f()) {
                                this.f44408e.G();
                            } else {
                                this.f44408e.H();
                            }
                            k.N(this.f44408e.n, "phoneNumberLogin");
                            return;
                        } else if (TextUtils.equals(e2.f44327b, "mobile")) {
                            this.f44408e.v(e2);
                            return;
                        } else {
                            this.f44408e.L(e2);
                            return;
                        }
                    } else {
                        this.f44408e.j.b(LightappBusinessClient.SVC_ID_H5_MYBANKCARD);
                        this.f44408e.B();
                        this.f44408e.A(10005, e2);
                        return;
                    }
                }
                d.a.n0.a.e2.c.d.j("bad MaOpenData response", Boolean.TRUE);
                this.f44408e.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                this.f44408e.B();
                this.f44408e.z(10001);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements n.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.e2.c.f f44409a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f44410b;

        public d(a aVar, d.a.n0.a.e2.c.f fVar) {
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
            this.f44410b = aVar;
            this.f44409a = fVar;
        }

        @Override // d.a.n0.a.p.d.n.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                d.a.n0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onSuccess isBind = " + z + ". needAuth = true");
                if (z) {
                    this.f44410b.L(this.f44409a);
                } else {
                    this.f44410b.w(this.f44409a, true);
                }
            }
        }

        @Override // d.a.n0.a.p.d.n.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.n0.a.e0.d.g("OpenData", "checkPhoneNumberStatus onFail. needAuth = true");
                this.f44410b.L(this.f44409a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f44411a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.e2.c.f f44412b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f44413c;

        /* renamed from: d.a.n0.a.e2.d.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0693a implements n.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f44414a;

            public C0693a(e eVar) {
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
                this.f44414a = eVar;
            }

            @Override // d.a.n0.a.p.d.n.c
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    d.a.n0.a.e0.d.g("OpenData", "bindPhoneNumber check onSuccess isBind =" + z + ". needAuth = " + this.f44414a.f44411a);
                    if (z) {
                        this.f44414a.f44413c.m = true;
                        this.f44414a.f44413c.K();
                        return;
                    }
                    this.f44414a.f44413c.j.b(LightappBusinessClient.SVC_ID_H5_SECURITCENTER);
                    this.f44414a.f44413c.B();
                }
            }

            @Override // d.a.n0.a.p.d.n.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d.a.n0.a.e0.d.g("OpenData", "bindPhoneNumber check onFail. needAuth = " + this.f44414a.f44411a);
                    e eVar = this.f44414a;
                    if (eVar.f44411a) {
                        eVar.f44413c.L(eVar.f44412b);
                    } else {
                        eVar.f44413c.B();
                    }
                }
            }
        }

        public e(a aVar, boolean z, d.a.n0.a.e2.c.f fVar) {
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
            this.f44413c = aVar;
            this.f44411a = z;
            this.f44412b = fVar;
        }

        @Override // d.a.n0.a.p.d.n.a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.e0.d.g("OpenData", "bindPhoneNumber onFinish. needAuth = " + this.f44411a);
                d.a.n0.a.c1.a.a0().g(new C0693a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.n0.a.e2.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f44415a;

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
            this.f44415a = aVar;
        }

        @Override // d.a.n0.a.e2.c.a
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f44415a.j.b(LightappBusinessClient.SVC_ID_H5_TRANSERECORD);
                }
                this.f44415a.J(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements d.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44416e;

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
            this.f44416e = aVar;
        }

        @Override // d.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                d.a.n0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    d.a.n0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f44416e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f44416e.B();
                } else if (i2 != 0) {
                    d.a.n0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f44416e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f44416e.B();
                } else {
                    d.a.n0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f44416e.f44404h = true;
                    this.f44416e.l = true;
                    this.f44416e.K();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements d.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44417e;

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
            this.f44417e = aVar;
        }

        @Override // d.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                d.a.n0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    d.a.n0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    this.f44417e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f44417e.B();
                } else if (i2 != 0) {
                    d.a.n0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    this.f44417e.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                    this.f44417e.B();
                } else {
                    d.a.n0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    this.f44417e.f44404h = true;
                    this.f44417e.K();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44418e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f44419f;

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
            this.f44419f = aVar;
            this.f44418e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!this.f44418e && !this.f44419f.k) {
                    this.f44419f.B();
                } else if (iVar != null && iVar.c() && (bVar = iVar.f44368a) != null && bVar.f44373c != null) {
                    a aVar = this.f44419f;
                    aVar.f44403g = bVar.f44373c;
                    aVar.B();
                } else {
                    d.a.n0.a.q2.a aVar2 = this.f44419f.j;
                    aVar2.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar2.e("bad Accredit response");
                    this.f44419f.B();
                    this.f44419f.z(10002);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f44420e;

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
            this.f44420e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c()) {
                    d.a.n0.a.q2.a aVar = this.f44420e.j;
                    aVar.b(LightappBusinessClient.SVC_ID_H5_BALANCE);
                    aVar.e("bad authorize response");
                    this.f44420e.z(10002);
                }
                this.f44420e.B();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2007794225, "Ld/a/n0/a/e2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2007794225, "Ld/a/n0/a/e2/d/a;");
                return;
            }
        }
        p = d.a.n0.a.k.f45831a;
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
        this.f44401e = new HashSet();
        this.f44402f = TaskState.INIT;
        this.f44404h = false;
        d.a.n0.a.q2.a aVar = new d.a.n0.a.q2.a();
        aVar.j(8L);
        aVar.e("OpenData");
        this.j = aVar;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = new b(this);
        this.f44397a = activity;
        this.f44398b = str;
        this.f44399c = str2;
        this.f44400d = z;
        this.n = str3;
    }

    public static void C(Activity activity, String str, String str2, boolean z, String str3, d.a.n0.a.v2.e1.b<a> bVar) {
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
                    d.a.n0.a.e0.d.g("OpenData", "reuse session : " + aVar.toString());
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

    public final void A(int i2, d.a.n0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, fVar) == null) {
            d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
            if (Q == null) {
                if (p) {
                    Log.e("OpenData", "failedStatistic-swanApp is null");
                    return;
                }
                return;
            }
            d.a.n0.a.j2.p.d dVar = new d.a.n0.a.j2.p.d();
            dVar.o(i2);
            dVar.r(Q.N());
            dVar.q(k.m(Q.l()));
            dVar.m(Q.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Q.getAppId());
                jSONObject.put("msg", d.a.n0.a.e2.c.d.f(i2));
                if (fVar != null) {
                    jSONObject.put("scope", fVar.f44327b);
                    jSONObject.put("scopeData", fVar.f44326a);
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
                q.remove(D(this.f44398b, this.f44400d));
            }
            this.f44402f = TaskState.FINISHED;
            if (this.f44403g == null && 0 == this.j.a()) {
                if (this.f44404h) {
                    this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                } else {
                    this.j.b(LightappBusinessClient.SVC_ID_H5_COUPON);
                }
            }
            d.a.n0.a.e0.d.g("OpenData", "onFinish" + toString());
            d.a.n0.a.e2.c.d.k(new RunnableC0692a(this));
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TaskState.FINISHED == this.f44402f && 0 == this.j.a() && this.f44403g != null : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TaskState.FINISHED == this.f44402f && this.f44403g != null : invokeV.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f44405i.j().f(this.f44397a, null, new h(this));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.n0.a.c1.a.a0().j(new g(this));
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f44404h = this.f44405i.j().e(this.f44397a);
            K();
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (TextUtils.isEmpty(this.f44399c)) {
                d.a.n0.a.e2.c.j.a a2 = d.a.n0.a.a2.d.g().y().a().b().a(this.f44397a, z, this.f44398b, this.f44399c);
                a2.r(this.n);
                a2.p(new i(this, z));
                a2.a();
                return;
            }
            d.a.n0.a.e2.c.j.b d2 = d.a.n0.a.a2.d.g().y().a().b().d(this.f44397a, true, z, new String[]{this.f44398b}, this.f44399c, true);
            d2.r(this.n);
            d2.p(new j(this));
            d2.a();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            k.N(this.n, "requestOpenData");
            d.a.n0.a.e2.c.j.g c2 = d.a.n0.a.a2.d.g().y().a().b().c(this.f44397a, this.f44398b, this.f44399c, this.f44400d, this.f44404h);
            c2.r(this.n);
            c2.p(new c(this));
            c2.a();
        }
    }

    public final void L(@NonNull d.a.n0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            d.a.n0.a.e2.c.d.t(this.f44397a, this.f44405i, fVar, this.f44403g, new f(this));
        }
    }

    public final void M(d.a.n0.a.v2.e1.b<a> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            d.a.n0.a.e0.d.g("OpenData", "start session : " + this.f44398b);
            this.f44402f = TaskState.CALLING;
            this.k = TextUtils.equals(this.f44398b, "snsapi_userinfo");
            u(bVar);
            d.a.n0.a.a2.e i2 = d.a.n0.a.a2.e.i();
            this.f44405i = i2;
            if (i2 == null) {
                d.a.n0.a.e2.c.d.j("SwanApp is null", Boolean.TRUE);
                this.j.b(LightappBusinessClient.SVC_ID_H5_HOMEPAGE);
                B();
                z(10001);
                return;
            }
            i2.T().f44200f.d(this.o);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(Locale.getDefault(), "%s(%s) isResultOK(%s) %s\n", "OpenData", this.f44398b, Boolean.valueOf(E()), super.toString()));
            sb.append(String.format(Locale.getDefault(), "Err(%s)\n", this.j));
            if (this.f44403g != null) {
                sb.append(String.format(Locale.getDefault(), "Data(%s)\n", this.f44403g));
            }
            sb.append(String.format(Locale.getDefault(), "state=%s\n", this.f44402f));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final a u(d.a.n0.a.v2.e1.b<a> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, bVar)) == null) {
            if (bVar == null) {
                return this;
            }
            synchronized (this.f44401e) {
                this.f44401e.add(bVar);
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void v(d.a.n0.a.e2.c.f fVar) {
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

    public final void w(d.a.n0.a.e2.c.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, fVar, z) == null) {
            d.a.n0.a.c1.a.a0().a(new e(this, z, fVar));
        }
    }

    public final void y(d.a.n0.a.e2.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) {
            d.a.n0.a.c1.a.a0().g(new d(this, fVar));
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            A(i2, d.a.n0.a.e2.c.f.d(this.f44398b, new JSONObject()));
        }
    }
}
