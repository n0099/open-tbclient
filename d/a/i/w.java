package d.a.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import d.a.i.v0.a;
/* loaded from: classes.dex */
public class w extends d.a.i.a<d.a.j0.r.q.a> {
    public MultiImgLayout j;
    public d.a.j0.r.q.a k;
    public int l;
    public String m;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.i.v0.a.b
        public boolean a(a.C0549a c0549a) {
            if (w.this.k != null && w.this.k.m() != null) {
                d.a.k0.x.m.a(w.this.k.m().o0());
                d.a.k0.x.m.l(w.this.j.f4399e, w.this.k.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                d.a.k0.x.m.l(w.this.j.f4400f, w.this.k.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            return false;
        }
    }

    public w(Context context) {
        super(context);
        this.l = 3;
        this.j = new MultiImgLayout(context);
    }

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    @Override // d.a.i.a
    public void h() {
        i(1, new a());
    }

    @Override // d.a.i.a
    public void l(d.a.k0.x.b0<d.a.j0.r.q.a> b0Var) {
        this.j.setSubClickListener(b0Var);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.l != i2) {
            SkinManager.setBackgroundResource(g(), R.drawable.addresslist_item_bg);
            this.j.f4402h.b();
        }
        this.l = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: q */
    public void a(d.a.j0.r.q.a aVar) {
        this.k = aVar;
        this.j.setFrom(this.m);
        this.j.a(aVar);
    }

    public void r(d.a.c.e.k.b<TbImageView> bVar) {
        MultiImgLayout multiImgLayout = this.j;
        if (multiImgLayout != null) {
            multiImgLayout.setConstrainImagePool(bVar);
        }
    }

    public void s(d.a.c.e.k.b<ConstrainImageLayout> bVar) {
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

    public void w(d.a.c.j.c.b bVar) {
        this.j.setPreloadSizeReadyCallback(bVar);
    }
}
