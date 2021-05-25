package d.a.n0.g1.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends k implements d.a.m0.g0.b.e {
    @Override // d.a.m0.g0.b.e
    public String f() {
        return null;
    }

    @Override // d.a.m0.g0.b.c
    public String getCacheKey() {
        return "atme_cache";
    }

    @Override // d.a.m0.g0.b.e
    public boolean k(String str) {
        try {
            initByJson(new JSONObject(str));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
