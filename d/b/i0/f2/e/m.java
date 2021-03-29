package d.b.i0.f2.e;

import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class m implements c {

    /* renamed from: a  reason: collision with root package name */
    public int f54799a;

    /* renamed from: b  reason: collision with root package name */
    public Long f54800b;

    /* renamed from: c  reason: collision with root package name */
    public String f54801c;

    /* renamed from: d  reason: collision with root package name */
    public String f54802d;

    /* renamed from: e  reason: collision with root package name */
    public String f54803e;

    /* renamed from: f  reason: collision with root package name */
    public String f54804f;

    /* renamed from: g  reason: collision with root package name */
    public String f54805g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f54806h;

    public m(SmartApp smartApp) {
        this.f54799a = 0;
        if (smartApp == null) {
            return;
        }
        this.f54800b = smartApp.swan_app_id;
        this.f54801c = smartApp.id;
        this.f54802d = smartApp.avatar;
        this.f54803e = smartApp.name;
        String str = smartApp._abstract;
        String str2 = smartApp.pic;
        this.f54804f = smartApp.h5_url;
        this.f54805g = smartApp.link;
        if (smartApp.is_recom.intValue() == 1) {
            this.f54799a = 1;
        }
        this.f54806h = smartApp.is_game;
    }

    public Long a() {
        return this.f54800b;
    }

    public String b() {
        return this.f54801c;
    }

    public String c() {
        return this.f54802d;
    }

    public String d() {
        return this.f54804f;
    }

    public Integer e() {
        return this.f54806h;
    }

    public String f() {
        return this.f54805g;
    }

    public String g() {
        return this.f54803e;
    }

    @Override // d.b.i0.f2.e.c
    public int getType() {
        return this.f54799a;
    }
}
