package d.b.j0.s0.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.funad.adapter.FunAdEmptyHolder;
import d.b.j0.s2.o;
import d.b.j0.s2.s;
/* loaded from: classes4.dex */
public class a extends d.b.c.j.e.a<d.b.i0.r.q.a, FunAdEmptyHolder> implements s, o {
    public BaseFragmentActivity m;

    public a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.m = baseFragmentActivity;
    }

    @Override // d.b.j0.s2.s
    public void c(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public FunAdEmptyHolder R(ViewGroup viewGroup) {
        View view = new View(this.m.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new FunAdEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.r.q.a aVar, FunAdEmptyHolder funAdEmptyHolder) {
        return funAdEmptyHolder.a();
    }

    @Override // d.b.j0.s2.o
    public void onDestroy() {
    }

    @Override // d.b.j0.s2.o
    public void onPause() {
    }

    @Override // d.b.j0.s2.o
    public void onResume() {
    }
}
