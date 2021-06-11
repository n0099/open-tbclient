package d.a.l0.n.j.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f51808c;

    /* renamed from: a  reason: collision with root package name */
    public final a f51809a = new a();

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.n.j.i.a f51810b;

    /* loaded from: classes3.dex */
    public static class a extends d.a.l0.t.j {
        public a() {
            super("swan_clean_stratey");
        }
    }

    public static b b() {
        if (f51808c == null) {
            synchronized (b.class) {
                if (f51808c == null) {
                    f51808c = new b();
                }
            }
        }
        return f51808c;
    }

    @NonNull
    public d.a.l0.n.j.i.a a() {
        if (this.f51810b == null) {
            synchronized (b.class) {
                if (this.f51810b == null) {
                    this.f51810b = d.a.l0.n.j.i.a.b(this.f51809a.getString("data", ""));
                }
            }
        }
        return this.f51810b;
    }

    public String c() {
        return this.f51809a.getString("version", "0");
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
        this.f51809a.edit().putString("version", optString).putString("data", optString2).apply();
    }
}
