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
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f63253a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f63254b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f63255c;

    /* renamed from: d  reason: collision with root package name */
    public View f63256d;

    /* renamed from: e  reason: collision with root package name */
    public g f63257e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f63258f;

    /* renamed from: g  reason: collision with root package name */
    public e f63259g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f63260h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f63261i;
    public c l;
    public d.a.m0.r.s.a j = null;
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
                if (f.this.f63254b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                f.this.f63254b.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            NavigationBarShadowView navigationBarShadowView = f.this.f63254b;
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

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.n0.x1.g.a f63263e;

        public c(d.a.n0.x1.g.a aVar) {
            this.f63263e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.x1.g.a aVar = this.f63263e;
            if (aVar != null) {
                aVar.w(Boolean.TRUE);
            }
        }
    }

    public f(ThreadFragment threadFragment, View view) {
        this.f63253a = null;
        this.f63255c = null;
        this.f63256d = null;
        this.f63258f = null;
        this.f63259g = null;
        this.f63260h = null;
        this.f63261i = null;
        this.f63253a = threadFragment.getBaseFragmentActivity();
        this.f63254b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.f63261i = (ProgressBar) view.findViewById(R.id.progress);
        this.f63260h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f63258f = NoDataViewFactory.a(this.f63253a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f63253a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f63259g = eVar;
        eVar.notifyDataSetChanged();
        this.f63257e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f63255c = bdListView;
        bdListView.setPullRefresh(this.f63257e);
        this.f63257e.a(threadFragment);
        this.f63256d = new TextView(this.f63253a.getActivity());
        this.f63256d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f63253a.getActivity(), R.dimen.ds88)));
        this.f63255c.x(this.f63256d, 0);
        this.f63255c.setAdapter((ListAdapter) this.f63259g);
        this.f63255c.setOnSrollToBottomListener(threadFragment);
        this.f63255c.setOnItemClickListener(threadFragment);
        this.f63255c.setOnScrollListener(this.n);
        this.f63259g.k(threadFragment);
        this.f63259g.r(threadFragment);
        this.f63259g.q(threadFragment);
    }

    public void a(boolean z) {
        this.f63259g.l(z);
        this.f63259g.notifyDataSetChanged();
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f63256d, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        BdListView bdListView = this.f63255c;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void d(boolean z, String str, d.a.n0.x1.g.a aVar) {
        if (z) {
            BaseFragmentActivity baseFragmentActivity = this.f63253a;
            baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
            if (aVar != null && aVar.n() != null) {
                this.f63259g.j(aVar.n());
                if (aVar.n().size() == 0) {
                    if (this.l == null) {
                        this.l = new c(aVar);
                    } else {
                        d.a.c.e.m.e.a().removeCallbacks(this.l);
                    }
                    d.a.c.e.m.e.a().postDelayed(this.l, 600L);
                }
            } else {
                this.f63261i.setVisibility(8);
                return;
            }
        } else {
            this.f63253a.showToast(str);
        }
        this.f63259g.m(false);
        this.f63261i.setVisibility(8);
    }

    public void e(String str, d.a.n0.x1.g.a aVar, boolean z) {
        this.f63259g.p(true);
        if (str != null) {
            this.f63253a.showToast(str);
        }
        if (aVar != null) {
            if (aVar.p() == 0 && !z) {
                aVar.m();
            }
            if (aVar.p() < 20) {
                this.f63259g.n(false);
                this.f63259g.m(true);
            } else {
                this.f63259g.n(true);
                this.f63259g.m(true);
            }
            this.f63259g.j(aVar.n());
            p(aVar, z);
        }
        this.f63259g.p(false);
        this.f63259g.notifyDataSetChanged();
        if (k()) {
            r(false);
        }
    }

    public void f(boolean z, String str, boolean z2) {
        this.f63253a.closeLoadingDialog();
        if (str != null) {
            this.f63253a.showToast(str);
        }
        if (z2) {
            t();
        }
        this.f63259g.notifyDataSetChanged();
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
        this.f63261i.setVisibility(8);
    }

    public boolean k() {
        return this.m;
    }

    public void l(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f63253a.getPageContext().getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void m() {
        this.f63259g.notifyDataSetChanged();
    }

    public void n(int i2) {
        SkinManager.setBackgroundColor(this.f63260h, R.color.CAM_X0201);
        g gVar = this.f63257e;
        if (gVar != null) {
            gVar.I(i2);
        }
        m();
        NoDataView noDataView = this.f63258f;
        if (noDataView != null) {
            noDataView.f(this.f63253a.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f63258f, R.color.CAM_X0201);
        }
    }

    public void o() {
        d.a.m0.r.s.a aVar = this.j;
        if (aVar != null) {
            aVar.dismiss();
            this.j = null;
        }
        ProgressBar progressBar = this.f63261i;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (this.l != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.l);
        }
        e eVar = this.f63259g;
        if (eVar != null) {
            eVar.i();
        }
    }

    public void p(d.a.n0.x1.g.a aVar, boolean z) {
        if (aVar == null) {
            s();
        } else if (aVar.m() > 0) {
            this.f63258f.setVisibility(8);
            this.f63255c.removeHeaderView(this.f63258f);
            this.f63259g.notifyDataSetChanged();
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
        this.f63258f.d(this.f63253a.getPageContext());
        this.f63255c.removeHeaderView(this.f63258f);
        this.f63255c.addHeaderView(this.f63258f);
        this.f63258f.setVisibility(0);
    }

    public final void t() {
        if (this.j == null) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f63253a.getPageContext().getPageActivity());
            this.j = aVar;
            aVar.setTitle(this.f63253a.getPageContext().getString(R.string.sync_mark_fail));
            this.j.setMessage(this.f63253a.getPageContext().getString(R.string.neterror));
            if (this.k != null) {
                this.j.setPositiveButton(this.f63253a.getPageContext().getString(R.string.retry_rightnow), this.k);
            }
            this.j.setNegativeButton(this.f63253a.getPageContext().getString(R.string.confirm), new b(this));
            this.j.create(this.f63253a.getPageContext());
            this.j.setCanceledOnTouchOutside(true);
        }
        this.j.show();
    }

    public void u() {
        this.f63261i.setVisibility(0);
    }

    public void v(int i2) {
        if (i2 == 0) {
            this.f63255c.F();
            return;
        }
        this.f63259g.p(true);
        this.f63259g.notifyDataSetChanged();
    }

    public void w(ArrayList<MarkData> arrayList) {
        this.f63259g.j(arrayList);
    }

    public void x() {
        if (this.f63258f.isShown()) {
            this.f63258f.d(this.f63253a.getPageContext());
        }
    }
}
