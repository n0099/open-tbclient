package d.a.j0.w1;

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
import d.a.i0.r.f0.g;
import d.a.i0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f62344a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f62345b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f62346c;

    /* renamed from: d  reason: collision with root package name */
    public View f62347d;

    /* renamed from: e  reason: collision with root package name */
    public g f62348e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f62349f;

    /* renamed from: g  reason: collision with root package name */
    public e f62350g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f62351h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f62352i;
    public c l;
    public d.a.i0.r.s.a j = null;
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
                if (f.this.f62345b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                f.this.f62345b.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            NavigationBarShadowView navigationBarShadowView = f.this.f62345b;
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

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.j0.w1.g.a f62354e;

        public c(d.a.j0.w1.g.a aVar) {
            this.f62354e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.j0.w1.g.a aVar = this.f62354e;
            if (aVar != null) {
                aVar.w(Boolean.TRUE);
            }
        }
    }

    public f(ThreadFragment threadFragment, View view) {
        this.f62344a = null;
        this.f62346c = null;
        this.f62347d = null;
        this.f62349f = null;
        this.f62350g = null;
        this.f62351h = null;
        this.f62352i = null;
        this.f62344a = threadFragment.getBaseFragmentActivity();
        this.f62345b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.f62352i = (ProgressBar) view.findViewById(R.id.progress);
        this.f62351h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f62349f = NoDataViewFactory.a(this.f62344a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f62344a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f62350g = eVar;
        eVar.notifyDataSetChanged();
        this.f62348e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f62346c = bdListView;
        bdListView.setPullRefresh(this.f62348e);
        this.f62348e.a(threadFragment);
        this.f62347d = new TextView(this.f62344a.getActivity());
        this.f62347d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f62344a.getActivity(), R.dimen.ds88)));
        this.f62346c.x(this.f62347d, 0);
        this.f62346c.setAdapter((ListAdapter) this.f62350g);
        this.f62346c.setOnSrollToBottomListener(threadFragment);
        this.f62346c.setOnItemClickListener(threadFragment);
        this.f62346c.setOnScrollListener(this.n);
        this.f62350g.k(threadFragment);
        this.f62350g.r(threadFragment);
        this.f62350g.q(threadFragment);
    }

    public void a(boolean z) {
        this.f62350g.l(z);
        this.f62350g.notifyDataSetChanged();
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f62347d, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        BdListView bdListView = this.f62346c;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void d(boolean z, String str, d.a.j0.w1.g.a aVar) {
        if (z) {
            BaseFragmentActivity baseFragmentActivity = this.f62344a;
            baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
            if (aVar != null && aVar.n() != null) {
                this.f62350g.j(aVar.n());
                if (aVar.n().size() == 0) {
                    if (this.l == null) {
                        this.l = new c(aVar);
                    } else {
                        d.a.c.e.m.e.a().removeCallbacks(this.l);
                    }
                    d.a.c.e.m.e.a().postDelayed(this.l, 600L);
                }
            } else {
                this.f62352i.setVisibility(8);
                return;
            }
        } else {
            this.f62344a.showToast(str);
        }
        this.f62350g.m(false);
        this.f62352i.setVisibility(8);
    }

    public void e(String str, d.a.j0.w1.g.a aVar, boolean z) {
        this.f62350g.p(true);
        if (str != null) {
            this.f62344a.showToast(str);
        }
        if (aVar != null) {
            if (aVar.p() == 0 && !z) {
                aVar.m();
            }
            if (aVar.p() < 20) {
                this.f62350g.n(false);
                this.f62350g.m(true);
            } else {
                this.f62350g.n(true);
                this.f62350g.m(true);
            }
            this.f62350g.j(aVar.n());
            p(aVar, z);
        }
        this.f62350g.p(false);
        this.f62350g.notifyDataSetChanged();
        if (k()) {
            r(false);
        }
    }

    public void f(boolean z, String str, boolean z2) {
        this.f62344a.closeLoadingDialog();
        if (str != null) {
            this.f62344a.showToast(str);
        }
        if (z2) {
            t();
        }
        this.f62350g.notifyDataSetChanged();
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
        this.f62352i.setVisibility(8);
    }

    public boolean k() {
        return this.m;
    }

    public void l(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f62344a.getPageContext().getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void m() {
        this.f62350g.notifyDataSetChanged();
    }

    public void n(int i2) {
        SkinManager.setBackgroundColor(this.f62351h, R.color.CAM_X0201);
        g gVar = this.f62348e;
        if (gVar != null) {
            gVar.I(i2);
        }
        m();
        NoDataView noDataView = this.f62349f;
        if (noDataView != null) {
            noDataView.f(this.f62344a.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f62349f, R.color.CAM_X0201);
        }
    }

    public void o() {
        d.a.i0.r.s.a aVar = this.j;
        if (aVar != null) {
            aVar.dismiss();
            this.j = null;
        }
        ProgressBar progressBar = this.f62352i;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (this.l != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.l);
        }
        e eVar = this.f62350g;
        if (eVar != null) {
            eVar.i();
        }
    }

    public void p(d.a.j0.w1.g.a aVar, boolean z) {
        if (aVar == null) {
            s();
        } else if (aVar.m() > 0) {
            this.f62349f.setVisibility(8);
            this.f62346c.removeHeaderView(this.f62349f);
            this.f62350g.notifyDataSetChanged();
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
        this.f62349f.d(this.f62344a.getPageContext());
        this.f62346c.removeHeaderView(this.f62349f);
        this.f62346c.addHeaderView(this.f62349f);
        this.f62349f.setVisibility(0);
    }

    public final void t() {
        if (this.j == null) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f62344a.getPageContext().getPageActivity());
            this.j = aVar;
            aVar.setTitle(this.f62344a.getPageContext().getString(R.string.sync_mark_fail));
            this.j.setMessage(this.f62344a.getPageContext().getString(R.string.neterror));
            if (this.k != null) {
                this.j.setPositiveButton(this.f62344a.getPageContext().getString(R.string.retry_rightnow), this.k);
            }
            this.j.setNegativeButton(this.f62344a.getPageContext().getString(R.string.confirm), new b(this));
            this.j.create(this.f62344a.getPageContext());
            this.j.setCanceledOnTouchOutside(true);
        }
        this.j.show();
    }

    public void u() {
        this.f62352i.setVisibility(0);
    }

    public void v(int i2) {
        if (i2 == 0) {
            this.f62346c.F();
            return;
        }
        this.f62350g.p(true);
        this.f62350g.notifyDataSetChanged();
    }

    public void w(ArrayList<MarkData> arrayList) {
        this.f62350g.j(arrayList);
    }

    public void x() {
        if (this.f62349f.isShown()) {
            this.f62349f.d(this.f62344a.getPageContext());
        }
    }
}
