package d.a.j0.t;

import tbclient.Pendant;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public long f50727a;

    /* renamed from: b  reason: collision with root package name */
    public String f50728b;

    public String a() {
        return this.f50728b;
    }

    public long b() {
        return this.f50727a;
    }

    public void c(Pendant pendant) {
        if (pendant == null) {
            return;
        }
        this.f50727a = pendant.props_id.longValue();
        this.f50728b = pendant.img_url;
    }

    public void d(String str) {
        this.f50728b = str;
    }

    public void e(long j) {
        this.f50727a = j;
    }
}
