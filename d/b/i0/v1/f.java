package d.b.i0.v1;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.myCollection.ThreadFragment;
import d.b.b.e.p.l;
import d.b.h0.r.f0.g;
import d.b.h0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f62004a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f62005b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f62006c;

    /* renamed from: d  reason: collision with root package name */
    public View f62007d;

    /* renamed from: e  reason: collision with root package name */
    public g f62008e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f62009f;

    /* renamed from: g  reason: collision with root package name */
    public e f62010g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f62011h;
    public ProgressBar i;
    public c l;
    public d.b.h0.r.s.a j = null;
    public a.e k = null;
    public boolean m = false;
    public AbsListView.OnScrollListener n = new a();

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (f.this.f62005b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                f.this.f62005b.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            NavigationBarShadowView navigationBarShadowView = f.this.f62005b;
            if (navigationBarShadowView == null || i != 1) {
                return;
            }
            navigationBarShadowView.c();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
        public b(f fVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.i0.v1.g.a f62013e;

        public c(d.b.i0.v1.g.a aVar) {
            this.f62013e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.v1.g.a aVar = this.f62013e;
            if (aVar != null) {
                aVar.w(Boolean.TRUE);
            }
        }
    }

    public f(ThreadFragment threadFragment, View view) {
        this.f62004a = null;
        this.f62006c = null;
        this.f62007d = null;
        this.f62009f = null;
        this.f62010g = null;
        this.f62011h = null;
        this.i = null;
        this.f62004a = threadFragment.getBaseFragmentActivity();
        this.f62005b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.i = (ProgressBar) view.findViewById(R.id.progress);
        this.f62011h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f62009f = NoDataViewFactory.a(this.f62004a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f62004a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f62010g = eVar;
        eVar.notifyDataSetChanged();
        this.f62008e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f62006c = bdListView;
        bdListView.setPullRefresh(this.f62008e);
        this.f62008e.b(threadFragment);
        this.f62007d = new TextView(this.f62004a.getActivity());
        this.f62007d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f62004a.getActivity(), R.dimen.ds88)));
        this.f62006c.x(this.f62007d, 0);
        this.f62006c.setAdapter((ListAdapter) this.f62010g);
        this.f62006c.setOnSrollToBottomListener(threadFragment);
        this.f62006c.setOnItemClickListener(threadFragment);
        this.f62006c.setOnScrollListener(this.n);
        this.f62010g.k(threadFragment);
        this.f62010g.r(threadFragment);
        this.f62010g.q(threadFragment);
    }

    public void a(boolean z) {
        this.f62010g.l(z);
        this.f62010g.notifyDataSetChanged();
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f62007d, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        BdListView bdListView = this.f62006c;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void d(boolean z, String str, d.b.i0.v1.g.a aVar) {
        if (z) {
            BaseFragmentActivity baseFragmentActivity = this.f62004a;
            baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
            if (aVar != null && aVar.n() != null) {
                this.f62010g.j(aVar.n());
                if (aVar.n().size() == 0) {
                    if (this.l == null) {
                        this.l = new c(aVar);
                    } else {
                        d.b.b.e.m.e.a().removeCallbacks(this.l);
                    }
                    d.b.b.e.m.e.a().postDelayed(this.l, 600L);
                }
            } else {
                this.i.setVisibility(8);
                return;
            }
        } else {
            this.f62004a.showToast(str);
        }
        this.f62010g.m(false);
        this.i.setVisibility(8);
    }

    public void e(String str, d.b.i0.v1.g.a aVar, boolean z) {
        this.f62010g.p(true);
        if (str != null) {
            this.f62004a.showToast(str);
        }
        if (aVar != null) {
            if (aVar.p() == 0 && !z) {
                aVar.m();
            }
            if (aVar.p() < 20) {
                this.f62010g.n(false);
                this.f62010g.m(true);
            } else {
                this.f62010g.n(true);
                this.f62010g.m(true);
            }
            this.f62010g.j(aVar.n());
            p(aVar, z);
        }
        this.f62010g.p(false);
        this.f62010g.notifyDataSetChanged();
        if (k()) {
            r(false);
        }
    }

    public void f(boolean z, String str, boolean z2) {
        this.f62004a.closeLoadingDialog();
        if (str != null) {
            this.f62004a.showToast(str);
        }
        if (z2) {
            t();
        }
        this.f62010g.notifyDataSetChanged();
    }

    public int g(boolean z) {
        if (z) {
            return R.id.share_lv_markitem_delete;
        }
        return R.id.home_lv_markitem_delete;
    }

    public int h(boolean z) {
        if (z) {
            return R.id.share_mark_item_state;
        }
        return R.id.markitem_state;
    }

    public int i(boolean z) {
        if (z) {
            return R.id.share_lv_markitem_userinfo;
        }
        return R.id.home_lv_markitem_userinfo;
    }

    public void j() {
        this.i.setVisibility(8);
    }

    public boolean k() {
        return this.m;
    }

    public void l(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f62004a.getPageContext().getPageActivity()).createNormalConfig(d.b.b.e.m.b.f(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void m() {
        this.f62010g.notifyDataSetChanged();
    }

    public void n(int i) {
        SkinManager.setBackgroundColor(this.f62011h, R.color.CAM_X0201);
        g gVar = this.f62008e;
        if (gVar != null) {
            gVar.I(i);
        }
        m();
        NoDataView noDataView = this.f62009f;
        if (noDataView != null) {
            noDataView.f(this.f62004a.getPageContext(), i);
            SkinManager.setBackgroundColor(this.f62009f, R.color.CAM_X0201);
        }
    }

    public void o() {
        d.b.h0.r.s.a aVar = this.j;
        if (aVar != null) {
            aVar.dismiss();
            this.j = null;
        }
        ProgressBar progressBar = this.i;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (this.l != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.l);
        }
        e eVar = this.f62010g;
        if (eVar != null) {
            eVar.i();
        }
    }

    public void p(d.b.i0.v1.g.a aVar, boolean z) {
        if (aVar == null) {
            s();
        } else if (aVar.m() > 0) {
            this.f62009f.setVisibility(8);
            this.f62006c.removeHeaderView(this.f62009f);
            this.f62010g.notifyDataSetChanged();
        } else if (aVar.m() != 0 || z) {
        } else {
            s();
        }
    }

    public void q(a.e eVar) {
        this.k = eVar;
    }

    public void r(boolean z) {
        this.m = z;
    }

    public void s() {
        this.f62009f.d(this.f62004a.getPageContext());
        this.f62006c.removeHeaderView(this.f62009f);
        this.f62006c.addHeaderView(this.f62009f);
        this.f62009f.setVisibility(0);
    }

    public final void t() {
        if (this.j == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f62004a.getPageContext().getPageActivity());
            this.j = aVar;
            aVar.setTitle(this.f62004a.getPageContext().getString(R.string.sync_mark_fail));
            this.j.setMessage(this.f62004a.getPageContext().getString(R.string.neterror));
            if (this.k != null) {
                this.j.setPositiveButton(this.f62004a.getPageContext().getString(R.string.retry_rightnow), this.k);
            }
            this.j.setNegativeButton(this.f62004a.getPageContext().getString(R.string.confirm), new b(this));
            this.j.create(this.f62004a.getPageContext());
            this.j.setCanceledOnTouchOutside(true);
        }
        this.j.show();
    }

    public void u() {
        this.i.setVisibility(0);
    }

    public void v(int i) {
        if (i == 0) {
            this.f62006c.F();
            return;
        }
        this.f62010g.p(true);
        this.f62010g.notifyDataSetChanged();
    }

    public void w(ArrayList<MarkData> arrayList) {
        this.f62010g.j(arrayList);
    }

    public void x() {
        if (this.f62009f.isShown()) {
            this.f62009f.d(this.f62004a.getPageContext());
        }
    }
}
