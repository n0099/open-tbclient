package d.b.h0.t;

import tbclient.Pendant;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public long f51484a;

    /* renamed from: b  reason: collision with root package name */
    public String f51485b;

    public String a() {
        return this.f51485b;
    }

    public long b() {
        return this.f51484a;
    }

    public void c(Pendant pendant) {
        if (pendant == null) {
            return;
        }
        this.f51484a = pendant.props_id.longValue();
        this.f51485b = pendant.img_url;
    }

    public void d(String str) {
        this.f51485b = str;
    }

    public void e(long j) {
        this.f51484a = j;
    }
}
