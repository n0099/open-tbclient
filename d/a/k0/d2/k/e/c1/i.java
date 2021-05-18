package d.a.k0.d2.k.e.c1;

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
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import d.a.k0.x.b0;
/* loaded from: classes5.dex */
public class i extends d.a.k0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f53007f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r.q.a f53008g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f53009h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f53010i;
    public a2 j;
    public VoteView k;

    /* loaded from: classes5.dex */
    public class a extends d.a.j0.r.q.a {
        public a() {
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.j0.r.q.a
        public v0 h() {
            return null;
        }

        @Override // d.a.j0.r.q.a
        public a2 m() {
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
            a.InterfaceC0547a interfaceC0547a = iVar.f52967c;
            if (interfaceC0547a != null) {
                interfaceC0547a.a(iVar.f53008g);
            }
        }
    }

    public i(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public View a() {
        if (this.f53007f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52965a.getPageActivity());
            this.f53007f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f53007f.setOrientation(1);
            this.f53007f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f53007f.removeAllViews();
        if (this.f53009h == null) {
            g0 g0Var = new g0(this.f52965a);
            this.f53009h = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f53007f.addView(this.f53009h.g(), layoutParams);
        if (this.f53010i == null) {
            s0 s0Var = new s0(this.f52965a.getPageActivity());
            this.f53010i = s0Var;
            s0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.f53007f.addView(this.f53010i.g(), layoutParams2);
        if (this.k == null) {
            this.k = new VoteView(this.f52965a.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f53007f.addView(this.k, layoutParams3);
        return this.f53007f;
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52969e != i2) {
            this.f52969e = i2;
            SkinManager.setBackgroundColor(this.f53007f, R.color.CAM_X0206);
            g0 g0Var = this.f53009h;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            s0 s0Var = this.f53010i;
            if (s0Var != null) {
                s0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52968d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f53008g = aVar;
        s0 s0Var = this.f53010i;
        if (s0Var != null) {
            s0Var.a(aVar);
        }
        g0 g0Var = this.f53009h;
        if (g0Var != null) {
            g0Var.a(this.f53008g);
        }
        PollData pollData = this.f52968d.D;
        if (pollData != null && pollData.getOptions() != null && this.f52968d.D.getOptions().size() > 0) {
            this.k.setIsTransmit(true);
            VoteView voteView = this.k;
            OriginalThreadInfo originalThreadInfo2 = this.f52968d;
            voteView.setData(originalThreadInfo2.D, originalThreadInfo2.f12137f, originalThreadInfo2.f12136e);
            this.k.setVisibility(0);
            return;
        }
        this.f53007f.removeView(this.k);
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void d(a.InterfaceC0547a interfaceC0547a) {
        super.d(interfaceC0547a);
        s0 s0Var = this.f53010i;
        if (s0Var != null) {
            s0Var.w(interfaceC0547a);
        }
        g0 g0Var = this.f53009h;
        if (g0Var != null) {
            g0Var.w(interfaceC0547a);
        }
        LinearLayout linearLayout = this.f53007f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        s0 s0Var = this.f53010i;
        if (s0Var != null) {
            s0Var.l(this.f52966b);
        }
    }
}
