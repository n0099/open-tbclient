package d.a.o0.a.i1.f.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.o0.a.a2.e;
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.e2.c.d;
import d.a.o0.a.e2.c.i;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.s1.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.i1.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0791a implements d.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46063f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.f.b f46064g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46065h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f46066i;
        public final /* synthetic */ d.a.o0.a.i1.f.a j;
        public final /* synthetic */ String k;
        public final /* synthetic */ e l;
        public final /* synthetic */ a m;

        public C0791a(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, d.a.o0.a.i1.f.b bVar, String str, Context context, d.a.o0.a.i1.f.a aVar2, String str2, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, bVar, str, context, aVar2, str2, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = aVar;
            this.f46062e = callbackHandler;
            this.f46063f = unitedSchemeEntity;
            this.f46064g = bVar;
            this.f46065h = str;
            this.f46066i = context;
            this.j = aVar2;
            this.k = str2;
            this.l = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.h(iVar)) {
                    d.o(iVar, this.f46062e, this.f46063f);
                    int b2 = iVar == null ? 10001 : iVar.b();
                    this.m.o(this.f46064g, b2, d.f(b2));
                } else if (d.a.o0.a.i1.f.e.a.k().q(this.f46065h)) {
                    this.m.o(this.f46064g, 2001, "error execute time");
                    d.a.o0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error execute time");
                } else {
                    this.m.r(this.f46066i, this.f46063f, this.f46062e, this.f46065h, this.j, this.f46064g, this.k, this.l.f43885f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46067a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46068b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46069c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f46070d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.f.a f46071e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.i1.f.b f46072f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46073g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46074h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f46075i;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, d.a.o0.a.i1.f.a aVar2, d.a.o0.a.i1.f.b bVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, str, context, aVar2, bVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46075i = aVar;
            this.f46067a = callbackHandler;
            this.f46068b = unitedSchemeEntity;
            this.f46069c = str;
            this.f46070d = context;
            this.f46071e = aVar2;
            this.f46072f = bVar;
            this.f46073g = str2;
            this.f46074h = str3;
        }

        @Override // d.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f44085b) {
                    Log.d("AudioRecordAction", str + "");
                }
                this.f46075i.p(this.f46067a, this.f46068b, this.f46069c, this.f46070d, this.f46071e, this.f46072f, this.f46073g, this.f46074h);
            }
        }

        @Override // d.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (a0.f44085b) {
                    Log.d("AudioRecordAction", str + "");
                }
                d.a.o0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, str);
                this.f46075i.o(this.f46072f, 10005, "system deny");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/recorder");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f44085b) {
                Log.d("AudioRecordAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // d.a.o0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, eVar)) == null) {
            if (a0.f44085b) {
                Log.d("AudioRecordAction", "handleSubAction subAction: " + str);
            }
            if (eVar == null) {
                d.a.o0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (a0.f44085b) {
                    Log.d("AudioRecordAction", "record --- illegal swanApp");
                }
                return false;
            }
            if (eVar.d0()) {
                if (a0.f44085b) {
                    Log.d("AudioRecordAction", "AudioRecordAction does not supported when app is invisible.");
                }
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -944894266) {
                    if (hashCode == 731105865 && str.equals("/swanAPI/recorder/resume")) {
                        c2 = 1;
                    }
                } else if (str.equals("/swanAPI/recorder/start")) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                } else if (c2 == 1) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
            }
            if (TextUtils.isEmpty(eVar.f43885f)) {
                d.a.o0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "aiapp id is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
                if (a0.f44085b) {
                    Log.d("AudioRecordAction", "record --- none swanApp id");
                }
                return false;
            } else if (d.a.o0.a.i1.f.e.a.k().p(str)) {
                JSONObject q = q(unitedSchemeEntity.getParam("params"));
                if (TextUtils.equals(str, "/swanAPI/recorder/start") && q == null) {
                    d.a.o0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                    return false;
                }
                d.a.o0.a.i1.f.a a2 = d.a.o0.a.i1.f.a.a(q, d.a.o0.a.i1.f.e.a.k().j());
                if (a2 == null) {
                    d.a.o0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "error cb");
                    return false;
                }
                JSONObject c3 = a2.c();
                if (c3 != null) {
                    d.a.o0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "error params");
                    unitedSchemeEntity.result = c3;
                    return false;
                }
                d.a.o0.a.i1.f.b a3 = d.a.o0.a.i1.f.b.a(callbackHandler, unitedSchemeEntity, a2.f46052g, d.a.o0.a.i1.f.e.a.k().i());
                String x = d.a.o0.a.k2.b.x(eVar.f43885f);
                if (TextUtils.isEmpty(x)) {
                    d.a.o0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "none tmp path");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!(context instanceof Activity)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    d.a.o0.a.e0.d.b(BundleOpProvider.METHOD_BUNDLE_RECORD, "handle action, but context is not Activity");
                    return false;
                } else {
                    eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new C0791a(this, callbackHandler, unitedSchemeEntity, a3, str, context, a2, x, eVar));
                    if (a0.f44085b) {
                        Log.d("AudioRecordAction", "subAction is : " + str);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final void o(d.a.o0.a.i1.f.b bVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bVar, i2, str) == null) {
            if (bVar != null && !TextUtils.isEmpty(d.a.o0.a.i1.f.b.f46058h)) {
                bVar.d(i2, str);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(RouterCallback.KEY_ERROR_CODE, i2);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                d.a.o0.a.g1.f.V().v(new d.a.o0.a.o0.d.b("recorderError", hashMap));
            } catch (JSONException e2) {
                d.a.o0.a.e0.d.c(BundleOpProvider.METHOD_BUNDLE_RECORD, "json error", e2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, Context context, d.a.o0.a.i1.f.a aVar, d.a.o0.a.i1.f.b bVar, String str2, String str3) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3}) == null) {
            switch (str.hashCode()) {
                case -948211622:
                    if (str.equals("/swanAPI/recorder/pause")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -944894266:
                    if (str.equals("/swanAPI/recorder/start")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 731105865:
                    if (str.equals("/swanAPI/recorder/resume")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2047729950:
                    if (str.equals("/swanAPI/recorder/stop")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                u(context, aVar, bVar, str2, str3);
            } else if (c2 == 1) {
                d.a.o0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "pause");
                s();
            } else if (c2 == 2) {
                d.a.o0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "resume");
                t();
            } else if (c2 != 3) {
            } else {
                d.a.o0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, IntentConfig.STOP);
                v();
            }
        }
    }

    public final JSONObject q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return new JSONObject(str);
                } catch (JSONException e2) {
                    if (a0.f44085b) {
                        Log.d("AudioRecordAction", Log.getStackTraceString(e2));
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.o0.a.i1.f.a aVar, d.a.o0.a.i1.f.b bVar, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, unitedSchemeEntity, callbackHandler, str, aVar, bVar, str2, str3}) == null) {
            d.a.o0.a.s1.e.g(new String[]{PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 2, context, new b(this, callbackHandler, unitedSchemeEntity, str, context, aVar, bVar, str2, str3));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d.a.o0.a.i1.f.e.a.k().t();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.o0.a.i1.f.e.a.k().A();
        }
    }

    public final void u(Context context, d.a.o0.a.i1.f.a aVar, d.a.o0.a.i1.f.b bVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, aVar, bVar, str, str2) == null) {
            d.a.o0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "init");
            d.a.o0.a.i1.f.e.a.k().l(str, aVar, context, bVar, str2);
            d.a.o0.a.e0.d.g(BundleOpProvider.METHOD_BUNDLE_RECORD, "start");
            d.a.o0.a.i1.f.e.a.k().D(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.o0.a.i1.f.e.a.k().F();
            d.a.o0.a.i1.f.e.a.x();
        }
    }
}
