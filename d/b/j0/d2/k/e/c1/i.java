package d.b.j0.d2.k.e.c1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
import d.b.i.a;
import d.b.i.f0;
import d.b.i.r0;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import d.b.j0.x.b0;
/* loaded from: classes3.dex */
public class i extends d.b.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54508f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.q.a f54509g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f54510h;
    public r0 i;
    public a2 j;
    public VoteView k;

    /* loaded from: classes3.dex */
    public class a extends d.b.i0.r.q.a {
        public a() {
        }

        @Override // d.b.i0.r.q.a
        public v0 g() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.b.i0.r.q.a
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
            a.InterfaceC1070a interfaceC1070a = iVar.f54473c;
            if (interfaceC1070a != null) {
                interfaceC1070a.a(iVar.f54509g);
            }
        }
    }

    public i(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public View a() {
        if (this.f54508f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f54471a.getPageActivity());
            this.f54508f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f54508f.setOrientation(1);
            this.f54508f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f54508f.removeAllViews();
        if (this.f54510h == null) {
            f0 f0Var = new f0(this.f54471a);
            this.f54510h = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f54508f.addView(this.f54510h.g(), layoutParams);
        if (this.i == null) {
            r0 r0Var = new r0(this.f54471a.getPageActivity());
            this.i = r0Var;
            r0Var.v("pb");
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.f54508f.addView(this.i.g(), layoutParams2);
        if (this.k == null) {
            this.k = new VoteView(this.f54471a.getPageActivity());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f54508f.addView(this.k, layoutParams3);
        return this.f54508f;
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54475e != i) {
            this.f54475e = i;
            SkinManager.setBackgroundColor(this.f54508f, R.color.CAM_X0206);
            f0 f0Var = this.f54510h;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i);
            }
            r0 r0Var = this.i;
            if (r0Var != null) {
                r0Var.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54474d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f54509g = aVar;
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.a(aVar);
        }
        f0 f0Var = this.f54510h;
        if (f0Var != null) {
            f0Var.a(this.f54509g);
        }
        PollData pollData = this.f54474d.D;
        if (pollData != null && pollData.getOptions() != null && this.f54474d.D.getOptions().size() > 0) {
            this.k.setIsTransmit(true);
            VoteView voteView = this.k;
            OriginalThreadInfo originalThreadInfo2 = this.f54474d;
            voteView.setData(originalThreadInfo2.D, originalThreadInfo2.f12885f, originalThreadInfo2.f12884e);
            this.k.setVisibility(0);
            return;
        }
        this.f54508f.removeView(this.k);
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1070a interfaceC1070a) {
        super.d(interfaceC1070a);
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.w(interfaceC1070a);
        }
        f0 f0Var = this.f54510h;
        if (f0Var != null) {
            f0Var.w(interfaceC1070a);
        }
        LinearLayout linearLayout = this.f54508f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        r0 r0Var = this.i;
        if (r0Var != null) {
            r0Var.l(this.f54472b);
        }
    }
}
