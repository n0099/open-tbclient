package d.b.i0.i3.h;

import tbclient.GetThemeList.ThemeList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56387a;

    /* renamed from: b  reason: collision with root package name */
    public String f56388b;

    /* renamed from: c  reason: collision with root package name */
    public long f56389c;

    /* renamed from: d  reason: collision with root package name */
    public String f56390d;

    public String a() {
        return this.f56388b;
    }

    public String b() {
        return this.f56387a;
    }

    public String c() {
        return this.f56390d;
    }

    public long d() {
        return this.f56389c;
    }

    public void e(ThemeList themeList) {
        if (themeList == null) {
            return;
        }
        this.f56387a = themeList.name;
        this.f56388b = themeList.icon;
        this.f56389c = themeList.last_update_time.longValue();
        this.f56390d = themeList.type;
    }
}
