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
import d.a.c.j.e.n;
import d.a.n0.r0.t;
import d.a.n0.r0.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f52620a;

    /* renamed from: b  reason: collision with root package name */
    public View f52621b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f52622c;

    /* renamed from: d  reason: collision with root package name */
    public PbListView f52623d;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public d(a aVar, View view, TbPageContext tbPageContext) {
        this.f52621b = view;
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_hottopic_lv_thread);
        this.f52622c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f52622c.setFadingEdgeLength(0);
        this.f52622c.setOverScrollMode(2);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f52623d = pbListView;
        pbListView.a();
        this.f52623d.o(R.color.CAM_X0205);
        this.f52623d.r(l.g(tbPageContext.getPageActivity(), R.dimen.tbds182));
        this.f52623d.v();
        this.f52623d.E(R.dimen.tbfontsize33);
        this.f52623d.y(R.color.CAM_X0110);
        this.f52622c.setNextPage(this.f52623d);
        this.f52623d.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f52623d.f();
        this.f52623d.A(tbPageContext.getResources().getString(R.string.list_no_more));
        c();
        this.f52620a = new b(tbPageContext, this.f52622c);
    }

    public View a() {
        return this.f52621b;
    }

    public boolean b() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f52622c;
        if (bdTypeRecyclerView == null) {
            return false;
        }
        return !ListUtils.isEmpty(bdTypeRecyclerView.getData());
    }

    public void c() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        PbListView pbListView = this.f52623d;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f52623d.d(skinType);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f52622c;
        if (bdTypeRecyclerView == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f52622c.getAdapter().notifyDataSetChanged();
    }

    public void d() {
        this.f52622c.scrollToPosition(0);
    }

    public void e(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f52622c.setData(list);
    }

    public void f(TbPageTag tbPageTag) {
        this.f52620a.a(tbPageTag);
    }

    public void g(boolean z) {
        if (z) {
            this.f52622c.setVisibility(0);
        } else {
            this.f52622c.setVisibility(8);
        }
    }

    public void h(boolean z) {
        u uVar = new u();
        uVar.f59661a = 401;
        uVar.f59662b = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new t());
        this.f52622c.setData(arrayList);
    }
}
