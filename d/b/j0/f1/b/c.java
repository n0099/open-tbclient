package d.b.j0.f1.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends k implements d.b.i0.g0.b.e {
    @Override // d.b.i0.g0.b.e
    public boolean a(String str) {
        try {
            initByJson(new JSONObject(str));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // d.b.i0.g0.b.c
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // d.b.i0.g0.b.e
    public String l() {
        return null;
    }
}
