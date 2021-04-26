package d.a.j0.i2.j;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g extends d.a.j0.x.b<d.a.j0.i2.e.i> {
    public View m;
    public ImageView n;
    public TextView o;
    public String p;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        s(l());
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_null_polymeric_view;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f62436e != i2) {
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
            SkinManager.setImageResource(this.n, R.drawable.new_pic_emotion_07);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0108, 1);
        }
        this.f62436e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void s(View view) {
        this.m = view.findViewById(R.id.card_null_polymeric_rootview);
        this.n = (ImageView) view.findViewById(R.id.card_null_polymeric_icon);
        this.o = (TextView) view.findViewById(R.id.card_null_polymeric_txt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: t */
    public void m(d.a.j0.i2.e.i iVar) {
        String string;
        if (iVar == null) {
            this.m.setVisibility(8);
            return;
        }
        if (this.m.getVisibility() != 0) {
            this.m.setVisibility(0);
        }
        if (StringUtils.isNull(this.p)) {
            TextView textView = this.o;
            String string2 = this.f62438g.getString(R.string.person_polymeric_null_data);
            Object[] objArr = new Object[1];
            if (iVar.f55527e) {
                string = this.f62438g.getString(R.string.you);
            } else if (iVar.f55528f == 2) {
                string = this.f62438g.getString(R.string.she);
            } else {
                string = this.f62438g.getString(R.string.he);
            }
            objArr[0] = string;
            textView.setText(String.format(string2, objArr));
            return;
        }
        this.o.setText(this.p);
    }
}
