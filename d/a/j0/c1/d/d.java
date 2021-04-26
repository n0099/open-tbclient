package d.a.j0.c1.d;

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
import d.a.c.j.e.n;
import d.a.j0.q0.t;
import d.a.j0.q0.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f51741a;

    /* renamed from: b  reason: collision with root package name */
    public View f51742b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f51743c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f51744d;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.f51742b = view;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.f51743c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f51743c.setFadingEdgeLength(0);
        this.f51743c.setOverScrollMode(2);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f51744d = pbListView;
        pbListView.a();
        this.f51744d.o(R.color.CAM_X0205);
        this.f51744d.r(l.g(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.f51744d.v();
        this.f51744d.E(R.dimen.tbfontsize33);
        this.f51744d.y(R.color.CAM_X0110);
        this.f51743c.setNextPage(this.f51744d);
        this.f51744d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f51744d.f();
        this.f51744d.A(tbPageContext.getResources().getString(R.string.list_no_more));
        c();
        this.f51741a = new b(tbPageContext, this.f51743c);
    }

    public View a() {
        return this.f51742b;
    }

    public boolean b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f51743c;
        if (bdTypeRecyclerView == null) {
            return false;
        }
        return !ListUtils.isEmpty(bdTypeRecyclerView.getData());
    }

    public void c() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        PbListView pbListView = this.f51744d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f51744d.d(skinType);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f51743c;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f51743c.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        this.f51743c.scrollToPosition(0);
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f51743c.setData(list);
    }

    public void f(TbPageTag tbPageTag) {
        this.f51741a.a(tbPageTag);
    }

    public void g(boolean z) {
        if (z) {
            this.f51743c.setVisibility(0);
        } else {
            this.f51743c.setVisibility(8);
        }
    }

    public void h(boolean z) {
        u uVar = new u();
        uVar.f58778a = 401;
        uVar.f58779b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f51743c.setData(arrayList);
    }
}
