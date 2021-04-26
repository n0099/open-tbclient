package d.a.j0.q2.e;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f59089a;

    /* renamed from: b  reason: collision with root package name */
    public String f59090b;

    /* renamed from: c  reason: collision with root package name */
    public String f59091c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59092d = true;

    public String a() {
        return this.f59089a;
    }

    public String b() {
        return this.f59090b;
    }

    public String c() {
        return this.f59091c;
    }

    public boolean d() {
        return this.f59092d;
    }

    public void e(Offpack offpack) {
        if (offpack != null) {
            this.f59089a = offpack.src;
            this.f59090b = offpack.md5;
            this.f59091c = offpack.webview_version;
            this.f59092d = offpack.is_use.intValue() == 1;
        }
    }
}
