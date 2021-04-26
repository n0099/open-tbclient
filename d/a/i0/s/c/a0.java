package d.a.i0.s.c;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public String f49525a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        jSONObject.optInt("offline");
        jSONObject.optString("title");
        String optString = jSONObject.optString("link");
        this.f49525a = optString;
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.f49525a = this.f49525a.replaceFirst("webview:", "http://");
    }
}
