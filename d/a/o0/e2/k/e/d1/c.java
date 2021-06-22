package d.a.o0.e2.k.e.d1;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import d.a.c.e.p.l;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import d.a.o0.z.b0;
/* loaded from: classes5.dex */
public class c extends d.a.o0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public OriginalThreadCardView f57050f;

    /* renamed from: g  reason: collision with root package name */
    public int f57051g;

    /* renamed from: h  reason: collision with root package name */
    public int f57052h;

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {

        /* renamed from: d.a.o0.e2.k.e.d1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1326a extends d.a.n0.r.q.a {
            public C1326a() {
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
                OriginalThreadInfo originalThreadInfo = c.this.f57042d;
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
            b0 b0Var = cVar.f57040b;
            if (b0Var != null) {
                b0Var.a(cVar.f57050f, new C1326a());
            }
        }
    }

    public c(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        this.f57052h = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.f57051g = i2;
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public View a() {
        if (this.f57050f == null) {
            OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f57039a.getPageActivity());
            this.f57050f = originalThreadCardView;
            originalThreadCardView.q = this.f57051g;
            originalThreadCardView.setSubClickListener(new a());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i2 = this.f57052h;
            layoutParams.bottomMargin = i2;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.f57050f.setLayoutParams(layoutParams);
            this.f57050f.n();
        }
        return this.f57050f;
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f57043e != i2) {
            this.f57043e = i2;
            OriginalThreadCardView originalThreadCardView = this.f57050f;
            if (originalThreadCardView != null) {
                originalThreadCardView.n();
            }
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f57042d = originalThreadInfo;
        OriginalThreadCardView originalThreadCardView = this.f57050f;
        if (originalThreadCardView != null) {
            originalThreadCardView.f(originalThreadInfo);
        }
    }
}
