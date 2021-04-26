package d.a.h0.g.k0.i.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.a.h0.a.k;
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
        recommendItemModel.appKey = jSONObject.optString(com.alipay.sdk.cons.b.f1831h);
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
            aVar.f46500a = a(optJSONObject);
        }
        aVar.f46501b = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("app_list");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                aVar.f46501b.add(a(optJSONArray.optJSONObject(i2)));
            }
        }
        return aVar;
    }

    @NonNull
    public static c c(String str) {
        c cVar = new c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.f46502a = jSONObject.getInt("errno");
            cVar.f46503b = jSONObject.optString("errmsg");
            cVar.f46504c = jSONObject.optJSONObject("data");
            return cVar;
        } catch (JSONException e2) {
            cVar.f46502a = -1;
            cVar.f46503b = "network error: response parse failed.";
            if (k.f43101a) {
                Log.e("RecommendModelParser", "parseResponseModel error:" + e2);
            }
            return cVar;
        }
    }
}
