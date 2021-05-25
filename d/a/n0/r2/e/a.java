package d.a.n0.r2.e;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f59975a;

    /* renamed from: b  reason: collision with root package name */
    public String f59976b;

    /* renamed from: c  reason: collision with root package name */
    public String f59977c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59978d = true;

    public String a() {
        return this.f59975a;
    }

    public String b() {
        return this.f59976b;
    }

    public String c() {
        return this.f59977c;
    }

    public boolean d() {
        return this.f59978d;
    }

    public void e(Offpack offpack) {
        if (offpack != null) {
            this.f59975a = offpack.src;
            this.f59976b = offpack.md5;
            this.f59977c = offpack.webview_version;
            this.f59978d = offpack.is_use.intValue() == 1;
        }
    }
}
