package d.a.j0.s.b.m;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends ShareItem {
    public String l() {
        return this.n0;
    }

    public String m() {
        return this.m0;
    }

    public String n() {
        return this.l0;
    }

    public JSONArray o() {
        return this.o0;
    }

    public void p(JSONObject jSONObject) throws JSONException {
        this.g0 = true;
        this.r = jSONObject.getString("title");
        this.t = jSONObject.getString("linkUrl");
        this.s = jSONObject.optString("content");
        this.w = jSONObject.optString("imageUrl");
        this.l0 = jSONObject.optString("mediaType");
        String optString = StringUtils.isNull(this.w) ? jSONObject.optString("iconUrl") : this.w;
        this.w = optString;
        this.v = Uri.parse(optString);
        JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
        if (optJSONObject != null) {
            this.h0 = optJSONObject.optString("source2");
            this.j0 = optJSONObject.optString("source3");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
        if (optJSONObject2 != null) {
            this.i0 = 2;
            this.o0 = optJSONObject2.optJSONArray("cmd_pannel");
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("info");
            this.p0 = optJSONObject3;
            if (optJSONObject3 != null) {
                this.m0 = optJSONObject3.optString("key");
                this.n0 = this.p0.optString("content");
                return;
            }
            return;
        }
        this.i0 = "url".equals(jSONObject.optString("type")) ? 1 : 3;
    }
}
