package d.a.i;

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

    @Override // d.a.i.a
    public View g() {
        return this.l;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.l.b();
    }

    public final boolean s(d.a.j0.r.q.a aVar) {
        return (aVar == null || aVar.m() == null || !aVar.m().B2() || aVar.m().v1() == null) ? false : true;
    }

    public final boolean t(d.a.j0.r.q.a aVar) {
        return (aVar == null || aVar.m() == null || aVar.m().O0() == null || aVar.m().O0().getOptions() == null || aVar.m().O0().getOptions().size() <= 0) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: u */
    public void a(d.a.j0.r.q.a aVar) {
        if (!t(aVar) && !s(aVar) && aVar != null && aVar.m() != null && ((!ListUtils.isEmpty(aVar.m().G0()) || ListUtils.getCount(aVar.m().l0()) > 1) && ((!ListUtils.isEmpty(aVar.m().l0()) || ListUtils.getCount(aVar.m().G0()) > 1) && ListUtils.getCount(aVar.m().G0()) + ListUtils.getCount(aVar.m().l0()) > 1))) {
            this.l.a(aVar.m().G0(), aVar.m().l0());
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
    }
}
