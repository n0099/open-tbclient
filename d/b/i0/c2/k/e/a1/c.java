package d.b.i0.c2.k.e.a1;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.i0.x.b0;
/* loaded from: classes5.dex */
public class c extends d.b.i0.c2.k.e.a1.a {

    /* renamed from: f  reason: collision with root package name */
    public OriginalThreadCardView f52575f;

    /* renamed from: g  reason: collision with root package name */
    public int f52576g;

    /* renamed from: h  reason: collision with root package name */
    public int f52577h;

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {

        /* renamed from: d.b.i0.c2.k.e.a1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1150a extends d.b.h0.r.q.a {
            public C1150a() {
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
                OriginalThreadInfo originalThreadInfo = c.this.f52568d;
                if (originalThreadInfo != null) {
                    return originalThreadInfo.a();
                }
                return null;
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            c cVar = c.this;
            b0 b0Var = cVar.f52566b;
            if (b0Var != null) {
                b0Var.a(cVar.f52575f, new C1150a());
            }
        }
    }

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.f52577h = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.f52576g = i;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public View a() {
        if (this.f52575f == null) {
            OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f52565a.getPageActivity());
            this.f52575f = originalThreadCardView;
            originalThreadCardView.q = this.f52576g;
            originalThreadCardView.setSubClickListener(new a());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i = this.f52577h;
            layoutParams.bottomMargin = i;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.f52575f.setLayoutParams(layoutParams);
            this.f52575f.n();
        }
        return this.f52575f;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f52569e != i) {
            this.f52569e = i;
            OriginalThreadCardView originalThreadCardView = this.f52575f;
            if (originalThreadCardView != null) {
                originalThreadCardView.n();
            }
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52568d = originalThreadInfo;
        OriginalThreadCardView originalThreadCardView = this.f52575f;
        if (originalThreadCardView != null) {
            originalThreadCardView.f(originalThreadInfo);
        }
    }
}
