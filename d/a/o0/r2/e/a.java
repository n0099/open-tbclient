package d.a.o0.r2.e;

import tbclient.GetWebviewCacheInfo.Offpack;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f63791a;

    /* renamed from: b  reason: collision with root package name */
    public String f63792b;

    /* renamed from: c  reason: collision with root package name */
    public String f63793c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63794d = true;

    public String a() {
        return this.f63791a;
    }

    public String b() {
        return this.f63792b;
    }

    public String c() {
        return this.f63793c;
    }

    public boolean d() {
        return this.f63794d;
    }

    public void e(Offpack offpack) {
        if (offpack != null) {
            this.f63791a = offpack.src;
            this.f63792b = offpack.md5;
            this.f63793c = offpack.webview_version;
            this.f63794d = offpack.is_use.intValue() == 1;
        }
    }
}
