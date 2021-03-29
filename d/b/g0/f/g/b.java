package d.b.g0.f.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.a.p.c.w0;
import d.b.g0.a.r1.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements w0 {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f47840a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.f.g.a f47841b = new d.b.g0.f.g.a();

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.p0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.p0.b f47842a;

        public a(d.b.g0.a.p0.b bVar) {
            this.f47842a = bVar;
        }

        @Override // d.b.g0.a.p0.b
        public void a(@Nullable JSONObject jSONObject) {
            b.this.g(true);
            this.f47842a.a(jSONObject);
        }

        @Override // d.b.g0.a.p0.b
        public void onFail(int i, @Nullable String str) {
            b.this.g(false);
            this.f47842a.onFail(i, str);
        }
    }

    @Override // d.b.g0.a.p.c.w0
    @Nullable
    public d.b.g0.a.t.e.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.b.g0.a.p0.b bVar) {
        if (f()) {
            bVar.a(null);
            return null;
        }
        return this.f47841b.a(jSONObject, c(bVar));
    }

    public final d.b.g0.a.p0.b c(@NonNull d.b.g0.a.p0.b bVar) {
        return new a(bVar);
    }

    public final String d() {
        e O = e.O();
        if (O != null) {
            return O.B();
        }
        return null;
    }

    public boolean e(String str) {
        return TextUtils.equals(this.f47841b.f47845a, str);
    }

    public boolean f() {
        Boolean bool;
        String d2 = d();
        if (TextUtils.isEmpty(d2) || (bool = this.f47840a.get(d2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void g(boolean z) {
        String d2 = d();
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        this.f47840a.put(d2, Boolean.valueOf(z));
    }
}
