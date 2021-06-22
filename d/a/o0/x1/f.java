package d.a.o0.x1;

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
import d.a.n0.r.f0.g;
import d.a.n0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f67093a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f67094b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f67095c;

    /* renamed from: d  reason: collision with root package name */
    public View f67096d;

    /* renamed from: e  reason: collision with root package name */
    public g f67097e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f67098f;

    /* renamed from: g  reason: collision with root package name */
    public e f67099g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f67100h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f67101i;
    public c l;
    public d.a.n0.r.s.a j = null;
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
                if (f.this.f67094b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                f.this.f67094b.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            NavigationBarShadowView navigationBarShadowView = f.this.f67094b;
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

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.o0.x1.g.a f67103e;

        public c(d.a.o0.x1.g.a aVar) {
            this.f67103e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.o0.x1.g.a aVar = this.f67103e;
            if (aVar != null) {
                aVar.w(Boolean.TRUE);
            }
        }
    }

    public f(ThreadFragment threadFragment, View view) {
        this.f67093a = null;
        this.f67095c = null;
        this.f67096d = null;
        this.f67098f = null;
        this.f67099g = null;
        this.f67100h = null;
        this.f67101i = null;
        this.f67093a = threadFragment.getBaseFragmentActivity();
        this.f67094b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.f67101i = (ProgressBar) view.findViewById(R.id.progress);
        this.f67100h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f67098f = NoDataViewFactory.a(this.f67093a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f67093a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f67099g = eVar;
        eVar.notifyDataSetChanged();
        this.f67097e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f67095c = bdListView;
        bdListView.setPullRefresh(this.f67097e);
        this.f67097e.a(threadFragment);
        this.f67096d = new TextView(this.f67093a.getActivity());
        this.f67096d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f67093a.getActivity(), R.dimen.ds88)));
        this.f67095c.x(this.f67096d, 0);
        this.f67095c.setAdapter((ListAdapter) this.f67099g);
        this.f67095c.setOnSrollToBottomListener(threadFragment);
        this.f67095c.setOnItemClickListener(threadFragment);
        this.f67095c.setOnScrollListener(this.n);
        this.f67099g.k(threadFragment);
        this.f67099g.r(threadFragment);
        this.f67099g.q(threadFragment);
    }

    public void a(boolean z) {
        this.f67099g.l(z);
        this.f67099g.notifyDataSetChanged();
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f67096d, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        BdListView bdListView = this.f67095c;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void d(boolean z, String str, d.a.o0.x1.g.a aVar) {
        if (z) {
            BaseFragmentActivity baseFragmentActivity = this.f67093a;
            baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
            if (aVar != null && aVar.n() != null) {
                this.f67099g.j(aVar.n());
                if (aVar.n().size() == 0) {
                    if (this.l == null) {
                        this.l = new c(aVar);
                    } else {
                        d.a.c.e.m.e.a().removeCallbacks(this.l);
                    }
                    d.a.c.e.m.e.a().postDelayed(this.l, 600L);
                }
            } else {
                this.f67101i.setVisibility(8);
                return;
            }
        } else {
            this.f67093a.showToast(str);
        }
        this.f67099g.m(false);
        this.f67101i.setVisibility(8);
    }

    public void e(String str, d.a.o0.x1.g.a aVar, boolean z) {
        this.f67099g.p(true);
        if (str != null) {
            this.f67093a.showToast(str);
        }
        if (aVar != null) {
            if (aVar.p() == 0 && !z) {
                aVar.m();
            }
            if (aVar.p() < 20) {
                this.f67099g.n(false);
                this.f67099g.m(true);
            } else {
                this.f67099g.n(true);
                this.f67099g.m(true);
            }
            this.f67099g.j(aVar.n());
            p(aVar, z);
        }
        this.f67099g.p(false);
        this.f67099g.notifyDataSetChanged();
        if (k()) {
            r(false);
        }
    }

    public void f(boolean z, String str, boolean z2) {
        this.f67093a.closeLoadingDialog();
        if (str != null) {
            this.f67093a.showToast(str);
        }
        if (z2) {
            t();
        }
        this.f67099g.notifyDataSetChanged();
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
        this.f67101i.setVisibility(8);
    }

    public boolean k() {
        return this.m;
    }

    public void l(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f67093a.getPageContext().getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void m() {
        this.f67099g.notifyDataSetChanged();
    }

    public void n(int i2) {
        SkinManager.setBackgroundColor(this.f67100h, R.color.CAM_X0201);
        g gVar = this.f67097e;
        if (gVar != null) {
            gVar.I(i2);
        }
        m();
        NoDataView noDataView = this.f67098f;
        if (noDataView != null) {
            noDataView.f(this.f67093a.getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f67098f, R.color.CAM_X0201);
        }
    }

    public void o() {
        d.a.n0.r.s.a aVar = this.j;
        if (aVar != null) {
            aVar.dismiss();
            this.j = null;
        }
        ProgressBar progressBar = this.f67101i;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (this.l != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.l);
        }
        e eVar = this.f67099g;
        if (eVar != null) {
            eVar.i();
        }
    }

    public void p(d.a.o0.x1.g.a aVar, boolean z) {
        if (aVar == null) {
            s();
        } else if (aVar.m() > 0) {
            this.f67098f.setVisibility(8);
            this.f67095c.removeHeaderView(this.f67098f);
            this.f67099g.notifyDataSetChanged();
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
        this.f67098f.d(this.f67093a.getPageContext());
        this.f67095c.removeHeaderView(this.f67098f);
        this.f67095c.addHeaderView(this.f67098f);
        this.f67098f.setVisibility(0);
    }

    public final void t() {
        if (this.j == null) {
            d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f67093a.getPageContext().getPageActivity());
            this.j = aVar;
            aVar.setTitle(this.f67093a.getPageContext().getString(R.string.sync_mark_fail));
            this.j.setMessage(this.f67093a.getPageContext().getString(R.string.neterror));
            if (this.k != null) {
                this.j.setPositiveButton(this.f67093a.getPageContext().getString(R.string.retry_rightnow), this.k);
            }
            this.j.setNegativeButton(this.f67093a.getPageContext().getString(R.string.confirm), new b(this));
            this.j.create(this.f67093a.getPageContext());
            this.j.setCanceledOnTouchOutside(true);
        }
        this.j.show();
    }

    public void u() {
        this.f67101i.setVisibility(0);
    }

    public void v(int i2) {
        if (i2 == 0) {
            this.f67095c.F();
            return;
        }
        this.f67099g.p(true);
        this.f67099g.notifyDataSetChanged();
    }

    public void w(ArrayList<MarkData> arrayList) {
        this.f67099g.j(arrayList);
    }

    public void x() {
        if (this.f67098f.isShown()) {
            this.f67098f.d(this.f67093a.getPageContext());
        }
    }
}
