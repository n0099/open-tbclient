package d.b.i;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class o0 extends h {
    public FrameLayout l;
    public ItemCardView m;

    public o0(Context context) {
        super(context);
        n(Boolean.TRUE);
    }

    @Override // d.b.i.a
    public View g() {
        if (this.l == null) {
            FrameLayout frameLayout = new FrameLayout(this.f51763f);
            this.l = frameLayout;
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0206);
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.l.removeAllViews();
        if (this.m == null) {
            ItemCardView itemCardView = new ItemCardView(this.f51763f);
            this.m = itemCardView;
            itemCardView.setBackGroundColor(R.color.CAM_X0205);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f51763f.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.rightMargin = this.f51763f.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.bottomMargin = this.f51763f.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        this.l.addView(this.m, layoutParams);
        return this.l;
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
        ItemCardView itemCardView = this.m;
        if (itemCardView != null) {
            itemCardView.b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: s */
    public void a(d.b.h0.r.q.a aVar) {
        if (aVar != null && aVar.n() != null && aVar.n().r1 != null && aVar.n().r1.z != null) {
            if (aVar.n().r1.m) {
                this.l.setVisibility(8);
                return;
            }
            this.l.setVisibility(0);
            this.m.setData(aVar.n().r1.z, 13);
            return;
        }
        this.l.setVisibility(8);
    }
}
