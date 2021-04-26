package d.a.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class s extends h {
    public static final int m = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003);
    public ItemCardView l;

    public s(Context context) {
        super(context);
        this.l = new ItemCardView(context);
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

    public void s() {
        r(m);
        q(0);
        u(this.l, m, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: t */
    public void a(d.a.i0.r.q.a aVar) {
        if (aVar != null && aVar.m() != null && aVar.m().y0() != null) {
            this.l.setVisibility(0);
            this.l.setData(aVar.m().y0(), 13);
            return;
        }
        this.l.setVisibility(8);
    }

    public final void u(View view, int i2, int i3) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.topMargin == i2 && marginLayoutParams.bottomMargin == i3) {
            return;
        }
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.bottomMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }
}
