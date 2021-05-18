package d.a.i0.g.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.i0.a.a2.e;
import d.a.i0.a.p.d.f1;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements f1 {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f46896a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.g.d.a f46897b = new d.a.i0.g.d.a();

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.u0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.u0.b f46898a;

        public a(d.a.i0.a.u0.b bVar) {
            this.f46898a = bVar;
        }

        @Override // d.a.i0.a.u0.b
        public void b(@Nullable JSONObject jSONObject) {
            b.this.g(true);
            this.f46898a.b(jSONObject);
        }

        @Override // d.a.i0.a.u0.b
        public void onFail(int i2, @Nullable String str) {
            b.this.g(false);
            this.f46898a.onFail(i2, str);
        }
    }

    @Override // d.a.i0.a.p.d.f1
    @Nullable
    public d.a.i0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.i0.a.u0.b bVar) {
        if (f()) {
            bVar.b(null);
            return null;
        }
        return this.f46897b.a(jSONObject, c(bVar));
    }

    public final d.a.i0.a.u0.b c(@NonNull d.a.i0.a.u0.b bVar) {
        return new a(bVar);
    }

    public final String d() {
        e Q = e.Q();
        if (Q != null) {
            return Q.D();
        }
        return null;
    }

    public boolean e(String str) {
        return TextUtils.equals(this.f46897b.f46901a, str);
    }

    public boolean f() {
        Boolean bool;
        String d2 = d();
        if (TextUtils.isEmpty(d2) || (bool = this.f46896a.get(d2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void g(boolean z) {
        String d2 = d();
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        this.f46896a.put(d2, Boolean.valueOf(z));
    }
}
