package d.a.q0.a.c2.f;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class t extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/performancePanel");
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
            if (!d.a.q0.a.g1.f.V().O() && !a0.f46883b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not debug app model");
                return false;
            } else if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                    return false;
                }
                JSONArray optJSONArray = optParamsAsJo.optJSONArray("data");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("slaveId");
                            String optString2 = optJSONObject.optString("actionName");
                            long optLong = optJSONObject.optLong("timestamp", -1L);
                            if (a0.f46883b) {
                                Log.i("performancePanel", "slaveId: " + optString + ", actionName: " + optString2 + ", timestamp: " + optLong);
                            }
                            d.a.q0.a.r1.p.d.b().d(optString, optString2, optLong);
                        }
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty data");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
