package d.a.j0.s2.e0.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f60228a;

    /* renamed from: b  reason: collision with root package name */
    public String f60229b;

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.f60228a = jSONObject.optString("apk_name");
        bVar.f60229b = jSONObject.optString("apk_url");
        jSONObject.optString("download_key");
        jSONObject.optBoolean("direcrt_download");
        return bVar;
    }
}
