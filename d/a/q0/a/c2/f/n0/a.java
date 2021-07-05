package d.a.q0.a.c2.f.n0;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c2.e;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.h0.c.a.b;
import d.a.q0.a.h0.o.d;
import d.a.q0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/prefetchAppData");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (a0.f46883b) {
                Log.d("PrefetchAppData", "handle entity: " + unitedSchemeEntity.getUri().toString());
            }
            String param = unitedSchemeEntity.getParam("params");
            JSONObject d2 = w.d(param);
            PrefetchEvent j = j(d2);
            if (j != null && j.isValid()) {
                if (!b.c(d2.optString("netconf", "1"))) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
                    return false;
                }
                d.e().d(j);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params: " + param);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final PrefetchEvent j(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            PrefetchEvent.b bVar = new PrefetchEvent.b();
            bVar.e(jSONObject.optString("state"));
            bVar.d(jSONObject.optString("schema"));
            bVar.c(jSONObject.optString("scene"));
            bVar.a(jSONObject.optString("appKey"));
            return bVar.b();
        }
        return (PrefetchEvent) invokeL.objValue;
    }
}
