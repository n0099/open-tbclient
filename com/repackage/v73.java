package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v73 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v73(e13 e13Var) {
        super(e13Var, "/swanAPI/file/getSavedFileInfo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (context != null && callbackHandler != null && h03Var != null && h03Var.f0() != null) {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    hx1.c("getSavedFile", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String M = p73.M(optParamsAsJo.optString("filePath"), h03.g0());
                if (e23.b) {
                    Log.d("GetSavedFileInfoAction", "——> handle: fileUrl " + optParamsAsJo.optString("filePath"));
                    Log.d("GetSavedFileInfoAction", "——> handle: filePath " + M);
                }
                if (TextUtils.isEmpty(M)) {
                    hx1.c("getSavedFile", "file path is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                o73 h = h03Var.f0().h(M);
                if (h == null) {
                    hx1.c("getSavedFile", "file info is null");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, b13.a(2001)));
                    if (e23.b) {
                        Log.d("GetSavedFileInfoAction", "——> handle: file not exist");
                    }
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(FileMetaUtil.CREATE_TIME, Math.round((float) (h.a() / 1000)));
                    jSONObject.put("size", h.c());
                    if (e23.b) {
                        Log.d("GetSavedFileInfoAction", "——> handle: fileInfo (" + jSONObject.get(FileMetaUtil.CREATE_TIME) + " , " + jSONObject.get("size") + SmallTailInfo.EMOTION_SUFFIX);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    return true;
                } catch (JSONException e) {
                    hx1.o("getSavedFile", "file info to json fail");
                    e.printStackTrace();
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, b13.a(2003)));
                    if (e23.b) {
                        Log.d("GetSavedFileInfoAction", "——> handle: jsonException ");
                    }
                    return false;
                }
            }
            hx1.c("getSavedFile", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
