package d.a.j0.s0.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.funad.adapter.FunAdEmptyHolder;
import d.a.j0.s2.o;
import d.a.j0.s2.s;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d.a.i0.r.q.a, FunAdEmptyHolder> implements s, o {
    public BaseFragmentActivity m;

    public a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.m = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public FunAdEmptyHolder P(ViewGroup viewGroup) {
        View view = new View(this.m.getPageContext().getPageActivity());
        view.setVisibility(8);
        return new FunAdEmptyHolder(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.i0.r.q.a aVar, FunAdEmptyHolder funAdEmptyHolder) {
        return funAdEmptyHolder.a();
    }

    @Override // d.a.j0.s2.s
    public void j(boolean z) {
    }

    @Override // d.a.j0.s2.o
    public void onDestroy() {
    }

    @Override // d.a.j0.s2.o
    public void onPause() {
    }

    @Override // d.a.j0.s2.o
    public void onResume() {
    }
}
