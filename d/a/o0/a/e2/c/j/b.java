package d.a.o0.a.e2.c.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends h<e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final String[] m;
    public final Context n;
    public boolean o;
    public boolean p;
    public boolean q;
    public d.a.o0.a.e2.c.f r;
    public final String s;
    public final boolean t;
    public boolean u;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.o0.a.e2.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0699b extends d.a.o0.a.e2.c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f44878g;

        /* renamed from: d.a.o0.a.e2.c.j.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Activity f44879e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.a.e2.c.f f44880f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C0699b f44881g;

            /* renamed from: d.a.o0.a.e2.c.j.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0700a implements d.a.o0.a.e2.c.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f44882a;

                public C0700a(a aVar) {
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
                    this.f44882a = aVar;
                }

                @Override // d.a.o0.a.e2.c.a
                public void onResult(boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                        b bVar = this.f44882a.f44881g.f44878g;
                        bVar.p = z;
                        bVar.u = !z;
                        this.f44882a.f44881g.d();
                    }
                }
            }

            public a(C0699b c0699b, Activity activity, d.a.o0.a.e2.c.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0699b, activity, fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44881g = c0699b;
                this.f44879e = activity;
                this.f44880f = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f44879e.isFinishing()) {
                    return;
                }
                d.a.o0.a.e2.c.d.t(this.f44879e, this.f44881g.f44878g.N(), this.f44880f, null, new C0700a(this));
            }
        }

        public C0699b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44878g = bVar;
        }

        @Override // d.a.o0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.f44878g;
                d.a.o0.a.e2.c.f fVar = bVar.r;
                if (fVar == null) {
                    d.a.o0.a.e2.c.d.j("Illegal ScopeInfo", Boolean.TRUE);
                    this.f44878g.e(new OAuthException(10001));
                    k.p(10001, null);
                    return true;
                } else if (fVar.f44833d) {
                    bVar.e(new OAuthException(10005));
                    k.p(10005, fVar);
                    return true;
                } else if (bVar.t || !bVar.p) {
                    return true;
                } else {
                    if (!bVar.o && fVar.j < 0) {
                        bVar.s(new e(false, null));
                        this.f44878g.e(new OAuthException(10005));
                        return true;
                    } else if (fVar.j > 0) {
                        this.f44878g.s(new e(true, null));
                        this.f44878g.d();
                        return true;
                    } else if (this.f44878g.N().d0()) {
                        d.a.o0.a.e2.c.d.j("this operation does not supported when app is invisible.", Boolean.TRUE);
                        this.f44878g.e(new OAuthException(10005));
                        return true;
                    } else {
                        Activity Z = this.f44878g.Z();
                        if (Z == null) {
                            d.a.o0.a.e2.c.d.j("login error context is not activity.", Boolean.TRUE);
                            this.f44878g.e(new OAuthException(10005));
                            return true;
                        }
                        d.a.o0.a.e2.c.d.k(new a(this, Z, fVar));
                        return false;
                    }
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends d.a.o0.a.e2.c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f44883g;

        /* loaded from: classes7.dex */
        public class a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.f> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f44884e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44884e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.o0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(d.a.o0.a.e2.c.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                    if (d.a.o0.a.e2.c.c.f44810f) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ListPreparation result: ");
                        sb.append(fVar == null ? StringUtil.NULL_STRING : fVar);
                        Log.i("aiapps-oauth", sb.toString());
                    }
                    c cVar = this.f44884e;
                    cVar.f44883g.r = fVar;
                    if (fVar == null) {
                        cVar.e(new Exception("no such scope"));
                        return;
                    }
                    if (fVar.c()) {
                        b bVar = this.f44884e.f44883g;
                        if (!bVar.q) {
                            bVar.i(new d(bVar, null));
                            this.f44884e.d();
                        }
                    }
                    b bVar2 = this.f44884e.f44883g;
                    bVar2.i(new C0699b(bVar2));
                    this.f44884e.d();
                }
            }
        }

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44883g = bVar;
        }

        @Override // d.a.o0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String[] strArr = this.f44883g.m;
                if (strArr != null && strArr.length <= 1) {
                    d.a.o0.a.n1.q.c.a.i(strArr[0], new a(this));
                    return false;
                }
                d();
                return true;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.o0.a.e2.c.e implements d.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f44885g;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44885g = bVar;
        }

        @Override // d.a.o0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b bVar = this.f44885g;
                bVar.q = true;
                if (bVar.N().j().e(this.f44885g.n)) {
                    d.a.o0.a.e2.c.d.j("LoginPreparation: isLogin true", Boolean.FALSE);
                    b bVar2 = this.f44885g;
                    bVar2.i(new c(bVar2, null));
                    return true;
                }
                d.a.o0.a.a2.e N = this.f44885g.N();
                if (N.d0()) {
                    d.a.o0.a.e2.c.d.j("this operation does not supported when app is invisible.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                }
                Activity Z = this.f44885g.Z();
                if (Z == null) {
                    d.a.o0.a.e2.c.d.j("login error context is not activity.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                }
                if (!d.a.o0.a.a2.d.g().r().j().e(Z)) {
                    k.N(this.f44885g.l, "passLogin");
                }
                N.j().f(Z, null, this);
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.o0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    d.a.o0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else if (i2 != 0) {
                    d.a.o0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else {
                    d.a.o0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    b bVar = this.f44885g;
                    bVar.i(new c(bVar, null));
                    d();
                }
            }
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f44886a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f44887b;

        public e(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44886a = str == null ? "" : str;
            this.f44887b = z;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("Result(%b):%s", Boolean.valueOf(this.f44887b), this.f44886a) : (String) invokeV.objValue;
        }
    }

    public b(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), strArr, str, Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.u = false;
        this.n = context;
        this.o = z;
        this.m = strArr == null ? new String[0] : strArr;
        this.s = str;
        this.p = z2;
        this.t = z3;
    }

    @Override // d.a.o0.a.e2.c.j.h
    public SwanInterfaceType A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SwanInterfaceType.AUTHORIZE : (SwanInterfaceType) invokeV.objValue;
    }

    @Override // d.a.o0.a.e2.c.j.h
    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.J();
            if (this.u) {
                e(new OAuthException(10003));
                this.u = false;
            }
            if (TextUtils.isEmpty(this.s)) {
                d.a.o0.a.n1.q.c.a.f();
            }
        }
    }

    public Activity Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context context = this.n;
            if (context instanceof Activity) {
                return (Activity) context;
            }
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            if (Q == null) {
                return null;
            }
            return Q.x();
        }
        return (Activity) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.a.e2.c.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: a0 */
    public e n(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            JSONObject c2 = d.a.o0.a.e2.c.d.c(jSONObject);
            int optInt = c2.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    d.a.o0.a.e2.c.d.l(c2);
                    d.a.o0.a.e2.c.d.s("Authorize", c2.toString());
                }
                if (d.a.o0.a.e2.c.c.f44810f) {
                    throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
                }
            }
            JSONObject jSONObject2 = c2.getJSONObject("data");
            return new e(this.p, jSONObject2 != null ? jSONObject2.optString("code", "") : "");
        }
        return (e) invokeL.objValue;
    }

    @Override // d.a.o0.a.e2.c.c
    public boolean k() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", N().D());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_key", N().D());
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", d.a.o0.a.e2.c.d.g());
                String l = d.a.o0.a.c1.a.n().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                for (String str : this.m) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("permit", Boolean.toString(this.p));
                    jSONObject3.put(str, jSONObject4);
                }
                jSONObject.put("accredits", jSONObject3);
                if (!TextUtils.isEmpty(this.s)) {
                    jSONObject.put("provider_appkey", this.s);
                }
            } catch (JSONException e2) {
                if (d.a.o0.a.e2.c.c.f44810f) {
                    e2.printStackTrace();
                }
            }
            w("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.o0.a.e2.c.c
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            i(new c(this, null));
            return super.l();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.o0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hVar)) == null) ? d.a.o0.a.c1.a.n().C(this.n, hVar.C()) : (HttpRequest) invokeL.objValue;
    }
}
