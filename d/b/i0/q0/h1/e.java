package d.b.i0.q0.h1;

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
import d.b.i0.q0.a0;
import d.b.i0.q0.u;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public FrsADFragment f59270a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f59271b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f59272c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f59273d;

    /* renamed from: e  reason: collision with root package name */
    public PbListView f59274e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.q0.h1.a f59275f;

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
        this.f59270a = frsADFragment;
        e(view);
    }

    public BdTypeRecyclerView a() {
        return this.f59272c;
    }

    public RelativeLayout b() {
        return this.f59271b;
    }

    public d.b.i0.q0.h1.a c() {
        return this.f59275f;
    }

    public void d() {
        this.f59272c.setNextPage(null);
    }

    public final void e(View view) {
        this.f59271b = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.f59272c = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
        this.f59272c.setFadingEdgeLength(0);
        this.f59272c.setOverScrollMode(2);
        this.f59272c.setRecyclerListener(new a(this));
        this.f59272c.setOnSrollToBottomListener(this.f59270a);
        this.f59275f = new d.b.i0.q0.h1.a(this.f59270a, this.f59272c);
        PbListView pbListView = new PbListView(this.f59270a.getPageContext().getPageActivity());
        this.f59274e = pbListView;
        pbListView.a();
        this.f59274e.o(R.color.CAM_X0205);
        this.f59274e.r(l.g(this.f59270a.getActivity(), R.dimen.tbds182));
        this.f59274e.v();
        this.f59274e.E(R.dimen.tbfontsize33);
        this.f59274e.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f59274e.y(R.color.CAM_X0110);
        this.f59273d = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        j(false);
    }

    public void f() {
        d.b.i0.q0.h1.a aVar = this.f59275f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void g(int i) {
        this.f59270a.getBaseFragmentActivity().getLayoutMode().k(i == 1);
        this.f59270a.getBaseFragmentActivity().getLayoutMode().j(this.f59271b);
        PbListView pbListView = this.f59274e;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f59274e.d(i);
        }
        d.b.i0.q0.h1.a aVar = this.f59275f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void h() {
        this.f59275f.c();
        this.f59272c.setOnSrollToBottomListener(null);
    }

    public void i() {
        u uVar = new u();
        uVar.f60250a = 90;
        uVar.f60251b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void j(boolean z) {
        if (z) {
            return;
        }
        u uVar = new u();
        uVar.f60250a = 90;
        uVar.f60251b = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void k(boolean z) {
        this.f59273d.setVisibility(z ? 0 : 8);
    }

    public void l(RecyclerView.OnScrollListener onScrollListener) {
        this.f59272c.setOnScrollListener(onScrollListener);
    }

    public void m(boolean z) {
        a0 a0Var = new a0();
        a0Var.f59020a = 90;
        a0Var.f59022c = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, a0Var));
    }

    public void n() {
        this.f59272c.setNextPage(this.f59274e);
        this.f59274e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f59274e.O();
    }

    public void o() {
        this.f59272c.setNextPage(this.f59274e);
        this.f59274e.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.f59274e.f();
        this.f59274e.A(this.f59270a.getResources().getString(R.string.list_no_more));
    }

    public void p() {
        u uVar = new u();
        uVar.f60250a = 90;
        uVar.f60251b = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }
}
