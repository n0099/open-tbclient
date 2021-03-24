package d.b.i0.t0.c;

import d.b.h0.r.q.j0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f61024a;

    /* renamed from: b  reason: collision with root package name */
    public long f61025b;

    /* renamed from: c  reason: collision with root package name */
    public b f61026c;

    /* renamed from: d  reason: collision with root package name */
    public c f61027d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1581a> f61028e;

    /* renamed from: f  reason: collision with root package name */
    public long f61029f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f61030g;

    /* renamed from: d.b.i0.t0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1581a {

        /* renamed from: a  reason: collision with root package name */
        public long f61031a;

        /* renamed from: b  reason: collision with root package name */
        public String f61032b;

        /* renamed from: c  reason: collision with root package name */
        public String f61033c;

        /* renamed from: d  reason: collision with root package name */
        public String f61034d;

        /* renamed from: e  reason: collision with root package name */
        public long f61035e;

        /* renamed from: f  reason: collision with root package name */
        public long f61036f;

        /* renamed from: g  reason: collision with root package name */
        public long f61037g;

        /* renamed from: h  reason: collision with root package name */
        public int f61038h;
        public String i;
        public int j;
        public String k;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f61039a;

        /* renamed from: b  reason: collision with root package name */
        public int f61040b;

        /* renamed from: c  reason: collision with root package name */
        public int f61041c;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f61042a;

        /* renamed from: b  reason: collision with root package name */
        public String f61043b;
    }

    public ArrayList<C1581a> a() {
        return this.f61028e;
    }

    public long b() {
        return this.f61024a;
    }

    public b c() {
        return this.f61026c;
    }

    public c d() {
        return this.f61027d;
    }

    public long e() {
        return this.f61025b;
    }

    public void f(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f61024a = dataRes.total_num.intValue();
        this.f61025b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f61029f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            j0 j0Var = new j0();
            this.f61030g = j0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                j0Var.f50820a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f61030g.f50821b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f61026c = bVar;
            bVar.f61039a = dataRes.page.cur_page.intValue();
            this.f61026c.f61040b = dataRes.page.has_more.intValue();
            this.f61026c.f61041c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f61027d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f61042a = presentmoneytxt.txt;
            cVar.f61043b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f61028e = new ArrayList<>();
        for (int i = 0; i < dataRes.gift_list.size(); i++) {
            PresentMyList presentMyList = dataRes.gift_list.get(i);
            if (presentMyList != null) {
                C1581a c1581a = new C1581a();
                c1581a.j = i + 1;
                c1581a.f61031a = presentMyList.pay_userid.longValue();
                c1581a.f61032b = presentMyList.pay_username;
                c1581a.f61033c = presentMyList.portrait;
                presentMyList.gift_id.intValue();
                String str3 = presentMyList.gift_name;
                String str4 = presentMyList.play_url;
                c1581a.f61034d = presentMyList.thumbnail_url;
                c1581a.f61035e = presentMyList.create_time.intValue();
                c1581a.f61036f = presentMyList.num.intValue();
                c1581a.f61038h = presentMyList.currency_unit.intValue();
                c1581a.i = presentMyList.currency_type;
                c1581a.f61037g = presentMyList.present_scores.longValue();
                c1581a.k = presentMyList.name_show;
                this.f61028e.add(c1581a);
            }
        }
    }

    public void g(ArrayList<C1581a> arrayList) {
        this.f61028e = arrayList;
    }

    public void h(long j) {
        this.f61024a = j;
    }

    public void i(b bVar) {
        this.f61026c = bVar;
    }

    public void j(c cVar) {
        this.f61027d = cVar;
    }

    public void k(long j) {
        this.f61025b = j;
    }
}
