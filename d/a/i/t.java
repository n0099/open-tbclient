package d.a.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ThreadLinkView;
import com.baidu.tieba.R;
import d.a.m0.r.q.a2;
/* loaded from: classes.dex */
public class t extends a<d.a.m0.r.q.a> {
    public View j;
    public ThreadLinkView k;
    public TextView l;
    public d.a.m0.r.q.a m;

    public t(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
        this.j = inflate;
        this.k = (ThreadLinkView) inflate.findViewById(R.id.link_thread_root);
        this.l = (TextView) this.j.findViewById(R.id.link_seg_title);
    }

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: o */
    public void a(d.a.m0.r.q.a aVar) {
        if (aVar != null && aVar.m() != null) {
            this.m = aVar;
            a2 m = aVar.m();
            d.a.n0.z.m.j(m, this.l);
            this.k.setData(m);
            return;
        }
        g().setVisibility(8);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.k.b();
        d.a.m0.r.q.a aVar = this.m;
        if (aVar == null || aVar.m() == null) {
            return;
        }
        d.a.n0.z.m.l(this.l, this.m.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
    }
}
