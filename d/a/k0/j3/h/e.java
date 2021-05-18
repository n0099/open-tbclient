package d.a.k0.j3.h;

import tbclient.ThemeRecommand;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f56960a;

    /* renamed from: b  reason: collision with root package name */
    public String f56961b;

    /* renamed from: c  reason: collision with root package name */
    public String f56962c;

    public String a() {
        return this.f56962c;
    }

    public String b() {
        return this.f56960a;
    }

    public String c() {
        return this.f56961b;
    }

    public void d(ThemeRecommand themeRecommand) {
        if (themeRecommand == null) {
            return;
        }
        this.f56960a = themeRecommand.icon;
        this.f56961b = themeRecommand.tip_text;
        this.f56962c = themeRecommand.button_text;
        String str = themeRecommand.button_url;
    }
}
