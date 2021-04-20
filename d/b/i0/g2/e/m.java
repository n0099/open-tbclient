package d.b.i0.g2.e;

import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class m implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f56269a;

    /* renamed from: b  reason: collision with root package name */
    public Long f56270b;

    /* renamed from: c  reason: collision with root package name */
    public String f56271c;

    /* renamed from: d  reason: collision with root package name */
    public String f56272d;

    /* renamed from: e  reason: collision with root package name */
    public String f56273e;

    /* renamed from: f  reason: collision with root package name */
    public String f56274f;

    /* renamed from: g  reason: collision with root package name */
    public String f56275g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f56276h;

    public m(SmartApp smartApp) {
        this.f56269a = 0;
        if (smartApp == null) {
            return;
        }
        this.f56270b = smartApp.swan_app_id;
        this.f56271c = smartApp.id;
        this.f56272d = smartApp.avatar;
        this.f56273e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f56274f = smartApp.h5_url;
        this.f56275g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f56269a = 1;
        }
        this.f56276h = smartApp.is_game;
    }

    public Long a() {
        return this.f56270b;
    }

    public String b() {
        return this.f56271c;
    }

    public String c() {
        return this.f56272d;
    }

    public String d() {
        return this.f56274f;
    }

    public Integer e() {
        return this.f56276h;
    }

    public String f() {
        return this.f56275g;
    }

    public String g() {
        return this.f56273e;
    }

    @Override // d.b.i0.g2.e.c
    public int getType() {
        return this.f56269a;
    }
}
