package d.b.j0.u0.c;

import d.b.i0.r.q.j0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f63135a;

    /* renamed from: b  reason: collision with root package name */
    public long f63136b;

    /* renamed from: c  reason: collision with root package name */
    public b f63137c;

    /* renamed from: d  reason: collision with root package name */
    public c f63138d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1665a> f63139e;

    /* renamed from: f  reason: collision with root package name */
    public long f63140f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f63141g;

    /* renamed from: d.b.j0.u0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1665a {

        /* renamed from: a  reason: collision with root package name */
        public long f63142a;

        /* renamed from: b  reason: collision with root package name */
        public String f63143b;

        /* renamed from: c  reason: collision with root package name */
        public String f63144c;

        /* renamed from: d  reason: collision with root package name */
        public String f63145d;

        /* renamed from: e  reason: collision with root package name */
        public long f63146e;

        /* renamed from: f  reason: collision with root package name */
        public long f63147f;

        /* renamed from: g  reason: collision with root package name */
        public long f63148g;

        /* renamed from: h  reason: collision with root package name */
        public int f63149h;
        public String i;
        public int j;
        public String k;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f63150a;

        /* renamed from: b  reason: collision with root package name */
        public int f63151b;

        /* renamed from: c  reason: collision with root package name */
        public int f63152c;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f63153a;

        /* renamed from: b  reason: collision with root package name */
        public String f63154b;
    }

    public ArrayList<C1665a> a() {
        return this.f63139e;
    }

    public long b() {
        return this.f63135a;
    }

    public b c() {
        return this.f63137c;
    }

    public c d() {
        return this.f63138d;
    }

    public long e() {
        return this.f63136b;
    }

    public void f(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f63135a = dataRes.total_num.intValue();
        this.f63136b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f63140f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            j0 j0Var = new j0();
            this.f63141g = j0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                j0Var.f51564a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f63141g.f51565b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f63137c = bVar;
            bVar.f63150a = dataRes.page.cur_page.intValue();
            this.f63137c.f63151b = dataRes.page.has_more.intValue();
            this.f63137c.f63152c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f63138d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f63153a = presentmoneytxt.txt;
            cVar.f63154b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f63139e = new ArrayList<>();
        for (int i = 0; i < dataRes.gift_list.size(); i++) {
            PresentMyList presentMyList = dataRes.gift_list.get(i);
            if (presentMyList != null) {
                C1665a c1665a = new C1665a();
                c1665a.j = i + 1;
                c1665a.f63142a = presentMyList.pay_userid.longValue();
                c1665a.f63143b = presentMyList.pay_username;
                c1665a.f63144c = presentMyList.portrait;
                presentMyList.gift_id.intValue();
                String str3 = presentMyList.gift_name;
                String str4 = presentMyList.play_url;
                c1665a.f63145d = presentMyList.thumbnail_url;
                c1665a.f63146e = presentMyList.create_time.intValue();
                c1665a.f63147f = presentMyList.num.intValue();
                c1665a.f63149h = presentMyList.currency_unit.intValue();
                c1665a.i = presentMyList.currency_type;
                c1665a.f63148g = presentMyList.present_scores.longValue();
                c1665a.k = presentMyList.name_show;
                this.f63139e.add(c1665a);
            }
        }
    }

    public void g(ArrayList<C1665a> arrayList) {
        this.f63139e = arrayList;
    }

    public void h(long j) {
        this.f63135a = j;
    }

    public void i(b bVar) {
        this.f63137c = bVar;
    }

    public void j(c cVar) {
        this.f63138d = cVar;
    }

    public void k(long j) {
        this.f63136b = j;
    }
}
