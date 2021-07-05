package d.a.q0.a.s.a.j;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
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
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.sdk.CookieManager;
import d.a.q0.a.c2.e;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.h0.g.k;
import d.a.q0.a.s.a.f;
import d.a.q0.a.s.a.g;
import d.a.q0.a.s.a.h;
import d.a.q0.a.v2.q0;
import d.a.q0.t.i;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final a f50524e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-115619900, "Ld/a/q0/a/s/a/j/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-115619900, "Ld/a/q0/a/s/a/j/b$a;");
                    return;
                }
            }
            f50524e = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k.L2();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar) {
        super(eVar, "/swanAPI/setTplBdussSync");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, entity, callbackHandler, eVar)) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(entity);
            f.f50510d.l(true);
            if (optParamsAsJo == null) {
                d.a.q0.a.m.a d2 = f.f50510d.d();
                if (d2 != null) {
                    d2.onResult(-1);
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                f.f50510d.a(g.d(), g.a());
                return false;
            }
            int optInt = optParamsAsJo.optInt("errno");
            JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
            q0.X(a.f50524e);
            if (optInt != 0) {
                d.a.q0.a.m.a d3 = f.f50510d.d();
                if (d3 != null) {
                    d3.onResult(-1);
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
                f.f50510d.a(g.d(), g.a());
                return false;
            } else if (optJSONObject != null) {
                Map<String, String> c2 = i.c(CookieManager.getInstance().getCookie(Domains.BAIDU));
                Intrinsics.checkNotNullExpressionValue(c2, "SwanAppUrlUtils.parseCookie(cookieString)");
                String str = c2.get("OPENBDUSS");
                if (!(str == null || StringsKt__StringsJVMKt.isBlank(str))) {
                    h.f50521b.c(optInt, optJSONObject);
                    d.a.q0.a.s.a.a.b(context, str);
                    f.f50510d.j(true);
                    d.a.q0.a.m.a d4 = f.f50510d.d();
                    if (d4 != null) {
                        d4.onResult(0);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, entity, 0);
                    f.f50510d.a(g.f(), g.c());
                    return true;
                }
                d.a.q0.a.m.a d5 = f.f50510d.d();
                if (d5 != null) {
                    d5.onResult(-1);
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "bduss is null");
                f.f50510d.a(g.d(), g.a());
                return false;
            } else {
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "json data is null");
                f.f50510d.a(g.d(), g.a());
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
