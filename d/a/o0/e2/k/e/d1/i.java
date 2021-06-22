package d.a.o0.e2.k.e.d1;

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
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import d.a.o0.z.b0;
/* loaded from: classes5.dex */
public class i extends d.a.o0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57081f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r.q.a f57082g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f57083h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f57084i;
    public a2 j;
    public VoteView k;

    /* loaded from: classes5.dex */
    public class a extends d.a.n0.r.q.a {
        public a() {
        }

        @Override // d.a.n0.r.q.a
        public v0 c() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.n0.r.q.a
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
            a.InterfaceC0600a interfaceC0600a = iVar.f57041c;
            if (interfaceC0600a != null) {
                interfaceC0600a.a(iVar.f57082g);
            }
        }
    }

    public i(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public View a() {
        if (this.f57081f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f57039a.getPageActivity());
            this.f57081f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f57081f.setOrientation(1);
            this.f57081f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f57081f.removeAllViews();
        if (this.f57083h == null) {
            g0 g0Var = new g0(this.f57039a);
            this.f57083h = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f57081f.addView(this.f57083h.g(), layoutParams);
        if (this.f57084i == null) {
            s0 s0Var = new s0(this.f57039a.getPageActivity());
            this.f57084i = s0Var;
            s0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.f57081f.addView(this.f57084i.g(), layoutParams2);
        if (this.k == null) {
            this.k = new VoteView(this.f57039a.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f57081f.addView(this.k, layoutParams3);
        return this.f57081f;
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f57043e != i2) {
            this.f57043e = i2;
            SkinManager.setBackgroundColor(this.f57081f, R.color.CAM_X0206);
            g0 g0Var = this.f57083h;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            s0 s0Var = this.f57084i;
            if (s0Var != null) {
                s0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f57042d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f57082g = aVar;
        s0 s0Var = this.f57084i;
        if (s0Var != null) {
            s0Var.a(aVar);
        }
        g0 g0Var = this.f57083h;
        if (g0Var != null) {
            g0Var.a(this.f57082g);
        }
        PollData pollData = this.f57042d.D;
        if (pollData != null && pollData.getOptions() != null && this.f57042d.D.getOptions().size() > 0) {
            this.k.setIsTransmit(true);
            VoteView voteView = this.k;
            OriginalThreadInfo originalThreadInfo2 = this.f57042d;
            voteView.setData(originalThreadInfo2.D, originalThreadInfo2.f12182f, originalThreadInfo2.f12181e);
            this.k.setVisibility(0);
            return;
        }
        this.f57081f.removeView(this.k);
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void d(a.InterfaceC0600a interfaceC0600a) {
        super.d(interfaceC0600a);
        s0 s0Var = this.f57084i;
        if (s0Var != null) {
            s0Var.w(interfaceC0600a);
        }
        g0 g0Var = this.f57083h;
        if (g0Var != null) {
            g0Var.w(interfaceC0600a);
        }
        LinearLayout linearLayout = this.f57081f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        s0 s0Var = this.f57084i;
        if (s0Var != null) {
            s0Var.l(this.f57040b);
        }
    }
}
