package d.a.j0.g2.e;

import tbclient.SmartApp;
/* loaded from: classes4.dex */
public class m implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f54592a;

    /* renamed from: b  reason: collision with root package name */
    public Long f54593b;

    /* renamed from: c  reason: collision with root package name */
    public String f54594c;

    /* renamed from: d  reason: collision with root package name */
    public String f54595d;

    /* renamed from: e  reason: collision with root package name */
    public String f54596e;

    /* renamed from: f  reason: collision with root package name */
    public String f54597f;

    /* renamed from: g  reason: collision with root package name */
    public String f54598g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f54599h;

    public m(SmartApp smartApp) {
        this.f54592a = 0;
        if (smartApp == null) {
            return;
        }
        this.f54593b = smartApp.swan_app_id;
        this.f54594c = smartApp.id;
        this.f54595d = smartApp.avatar;
        this.f54596e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f54597f = smartApp.h5_url;
        this.f54598g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f54592a = 1;
        }
        this.f54599h = smartApp.is_game;
    }

    public Long a() {
        return this.f54593b;
    }

    public String b() {
        return this.f54594c;
    }

    public String c() {
        return this.f54595d;
    }

    public String d() {
        return this.f54597f;
    }

    public Integer e() {
        return this.f54599h;
    }

    public String f() {
        return this.f54598g;
    }

    public String g() {
        return this.f54596e;
    }

    @Override // d.a.j0.g2.e.c
    public int getType() {
        return this.f54592a;
    }
}
