package d.b.i0.r0.e;

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
import d.b.i0.c3.h0.n;
import d.b.i0.r2.l;
import d.b.i0.r2.p;
/* loaded from: classes4.dex */
public class b extends d.b.b.j.e.a<d.b.h0.r.q.a, FunAdNativeViewHolder> implements p, l {
    public final BaseFragmentActivity m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f59725e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FunAdNativeViewHolder f59726f;

        public a(n nVar, FunAdNativeViewHolder funAdNativeViewHolder) {
            this.f59725e = nVar;
            this.f59726f = funAdNativeViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f59725e.j(true);
            b.this.L();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.f59726f.f().getPageType()).param("obj_locate", 0));
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.m = baseFragmentActivity;
    }

    @Override // d.b.i0.r2.p
    public void c(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public FunAdNativeViewHolder R(ViewGroup viewGroup) {
        return new FunAdNativeViewHolder(this.f42361h == AdvertAppInfo.n4 ? new FunAdNativeFrsView(this.m) : new FunAdNativePbView(this.m), this.m, this.f42361h);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.h0.r.q.a aVar, FunAdNativeViewHolder funAdNativeViewHolder) {
        n nVar;
        if (aVar instanceof z1) {
            nVar = ((z1) aVar).w.C2;
        } else {
            nVar = aVar instanceof a2 ? ((a2) aVar).C2 : null;
        }
        if (nVar == null) {
            return funAdNativeViewHolder.a();
        }
        if (this.f42361h == AdvertAppInfo.n4) {
            if (!d.b.i0.q0.a.h().p(this.m)) {
                funAdNativeViewHolder.f().d(8);
                return funAdNativeViewHolder.a();
            }
            funAdNativeViewHolder.f().d(0);
        }
        funAdNativeViewHolder.g(new a(nVar, funAdNativeViewHolder));
        funAdNativeViewHolder.f().h();
        funAdNativeViewHolder.h(nVar);
        return funAdNativeViewHolder.a();
    }

    @Override // d.b.i0.r2.l
    public void onDestroy() {
        V v = this.k;
        if (v != 0 && ((FunAdNativeViewHolder) v).f() != null) {
            ((FunAdNativeViewHolder) this.k).f().b();
        }
        d.b.i0.q0.a.h().b(this.f42361h == AdvertAppInfo.n4 ? "6051001773-1862514716" : "6051001775-457565154");
    }

    @Override // d.b.i0.r2.l
    public void onPause() {
        V v = this.k;
        if (v == 0 || ((FunAdNativeViewHolder) v).f() == null) {
            return;
        }
        ((FunAdNativeViewHolder) this.k).f().b();
    }

    @Override // d.b.i0.r2.l
    public void onResume() {
    }
}
