package d.a.k0.i2.j;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f extends d.a.k0.x.b<d.a.k0.i2.e.h> {
    public TbImageView m;
    public View n;
    public View o;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        View l = l();
        this.n = l;
        this.m = (TbImageView) l.findViewById(R.id.center_image);
        this.o = this.n.findViewById(R.id.more_view_container);
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.card_more_item;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f63160e == i2) {
            return;
        }
        this.f63160e = i2;
        SkinManager.setImageResource(this.m, R.drawable.icon_mine_more);
        SkinManager.setBackgroundResource(this.n, R.drawable.btn_look_more_selector);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: s */
    public void m(d.a.k0.i2.e.h hVar) {
        if (hVar == null) {
            this.n.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
        if (layoutParams != null) {
            if (layoutParams.width > 0) {
                layoutParams.width = hVar.f56231e;
            }
            if (layoutParams.height > 0) {
                layoutParams.height = hVar.f56232f;
            }
        }
        this.o.setLayoutParams(layoutParams);
        this.n.setVisibility(0);
        n(this.f63161f, TbadkCoreApplication.getInst().getSkinType());
    }
}
