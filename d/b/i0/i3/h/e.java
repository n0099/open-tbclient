package d.b.i0.i3.h;

import tbclient.ThemeRecommand;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f56390a;

    /* renamed from: b  reason: collision with root package name */
    public String f56391b;

    /* renamed from: c  reason: collision with root package name */
    public String f56392c;

    public String a() {
        return this.f56392c;
    }

    public String b() {
        return this.f56390a;
    }

    public String c() {
        return this.f56391b;
    }

    public void d(ThemeRecommand themeRecommand) {
        if (themeRecommand == null) {
            return;
        }
        this.f56390a = themeRecommand.icon;
        this.f56391b = themeRecommand.tip_text;
        this.f56392c = themeRecommand.button_text;
        String str = themeRecommand.button_url;
    }
}
