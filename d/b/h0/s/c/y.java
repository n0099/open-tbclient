package d.b.h0.s.c;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public String f51241a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        jSONObject.optInt("offline");
        jSONObject.optString("title");
        String optString = jSONObject.optString("link");
        this.f51241a = optString;
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.f51241a = this.f51241a.replaceFirst("webview:", "http://");
    }
}
