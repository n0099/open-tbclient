package d.a.n0.k3.h;

import tbclient.GetThemeList.ThemeList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f60825a;

    /* renamed from: b  reason: collision with root package name */
    public String f60826b;

    /* renamed from: c  reason: collision with root package name */
    public long f60827c;

    /* renamed from: d  reason: collision with root package name */
    public String f60828d;

    public String a() {
        return this.f60826b;
    }

    public String b() {
        return this.f60825a;
    }

    public String c() {
        return this.f60828d;
    }

    public long d() {
        return this.f60827c;
    }

    public void e(ThemeList themeList) {
        if (themeList == null) {
            return;
        }
        this.f60825a = themeList.name;
        this.f60826b = themeList.icon;
        this.f60827c = themeList.last_update_time.longValue();
        this.f60828d = themeList.type;
    }
}
