package d.a.n0.v.i.e;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.n0.z.z;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends d.a.n0.z.b<a2> implements z {
    public TbPageContext<?> m;
    public RelativeLayout n;
    public a2 o;
    public View p;
    public View q;
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public RelativeLayout v;
    public final View.OnClickListener w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.o == null || b.this.i() == null) {
                return;
            }
            b.this.i().a(view, b.this.o);
            TiebaStatic.log(new StatisticItem("c11844").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", b.this.o.c0()));
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.w = new a();
        this.m = tbPageContext;
        View m = m();
        this.p = m.findViewById(R.id.divider);
        this.q = m.findViewById(R.id.recommend_left_line);
        this.r = m.findViewById(R.id.recommend_right_line);
        this.n = (RelativeLayout) m.findViewById(R.id.ala_live_empty_layout_root);
        this.s = (TextView) m.findViewById(R.id.ala_live_title);
        this.t = (TextView) m.findViewById(R.id.start_live_btn);
        this.v = (RelativeLayout) m.findViewById(R.id.ala_bottom_container);
        this.u = (TextView) m.findViewById(R.id.ala_recommend_live);
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.frs_ala_video_empty_layout;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.f67158e != i2) {
            SkinManager.setBackgroundResource(this.t, R.drawable.ala_live_card_start_live_selector);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
            this.f67158e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.a.n0.z.z
    public void r(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: u */
    public void n(a2 a2Var) {
        this.o = a2Var;
        v();
    }

    public final void v() {
        if (!this.o.d1) {
            this.u.setVisibility(8);
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.height = l.i(this.m.getPageActivity()) / 4;
            this.v.setLayoutParams(layoutParams);
        } else {
            this.u.setVisibility(0);
            this.q.setVisibility(0);
            this.r.setVisibility(0);
            ViewGroup.LayoutParams layoutParams2 = this.v.getLayoutParams();
            layoutParams2.height = this.m.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds30);
            this.v.setLayoutParams(layoutParams2);
        }
        o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public void w(BdUniqueId bdUniqueId) {
        this.t.setOnClickListener(this.w);
    }
}
