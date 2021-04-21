package d.b.j0.q0.h1;

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
import d.b.c.e.p.l;
import d.b.j0.q0.a0;
import d.b.j0.q0.u;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f59691a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f59692b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f59693c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f59694d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f59695e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.q0.h1.a f59696f;

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
        this.f59691a = frsADFragment;
        e(view);
    }

    public BdTypeRecyclerView a() {
        return this.f59693c;
    }

    public RelativeLayout b() {
        return this.f59692b;
    }

    public d.b.j0.q0.h1.a c() {
        return this.f59696f;
    }

    public void d() {
        this.f59693c.setNextPage(null);
    }

    public final void e(View view) {
        this.f59692b = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.f59693c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f59693c.setFadingEdgeLength(0);
        this.f59693c.setOverScrollMode(2);
        this.f59693c.setRecyclerListener(new a(this));
        this.f59693c.setOnSrollToBottomListener(this.f59691a);
        this.f59696f = new d.b.j0.q0.h1.a(this.f59691a, this.f59693c);
        PbListView pbListView = new PbListView(this.f59691a.getPageContext().getPageActivity());
        this.f59695e = pbListView;
        pbListView.a();
        this.f59695e.o(R.color.CAM_X0205);
        this.f59695e.r(l.g(this.f59691a.getActivity(), R.dimen.tbds182));
        this.f59695e.v();
        this.f59695e.E(R.dimen.tbfontsize33);
        this.f59695e.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f59695e.y(R.color.CAM_X0110);
        this.f59694d = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        j(false);
    }

    public void f() {
        d.b.j0.q0.h1.a aVar = this.f59696f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void g(int i) {
        this.f59691a.getBaseFragmentActivity().getLayoutMode().k(i == 1);
        this.f59691a.getBaseFragmentActivity().getLayoutMode().j(this.f59692b);
        PbListView pbListView = this.f59695e;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f59695e.d(i);
        }
        d.b.j0.q0.h1.a aVar = this.f59696f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void h() {
        this.f59696f.c();
        this.f59693c.setOnSrollToBottomListener(null);
    }

    public void i() {
        u uVar = new u();
        uVar.f60671a = 90;
        uVar.f60672b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void j(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f60671a = 90;
        uVar.f60672b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void k(boolean z) {
        this.f59694d.setVisibility(z ? 0 : 8);
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        this.f59693c.setOnScrollListener(onScrollListener);
    }

    public void m(boolean z) {
        a0 a0Var = new a0();
        a0Var.f59441a = 90;
        a0Var.f59443c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void n() {
        this.f59693c.setNextPage(this.f59695e);
        this.f59695e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f59695e.O();
    }

    public void o() {
        this.f59693c.setNextPage(this.f59695e);
        this.f59695e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f59695e.f();
        this.f59695e.A(this.f59691a.getResources().getString(R.string.list_no_more));
    }

    public void p() {
        u uVar = new u();
        uVar.f60671a = 90;
        uVar.f60672b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }
}
