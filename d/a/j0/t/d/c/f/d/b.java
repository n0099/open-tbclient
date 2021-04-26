package d.a.j0.t.d.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends d.a.j0.x.b<d.a.j0.t.d.f.c.e> {
    public TextView m;
    public ImageView n;
    public View o;
    public View p;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.o = l();
        this.m = (TextView) l().findViewById(R.id.tv_empty);
        this.n = (ImageView) l().findViewById(R.id.iv_empty);
        this.p = l().findViewById(R.id.id_tab_live_sub_empty_divider);
        n(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.tab_sub_concern_empty;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundResource(this.o, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
        SkinManager.setImageResource(this.n, R.drawable.new_pic_emotion_08);
        SkinManager.setBackgroundResource(this.p, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(d.a.j0.t.d.f.c.e eVar) {
        if (eVar.f60712e == 1) {
            this.m.setText(this.f62437f.getResources().getString(R.string.live_sub_tab_no_attention_txt));
            SkinManager.setImageResource(this.n, R.drawable.new_pic_emotion_07);
            return;
        }
        this.m.setText(this.f62437f.getResources().getString(R.string.live_sub_tab_empty_txt));
        SkinManager.setImageResource(this.n, R.drawable.new_pic_emotion_06);
    }
}
