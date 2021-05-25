package d.a.n0.k3.h;

import tbclient.GetThemeList.ThemeList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f57136a;

    /* renamed from: b  reason: collision with root package name */
    public String f57137b;

    /* renamed from: c  reason: collision with root package name */
    public long f57138c;

    /* renamed from: d  reason: collision with root package name */
    public String f57139d;

    public String a() {
        return this.f57137b;
    }

    public String b() {
        return this.f57136a;
    }

    public String c() {
        return this.f57139d;
    }

    public long d() {
        return this.f57138c;
    }

    public void e(ThemeList themeList) {
        if (themeList == null) {
            return;
        }
        this.f57136a = themeList.name;
        this.f57137b = themeList.icon;
        this.f57138c = themeList.last_update_time.longValue();
        this.f57139d = themeList.type;
    }
}
