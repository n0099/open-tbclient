package d.b.i;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i.a;
/* loaded from: classes.dex */
public class n0 extends h {
    public LinearLayout l;
    public BjhArticleLayout m;
    public d.b.i0.r.q.a n;
    public int o;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n0 n0Var = n0.this;
            a.InterfaceC1070a interfaceC1070a = n0Var.i;
            if (interfaceC1070a != null) {
                interfaceC1070a.a(n0Var.n);
            }
        }
    }

    public n0(Context context) {
        super(context);
        this.o = 3;
    }

    @Override // d.b.i.a
    public View g() {
        if (this.l == null) {
            LinearLayout linearLayout = new LinearLayout(this.f50155f);
            this.l = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.l.setOrientation(1);
            this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.l.removeAllViews();
        if (this.m == null) {
            BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(this.f50155f);
            this.m = bjhArticleLayout;
            bjhArticleLayout.setJumpToPbListener(new a());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.f50155f.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        layoutParams.leftMargin = this.f50155f.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f50155f.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
        layoutParams.bottomMargin = this.f50155f.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        this.l.addView(this.m, layoutParams);
        return this.l;
    }

    @Override // d.b.i.a
    public void l(d.b.j0.x.b0<d.b.i0.r.q.a> b0Var) {
        super.l(b0Var);
        BjhArticleLayout bjhArticleLayout = this.m;
        if (bjhArticleLayout != null) {
            bjhArticleLayout.setSubClickListener(b0Var);
        }
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.o) {
            this.o = i;
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
            BjhArticleLayout bjhArticleLayout = this.m;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: t */
    public void a(d.b.i0.r.q.a aVar) {
        this.n = aVar;
        BjhArticleLayout bjhArticleLayout = this.m;
        if (bjhArticleLayout != null) {
            bjhArticleLayout.a(aVar);
        }
    }

    public void u(a.InterfaceC1070a interfaceC1070a) {
        this.i = interfaceC1070a;
    }
}
