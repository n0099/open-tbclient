package d.b.i0.c1.d;

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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.i0.q0.t;
import d.b.i0.q0.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f53554a;

    /* renamed from: b  reason: collision with root package name */
    public View f53555b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f53556c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f53557d;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.f53555b = view;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.f53556c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f53556c.setFadingEdgeLength(0);
        this.f53556c.setOverScrollMode(2);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f53557d = pbListView;
        pbListView.a();
        this.f53557d.o(R.color.CAM_X0205);
        this.f53557d.r(l.g(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.f53557d.v();
        this.f53557d.E(R.dimen.tbfontsize33);
        this.f53557d.y(R.color.CAM_X0110);
        this.f53556c.setNextPage(this.f53557d);
        this.f53557d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f53557d.f();
        this.f53557d.A(tbPageContext.getResources().getString(R.string.list_no_more));
        c();
        this.f53554a = new b(tbPageContext, this.f53556c);
    }

    public View a() {
        return this.f53555b;
    }

    public boolean b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f53556c;
        if (bdTypeRecyclerView == null) {
            return false;
        }
        return !ListUtils.isEmpty(bdTypeRecyclerView.getData());
    }

    public void c() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        PbListView pbListView = this.f53557d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f53557d.d(skinType);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f53556c;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f53556c.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        this.f53556c.scrollToPosition(0);
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f53556c.setData(list);
    }

    public void f(TbPageTag tbPageTag) {
        this.f53554a.a(tbPageTag);
    }

    public void g(boolean z) {
        if (z) {
            this.f53556c.setVisibility(0);
        } else {
            this.f53556c.setVisibility(8);
        }
    }

    public void h(boolean z) {
        u uVar = new u();
        uVar.f60250a = 401;
        uVar.f60251b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f53556c.setData(arrayList);
    }
}
