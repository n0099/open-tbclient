package d.a.o0.h2.e;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class m implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f59387a;

    /* renamed from: b  reason: collision with root package name */
    public Long f59388b;

    /* renamed from: c  reason: collision with root package name */
    public String f59389c;

    /* renamed from: d  reason: collision with root package name */
    public String f59390d;

    /* renamed from: e  reason: collision with root package name */
    public String f59391e;

    /* renamed from: f  reason: collision with root package name */
    public String f59392f;

    /* renamed from: g  reason: collision with root package name */
    public String f59393g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f59394h;

    public m(SmartApp smartApp) {
        this.f59387a = 0;
        if (smartApp == null) {
            return;
        }
        this.f59388b = smartApp.swan_app_id;
        this.f59389c = smartApp.id;
        this.f59390d = smartApp.avatar;
        this.f59391e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f59392f = smartApp.h5_url;
        this.f59393g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f59387a = 1;
        }
        this.f59394h = smartApp.is_game;
    }

    public Long a() {
        return this.f59388b;
    }

    public String b() {
        return this.f59389c;
    }

    public String c() {
        return this.f59390d;
    }

    public String d() {
        return this.f59392f;
    }

    public Integer e() {
        return this.f59394h;
    }

    public String f() {
        return this.f59393g;
    }

    public String g() {
        return this.f59391e;
    }

    @Override // d.a.o0.h2.e.c
    public int getType() {
        return this.f59387a;
    }
}
