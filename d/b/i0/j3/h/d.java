package d.b.i0.j3.h;

import tbclient.GetThemeList.ThemeList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f57834a;

    /* renamed from: b  reason: collision with root package name */
    public String f57835b;

    /* renamed from: c  reason: collision with root package name */
    public long f57836c;

    /* renamed from: d  reason: collision with root package name */
    public String f57837d;

    public String a() {
        return this.f57835b;
    }

    public String b() {
        return this.f57834a;
    }

    public String c() {
        return this.f57837d;
    }

    public long d() {
        return this.f57836c;
    }

    public void e(ThemeList themeList) {
        if (themeList == null) {
            return;
        }
        this.f57834a = themeList.name;
        this.f57835b = themeList.icon;
        this.f57836c = themeList.last_update_time.longValue();
        this.f57837d = themeList.type;
    }
}
