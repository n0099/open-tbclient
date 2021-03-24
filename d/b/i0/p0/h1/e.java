package d.b.i0.p0.h1;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import d.b.b.e.p.l;
import d.b.i0.p0.a0;
import d.b.i0.p0.u;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f57570a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f57571b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f57572c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f57573d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f57574e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.p0.h1.a f57575f;

    /* loaded from: classes4.dex */
    public class a implements RecyclerView.RecyclerListener {
        public a(e eVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view != null) {
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.l();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        }
    }

    public e(FrsADFragment frsADFragment, View view) {
        this.f57570a = frsADFragment;
        e(view);
    }

    public BdTypeRecyclerView a() {
        return this.f57572c;
    }

    public RelativeLayout b() {
        return this.f57571b;
    }

    public d.b.i0.p0.h1.a c() {
        return this.f57575f;
    }

    public void d() {
        this.f57572c.setNextPage(null);
    }

    public final void e(View view) {
        this.f57571b = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.f57572c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f57572c.setFadingEdgeLength(0);
        this.f57572c.setOverScrollMode(2);
        this.f57572c.setRecyclerListener(new a(this));
        this.f57572c.setOnSrollToBottomListener(this.f57570a);
        this.f57575f = new d.b.i0.p0.h1.a(this.f57570a, this.f57572c);
        PbListView pbListView = new PbListView(this.f57570a.getPageContext().getPageActivity());
        this.f57574e = pbListView;
        pbListView.a();
        this.f57574e.o(R.color.CAM_X0205);
        this.f57574e.r(l.g(this.f57570a.getActivity(), R.dimen.tbds182));
        this.f57574e.v();
        this.f57574e.E(R.dimen.tbfontsize33);
        this.f57574e.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f57574e.y(R.color.CAM_X0110);
        this.f57573d = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        j(false);
    }

    public void f() {
        d.b.i0.p0.h1.a aVar = this.f57575f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void g(int i) {
        this.f57570a.getBaseFragmentActivity().getLayoutMode().k(i == 1);
        this.f57570a.getBaseFragmentActivity().getLayoutMode().j(this.f57571b);
        PbListView pbListView = this.f57574e;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f57574e.d(i);
        }
        d.b.i0.p0.h1.a aVar = this.f57575f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void h() {
        this.f57575f.c();
        this.f57572c.setOnSrollToBottomListener(null);
    }

    public void i() {
        u uVar = new u();
        uVar.f58581a = 90;
        uVar.f58582b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void j(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f58581a = 90;
        uVar.f58582b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void k(boolean z) {
        this.f57573d.setVisibility(z ? 0 : 8);
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        this.f57572c.setOnScrollListener(onScrollListener);
    }

    public void m(boolean z) {
        a0 a0Var = new a0();
        a0Var.f57320a = 90;
        a0Var.f57322c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void n() {
        this.f57572c.setNextPage(this.f57574e);
        this.f57574e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57574e.O();
    }

    public void o() {
        this.f57572c.setNextPage(this.f57574e);
        this.f57574e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57574e.f();
        this.f57574e.A(this.f57570a.getResources().getString(R.string.list_no_more));
    }

    public void p() {
        u uVar = new u();
        uVar.f58581a = 90;
        uVar.f58582b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }
}
