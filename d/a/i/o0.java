package d.a.i;

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

    @Override // d.a.i.a
    public View g() {
        if (this.l == null) {
            FrameLayout frameLayout = new FrameLayout(this.f47690f);
            this.l = frameLayout;
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0206);
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.l.removeAllViews();
        if (this.m == null) {
            ItemCardView itemCardView = new ItemCardView(this.f47690f);
            this.m = itemCardView;
            itemCardView.setBackGroundColor(R.color.CAM_X0205);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f47690f.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.rightMargin = this.f47690f.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams.bottomMargin = this.f47690f.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        this.l.addView(this.m, layoutParams);
        return this.l;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
        ItemCardView itemCardView = this.m;
        if (itemCardView != null) {
            itemCardView.b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: s */
    public void a(d.a.i0.r.q.a aVar) {
        if (aVar != null && aVar.m() != null && aVar.m().r1 != null && aVar.m().r1.z != null) {
            if (aVar.m().r1.m) {
                this.l.setVisibility(8);
                return;
            }
            this.l.setVisibility(0);
            this.m.setData(aVar.m().r1.z, 13);
            return;
        }
        this.l.setVisibility(8);
    }
}
