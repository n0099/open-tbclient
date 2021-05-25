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
    public long f62227a;

    /* renamed from: b  reason: collision with root package name */
    public long f62228b;

    /* renamed from: c  reason: collision with root package name */
    public b f62229c;

    /* renamed from: d  reason: collision with root package name */
    public c f62230d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1683a> f62231e;

    /* renamed from: f  reason: collision with root package name */
    public long f62232f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f62233g;

    /* renamed from: h  reason: collision with root package name */
    public int f62234h;

    /* renamed from: d.a.n0.v0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1683a {

        /* renamed from: a  reason: collision with root package name */
        public long f62235a;

        /* renamed from: b  reason: collision with root package name */
        public String f62236b;

        /* renamed from: c  reason: collision with root package name */
        public String f62237c;

        /* renamed from: d  reason: collision with root package name */
        public String f62238d;

        /* renamed from: e  reason: collision with root package name */
        public long f62239e;

        /* renamed from: f  reason: collision with root package name */
        public long f62240f;

        /* renamed from: g  reason: collision with root package name */
        public long f62241g;

        /* renamed from: h  reason: collision with root package name */
        public int f62242h;

        /* renamed from: i  reason: collision with root package name */
        public String f62243i;
        public int j;
        public String k;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f62244a;

        /* renamed from: b  reason: collision with root package name */
        public int f62245b;

        /* renamed from: c  reason: collision with root package name */
        public int f62246c;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f62247a;

        /* renamed from: b  reason: collision with root package name */
        public String f62248b;
    }

    public ArrayList<C1683a> a() {
        return this.f62231e;
    }

    public long b() {
        return this.f62227a;
    }

    public b c() {
        return this.f62229c;
    }

    public c d() {
        return this.f62230d;
    }

    public long e() {
        return this.f62228b;
    }

    public void f(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f62227a = dataRes.total_num.intValue();
        this.f62228b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f62232f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            j0 j0Var = new j0();
            this.f62233g = j0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                j0Var.f50056a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f62233g.f50057b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f62229c = bVar;
            bVar.f62244a = dataRes.page.cur_page.intValue();
            this.f62229c.f62245b = dataRes.page.has_more.intValue();
            this.f62229c.f62246c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f62230d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f62247a = presentmoneytxt.txt;
            cVar.f62248b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f62231e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1683a c1683a = new C1683a();
                    c1683a.j = i2 + 1;
                    c1683a.f62235a = presentMyList.pay_userid.longValue();
                    c1683a.f62236b = presentMyList.pay_username;
                    c1683a.f62237c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1683a.f62238d = presentMyList.thumbnail_url;
                    c1683a.f62239e = presentMyList.create_time.intValue();
                    c1683a.f62240f = presentMyList.num.intValue();
                    c1683a.f62242h = presentMyList.currency_unit.intValue();
                    c1683a.f62243i = presentMyList.currency_type;
                    c1683a.f62241g = presentMyList.present_scores.longValue();
                    c1683a.k = presentMyList.name_show;
                    this.f62231e.add(c1683a);
                }
            }
        }
        this.f62234h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1683a> arrayList) {
        this.f62231e = arrayList;
    }

    public void h(long j) {
        this.f62227a = j;
    }

    public void i(b bVar) {
        this.f62229c = bVar;
    }

    public void j(c cVar) {
        this.f62230d = cVar;
    }

    public void k(long j) {
        this.f62228b = j;
    }
}
