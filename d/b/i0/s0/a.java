package d.b.i0.s0;

import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f60132a;

    /* renamed from: b  reason: collision with root package name */
    public String f60133b;

    /* renamed from: c  reason: collision with root package name */
    public String f60134c;

    /* renamed from: d  reason: collision with root package name */
    public String f60135d;

    /* renamed from: e  reason: collision with root package name */
    public String f60136e;

    /* renamed from: f  reason: collision with root package name */
    public String f60137f;

    /* renamed from: g  reason: collision with root package name */
    public String f60138g;

    public String a() {
        return this.f60134c;
    }

    public String b() {
        return this.f60137f;
    }

    public String c() {
        return this.f60138g;
    }

    public String d() {
        return this.f60133b;
    }

    public String e() {
        return this.f60135d;
    }

    public String f() {
        return this.f60136e;
    }

    public String g() {
        return this.f60132a;
    }

    public void h(EsportRank esportRank) {
        if (esportRank != null) {
            this.f60132a = esportRank.title;
            this.f60133b = String.valueOf(esportRank.rank);
            this.f60134c = esportRank.text;
            this.f60138g = esportRank.url;
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                this.f60135d = esportUser.steam_name;
                this.f60136e = esportUser.steam_portrait;
            }
        }
    }

    public void i(String str) {
        this.f60137f = str;
    }

    public void j(String str) {
        this.f60138g = str;
    }
}
