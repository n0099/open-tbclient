package d.a.o0.q0.d;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class c extends d.a.o0.z.b<d.a.o0.q0.c.a> {
    public NoDataView m;
    public int n;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = 3;
        NoDataView a2 = NoDataViewFactory.a(this.f67284f.getPageActivity(), m(), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f67284f.getPageActivity(), R.dimen.ds160)), NoDataViewFactory.e.a(R.string.search_forum_no_result), null);
        this.m = a2;
        a2.setVisibility(0);
        o(this.f67284f, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.forum_search_no_result;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.n == i2) {
            return;
        }
        NoDataView noDataView = this.m;
        if (noDataView != null) {
            noDataView.f(this.f67284f, i2);
        }
        this.n = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: t */
    public void n(d.a.o0.q0.c.a aVar) {
        o(this.f67284f, TbadkCoreApplication.getInst().getSkinType());
    }
}
