package d.a.n0.e2.k.g;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class d extends PbListView {
    public TbPageContext<?> E;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.E = tbPageContext;
        b().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds74));
        x();
        w();
        t();
        E(R.dimen.tbfontsize33);
    }

    public void P() {
        super.f();
        A(this.E.getResources().getString(R.string.load_more));
        b().setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void f() {
        super.f();
        A(this.E.getResources().getString(R.string.sub_pb_list_no_more));
        b().setVisibility(0);
    }
}
