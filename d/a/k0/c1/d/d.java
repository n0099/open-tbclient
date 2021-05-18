package d.a.k0.c1.d;

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
import d.a.k0.q0.t;
import d.a.k0.q0.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f52440a;

    /* renamed from: b  reason: collision with root package name */
    public View f52441b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f52442c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f52443d;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.f52441b = view;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.f52442c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f52442c.setFadingEdgeLength(0);
        this.f52442c.setOverScrollMode(2);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f52443d = pbListView;
        pbListView.a();
        this.f52443d.o(R.color.CAM_X0205);
        this.f52443d.r(l.g(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.f52443d.v();
        this.f52443d.E(R.dimen.tbfontsize33);
        this.f52443d.y(R.color.CAM_X0110);
        this.f52442c.setNextPage(this.f52443d);
        this.f52443d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f52443d.f();
        this.f52443d.A(tbPageContext.getResources().getString(R.string.list_no_more));
        c();
        this.f52440a = new b(tbPageContext, this.f52442c);
    }

    public View a() {
        return this.f52441b;
    }

    public boolean b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52442c;
        if (bdTypeRecyclerView == null) {
            return false;
        }
        return !ListUtils.isEmpty(bdTypeRecyclerView.getData());
    }

    public void c() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        PbListView pbListView = this.f52443d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f52443d.d(skinType);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f52442c;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f52442c.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        this.f52442c.scrollToPosition(0);
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f52442c.setData(list);
    }

    public void f(TbPageTag tbPageTag) {
        this.f52440a.a(tbPageTag);
    }

    public void g(boolean z) {
        if (z) {
            this.f52442c.setVisibility(0);
        } else {
            this.f52442c.setVisibility(8);
        }
    }

    public void h(boolean z) {
        u uVar = new u();
        uVar.f59520a = 401;
        uVar.f59521b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f52442c.setData(arrayList);
    }
}
