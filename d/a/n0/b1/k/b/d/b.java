package d.a.n0.b1.k.b.d;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.b1.k.b.c.c;
/* loaded from: classes4.dex */
public class b extends d.a.n0.z.b<c> {
    public View m;
    public c n;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = m().findViewById(R.id.card_topic_list_placeholder);
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.card_topic_list_placeholder_view;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void n(c cVar) {
        if (cVar == null) {
            return;
        }
        this.n = cVar;
        SkinManager.setBackgroundColor(this.m, cVar.f55688f);
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        layoutParams.height = l.g(this.f67160g, cVar.f55687e);
        this.m.setLayoutParams(layoutParams);
    }
}
