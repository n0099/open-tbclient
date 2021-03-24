package d.b.i0.f2.e;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class m implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f54798a;

    /* renamed from: b  reason: collision with root package name */
    public Long f54799b;

    /* renamed from: c  reason: collision with root package name */
    public String f54800c;

    /* renamed from: d  reason: collision with root package name */
    public String f54801d;

    /* renamed from: e  reason: collision with root package name */
    public String f54802e;

    /* renamed from: f  reason: collision with root package name */
    public String f54803f;

    /* renamed from: g  reason: collision with root package name */
    public String f54804g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f54805h;

    public m(SmartApp smartApp) {
        this.f54798a = 0;
        if (smartApp == null) {
            return;
        }
        this.f54799b = smartApp.swan_app_id;
        this.f54800c = smartApp.id;
        this.f54801d = smartApp.avatar;
        this.f54802e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f54803f = smartApp.h5_url;
        this.f54804g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f54798a = 1;
        }
        this.f54805h = smartApp.is_game;
    }

    public Long a() {
        return this.f54799b;
    }

    public String b() {
        return this.f54800c;
    }

    public String c() {
        return this.f54801d;
    }

    public String d() {
        return this.f54803f;
    }

    public Integer e() {
        return this.f54805h;
    }

    public String f() {
        return this.f54804g;
    }

    public String g() {
        return this.f54802e;
    }

    @Override // d.b.i0.f2.e.c
    public int getType() {
        return this.f54798a;
    }
}
