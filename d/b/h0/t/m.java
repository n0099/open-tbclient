package d.b.h0.t;

import tbclient.Pendant;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public long f51485a;

    /* renamed from: b  reason: collision with root package name */
    public String f51486b;

    public String a() {
        return this.f51486b;
    }

    public long b() {
        return this.f51485a;
    }

    public void c(Pendant pendant) {
        if (pendant == null) {
            return;
        }
        this.f51485a = pendant.props_id.longValue();
        this.f51486b = pendant.img_url;
    }

    public void d(String str) {
        this.f51486b = str;
    }

    public void e(long j) {
        this.f51485a = j;
    }
}
