package d.b.i0.q0.p2.j;

import d.b.h0.r.d0.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f59993b;

    /* renamed from: c  reason: collision with root package name */
    public int f59994c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f59995d = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f59992a = b.j().k("nani_key_download_show_position", 3);

    public a() {
        new HashSet();
        this.f59993b = new HashSet();
    }

    public void a(int i, String str) {
        this.f59993b.add(str);
        if (this.f59994c >= 0 || this.f59992a != this.f59993b.size()) {
            return;
        }
        this.f59994c = i;
    }

    public int b() {
        return this.f59994c;
    }

    public void c(long j) {
        this.f59995d = j;
    }

    public void d() {
        int k = b.j().k("nani_key_download_show_rate", 2);
        if (this.f59995d <= 0 || k == 1) {
            return;
        }
        b.j().w("key_horizontal_shown_time", this.f59995d);
    }
}
