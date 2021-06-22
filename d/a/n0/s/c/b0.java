package d.a.n0.s.c;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public String f54202a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        jSONObject.optInt("offline");
        jSONObject.optString("title");
        String optString = jSONObject.optString("link");
        this.f54202a = optString;
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.f54202a = this.f54202a.replaceFirst("webview:", "http://");
    }
}
