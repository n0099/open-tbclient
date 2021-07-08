package d.a.n0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a1.e;
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.e2.c.j.b;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46672e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46673f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46674g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46675h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f46676i;

        public a(d dVar, CallbackHandler callbackHandler, String str, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, callbackHandler, str, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46676i = dVar;
            this.f46672e = callbackHandler;
            this.f46673f = str;
            this.f46674g = context;
            this.f46675h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.n0.a.e2.c.d.h(iVar)) {
                    this.f46676i.l(this.f46674g, this.f46675h, this.f46673f, this.f46672e);
                } else {
                    d.a.n0.a.e2.c.d.p(iVar, this.f46672e, this.f46673f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46677a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46678b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46679c;

        public b(d dVar, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46677a = context;
            this.f46678b = callbackHandler;
            this.f46679c = str;
        }

        @Override // d.a.n0.a.a1.e.c
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // d.a.n0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.n0.a.z1.b.f.e.f(this.f46677a, d.a.n0.a.h.aiapps_debug_swan_core_download_failed).F();
                this.f46678b.handleSchemeDispatchCallback(this.f46679c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // d.a.n0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File d2 = d.a.n0.a.m2.d.a.d();
                File c2 = d.a.n0.a.m2.d.a.c();
                if (a0.f43581b) {
                    Log.d("replaceSwanCore", "swanCoreZipFile: " + d2 + " swanCoreDir: " + c2);
                }
                if (d2.exists() && d.a.n0.t.d.T(d2.getPath(), c2.getPath())) {
                    d.a.n0.a.u1.a.a.L(true);
                    d.a.n0.a.z1.b.f.e.f(this.f46677a, d.a.n0.a.h.aiapps_debug_swan_core_download_success).F();
                    this.f46678b.handleSchemeDispatchCallback(this.f46679c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                }
                d.a.n0.a.z1.b.f.e.f(this.f46677a, d.a.n0.a.h.aiapps_debug_swan_core_download_failed).F();
                this.f46678b.handleSchemeDispatchCallback(this.f46679c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/replaceSwanCore");
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

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.n0.a.z1.b.f.e.f(context, d.a.n0.a.h.aiapps_debug_params_empty).F();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
                return false;
            }
            String optString = a2.optString("url");
            String optString2 = a2.optString("cb");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, optString2, context, optString));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            d.a.n0.a.z1.b.f.e.f(context, d.a.n0.a.h.aiapps_debug_download_url_empty).F();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swan core url or cb is null");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, callbackHandler) == null) {
            d.a.n0.a.a1.e.H(str, new b(this, context, callbackHandler, str2));
        }
    }
}
