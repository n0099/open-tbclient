package d.a.n0.v0.c;

import d.a.m0.r.q.j0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f65942a;

    /* renamed from: b  reason: collision with root package name */
    public long f65943b;

    /* renamed from: c  reason: collision with root package name */
    public b f65944c;

    /* renamed from: d  reason: collision with root package name */
    public c f65945d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1740a> f65946e;

    /* renamed from: f  reason: collision with root package name */
    public long f65947f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f65948g;

    /* renamed from: h  reason: collision with root package name */
    public int f65949h;

    /* renamed from: d.a.n0.v0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1740a {

        /* renamed from: a  reason: collision with root package name */
        public long f65950a;

        /* renamed from: b  reason: collision with root package name */
        public String f65951b;

        /* renamed from: c  reason: collision with root package name */
        public String f65952c;

        /* renamed from: d  reason: collision with root package name */
        public String f65953d;

        /* renamed from: e  reason: collision with root package name */
        public long f65954e;

        /* renamed from: f  reason: collision with root package name */
        public long f65955f;

        /* renamed from: g  reason: collision with root package name */
        public long f65956g;

        /* renamed from: h  reason: collision with root package name */
        public int f65957h;

        /* renamed from: i  reason: collision with root package name */
        public String f65958i;
        public int j;
        public String k;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f65959a;

        /* renamed from: b  reason: collision with root package name */
        public int f65960b;

        /* renamed from: c  reason: collision with root package name */
        public int f65961c;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f65962a;

        /* renamed from: b  reason: collision with root package name */
        public String f65963b;
    }

    public ArrayList<C1740a> a() {
        return this.f65946e;
    }

    public long b() {
        return this.f65942a;
    }

    public b c() {
        return this.f65944c;
    }

    public c d() {
        return this.f65945d;
    }

    public long e() {
        return this.f65943b;
    }

    public void f(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f65942a = dataRes.total_num.intValue();
        this.f65943b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f65947f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            j0 j0Var = new j0();
            this.f65948g = j0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                j0Var.f53732a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f65948g.f53733b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f65944c = bVar;
            bVar.f65959a = dataRes.page.cur_page.intValue();
            this.f65944c.f65960b = dataRes.page.has_more.intValue();
            this.f65944c.f65961c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f65945d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f65962a = presentmoneytxt.txt;
            cVar.f65963b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f65946e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1740a c1740a = new C1740a();
                    c1740a.j = i2 + 1;
                    c1740a.f65950a = presentMyList.pay_userid.longValue();
                    c1740a.f65951b = presentMyList.pay_username;
                    c1740a.f65952c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1740a.f65953d = presentMyList.thumbnail_url;
                    c1740a.f65954e = presentMyList.create_time.intValue();
                    c1740a.f65955f = presentMyList.num.intValue();
                    c1740a.f65957h = presentMyList.currency_unit.intValue();
                    c1740a.f65958i = presentMyList.currency_type;
                    c1740a.f65956g = presentMyList.present_scores.longValue();
                    c1740a.k = presentMyList.name_show;
                    this.f65946e.add(c1740a);
                }
            }
        }
        this.f65949h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1740a> arrayList) {
        this.f65946e = arrayList;
    }

    public void h(long j) {
        this.f65942a = j;
    }

    public void i(b bVar) {
        this.f65944c = bVar;
    }

    public void j(c cVar) {
        this.f65945d = cVar;
    }

    public void k(long j) {
        this.f65943b = j;
    }
}
