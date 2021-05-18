package d.a.k0.t0;

import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61896a;

    /* renamed from: b  reason: collision with root package name */
    public String f61897b;

    /* renamed from: c  reason: collision with root package name */
    public String f61898c;

    /* renamed from: d  reason: collision with root package name */
    public String f61899d;

    /* renamed from: e  reason: collision with root package name */
    public String f61900e;

    /* renamed from: f  reason: collision with root package name */
    public String f61901f;

    /* renamed from: g  reason: collision with root package name */
    public String f61902g;

    public String a() {
        return this.f61898c;
    }

    public String b() {
        return this.f61901f;
    }

    public String c() {
        return this.f61902g;
    }

    public String d() {
        return this.f61897b;
    }

    public String e() {
        return this.f61899d;
    }

    public String f() {
        return this.f61900e;
    }

    public String g() {
        return this.f61896a;
    }

    public void h(EsportRank esportRank) {
        if (esportRank != null) {
            this.f61896a = esportRank.title;
            this.f61897b = String.valueOf(esportRank.rank);
            this.f61898c = esportRank.text;
            this.f61902g = esportRank.url;
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                this.f61899d = esportUser.steam_name;
                this.f61900e = esportUser.steam_portrait;
            }
        }
    }

    public void i(String str) {
        this.f61901f = str;
    }

    public void j(String str) {
        this.f61902g = str;
    }
}
