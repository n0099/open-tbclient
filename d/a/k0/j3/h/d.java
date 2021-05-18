package d.a.k0.j3.h;

import tbclient.GetThemeList.ThemeList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56956a;

    /* renamed from: b  reason: collision with root package name */
    public String f56957b;

    /* renamed from: c  reason: collision with root package name */
    public long f56958c;

    /* renamed from: d  reason: collision with root package name */
    public String f56959d;

    public String a() {
        return this.f56957b;
    }

    public String b() {
        return this.f56956a;
    }

    public String c() {
        return this.f56959d;
    }

    public long d() {
        return this.f56958c;
    }

    public void e(ThemeList themeList) {
        if (themeList == null) {
            return;
        }
        this.f56956a = themeList.name;
        this.f56957b = themeList.icon;
        this.f56958c = themeList.last_update_time.longValue();
        this.f56959d = themeList.type;
    }
}
