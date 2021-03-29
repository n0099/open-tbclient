package d.b.i0.a0;

import tbclient.DefaultInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f51850a;

    /* renamed from: b  reason: collision with root package name */
    public String f51851b;

    public String a() {
        return this.f51850a;
    }

    public String b() {
        return this.f51851b;
    }

    public void c(DefaultInfo defaultInfo) {
        if (defaultInfo == null) {
            return;
        }
        this.f51850a = defaultInfo.icon;
        this.f51851b = defaultInfo.url;
    }
}
