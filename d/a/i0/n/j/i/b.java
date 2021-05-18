package d.a.i0.n.j.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f47958c;

    /* renamed from: a  reason: collision with root package name */
    public final a f47959a = new a();

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.n.j.i.a f47960b;

    /* loaded from: classes3.dex */
    public static class a extends d.a.i0.t.j {
        public a() {
            super("swan_clean_stratey");
        }
    }

    public static b b() {
        if (f47958c == null) {
            synchronized (b.class) {
                if (f47958c == null) {
                    f47958c = new b();
                }
            }
        }
        return f47958c;
    }

    @NonNull
    public d.a.i0.n.j.i.a a() {
        if (this.f47960b == null) {
            synchronized (b.class) {
                if (this.f47960b == null) {
                    this.f47960b = d.a.i0.n.j.i.a.b(this.f47959a.getString("data", ""));
                }
            }
        }
        return this.f47960b;
    }

    public String c() {
        return this.f47959a.getString("version", "0");
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
        this.f47959a.edit().putString("version", optString).putString("data", optString2).apply();
    }
}
