package d.b.j0.a0;

import tbclient.DefaultInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f52695a;

    /* renamed from: b  reason: collision with root package name */
    public String f52696b;

    public String a() {
        return this.f52695a;
    }

    public String b() {
        return this.f52696b;
    }

    public void c(DefaultInfo defaultInfo) {
        if (defaultInfo == null) {
            return;
        }
        this.f52695a = defaultInfo.icon;
        this.f52696b = defaultInfo.url;
    }
}
