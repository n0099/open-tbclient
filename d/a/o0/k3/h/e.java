package d.a.o0.k3.h;

import tbclient.ThemeRecommand;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f60954a;

    /* renamed from: b  reason: collision with root package name */
    public String f60955b;

    /* renamed from: c  reason: collision with root package name */
    public String f60956c;

    public String a() {
        return this.f60956c;
    }

    public String b() {
        return this.f60954a;
    }

    public String c() {
        return this.f60955b;
    }

    public void d(ThemeRecommand themeRecommand) {
        if (themeRecommand == null) {
            return;
        }
        this.f60954a = themeRecommand.icon;
        this.f60955b = themeRecommand.tip_text;
        this.f60956c = themeRecommand.button_text;
        String str = themeRecommand.button_url;
    }
}
