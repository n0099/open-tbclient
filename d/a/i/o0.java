package d.a.i;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i.a;
/* loaded from: classes.dex */
public class o0 extends h {
    public LinearLayout l;
    public BjhArticleLayout m;
    public d.a.m0.r.q.a n;
    public int o;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o0 o0Var = o0.this;
            a.InterfaceC0598a interfaceC0598a = o0Var.f43692i;
            if (interfaceC0598a != null) {
                interfaceC0598a.a(o0Var.n);
            }
        }
    }

    public o0(Context context) {
        super(context);
        this.o = 3;
    }

    @Override // d.a.i.a
    public View g() {
        if (this.l == null) {
            LinearLayout linearLayout = new LinearLayout(this.f43689f);
            this.l = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.l.setOrientation(1);
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.l.removeAllViews();
        if (this.m == null) {
            BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(this.f43689f);
            this.m = bjhArticleLayout;
            bjhArticleLayout.setJumpToPbListener(new a());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.f43689f.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f43689f.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f43689f.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.f43689f.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        this.l.addView(this.m, layoutParams);
        return this.l;
    }

    @Override // d.a.i.a
    public void l(d.a.n0.z.b0<d.a.m0.r.q.a> b0Var) {
        super.l(b0Var);
        BjhArticleLayout bjhArticleLayout = this.m;
        if (bjhArticleLayout != null) {
            bjhArticleLayout.setSubClickListener(b0Var);
        }
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (i2 != this.o) {
            this.o = i2;
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
            BjhArticleLayout bjhArticleLayout = this.m;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: t */
    public void a(d.a.m0.r.q.a aVar) {
        this.n = aVar;
        BjhArticleLayout bjhArticleLayout = this.m;
        if (bjhArticleLayout != null) {
            bjhArticleLayout.a(aVar);
        }
    }

    public void u(a.InterfaceC0598a interfaceC0598a) {
        this.f43692i = interfaceC0598a;
    }
}
