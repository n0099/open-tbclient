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
    public FrsADFragment f62330a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f62331b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f62332c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f62333d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f62334e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r0.h1.a f62335f;

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
        this.f62330a = frsADFragment;
        e(view);
    }

    public BdTypeRecyclerView a() {
        return this.f62332c;
    }

    public RelativeLayout b() {
        return this.f62331b;
    }

    public d.a.n0.r0.h1.a c() {
        return this.f62335f;
    }

    public void d() {
        this.f62332c.setNextPage(null);
    }

    public final void e(View view) {
        this.f62331b = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.f62332c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f62332c.setFadingEdgeLength(0);
        this.f62332c.setOverScrollMode(2);
        this.f62332c.setRecyclerListener(new a(this));
        this.f62332c.setOnSrollToBottomListener(this.f62330a);
        this.f62335f = new d.a.n0.r0.h1.a(this.f62330a, this.f62332c);
        PbListView pbListView = new PbListView(this.f62330a.getPageContext().getPageActivity());
        this.f62334e = pbListView;
        pbListView.a();
        this.f62334e.o(R.color.CAM_X0205);
        this.f62334e.r(l.g(this.f62330a.getActivity(), R.dimen.tbds182));
        this.f62334e.v();
        this.f62334e.E(R.dimen.tbfontsize33);
        this.f62334e.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f62334e.y(R.color.CAM_X0110);
        this.f62333d = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        j(false);
    }

    public void f() {
        d.a.n0.r0.h1.a aVar = this.f62335f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void g(int i2) {
        this.f62330a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f62330a.getBaseFragmentActivity().getLayoutMode().j(this.f62331b);
        PbListView pbListView = this.f62334e;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f62334e.d(i2);
        }
        d.a.n0.r0.h1.a aVar = this.f62335f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void h() {
        this.f62335f.c();
        this.f62332c.setOnSrollToBottomListener(null);
    }

    public void i() {
        u uVar = new u();
        uVar.f63352a = 90;
        uVar.f63353b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void j(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f63352a = 90;
        uVar.f63353b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void k(boolean z) {
        this.f62333d.setVisibility(z ? 0 : 8);
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        this.f62332c.setOnScrollListener(onScrollListener);
    }

    public void m(boolean z) {
        a0 a0Var = new a0();
        a0Var.f62054a = 90;
        a0Var.f62056c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void n() {
        this.f62332c.setNextPage(this.f62334e);
        this.f62334e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f62334e.O();
    }

    public void o() {
        this.f62332c.setNextPage(this.f62334e);
        this.f62334e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f62334e.f();
        this.f62334e.A(this.f62330a.getResources().getString(R.string.list_no_more));
    }

    public void p() {
        u uVar = new u();
        uVar.f63352a = 90;
        uVar.f63353b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }
}
