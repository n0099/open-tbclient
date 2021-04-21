package d.b.j0.j3.h;

import tbclient.GetThemeList.ThemeList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f58255a;

    /* renamed from: b  reason: collision with root package name */
    public String f58256b;

    /* renamed from: c  reason: collision with root package name */
    public long f58257c;

    /* renamed from: d  reason: collision with root package name */
    public String f58258d;

    public String a() {
        return this.f58256b;
    }

    public String b() {
        return this.f58255a;
    }

    public String c() {
        return this.f58258d;
    }

    public long d() {
        return this.f58257c;
    }

    public void e(ThemeList themeList) {
        if (themeList == null) {
            return;
        }
        this.f58255a = themeList.name;
        this.f58256b = themeList.icon;
        this.f58257c = themeList.last_update_time.longValue();
        this.f58258d = themeList.type;
    }
}
