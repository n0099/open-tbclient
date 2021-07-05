package d.a.q0.a.o;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c2.f.a0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.a.o.b f49793c;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final UnitedSchemeEntity f49794a;

        /* renamed from: b  reason: collision with root package name */
        public final CallbackHandler f49795b;

        public a(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49794a = unitedSchemeEntity;
            this.f49795b = callbackHandler;
        }

        @Override // d.a.q0.a.o.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                UnitedSchemeUtility.callCallback(this.f49795b, this.f49794a, i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final CallbackHandler f49796a;

        /* renamed from: b  reason: collision with root package name */
        public final String f49797b;

        public b(d dVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49796a = callbackHandler;
            this.f49797b = str;
        }

        @Override // d.a.q0.a.o.c
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (TextUtils.isEmpty(this.f49797b)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.b("rewardedVideoAdClose", hashMap));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("event", IntentConfig.CLOSE);
                    jSONObject2.put("result", jSONObject);
                    this.f49796a.handleSchemeDispatchCallback(this.f49797b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.a.q0.a.o.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (TextUtils.isEmpty(this.f49797b)) {
                    d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.b("rewardedVideoAdLoad", new HashMap()));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("event", "load");
                    this.f49796a.handleSchemeDispatchCallback(this.f49797b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // d.a.q0.a.o.c
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                if (TextUtils.isEmpty(this.f49797b)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    d.a.q0.a.g1.f.V().v(new d.a.q0.a.o0.d.b("rewardedVideoAdError", hashMap));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("event", "error");
                    jSONObject2.put("result", jSONObject);
                    this.f49796a.handleSchemeDispatchCallback(this.f49797b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/rewardedVideoAd");
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
        this.f49793c = null;
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("SwanAppAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = a2.optString("cb");
            String optString2 = a2.optString("action");
            b bVar = new b(this, callbackHandler, optString);
            a aVar = new a(this, unitedSchemeEntity, callbackHandler);
            if (this.f49793c == null) {
                this.f49793c = new f(a2, bVar, aVar);
            }
            if (TextUtils.equals(optString2, "show")) {
                this.f49793c.a(a2, aVar);
                return true;
            } else if (TextUtils.equals(optString2, "load")) {
                this.f49793c.b(a2, aVar, bVar);
                return true;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
