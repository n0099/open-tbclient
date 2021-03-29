package d.b.i0.e1.b;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends k implements d.b.h0.g0.b.e {
    @Override // d.b.h0.g0.b.e
    public boolean a(String str) {
        try {
            initByJson(new JSONObject(str));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // d.b.h0.g0.b.c
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // d.b.h0.g0.b.e
    public String l() {
        return null;
    }
}
