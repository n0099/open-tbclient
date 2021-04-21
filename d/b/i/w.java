package d.b.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import d.b.i.u0.a;
/* loaded from: classes.dex */
public class w extends d.b.i.a<d.b.i0.r.q.a> {
    public MultiImgLayout j;
    public d.b.i0.r.q.a k;
    public int l;
    public String m;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.i.u0.a.b
        public boolean a(a.C1072a c1072a) {
            if (w.this.k != null && w.this.k.n() != null) {
                d.b.j0.x.m.a(w.this.k.n().o0());
                d.b.j0.x.m.l(w.this.j.f4460e, w.this.k.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                d.b.j0.x.m.l(w.this.j.f4461f, w.this.k.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            return false;
        }
    }

    public w(Context context) {
        super(context);
        this.l = 3;
        this.j = new MultiImgLayout(context);
    }

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    @Override // d.b.i.a
    public void h() {
        i(1, new a());
    }

    @Override // d.b.i.a
    public void l(d.b.j0.x.b0<d.b.i0.r.q.a> b0Var) {
        this.j.setSubClickListener(b0Var);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.l != i) {
            SkinManager.setBackgroundResource(g(), R.drawable.addresslist_item_bg);
            this.j.f4463h.b();
        }
        this.l = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: q */
    public void a(d.b.i0.r.q.a aVar) {
        this.k = aVar;
        this.j.setFrom(this.m);
        this.j.a(aVar);
    }

    public void r(d.b.c.e.k.b<TbImageView> bVar) {
        MultiImgLayout multiImgLayout = this.j;
        if (multiImgLayout != null) {
            multiImgLayout.setConstrainImagePool(bVar);
        }
    }

    public void s(d.b.c.e.k.b<ConstrainImageLayout> bVar) {
        MultiImgLayout multiImgLayout = this.j;
        if (multiImgLayout != null) {
            multiImgLayout.setConstrainLayoutPool(bVar);
        }
    }

    public void t(String str) {
        this.m = str;
    }

    public void u(boolean z) {
        this.j.setFromCDN(z);
    }

    public void v(boolean z) {
        this.j.setNeedFrsTabName(z);
    }

    public void w(d.b.c.j.c.b bVar) {
        this.j.setPreloadSizeReadyCallback(bVar);
    }
}
