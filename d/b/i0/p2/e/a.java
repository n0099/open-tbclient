package d.b.i0.p2.e;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f58870a;

    /* renamed from: b  reason: collision with root package name */
    public String f58871b;

    /* renamed from: c  reason: collision with root package name */
    public String f58872c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58873d = true;

    public String a() {
        return this.f58870a;
    }

    public String b() {
        return this.f58871b;
    }

    public String c() {
        return this.f58872c;
    }

    public boolean d() {
        return this.f58873d;
    }

    public void e(Offpack offpack) {
        if (offpack != null) {
            this.f58870a = offpack.src;
            this.f58871b = offpack.md5;
            this.f58872c = offpack.webview_version;
            this.f58873d = offpack.is_use.intValue() == 1;
        }
    }
}
