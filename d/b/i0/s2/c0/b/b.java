package d.b.i0.s2.c0.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f61594a;

    /* renamed from: b  reason: collision with root package name */
    public String f61595b;

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.f61594a = jSONObject.optString("apk_name");
        bVar.f61595b = jSONObject.optString("apk_url");
        jSONObject.optString("download_key");
        jSONObject.optBoolean("direcrt_download");
        return bVar;
    }
}
