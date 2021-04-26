package d.a.j0.j3.h;

import tbclient.GetThemeList.ThemeList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56249a;

    /* renamed from: b  reason: collision with root package name */
    public String f56250b;

    /* renamed from: c  reason: collision with root package name */
    public long f56251c;

    /* renamed from: d  reason: collision with root package name */
    public String f56252d;

    public String a() {
        return this.f56250b;
    }

    public String b() {
        return this.f56249a;
    }

    public String c() {
        return this.f56252d;
    }

    public long d() {
        return this.f56251c;
    }

    public void e(ThemeList themeList) {
        if (themeList == null) {
            return;
        }
        this.f56249a = themeList.name;
        this.f56250b = themeList.icon;
        this.f56251c = themeList.last_update_time.longValue();
        this.f56252d = themeList.type;
    }
}
