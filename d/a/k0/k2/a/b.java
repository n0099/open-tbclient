package d.a.k0.k2.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d.a.j0.g0.f.a<String, d.a.j0.g0.d.b> {
    public TextView k;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.k = (TextView) view.findViewById(R.id.text);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.g0.f.e
    /* renamed from: o */
    public void k(String str) {
        super.k(str);
        this.k.setText(str);
    }

    @Override // d.a.k0.d3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        d.a.j0.s0.a.a(tbPageContext, g());
        return true;
    }
}
