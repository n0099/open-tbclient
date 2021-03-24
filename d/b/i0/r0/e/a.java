package d.b.i0.r0.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.funad.adapter.FunAdEmptyHolder;
import d.b.i0.r2.l;
import d.b.i0.r2.p;
/* loaded from: classes4.dex */
public class a extends d.b.b.j.e.a<d.b.h0.r.q.a, FunAdEmptyHolder> implements p, l {
    public BaseFragmentActivity m;

    public a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.m = baseFragmentActivity;
    }

    @Override // d.b.i0.r2.p
    public void c(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public FunAdEmptyHolder R(ViewGroup viewGroup) {
        View view = new View(this.m.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new FunAdEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.h0.r.q.a aVar, FunAdEmptyHolder funAdEmptyHolder) {
        return funAdEmptyHolder.a();
    }

    @Override // d.b.i0.r2.l
    public void onDestroy() {
    }

    @Override // d.b.i0.r2.l
    public void onPause() {
    }

    @Override // d.b.i0.r2.l
    public void onResume() {
    }
}
