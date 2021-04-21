package d.b.j0.d2.k.e.c1;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import d.b.j0.x.b0;
/* loaded from: classes3.dex */
public class c extends d.b.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public OriginalThreadCardView f54481f;

    /* renamed from: g  reason: collision with root package name */
    public int f54482g;

    /* renamed from: h  reason: collision with root package name */
    public int f54483h;

    /* loaded from: classes3.dex */
    public class a implements OriginalThreadCardView.b {

        /* renamed from: d.b.j0.d2.k.e.c1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1236a extends d.b.i0.r.q.a {
            public C1236a() {
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
                OriginalThreadInfo originalThreadInfo = c.this.f54474d;
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
            b0 b0Var = cVar.f54472b;
            if (b0Var != null) {
                b0Var.a(cVar.f54481f, new C1236a());
            }
        }
    }

    public c(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.f54483h = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.f54482g = i;
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public View a() {
        if (this.f54481f == null) {
            OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f54471a.getPageActivity());
            this.f54481f = originalThreadCardView;
            originalThreadCardView.q = this.f54482g;
            originalThreadCardView.setSubClickListener(new a());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i = this.f54483h;
            layoutParams.bottomMargin = i;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.f54481f.setLayoutParams(layoutParams);
            this.f54481f.n();
        }
        return this.f54481f;
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54475e != i) {
            this.f54475e = i;
            OriginalThreadCardView originalThreadCardView = this.f54481f;
            if (originalThreadCardView != null) {
                originalThreadCardView.n();
            }
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54474d = originalThreadInfo;
        OriginalThreadCardView originalThreadCardView = this.f54481f;
        if (originalThreadCardView != null) {
            originalThreadCardView.f(originalThreadInfo);
        }
    }
}
