package d.a.j0.t.i.e;

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
import d.a.i0.r.q.a2;
import d.a.j0.x.z;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends d.a.j0.x.b<a2> implements z {
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
            if (b.this.o == null || b.this.h() == null) {
                return;
            }
            b.this.h().a(view, b.this.o);
            TiebaStatic.log(new StatisticItem("c11844").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", b.this.o.c0()));
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.w = new a();
        this.m = tbPageContext;
        View l = l();
        this.p = l.findViewById(R.id.divider);
        this.q = l.findViewById(R.id.recommend_left_line);
        this.r = l.findViewById(R.id.recommend_right_line);
        this.n = (RelativeLayout) l.findViewById(R.id.ala_live_empty_layout_root);
        this.s = (TextView) l.findViewById(R.id.ala_live_title);
        this.t = (TextView) l.findViewById(R.id.start_live_btn);
        this.v = (RelativeLayout) l.findViewById(R.id.ala_bottom_container);
        this.u = (TextView) l.findViewById(R.id.ala_recommend_live);
    }

    @Override // d.a.j0.x.z
    public void a(String str) {
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.frs_ala_video_empty_layout;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f62436e != i2) {
            SkinManager.setBackgroundResource(this.t, R.drawable.ala_live_card_start_live_selector);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
            this.f62436e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.a.j0.x.z
    public void q(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: t */
    public void m(a2 a2Var) {
        this.o = a2Var;
        u();
    }

    public final void u() {
        if (!this.o.b1) {
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
        n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public void v(BdUniqueId bdUniqueId) {
        this.t.setOnClickListener(this.w);
    }
}
