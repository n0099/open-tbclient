package d.a.k0.u0.c;

import d.a.j0.r.q.j0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f62070a;

    /* renamed from: b  reason: collision with root package name */
    public long f62071b;

    /* renamed from: c  reason: collision with root package name */
    public b f62072c;

    /* renamed from: d  reason: collision with root package name */
    public c f62073d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1670a> f62074e;

    /* renamed from: f  reason: collision with root package name */
    public long f62075f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f62076g;

    /* renamed from: h  reason: collision with root package name */
    public int f62077h;

    /* renamed from: d.a.k0.u0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1670a {

        /* renamed from: a  reason: collision with root package name */
        public long f62078a;

        /* renamed from: b  reason: collision with root package name */
        public String f62079b;

        /* renamed from: c  reason: collision with root package name */
        public String f62080c;

        /* renamed from: d  reason: collision with root package name */
        public String f62081d;

        /* renamed from: e  reason: collision with root package name */
        public long f62082e;

        /* renamed from: f  reason: collision with root package name */
        public long f62083f;

        /* renamed from: g  reason: collision with root package name */
        public long f62084g;

        /* renamed from: h  reason: collision with root package name */
        public int f62085h;

        /* renamed from: i  reason: collision with root package name */
        public String f62086i;
        public int j;
        public String k;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f62087a;

        /* renamed from: b  reason: collision with root package name */
        public int f62088b;

        /* renamed from: c  reason: collision with root package name */
        public int f62089c;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f62090a;

        /* renamed from: b  reason: collision with root package name */
        public String f62091b;
    }

    public ArrayList<C1670a> a() {
        return this.f62074e;
    }

    public long b() {
        return this.f62070a;
    }

    public b c() {
        return this.f62072c;
    }

    public c d() {
        return this.f62073d;
    }

    public long e() {
        return this.f62071b;
    }

    public void f(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f62070a = dataRes.total_num.intValue();
        this.f62071b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f62075f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            j0 j0Var = new j0();
            this.f62076g = j0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                j0Var.f50012a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f62076g.f50013b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f62072c = bVar;
            bVar.f62087a = dataRes.page.cur_page.intValue();
            this.f62072c.f62088b = dataRes.page.has_more.intValue();
            this.f62072c.f62089c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f62073d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f62090a = presentmoneytxt.txt;
            cVar.f62091b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f62074e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1670a c1670a = new C1670a();
                    c1670a.j = i2 + 1;
                    c1670a.f62078a = presentMyList.pay_userid.longValue();
                    c1670a.f62079b = presentMyList.pay_username;
                    c1670a.f62080c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1670a.f62081d = presentMyList.thumbnail_url;
                    c1670a.f62082e = presentMyList.create_time.intValue();
                    c1670a.f62083f = presentMyList.num.intValue();
                    c1670a.f62085h = presentMyList.currency_unit.intValue();
                    c1670a.f62086i = presentMyList.currency_type;
                    c1670a.f62084g = presentMyList.present_scores.longValue();
                    c1670a.k = presentMyList.name_show;
                    this.f62074e.add(c1670a);
                }
            }
        }
        this.f62077h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1670a> arrayList) {
        this.f62074e = arrayList;
    }

    public void h(long j) {
        this.f62070a = j;
    }

    public void i(b bVar) {
        this.f62072c = bVar;
    }

    public void j(c cVar) {
        this.f62073d = cVar;
    }

    public void k(long j) {
        this.f62071b = j;
    }
}
