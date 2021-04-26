package d.a.j0.d2.k.e.c1;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import d.a.c.e.p.l;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import d.a.j0.x.b0;
/* loaded from: classes3.dex */
public class c extends d.a.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public OriginalThreadCardView f52277f;

    /* renamed from: g  reason: collision with root package name */
    public int f52278g;

    /* renamed from: h  reason: collision with root package name */
    public int f52279h;

    /* loaded from: classes3.dex */
    public class a implements OriginalThreadCardView.b {

        /* renamed from: d.a.j0.d2.k.e.c1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1175a extends d.a.i0.r.q.a {
            public C1175a() {
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
                OriginalThreadInfo originalThreadInfo = c.this.f52269d;
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
            b0 b0Var = cVar.f52267b;
            if (b0Var != null) {
                b0Var.a(cVar.f52277f, new C1175a());
            }
        }
    }

    public c(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        this.f52279h = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.f52278g = i2;
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public View a() {
        if (this.f52277f == null) {
            OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f52266a.getPageActivity());
            this.f52277f = originalThreadCardView;
            originalThreadCardView.q = this.f52278g;
            originalThreadCardView.setSubClickListener(new a());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i2 = this.f52279h;
            layoutParams.bottomMargin = i2;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.f52277f.setLayoutParams(layoutParams);
            this.f52277f.n();
        }
        return this.f52277f;
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52270e != i2) {
            this.f52270e = i2;
            OriginalThreadCardView originalThreadCardView = this.f52277f;
            if (originalThreadCardView != null) {
                originalThreadCardView.n();
            }
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52269d = originalThreadInfo;
        OriginalThreadCardView originalThreadCardView = this.f52277f;
        if (originalThreadCardView != null) {
            originalThreadCardView.f(originalThreadInfo);
        }
    }
}
