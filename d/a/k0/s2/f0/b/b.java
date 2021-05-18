package d.a.k0.s2.f0.b;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f60959a;

    /* renamed from: b  reason: collision with root package name */
    public String f60960b;

    /* renamed from: c  reason: collision with root package name */
    public String f60961c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60962d;

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.f60959a = jSONObject.optString("apk_name");
        bVar.f60960b = jSONObject.optString("apk_url");
        bVar.f60961c = jSONObject.optString("download_key");
        bVar.f60962d = jSONObject.optBoolean("direcrt_download");
        return bVar;
    }
}
