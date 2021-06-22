package d.a.o0.v0.c;

import d.a.n0.r.q.j0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f66067a;

    /* renamed from: b  reason: collision with root package name */
    public long f66068b;

    /* renamed from: c  reason: collision with root package name */
    public b f66069c;

    /* renamed from: d  reason: collision with root package name */
    public c f66070d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1744a> f66071e;

    /* renamed from: f  reason: collision with root package name */
    public long f66072f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f66073g;

    /* renamed from: h  reason: collision with root package name */
    public int f66074h;

    /* renamed from: d.a.o0.v0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1744a {

        /* renamed from: a  reason: collision with root package name */
        public long f66075a;

        /* renamed from: b  reason: collision with root package name */
        public String f66076b;

        /* renamed from: c  reason: collision with root package name */
        public String f66077c;

        /* renamed from: d  reason: collision with root package name */
        public String f66078d;

        /* renamed from: e  reason: collision with root package name */
        public long f66079e;

        /* renamed from: f  reason: collision with root package name */
        public long f66080f;

        /* renamed from: g  reason: collision with root package name */
        public long f66081g;

        /* renamed from: h  reason: collision with root package name */
        public int f66082h;

        /* renamed from: i  reason: collision with root package name */
        public String f66083i;
        public int j;
        public String k;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f66084a;

        /* renamed from: b  reason: collision with root package name */
        public int f66085b;

        /* renamed from: c  reason: collision with root package name */
        public int f66086c;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f66087a;

        /* renamed from: b  reason: collision with root package name */
        public String f66088b;
    }

    public ArrayList<C1744a> a() {
        return this.f66071e;
    }

    public long b() {
        return this.f66067a;
    }

    public b c() {
        return this.f66069c;
    }

    public c d() {
        return this.f66070d;
    }

    public long e() {
        return this.f66068b;
    }

    public void f(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f66067a = dataRes.total_num.intValue();
        this.f66068b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f66072f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            j0 j0Var = new j0();
            this.f66073g = j0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                j0Var.f53839a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f66073g.f53840b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f66069c = bVar;
            bVar.f66084a = dataRes.page.cur_page.intValue();
            this.f66069c.f66085b = dataRes.page.has_more.intValue();
            this.f66069c.f66086c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f66070d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f66087a = presentmoneytxt.txt;
            cVar.f66088b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f66071e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1744a c1744a = new C1744a();
                    c1744a.j = i2 + 1;
                    c1744a.f66075a = presentMyList.pay_userid.longValue();
                    c1744a.f66076b = presentMyList.pay_username;
                    c1744a.f66077c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1744a.f66078d = presentMyList.thumbnail_url;
                    c1744a.f66079e = presentMyList.create_time.intValue();
                    c1744a.f66080f = presentMyList.num.intValue();
                    c1744a.f66082h = presentMyList.currency_unit.intValue();
                    c1744a.f66083i = presentMyList.currency_type;
                    c1744a.f66081g = presentMyList.present_scores.longValue();
                    c1744a.k = presentMyList.name_show;
                    this.f66071e.add(c1744a);
                }
            }
        }
        this.f66074h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1744a> arrayList) {
        this.f66071e = arrayList;
    }

    public void h(long j) {
        this.f66067a = j;
    }

    public void i(b bVar) {
        this.f66069c = bVar;
    }

    public void j(c cVar) {
        this.f66070d = cVar;
    }

    public void k(long j) {
        this.f66068b = j;
    }
}
