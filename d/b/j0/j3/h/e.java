package d.b.j0.j3.h;

import tbclient.ThemeRecommand;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f58259a;

    /* renamed from: b  reason: collision with root package name */
    public String f58260b;

    /* renamed from: c  reason: collision with root package name */
    public String f58261c;

    public String a() {
        return this.f58261c;
    }

    public String b() {
        return this.f58259a;
    }

    public String c() {
        return this.f58260b;
    }

    public void d(ThemeRecommand themeRecommand) {
        if (themeRecommand == null) {
            return;
        }
        this.f58259a = themeRecommand.icon;
        this.f58260b = themeRecommand.tip_text;
        this.f58261c = themeRecommand.button_text;
        String str = themeRecommand.button_url;
    }
}
