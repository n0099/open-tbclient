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
    public FrsADFragment f57571a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f57572b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f57573c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f57574d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f57575e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.p0.h1.a f57576f;

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
        this.f57571a = frsADFragment;
        e(view);
    }

    public BdTypeRecyclerView a() {
        return this.f57573c;
    }

    public RelativeLayout b() {
        return this.f57572b;
    }

    public d.b.i0.p0.h1.a c() {
        return this.f57576f;
    }

    public void d() {
        this.f57573c.setNextPage(null);
    }

    public final void e(View view) {
        this.f57572b = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.f57573c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f57573c.setFadingEdgeLength(0);
        this.f57573c.setOverScrollMode(2);
        this.f57573c.setRecyclerListener(new a(this));
        this.f57573c.setOnSrollToBottomListener(this.f57571a);
        this.f57576f = new d.b.i0.p0.h1.a(this.f57571a, this.f57573c);
        PbListView pbListView = new PbListView(this.f57571a.getPageContext().getPageActivity());
        this.f57575e = pbListView;
        pbListView.a();
        this.f57575e.o(R.color.CAM_X0205);
        this.f57575e.r(l.g(this.f57571a.getActivity(), R.dimen.tbds182));
        this.f57575e.v();
        this.f57575e.E(R.dimen.tbfontsize33);
        this.f57575e.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f57575e.y(R.color.CAM_X0110);
        this.f57574d = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        j(false);
    }

    public void f() {
        d.b.i0.p0.h1.a aVar = this.f57576f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void g(int i) {
        this.f57571a.getBaseFragmentActivity().getLayoutMode().k(i == 1);
        this.f57571a.getBaseFragmentActivity().getLayoutMode().j(this.f57572b);
        PbListView pbListView = this.f57575e;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f57575e.d(i);
        }
        d.b.i0.p0.h1.a aVar = this.f57576f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void h() {
        this.f57576f.c();
        this.f57573c.setOnSrollToBottomListener(null);
    }

    public void i() {
        u uVar = new u();
        uVar.f58582a = 90;
        uVar.f58583b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void j(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f58582a = 90;
        uVar.f58583b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void k(boolean z) {
        this.f57574d.setVisibility(z ? 0 : 8);
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        this.f57573c.setOnScrollListener(onScrollListener);
    }

    public void m(boolean z) {
        a0 a0Var = new a0();
        a0Var.f57321a = 90;
        a0Var.f57323c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void n() {
        this.f57573c.setNextPage(this.f57575e);
        this.f57575e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57575e.O();
    }

    public void o() {
        this.f57573c.setNextPage(this.f57575e);
        this.f57575e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f57575e.f();
        this.f57575e.A(this.f57571a.getResources().getString(R.string.list_no_more));
    }

    public void p() {
        u uVar = new u();
        uVar.f58582a = 90;
        uVar.f58583b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }
}
