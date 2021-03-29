package d.b.i0.s0;

import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f60133a;

    /* renamed from: b  reason: collision with root package name */
    public String f60134b;

    /* renamed from: c  reason: collision with root package name */
    public String f60135c;

    /* renamed from: d  reason: collision with root package name */
    public String f60136d;

    /* renamed from: e  reason: collision with root package name */
    public String f60137e;

    /* renamed from: f  reason: collision with root package name */
    public String f60138f;

    /* renamed from: g  reason: collision with root package name */
    public String f60139g;

    public String a() {
        return this.f60135c;
    }

    public String b() {
        return this.f60138f;
    }

    public String c() {
        return this.f60139g;
    }

    public String d() {
        return this.f60134b;
    }

    public String e() {
        return this.f60136d;
    }

    public String f() {
        return this.f60137e;
    }

    public String g() {
        return this.f60133a;
    }

    public void h(EsportRank esportRank) {
        if (esportRank != null) {
            this.f60133a = esportRank.title;
            this.f60134b = String.valueOf(esportRank.rank);
            this.f60135c = esportRank.text;
            this.f60139g = esportRank.url;
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                this.f60136d = esportUser.steam_name;
                this.f60137e = esportUser.steam_portrait;
            }
        }
    }

    public void i(String str) {
        this.f60138f = str;
    }

    public void j(String str) {
        this.f60139g = str;
    }
}
