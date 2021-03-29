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
    public long f61025a;

    /* renamed from: b  reason: collision with root package name */
    public long f61026b;

    /* renamed from: c  reason: collision with root package name */
    public b f61027c;

    /* renamed from: d  reason: collision with root package name */
    public c f61028d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1582a> f61029e;

    /* renamed from: f  reason: collision with root package name */
    public long f61030f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f61031g;

    /* renamed from: d.b.i0.t0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1582a {

        /* renamed from: a  reason: collision with root package name */
        public long f61032a;

        /* renamed from: b  reason: collision with root package name */
        public String f61033b;

        /* renamed from: c  reason: collision with root package name */
        public String f61034c;

        /* renamed from: d  reason: collision with root package name */
        public String f61035d;

        /* renamed from: e  reason: collision with root package name */
        public long f61036e;

        /* renamed from: f  reason: collision with root package name */
        public long f61037f;

        /* renamed from: g  reason: collision with root package name */
        public long f61038g;

        /* renamed from: h  reason: collision with root package name */
        public int f61039h;
        public String i;
        public int j;
        public String k;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f61040a;

        /* renamed from: b  reason: collision with root package name */
        public int f61041b;

        /* renamed from: c  reason: collision with root package name */
        public int f61042c;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f61043a;

        /* renamed from: b  reason: collision with root package name */
        public String f61044b;
    }

    public ArrayList<C1582a> a() {
        return this.f61029e;
    }

    public long b() {
        return this.f61025a;
    }

    public b c() {
        return this.f61027c;
    }

    public c d() {
        return this.f61028d;
    }

    public long e() {
        return this.f61026b;
    }

    public void f(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f61025a = dataRes.total_num.intValue();
        this.f61026b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f61030f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            j0 j0Var = new j0();
            this.f61031g = j0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                j0Var.f50821a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f61031g.f50822b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f61027c = bVar;
            bVar.f61040a = dataRes.page.cur_page.intValue();
            this.f61027c.f61041b = dataRes.page.has_more.intValue();
            this.f61027c.f61042c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f61028d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f61043a = presentmoneytxt.txt;
            cVar.f61044b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f61029e = new ArrayList<>();
        for (int i = 0; i < dataRes.gift_list.size(); i++) {
            PresentMyList presentMyList = dataRes.gift_list.get(i);
            if (presentMyList != null) {
                C1582a c1582a = new C1582a();
                c1582a.j = i + 1;
                c1582a.f61032a = presentMyList.pay_userid.longValue();
                c1582a.f61033b = presentMyList.pay_username;
                c1582a.f61034c = presentMyList.portrait;
                presentMyList.gift_id.intValue();
                String str3 = presentMyList.gift_name;
                String str4 = presentMyList.play_url;
                c1582a.f61035d = presentMyList.thumbnail_url;
                c1582a.f61036e = presentMyList.create_time.intValue();
                c1582a.f61037f = presentMyList.num.intValue();
                c1582a.f61039h = presentMyList.currency_unit.intValue();
                c1582a.i = presentMyList.currency_type;
                c1582a.f61038g = presentMyList.present_scores.longValue();
                c1582a.k = presentMyList.name_show;
                this.f61029e.add(c1582a);
            }
        }
    }

    public void g(ArrayList<C1582a> arrayList) {
        this.f61029e = arrayList;
    }

    public void h(long j) {
        this.f61025a = j;
    }

    public void i(b bVar) {
        this.f61027c = bVar;
    }

    public void j(c cVar) {
        this.f61028d = cVar;
    }

    public void k(long j) {
        this.f61026b = j;
    }
}
