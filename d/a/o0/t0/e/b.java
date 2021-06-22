package d.a.o0.t0.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.funad.adapter.FunAdNativeViewHolder;
import com.baidu.tieba.funad.view.FunAdNativeFrsView;
import com.baidu.tieba.funad.view.FunAdNativePbView;
import d.a.n0.b.d;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.z1;
import d.a.o0.e3.h0.n;
import d.a.o0.s0.d.c;
import d.a.o0.t2.p;
import d.a.o0.t2.t;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class b extends d.a.c.k.e.a<d.a.n0.r.q.a, FunAdNativeViewHolder> implements t, p {
    public final BaseFragmentActivity m;
    public String n;
    public Set<String> o;
    public String p;
    public String q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f64685e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f64686f;

        public a(n nVar, FunAdNativeViewHolder funAdNativeViewHolder) {
            this.f64685e = nVar;
            this.f64686f = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f64685e.m(true);
            b.this.L();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f64686f.e().getPageType()).param("obj_locate", 0));
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.o = new HashSet();
        this.m = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public FunAdNativeViewHolder Q(ViewGroup viewGroup) {
        FunAdNativeViewHolder funAdNativeViewHolder = new FunAdNativeViewHolder(this.f43015h == AdvertAppInfo.o4 ? new FunAdNativeFrsView(this.m) : new FunAdNativePbView(this.m), this.m, this.f43015h);
        funAdNativeViewHolder.j(this.n);
        funAdNativeViewHolder.i(this.q);
        return funAdNativeViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.r.q.a aVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        n nVar;
        long j;
        if (aVar instanceof z1) {
            a2 a2Var = ((z1) aVar).w;
            nVar = a2Var.F2;
            j = a2Var.c0();
        } else if (aVar instanceof a2) {
            a2 a2Var2 = (a2) aVar;
            nVar = a2Var2.F2;
            j = a2Var2.c0();
        } else {
            nVar = null;
            j = 0;
        }
        if (nVar == null) {
            funAdNativeViewHolder.e().d(8);
            return funAdNativeViewHolder.a();
        }
        if (!"personalize".equals(this.p)) {
            this.n = c.e().d(this.q);
        }
        if (this.f43015h == AdvertAppInfo.o4) {
            if ("frs".equals(this.p)) {
                d.a.o0.s0.a.h().r(this.m, this.n, d.a.o0.s0.a.a(this.p, d.m() ? "1" : "0"), String.valueOf(j));
            } else if ("personalize".equals(this.p)) {
                d.a.o0.s0.a.h().q(this.m, this.n, d.a.o0.s0.a.a(this.p, d.C() ? "1" : "0"));
            }
        }
        funAdNativeViewHolder.g(new a(nVar, funAdNativeViewHolder));
        funAdNativeViewHolder.e().h();
        funAdNativeViewHolder.h(this.p);
        funAdNativeViewHolder.j(this.n);
        this.o.add(this.n);
        funAdNativeViewHolder.k(nVar);
        return funAdNativeViewHolder.a();
    }

    public void h0(String str) {
        this.p = str;
    }

    public void i0(String str) {
        this.q = str;
    }

    public void j0(String str) {
        this.n = str;
    }

    @Override // d.a.o0.t2.t
    public void k(boolean z) {
    }

    @Override // d.a.o0.t2.p
    public void onDestroy() {
        V v = this.k;
        if (v != 0 && ((FunAdNativeViewHolder) v).e() != null) {
            ((FunAdNativeViewHolder) this.k).e().b();
        }
        for (String str : this.o) {
            d.a.o0.s0.a.h().b(str);
        }
    }

    @Override // d.a.o0.t2.p
    public void onPause() {
        V v = this.k;
        if (v == 0 || ((FunAdNativeViewHolder) v).e() == null) {
            return;
        }
        ((FunAdNativeViewHolder) this.k).e().b();
    }

    @Override // d.a.o0.t2.p
    public void onResume() {
    }
}
