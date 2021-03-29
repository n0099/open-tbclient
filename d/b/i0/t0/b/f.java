package d.b.i0.t0.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.gift.giftTab.CategoryGiftListModel;
import com.baidu.tieba.gift.giftTab.DefaultGiftListModel;
import com.baidu.tieba.gift.giftTab.FreeGiftChanceModel;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
import d.b.h0.r.q.i0;
import d.b.h0.r.q.j0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.a.f<GiftTabActivity> f61014a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f61015b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f61016c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f61017d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.b.i0.t0.b.c> f61018e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.b.i0.t0.b.a> f61019f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.b.i0.t0.b.e> f61020g;
    public int i;
    public String j;
    public int k;
    public j0 l;
    public e m;
    public d n;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<i0>> f61021h = new HashMap<>();
    public DefaultGiftListModel.b o = new a();
    public CategoryGiftListModel.b p = new b();
    public FreeGiftChanceModel.b q = new c();

    /* loaded from: classes4.dex */
    public class a implements DefaultGiftListModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i, String str, int i2, String str2, int i3, j0 j0Var, ArrayList<d.b.i0.t0.b.a> arrayList, ArrayList<i0> arrayList2, ArrayList<d.b.i0.t0.b.e> arrayList3) {
            if (i == 0) {
                int i4 = 0;
                if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                    i4 = arrayList.get(0).a();
                }
                f.this.f61019f = arrayList;
                f.this.f61021h.put(Integer.valueOf(i4), arrayList2);
                f.this.f61020g = arrayList3;
                f.this.j = str2;
                f.this.i = i2;
                f fVar = f.this;
                fVar.k = i3;
                fVar.l = j0Var;
                fVar.q();
            }
            if (f.this.m != null) {
                e eVar = f.this.m;
                String str3 = f.this.j;
                f fVar2 = f.this;
                eVar.a(i, str, true, str3, fVar2.k, fVar2.l, fVar2.f61018e, f.this.f61019f, f.this.f61020g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CategoryGiftListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i, String str, int i2, ArrayList<i0> arrayList) {
            if (i == 0) {
                f.this.f61021h.put(Integer.valueOf(i2), arrayList);
                f.this.q();
            }
            if (f.this.m != null) {
                e eVar = f.this.m;
                String str2 = f.this.j;
                f fVar = f.this;
                eVar.a(i, str, false, str2, fVar.k, fVar.l, fVar.f61018e, f.this.f61019f, f.this.f61020g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FreeGiftChanceModel.b {
        public c() {
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i, String str, int i2) {
            if (i != 0) {
                return;
            }
            f.this.i = i2;
            if (f.this.n != null) {
                f.this.n.a(f.this.i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i, String str, boolean z, String str2, int i2, j0 j0Var, ArrayList<d.b.i0.t0.b.c> arrayList, ArrayList<d.b.i0.t0.b.a> arrayList2, ArrayList<d.b.i0.t0.b.e> arrayList3);
    }

    public f(d.b.b.a.f<GiftTabActivity> fVar) {
        this.f61014a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f61015b = defaultGiftListModel;
        defaultGiftListModel.E(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f61014a);
        this.f61016c = categoryGiftListModel;
        categoryGiftListModel.w(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f61014a);
        this.f61017d = freeGiftChanceModel;
        freeGiftChanceModel.w(this.q);
    }

    public void n(String str) {
        if (this.f61017d == null) {
            FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f61014a);
            this.f61017d = freeGiftChanceModel;
            freeGiftChanceModel.w(this.q);
        }
        this.f61017d.v(str);
    }

    public void o(String str, long j) {
        if (this.f61015b == null) {
            DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.f61014a);
            this.f61015b = defaultGiftListModel;
            defaultGiftListModel.E(this.o);
        }
        this.f61015b.D(str, j);
    }

    public void p(int i) {
        if (this.f61016c == null) {
            CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f61014a);
            this.f61016c = categoryGiftListModel;
            categoryGiftListModel.w(this.p);
        }
        this.f61016c.v(i);
    }

    public final void q() {
        ArrayList<d.b.i0.t0.b.a> arrayList;
        HashMap<Integer, ArrayList<i0>> hashMap = this.f61021h;
        if (hashMap == null || hashMap.size() <= 0 || (arrayList = this.f61019f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f61018e == null) {
            this.f61018e = new ArrayList<>();
        }
        this.f61018e.clear();
        Iterator<d.b.i0.t0.b.a> it = this.f61019f.iterator();
        while (it.hasNext()) {
            d.b.i0.t0.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                d.b.i0.t0.b.c cVar = new d.b.i0.t0.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<i0> arrayList2 = this.f61021h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f61018e.add(cVar);
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
