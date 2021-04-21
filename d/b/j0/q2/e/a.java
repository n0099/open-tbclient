package d.b.j0.q2.e;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f60959a;

    /* renamed from: b  reason: collision with root package name */
    public String f60960b;

    /* renamed from: c  reason: collision with root package name */
    public String f60961c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60962d = true;

    public String a() {
        return this.f60959a;
    }

    public String b() {
        return this.f60960b;
    }

    public String c() {
        return this.f60961c;
    }

    public boolean d() {
        return this.f60962d;
    }

    public void e(Offpack offpack) {
        if (offpack != null) {
            this.f60959a = offpack.src;
            this.f60960b = offpack.md5;
            this.f60961c = offpack.webview_version;
            this.f60962d = offpack.is_use.intValue() == 1;
        }
    }
}
