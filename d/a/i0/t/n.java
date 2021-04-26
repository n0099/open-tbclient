package d.a.i0.t;

import tbclient.Pendant;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public long f49908a;

    /* renamed from: b  reason: collision with root package name */
    public String f49909b;

    public String a() {
        return this.f49909b;
    }

    public long b() {
        return this.f49908a;
    }

    public void c(Pendant pendant) {
        if (pendant == null) {
            return;
        }
        this.f49908a = pendant.props_id.longValue();
        this.f49909b = pendant.img_url;
    }

    public void d(String str) {
        this.f49909b = str;
    }

    public void e(long j) {
        this.f49908a = j;
    }
}
