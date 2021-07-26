package d.a.o0.a.p0.f.d;

import android.content.Context;
import android.text.TextUtils;
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
import d.a.o0.a.a1.e;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.e2.c.j.b;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.p0.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0873a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47161e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47162f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47163g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f47164h;

        public C0873a(a aVar, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47164h = aVar;
            this.f47161e = callbackHandler;
            this.f47162f = str;
            this.f47163g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.f47164h.k(this.f47163g, this.f47162f, this.f47161e);
                } else {
                    d.a.o0.a.e2.c.d.p(iVar, this.f47161e, this.f47162f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47165a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47166b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f47167c;

        public b(a aVar, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47165a = callbackHandler;
            this.f47166b = jSONObject;
            this.f47167c = str;
        }

        @Override // d.a.o0.a.a1.e.c
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // d.a.o0.a.a1.e.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f47165a == null) {
                    d.a.o0.a.e0.d.l("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    d.a.o0.a.e0.d.b("ExtCore-DebugDownload", "download failed");
                    d.a.o0.a.z1.b.f.e.f(d.a.o0.a.c1.a.b(), d.a.o0.a.h.aiapps_debug_extension_core_download_failed).F();
                    this.f47166b.put("status", -1);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f47165a.handleSchemeDispatchCallback(this.f47167c, UnitedSchemeUtility.wrapCallbackParams(this.f47166b, 1001).toString());
            }
        }

        @Override // d.a.o0.a.a1.e.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f47165a == null) {
                    d.a.o0.a.e0.d.l("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    File c2 = d.a.o0.a.p0.f.c.c();
                    File b2 = d.a.o0.a.p0.f.c.b();
                    if (c2.exists() && d.a.o0.t.d.T(c2.getPath(), b2.getPath())) {
                        d.a.o0.a.e0.d.b("ExtCore-DebugDownload", "download success");
                        d.a.o0.a.z1.b.f.e.f(d.a.o0.a.c1.a.b(), d.a.o0.a.h.aiapps_debug_extension_core_download_success).F();
                        this.f47166b.put("status", 0);
                        this.f47165a.handleSchemeDispatchCallback(this.f47167c, UnitedSchemeUtility.wrapCallbackParams(this.f47166b, 0).toString());
                    } else {
                        d.a.o0.a.e0.d.b("ExtCore-DebugDownload", "download failed");
                        d.a.o0.a.z1.b.f.e.f(d.a.o0.a.c1.a.b(), d.a.o0.a.h.aiapps_debug_extension_core_download_failed).F();
                        this.f47166b.put("status", -1);
                        this.f47165a.handleSchemeDispatchCallback(this.f47167c, UnitedSchemeUtility.wrapCallbackParams(this.f47166b, 1001).toString());
                    }
                } catch (JSONException e2) {
                    d.a.o0.a.e0.d.c("ExtCore-DebugDownload", "build result with exception", e2);
                    e2.printStackTrace();
                    this.f47165a.handleSchemeDispatchCallback(this.f47167c, UnitedSchemeUtility.wrapCallbackParams(this.f47166b, 1001).toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/downloadExtension");
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

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.o0.a.e0.d.b("ExtCore-DebugDownload", "params is null");
                d.a.o0.a.z1.b.f.e.f(context, d.a.o0.a.h.aiapps_debug_params_empty).F();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString = a2.optString("url");
            if (TextUtils.isEmpty(optString)) {
                d.a.o0.a.e0.d.b("ExtCore-DebugDownload", "url is null");
                d.a.o0.a.z1.b.f.e.f(context, d.a.o0.a.h.aiapps_debug_download_url_empty).F();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = a2.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                d.a.o0.a.e0.d.b("ExtCore-DebugDownload", "cb is null");
                d.a.o0.a.z1.b.f.e.f(context, d.a.o0.a.h.aiapps_debug_extension_core_cb_empty).F();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            eVar.T().g(context, "mapp_cts_debug", new C0873a(this, callbackHandler, optString2, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, callbackHandler) == null) {
            d.a.o0.a.a1.e.G(str, new b(this, callbackHandler, new JSONObject(), str2));
        }
    }
}
