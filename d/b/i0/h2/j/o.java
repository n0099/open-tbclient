package d.b.i0.h2.j;

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
public class o extends d.b.i0.x.b<d.b.i0.h2.e.l> {
    public View m;
    public TbImageView n;
    public TextView o;
    public ImageView p;
    public d.b.i0.h2.e.l q;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View m = m();
        this.m = m;
        this.n = (TbImageView) m.findViewById(R.id.polymeric_vedio_pic);
        this.o = (TextView) this.m.findViewById(R.id.polymeric_vedio_des);
        this.p = (ImageView) this.m.findViewById(R.id.polymeric_vedio_play_icon);
        this.m.setOnClickListener(this);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.person_polymeric_vedio_item_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f62180e == i) {
            return;
        }
        this.f62180e = i;
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setImageResource(this.p, R.drawable.icon_play_video, i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m == view) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f62182g);
            d.b.i0.h2.e.l lVar = this.q;
            messageManager.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(lVar.f55305g, lVar.f55306h, "person_page")));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.h2.e.l lVar) {
        if (lVar == null) {
            return;
        }
        this.q = lVar;
        this.n.W(lVar.f55303e, 10, false);
        this.o.setText(lVar.f55304f);
        o(this.f62181f, TbadkCoreApplication.getInst().getSkinType());
    }
}
