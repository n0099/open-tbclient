package d.b.i0.p0.d;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class c extends d.b.i0.x.b<d.b.i0.p0.c.a> {
    public NoDataView m;
    public int n;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = 3;
        NoDataView a2 = NoDataViewFactory.a(this.f63756f.getPageActivity(), m(), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f63756f.getPageActivity(), R.dimen.ds160)), NoDataViewFactory.e.a(R.string.search_forum_no_result), null);
        this.m = a2;
        a2.setVisibility(0);
        o(this.f63756f, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.forum_search_no_result;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.n == i) {
            return;
        }
        NoDataView noDataView = this.m;
        if (noDataView != null) {
            noDataView.f(this.f63756f, i);
        }
        this.n = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.p0.c.a aVar) {
        o(this.f63756f, TbadkCoreApplication.getInst().getSkinType());
    }
}
