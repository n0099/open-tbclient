package d.b.i0.p0.o2.j;

import d.b.h0.r.d0.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f58320b;

    /* renamed from: c  reason: collision with root package name */
    public int f58321c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f58322d = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f58319a = b.i().j("nani_key_download_show_position", 3);

    public a() {
        new HashSet();
        this.f58320b = new HashSet();
    }

    public void a(int i, String str) {
        this.f58320b.add(str);
        if (this.f58321c >= 0 || this.f58319a != this.f58320b.size()) {
            return;
        }
        this.f58321c = i;
    }

    public int b() {
        return this.f58321c;
    }

    public void c(long j) {
        this.f58322d = j;
    }

    public void d() {
        int j = b.i().j("nani_key_download_show_rate", 2);
        if (this.f58322d <= 0 || j == 1) {
            return;
        }
        b.i().v("key_horizontal_shown_time", this.f58322d);
    }
}
