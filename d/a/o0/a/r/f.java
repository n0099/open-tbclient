package d.a.o0.a.r;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/cloudRequest");
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
                super((d.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.r.c, d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) ? super.d(context, unitedSchemeEntity, callbackHandler, eVar) : invokeLLLL.booleanValue;
    }

    @Override // d.a.o0.a.r.c
    public void j(Response response, CallbackHandler callbackHandler, String str) {
        String header;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, callbackHandler, str) == null) && (header = response.header("Content-Type", "")) != null && header.contains("application/json")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("statusCode", response.code());
                jSONObject.put("header", d.a.o0.a.n1.a.s(response.headers()));
                jSONObject.put("body", response.body().string());
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("body"));
                String optString = jSONObject2.optString("errno", String.valueOf(0));
                String optString2 = jSONObject2.optString("errmsg");
                if (response.isSuccessful() && !a.o(optString)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(a.j(optString), a.k(optString2)).toString());
            } catch (Exception e2) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
            }
        }
    }
}
