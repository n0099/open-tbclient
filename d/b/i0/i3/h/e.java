package d.b.i0.i3.h;

import tbclient.ThemeRecommand;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f56391a;

    /* renamed from: b  reason: collision with root package name */
    public String f56392b;

    /* renamed from: c  reason: collision with root package name */
    public String f56393c;

    public String a() {
        return this.f56393c;
    }

    public String b() {
        return this.f56391a;
    }

    public String c() {
        return this.f56392b;
    }

    public void d(ThemeRecommand themeRecommand) {
        if (themeRecommand == null) {
            return;
        }
        this.f56391a = themeRecommand.icon;
        this.f56392b = themeRecommand.tip_text;
        this.f56393c = themeRecommand.button_text;
        String str = themeRecommand.button_url;
    }
}
