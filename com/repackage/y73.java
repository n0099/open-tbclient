package com.repackage;

import android.content.Context;
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
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class y73 extends g23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y73(g13 g13Var) {
        super(g13Var, "/swanAPI/file/getSavedFileList");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g13Var};
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

    @Override // com.repackage.g23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, j03Var)) == null) {
            if (context != null && callbackHandler != null && j03Var != null && j03Var.e0() != null) {
                ArrayList arrayList = (ArrayList) j03Var.e0().i();
                JSONArray jSONArray = new JSONArray();
                if (arrayList != null && arrayList.size() != 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        q73 q73Var = (q73) it.next();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("filePath", r73.J(q73Var.b(), j03.f0()));
                            jSONObject.put(FileMetaUtil.CREATE_TIME, q73Var.a());
                            jSONObject.put("size", q73Var.c());
                            if (g23.b) {
                                Log.d("GetSavedFileListAction", "——> handle: fileInfo (" + jSONObject.get("filePath") + " , " + jSONObject.get(FileMetaUtil.CREATE_TIME) + " , " + jSONObject.get("size") + SmallTailInfo.EMOTION_SUFFIX);
                            }
                        } catch (JSONException e) {
                            jx1.o("getSavedFileList", "file info to json fail");
                            e.printStackTrace();
                        }
                        jSONArray.put(jSONObject);
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("fileList", jSONArray);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                        return true;
                    } catch (JSONException e2) {
                        jx1.c("getSavedFileList", "file list to json fail");
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, d13.a(2003)));
                        if (g23.b) {
                            Log.d("GetSavedFileListAction", "——> handle: jsonException " + e2.getMessage());
                        }
                        return false;
                    }
                }
                jx1.c("getSavedFileList", "file list is null");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, 0));
                return true;
            }
            jx1.c("getSavedFileList", "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
