package d.a.o0.r0.p2.j;

import d.a.n0.r.d0.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f63206b;

    /* renamed from: c  reason: collision with root package name */
    public int f63207c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f63208d = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f63205a = b.j().k("nani_key_download_show_position", 3);

    public a() {
        new HashSet();
        this.f63206b = new HashSet();
    }

    public void a(int i2, String str) {
        this.f63206b.add(str);
        if (this.f63207c >= 0 || this.f63205a != this.f63206b.size()) {
            return;
        }
        this.f63207c = i2;
    }

    public int b() {
        return this.f63207c;
    }

    public void c(long j) {
        this.f63208d = j;
    }

    public void d() {
        int k = b.j().k("nani_key_download_show_rate", 2);
        if (this.f63208d <= 0 || k == 1) {
            return;
        }
        b.j().w("key_horizontal_shown_time", this.f63208d);
    }
}
