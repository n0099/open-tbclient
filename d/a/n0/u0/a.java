package d.a.n0.u0;

import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61303a;

    /* renamed from: b  reason: collision with root package name */
    public String f61304b;

    /* renamed from: c  reason: collision with root package name */
    public String f61305c;

    /* renamed from: d  reason: collision with root package name */
    public String f61306d;

    /* renamed from: e  reason: collision with root package name */
    public String f61307e;

    /* renamed from: f  reason: collision with root package name */
    public String f61308f;

    /* renamed from: g  reason: collision with root package name */
    public String f61309g;

    public String a() {
        return this.f61305c;
    }

    public String b() {
        return this.f61308f;
    }

    public String c() {
        return this.f61309g;
    }

    public String d() {
        return this.f61304b;
    }

    public String e() {
        return this.f61306d;
    }

    public String f() {
        return this.f61307e;
    }

    public String g() {
        return this.f61303a;
    }

    public void h(EsportRank esportRank) {
        if (esportRank != null) {
            this.f61303a = esportRank.title;
            this.f61304b = String.valueOf(esportRank.rank);
            this.f61305c = esportRank.text;
            this.f61309g = esportRank.url;
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                this.f61306d = esportUser.steam_name;
                this.f61307e = esportUser.steam_portrait;
            }
        }
    }

    public void i(String str) {
        this.f61308f = str;
    }

    public void j(String str) {
        this.f61309g = str;
    }
}
