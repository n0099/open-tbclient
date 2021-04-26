package d.a.j0.d2.k.e.c1;

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
import d.a.i.f0;
import d.a.i.r0;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import d.a.j0.x.b0;
/* loaded from: classes3.dex */
public class i extends d.a.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52308f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.r.q.a f52309g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f52310h;

    /* renamed from: i  reason: collision with root package name */
    public r0 f52311i;
    public a2 j;
    public VoteView k;

    /* loaded from: classes3.dex */
    public class a extends d.a.i0.r.q.a {
        public a() {
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.i0.r.q.a
        public v0 h() {
            return null;
        }

        @Override // d.a.i0.r.q.a
        public a2 m() {
            return i.this.j;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = i.this;
            a.InterfaceC1009a interfaceC1009a = iVar.f52268c;
            if (interfaceC1009a != null) {
                interfaceC1009a.a(iVar.f52309g);
            }
        }
    }

    public i(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public View a() {
        if (this.f52308f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52266a.getPageActivity());
            this.f52308f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f52308f.setOrientation(1);
            this.f52308f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52308f.removeAllViews();
        if (this.f52310h == null) {
            f0 f0Var = new f0(this.f52266a);
            this.f52310h = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52308f.addView(this.f52310h.g(), layoutParams);
        if (this.f52311i == null) {
            r0 r0Var = new r0(this.f52266a.getPageActivity());
            this.f52311i = r0Var;
            r0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.f52308f.addView(this.f52311i.g(), layoutParams2);
        if (this.k == null) {
            this.k = new VoteView(this.f52266a.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f52308f.addView(this.k, layoutParams3);
        return this.f52308f;
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52270e != i2) {
            this.f52270e = i2;
            SkinManager.setBackgroundColor(this.f52308f, R.color.CAM_X0206);
            f0 f0Var = this.f52310h;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i2);
            }
            r0 r0Var = this.f52311i;
            if (r0Var != null) {
                r0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52269d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f52309g = aVar;
        r0 r0Var = this.f52311i;
        if (r0Var != null) {
            r0Var.a(aVar);
        }
        f0 f0Var = this.f52310h;
        if (f0Var != null) {
            f0Var.a(this.f52309g);
        }
        PollData pollData = this.f52269d.D;
        if (pollData != null && pollData.getOptions() != null && this.f52269d.D.getOptions().size() > 0) {
            this.k.setIsTransmit(true);
            VoteView voteView = this.k;
            OriginalThreadInfo originalThreadInfo2 = this.f52269d;
            voteView.setData(originalThreadInfo2.D, originalThreadInfo2.f12801f, originalThreadInfo2.f12800e);
            this.k.setVisibility(0);
            return;
        }
        this.f52308f.removeView(this.k);
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1009a interfaceC1009a) {
        super.d(interfaceC1009a);
        r0 r0Var = this.f52311i;
        if (r0Var != null) {
            r0Var.w(interfaceC1009a);
        }
        f0 f0Var = this.f52310h;
        if (f0Var != null) {
            f0Var.w(interfaceC1009a);
        }
        LinearLayout linearLayout = this.f52308f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        r0 r0Var = this.f52311i;
        if (r0Var != null) {
            r0Var.l(this.f52267b);
        }
    }
}
