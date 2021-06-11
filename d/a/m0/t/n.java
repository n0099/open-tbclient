package d.a.m0.t;

import tbclient.Pendant;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public long f54477a;

    /* renamed from: b  reason: collision with root package name */
    public String f54478b;

    public String a() {
        return this.f54478b;
    }

    public long b() {
        return this.f54477a;
    }

    public void c(Pendant pendant) {
        if (pendant == null) {
            return;
        }
        this.f54477a = pendant.props_id.longValue();
        this.f54478b = pendant.img_url;
    }

    public void d(String str) {
        this.f54478b = str;
    }

    public void e(long j) {
        this.f54477a = j;
    }
}
