package d.a.n0.d1.d;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.r0.t;
import d.a.n0.r0.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f56309a;

    /* renamed from: b  reason: collision with root package name */
    public View f56310b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f56311c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f56312d;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.f56310b = view;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.f56311c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f56311c.setFadingEdgeLength(0);
        this.f56311c.setOverScrollMode(2);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f56312d = pbListView;
        pbListView.a();
        this.f56312d.o(R.color.CAM_X0205);
        this.f56312d.r(l.g(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.f56312d.v();
        this.f56312d.E(R.dimen.tbfontsize33);
        this.f56312d.y(R.color.CAM_X0110);
        this.f56311c.setNextPage(this.f56312d);
        this.f56312d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f56312d.f();
        this.f56312d.A(tbPageContext.getResources().getString(R.string.list_no_more));
        c();
        this.f56309a = new b(tbPageContext, this.f56311c);
    }

    public View a() {
        return this.f56310b;
    }

    public boolean b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f56311c;
        if (bdTypeRecyclerView == null) {
            return false;
        }
        return !ListUtils.isEmpty(bdTypeRecyclerView.getData());
    }

    public void c() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        PbListView pbListView = this.f56312d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f56312d.d(skinType);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f56311c;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f56311c.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        this.f56311c.scrollToPosition(0);
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f56311c.setData(list);
    }

    public void f(TbPageTag tbPageTag) {
        this.f56309a.a(tbPageTag);
    }

    public void g(boolean z) {
        if (z) {
            this.f56311c.setVisibility(0);
        } else {
            this.f56311c.setVisibility(8);
        }
    }

    public void h(boolean z) {
        u uVar = new u();
        uVar.f63352a = 401;
        uVar.f63353b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f56311c.setData(arrayList);
    }
}
