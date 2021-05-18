package d.a.k0.d2.k.e.c1;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import d.a.c.e.p.l;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import d.a.k0.x.b0;
/* loaded from: classes5.dex */
public class c extends d.a.k0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public OriginalThreadCardView f52976f;

    /* renamed from: g  reason: collision with root package name */
    public int f52977g;

    /* renamed from: h  reason: collision with root package name */
    public int f52978h;

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {

        /* renamed from: d.a.k0.d2.k.e.c1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1247a extends d.a.j0.r.q.a {
            public C1247a() {
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
                OriginalThreadInfo originalThreadInfo = c.this.f52968d;
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
            b0 b0Var = cVar.f52966b;
            if (b0Var != null) {
                b0Var.a(cVar.f52976f, new C1247a());
            }
        }
    }

    public c(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        this.f52978h = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.f52977g = i2;
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public View a() {
        if (this.f52976f == null) {
            OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f52965a.getPageActivity());
            this.f52976f = originalThreadCardView;
            originalThreadCardView.q = this.f52977g;
            originalThreadCardView.setSubClickListener(new a());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i2 = this.f52978h;
            layoutParams.bottomMargin = i2;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.f52976f.setLayoutParams(layoutParams);
            this.f52976f.n();
        }
        return this.f52976f;
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52969e != i2) {
            this.f52969e = i2;
            OriginalThreadCardView originalThreadCardView = this.f52976f;
            if (originalThreadCardView != null) {
                originalThreadCardView.n();
            }
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52968d = originalThreadInfo;
        OriginalThreadCardView originalThreadCardView = this.f52976f;
        if (originalThreadCardView != null) {
            originalThreadCardView.f(originalThreadInfo);
        }
    }
}
