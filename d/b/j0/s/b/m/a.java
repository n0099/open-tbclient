package d.b.j0.s.b.m;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends ShareItem {
    public String j() {
        return this.l0;
    }

    public String k() {
        return this.k0;
    }

    public String l() {
        return this.j0;
    }

    public JSONArray m() {
        return this.m0;
    }

    public void n(JSONObject jSONObject) throws JSONException {
        this.e0 = true;
        this.r = jSONObject.getString("title");
        this.t = jSONObject.getString("linkUrl");
        this.s = jSONObject.optString("content");
        this.w = jSONObject.optString("imageUrl");
        this.j0 = jSONObject.optString("mediaType");
        String optString = StringUtils.isNull(this.w) ? jSONObject.optString("iconUrl") : this.w;
        this.w = optString;
        this.v = Uri.parse(optString);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.f0 = optJSONObject.optString("source2");
            this.h0 = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.g0 = 2;
            this.m0 = optJSONObject2.optJSONArray("cmd_pannel");
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("info");
            this.n0 = optJSONObject3;
            if (optJSONObject3 != null) {
                this.k0 = optJSONObject3.optString("key");
                this.l0 = this.n0.optString("content");
                return;
            }
            return;
        }
        this.g0 = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }
}
