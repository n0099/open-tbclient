package d.a.j0.s.c;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public String f50344a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        jSONObject.optInt("offline");
        jSONObject.optString("title");
        String optString = jSONObject.optString("link");
        this.f50344a = optString;
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.f50344a = this.f50344a.replaceFirst("webview:", "http://");
    }
}
