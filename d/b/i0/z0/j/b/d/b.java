package d.b.i0.z0.j.b.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.z0.j.b.c.c;
/* loaded from: classes4.dex */
public class b extends d.b.i0.x.b<c> {
    public View m;
    public c n;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = m().findViewById(R.id.card_topic_list_placeholder);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_topic_list_placeholder_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(c cVar) {
        if (cVar == null) {
            return;
        }
        this.n = cVar;
        SkinManager.setBackgroundColor(this.m, cVar.f63367f);
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        layoutParams.height = l.g(this.f62181g, cVar.f63366e);
        this.m.setLayoutParams(layoutParams);
    }
}
