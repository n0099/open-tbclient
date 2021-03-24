package d.b.i0.i3.h;

import tbclient.GetThemeList.ThemeList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56386a;

    /* renamed from: b  reason: collision with root package name */
    public String f56387b;

    /* renamed from: c  reason: collision with root package name */
    public long f56388c;

    /* renamed from: d  reason: collision with root package name */
    public String f56389d;

    public String a() {
        return this.f56387b;
    }

    public String b() {
        return this.f56386a;
    }

    public String c() {
        return this.f56389d;
    }

    public long d() {
        return this.f56388c;
    }

    public void e(ThemeList themeList) {
        if (themeList == null) {
            return;
        }
        this.f56386a = themeList.name;
        this.f56387b = themeList.icon;
        this.f56388c = themeList.last_update_time.longValue();
        this.f56389d = themeList.type;
    }
}
