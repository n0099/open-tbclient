package d.a.o0.k3.h;

import tbclient.GetThemeList.ThemeList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f60950a;

    /* renamed from: b  reason: collision with root package name */
    public String f60951b;

    /* renamed from: c  reason: collision with root package name */
    public long f60952c;

    /* renamed from: d  reason: collision with root package name */
    public String f60953d;

    public String a() {
        return this.f60951b;
    }

    public String b() {
        return this.f60950a;
    }

    public String c() {
        return this.f60953d;
    }

    public long d() {
        return this.f60952c;
    }

    public void e(ThemeList themeList) {
        if (themeList == null) {
            return;
        }
        this.f60950a = themeList.name;
        this.f60951b = themeList.icon;
        this.f60952c = themeList.last_update_time.longValue();
        this.f60953d = themeList.type;
    }
}
