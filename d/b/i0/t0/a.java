package d.b.i0.t0;

import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f62547a;

    /* renamed from: b  reason: collision with root package name */
    public String f62548b;

    /* renamed from: c  reason: collision with root package name */
    public String f62549c;

    /* renamed from: d  reason: collision with root package name */
    public String f62550d;

    /* renamed from: e  reason: collision with root package name */
    public String f62551e;

    /* renamed from: f  reason: collision with root package name */
    public String f62552f;

    /* renamed from: g  reason: collision with root package name */
    public String f62553g;

    public String a() {
        return this.f62549c;
    }

    public String b() {
        return this.f62552f;
    }

    public String c() {
        return this.f62553g;
    }

    public String d() {
        return this.f62548b;
    }

    public String e() {
        return this.f62550d;
    }

    public String f() {
        return this.f62551e;
    }

    public String g() {
        return this.f62547a;
    }

    public void h(EsportRank esportRank) {
        if (esportRank != null) {
            this.f62547a = esportRank.title;
            this.f62548b = String.valueOf(esportRank.rank);
            this.f62549c = esportRank.text;
            this.f62553g = esportRank.url;
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                this.f62550d = esportUser.steam_name;
                this.f62551e = esportUser.steam_portrait;
            }
        }
    }

    public void i(String str) {
        this.f62552f = str;
    }

    public void j(String str) {
        this.f62553g = str;
    }
}
