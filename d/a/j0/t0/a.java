package d.a.j0.t0;

import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61172a;

    /* renamed from: b  reason: collision with root package name */
    public String f61173b;

    /* renamed from: c  reason: collision with root package name */
    public String f61174c;

    /* renamed from: d  reason: collision with root package name */
    public String f61175d;

    /* renamed from: e  reason: collision with root package name */
    public String f61176e;

    /* renamed from: f  reason: collision with root package name */
    public String f61177f;

    /* renamed from: g  reason: collision with root package name */
    public String f61178g;

    public String a() {
        return this.f61174c;
    }

    public String b() {
        return this.f61177f;
    }

    public String c() {
        return this.f61178g;
    }

    public String d() {
        return this.f61173b;
    }

    public String e() {
        return this.f61175d;
    }

    public String f() {
        return this.f61176e;
    }

    public String g() {
        return this.f61172a;
    }

    public void h(EsportRank esportRank) {
        if (esportRank != null) {
            this.f61172a = esportRank.title;
            this.f61173b = String.valueOf(esportRank.rank);
            this.f61174c = esportRank.text;
            this.f61178g = esportRank.url;
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                this.f61175d = esportUser.steam_name;
                this.f61176e = esportUser.steam_portrait;
            }
        }
    }

    public void i(String str) {
        this.f61177f = str;
    }

    public void j(String str) {
        this.f61178g = str;
    }
}
