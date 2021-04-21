package d.b.j0.u0.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.gift.giftTab.CategoryGiftListModel;
import com.baidu.tieba.gift.giftTab.DefaultGiftListModel;
import com.baidu.tieba.gift.giftTab.FreeGiftChanceModel;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
import d.b.i0.r.q.i0;
import d.b.i0.r.q.j0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.a.f<GiftTabActivity> f63124a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f63125b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f63126c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f63127d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.b.j0.u0.b.c> f63128e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.b.j0.u0.b.a> f63129f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.b.j0.u0.b.e> f63130g;
    public int i;
    public String j;
    public int k;
    public j0 l;
    public e m;
    public d n;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<i0>> f63131h = new HashMap<>();
    public DefaultGiftListModel.b o = new a();
    public CategoryGiftListModel.b p = new b();
    public FreeGiftChanceModel.b q = new c();

    /* loaded from: classes4.dex */
    public class a implements DefaultGiftListModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i, String str, int i2, String str2, int i3, j0 j0Var, ArrayList<d.b.j0.u0.b.a> arrayList, ArrayList<i0> arrayList2, ArrayList<d.b.j0.u0.b.e> arrayList3) {
            if (i == 0) {
                int i4 = 0;
                if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                    i4 = arrayList.get(0).a();
                }
                f.this.f63129f = arrayList;
                f.this.f63131h.put(Integer.valueOf(i4), arrayList2);
                f.this.f63130g = arrayList3;
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
                eVar.a(i, str, true, str3, fVar2.k, fVar2.l, fVar2.f63128e, f.this.f63129f, f.this.f63130g);
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
                f.this.f63131h.put(Integer.valueOf(i2), arrayList);
                f.this.q();
            }
            if (f.this.m != null) {
                e eVar = f.this.m;
                String str2 = f.this.j;
                f fVar = f.this;
                eVar.a(i, str, false, str2, fVar.k, fVar.l, fVar.f63128e, f.this.f63129f, f.this.f63130g);
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
        void a(int i, String str, boolean z, String str2, int i2, j0 j0Var, ArrayList<d.b.j0.u0.b.c> arrayList, ArrayList<d.b.j0.u0.b.a> arrayList2, ArrayList<d.b.j0.u0.b.e> arrayList3);
    }

    public f(d.b.c.a.f<GiftTabActivity> fVar) {
        this.f63124a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f63125b = defaultGiftListModel;
        defaultGiftListModel.E(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f63124a);
        this.f63126c = categoryGiftListModel;
        categoryGiftListModel.w(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f63124a);
        this.f63127d = freeGiftChanceModel;
        freeGiftChanceModel.w(this.q);
    }

    public void n(String str) {
        if (this.f63127d == null) {
            FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f63124a);
            this.f63127d = freeGiftChanceModel;
            freeGiftChanceModel.w(this.q);
        }
        this.f63127d.v(str);
    }

    public void o(String str, long j) {
        if (this.f63125b == null) {
            DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.f63124a);
            this.f63125b = defaultGiftListModel;
            defaultGiftListModel.E(this.o);
        }
        this.f63125b.D(str, j);
    }

    public void p(int i) {
        if (this.f63126c == null) {
            CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f63124a);
            this.f63126c = categoryGiftListModel;
            categoryGiftListModel.w(this.p);
        }
        this.f63126c.v(i);
    }

    public final void q() {
        ArrayList<d.b.j0.u0.b.a> arrayList;
        HashMap<Integer, ArrayList<i0>> hashMap = this.f63131h;
        if (hashMap == null || hashMap.size() <= 0 || (arrayList = this.f63129f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f63128e == null) {
            this.f63128e = new ArrayList<>();
        }
        this.f63128e.clear();
        Iterator<d.b.j0.u0.b.a> it = this.f63129f.iterator();
        while (it.hasNext()) {
            d.b.j0.u0.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                d.b.j0.u0.b.c cVar = new d.b.j0.u0.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<i0> arrayList2 = this.f63131h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f63128e.add(cVar);
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
