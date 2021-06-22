package d.a.m0.n.j.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f51916c;

    /* renamed from: a  reason: collision with root package name */
    public final a f51917a = new a();

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.n.j.i.a f51918b;

    /* loaded from: classes3.dex */
    public static class a extends d.a.m0.t.j {
        public a() {
            super("swan_clean_stratey");
        }
    }

    public static b b() {
        if (f51916c == null) {
            synchronized (b.class) {
                if (f51916c == null) {
                    f51916c = new b();
                }
            }
        }
        return f51916c;
    }

    @NonNull
    public d.a.m0.n.j.i.a a() {
        if (this.f51918b == null) {
            synchronized (b.class) {
                if (this.f51918b == null) {
                    this.f51918b = d.a.m0.n.j.i.a.b(this.f51917a.getString("data", ""));
                }
            }
        }
        return this.f51918b;
    }

    public String c() {
        return this.f51917a.getString("version", "0");
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
        this.f51917a.edit().putString("version", optString).putString("data", optString2).apply();
    }
}
