package d.a.n0.k3.h;

import tbclient.ThemeRecommand;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f57140a;

    /* renamed from: b  reason: collision with root package name */
    public String f57141b;

    /* renamed from: c  reason: collision with root package name */
    public String f57142c;

    public String a() {
        return this.f57142c;
    }

    public String b() {
        return this.f57140a;
    }

    public String c() {
        return this.f57141b;
    }

    public void d(ThemeRecommand themeRecommand) {
        if (themeRecommand == null) {
            return;
        }
        this.f57140a = themeRecommand.icon;
        this.f57141b = themeRecommand.tip_text;
        this.f57142c = themeRecommand.button_text;
        String str = themeRecommand.button_url;
    }
}
