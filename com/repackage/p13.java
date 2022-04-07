package com.repackage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p13 extends g23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p13(g13 g13Var) {
        super(g13Var, "/swanAPI/getImageInfo");
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
            if (j03Var == null) {
                jx1.c("getImageInfo", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            String optString = jd3.d(unitedSchemeEntity.getParam("params")).optString("src");
            if (TextUtils.isEmpty(optString)) {
                jx1.c("getImageInfo", "path null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            JSONObject jSONObject = null;
            if (r73.s(optString) == PathType.BD_FILE) {
                jSONObject = k(r73.M(optString, j03Var.b), optString);
            } else if (r73.s(optString) == PathType.RELATIVE) {
                jSONObject = k(r73.L(optString, j03Var, j03Var.j0()), optString);
            }
            if (jSONObject != null) {
                jx1.i("getImageInfo", "getImgInfo success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "image not found");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final ExifInterface j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new ExifInterface(str);
            } catch (IOException unused) {
                return null;
            }
        }
        return (ExifInterface) invokeL.objValue;
    }

    public final JSONObject k(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            jx1.i("getImageInfo", "getImgInfo start");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            String str4 = options.outMimeType;
            if (TextUtils.isEmpty(str4)) {
                str3 = "";
            } else {
                String[] split = str4.split("/");
                str3 = split[split.length - 1];
            }
            if (!TextUtils.equals("png", str3)) {
                ExifInterface j = j(str);
                if (j == null) {
                    return null;
                }
                i = j.getAttributeInt("Orientation", 1);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", i2);
                jSONObject.put("height", i3);
                jSONObject.put("path", str2);
                jSONObject.put("orientation", l(i));
                jSONObject.put("type", str3);
            } catch (JSONException e) {
                jx1.c("getImageInfo", "getImgInfo failed by json exception");
                if (g23.b) {
                    e.printStackTrace();
                }
            }
            jx1.i("getImageInfo", "getImgInfo end");
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final String l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            switch (i) {
                case 0:
                case 1:
                    return "up";
                case 2:
                    return "up-mirrored";
                case 3:
                    return "down";
                case 4:
                    return "down-mirrored";
                case 5:
                    return "left-mirrored";
                case 6:
                    return "left";
                case 7:
                    return "right-mirrored";
                case 8:
                    return "right";
                default:
                    return "";
            }
        }
        return (String) invokeI.objValue;
    }
}
