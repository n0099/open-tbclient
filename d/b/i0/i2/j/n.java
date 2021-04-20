package d.b.i0.i2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class n extends d.b.i0.x.b<d.b.i0.i2.e.o> {
    public TbPageContext m;
    public View n;
    public TbImageView o;
    public TextView p;

    public n(TbPageContext tbPageContext) {
        super(tbPageContext);
        View m = m();
        this.n = m;
        this.m = tbPageContext;
        m.setTag(this);
        this.o = (TbImageView) this.n.findViewById(R.id.gift_pic);
        this.p = (TextView) this.n.findViewById(R.id.gift_num_text);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.item_gift_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.o, R.drawable.item_gift_selector);
        SkinManager.setBackgroundColor(this.p, R.color.common_color_10294);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.i2.e.o oVar) {
        if (oVar == null) {
            this.n.setVisibility(8);
            return;
        }
        o(this.m, TbadkCoreApplication.getInst().getSkinType());
        this.o.W(oVar.f57171e, 10, false);
        this.n.setOnClickListener(this);
        if (oVar.f57172f > 0) {
            this.p.setVisibility(0);
            long j = oVar.f57172f;
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
