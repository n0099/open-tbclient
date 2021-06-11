package d.a.n0.h2.e;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class m implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f59262a;

    /* renamed from: b  reason: collision with root package name */
    public Long f59263b;

    /* renamed from: c  reason: collision with root package name */
    public String f59264c;

    /* renamed from: d  reason: collision with root package name */
    public String f59265d;

    /* renamed from: e  reason: collision with root package name */
    public String f59266e;

    /* renamed from: f  reason: collision with root package name */
    public String f59267f;

    /* renamed from: g  reason: collision with root package name */
    public String f59268g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f59269h;

    public m(SmartApp smartApp) {
        this.f59262a = 0;
        if (smartApp == null) {
            return;
        }
        this.f59263b = smartApp.swan_app_id;
        this.f59264c = smartApp.id;
        this.f59265d = smartApp.avatar;
        this.f59266e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f59267f = smartApp.h5_url;
        this.f59268g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f59262a = 1;
        }
        this.f59269h = smartApp.is_game;
    }

    public Long a() {
        return this.f59263b;
    }

    public String b() {
        return this.f59264c;
    }

    public String c() {
        return this.f59265d;
    }

    public String d() {
        return this.f59267f;
    }

    public Integer e() {
        return this.f59269h;
    }

    public String f() {
        return this.f59268g;
    }

    public String g() {
        return this.f59266e;
    }

    @Override // d.a.n0.h2.e.c
    public int getType() {
        return this.f59262a;
    }
}
