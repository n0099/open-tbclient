package d.a.n0.e2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.g0;
import d.a.i.s0;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
import d.a.n0.z.b0;
/* loaded from: classes5.dex */
public class i extends d.a.n0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f56956f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.q.a f56957g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f56958h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f56959i;
    public a2 j;
    public VoteView k;

    /* loaded from: classes5.dex */
    public class a extends d.a.m0.r.q.a {
        public a() {
        }

        @Override // d.a.m0.r.q.a
        public v0 c() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.m0.r.q.a
        public a2 i() {
            return i.this.j;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = i.this;
            a.InterfaceC0598a interfaceC0598a = iVar.f56916c;
            if (interfaceC0598a != null) {
                interfaceC0598a.a(iVar.f56957g);
            }
        }
    }

    public i(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f56956f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f56914a.getPageActivity());
            this.f56956f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f56956f.setOrientation(1);
            this.f56956f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f56956f.removeAllViews();
        if (this.f56958h == null) {
            g0 g0Var = new g0(this.f56914a);
            this.f56958h = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f56956f.addView(this.f56958h.g(), layoutParams);
        if (this.f56959i == null) {
            s0 s0Var = new s0(this.f56914a.getPageActivity());
            this.f56959i = s0Var;
            s0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.f56956f.addView(this.f56959i.g(), layoutParams2);
        if (this.k == null) {
            this.k = new VoteView(this.f56914a.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f56956f.addView(this.k, layoutParams3);
        return this.f56956f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f56918e != i2) {
            this.f56918e = i2;
            SkinManager.setBackgroundColor(this.f56956f, R.color.CAM_X0206);
            g0 g0Var = this.f56958h;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            s0 s0Var = this.f56959i;
            if (s0Var != null) {
                s0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f56917d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f56957g = aVar;
        s0 s0Var = this.f56959i;
        if (s0Var != null) {
            s0Var.a(aVar);
        }
        g0 g0Var = this.f56958h;
        if (g0Var != null) {
            g0Var.a(this.f56957g);
        }
        PollData pollData = this.f56917d.D;
        if (pollData != null && pollData.getOptions() != null && this.f56917d.D.getOptions().size() > 0) {
            this.k.setIsTransmit(true);
            VoteView voteView = this.k;
            OriginalThreadInfo originalThreadInfo2 = this.f56917d;
            voteView.setData(originalThreadInfo2.D, originalThreadInfo2.f12100f, originalThreadInfo2.f12099e);
            this.k.setVisibility(0);
            return;
        }
        this.f56956f.removeView(this.k);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0598a interfaceC0598a) {
        super.d(interfaceC0598a);
        s0 s0Var = this.f56959i;
        if (s0Var != null) {
            s0Var.w(interfaceC0598a);
        }
        g0 g0Var = this.f56958h;
        if (g0Var != null) {
            g0Var.w(interfaceC0598a);
        }
        LinearLayout linearLayout = this.f56956f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        s0 s0Var = this.f56959i;
        if (s0Var != null) {
            s0Var.l(this.f56915b);
        }
    }
}
