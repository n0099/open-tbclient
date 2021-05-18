package d.a.k0.w1;

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
import d.a.c.e.p.l;
import d.a.j0.r.f0.g;
import d.a.j0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f63068a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f63069b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f63070c;

    /* renamed from: d  reason: collision with root package name */
    public View f63071d;

    /* renamed from: e  reason: collision with root package name */
    public g f63072e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f63073f;

    /* renamed from: g  reason: collision with root package name */
    public e f63074g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f63075h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f63076i;
    public c l;
    public d.a.j0.r.s.a j = null;
    public a.e k = null;
    public boolean m = false;
    public AbsListView.OnScrollListener n = new a();

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (f.this.f63069b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                f.this.f63069b.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            NavigationBarShadowView navigationBarShadowView = f.this.f63069b;
            if (navigationBarShadowView == null || i2 != 1) {
                return;
            }
            navigationBarShadowView.c();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
        public b(f fVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.k0.w1.g.a f63078e;

        public c(d.a.k0.w1.g.a aVar) {
            this.f63078e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.k0.w1.g.a aVar = this.f63078e;
            if (aVar != null) {
                aVar.w(Boolean.TRUE);
            }
        }
    }

    public f(ThreadFragment threadFragment, View view) {
        this.f63068a = null;
        this.f63070c = null;
        this.f63071d = null;
        this.f63073f = null;
        this.f63074g = null;
        this.f63075h = null;
        this.f63076i = null;
        this.f63068a = threadFragment.getBaseFragmentActivity();
        this.f63069b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.f63076i = (ProgressBar) view.findViewById(R.id.progress);
        this.f63075h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f63073f = NoDataViewFactory.a(this.f63068a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f63068a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f63074g = eVar;
        eVar.notifyDataSetChanged();
        this.f63072e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f63070c = bdListView;
        bdListView.setPullRefresh(this.f63072e);
        this.f63072e.a(threadFragment);
        this.f63071d = new TextView(this.f63068a.getActivity());
        this.f63071d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f63068a.getActivity(), R.dimen.ds88)));
        this.f63070c.x(this.f63071d, 0);
        this.f63070c.setAdapter((ListAdapter) this.f63074g);
        this.f63070c.setOnSrollToBottomListener(threadFragment);
        this.f63070c.setOnItemClickListener(threadFragment);
        this.f63070c.setOnScrollListener(this.n);
        this.f63074g.k(threadFragment);
        this.f63074g.r(threadFragment);
        this.f63074g.q(threadFragment);
    }

    public void a(boolean z) {
        this.f63074g.l(z);
        this.f63074g.notifyDataSetChanged();
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f63071d, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        BdListView bdListView = this.f63070c;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void d(boolean z, String str, d.a.k0.w1.g.a aVar) {
        if (z) {
            BaseFragmentActivity baseFragmentActivity = this.f63068a;
            baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
            if (aVar != null && aVar.n() != null) {
                this.f63074g.j(aVar.n());
                if (aVar.n().size() == 0) {
                    if (this.l == null) {
                        this.l = new c(aVar);
                    } else {
                        d.a.c.e.m.e.a().removeCallbacks(this.l);
                    }
                    d.a.c.e.m.e.a().postDelayed(this.l, 600L);
                }
            } else {
                this.f63076i.setVisibility(8);
                return;
            }
        } else {
            this.f63068a.showToast(str);
        }
        this.f63074g.m(false);
        this.f63076i.setVisibility(8);
    }

    public void e(String str, d.a.k0.w1.g.a aVar, boolean z) {
        this.f63074g.p(true);
        if (str != null) {
            this.f63068a.showToast(str);
        }
        if (aVar != null) {
            if (aVar.p() == 0 && !z) {
                aVar.m();
            }
            if (aVar.p() < 20) {
                this.f63074g.n(false);
                this.f63074g.m(true);
            } else {
                this.f63074g.n(true);
                this.f63074g.m(true);
            }
            this.f63074g.j(aVar.n());
            p(aVar, z);
        }
        this.f63074g.p(false);
        this.f63074g.notifyDataSetChanged();
        if (k()) {
            r(false);
        }
    }

    public void f(boolean z, String str, boolean z2) {
        this.f63068a.closeLoadingDialog();
        if (str != null) {
            this.f63068a.showToast(str);
        }
        if (z2) {
            t();
        }
        this.f63074g.notifyDataSetChanged();
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
        this.f63076i.setVisibility(8);
    }

    public boolean k() {
        return this.m;
    }

    public void l(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f63068a.getPageContext().getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void m() {
        this.f63074g.notifyDataSetChanged();
    }

    public void n(int i2) {
        SkinManager.setBackgroundColor(this.f63075h, R.color.CAM_X0201);
        g gVar = this.f63072e;
        if (gVar != null) {
            gVar.I(i2);
        }
        m();
        NoDataView noDataView = this.f63073f;
        if (noDataView != null) {
            noDataView.f(this.f63068a.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f63073f, R.color.CAM_X0201);
        }
    }

    public void o() {
        d.a.j0.r.s.a aVar = this.j;
        if (aVar != null) {
            aVar.dismiss();
            this.j = null;
        }
        ProgressBar progressBar = this.f63076i;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (this.l != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.l);
        }
        e eVar = this.f63074g;
        if (eVar != null) {
            eVar.i();
        }
    }

    public void p(d.a.k0.w1.g.a aVar, boolean z) {
        if (aVar == null) {
            s();
        } else if (aVar.m() > 0) {
            this.f63073f.setVisibility(8);
            this.f63070c.removeHeaderView(this.f63073f);
            this.f63074g.notifyDataSetChanged();
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
        this.f63073f.d(this.f63068a.getPageContext());
        this.f63070c.removeHeaderView(this.f63073f);
        this.f63070c.addHeaderView(this.f63073f);
        this.f63073f.setVisibility(0);
    }

    public final void t() {
        if (this.j == null) {
            d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f63068a.getPageContext().getPageActivity());
            this.j = aVar;
            aVar.setTitle(this.f63068a.getPageContext().getString(R.string.sync_mark_fail));
            this.j.setMessage(this.f63068a.getPageContext().getString(R.string.neterror));
            if (this.k != null) {
                this.j.setPositiveButton(this.f63068a.getPageContext().getString(R.string.retry_rightnow), this.k);
            }
            this.j.setNegativeButton(this.f63068a.getPageContext().getString(R.string.confirm), new b(this));
            this.j.create(this.f63068a.getPageContext());
            this.j.setCanceledOnTouchOutside(true);
        }
        this.j.show();
    }

    public void u() {
        this.f63076i.setVisibility(0);
    }

    public void v(int i2) {
        if (i2 == 0) {
            this.f63070c.F();
            return;
        }
        this.f63074g.p(true);
        this.f63074g.notifyDataSetChanged();
    }

    public void w(ArrayList<MarkData> arrayList) {
        this.f63074g.j(arrayList);
    }

    public void x() {
        if (this.f63073f.isShown()) {
            this.f63073f.d(this.f63068a.getPageContext());
        }
    }
}
