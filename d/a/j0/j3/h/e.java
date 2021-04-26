package d.a.j0.j3.h;

import tbclient.ThemeRecommand;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f56253a;

    /* renamed from: b  reason: collision with root package name */
    public String f56254b;

    /* renamed from: c  reason: collision with root package name */
    public String f56255c;

    public String a() {
        return this.f56255c;
    }

    public String b() {
        return this.f56253a;
    }

    public String c() {
        return this.f56254b;
    }

    public void d(ThemeRecommand themeRecommand) {
        if (themeRecommand == null) {
            return;
        }
        this.f56253a = themeRecommand.icon;
        this.f56254b = themeRecommand.tip_text;
        this.f56255c = themeRecommand.button_text;
        String str = themeRecommand.button_url;
    }
}
