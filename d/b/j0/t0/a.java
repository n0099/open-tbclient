package d.b.j0.t0;

import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f62968a;

    /* renamed from: b  reason: collision with root package name */
    public String f62969b;

    /* renamed from: c  reason: collision with root package name */
    public String f62970c;

    /* renamed from: d  reason: collision with root package name */
    public String f62971d;

    /* renamed from: e  reason: collision with root package name */
    public String f62972e;

    /* renamed from: f  reason: collision with root package name */
    public String f62973f;

    /* renamed from: g  reason: collision with root package name */
    public String f62974g;

    public String a() {
        return this.f62970c;
    }

    public String b() {
        return this.f62973f;
    }

    public String c() {
        return this.f62974g;
    }

    public String d() {
        return this.f62969b;
    }

    public String e() {
        return this.f62971d;
    }

    public String f() {
        return this.f62972e;
    }

    public String g() {
        return this.f62968a;
    }

    public void h(EsportRank esportRank) {
        if (esportRank != null) {
            this.f62968a = esportRank.title;
            this.f62969b = String.valueOf(esportRank.rank);
            this.f62970c = esportRank.text;
            this.f62974g = esportRank.url;
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                this.f62971d = esportUser.steam_name;
                this.f62972e = esportUser.steam_portrait;
            }
        }
    }

    public void i(String str) {
        this.f62973f = str;
    }

    public void j(String str) {
        this.f62974g = str;
    }
}
