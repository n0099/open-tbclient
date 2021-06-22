package d.a.m0.n.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.m0.n.h.i;
import d.a.m0.n.i.l.a;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class g implements d {
    public Map<String, String> A() {
        return null;
    }

    public void B(d.a.m0.n.h.a aVar) {
    }

    public void C() {
    }

    public void D() {
    }

    public void E() {
    }

    public void F(d.a.m0.n.o.f fVar) {
    }

    public void G(String str, int i2) {
    }

    public void H(String str, String str2, JSONObject jSONObject) {
    }

    @Override // d.a.m0.n.f.d
    public void b() {
    }

    @Override // d.a.m0.n.f.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    @Override // d.a.m0.n.f.d
    public void n(@Nullable String str, @Nullable String str2) {
    }

    public f p() {
        return null;
    }

    public c<d.a.m0.n.h.b> q() {
        return null;
    }

    public c<d.a.m0.n.h.d> r() {
        return null;
    }

    public Map<String, String> s() {
        return null;
    }

    public c<d.a.m0.n.h.f> t() {
        return null;
    }

    public a<a.C1137a> u() {
        return null;
    }

    public d.a.m0.n.j.k.c v(String str) {
        return null;
    }

    public c<d.a.m0.n.h.h> w() {
        return null;
    }

    public Map<String, String> x() {
        return null;
    }

    public c<i> y() {
        return null;
    }

    public c<d.a.m0.n.h.g> z() {
        return null;
    }
}
