package d.a.q0.h.o0.g.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static RecommendItemModel a(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            RecommendItemModel recommendItemModel = new RecommendItemModel();
            recommendItemModel.appName = jSONObject.optString("app_name");
            recommendItemModel.appKey = jSONObject.optString("app_key");
            recommendItemModel.iconUrl = jSONObject.optString("icon_url");
            recommendItemModel.scheme = jSONObject.optString("scheme");
            recommendItemModel.desc = jSONObject.optString("desc");
            JSONObject optJSONObject = jSONObject.optJSONObject("button");
            if (optJSONObject != null) {
                recommendItemModel.buttonText = optJSONObject.optString("text");
            }
            return recommendItemModel;
        }
        return (RecommendItemModel) invokeL.objValue;
    }

    @NonNull
    public static a b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            a aVar = new a();
            if (jSONObject == null) {
                return aVar;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("game_center");
            if (optJSONObject != null) {
                aVar.f53534a = a(optJSONObject);
            }
            aVar.f53535b = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    aVar.f53535b.add(a(optJSONArray.optJSONObject(i2)));
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static c c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c cVar = new c();
            try {
                JSONObject jSONObject = new JSONObject(str);
                cVar.f53536a = jSONObject.getInt("errno");
                cVar.f53537b = jSONObject.optString("errmsg");
                cVar.f53538c = jSONObject.optJSONObject("data");
                return cVar;
            } catch (JSONException e2) {
                cVar.f53536a = -1;
                cVar.f53537b = "network error: response parse failed.";
                if (k.f49133a) {
                    Log.e("RecommendModelParser", "parseResponseModel error:" + e2);
                }
                return cVar;
            }
        }
        return (c) invokeL.objValue;
    }
}
