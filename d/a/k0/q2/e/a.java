package d.a.k0.q2.e;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f59834a;

    /* renamed from: b  reason: collision with root package name */
    public String f59835b;

    /* renamed from: c  reason: collision with root package name */
    public String f59836c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59837d = true;

    public String a() {
        return this.f59834a;
    }

    public String b() {
        return this.f59835b;
    }

    public String c() {
        return this.f59836c;
    }

    public boolean d() {
        return this.f59837d;
    }

    public void e(Offpack offpack) {
        if (offpack != null) {
            this.f59834a = offpack.src;
            this.f59835b = offpack.md5;
            this.f59836c = offpack.webview_version;
            this.f59837d = offpack.is_use.intValue() == 1;
        }
    }
}
