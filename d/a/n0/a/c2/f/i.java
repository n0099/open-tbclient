package d.a.n0.a.c2.f;

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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getImageInfo");
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
            if (eVar == null) {
                d.a.n0.a.e0.d.b("getImageInfo", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            String optString = d.a.n0.a.v2.w.d(unitedSchemeEntity.getParam("params")).optString("src");
            if (TextUtils.isEmpty(optString)) {
                d.a.n0.a.e0.d.b("getImageInfo", "path null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            JSONObject jSONObject = null;
            if (d.a.n0.a.k2.b.s(optString) == PathType.BD_FILE) {
                jSONObject = k(d.a.n0.a.k2.b.M(optString, eVar.f43381f), optString);
            } else if (d.a.n0.a.k2.b.s(optString) == PathType.RELATIVE) {
                jSONObject = k(d.a.n0.a.k2.b.L(optString, eVar, eVar.Z()), optString);
            }
            if (jSONObject != null) {
                d.a.n0.a.e0.d.g("getImageInfo", "getImgInfo success");
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
            d.a.n0.a.e0.d.g("getImageInfo", "getImgInfo start");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i2 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
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
                i2 = j.getAttributeInt("Orientation", 1);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", i3);
                jSONObject.put("height", i4);
                jSONObject.put("path", str2);
                jSONObject.put("orientation", l(i2));
                jSONObject.put("type", str3);
            } catch (JSONException e2) {
                d.a.n0.a.e0.d.b("getImageInfo", "getImgInfo failed by json exception");
                if (a0.f43581b) {
                    e2.printStackTrace();
                }
            }
            d.a.n0.a.e0.d.g("getImageInfo", "getImgInfo end");
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final String l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            switch (i2) {
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
                    return CustomDialogData.POS_LEFT;
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
