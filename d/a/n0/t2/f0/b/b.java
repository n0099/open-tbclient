package d.a.n0.t2.f0.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f64753a;

    /* renamed from: b  reason: collision with root package name */
    public String f64754b;

    /* renamed from: c  reason: collision with root package name */
    public String f64755c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64756d;

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.f64753a = jSONObject.optString("apk_name");
        bVar.f64754b = jSONObject.optString("apk_url");
        bVar.f64755c = jSONObject.optString("download_key");
        bVar.f64756d = jSONObject.optBoolean("direcrt_download");
        return bVar;
    }
}
