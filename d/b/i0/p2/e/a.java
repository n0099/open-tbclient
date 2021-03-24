package d.b.i0.p2.e;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f58869a;

    /* renamed from: b  reason: collision with root package name */
    public String f58870b;

    /* renamed from: c  reason: collision with root package name */
    public String f58871c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58872d = true;

    public String a() {
        return this.f58869a;
    }

    public String b() {
        return this.f58870b;
    }

    public String c() {
        return this.f58871c;
    }

    public boolean d() {
        return this.f58872d;
    }

    public void e(Offpack offpack) {
        if (offpack != null) {
            this.f58869a = offpack.src;
            this.f58870b = offpack.md5;
            this.f58871c = offpack.webview_version;
            this.f58872d = offpack.is_use.intValue() == 1;
        }
    }
}
