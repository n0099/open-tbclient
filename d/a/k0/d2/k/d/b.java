package d.a.k0.d2.k.d;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends PbListView {
    public TbPageContext<?> E;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.E = tbPageContext;
        b().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds74));
        x();
        w();
        t();
        E(R.dimen.ds30);
    }

    public void P() {
        super.f();
        A(this.E.getResources().getString(R.string.load_more));
        b().setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void f() {
        super.f();
        A(this.E.getResources().getString(R.string.list_no_more));
        b().setVisibility(0);
    }
}
