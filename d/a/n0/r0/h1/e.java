package d.a.n0.r0.h1;

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
import d.a.c.e.p.l;
import d.a.n0.r0.a0;
import d.a.n0.r0.u;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f58639a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f58640b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f58641c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f58642d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f58643e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r0.h1.a f58644f;

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
                    playVoiceBnt.h();
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
        this.f58639a = frsADFragment;
        e(view);
    }

    public BdTypeRecyclerView a() {
        return this.f58641c;
    }

    public RelativeLayout b() {
        return this.f58640b;
    }

    public d.a.n0.r0.h1.a c() {
        return this.f58644f;
    }

    public void d() {
        this.f58641c.setNextPage(null);
    }

    public final void e(View view) {
        this.f58640b = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.f58641c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f58641c.setFadingEdgeLength(0);
        this.f58641c.setOverScrollMode(2);
        this.f58641c.setRecyclerListener(new a(this));
        this.f58641c.setOnSrollToBottomListener(this.f58639a);
        this.f58644f = new d.a.n0.r0.h1.a(this.f58639a, this.f58641c);
        PbListView pbListView = new PbListView(this.f58639a.getPageContext().getPageActivity());
        this.f58643e = pbListView;
        pbListView.a();
        this.f58643e.o(R.color.CAM_X0205);
        this.f58643e.r(l.g(this.f58639a.getActivity(), R.dimen.tbds182));
        this.f58643e.v();
        this.f58643e.E(R.dimen.tbfontsize33);
        this.f58643e.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f58643e.y(R.color.CAM_X0110);
        this.f58642d = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        j(false);
    }

    public void f() {
        d.a.n0.r0.h1.a aVar = this.f58644f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void g(int i2) {
        this.f58639a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f58639a.getBaseFragmentActivity().getLayoutMode().j(this.f58640b);
        PbListView pbListView = this.f58643e;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f58643e.d(i2);
        }
        d.a.n0.r0.h1.a aVar = this.f58644f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void h() {
        this.f58644f.c();
        this.f58641c.setOnSrollToBottomListener(null);
    }

    public void i() {
        u uVar = new u();
        uVar.f59661a = 90;
        uVar.f59662b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void j(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f59661a = 90;
        uVar.f59662b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void k(boolean z) {
        this.f58642d.setVisibility(z ? 0 : 8);
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        this.f58641c.setOnScrollListener(onScrollListener);
    }

    public void m(boolean z) {
        a0 a0Var = new a0();
        a0Var.f58363a = 90;
        a0Var.f58365c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void n() {
        this.f58641c.setNextPage(this.f58643e);
        this.f58643e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f58643e.O();
    }

    public void o() {
        this.f58641c.setNextPage(this.f58643e);
        this.f58643e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f58643e.f();
        this.f58643e.A(this.f58639a.getResources().getString(R.string.list_no_more));
    }

    public void p() {
        u uVar = new u();
        uVar.f59661a = 90;
        uVar.f59662b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }
}
