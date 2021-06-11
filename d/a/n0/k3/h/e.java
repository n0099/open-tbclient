package d.a.n0.k3.h;

import tbclient.ThemeRecommand;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f60829a;

    /* renamed from: b  reason: collision with root package name */
    public String f60830b;

    /* renamed from: c  reason: collision with root package name */
    public String f60831c;

    public String a() {
        return this.f60831c;
    }

    public String b() {
        return this.f60829a;
    }

    public String c() {
        return this.f60830b;
    }

    public void d(ThemeRecommand themeRecommand) {
        if (themeRecommand == null) {
            return;
        }
        this.f60829a = themeRecommand.icon;
        this.f60830b = themeRecommand.tip_text;
        this.f60831c = themeRecommand.button_text;
        String str = themeRecommand.button_url;
    }
}
