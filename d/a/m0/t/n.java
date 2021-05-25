package d.a.m0.t;

import tbclient.Pendant;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public long f50800a;

    /* renamed from: b  reason: collision with root package name */
    public String f50801b;

    public String a() {
        return this.f50801b;
    }

    public long b() {
        return this.f50800a;
    }

    public void c(Pendant pendant) {
        if (pendant == null) {
            return;
        }
        this.f50800a = pendant.props_id.longValue();
        this.f50801b = pendant.img_url;
    }

    public void d(String str) {
        this.f50801b = str;
    }

    public void e(long j) {
        this.f50800a = j;
    }
}
