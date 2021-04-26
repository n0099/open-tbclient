package d.a.j0.u0.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.gift.giftTab.CategoryGiftListModel;
import com.baidu.tieba.gift.giftTab.DefaultGiftListModel;
import com.baidu.tieba.gift.giftTab.FreeGiftChanceModel;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
import d.a.i0.r.q.i0;
import d.a.i0.r.q.j0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f<GiftTabActivity> f61334a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f61335b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f61336c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f61337d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.j0.u0.b.c> f61338e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.j0.u0.b.a> f61339f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.j0.u0.b.e> f61340g;

    /* renamed from: i  reason: collision with root package name */
    public int f61342i;
    public String j;
    public int k;
    public j0 l;
    public e m;
    public d n;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<i0>> f61341h = new HashMap<>();
    public DefaultGiftListModel.b o = new a();
    public CategoryGiftListModel.b p = new b();
    public FreeGiftChanceModel.b q = new c();

    /* loaded from: classes4.dex */
    public class a implements DefaultGiftListModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i2, String str, int i3, String str2, int i4, j0 j0Var, ArrayList<d.a.j0.u0.b.a> arrayList, ArrayList<i0> arrayList2, ArrayList<d.a.j0.u0.b.e> arrayList3) {
            if (i2 == 0) {
                int i5 = 0;
                if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                    i5 = arrayList.get(0).a();
                }
                f.this.f61339f = arrayList;
                f.this.f61341h.put(Integer.valueOf(i5), arrayList2);
                f.this.f61340g = arrayList3;
                f.this.j = str2;
                f.this.f61342i = i3;
                f fVar = f.this;
                fVar.k = i4;
                fVar.l = j0Var;
                fVar.q();
            }
            if (f.this.m != null) {
                e eVar = f.this.m;
                String str3 = f.this.j;
                f fVar2 = f.this;
                eVar.a(i2, str, true, str3, fVar2.k, fVar2.l, fVar2.f61338e, f.this.f61339f, f.this.f61340g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CategoryGiftListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i2, String str, int i3, ArrayList<i0> arrayList) {
            if (i2 == 0) {
                f.this.f61341h.put(Integer.valueOf(i3), arrayList);
                f.this.q();
            }
            if (f.this.m != null) {
                e eVar = f.this.m;
                String str2 = f.this.j;
                f fVar = f.this;
                eVar.a(i2, str, false, str2, fVar.k, fVar.l, fVar.f61338e, f.this.f61339f, f.this.f61340g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FreeGiftChanceModel.b {
        public c() {
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i2, String str, int i3) {
            if (i2 != 0) {
                return;
            }
            f.this.f61342i = i3;
            if (f.this.n != null) {
                f.this.n.a(f.this.f61342i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i2, String str, boolean z, String str2, int i3, j0 j0Var, ArrayList<d.a.j0.u0.b.c> arrayList, ArrayList<d.a.j0.u0.b.a> arrayList2, ArrayList<d.a.j0.u0.b.e> arrayList3);
    }

    public f(d.a.c.a.f<GiftTabActivity> fVar) {
        this.f61334a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f61335b = defaultGiftListModel;
        defaultGiftListModel.E(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f61334a);
        this.f61336c = categoryGiftListModel;
        categoryGiftListModel.w(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f61334a);
        this.f61337d = freeGiftChanceModel;
        freeGiftChanceModel.w(this.q);
    }

    public void n(String str) {
        if (this.f61337d == null) {
            FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f61334a);
            this.f61337d = freeGiftChanceModel;
            freeGiftChanceModel.w(this.q);
        }
        this.f61337d.v(str);
    }

    public void o(String str, long j) {
        if (this.f61335b == null) {
            DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.f61334a);
            this.f61335b = defaultGiftListModel;
            defaultGiftListModel.E(this.o);
        }
        this.f61335b.D(str, j);
    }

    public void p(int i2) {
        if (this.f61336c == null) {
            CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f61334a);
            this.f61336c = categoryGiftListModel;
            categoryGiftListModel.w(this.p);
        }
        this.f61336c.v(i2);
    }

    public final void q() {
        ArrayList<d.a.j0.u0.b.a> arrayList;
        HashMap<Integer, ArrayList<i0>> hashMap = this.f61341h;
        if (hashMap == null || hashMap.size() <= 0 || (arrayList = this.f61339f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f61338e == null) {
            this.f61338e = new ArrayList<>();
        }
        this.f61338e.clear();
        Iterator<d.a.j0.u0.b.a> it = this.f61339f.iterator();
        while (it.hasNext()) {
            d.a.j0.u0.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                d.a.j0.u0.b.c cVar = new d.a.j0.u0.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<i0> arrayList2 = this.f61341h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f61338e.add(cVar);
            }
        }
    }

    public void r(d dVar) {
        this.n = dVar;
    }

    public void s(e eVar) {
        this.m = eVar;
    }
}
