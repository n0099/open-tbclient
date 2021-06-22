package d.a.n0.t;

import tbclient.Pendant;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public long f54584a;

    /* renamed from: b  reason: collision with root package name */
    public String f54585b;

    public String a() {
        return this.f54585b;
    }

    public long b() {
        return this.f54584a;
    }

    public void c(Pendant pendant) {
        if (pendant == null) {
            return;
        }
        this.f54584a = pendant.props_id.longValue();
        this.f54585b = pendant.img_url;
    }

    public void d(String str) {
        this.f54585b = str;
    }

    public void e(long j) {
        this.f54584a = j;
    }
}
