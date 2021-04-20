package d.b.i0.d2.k.e.c1;

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
/* loaded from: classes3.dex */
public class i extends d.b.i0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54087f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.q.a f54088g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f54089h;
    public r0 i;
    public a2 j;
    public VoteView k;

    /* loaded from: classes3.dex */
    public class a extends d.b.h0.r.q.a {
        public a() {
        }

        @Override // d.b.h0.r.q.a
        public v0 g() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.b.h0.r.q.a
        public a2 n() {
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
            a.InterfaceC1129a interfaceC1129a = iVar.f54052c;
            if (interfaceC1129a != null) {
                interfaceC1129a.a(iVar.f54088g);
            }
        }
    }

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public View a() {
        if (this.f54087f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f54050a.getPageActivity());
            this.f54087f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f54087f.setOrientation(1);
            this.f54087f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f54087f.removeAllViews();
        if (this.f54089h == null) {
            f0 f0Var = new f0(this.f54050a);
            this.f54089h = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f54087f.addView(this.f54089h.g(), layoutParams);
        if (this.i == null) {
            r0 r0Var = new r0(this.f54050a.getPageActivity());
            this.i = r0Var;
            r0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.f54087f.addView(this.i.g(), layoutParams2);
        if (this.k == null) {
            this.k = new VoteView(this.f54050a.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f54087f.addView(this.k, layoutParams3);
        return this.f54087f;
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54054e != i) {
            this.f54054e = i;
            SkinManager.setBackgroundColor(this.f54087f, R.color.CAM_X0206);
            f0 f0Var = this.f54089h;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i);
            }
            r0 r0Var = this.i;
            if (r0Var != null) {
                r0Var.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54053d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f54088g = aVar;
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.a(aVar);
        }
        f0 f0Var = this.f54089h;
        if (f0Var != null) {
            f0Var.a(this.f54088g);
        }
        PollData pollData = this.f54053d.D;
        if (pollData != null && pollData.getOptions() != null && this.f54053d.D.getOptions().size() > 0) {
            this.k.setIsTransmit(true);
            VoteView voteView = this.k;
            OriginalThreadInfo originalThreadInfo2 = this.f54053d;
            voteView.setData(originalThreadInfo2.D, originalThreadInfo2.f12877f, originalThreadInfo2.f12876e);
            this.k.setVisibility(0);
            return;
        }
        this.f54087f.removeView(this.k);
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void d(a.InterfaceC1129a interfaceC1129a) {
        super.d(interfaceC1129a);
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.w(interfaceC1129a);
        }
        f0 f0Var = this.f54089h;
        if (f0Var != null) {
            f0Var.w(interfaceC1129a);
        }
        LinearLayout linearLayout = this.f54087f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.l(this.f54051b);
        }
    }
}
