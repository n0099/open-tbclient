package d.a.h0.f.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.h0.a.p.c.w0;
import d.a.h0.a.r1.e;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements w0 {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f46022a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.f.g.a f46023b = new d.a.h0.f.g.a();

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.p0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.p0.b f46024a;

        public a(d.a.h0.a.p0.b bVar) {
            this.f46024a = bVar;
        }

        @Override // d.a.h0.a.p0.b
        public void a(@Nullable JSONObject jSONObject) {
            b.this.g(true);
            this.f46024a.a(jSONObject);
        }

        @Override // d.a.h0.a.p0.b
        public void onFail(int i2, @Nullable String str) {
            b.this.g(false);
            this.f46024a.onFail(i2, str);
        }
    }

    @Override // d.a.h0.a.p.c.w0
    @Nullable
    public d.a.h0.a.t.e.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.h0.a.p0.b bVar) {
        if (f()) {
            bVar.a(null);
            return null;
        }
        return this.f46023b.a(jSONObject, c(bVar));
    }

    public final d.a.h0.a.p0.b c(@NonNull d.a.h0.a.p0.b bVar) {
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
        return TextUtils.equals(this.f46023b.f46027a, str);
    }

    public boolean f() {
        Boolean bool;
        String d2 = d();
        if (TextUtils.isEmpty(d2) || (bool = this.f46022a.get(d2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void g(boolean z) {
        String d2 = d();
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        this.f46022a.put(d2, Boolean.valueOf(z));
    }
}
