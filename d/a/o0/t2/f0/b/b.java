package d.a.o0.t2.f0.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f64878a;

    /* renamed from: b  reason: collision with root package name */
    public String f64879b;

    /* renamed from: c  reason: collision with root package name */
    public String f64880c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64881d;

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.f64878a = jSONObject.optString("apk_name");
        bVar.f64879b = jSONObject.optString("apk_url");
        bVar.f64880c = jSONObject.optString("download_key");
        bVar.f64881d = jSONObject.optBoolean("direcrt_download");
        return bVar;
    }
}
