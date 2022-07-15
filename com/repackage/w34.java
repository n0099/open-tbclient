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
public class w34 {
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
    public static v34 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            v34 v34Var = new v34();
            if (jSONObject == null) {
                return v34Var;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("game_center");
            if (optJSONObject != null) {
                v34Var.a = a(optJSONObject);
            }
            v34Var.b = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    v34Var.b.add(a(optJSONArray.optJSONObject(i)));
                }
            }
            return v34Var;
        }
        return (v34) invokeL.objValue;
    }

    @NonNull
    public static x34 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            x34 x34Var = new x34();
            try {
                JSONObject jSONObject = new JSONObject(str);
                x34Var.a = jSONObject.getInt("errno");
                x34Var.b = jSONObject.optString("errmsg");
                x34Var.c = jSONObject.optJSONObject("data");
                return x34Var;
            } catch (JSONException e) {
                x34Var.a = -1;
                x34Var.b = "network error: response parse failed.";
                if (rg1.a) {
                    Log.e("RecommendModelParser", "parseResponseModel error:" + e);
                }
                return x34Var;
            }
        }
        return (x34) invokeL.objValue;
    }
}
