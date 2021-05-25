package d.a.n0.r0.p2.j;

import d.a.m0.r.d0.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f59390b;

    /* renamed from: c  reason: collision with root package name */
    public int f59391c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f59392d = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f59389a = b.j().k("nani_key_download_show_position", 3);

    public a() {
        new HashSet();
        this.f59390b = new HashSet();
    }

    public void a(int i2, String str) {
        this.f59390b.add(str);
        if (this.f59391c >= 0 || this.f59389a != this.f59390b.size()) {
            return;
        }
        this.f59391c = i2;
    }

    public int b() {
        return this.f59391c;
    }

    public void c(long j) {
        this.f59392d = j;
    }

    public void d() {
        int k = b.j().k("nani_key_download_show_rate", 2);
        if (this.f59392d <= 0 || k == 1) {
            return;
        }
        b.j().w("key_horizontal_shown_time", this.f59392d);
    }
}
