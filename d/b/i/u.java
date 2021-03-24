package d.b.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.i.u0.a;
/* loaded from: classes2.dex */
public class u extends c implements q, p<a2> {
    public final RelativeLayout i;
    public final LinearLayout j;
    public View k;
    public View l;
    public View m;
    public ImageView n;
    public TextView o;
    public a2 p;
    public boolean q = false;
    public boolean r = true;
    public CustomMessageListener s = new a(2921402);

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof a2) || ((a2) customResponsedMessage.getData()) != u.this.p) {
                return;
            }
            u.this.r();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (u.this.n == null || u.this.p == null || u.this.o == null || u.this.p.w2() || !u.this.r) {
                return;
            }
            if (u.this.p.i2() || !d.b.i0.p0.b.e().g()) {
                if (u.this.p.j2() || !d.b.i0.p0.a.h().j()) {
                    d.b.i0.p0.b.e().j(u.this.p);
                    u.this.p.S3(false);
                    d.b.i0.p0.a.h().l(u.this.p);
                    u.this.p.T3(false);
                } else if (d.b.i0.p0.a.h().a(u.this.p)) {
                    u.this.p.T3(true);
                }
            } else if (d.b.i0.p0.b.e().a(u.this.p)) {
                u.this.p.S3(true);
            }
            u.this.r();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921402, u.this.p));
        }
    }

    public u(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.multi_del_decor_layout, (ViewGroup) null);
        this.k = inflate;
        this.l = inflate.findViewById(R.id.multi_del_mask_top_view);
        this.j = (LinearLayout) this.k.findViewById(R.id.multi_del_bottom_layout);
        this.l.setAlpha(0.5f);
        View findViewById = this.k.findViewById(R.id.multi_del_mask_bottom_view);
        this.m = findViewById;
        findViewById.setAlpha(0.5f);
        this.n = (ImageView) this.k.findViewById(R.id.manage_select_img);
        this.i = (RelativeLayout) this.k.findViewById(R.id.multi_del_bottom_root);
        this.o = (TextView) this.k.findViewById(R.id.manage_select_txt);
        g(this.k);
        this.k.setFocusable(true);
        this.k.setOnClickListener(new b());
        h(-1);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).registerListener(this.s);
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).registerListener(this.s);
        }
    }

    @Override // d.b.i.c
    public void e() {
    }

    @Override // d.b.i.c
    public void f() {
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (!this.p.i2() && !this.p.j2()) {
            WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
        } else {
            WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
        }
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.l);
        a2.h(R.string.J_X06);
        a2.g(this.q ? 2 : 1);
        a2.c(R.color.CAM_X0201);
        d.b.h0.r.u.c a3 = d.b.h0.r.u.c.a(this.m);
        a3.h(R.string.J_X06);
        a3.g(2);
        a3.c(R.color.CAM_X0201);
        d.b.h0.r.u.c.a(this.o).s(R.string.F_X01);
        SkinManager.setViewTextColor(this.o, (this.p.i2() || this.p.j2()) ? R.color.CAM_X0302 : R.drawable.selector_comment_and_prise_item_text_color);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: p */
    public void a(a2 a2Var) {
        this.p = a2Var;
        this.r = a2Var.getType() != a2.x3 && (a2Var == null || a2Var.T() == null || !a2Var.T().isForumBusinessAccount() || a2Var.s());
        if (!d.b.i0.p0.b.e().g() && !d.b.i0.p0.a.h().j()) {
            this.f51770h.o(new a.C1117a(4, Boolean.TRUE));
            this.k.setVisibility(8);
            return;
        }
        this.k.setVisibility(0);
        this.f51770h.o(new a.C1117a(4, Boolean.FALSE));
        r();
    }

    public void q(boolean z) {
        this.q = z;
    }

    public final void r() {
        a2 a2Var = this.p;
        if (a2Var == null) {
            return;
        }
        int i = 4;
        this.l.setVisibility((a2Var.i2() || this.p.j2() || !this.r) ? 0 : 4);
        this.m.setVisibility((this.p.i2() || this.p.j2()) ? 0 : 0);
        if (this.q) {
            this.i.setVisibility(0);
            if (this.r) {
                this.n.setVisibility(0);
                this.o.setVisibility(0);
                if (!this.p.i2() && !this.p.j2()) {
                    WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
                } else {
                    WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
                }
                SkinManager.setViewTextColor(this.o, (this.p.i2() || this.p.j2()) ? R.color.CAM_X0304 : R.drawable.selector_comment_and_prise_item_text_color);
                return;
            }
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            return;
        }
        this.i.setVisibility(8);
        this.n.setVisibility(8);
        this.o.setVisibility(8);
    }

    public void s(BdUniqueId bdUniqueId) {
    }

    public void t(int i, l0 l0Var) {
        this.j.setWeightSum(i);
        if (this.j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.j.getLayoutParams()).setMargins(l0Var.f51800f, l0Var.f51798d, l0Var.f51801g, l0Var.f51799e);
        }
    }
}
