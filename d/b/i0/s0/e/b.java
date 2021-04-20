package d.b.i0.s0.e;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import d.b.i0.d3.h0.n;
import d.b.i0.r0.d.c;
import d.b.i0.s2.o;
import d.b.i0.s2.s;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class b extends d.b.c.j.e.a<d.b.h0.r.q.a, FunAdNativeViewHolder> implements s, o {
    public final BaseFragmentActivity m;
    public String n;
    public Set<String> o;
    public String p;
    public String q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f61466e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f61467f;

        public a(n nVar, FunAdNativeViewHolder funAdNativeViewHolder) {
            this.f61466e = nVar;
            this.f61467f = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f61466e.m(true);
            b.this.L();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f61467f.e().getPageType()).param("obj_locate", 0));
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.o = new HashSet();
        this.m = baseFragmentActivity;
    }

    @Override // d.b.i0.s2.s
    public void c(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public FunAdNativeViewHolder R(ViewGroup viewGroup) {
        FunAdNativeViewHolder funAdNativeViewHolder = new FunAdNativeViewHolder(this.f42858h == AdvertAppInfo.n4 ? new FunAdNativeFrsView(this.m) : new FunAdNativePbView(this.m), this.m, this.f42858h);
        funAdNativeViewHolder.j(this.n);
        funAdNativeViewHolder.i(this.q);
        return funAdNativeViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
        if (d.b.h0.b.d.m() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
        r1 = "0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006f, code lost:
        if (d.b.h0.b.d.C() != false) goto L18;
     */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View X(int i, View view, ViewGroup viewGroup, d.b.h0.r.q.a aVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        n nVar;
        long j;
        if (aVar instanceof z1) {
            a2 a2Var = ((z1) aVar).w;
            nVar = a2Var.C2;
            j = a2Var.c0();
        } else if (aVar instanceof a2) {
            a2 a2Var2 = (a2) aVar;
            nVar = a2Var2.C2;
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
        if (this.f42858h == AdvertAppInfo.n4) {
            String str = "1";
            String str2 = "0";
            if (!"frs".equals(this.p)) {
                if ("personalize".equals(this.p)) {
                }
            }
            d.b.i0.r0.a.h().q(this.m, this.n, d.b.i0.r0.a.a(this.p, str2), String.valueOf(j));
        }
        funAdNativeViewHolder.g(new a(nVar, funAdNativeViewHolder));
        funAdNativeViewHolder.e().h();
        funAdNativeViewHolder.h(this.p);
        funAdNativeViewHolder.j(this.n);
        this.o.add(this.n);
        funAdNativeViewHolder.k(nVar);
        return funAdNativeViewHolder.a();
    }

    public void j0(String str) {
        this.p = str;
    }

    public void l0(String str) {
        this.q = str;
    }

    public void m0(String str) {
        this.n = str;
    }

    @Override // d.b.i0.s2.o
    public void onDestroy() {
        V v = this.k;
        if (v != 0 && ((FunAdNativeViewHolder) v).e() != null) {
            ((FunAdNativeViewHolder) this.k).e().b();
        }
        for (String str : this.o) {
            d.b.i0.r0.a.h().b(str);
        }
    }

    @Override // d.b.i0.s2.o
    public void onPause() {
        V v = this.k;
        if (v == 0 || ((FunAdNativeViewHolder) v).e() == null) {
            return;
        }
        ((FunAdNativeViewHolder) this.k).e().b();
    }

    @Override // d.b.i0.s2.o
    public void onResume() {
    }
}
