package d.a.q0.b.j;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.u.e.a.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class s extends d.a.q0.a.e2.c.j.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean t;
    public transient /* synthetic */ FieldHolder $fh;
    public String s;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.q0.a.e2.c.e implements d.a.q0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s f52189g;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52189g = sVar;
        }

        @Override // d.a.q0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                boolean e2 = d.a.q0.a.c1.a.a0().e(this.f52189g.m);
                if (s.t) {
                    Log.d("LoginRequest", "LoginPreparation isLogin : " + e2 + " call stack:" + Log.getStackTraceString(new Exception()));
                }
                if (!e2) {
                    this.f52189g.N().j().f(this.f52189g.m, this.f52189g.p, this);
                    return false;
                }
                s sVar = this.f52189g;
                sVar.i(new c(sVar, null));
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.q0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.q0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    d.a.q0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else if (i2 != 0) {
                    d.a.q0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else {
                    d.a.q0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    s sVar = this.f52189g;
                    sVar.i(new c(sVar, null));
                    d();
                }
            }
        }

        public /* synthetic */ b(s sVar, a aVar) {
            this(sVar);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.q0.a.e2.c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ s f52190g;

        /* loaded from: classes8.dex */
        public class a implements d.a.q0.a.v2.e1.b<Bundle> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f52191e;

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
                this.f52191e = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                    if (bundle == null) {
                        d.a.q0.a.e2.c.d.j("null stoken", Boolean.TRUE);
                        this.f52191e.e(new OAuthException(10001));
                        return;
                    }
                    String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE, "");
                    if (!TextUtils.isEmpty(string)) {
                        this.f52191e.f52190g.s = string;
                        this.f52191e.d();
                        return;
                    }
                    d.a.q0.a.e2.c.d.j("empty stoken", Boolean.TRUE);
                    this.f52191e.e(new OAuthException(10001));
                }
            }
        }

        public /* synthetic */ c(s sVar, a aVar) {
            this(sVar);
        }

        @Override // d.a.q0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.q0.b.j.a.t(this.f52190g.m, new a(this), BdZeusUtil.URL_KEY_MACHINE);
                return false;
            }
            return invokeV.booleanValue;
        }

        public c(s sVar) {
            c.C0951c c0951c;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52190g = sVar;
            if (sVar.o == null || (c0951c = sVar.n) == null || !c0951c.f50762a) {
                return;
            }
            long j = c0951c.f50763b;
            if (s.t) {
                Log.d("LoginRequest", "send timeout " + j + "ms msg");
            }
            sVar.o.sendEmptyMessageDelayed(1, j < 0 ? 0L : j);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(863745925, "Ld/a/q0/b/j/s;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(863745925, "Ld/a/q0/b/j/s;");
                return;
            }
        }
        t = d.a.q0.a.k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Activity activity, c.C0951c c0951c, Bundle bundle) {
        super(activity, c0951c, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, c0951c, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Activity) objArr2[0], (c.C0951c) objArr2[1], (Bundle) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        y();
        z();
    }

    @Override // d.a.q0.a.e2.c.j.f
    @NonNull
    public d.a.q0.a.e2.c.e R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this, null) : (d.a.q0.a.e2.c.e) invokeV.objValue;
    }

    @Override // d.a.q0.a.e2.c.j.f, d.a.q0.a.e2.c.c
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                boolean isEmpty = TextUtils.isEmpty(this.q);
                jSONObject.put("ma_id", isEmpty ? N().D() : this.q);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_key", isEmpty ? N().D() : this.q);
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", d.a.q0.a.e2.c.d.g());
                jSONObject2.put("stoken", this.s);
                String l = d.a.q0.a.c1.a.n().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
            } catch (JSONException e2) {
                if (t) {
                    e2.printStackTrace();
                }
            }
            w("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }
}
