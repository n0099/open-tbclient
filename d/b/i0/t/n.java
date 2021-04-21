package d.b.i0.t;

import tbclient.Pendant;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public long f52239a;

    /* renamed from: b  reason: collision with root package name */
    public String f52240b;

    public String a() {
        return this.f52240b;
    }

    public long b() {
        return this.f52239a;
    }

    public void c(Pendant pendant) {
        if (pendant == null) {
            return;
        }
        this.f52239a = pendant.props_id.longValue();
        this.f52240b = pendant.img_url;
    }

    public void d(String str) {
        this.f52240b = str;
    }

    public void e(long j) {
        this.f52239a = j;
    }
}
