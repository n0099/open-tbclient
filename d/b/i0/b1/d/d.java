package d.b.i0.b1.d;

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
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.i0.p0.t;
import d.b.i0.p0.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f52152a;

    /* renamed from: b  reason: collision with root package name */
    public View f52153b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f52154c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f52155d;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.f52153b = view;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.f52154c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f52154c.setFadingEdgeLength(0);
        this.f52154c.setOverScrollMode(2);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f52155d = pbListView;
        pbListView.a();
        this.f52155d.o(R.color.CAM_X0205);
        this.f52155d.r(l.g(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.f52155d.v();
        this.f52155d.E(R.dimen.tbfontsize33);
        this.f52155d.y(R.color.CAM_X0110);
        this.f52154c.setNextPage(this.f52155d);
        this.f52155d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f52155d.f();
        this.f52155d.A(tbPageContext.getResources().getString(R.string.list_no_more));
        c();
        this.f52152a = new b(tbPageContext, this.f52154c);
    }

    public View a() {
        return this.f52153b;
    }

    public boolean b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52154c;
        if (bdTypeRecyclerView == null) {
            return false;
        }
        return !ListUtils.isEmpty(bdTypeRecyclerView.getData());
    }

    public void c() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        PbListView pbListView = this.f52155d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f52155d.d(skinType);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f52154c;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f52154c.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        this.f52154c.scrollToPosition(0);
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f52154c.setData(list);
    }

    public void f(TbPageTag tbPageTag) {
        this.f52152a.a(tbPageTag);
    }

    public void g(boolean z) {
        if (z) {
            this.f52154c.setVisibility(0);
        } else {
            this.f52154c.setVisibility(8);
        }
    }

    public void h(boolean z) {
        u uVar = new u();
        uVar.f58581a = 401;
        uVar.f58582b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f52154c.setData(arrayList);
    }
}
