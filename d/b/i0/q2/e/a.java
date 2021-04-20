package d.b.i0.q2.e;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f60538a;

    /* renamed from: b  reason: collision with root package name */
    public String f60539b;

    /* renamed from: c  reason: collision with root package name */
    public String f60540c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60541d = true;

    public String a() {
        return this.f60538a;
    }

    public String b() {
        return this.f60539b;
    }

    public String c() {
        return this.f60540c;
    }

    public boolean d() {
        return this.f60541d;
    }

    public void e(Offpack offpack) {
        if (offpack != null) {
            this.f60538a = offpack.src;
            this.f60539b = offpack.md5;
            this.f60540c = offpack.webview_version;
            this.f60541d = offpack.is_use.intValue() == 1;
        }
    }
}
