package d.a.n0.e2.k.e.d1;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
import d.a.n0.z.b0;
/* loaded from: classes5.dex */
public class c extends d.a.n0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public OriginalThreadCardView f56925f;

    /* renamed from: g  reason: collision with root package name */
    public int f56926g;

    /* renamed from: h  reason: collision with root package name */
    public int f56927h;

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {

        /* renamed from: d.a.n0.e2.k.e.d1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1322a extends d.a.m0.r.q.a {
            public C1322a() {
            }

            @Override // d.a.m0.r.q.a
            public v0 c() {
                return null;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
            public BdUniqueId getType() {
                return null;
            }

            @Override // d.a.m0.r.q.a
            public a2 i() {
                OriginalThreadInfo originalThreadInfo = c.this.f56917d;
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
            b0 b0Var = cVar.f56915b;
            if (b0Var != null) {
                b0Var.a(cVar.f56925f, new C1322a());
            }
        }
    }

    public c(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        this.f56927h = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.f56926g = i2;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f56925f == null) {
            OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f56914a.getPageActivity());
            this.f56925f = originalThreadCardView;
            originalThreadCardView.q = this.f56926g;
            originalThreadCardView.setSubClickListener(new a());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i2 = this.f56927h;
            layoutParams.bottomMargin = i2;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.f56925f.setLayoutParams(layoutParams);
            this.f56925f.n();
        }
        return this.f56925f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f56918e != i2) {
            this.f56918e = i2;
            OriginalThreadCardView originalThreadCardView = this.f56925f;
            if (originalThreadCardView != null) {
                originalThreadCardView.n();
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f56917d = originalThreadInfo;
        OriginalThreadCardView originalThreadCardView = this.f56925f;
        if (originalThreadCardView != null) {
            originalThreadCardView.f(originalThreadInfo);
        }
    }
}
