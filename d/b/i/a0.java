package d.b.i;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a0 extends h {
    public MultiLinkCardView l;

    public a0(Context context) {
        super(context);
        this.l = new MultiLinkCardView(context);
        r(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // d.b.i.a
    public View g() {
        return this.l;
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.l.b();
    }

    public final boolean s(d.b.h0.r.q.a aVar) {
        return (aVar == null || aVar.n() == null || !aVar.n().z2() || aVar.n().u1() == null) ? false : true;
    }

    public final boolean t(d.b.h0.r.q.a aVar) {
        return (aVar == null || aVar.n() == null || aVar.n().O0() == null || aVar.n().O0().getOptions() == null || aVar.n().O0().getOptions().size() <= 0) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: u */
    public void a(d.b.h0.r.q.a aVar) {
        if (!t(aVar) && !s(aVar) && aVar != null && aVar.n() != null && ((!ListUtils.isEmpty(aVar.n().G0()) || ListUtils.getCount(aVar.n().l0()) > 1) && ((!ListUtils.isEmpty(aVar.n().l0()) || ListUtils.getCount(aVar.n().G0()) > 1) && ListUtils.getCount(aVar.n().G0()) + ListUtils.getCount(aVar.n().l0()) > 1))) {
            this.l.a(aVar.n().G0(), aVar.n().l0());
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
    }
}
