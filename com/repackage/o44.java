package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static RecommendItemModel a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            RecommendItemModel recommendItemModel = new RecommendItemModel();
            recommendItemModel.appName = jSONObject.optString("app_name");
            recommendItemModel.appKey = jSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
            recommendItemModel.iconUrl = jSONObject.optString("icon_url");
            recommendItemModel.scheme = jSONObject.optString("scheme");
            recommendItemModel.desc = jSONObject.optString("desc");
            JSONObject optJSONObject = jSONObject.optJSONObject(NativeConstants.ID_BUTTON);
            if (optJSONObject != null) {
                recommendItemModel.buttonText = optJSONObject.optString("text");
            }
            return recommendItemModel;
        }
        return (RecommendItemModel) invokeL.objValue;
    }

    @NonNull
    public static n44 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            n44 n44Var = new n44();
            if (jSONObject == null) {
                return n44Var;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("game_center");
            if (optJSONObject != null) {
                n44Var.a = a(optJSONObject);
            }
            n44Var.b = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    n44Var.b.add(a(optJSONArray.optJSONObject(i)));
                }
            }
            return n44Var;
        }
        return (n44) invokeL.objValue;
    }

    @NonNull
    public static p44 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            p44 p44Var = new p44();
            try {
                JSONObject jSONObject = new JSONObject(str);
                p44Var.a = jSONObject.getInt("errno");
                p44Var.b = jSONObject.optString("errmsg");
                p44Var.c = jSONObject.optJSONObject("data");
                return p44Var;
            } catch (JSONException e) {
                p44Var.a = -1;
                p44Var.b = "network error: response parse failed.";
                if (jh1.a) {
                    Log.e("RecommendModelParser", "parseResponseModel error:" + e);
                }
                return p44Var;
            }
        }
        return (p44) invokeL.objValue;
    }
}
