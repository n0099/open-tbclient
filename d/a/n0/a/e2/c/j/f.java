package d.a.n0.a.e2.c.j;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.j2.k;
import d.a.n0.a.u.e.a.c;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends h<d> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity m;
    public c.C0900c n;
    public c o;
    public Bundle p;
    public String q;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.n0.a.e2.c.e implements d.a.n0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f44384g;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44384g = fVar;
        }

        @Override // d.a.n0.a.e2.c.e
        public boolean f() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.n0.a.m.b j = this.f44384g.N().j();
                boolean e2 = j.e(this.f44384g.m);
                if (f.r) {
                    Log.d("LoginRequest", "LoginPreparation isLogin : " + e2 + " call stack:" + Log.getStackTraceString(new Exception()));
                }
                if (!e2) {
                    k.N(this.f44384g.l, "passLogin");
                    f fVar = this.f44384g;
                    j.f(fVar.m, fVar.p, this);
                }
                return e2;
            }
            return invokeV.booleanValue;
        }

        @Override // d.a.n0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.n0.a.e2.c.d.j("onResult :: " + i2, Boolean.FALSE);
                if (i2 == -2) {
                    d.a.n0.a.e2.c.d.j("login error ERR_BY_UESR_REFUSE", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else if (i2 != 0) {
                    d.a.n0.a.e2.c.d.j("login error ERR_BY_LOGIN", Boolean.TRUE);
                    e(new OAuthException(10004));
                } else {
                    d.a.n0.a.e2.c.d.j("Login Preparation ok, is already login", Boolean.FALSE);
                    d();
                }
            }
        }

        public /* synthetic */ b(f fVar, a aVar) {
            this(fVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<f> f44385a;

        public /* synthetic */ c(Looper looper, f fVar, a aVar) {
            this(looper, fVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f fVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (fVar = this.f44385a.get()) != null && message.what == 1) {
                if (f.r) {
                    Log.d("LoginRequest", "handleMessage: timeout");
                }
                d.a.n0.a.e2.c.d.j("request timeout", Boolean.TRUE);
                fVar.e(new OAuthException(10002));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, f fVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44385a = new WeakReference<>(fVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f44386a;

        public /* synthetic */ d(String str, a aVar) {
            this(str);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("Result code(%s)", this.f44386a) : (String) invokeV.objValue;
        }

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44386a = str == null ? "" : str;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1021564978, "Ld/a/n0/a/e2/c/j/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1021564978, "Ld/a/n0/a/e2/c/j/f;");
                return;
            }
        }
        r = d.a.n0.a.k.f45831a;
    }

    public f(Activity activity, c.C0900c c0900c, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, c0900c, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = activity;
        this.n = c0900c;
        this.o = new c(Looper.getMainLooper(), this, null);
        if (bundle != null && bundle.containsKey("__plugin__")) {
            this.q = bundle.getString("__plugin__");
            bundle.remove("__plugin__");
            d.a.n0.a.e0.d.h("LoginRequest", "Info: Remove previous account.");
        }
        this.p = bundle;
    }

    @Override // d.a.n0.a.e2.c.j.h
    public SwanInterfaceType A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SwanInterfaceType.LOGIN : (SwanInterfaceType) invokeV.objValue;
    }

    @NonNull
    public d.a.n0.a.e2.c.e R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this, null) : (d.a.n0.a.e2.c.e) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.e2.c.c
    /* renamed from: S */
    public d n(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            JSONObject c2 = d.a.n0.a.e2.c.d.c(jSONObject);
            int optInt = c2.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    d.a.n0.a.e2.c.d.l(c2);
                    d.a.n0.a.e2.c.d.s("LoginRequest", c2.toString());
                }
                if (r) {
                    throw new OAuthException(c2.optString("errmsg"), optInt);
                }
            }
            JSONObject jSONObject2 = c2.getJSONObject("data");
            return new d(jSONObject2 != null ? jSONObject2.optString("code", "") : "", null);
        }
        return (d) invokeL.objValue;
    }

    @Override // d.a.n0.a.e2.c.c
    public void e(@Nullable Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
            super.e(exc);
            if (r) {
                Log.d("LoginRequest", "finish: remove timeout msg");
            }
            this.o.removeMessages(1);
        }
    }

    @Override // d.a.n0.a.e2.c.c
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                boolean isEmpty = TextUtils.isEmpty(this.q);
                jSONObject.put("ma_id", isEmpty ? N().D() : this.q);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("app_key", isEmpty ? N().D() : this.q);
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", d.a.n0.a.e2.c.d.g());
                String l = d.a.n0.a.c1.a.n().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            w("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.e2.c.c
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            i(R());
            return super.l();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, hVar)) == null) ? d.a.n0.a.c1.a.n().r(this.m, hVar.C()) : (HttpRequest) invokeL.objValue;
    }
}
