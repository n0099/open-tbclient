package d.a.n0.x1;

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
import d.a.m0.r.f0.g;
import d.a.m0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f66968a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f66969b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f66970c;

    /* renamed from: d  reason: collision with root package name */
    public View f66971d;

    /* renamed from: e  reason: collision with root package name */
    public g f66972e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f66973f;

    /* renamed from: g  reason: collision with root package name */
    public e f66974g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f66975h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f66976i;
    public c l;
    public d.a.m0.r.s.a j = null;
    public a.e k = null;
    public boolean m = false;
    public AbsListView.OnScrollListener n = new a();

    /* loaded from: classes4.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i2 == 0) {
                View childAt = absListView.getChildAt(0);
                if (f.this.f66969b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                f.this.f66969b.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            NavigationBarShadowView navigationBarShadowView = f.this.f66969b;
            if (navigationBarShadowView == null || i2 != 1) {
                return;
            }
            navigationBarShadowView.c();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b(f fVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.n0.x1.g.a f66978e;

        public c(d.a.n0.x1.g.a aVar) {
            this.f66978e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.x1.g.a aVar = this.f66978e;
            if (aVar != null) {
                aVar.w(Boolean.TRUE);
            }
        }
    }

    public f(ThreadFragment threadFragment, View view) {
        this.f66968a = null;
        this.f66970c = null;
        this.f66971d = null;
        this.f66973f = null;
        this.f66974g = null;
        this.f66975h = null;
        this.f66976i = null;
        this.f66968a = threadFragment.getBaseFragmentActivity();
        this.f66969b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.f66976i = (ProgressBar) view.findViewById(R.id.progress);
        this.f66975h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f66973f = NoDataViewFactory.a(this.f66968a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f66968a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f66974g = eVar;
        eVar.notifyDataSetChanged();
        this.f66972e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f66970c = bdListView;
        bdListView.setPullRefresh(this.f66972e);
        this.f66972e.a(threadFragment);
        this.f66971d = new TextView(this.f66968a.getActivity());
        this.f66971d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f66968a.getActivity(), R.dimen.ds88)));
        this.f66970c.x(this.f66971d, 0);
        this.f66970c.setAdapter((ListAdapter) this.f66974g);
        this.f66970c.setOnSrollToBottomListener(threadFragment);
        this.f66970c.setOnItemClickListener(threadFragment);
        this.f66970c.setOnScrollListener(this.n);
        this.f66974g.k(threadFragment);
        this.f66974g.r(threadFragment);
        this.f66974g.q(threadFragment);
    }

    public void a(boolean z) {
        this.f66974g.l(z);
        this.f66974g.notifyDataSetChanged();
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f66971d, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        BdListView bdListView = this.f66970c;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void d(boolean z, String str, d.a.n0.x1.g.a aVar) {
        if (z) {
            BaseFragmentActivity baseFragmentActivity = this.f66968a;
            baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
            if (aVar != null && aVar.n() != null) {
                this.f66974g.j(aVar.n());
                if (aVar.n().size() == 0) {
                    if (this.l == null) {
                        this.l = new c(aVar);
                    } else {
                        d.a.c.e.m.e.a().removeCallbacks(this.l);
                    }
                    d.a.c.e.m.e.a().postDelayed(this.l, 600L);
                }
            } else {
                this.f66976i.setVisibility(8);
                return;
            }
        } else {
            this.f66968a.showToast(str);
        }
        this.f66974g.m(false);
        this.f66976i.setVisibility(8);
    }

    public void e(String str, d.a.n0.x1.g.a aVar, boolean z) {
        this.f66974g.p(true);
        if (str != null) {
            this.f66968a.showToast(str);
        }
        if (aVar != null) {
            if (aVar.p() == 0 && !z) {
                aVar.m();
            }
            if (aVar.p() < 20) {
                this.f66974g.n(false);
                this.f66974g.m(true);
            } else {
                this.f66974g.n(true);
                this.f66974g.m(true);
            }
            this.f66974g.j(aVar.n());
            p(aVar, z);
        }
        this.f66974g.p(false);
        this.f66974g.notifyDataSetChanged();
        if (k()) {
            r(false);
        }
    }

    public void f(boolean z, String str, boolean z2) {
        this.f66968a.closeLoadingDialog();
        if (str != null) {
            this.f66968a.showToast(str);
        }
        if (z2) {
            t();
        }
        this.f66974g.notifyDataSetChanged();
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
        this.f66976i.setVisibility(8);
    }

    public boolean k() {
        return this.m;
    }

    public void l(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f66968a.getPageContext().getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void m() {
        this.f66974g.notifyDataSetChanged();
    }

    public void n(int i2) {
        SkinManager.setBackgroundColor(this.f66975h, R.color.CAM_X0201);
        g gVar = this.f66972e;
        if (gVar != null) {
            gVar.I(i2);
        }
        m();
        NoDataView noDataView = this.f66973f;
        if (noDataView != null) {
            noDataView.f(this.f66968a.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f66973f, R.color.CAM_X0201);
        }
    }

    public void o() {
        d.a.m0.r.s.a aVar = this.j;
        if (aVar != null) {
            aVar.dismiss();
            this.j = null;
        }
        ProgressBar progressBar = this.f66976i;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (this.l != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.l);
        }
        e eVar = this.f66974g;
        if (eVar != null) {
            eVar.i();
        }
    }

    public void p(d.a.n0.x1.g.a aVar, boolean z) {
        if (aVar == null) {
            s();
        } else if (aVar.m() > 0) {
            this.f66973f.setVisibility(8);
            this.f66970c.removeHeaderView(this.f66973f);
            this.f66974g.notifyDataSetChanged();
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
        this.f66973f.d(this.f66968a.getPageContext());
        this.f66970c.removeHeaderView(this.f66973f);
        this.f66970c.addHeaderView(this.f66973f);
        this.f66973f.setVisibility(0);
    }

    public final void t() {
        if (this.j == null) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f66968a.getPageContext().getPageActivity());
            this.j = aVar;
            aVar.setTitle(this.f66968a.getPageContext().getString(R.string.sync_mark_fail));
            this.j.setMessage(this.f66968a.getPageContext().getString(R.string.neterror));
            if (this.k != null) {
                this.j.setPositiveButton(this.f66968a.getPageContext().getString(R.string.retry_rightnow), this.k);
            }
            this.j.setNegativeButton(this.f66968a.getPageContext().getString(R.string.confirm), new b(this));
            this.j.create(this.f66968a.getPageContext());
            this.j.setCanceledOnTouchOutside(true);
        }
        this.j.show();
    }

    public void u() {
        this.f66976i.setVisibility(0);
    }

    public void v(int i2) {
        if (i2 == 0) {
            this.f66970c.F();
            return;
        }
        this.f66974g.p(true);
        this.f66974g.notifyDataSetChanged();
    }

    public void w(ArrayList<MarkData> arrayList) {
        this.f66974g.j(arrayList);
    }

    public void x() {
        if (this.f66973f.isShown()) {
            this.f66973f.d(this.f66968a.getPageContext());
        }
    }
}
