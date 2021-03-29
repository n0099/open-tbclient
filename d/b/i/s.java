package d.b.i;

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
    public static final int m = d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003);
    public ItemCardView l;

    public s(Context context) {
        super(context);
        this.l = new ItemCardView(context);
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

    public void s() {
        r(m);
        q(0);
        u(this.l, m, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: t */
    public void a(d.b.h0.r.q.a aVar) {
        if (aVar != null && aVar.n() != null && aVar.n().y0() != null) {
            this.l.setVisibility(0);
            this.l.setData(aVar.n().y0(), 13);
            return;
        }
        this.l.setVisibility(8);
    }

    public final void u(View view, int i, int i2) {
        if (view == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.topMargin == i && marginLayoutParams.bottomMargin == i2) {
            return;
        }
        marginLayoutParams.topMargin = i;
        marginLayoutParams.bottomMargin = i2;
        view.setLayoutParams(marginLayoutParams);
    }
}
