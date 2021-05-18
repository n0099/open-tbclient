package d.a.k0.q0.p2.j;

import d.a.j0.r.d0.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f59249b;

    /* renamed from: c  reason: collision with root package name */
    public int f59250c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f59251d = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f59248a = b.j().k("nani_key_download_show_position", 3);

    public a() {
        new HashSet();
        this.f59249b = new HashSet();
    }

    public void a(int i2, String str) {
        this.f59249b.add(str);
        if (this.f59250c >= 0 || this.f59248a != this.f59249b.size()) {
            return;
        }
        this.f59250c = i2;
    }

    public int b() {
        return this.f59250c;
    }

    public void c(long j) {
        this.f59251d = j;
    }

    public void d() {
        int k = b.j().k("nani_key_download_show_rate", 2);
        if (this.f59251d <= 0 || k == 1) {
            return;
        }
        b.j().w("key_horizontal_shown_time", this.f59251d);
    }
}
