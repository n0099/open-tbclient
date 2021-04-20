package d.b.i0.u0.c;

import d.b.h0.r.q.j0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f62714a;

    /* renamed from: b  reason: collision with root package name */
    public long f62715b;

    /* renamed from: c  reason: collision with root package name */
    public b f62716c;

    /* renamed from: d  reason: collision with root package name */
    public c f62717d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1642a> f62718e;

    /* renamed from: f  reason: collision with root package name */
    public long f62719f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f62720g;

    /* renamed from: d.b.i0.u0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1642a {

        /* renamed from: a  reason: collision with root package name */
        public long f62721a;

        /* renamed from: b  reason: collision with root package name */
        public String f62722b;

        /* renamed from: c  reason: collision with root package name */
        public String f62723c;

        /* renamed from: d  reason: collision with root package name */
        public String f62724d;

        /* renamed from: e  reason: collision with root package name */
        public long f62725e;

        /* renamed from: f  reason: collision with root package name */
        public long f62726f;

        /* renamed from: g  reason: collision with root package name */
        public long f62727g;

        /* renamed from: h  reason: collision with root package name */
        public int f62728h;
        public String i;
        public int j;
        public String k;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f62729a;

        /* renamed from: b  reason: collision with root package name */
        public int f62730b;

        /* renamed from: c  reason: collision with root package name */
        public int f62731c;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f62732a;

        /* renamed from: b  reason: collision with root package name */
        public String f62733b;
    }

    public ArrayList<C1642a> a() {
        return this.f62718e;
    }

    public long b() {
        return this.f62714a;
    }

    public b c() {
        return this.f62716c;
    }

    public c d() {
        return this.f62717d;
    }

    public long e() {
        return this.f62715b;
    }

    public void f(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f62714a = dataRes.total_num.intValue();
        this.f62715b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f62719f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            j0 j0Var = new j0();
            this.f62720g = j0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                j0Var.f51228a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f62720g.f51229b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f62716c = bVar;
            bVar.f62729a = dataRes.page.cur_page.intValue();
            this.f62716c.f62730b = dataRes.page.has_more.intValue();
            this.f62716c.f62731c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f62717d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f62732a = presentmoneytxt.txt;
            cVar.f62733b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f62718e = new ArrayList<>();
        for (int i = 0; i < dataRes.gift_list.size(); i++) {
            PresentMyList presentMyList = dataRes.gift_list.get(i);
            if (presentMyList != null) {
                C1642a c1642a = new C1642a();
                c1642a.j = i + 1;
                c1642a.f62721a = presentMyList.pay_userid.longValue();
                c1642a.f62722b = presentMyList.pay_username;
                c1642a.f62723c = presentMyList.portrait;
                presentMyList.gift_id.intValue();
                String str3 = presentMyList.gift_name;
                String str4 = presentMyList.play_url;
                c1642a.f62724d = presentMyList.thumbnail_url;
                c1642a.f62725e = presentMyList.create_time.intValue();
                c1642a.f62726f = presentMyList.num.intValue();
                c1642a.f62728h = presentMyList.currency_unit.intValue();
                c1642a.i = presentMyList.currency_type;
                c1642a.f62727g = presentMyList.present_scores.longValue();
                c1642a.k = presentMyList.name_show;
                this.f62718e.add(c1642a);
            }
        }
    }

    public void g(ArrayList<C1642a> arrayList) {
        this.f62718e = arrayList;
    }

    public void h(long j) {
        this.f62714a = j;
    }

    public void i(b bVar) {
        this.f62716c = bVar;
    }

    public void j(c cVar) {
        this.f62717d = cVar;
    }

    public void k(long j) {
        this.f62715b = j;
    }
}
