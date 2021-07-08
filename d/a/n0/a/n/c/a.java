package d.a.n0.a.n.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.e2.c.d;
import d.a.n0.a.e2.c.i;
import d.a.n0.a.e2.c.j.b;
import d.a.n0.a.j2.k;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0825a implements d.a.n0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f46200e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f46201f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46202g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46203h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46204i;
        public final /* synthetic */ String j;
        public final /* synthetic */ UnitedSchemeEntity k;
        public final /* synthetic */ a l;

        public C0825a(a aVar, e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, String str2, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, context, Boolean.valueOf(z), str, callbackHandler, str2, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = aVar;
            this.f46200e = eVar;
            this.f46201f = context;
            this.f46202g = z;
            this.f46203h = str;
            this.f46204i = callbackHandler;
            this.j = str2;
            this.k = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean e2 = this.f46200e.j().e(this.f46201f);
                if (!d.h(iVar)) {
                    if (!e2 && !this.f46202g) {
                        k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 5, this.f46203h);
                    }
                    d.p(iVar, this.f46204i, this.j);
                    return;
                }
                d.a.n0.a.e0.d.g("chooseInvoiceTitle", OAuthResult.RESULT_MSG_SUCCESS);
                Context context = this.f46201f;
                Context x = context instanceof Activity ? (Activity) context : this.f46200e.x();
                if (x == null) {
                    UnitedSchemeUtility.safeCallback(this.f46204i, this.k, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString(), this.j);
                    return;
                }
                if (e2 && !this.f46202g) {
                    k.M("success", 5, this.f46203h);
                }
                this.l.k(x, this.f46204i, this.k, this.f46200e, this.j, this.f46203h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.n0.a.n.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46205a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46206b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46207c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46205a = callbackHandler;
            this.f46206b = unitedSchemeEntity;
            this.f46207c = str;
        }

        @Override // d.a.n0.a.n.c.b
        public void a(int i2) {
            String jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    d.a.n0.a.e0.d.g("chooseInvoiceTitle", "choose invoice cancel");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1002, "choose invoice cancel").toString();
                } else {
                    d.a.n0.a.e0.d.g("chooseInvoiceTitle", "choose invoice failed");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1003, "choose invoice failed").toString();
                }
                UnitedSchemeUtility.safeCallback(this.f46205a, this.f46206b, jSONObject, this.f46207c);
            }
        }

        @Override // d.a.n0.a.n.c.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                d.a.n0.a.e0.d.g("chooseInvoiceTitle", "choose success");
                UnitedSchemeUtility.safeCallback(this.f46205a, this.f46206b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f46207c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseInvoiceTitle");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            d.a.n0.a.e0.d.g("chooseInvoiceTitle", "发票调起");
            if (eVar == null) {
                d.a.n0.a.e0.d.b("chooseInvoiceTitle", "empty swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            } else if (eVar.d0()) {
                if (a0.f43581b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    d.a.n0.a.e0.d.b("chooseInvoiceTitle", "empty joParams");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    d.a.n0.a.e0.d.b("chooseInvoiceTitle", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                String optString2 = optParamsAsJo.optString("invokeFrom");
                boolean e2 = eVar.j().e(context);
                if (!e2) {
                    k.M("show", 5, optString2);
                }
                eVar.T().h(context, "mapp_choose_invoice", d.i(optParamsAsJo), new C0825a(this, eVar, context, e2, optString2, callbackHandler, optString, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, callbackHandler, unitedSchemeEntity, eVar, str, str2}) == null) {
            d.a.n0.a.c1.a.d0().a(context, eVar.f43381f, eVar.D(), new b(this, callbackHandler, unitedSchemeEntity, str));
        }
    }
}
