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
/* loaded from: classes5.dex */
public class i extends d.b.i0.c2.k.e.a1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52602f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.q.a f52603g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f52604h;
    public r0 i;
    public a2 j;
    public VoteView k;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar = i.this;
            a.InterfaceC1116a interfaceC1116a = iVar.f52567c;
            if (interfaceC1116a != null) {
                interfaceC1116a.a(iVar.f52603g);
            }
        }
    }

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public View a() {
        if (this.f52602f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52565a.getPageActivity());
            this.f52602f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f52602f.setOrientation(1);
            this.f52602f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52602f.removeAllViews();
        if (this.f52604h == null) {
            f0 f0Var = new f0(this.f52565a);
            this.f52604h = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52602f.addView(this.f52604h.g(), layoutParams);
        if (this.i == null) {
            r0 r0Var = new r0(this.f52565a.getPageActivity());
            this.i = r0Var;
            r0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.f52602f.addView(this.i.g(), layoutParams2);
        if (this.k == null) {
            this.k = new VoteView(this.f52565a.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f52602f.addView(this.k, layoutParams3);
        return this.f52602f;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f52569e != i) {
            this.f52569e = i;
            SkinManager.setBackgroundColor(this.f52602f, R.color.CAM_X0206);
            f0 f0Var = this.f52604h;
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
        this.f52568d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f52603g = aVar;
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.a(aVar);
        }
        f0 f0Var = this.f52604h;
        if (f0Var != null) {
            f0Var.a(this.f52603g);
        }
        PollData pollData = this.f52568d.D;
        if (pollData != null && pollData.getOptions() != null && this.f52568d.D.getOptions().size() > 0) {
            this.k.setIsTransmit(true);
            VoteView voteView = this.k;
            OriginalThreadInfo originalThreadInfo2 = this.f52568d;
            voteView.setData(originalThreadInfo2.D, originalThreadInfo2.f13216f, originalThreadInfo2.f13215e);
            this.k.setVisibility(0);
            return;
        }
        this.f52602f.removeView(this.k);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void d(a.InterfaceC1116a interfaceC1116a) {
        super.d(interfaceC1116a);
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.w(interfaceC1116a);
        }
        f0 f0Var = this.f52604h;
        if (f0Var != null) {
            f0Var.w(interfaceC1116a);
        }
        LinearLayout linearLayout = this.f52602f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.l(this.f52566b);
        }
    }
}
