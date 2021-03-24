package d.b.h0.r.y.s;

import android.content.ClipboardManager;
import com.baidu.adp.lib.util.StringUtils;
import d.b.h0.r.y.l;
import d.b.h0.r.y.n;
import d.b.h0.r.y.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends n {
    public a(l lVar) {
        super(lVar);
    }

    @o("copy")
    public JSONObject copyToClipboard(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            String optString = jSONObject.optString("message");
            if (!StringUtils.isNull(optString)) {
                ((ClipboardManager) b().getSystemService("clipboard")).setText(optString.trim());
                jSONObject2.put("status", 0);
                jSONObject2.put("message", "");
                return jSONObject2;
            }
        }
        jSONObject2.put("status", -1);
        jSONObject2.put("message", "无效内容");
        return jSONObject2;
    }

    @Override // d.b.h0.r.y.n
    public String g() {
        return "TBHY_COMMON_Clipboard";
    }
}
