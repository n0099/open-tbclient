package d.a.k0.i2.j;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class o extends d.a.k0.x.b<d.a.k0.i2.e.l> {
    public View m;
    public TbImageView n;
    public TextView o;
    public ImageView p;
    public d.a.k0.i2.e.l q;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View l = l();
        this.m = l;
        this.n = (TbImageView) l.findViewById(R.id.polymeric_vedio_pic);
        this.o = (TextView) this.m.findViewById(R.id.polymeric_vedio_des);
        this.p = (ImageView) this.m.findViewById(R.id.polymeric_vedio_play_icon);
        this.m.setOnClickListener(this);
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.person_polymeric_vedio_item_layout;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f63160e == i2) {
            return;
        }
        this.f63160e = i2;
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setImageResource(this.p, R.drawable.icon_play_video, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m == view) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f63162g);
            d.a.k0.i2.e.l lVar = this.q;
            messageManager.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(lVar.f56246g, lVar.f56247h, "person_page")));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: s */
    public void m(d.a.k0.i2.e.l lVar) {
        if (lVar == null) {
            return;
        }
        this.q = lVar;
        this.n.V(lVar.f56244e, 10, false);
        this.o.setText(lVar.f56245f);
        n(this.f63161f, TbadkCoreApplication.getInst().getSkinType());
    }
}
