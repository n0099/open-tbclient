package d.a.i;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g0 extends h {
    public SingleLinkCardView l;

    public g0(Context context) {
        super(context);
        this.l = new SingleLinkCardView(context);
        r(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // d.a.i.a
    public View g() {
        return this.l;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.l.b();
    }

    public final boolean s(d.a.i0.r.q.a aVar) {
        return (aVar == null || aVar.m() == null || !aVar.m().z2() || aVar.m().u1() == null) ? false : true;
    }

    public final boolean t(d.a.i0.r.q.a aVar) {
        return (aVar == null || aVar.m() == null || aVar.m().O0() == null || aVar.m().O0().getOptions() == null || aVar.m().O0().getOptions().size() <= 0) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: u */
    public void a(d.a.i0.r.q.a aVar) {
        if (!t(aVar) && aVar != null && aVar.m() != null && !s(aVar) && ((!ListUtils.isEmpty(aVar.m().G0()) || ListUtils.getCount(aVar.m().l0()) == 1) && ((!ListUtils.isEmpty(aVar.m().l0()) || ListUtils.getCount(aVar.m().G0()) == 1) && ListUtils.getCount(aVar.m().G0()) + ListUtils.getCount(aVar.m().l0()) == 1))) {
            if (aVar.m().G0().size() >= 1) {
                this.l.a((d.a.j0.x.e0.c) ListUtils.getItem(aVar.m().G0(), 0));
            } else if (aVar.m().l0().size() >= 1) {
                this.l.a((d.a.j0.x.e0.c) ListUtils.getItem(aVar.m().l0(), 0));
            }
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
    }
}
