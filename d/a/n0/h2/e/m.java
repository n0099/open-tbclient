package d.a.n0.h2.e;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class m implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f55573a;

    /* renamed from: b  reason: collision with root package name */
    public Long f55574b;

    /* renamed from: c  reason: collision with root package name */
    public String f55575c;

    /* renamed from: d  reason: collision with root package name */
    public String f55576d;

    /* renamed from: e  reason: collision with root package name */
    public String f55577e;

    /* renamed from: f  reason: collision with root package name */
    public String f55578f;

    /* renamed from: g  reason: collision with root package name */
    public String f55579g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f55580h;

    public m(SmartApp smartApp) {
        this.f55573a = 0;
        if (smartApp == null) {
            return;
        }
        this.f55574b = smartApp.swan_app_id;
        this.f55575c = smartApp.id;
        this.f55576d = smartApp.avatar;
        this.f55577e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f55578f = smartApp.h5_url;
        this.f55579g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f55573a = 1;
        }
        this.f55580h = smartApp.is_game;
    }

    public Long a() {
        return this.f55574b;
    }

    public String b() {
        return this.f55575c;
    }

    public String c() {
        return this.f55576d;
    }

    public String d() {
        return this.f55578f;
    }

    public Integer e() {
        return this.f55580h;
    }

    public String f() {
        return this.f55579g;
    }

    public String g() {
        return this.f55577e;
    }

    @Override // d.a.n0.h2.e.c
    public int getType() {
        return this.f55573a;
    }
}
