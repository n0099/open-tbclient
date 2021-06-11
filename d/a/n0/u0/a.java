package d.a.n0.u0;

import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f65016a;

    /* renamed from: b  reason: collision with root package name */
    public String f65017b;

    /* renamed from: c  reason: collision with root package name */
    public String f65018c;

    /* renamed from: d  reason: collision with root package name */
    public String f65019d;

    /* renamed from: e  reason: collision with root package name */
    public String f65020e;

    /* renamed from: f  reason: collision with root package name */
    public String f65021f;

    /* renamed from: g  reason: collision with root package name */
    public String f65022g;

    public String a() {
        return this.f65018c;
    }

    public String b() {
        return this.f65021f;
    }

    public String c() {
        return this.f65022g;
    }

    public String d() {
        return this.f65017b;
    }

    public String e() {
        return this.f65019d;
    }

    public String f() {
        return this.f65020e;
    }

    public String g() {
        return this.f65016a;
    }

    public void h(EsportRank esportRank) {
        if (esportRank != null) {
            this.f65016a = esportRank.title;
            this.f65017b = String.valueOf(esportRank.rank);
            this.f65018c = esportRank.text;
            this.f65022g = esportRank.url;
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                this.f65019d = esportUser.steam_name;
                this.f65020e = esportUser.steam_portrait;
            }
        }
    }

    public void i(String str) {
        this.f65021f = str;
    }

    public void j(String str) {
        this.f65022g = str;
    }
}
