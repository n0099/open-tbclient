package d.b.i;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.b.i.u0.a;
/* loaded from: classes.dex */
public class z extends d.b.i.a<d.b.h0.r.q.a> {
    public MutiImgTextLayout j;
    public d.b.h0.r.q.a k;
    public int l;
    public String m;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.b.i.u0.a.b
        public boolean a(a.C1118a c1118a) {
            if (z.this.k != null && z.this.k.n() != null) {
                d.b.i0.x.m.a(z.this.k.n().o0());
                d.b.i0.x.m.l(z.this.j.f4489e, z.this.k.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                d.b.i0.x.m.l(z.this.j.f4490f, z.this.k.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            return false;
        }
    }

    public z(Context context) {
        super(context);
        this.l = 3;
        this.j = new MutiImgTextLayout(context);
        this.j.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
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
    public void l(d.b.i0.x.b0<d.b.h0.r.q.a> b0Var) {
        this.j.setSubClickListener(b0Var);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.l = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: q */
    public void a(d.b.h0.r.q.a aVar) {
        this.k = aVar;
        this.j.setFrom(this.m);
        this.j.a(aVar);
    }

    public void r(String str) {
        this.m = str;
    }

    public void s(boolean z) {
        this.j.setFromCDN(z);
    }

    public void t(boolean z) {
        this.j.setNeedFrsTabName(z);
    }
}
