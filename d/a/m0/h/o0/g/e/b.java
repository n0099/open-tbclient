package d.a.m0.h.o0.g.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.a.m0.a.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    @NonNull
    public static RecommendItemModel a(@NonNull JSONObject jSONObject) {
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

    @NonNull
    public static a b(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject == null) {
            return aVar;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("game_center");
        if (optJSONObject != null) {
            aVar.f51388a = a(optJSONObject);
        }
        aVar.f51389b = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                aVar.f51389b.add(a(optJSONArray.optJSONObject(i2)));
            }
        }
        return aVar;
    }

    @NonNull
    public static c c(String str) {
        c cVar = new c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.f51390a = jSONObject.getInt("errno");
            cVar.f51391b = jSONObject.optString("errmsg");
            cVar.f51392c = jSONObject.optJSONObject("data");
            return cVar;
        } catch (JSONException e2) {
            cVar.f51390a = -1;
            cVar.f51391b = "network error: response parse failed.";
            if (k.f46983a) {
                Log.e("RecommendModelParser", "parseResponseModel error:" + e2);
            }
            return cVar;
        }
    }
}
