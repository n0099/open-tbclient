package d.a.h0.l.m.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.a.h0.p.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f47262b;

    /* renamed from: a  reason: collision with root package name */
    public C0993b f47263a = new C0993b();

    /* renamed from: d.a.h0.l.m.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0993b extends i {
        public C0993b() {
            super("swan_clean_stratey");
        }
    }

    public static b b() {
        if (f47262b == null) {
            synchronized (b.class) {
                if (f47262b == null) {
                    f47262b = new b();
                }
            }
        }
        return f47262b;
    }

    @NonNull
    public d.a.h0.l.m.i.a a() {
        d.a.h0.l.m.i.a aVar;
        try {
            aVar = d.a.h0.l.m.i.a.a(new JSONObject(this.f47263a.getString("data", "")));
        } catch (JSONException e2) {
            e2.printStackTrace();
            aVar = null;
        }
        return aVar == null ? d.a.h0.l.m.i.a.f47257e : aVar;
    }

    public String c() {
        return this.f47263a.getString("version", "0");
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
        this.f47263a.edit().putString("version", optString).putString("data", optString2).apply();
    }
}
