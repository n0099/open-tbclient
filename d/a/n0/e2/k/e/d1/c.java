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
    public OriginalThreadCardView f53236f;

    /* renamed from: g  reason: collision with root package name */
    public int f53237g;

    /* renamed from: h  reason: collision with root package name */
    public int f53238h;

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {

        /* renamed from: d.a.n0.e2.k.e.d1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1266a extends d.a.m0.r.q.a {
            public C1266a() {
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
            public BdUniqueId getType() {
                return null;
            }

            @Override // d.a.m0.r.q.a
            public v0 h() {
                return null;
            }

            @Override // d.a.m0.r.q.a
            public a2 m() {
                OriginalThreadInfo originalThreadInfo = c.this.f53228d;
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
            b0 b0Var = cVar.f53226b;
            if (b0Var != null) {
                b0Var.a(cVar.f53236f, new C1266a());
            }
        }
    }

    public c(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        this.f53238h = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.f53237g = i2;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f53236f == null) {
            OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f53225a.getPageActivity());
            this.f53236f = originalThreadCardView;
            originalThreadCardView.q = this.f53237g;
            originalThreadCardView.setSubClickListener(new a());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i2 = this.f53238h;
            layoutParams.bottomMargin = i2;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.f53236f.setLayoutParams(layoutParams);
            this.f53236f.n();
        }
        return this.f53236f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f53229e != i2) {
            this.f53229e = i2;
            OriginalThreadCardView originalThreadCardView = this.f53236f;
            if (originalThreadCardView != null) {
                originalThreadCardView.n();
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f53228d = originalThreadInfo;
        OriginalThreadCardView originalThreadCardView = this.f53236f;
        if (originalThreadCardView != null) {
            originalThreadCardView.f(originalThreadInfo);
        }
    }
}
