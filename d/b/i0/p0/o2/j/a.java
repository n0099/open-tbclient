package d.b.i0.p0.o2.j;

import d.b.h0.r.d0.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f58319b;

    /* renamed from: c  reason: collision with root package name */
    public int f58320c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f58321d = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f58318a = b.i().j("nani_key_download_show_position", 3);

    public a() {
        new HashSet();
        this.f58319b = new HashSet();
    }

    public void a(int i, String str) {
        this.f58319b.add(str);
        if (this.f58320c >= 0 || this.f58318a != this.f58319b.size()) {
            return;
        }
        this.f58320c = i;
    }

    public int b() {
        return this.f58320c;
    }

    public void c(long j) {
        this.f58321d = j;
    }

    public void d() {
        int j = b.i().j("nani_key_download_show_rate", 2);
        if (this.f58321d <= 0 || j == 1) {
            return;
        }
        b.i().v("key_horizontal_shown_time", this.f58321d);
    }
}
