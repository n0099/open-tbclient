package d.a.i;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u0 extends h {
    public TbPageContext l;
    public int m;
    public VoteView n;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.q.a f40388e;

        public a(d.a.j0.r.q.a aVar) {
            this.f40388e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCardUtils.jumpToPB(this.f40388e, (Context) u0.this.l.getPageActivity(), u0.this.m, false);
        }
    }

    public u0(Context context) {
        super(context);
        this.n = new VoteView(context);
        r(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // d.a.i.a
    public View g() {
        return this.n;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.n.C(i2);
    }

    public final boolean u(d.a.j0.r.q.a aVar) {
        return (aVar == null || aVar.m() == null || aVar.m().O0() == null || aVar.m().O0().getOptions() == null || aVar.m().O0().getOptions().size() <= 0 || aVar.m().B2()) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: v */
    public void a(d.a.j0.r.q.a aVar) {
        if (u(aVar)) {
            this.n.setVisibility(0);
            this.n.setData(aVar.m().O0(), aVar.m().x1(), aVar.m().c0());
            this.n.setOnItemClickListener(new a(aVar));
            return;
        }
        this.n.setVisibility(8);
    }

    public void w(int i2) {
        this.m = i2;
    }

    public void x(TbPageContext tbPageContext) {
        this.l = tbPageContext;
        this.n.setPageContext(tbPageContext);
    }
}
