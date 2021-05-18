package d.a.k0.p0.d;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class c extends d.a.k0.x.b<d.a.k0.p0.c.a> {
    public NoDataView m;
    public int n;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = 3;
        NoDataView a2 = NoDataViewFactory.a(this.f63161f.getPageActivity(), l(), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f63161f.getPageActivity(), R.dimen.ds160)), NoDataViewFactory.e.a(R.string.search_forum_no_result), null);
        this.m = a2;
        a2.setVisibility(0);
        n(this.f63161f, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.forum_search_no_result;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.n == i2) {
            return;
        }
        NoDataView noDataView = this.m;
        if (noDataView != null) {
            noDataView.f(this.f63161f, i2);
        }
        this.n = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: s */
    public void m(d.a.k0.p0.c.a aVar) {
        n(this.f63161f, TbadkCoreApplication.getInst().getSkinType());
    }
}
