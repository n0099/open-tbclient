package d.b.i0.j3.h;

import tbclient.ThemeRecommand;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f57838a;

    /* renamed from: b  reason: collision with root package name */
    public String f57839b;

    /* renamed from: c  reason: collision with root package name */
    public String f57840c;

    public String a() {
        return this.f57840c;
    }

    public String b() {
        return this.f57838a;
    }

    public String c() {
        return this.f57839b;
    }

    public void d(ThemeRecommand themeRecommand) {
        if (themeRecommand == null) {
            return;
        }
        this.f57838a = themeRecommand.icon;
        this.f57839b = themeRecommand.tip_text;
        this.f57840c = themeRecommand.button_text;
        String str = themeRecommand.button_url;
    }
}
