package d.b.g0.l.m.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.b.g0.p.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f49026b;

    /* renamed from: a  reason: collision with root package name */
    public C1021b f49027a = new C1021b();

    /* renamed from: d.b.g0.l.m.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1021b extends i {
        public C1021b() {
            super("swan_clean_stratey");
        }
    }

    public static b b() {
        if (f49026b == null) {
            synchronized (b.class) {
                if (f49026b == null) {
                    f49026b = new b();
                }
            }
        }
        return f49026b;
    }

    @NonNull
    public d.b.g0.l.m.i.a a() {
        d.b.g0.l.m.i.a aVar;
        try {
            aVar = d.b.g0.l.m.i.a.a(new JSONObject(this.f49027a.getString("data", "")));
        } catch (JSONException e2) {
            e2.printStackTrace();
            aVar = null;
        }
        return aVar == null ? d.b.g0.l.m.i.a.f49021e : aVar;
    }

    public String c() {
        return this.f49027a.getString("version", "0");
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        String optString2 = jSONObject.optString("data");
        if (TextUtils.isEmpty(optString2)) {
            return;
        }
        this.f49027a.edit().putString("version", optString).putString("data", optString2).apply();
    }
}
