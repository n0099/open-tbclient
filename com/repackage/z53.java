package com.repackage;

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
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z53 extends f63<e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final String[] m;
    public final Context n;
    public boolean o;
    public boolean p;
    public boolean q;
    public u53 r;
    public final String s;
    public final boolean t;
    public boolean u;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends t53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z53 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ u53 b;
            public final /* synthetic */ b c;

            /* renamed from: com.repackage.z53$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0570a implements p53 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0570a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // com.repackage.p53
                public void onResult(boolean z) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                        z53 z53Var = this.a.c.c;
                        z53Var.p = z;
                        z53Var.u = !z;
                        this.a.c.d();
                    }
                }
            }

            public a(b bVar, Activity activity, u53 u53Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, activity, u53Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = activity;
                this.b = u53Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.isFinishing()) {
                    return;
                }
                s53.u(this.a, this.c.c.M(), this.b, null, new C0570a(this));
            }
        }

        public b(z53 z53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z53Var;
        }

        @Override // com.repackage.t53
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                z53 z53Var = this.c;
                u53 u53Var = z53Var.r;
                if (u53Var == null) {
                    s53.k("Illegal ScopeInfo", Boolean.TRUE);
                    this.c.d(new OAuthException(10001));
                    n73.r(10001, null);
                    return true;
                } else if (u53Var.d) {
                    z53Var.d(new OAuthException(10005));
                    n73.r(10005, u53Var);
                    return true;
                } else if (z53Var.t || !z53Var.p) {
                    return true;
                } else {
                    if (!z53Var.o && u53Var.j < 0) {
                        z53Var.r(new e(false, null));
                        this.c.d(new OAuthException(10005));
                        return true;
                    } else if (u53Var.j > 0) {
                        this.c.r(new e(true, null));
                        this.c.c();
                        return true;
                    } else if (this.c.M().m0()) {
                        s53.k("this operation does not supported when app is invisible.", Boolean.TRUE);
                        this.c.d(new OAuthException(10005));
                        return true;
                    } else {
                        Activity Y = this.c.Y();
                        if (Y == null) {
                            s53.k("login error context is not activity.", Boolean.TRUE);
                            this.c.d(new OAuthException(10005));
                            return true;
                        }
                        s53.l(new a(this, Y, u53Var));
                        return false;
                    }
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends t53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z53 c;

        /* loaded from: classes7.dex */
        public class a implements nf3<u53> {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.nf3
            /* renamed from: a */
            public void onCallback(u53 u53Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, u53Var) == null) {
                    if (r53.f) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ListPreparation result: ");
                        sb.append(u53Var == null ? StringUtil.NULL_STRING : u53Var);
                        Log.i("aiapps-oauth", sb.toString());
                    }
                    c cVar = this.a;
                    cVar.c.r = u53Var;
                    if (u53Var == null) {
                        cVar.e(new Exception("no such scope"));
                        return;
                    }
                    if (u53Var.e()) {
                        z53 z53Var = this.a.c;
                        if (!z53Var.q) {
                            z53Var.h(new d(z53Var, null));
                            this.a.d();
                        }
                    }
                    z53 z53Var2 = this.a.c;
                    z53Var2.h(new b(z53Var2));
                    this.a.d();
                }
            }
        }

        public c(z53 z53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z53Var;
        }

        @Override // com.repackage.t53
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String[] strArr = this.c.m;
                if (strArr != null && strArr.length <= 1) {
                    ss2.i(strArr[0], new a(this));
                    return false;
                }
                d();
                return true;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ c(z53 z53Var, a aVar) {
            this(z53Var);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends t53 implements gh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z53 c;

        public d(z53 z53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z53Var;
        }

        @Override // com.repackage.t53
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                z53 z53Var = this.c;
                z53Var.q = true;
                if (z53Var.M().M().e(this.c.n)) {
                    s53.k("LoginPreparation: isLogin true", Boolean.FALSE);
                    z53 z53Var2 = this.c;
                    z53Var2.h(new c(z53Var2, null));
                    return true;
                }
                u03 M = this.c.M();
                if (M.m0()) {
                    s53.k("this operation does not supported when app is invisible.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                }
                Activity Y = this.c.Y();
                if (Y == null) {
                    s53.k("login error context is not activity.", Boolean.TRUE);
                    e(new OAuthException(10004));
                    return true;
                }
                if (!t03.J().r().M().e(Y)) {
                    n73.T(this.c.l, "passLogin");
                }
                M.M().f(Y, null, this);
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.gh1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                s53.k("onResult :: " + i, Boolean.FALSE);
                if (i == -2) {
                    s53.k("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else if (i != 0) {
                    s53.k("login error ERR_BY_LOGIN", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else {
                    s53.k("Login Preparation ok, is already login", Boolean.FALSE);
                    z53 z53Var = this.c;
                    z53Var.h(new c(z53Var, null));
                    d();
                }
            }
        }

        public /* synthetic */ d(z53 z53Var, a aVar) {
            this(z53Var);
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final boolean b;

        public e(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str == null ? "" : str;
            this.b = z;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("Result(%b):%s", Boolean.valueOf(this.b), this.a) : (String) invokeV.objValue;
        }
    }

    public z53(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2), strArr, str, Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    @Override // com.repackage.f63
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.I();
            if (this.u) {
                d(new OAuthException(10003));
                this.u = false;
            }
            if (TextUtils.isEmpty(this.s)) {
                ss2.f();
            }
        }
    }

    public Activity Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = this.n;
            if (context instanceof Activity) {
                return (Activity) context;
            }
            u03 a0 = u03.a0();
            if (a0 == null) {
                return null;
            }
            return a0.x();
        }
        return (Activity) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.r53
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: Z */
    public e m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            JSONObject c2 = s53.c(jSONObject);
            int optInt = c2.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    s53.m(c2);
                    s53.t("Authorize", c2.toString());
                }
                if (r53.f) {
                    throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
                }
            }
            JSONObject jSONObject2 = c2.getJSONObject("data");
            return new e(this.p, jSONObject2 != null ? jSONObject2.optString("code", "") : "");
        }
        return (e) invokeL.objValue;
    }

    @Override // com.repackage.r53
    public boolean j() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", M().N());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, M().N());
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", s53.g());
                String l = bk2.o().l();
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
                if (r53.f) {
                    e2.printStackTrace();
                }
            }
            v("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.r53
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            h(new c(this, null));
            return super.k();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.f63
    public HttpRequest w(f63 f63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f63Var)) == null) ? bk2.o().F(this.n, f63Var.B()) : (HttpRequest) invokeL.objValue;
    }

    @Override // com.repackage.f63
    public SwanInterfaceType z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? SwanInterfaceType.AUTHORIZE : (SwanInterfaceType) invokeV.objValue;
    }
}
