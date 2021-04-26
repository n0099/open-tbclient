package d.a.h0.l.h;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.a.h0.l.k.i;
import d.a.h0.l.l.j.a;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class g implements d {
    public Map<String, String> A() {
        return null;
    }

    public void B(d.a.h0.l.k.a aVar) {
    }

    public void C() {
    }

    public void D() {
    }

    public void E() {
    }

    public void F(d.a.h0.l.r.f fVar) {
    }

    public void G(String str, int i2) {
    }

    public void H(String str, String str2, JSONObject jSONObject) {
    }

    @Override // d.a.h0.l.h.d
    public void c() {
    }

    @Override // d.a.h0.l.h.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        Bundle bundle2 = new Bundle();
        if (set.contains("event_performance_ubc")) {
            n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
            set.remove("event_performance_ubc");
        }
        return bundle2;
    }

    @Override // d.a.h0.l.h.d
    public void n(@Nullable String str, @Nullable String str2) {
    }

    public f p() {
        return null;
    }

    public c<d.a.h0.l.k.b> q() {
        return null;
    }

    public c<d.a.h0.l.k.d> r() {
        return null;
    }

    public Map<String, String> s() {
        return null;
    }

    public c<d.a.h0.l.k.f> t() {
        return null;
    }

    public a<a.C0991a> u() {
        return null;
    }

    public d.a.h0.l.m.k.c v(String str) {
        return null;
    }

    public c<d.a.h0.l.k.h> w() {
        return null;
    }

    public Map<String, String> x() {
        return null;
    }

    public c<i> y() {
        return null;
    }

    public c<d.a.h0.l.k.g> z() {
        return null;
    }
}
