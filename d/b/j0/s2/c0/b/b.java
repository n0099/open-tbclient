package d.b.j0.s2.c0.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f62015a;

    /* renamed from: b  reason: collision with root package name */
    public String f62016b;

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.f62015a = jSONObject.optString("apk_name");
        bVar.f62016b = jSONObject.optString("apk_url");
        jSONObject.optString("download_key");
        jSONObject.optBoolean("direcrt_download");
        return bVar;
    }
}
