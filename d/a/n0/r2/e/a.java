package d.a.n0.r2.e;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f63666a;

    /* renamed from: b  reason: collision with root package name */
    public String f63667b;

    /* renamed from: c  reason: collision with root package name */
    public String f63668c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63669d = true;

    public String a() {
        return this.f63666a;
    }

    public String b() {
        return this.f63667b;
    }

    public String c() {
        return this.f63668c;
    }

    public boolean d() {
        return this.f63669d;
    }

    public void e(Offpack offpack) {
        if (offpack != null) {
            this.f63666a = offpack.src;
            this.f63667b = offpack.md5;
            this.f63668c = offpack.webview_version;
            this.f63669d = offpack.is_use.intValue() == 1;
        }
    }
}
