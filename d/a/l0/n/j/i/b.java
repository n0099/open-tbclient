package d.a.l0.n.j.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f48134c;

    /* renamed from: a  reason: collision with root package name */
    public final a f48135a = new a();

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.n.j.i.a f48136b;

    /* loaded from: classes3.dex */
    public static class a extends d.a.l0.t.j {
        public a() {
            super("swan_clean_stratey");
        }
    }

    public static b b() {
        if (f48134c == null) {
            synchronized (b.class) {
                if (f48134c == null) {
                    f48134c = new b();
                }
            }
        }
        return f48134c;
    }

    @NonNull
    public d.a.l0.n.j.i.a a() {
        if (this.f48136b == null) {
            synchronized (b.class) {
                if (this.f48136b == null) {
                    this.f48136b = d.a.l0.n.j.i.a.b(this.f48135a.getString("data", ""));
                }
            }
        }
        return this.f48136b;
    }

    public String c() {
        return this.f48135a.getString("version", "0");
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
        this.f48135a.edit().putString("version", optString).putString("data", optString2).apply();
    }
}
