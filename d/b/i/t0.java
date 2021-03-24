package d.b.i;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class t0 extends h {
    public TbPageContext l;
    public int m;
    public VoteView n;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.q.a f51822e;

        public a(d.b.h0.r.q.a aVar) {
            this.f51822e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ThreadCardUtils.jumpToPB(this.f51822e, (Context) t0.this.l.getPageActivity(), t0.this.m, false);
        }
    }

    public t0(Context context) {
        super(context);
        this.n = new VoteView(context);
        r(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // d.b.i.a
    public View g() {
        return this.n;
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.n.C(i);
    }

    public final boolean u(d.b.h0.r.q.a aVar) {
        return (aVar == null || aVar.n() == null || aVar.n().O0() == null || aVar.n().O0().getOptions() == null || aVar.n().O0().getOptions().size() <= 0 || aVar.n().y2()) ? false : true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: v */
    public void a(d.b.h0.r.q.a aVar) {
        if (u(aVar)) {
            this.n.setVisibility(0);
            this.n.setData(aVar.n().O0(), aVar.n().w1(), aVar.n().c0());
            this.n.setOnItemClickListener(new a(aVar));
            return;
        }
        this.n.setVisibility(8);
    }

    public void w(int i) {
        this.m = i;
    }

    public void x(TbPageContext tbPageContext) {
        this.l = tbPageContext;
        this.n.setPageContext(tbPageContext);
    }
}
