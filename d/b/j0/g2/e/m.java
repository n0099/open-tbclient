package d.b.j0.g2.e;

import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class m implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f56690a;

    /* renamed from: b  reason: collision with root package name */
    public Long f56691b;

    /* renamed from: c  reason: collision with root package name */
    public String f56692c;

    /* renamed from: d  reason: collision with root package name */
    public String f56693d;

    /* renamed from: e  reason: collision with root package name */
    public String f56694e;

    /* renamed from: f  reason: collision with root package name */
    public String f56695f;

    /* renamed from: g  reason: collision with root package name */
    public String f56696g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f56697h;

    public m(SmartApp smartApp) {
        this.f56690a = 0;
        if (smartApp == null) {
            return;
        }
        this.f56691b = smartApp.swan_app_id;
        this.f56692c = smartApp.id;
        this.f56693d = smartApp.avatar;
        this.f56694e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f56695f = smartApp.h5_url;
        this.f56696g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f56690a = 1;
        }
        this.f56697h = smartApp.is_game;
    }

    public Long a() {
        return this.f56691b;
    }

    public String b() {
        return this.f56692c;
    }

    public String c() {
        return this.f56693d;
    }

    public String d() {
        return this.f56695f;
    }

    public Integer e() {
        return this.f56697h;
    }

    public String f() {
        return this.f56696g;
    }

    public String g() {
        return this.f56694e;
    }

    @Override // d.b.j0.g2.e.c
    public int getType() {
        return this.f56690a;
    }
}
