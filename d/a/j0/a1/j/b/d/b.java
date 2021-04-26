package d.a.j0.a1.j.b.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.a1.j.b.c.c;
/* loaded from: classes4.dex */
public class b extends d.a.j0.x.b<c> {
    public View m;
    public c n;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = l().findViewById(R.id.card_topic_list_placeholder);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_topic_list_placeholder_view;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(c cVar) {
        if (cVar == null) {
            return;
        }
        this.n = cVar;
        SkinManager.setBackgroundColor(this.m, cVar.f51133f);
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        layoutParams.height = l.g(this.f62438g, cVar.f51132e);
        this.m.setLayoutParams(layoutParams);
    }
}
