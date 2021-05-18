package d.a.k0.g2.e;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class m implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f55299a;

    /* renamed from: b  reason: collision with root package name */
    public Long f55300b;

    /* renamed from: c  reason: collision with root package name */
    public String f55301c;

    /* renamed from: d  reason: collision with root package name */
    public String f55302d;

    /* renamed from: e  reason: collision with root package name */
    public String f55303e;

    /* renamed from: f  reason: collision with root package name */
    public String f55304f;

    /* renamed from: g  reason: collision with root package name */
    public String f55305g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f55306h;

    public m(SmartApp smartApp) {
        this.f55299a = 0;
        if (smartApp == null) {
            return;
        }
        this.f55300b = smartApp.swan_app_id;
        this.f55301c = smartApp.id;
        this.f55302d = smartApp.avatar;
        this.f55303e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f55304f = smartApp.h5_url;
        this.f55305g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f55299a = 1;
        }
        this.f55306h = smartApp.is_game;
    }

    public Long a() {
        return this.f55300b;
    }

    public String b() {
        return this.f55301c;
    }

    public String c() {
        return this.f55302d;
    }

    public String d() {
        return this.f55304f;
    }

    public Integer e() {
        return this.f55306h;
    }

    public String f() {
        return this.f55305g;
    }

    public String g() {
        return this.f55303e;
    }

    @Override // d.a.k0.g2.e.c
    public int getType() {
        return this.f55299a;
    }
}
