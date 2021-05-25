package d.a.m0.s.c;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public String f50419a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        jSONObject.optInt("offline");
        jSONObject.optString("title");
        String optString = jSONObject.optString("link");
        this.f50419a = optString;
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.f50419a = this.f50419a.replaceFirst("webview:", "http://");
    }
}
