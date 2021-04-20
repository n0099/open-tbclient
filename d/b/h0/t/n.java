package d.b.h0.t;

import tbclient.Pendant;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public long f51903a;

    /* renamed from: b  reason: collision with root package name */
    public String f51904b;

    public String a() {
        return this.f51904b;
    }

    public long b() {
        return this.f51903a;
    }

    public void c(Pendant pendant) {
        if (pendant == null) {
            return;
        }
        this.f51903a = pendant.props_id.longValue();
        this.f51904b = pendant.img_url;
    }

    public void d(String str) {
        this.f51904b = str;
    }

    public void e(long j) {
        this.f51903a = j;
    }
}
