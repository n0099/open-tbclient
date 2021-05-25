package d.a.n0.t2.f0.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f61061a;

    /* renamed from: b  reason: collision with root package name */
    public String f61062b;

    /* renamed from: c  reason: collision with root package name */
    public String f61063c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61064d;

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.f61061a = jSONObject.optString("apk_name");
        bVar.f61062b = jSONObject.optString("apk_url");
        bVar.f61063c = jSONObject.optString("download_key");
        bVar.f61064d = jSONObject.optBoolean("direcrt_download");
        return bVar;
    }
}
