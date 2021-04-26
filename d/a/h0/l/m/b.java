package d.a.h0.l.m;

import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b implements e {
    public static <T> T e(@Nullable T t, @Nullable c<T> cVar) {
        if (t != null && cVar != null) {
            cVar.a(t);
        }
        return t;
    }

    @Override // d.a.h0.l.m.e
    @Nullable
    public JSONObject a(@Nullable c<JSONObject> cVar) {
        JSONObject d2 = d();
        e(d2, cVar);
        return d2;
    }

    @Override // d.a.h0.l.m.e
    @Nullable
    public JSONArray b(@Nullable c<JSONArray> cVar) {
        JSONArray c2 = c();
        e(c2, cVar);
        return c2;
    }

    @Nullable
    public JSONArray c() {
        return null;
    }

    @Nullable
    public JSONObject d() {
        return null;
    }
}
