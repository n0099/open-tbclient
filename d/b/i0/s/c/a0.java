package d.b.i0.s.c;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51874a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        jSONObject.optInt("offline");
        jSONObject.optString("title");
        String optString = jSONObject.optString("link");
        this.f51874a = optString;
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.f51874a = this.f51874a.replaceFirst("webview:", "http://");
    }
}
