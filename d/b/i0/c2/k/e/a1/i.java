package d.b.i0.c2.k.e.a1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.i.a;
import d.b.i.f0;
import d.b.i.r0;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class i extends d.b.i0.c2.k.e.a1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52601f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.q.a f52602g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f52603h;
    public r0 i;
    public a2 j;
    public VoteView k;

    /* loaded from: classes4.dex */
    public class a extends d.b.h0.r.q.a {
        public a() {
        }

        @Override // d.b.h0.r.q.a
        public v0 g() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.b.h0.r.q.a
        public a2 n() {
            return i.this.j;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = i.this;
            a.InterfaceC1115a interfaceC1115a = iVar.f52566c;
            if (interfaceC1115a != null) {
                interfaceC1115a.a(iVar.f52602g);
            }
        }
    }

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public View a() {
        if (this.f52601f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52564a.getPageActivity());
            this.f52601f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f52601f.setOrientation(1);
            this.f52601f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52601f.removeAllViews();
        if (this.f52603h == null) {
            f0 f0Var = new f0(this.f52564a);
            this.f52603h = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52601f.addView(this.f52603h.g(), layoutParams);
        if (this.i == null) {
            r0 r0Var = new r0(this.f52564a.getPageActivity());
            this.i = r0Var;
            r0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.f52601f.addView(this.i.g(), layoutParams2);
        if (this.k == null) {
            this.k = new VoteView(this.f52564a.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f52601f.addView(this.k, layoutParams3);
        return this.f52601f;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f52568e != i) {
            this.f52568e = i;
            SkinManager.setBackgroundColor(this.f52601f, R.color.CAM_X0206);
            f0 f0Var = this.f52603h;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i);
            }
            r0 r0Var = this.i;
            if (r0Var != null) {
                r0Var.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52567d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f52602g = aVar;
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.a(aVar);
        }
        f0 f0Var = this.f52603h;
        if (f0Var != null) {
            f0Var.a(this.f52602g);
        }
        PollData pollData = this.f52567d.D;
        if (pollData != null && pollData.getOptions() != null && this.f52567d.D.getOptions().size() > 0) {
            this.k.setIsTransmit(true);
            VoteView voteView = this.k;
            OriginalThreadInfo originalThreadInfo2 = this.f52567d;
            voteView.setData(originalThreadInfo2.D, originalThreadInfo2.f13215f, originalThreadInfo2.f13214e);
            this.k.setVisibility(0);
            return;
        }
        this.f52601f.removeView(this.k);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void d(a.InterfaceC1115a interfaceC1115a) {
        super.d(interfaceC1115a);
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.w(interfaceC1115a);
        }
        f0 f0Var = this.f52603h;
        if (f0Var != null) {
            f0Var.w(interfaceC1115a);
        }
        LinearLayout linearLayout = this.f52601f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.l(this.f52565b);
        }
    }
}
