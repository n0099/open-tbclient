package d.a.o0.a.e0.f.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.f1.e.c;
import d.a.o0.a.p.d.n;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static Set<String> f44495f;

    /* renamed from: g  reason: collision with root package name */
    public static final Set<String> f44496g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f44497c;

    /* renamed from: d  reason: collision with root package name */
    public int f44498d;

    /* renamed from: e  reason: collision with root package name */
    public c f44499e;

    /* renamed from: d.a.o0.a.e0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0675a implements n.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f44500a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44501b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44502c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f44503d;

        public C0675a(a aVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44503d = aVar;
            this.f44500a = context;
            this.f44501b = unitedSchemeEntity;
            this.f44502c = callbackHandler;
        }

        @Override // d.a.o0.a.p.d.n.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    d.a.o0.a.e0.d.b("LocalDebugAction", "Authentication Success");
                    a.f44496g.add(this.f44503d.o(this.f44500a));
                    this.f44503d.p(this.f44500a, this.f44501b, this.f44502c);
                    return;
                }
                d.a.o0.a.e0.d.b("LocalDebugAction", "Authentication Fail : Not developer");
                this.f44503d.w(this.f44500a, this.f44501b, 401);
            }
        }

        @Override // d.a.o0.a.p.d.n.b
        public void b(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                d.a.o0.a.e0.d.c("LocalDebugAction", "onFail : Authentication exception :", exc);
                this.f44503d.w(this.f44500a, this.f44501b, 401);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44504e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44505f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ File f44506g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44507h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44508i;
        public final /* synthetic */ a j;

        public b(a aVar, Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, str, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = aVar;
            this.f44504e = context;
            this.f44505f = str;
            this.f44506g = file;
            this.f44507h = unitedSchemeEntity;
            this.f44508i = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.x(this.f44504e, this.f44505f, this.f44506g, this.f44507h, this.f44508i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1411061531, "Ld/a/o0/a/e0/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1411061531, "Ld/a/o0/a/e0/f/d/a;");
                return;
            }
        }
        f44496g = new HashSet();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/localdebuglaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (!t()) {
                d.a.o0.a.e0.d.b("LocalDebugAction", "switch is off");
                w(context, unitedSchemeEntity, 1003);
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                this.f44499e = c.c(optParamsAsJo);
                if (d.a.o0.a.m2.b.e(0).swanCoreVersionCode < this.f44499e.f44520h) {
                    d.a.o0.a.e0.d.b("LocalDebugAction", "swan js version is low");
                    w(context, unitedSchemeEntity, 1002);
                    return false;
                } else if (!u()) {
                    d.a.o0.a.e0.d.b("LocalDebugAction", "debug model invalid");
                    w(context, unitedSchemeEntity, 202);
                    return false;
                } else if (!d.a.o0.a.s.a.f.f47712d.f() && !s().contains(d.a.o0.a.c1.a.a0().h(context)) && !f44496g.contains(o(context))) {
                    d.a.o0.a.m.b.b(this.f44499e.f44514b, new C0675a(this, context, unitedSchemeEntity, callbackHandler));
                    return true;
                } else {
                    p(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            }
            d.a.o0.a.e0.d.b("LocalDebugAction", "param is null");
            w(context, unitedSchemeEntity, 202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return d.a.o0.a.c1.a.a0().h(context) + this.f44499e.f44514b;
        }
        return (String) invokeL.objValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = d.a.o0.a.e0.f.d.b.b();
            if (b2.exists()) {
                boolean delete = b2.delete();
                d.a.o0.a.e0.d.g("LocalDebugAction", "debug bundle delete: " + delete);
            }
            this.f44497c = Executors.newFixedThreadPool(4);
            this.f44498d = 0;
            d.e().f("downloadstart");
            for (int i2 = 0; i2 < this.f44499e.f44515c.length(); i2++) {
                String a2 = this.f44499e.a(i2);
                if (TextUtils.isEmpty(a2)) {
                    int i3 = this.f44498d + 1;
                    this.f44498d = i3;
                    if (i3 >= this.f44499e.f44515c.length()) {
                        d.a.o0.a.e0.d.b("LocalDebugAction", "IPs are invalid");
                        w(context, unitedSchemeEntity, 202);
                        d.e().f("downloadfail");
                    }
                } else {
                    this.f44497c.execute(new b(this, context, a2, b2, unitedSchemeEntity, callbackHandler));
                }
            }
        }
    }

    public final void q() {
        d.a.o0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (Q = d.a.o0.a.a2.e.Q()) == null) {
            return;
        }
        d.a.o0.a.v2.f.j(Q.x());
        System.exit(0);
    }

    public final String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                if (a0.f44085b) {
                    Log.e("LocalDebugAction", "url encode fail", e2);
                    return str;
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public final Set<String> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (f44495f == null) {
                f44495f = new HashSet();
                d.a.o0.n.a b2 = d.a.o0.n.c.b();
                String string = b2 != null ? b2.j().getString("auth_white_list", "") : "";
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(string);
                } catch (JSONException unused) {
                    if (a0.f44085b) {
                        Log.d("LocalDebugAction", "JSONException: parse cloud white list");
                    }
                }
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        f44495f.add(jSONArray.optString(i2));
                    }
                }
            }
            return f44495f;
        }
        return (Set) invokeV.objValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.o0.n.a b2 = d.a.o0.n.c.b();
            return TextUtils.equals(b2 != null ? b2.j().getString("enable_local_debug_switch", "1") : "1", "1");
        }
        return invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (TextUtils.isEmpty(this.f44499e.f44513a) || TextUtils.isEmpty(this.f44499e.f44514b) || (jSONArray = this.f44499e.f44515c) == null || jSONArray.length() <= 0 || TextUtils.isEmpty(this.f44499e.f44516d)) ? false : true : invokeV.booleanValue;
    }

    public final c.a v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, unitedSchemeEntity)) == null) {
            String uri = (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) ? "" : unitedSchemeEntity.getUri().toString();
            d.a.o0.a.e0.d.g("LocalDebugAction", "local debug scheme = " + uri);
            return (c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) ((c.a) new c.a().u0(this.f44499e.f44514b)).z0(false)).K0(true)).L0(this.f44499e.f44517e)).M0(this.f44499e.f44518f)).J0(uri)).O0(this.f44499e.f44519g);
        }
        return (c.a) invokeL.objValue;
    }

    public final void w(Context context, UnitedSchemeEntity unitedSchemeEntity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, context, unitedSchemeEntity, i2) == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i2);
            d.a.o0.n.a b2 = d.a.o0.n.c.b();
            String string = b2 != null ? b2.j().getString("error_url", "") : "";
            if (TextUtils.isEmpty(string)) {
                d.a.o0.a.z1.b.f.e.g(context, "IPs are invalid ：" + i2).F();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SchemeConfig.getSchemeHead());
            sb.append("://v1/easybrowse/open?url=");
            sb.append(r(string + "?" + i2));
            SchemeRouter.invoke(context, sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c4, code lost:
        if (r6 >= r4.f44499e.f44515c.length()) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(Context context, String str, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, context, str, file, unitedSchemeEntity, callbackHandler) == null) {
            try {
                Response executeSync = d.a.o0.m.e.a.g().getRequest().url(this.f44499e.b(str)).connectionTimeout(3000).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    boolean a2 = d.a.o0.t.g.a(executeSync.body().byteStream(), file);
                    d.a.o0.a.e0.d.g("LocalDebugAction", "save debug bundle: " + a2);
                    d.e().f("downloadsuccess");
                    this.f44499e.f44517e = str;
                    context.startActivity(d.a.o0.a.f1.e.c.d1(context, v(unitedSchemeEntity)));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.f44497c != null) {
                        this.f44497c.shutdownNow();
                        this.f44497c = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        if (a0.f44085b) {
                            Log.d("LocalDebugAction", "Suicide for reload.");
                        }
                        q();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                synchronized (this) {
                    if (this.f44499e.f44515c != null) {
                        int i2 = this.f44498d + 1;
                        this.f44498d = i2;
                    }
                    d.a.o0.a.e0.d.b("LocalDebugAction", "Host IPs are invalid");
                    w(context, unitedSchemeEntity, 1001);
                    d.e().f("downloadfail");
                }
            }
        }
    }
}
