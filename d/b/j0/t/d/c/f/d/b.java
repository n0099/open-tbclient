package d.b.j0.t.d.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends d.b.j0.x.b<d.b.j0.t.d.f.c.e> {
    public TextView m;
    public ImageView n;
    public View o;
    public View p;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = m();
        this.m = (TextView) m().findViewById(R.id.tv_empty);
        this.n = (ImageView) m().findViewById(R.id.iv_empty);
        this.p = m().findViewById(R.id.id_tab_live_sub_empty_divider);
        o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.tab_sub_concern_empty;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setBackgroundResource(this.o, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
        SkinManager.setImageResource(this.n, R.drawable.new_pic_emotion_08);
        SkinManager.setBackgroundResource(this.p, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: u */
    public void n(d.b.j0.t.d.f.c.e eVar) {
        if (eVar.f62524e == 1) {
            this.m.setText(this.f64177f.getResources().getString(R.string.live_sub_tab_no_attention_txt));
            SkinManager.setImageResource(this.n, R.drawable.new_pic_emotion_07);
            return;
        }
        this.m.setText(this.f64177f.getResources().getString(R.string.live_sub_tab_empty_txt));
        SkinManager.setImageResource(this.n, R.drawable.new_pic_emotion_06);
    }
}
