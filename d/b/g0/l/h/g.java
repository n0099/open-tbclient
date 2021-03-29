package d.b.g0.l.h;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.b.g0.l.k.i;
import d.b.g0.l.l.j.a;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class g implements d {
    public c<d.b.g0.l.k.g> A() {
        return null;
    }

    public Map<String, String> B() {
        return null;
    }

    public void C(d.b.g0.l.k.a aVar) {
    }

    public void D() {
    }

    public void E() {
    }

    public void F() {
    }

    public void G(d.b.g0.l.r.f fVar) {
    }

    public void H(String str, int i) {
    }

    public void I(String str, String str2, JSONObject jSONObject) {
    }

    @Override // d.b.g0.l.h.e
    @NonNull
    public Bundle g(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            k(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    @Override // d.b.g0.l.h.d
    public void h() {
    }

    @Override // d.b.g0.l.h.d
    public void k(@Nullable String str, @Nullable String str2) {
    }

    public f q() {
        return null;
    }

    public c<d.b.g0.l.k.b> r() {
        return null;
    }

    public c<d.b.g0.l.k.d> s() {
        return null;
    }

    public Map<String, String> t() {
        return null;
    }

    public c<d.b.g0.l.k.f> u() {
        return null;
    }

    public a<a.C1020a> v() {
        return null;
    }

    public d.b.g0.l.m.k.c w(String str) {
        return null;
    }

    public c<d.b.g0.l.k.h> x() {
        return null;
    }

    public Map<String, String> y() {
        return null;
    }

    public c<i> z() {
        return null;
    }
}
