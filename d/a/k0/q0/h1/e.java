package d.a.k0.q0.h1;

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
import d.a.k0.q0.a0;
import d.a.k0.q0.u;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f58498a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f58499b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f58500c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f58501d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f58502e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.q0.h1.a f58503f;

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
        this.f58498a = frsADFragment;
        e(view);
    }

    public BdTypeRecyclerView a() {
        return this.f58500c;
    }

    public RelativeLayout b() {
        return this.f58499b;
    }

    public d.a.k0.q0.h1.a c() {
        return this.f58503f;
    }

    public void d() {
        this.f58500c.setNextPage(null);
    }

    public final void e(View view) {
        this.f58499b = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.f58500c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f58500c.setFadingEdgeLength(0);
        this.f58500c.setOverScrollMode(2);
        this.f58500c.setRecyclerListener(new a(this));
        this.f58500c.setOnSrollToBottomListener(this.f58498a);
        this.f58503f = new d.a.k0.q0.h1.a(this.f58498a, this.f58500c);
        PbListView pbListView = new PbListView(this.f58498a.getPageContext().getPageActivity());
        this.f58502e = pbListView;
        pbListView.a();
        this.f58502e.o(R.color.CAM_X0205);
        this.f58502e.r(l.g(this.f58498a.getActivity(), R.dimen.tbds182));
        this.f58502e.v();
        this.f58502e.E(R.dimen.tbfontsize33);
        this.f58502e.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f58502e.y(R.color.CAM_X0110);
        this.f58501d = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        j(false);
    }

    public void f() {
        d.a.k0.q0.h1.a aVar = this.f58503f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void g(int i2) {
        this.f58498a.getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        this.f58498a.getBaseFragmentActivity().getLayoutMode().j(this.f58499b);
        PbListView pbListView = this.f58502e;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f58502e.d(i2);
        }
        d.a.k0.q0.h1.a aVar = this.f58503f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void h() {
        this.f58503f.c();
        this.f58500c.setOnSrollToBottomListener(null);
    }

    public void i() {
        u uVar = new u();
        uVar.f59520a = 90;
        uVar.f59521b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void j(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f59520a = 90;
        uVar.f59521b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void k(boolean z) {
        this.f58501d.setVisibility(z ? 0 : 8);
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        this.f58500c.setOnScrollListener(onScrollListener);
    }

    public void m(boolean z) {
        a0 a0Var = new a0();
        a0Var.f58222a = 90;
        a0Var.f58224c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void n() {
        this.f58500c.setNextPage(this.f58502e);
        this.f58502e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f58502e.O();
    }

    public void o() {
        this.f58500c.setNextPage(this.f58502e);
        this.f58502e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f58502e.f();
        this.f58502e.A(this.f58498a.getResources().getString(R.string.list_no_more));
    }

    public void p() {
        u uVar = new u();
        uVar.f59520a = 90;
        uVar.f59521b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }
}
