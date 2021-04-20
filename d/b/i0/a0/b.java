package d.b.i0.a0;

import tbclient.DefaultInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f52274a;

    /* renamed from: b  reason: collision with root package name */
    public String f52275b;

    public String a() {
        return this.f52274a;
    }

    public String b() {
        return this.f52275b;
    }

    public void c(DefaultInfo defaultInfo) {
        if (defaultInfo == null) {
            return;
        }
        this.f52274a = defaultInfo.icon;
        this.f52275b = defaultInfo.url;
    }
}
