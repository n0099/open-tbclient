package d.a.n0.v0.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.gift.giftTab.CategoryGiftListModel;
import com.baidu.tieba.gift.giftTab.DefaultGiftListModel;
import com.baidu.tieba.gift.giftTab.FreeGiftChanceModel;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
import d.a.m0.r.q.i0;
import d.a.m0.r.q.j0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f<GiftTabActivity> f65930a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f65931b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f65932c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f65933d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.n0.v0.b.c> f65934e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.n0.v0.b.a> f65935f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.n0.v0.b.e> f65936g;

    /* renamed from: i  reason: collision with root package name */
    public int f65938i;
    public String j;
    public int k;
    public j0 l;
    public e m;
    public d n;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<i0>> f65937h = new HashMap<>();
    public DefaultGiftListModel.b o = new a();
    public CategoryGiftListModel.b p = new b();
    public FreeGiftChanceModel.b q = new c();

    /* loaded from: classes4.dex */
    public class a implements DefaultGiftListModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i2, String str, int i3, String str2, int i4, j0 j0Var, ArrayList<d.a.n0.v0.b.a> arrayList, ArrayList<i0> arrayList2, ArrayList<d.a.n0.v0.b.e> arrayList3) {
            if (i2 == 0) {
                int i5 = 0;
                if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                    i5 = arrayList.get(0).a();
                }
                f.this.f65935f = arrayList;
                f.this.f65937h.put(Integer.valueOf(i5), arrayList2);
                f.this.f65936g = arrayList3;
                f.this.j = str2;
                f.this.f65938i = i3;
                f fVar = f.this;
                fVar.k = i4;
                fVar.l = j0Var;
                fVar.q();
            }
            if (f.this.m != null) {
                e eVar = f.this.m;
                String str3 = f.this.j;
                f fVar2 = f.this;
                eVar.a(i2, str, true, str3, fVar2.k, fVar2.l, fVar2.f65934e, f.this.f65935f, f.this.f65936g);
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
                f.this.f65937h.put(Integer.valueOf(i3), arrayList);
                f.this.q();
            }
            if (f.this.m != null) {
                e eVar = f.this.m;
                String str2 = f.this.j;
                f fVar = f.this;
                eVar.a(i2, str, false, str2, fVar.k, fVar.l, fVar.f65934e, f.this.f65935f, f.this.f65936g);
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
            f.this.f65938i = i3;
            if (f.this.n != null) {
                f.this.n.a(f.this.f65938i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i2, String str, boolean z, String str2, int i3, j0 j0Var, ArrayList<d.a.n0.v0.b.c> arrayList, ArrayList<d.a.n0.v0.b.a> arrayList2, ArrayList<d.a.n0.v0.b.e> arrayList3);
    }

    public f(d.a.c.a.f<GiftTabActivity> fVar) {
        this.f65930a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f65931b = defaultGiftListModel;
        defaultGiftListModel.I(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f65930a);
        this.f65932c = categoryGiftListModel;
        categoryGiftListModel.A(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f65930a);
        this.f65933d = freeGiftChanceModel;
        freeGiftChanceModel.A(this.q);
    }

    public void n(String str) {
        if (this.f65933d == null) {
            FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f65930a);
            this.f65933d = freeGiftChanceModel;
            freeGiftChanceModel.A(this.q);
        }
        this.f65933d.z(str);
    }

    public void o(String str, long j) {
        if (this.f65931b == null) {
            DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.f65930a);
            this.f65931b = defaultGiftListModel;
            defaultGiftListModel.I(this.o);
        }
        this.f65931b.H(str, j);
    }

    public void p(int i2) {
        if (this.f65932c == null) {
            CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f65930a);
            this.f65932c = categoryGiftListModel;
            categoryGiftListModel.A(this.p);
        }
        this.f65932c.z(i2);
    }

    public final void q() {
        ArrayList<d.a.n0.v0.b.a> arrayList;
        HashMap<Integer, ArrayList<i0>> hashMap = this.f65937h;
        if (hashMap == null || hashMap.size() <= 0 || (arrayList = this.f65935f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f65934e == null) {
            this.f65934e = new ArrayList<>();
        }
        this.f65934e.clear();
        Iterator<d.a.n0.v0.b.a> it = this.f65935f.iterator();
        while (it.hasNext()) {
            d.a.n0.v0.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                d.a.n0.v0.b.c cVar = new d.a.n0.v0.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<i0> arrayList2 = this.f65937h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f65934e.add(cVar);
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
