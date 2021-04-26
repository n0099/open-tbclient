package d.a.j0.q0.p2.j;

import d.a.i0.r.d0.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f58507b;

    /* renamed from: c  reason: collision with root package name */
    public int f58508c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f58509d = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f58506a = b.j().k("nani_key_download_show_position", 3);

    public a() {
        new HashSet();
        this.f58507b = new HashSet();
    }

    public void a(int i2, String str) {
        this.f58507b.add(str);
        if (this.f58508c >= 0 || this.f58506a != this.f58507b.size()) {
            return;
        }
        this.f58508c = i2;
    }

    public int b() {
        return this.f58508c;
    }

    public void c(long j) {
        this.f58509d = j;
    }

    public void d() {
        int k = b.j().k("nani_key_download_show_rate", 2);
        if (this.f58509d <= 0 || k == 1) {
            return;
        }
        b.j().w("key_horizontal_shown_time", this.f58509d);
    }
}
