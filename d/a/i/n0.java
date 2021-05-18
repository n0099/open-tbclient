package d.a.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import d.a.i.v0.a;
import java.util.List;
/* loaded from: classes.dex */
public class n0 extends d.a.i.a<d.a.j0.r.q.a> {
    public int j;
    public int k;
    public ThreadCommentAndPraiseInfoLayout l;
    public d.a.j0.r.q.a m;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (n0.this.d() != null) {
                n0.this.d().a(view, n0.this.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.i.v0.a.b
        public boolean a(a.C0549a c0549a) {
            if (c0549a.c() instanceof Boolean) {
                if (!((Boolean) c0549a.c()).booleanValue()) {
                    if ((n0.this.j & 128) <= 0) {
                        n0.this.j &= -5;
                        n0.this.j |= 64;
                    }
                } else {
                    n0 n0Var = n0.this;
                    n0Var.j = n0Var.k;
                }
                n0.this.l.setShowFlag(n0.this.j);
                return false;
            }
            return false;
        }
    }

    public n0(Context context) {
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

    public void A(int i2) {
        this.l.setShareReportFrom(i2);
    }

    public void B(String str) {
        this.l.setStType(str);
    }

    public void D(String str) {
        this.l.setTabName(str);
    }

    @Override // d.a.i.a
    public void b(int i2) {
        int i3 = i2 | this.j;
        this.j = i3;
        this.l.setShowFlag(i3);
        this.k = this.j;
    }

    @Override // d.a.i.a
    public void c(int i2) {
        int i3 = (~i2) & this.j;
        this.j = i3;
        this.l.setShowFlag(i3);
        this.k = this.j;
    }

    @Override // d.a.i.a
    public View g() {
        return this.l;
    }

    @Override // d.a.i.a
    public void h() {
        this.f40315e.m(4, new b());
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.l.onChangeSkinType();
    }

    public final void t() {
        boolean z = false;
        k(this.l, 0);
        d.a.i.a f2 = this.f40315e.f();
        if (f2 == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) f2.g();
        int childCount = viewGroup.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                z = true;
                break;
            } else if (!(viewGroup.getChildAt(i2) instanceof TextView) && viewGroup.getChildAt(i2).getVisibility() == 0) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            List<h> h2 = this.f40315e.h();
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
    @Override // d.a.i.p
    /* renamed from: u */
    public void a(d.a.j0.r.q.a aVar) {
        this.m = aVar;
        this.l.setData(aVar.m());
        t();
    }

    public void v(d.a.j0.r.q.e eVar) {
        this.l.setAgreeStatisticData(eVar);
    }

    public void w(int i2) {
        this.l.setFrom(i2);
    }

    public void x(int i2) {
        this.l.R = i2;
    }

    public void y(int i2) {
        this.l.setGameId(i2);
    }

    public void z(ThreadCommentAndPraiseInfoLayout.i iVar) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.setOnCommentClickCallback(iVar);
        }
    }
}
