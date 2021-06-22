package d.a.o0.u0;

import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f65141a;

    /* renamed from: b  reason: collision with root package name */
    public String f65142b;

    /* renamed from: c  reason: collision with root package name */
    public String f65143c;

    /* renamed from: d  reason: collision with root package name */
    public String f65144d;

    /* renamed from: e  reason: collision with root package name */
    public String f65145e;

    /* renamed from: f  reason: collision with root package name */
    public String f65146f;

    /* renamed from: g  reason: collision with root package name */
    public String f65147g;

    public String a() {
        return this.f65143c;
    }

    public String b() {
        return this.f65146f;
    }

    public String c() {
        return this.f65147g;
    }

    public String d() {
        return this.f65142b;
    }

    public String e() {
        return this.f65144d;
    }

    public String f() {
        return this.f65145e;
    }

    public String g() {
        return this.f65141a;
    }

    public void h(EsportRank esportRank) {
        if (esportRank != null) {
            this.f65141a = esportRank.title;
            this.f65142b = String.valueOf(esportRank.rank);
            this.f65143c = esportRank.text;
            this.f65147g = esportRank.url;
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                this.f65144d = esportUser.steam_name;
                this.f65145e = esportUser.steam_portrait;
            }
        }
    }

    public void i(String str) {
        this.f65146f = str;
    }

    public void j(String str) {
        this.f65147g = str;
    }
}
