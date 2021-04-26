package d.a.j0.i2.j;

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
/* loaded from: classes4.dex */
public class o extends d.a.j0.x.b<d.a.j0.i2.e.l> {
    public View m;
    public TbImageView n;
    public TextView o;
    public ImageView p;
    public d.a.j0.i2.e.l q;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View l = l();
        this.m = l;
        this.n = (TbImageView) l.findViewById(R.id.polymeric_vedio_pic);
        this.o = (TextView) this.m.findViewById(R.id.polymeric_vedio_des);
        this.p = (ImageView) this.m.findViewById(R.id.polymeric_vedio_play_icon);
        this.m.setOnClickListener(this);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.person_polymeric_vedio_item_layout;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f62436e == i2) {
            return;
        }
        this.f62436e = i2;
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setImageResource(this.p, R.drawable.icon_play_video, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m == view) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f62438g);
            d.a.j0.i2.e.l lVar = this.q;
            messageManager.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(lVar.f55539g, lVar.f55540h, "person_page")));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(d.a.j0.i2.e.l lVar) {
        if (lVar == null) {
            return;
        }
        this.q = lVar;
        this.n.V(lVar.f55537e, 10, false);
        this.o.setText(lVar.f55538f);
        n(this.f62437f, TbadkCoreApplication.getInst().getSkinType());
    }
}
