package d.a.l0.g.c.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f50694a = new d();
    }

    public static d b() {
        return a.f50694a;
    }

    public void a(@NonNull JSONObject jSONObject, @NonNull d.a.l0.g.c.f.b bVar) {
        boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
        String optString = jSONObject.optString("url");
        if (!optBoolean) {
            bVar.b(new d.a.l0.g.c.g.a(31008, "download is not exist"));
        } else {
            d.a.l0.h.t.a.c().c(optString);
        }
    }

    public void c(@NonNull JSONObject jSONObject, @NonNull d.a.l0.g.c.f.b bVar) {
        boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
        String optString = jSONObject.optString("url");
        if (!optBoolean) {
            bVar.b(new d.a.l0.g.c.g.a(31008, "download is not exist"));
        } else {
            d.a.l0.h.t.a.c().e(optString);
        }
    }

    public void d(@NonNull JSONObject jSONObject, @NonNull d.a.l0.g.c.f.b bVar) {
        boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
        if (!optBoolean) {
            bVar.b(new d.a.l0.g.c.g.a(31008, "download is not exist"));
            return;
        }
        String optString = jSONObject.optString("packageName");
        String optString2 = jSONObject.optString("apkId");
        String optString3 = jSONObject.optString("url");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            if (d.a.l0.h.t.a.c().a(optString3, optString, optString2, optBoolean, new f(bVar))) {
                return;
            }
            bVar.b(new d.a.l0.g.c.g.a(31006, "is not in main process"));
            return;
        }
        bVar.b(new d.a.l0.g.c.g.a(31007, "invalid params"));
    }

    public void e(@NonNull JSONObject jSONObject, @NonNull d.a.l0.g.c.f.b bVar) {
        boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
        String optString = jSONObject.optString("url");
        if (!optBoolean) {
            bVar.b(new d.a.l0.g.c.g.a(31008, "download is not exist"));
        } else {
            d.a.l0.h.t.a.c().f(optString);
        }
    }
}
