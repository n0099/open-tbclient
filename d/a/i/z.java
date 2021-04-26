package d.a.i;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import d.a.i.u0.a;
/* loaded from: classes.dex */
public class z extends d.a.i.a<d.a.i0.r.q.a> {
    public MutiImgTextLayout j;
    public d.a.i0.r.q.a k;
    public int l;
    public String m;

    /* loaded from: classes.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // d.a.i.u0.a.b
        public boolean a(a.C1011a c1011a) {
            if (z.this.k != null && z.this.k.m() != null) {
                d.a.j0.x.m.a(z.this.k.m().o0());
                d.a.j0.x.m.l(z.this.j.f4619e, z.this.k.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                d.a.j0.x.m.l(z.this.j.f4620f, z.this.k.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
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

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    @Override // d.a.i.a
    public void h() {
        i(1, new a());
    }

    @Override // d.a.i.a
    public void l(d.a.j0.x.b0<d.a.i0.r.q.a> b0Var) {
        this.j.setSubClickListener(b0Var);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.l = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: q */
    public void a(d.a.i0.r.q.a aVar) {
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
