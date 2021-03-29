package d.b.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import d.b.i.u0.a;
import java.util.List;
/* loaded from: classes.dex */
public class m0 extends d.b.i.a<d.b.h0.r.q.a> {
    public int j;
    public int k;
    public ThreadCommentAndPraiseInfoLayout l;
    public d.b.h0.r.q.a m;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m0.this.d() != null) {
                m0.this.d().a(view, m0.this.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.i.u0.a.b
        public boolean a(a.C1118a c1118a) {
            if (c1118a.c() instanceof Boolean) {
                if (!((Boolean) c1118a.c()).booleanValue()) {
                    if ((m0.this.j & 128) <= 0) {
                        m0.this.j &= -5;
                        m0.this.j |= 64;
                    }
                } else {
                    m0 m0Var = m0.this;
                    m0Var.j = m0Var.k;
                }
                m0.this.l.setShowFlag(m0.this.j);
                return false;
            }
            return false;
        }
    }

    public m0(Context context) {
        super(context);
        this.j = 11;
        this.k = 11;
        ThreadCardBottomOpSegmentLayout threadCardBottomOpSegmentLayout = new ThreadCardBottomOpSegmentLayout(context);
        this.l = threadCardBottomOpSegmentLayout;
        threadCardBottomOpSegmentLayout.setReplyTimeVisible(false);
        this.l.setShowPraiseNum(true);
        this.l.setNeedAddPraiseIcon(true);
        this.l.setNeedAddReplyIcon(true);
        this.l.setShareVisible(true);
        this.l.setForumAfterClickListener(new a());
    }

    public void A(int i) {
        this.l.setShareReportFrom(i);
    }

    public void B(String str) {
        this.l.setStType(str);
    }

    public void C(String str) {
        this.l.setTabName(str);
    }

    @Override // d.b.i.a
    public void b(int i) {
        int i2 = i | this.j;
        this.j = i2;
        this.l.setShowFlag(i2);
        this.k = this.j;
    }

    @Override // d.b.i.a
    public void c(int i) {
        int i2 = (~i) & this.j;
        this.j = i2;
        this.l.setShowFlag(i2);
        this.k = this.j;
    }

    @Override // d.b.i.a
    public View g() {
        return this.l;
    }

    @Override // d.b.i.a
    public void h() {
        this.f51762e.m(4, new b());
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.l.onChangeSkinType();
    }

    public final void t() {
        boolean z = false;
        k(this.l, 0);
        d.b.i.a f2 = this.f51762e.f();
        if (f2 == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) f2.g();
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = true;
                break;
            } else if (!(viewGroup.getChildAt(i) instanceof TextView) && viewGroup.getChildAt(i).getVisibility() == 0) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            List<h> h2 = this.f51762e.h();
            if (ListUtils.isEmpty(h2)) {
                return;
            }
            for (h hVar : h2) {
                if (hVar != null && hVar.g() != null && hVar.g().getVisibility() == 0) {
                    return;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: u */
    public void a(d.b.h0.r.q.a aVar) {
        this.m = aVar;
        this.l.setData(aVar.n());
        t();
    }

    public void v(d.b.h0.r.q.e eVar) {
        this.l.setAgreeStatisticData(eVar);
    }

    public void w(int i) {
        this.l.setFrom(i);
    }

    public void x(int i) {
        this.l.R = i;
    }

    public void y(int i) {
        this.l.setGameId(i);
    }

    public void z(ThreadCommentAndPraiseInfoLayout.i iVar) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.setOnCommentClickCallback(iVar);
        }
    }
}
