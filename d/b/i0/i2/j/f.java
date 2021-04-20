package d.b.i0.i2.j;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class f extends d.b.i0.x.b<d.b.i0.i2.e.h> {
    public TbImageView m;
    public View n;
    public View o;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        View m = m();
        this.n = m;
        this.m = (TbImageView) m.findViewById(R.id.center_image);
        this.o = this.n.findViewById(R.id.more_view_container);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_more_item;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f63755e == i) {
            return;
        }
        this.f63755e = i;
        SkinManager.setImageResource(this.m, R.drawable.icon_mine_more);
        SkinManager.setBackgroundResource(this.n, R.drawable.btn_look_more_selector);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.i2.e.h hVar) {
        if (hVar == null) {
            this.n.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width > 0) {
                layoutParams.width = hVar.f57150e;
            }
            if (layoutParams.height > 0) {
                layoutParams.height = hVar.f57151f;
            }
        }
        this.o.setLayoutParams(layoutParams);
        this.n.setVisibility(0);
        o(this.f63756f, TbadkCoreApplication.getInst().getSkinType());
    }
}
