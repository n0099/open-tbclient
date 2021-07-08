package d.a.n0.a.k2.e;

import android.content.Context;
import android.text.TextUtils;
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
import d.a.n0.a.c2.f.a0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/file/removeSavedFile");
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
            if (context != null && callbackHandler != null && eVar != null && eVar.U() != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    d.a.n0.a.e0.d.b("removeSavedFile", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String M = d.a.n0.a.k2.b.M(optParamsAsJo.optString("filePath"), d.a.n0.a.a2.e.V());
                if (a0.f43581b) {
                    Log.d("SaveFileAction", "——> handle: fileUrl " + optParamsAsJo.optString("filePath"));
                    Log.d("SaveFileAction", "——> handle: filePath " + M);
                }
                if (a0.f43581b) {
                    Log.d("RemoveSavedFileAction", "——> handle: filePath " + M);
                }
                if (TextUtils.isEmpty(M)) {
                    d.a.n0.a.e0.d.b("removeSavedFile", "file path is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                int a2 = eVar.U().a(M);
                if (a0.f43581b) {
                    Log.d("RemoveSavedFileAction", "——> handle: statusCode " + a2);
                }
                if (a2 > 2000) {
                    d.a.n0.a.e0.d.b("removeSavedFile", "file path status code : " + a2);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a2, d.a.n0.a.c2.b.a(a2)));
                    return false;
                } else if (d.a.n0.t.d.j(M)) {
                    d.a.n0.a.e0.d.g("removeSavedFile", "file delete success");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (a0.f43581b) {
                        Log.d("RemoveSavedFileAction", "——> handle:  delete OK ");
                        return true;
                    }
                    return true;
                } else {
                    d.a.n0.a.e0.d.b("removeSavedFile", "file delete fail");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2004, d.a.n0.a.c2.b.a(2004)));
                    if (a0.f43581b) {
                        Log.d("RemoveSavedFileAction", "——> handle:  delete fail ");
                    }
                    return false;
                }
            }
            d.a.n0.a.e0.d.b("removeSavedFile", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
