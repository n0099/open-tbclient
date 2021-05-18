package d.a.k0.i2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class n extends d.a.k0.x.b<d.a.k0.i2.e.o> {
    public TbPageContext m;
    public View n;
    public TbImageView o;
    public TextView p;

    public n(TbPageContext tbPageContext) {
        super(tbPageContext);
        View l = l();
        this.n = l;
        this.m = tbPageContext;
        l.setTag(this);
        this.o = (TbImageView) this.n.findViewById(R.id.gift_pic);
        this.p = (TextView) this.n.findViewById(R.id.gift_num_text);
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.item_gift_view;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.o, R.drawable.item_gift_selector);
        SkinManager.setBackgroundColor(this.p, R.color.common_color_10294);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: s */
    public void m(d.a.k0.i2.e.o oVar) {
        if (oVar == null) {
            this.n.setVisibility(8);
            return;
        }
        n(this.m, TbadkCoreApplication.getInst().getSkinType());
        this.o.V(oVar.f56254e, 10, false);
        this.n.setOnClickListener(this);
        if (oVar.f56255f > 0) {
            this.p.setVisibility(0);
            long j = oVar.f56255f;
            if (j > 99) {
                this.p.setText("99");
                return;
            } else {
                this.p.setText(String.valueOf(j));
                return;
            }
        }
        this.p.setVisibility(8);
    }
}
