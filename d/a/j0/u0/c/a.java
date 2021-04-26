package d.a.j0.u0.c;

import d.a.i0.r.q.j0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f61346a;

    /* renamed from: b  reason: collision with root package name */
    public long f61347b;

    /* renamed from: c  reason: collision with root package name */
    public b f61348c;

    /* renamed from: d  reason: collision with root package name */
    public c f61349d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1605a> f61350e;

    /* renamed from: f  reason: collision with root package name */
    public long f61351f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f61352g;

    /* renamed from: h  reason: collision with root package name */
    public int f61353h;

    /* renamed from: d.a.j0.u0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1605a {

        /* renamed from: a  reason: collision with root package name */
        public long f61354a;

        /* renamed from: b  reason: collision with root package name */
        public String f61355b;

        /* renamed from: c  reason: collision with root package name */
        public String f61356c;

        /* renamed from: d  reason: collision with root package name */
        public String f61357d;

        /* renamed from: e  reason: collision with root package name */
        public long f61358e;

        /* renamed from: f  reason: collision with root package name */
        public long f61359f;

        /* renamed from: g  reason: collision with root package name */
        public long f61360g;

        /* renamed from: h  reason: collision with root package name */
        public int f61361h;

        /* renamed from: i  reason: collision with root package name */
        public String f61362i;
        public int j;
        public String k;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f61363a;

        /* renamed from: b  reason: collision with root package name */
        public int f61364b;

        /* renamed from: c  reason: collision with root package name */
        public int f61365c;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f61366a;

        /* renamed from: b  reason: collision with root package name */
        public String f61367b;
    }

    public ArrayList<C1605a> a() {
        return this.f61350e;
    }

    public long b() {
        return this.f61346a;
    }

    public b c() {
        return this.f61348c;
    }

    public c d() {
        return this.f61349d;
    }

    public long e() {
        return this.f61347b;
    }

    public void f(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f61346a = dataRes.total_num.intValue();
        this.f61347b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f61351f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            j0 j0Var = new j0();
            this.f61352g = j0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                j0Var.f49193a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f61352g.f49194b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f61348c = bVar;
            bVar.f61363a = dataRes.page.cur_page.intValue();
            this.f61348c.f61364b = dataRes.page.has_more.intValue();
            this.f61348c.f61365c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f61349d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f61366a = presentmoneytxt.txt;
            cVar.f61367b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f61350e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1605a c1605a = new C1605a();
                    c1605a.j = i2 + 1;
                    c1605a.f61354a = presentMyList.pay_userid.longValue();
                    c1605a.f61355b = presentMyList.pay_username;
                    c1605a.f61356c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1605a.f61357d = presentMyList.thumbnail_url;
                    c1605a.f61358e = presentMyList.create_time.intValue();
                    c1605a.f61359f = presentMyList.num.intValue();
                    c1605a.f61361h = presentMyList.currency_unit.intValue();
                    c1605a.f61362i = presentMyList.currency_type;
                    c1605a.f61360g = presentMyList.present_scores.longValue();
                    c1605a.k = presentMyList.name_show;
                    this.f61350e.add(c1605a);
                }
            }
        }
        this.f61353h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1605a> arrayList) {
        this.f61350e = arrayList;
    }

    public void h(long j) {
        this.f61346a = j;
    }

    public void i(b bVar) {
        this.f61348c = bVar;
    }

    public void j(c cVar) {
        this.f61349d = cVar;
    }

    public void k(long j) {
        this.f61347b = j;
    }
}
