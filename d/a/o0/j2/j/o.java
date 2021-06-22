package d.a.o0.j2.j;

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
public class o extends d.a.o0.z.b<d.a.o0.j2.e.l> {
    public View m;
    public TbImageView n;
    public TextView o;
    public ImageView p;
    public d.a.o0.j2.e.l q;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View m = m();
        this.m = m;
        this.n = (TbImageView) m.findViewById(R.id.polymeric_vedio_pic);
        this.o = (TextView) this.m.findViewById(R.id.polymeric_vedio_des);
        this.p = (ImageView) this.m.findViewById(R.id.polymeric_vedio_play_icon);
        this.m.setOnClickListener(this);
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.person_polymeric_vedio_item_layout;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.f67283e == i2) {
            return;
        }
        this.f67283e = i2;
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setImageResource(this.p, R.drawable.icon_play_video, i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.m == view) {
            MessageManager messageManager = MessageManager.getInstance();
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f67285g);
            d.a.o0.j2.e.l lVar = this.q;
            messageManager.sendMessage(new CustomMessage(2004001, pbActivityConfig.createNormalCfg(lVar.f60244g, lVar.f60245h, "person_page")));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: t */
    public void n(d.a.o0.j2.e.l lVar) {
        if (lVar == null) {
            return;
        }
        this.q = lVar;
        this.n.U(lVar.f60242e, 10, false);
        this.o.setText(lVar.f60243f);
        o(this.f67284f, TbadkCoreApplication.getInst().getSkinType());
    }
}
