package d.b.g0.g.k0.i.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.b.g0.a.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    @NonNull
    public static RecommendItemModel a(@NonNull JSONObject jSONObject) {
        RecommendItemModel recommendItemModel = new RecommendItemModel();
        recommendItemModel.appName = jSONObject.optString(DpStatConstants.KEY_APP_NAME);
        recommendItemModel.appKey = jSONObject.optString(com.alipay.sdk.cons.b.f1858h);
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
            aVar.f48301a = a(optJSONObject);
        }
        aVar.f48302b = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                aVar.f48302b.add(a(optJSONArray.optJSONObject(i)));
            }
        }
        return aVar;
    }

    @NonNull
    public static c c(String str) {
        c cVar = new c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.f48303a = jSONObject.getInt("errno");
            cVar.f48304b = jSONObject.optString("errmsg");
            cVar.f48305c = jSONObject.optJSONObject("data");
            return cVar;
        } catch (JSONException e2) {
            cVar.f48303a = -1;
            cVar.f48304b = "network error: response parse failed.";
            if (k.f45050a) {
                Log.e("RecommendModelParser", "parseResponseModel error:" + e2);
            }
            return cVar;
        }
    }
}
