package d.a.j0.i2.j;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h extends d.a.j0.x.b<d.a.j0.i2.e.j> implements View.OnClickListener {
    public View m;
    public d.a.j0.i2.d.c n;
    public View o;
    public TextView p;
    public TextView q;
    public ImageView r;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        s(l());
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_privacy_setting_view;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f62436e != i2) {
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0109, 1);
            SkinManager.setImageResource(this.r, R.drawable.pic_pop_key);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0304, 1);
        }
        this.f62436e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.j0.i2.d.c cVar;
        if (view == null || (cVar = this.n) == null || view != this.p) {
            return;
        }
        cVar.a();
    }

    public final void s(View view) {
        this.m = view.findViewById(R.id.card_privacy_setting_rootview);
        this.o = view.findViewById(R.id.top_divider_line);
        this.r = (ImageView) view.findViewById(R.id.lock_img);
        this.p = (TextView) view.findViewById(R.id.one_public_tv);
        this.q = (TextView) view.findViewById(R.id.card_hint_txt);
        this.p.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: t */
    public void m(d.a.j0.i2.e.j jVar) {
        if (jVar == null) {
            this.m.setVisibility(8);
            return;
        }
        if (this.m.getVisibility() != 0) {
            this.m.setVisibility(0);
        }
        View view = this.o;
        if (view != null) {
            if (jVar.f55530e) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public void u(d.a.j0.i2.d.c cVar) {
        this.n = cVar;
    }
}
