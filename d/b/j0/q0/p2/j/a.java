package d.b.j0.q0.p2.j;

import d.b.i0.r.d0.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f60414b;

    /* renamed from: c  reason: collision with root package name */
    public int f60415c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f60416d = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f60413a = b.j().k("nani_key_download_show_position", 3);

    public a() {
        new HashSet();
        this.f60414b = new HashSet();
    }

    public void a(int i, String str) {
        this.f60414b.add(str);
        if (this.f60415c >= 0 || this.f60413a != this.f60414b.size()) {
            return;
        }
        this.f60415c = i;
    }

    public int b() {
        return this.f60415c;
    }

    public void c(long j) {
        this.f60416d = j;
    }

    public void d() {
        int k = b.j().k("nani_key_download_show_rate", 2);
        if (this.f60416d <= 0 || k == 1) {
            return;
        }
        b.j().w("key_horizontal_shown_time", this.f60416d);
    }
}
