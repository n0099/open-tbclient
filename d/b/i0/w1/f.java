package d.b.i0.w1;

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
import d.b.c.e.p.l;
import d.b.h0.r.f0.g;
import d.b.h0.r.s.a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f63670a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f63671b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f63672c;

    /* renamed from: d  reason: collision with root package name */
    public View f63673d;

    /* renamed from: e  reason: collision with root package name */
    public g f63674e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f63675f;

    /* renamed from: g  reason: collision with root package name */
    public e f63676g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f63677h;
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
                if (f.this.f63671b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                f.this.f63671b.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            NavigationBarShadowView navigationBarShadowView = f.this.f63671b;
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
        public d.b.i0.w1.g.a f63679e;

        public c(d.b.i0.w1.g.a aVar) {
            this.f63679e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.w1.g.a aVar = this.f63679e;
            if (aVar != null) {
                aVar.w(Boolean.TRUE);
            }
        }
    }

    public f(ThreadFragment threadFragment, View view) {
        this.f63670a = null;
        this.f63672c = null;
        this.f63673d = null;
        this.f63675f = null;
        this.f63676g = null;
        this.f63677h = null;
        this.i = null;
        this.f63670a = threadFragment.getBaseFragmentActivity();
        this.f63671b = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.i = (ProgressBar) view.findViewById(R.id.progress);
        this.f63677h = (RelativeLayout) view.findViewById(R.id.parent);
        this.f63675f = NoDataViewFactory.a(this.f63670a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, l.g(this.f63670a.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.e.b(R.string.mark_nodata, R.string.mark_nodata_2), null);
        e eVar = new e(threadFragment.getPageContext());
        this.f63676g = eVar;
        eVar.notifyDataSetChanged();
        this.f63674e = new g(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view.findViewById(R.id.list);
        this.f63672c = bdListView;
        bdListView.setPullRefresh(this.f63674e);
        this.f63674e.b(threadFragment);
        this.f63673d = new TextView(this.f63670a.getActivity());
        this.f63673d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.f63670a.getActivity(), R.dimen.ds88)));
        this.f63672c.x(this.f63673d, 0);
        this.f63672c.setAdapter((ListAdapter) this.f63676g);
        this.f63672c.setOnSrollToBottomListener(threadFragment);
        this.f63672c.setOnItemClickListener(threadFragment);
        this.f63672c.setOnScrollListener(this.n);
        this.f63676g.k(threadFragment);
        this.f63676g.r(threadFragment);
        this.f63676g.q(threadFragment);
    }

    public void a(boolean z) {
        this.f63676g.l(z);
        this.f63676g.notifyDataSetChanged();
    }

    public void b(boolean z) {
        BdListViewHelper.c(this.f63673d, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c() {
        BdListView bdListView = this.f63672c;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void d(boolean z, String str, d.b.i0.w1.g.a aVar) {
        if (z) {
            BaseFragmentActivity baseFragmentActivity = this.f63670a;
            baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.delete_success));
            if (aVar != null && aVar.n() != null) {
                this.f63676g.j(aVar.n());
                if (aVar.n().size() == 0) {
                    if (this.l == null) {
                        this.l = new c(aVar);
                    } else {
                        d.b.c.e.m.e.a().removeCallbacks(this.l);
                    }
                    d.b.c.e.m.e.a().postDelayed(this.l, 600L);
                }
            } else {
                this.i.setVisibility(8);
                return;
            }
        } else {
            this.f63670a.showToast(str);
        }
        this.f63676g.m(false);
        this.i.setVisibility(8);
    }

    public void e(String str, d.b.i0.w1.g.a aVar, boolean z) {
        this.f63676g.p(true);
        if (str != null) {
            this.f63670a.showToast(str);
        }
        if (aVar != null) {
            if (aVar.p() == 0 && !z) {
                aVar.m();
            }
            if (aVar.p() < 20) {
                this.f63676g.n(false);
                this.f63676g.m(true);
            } else {
                this.f63676g.n(true);
                this.f63676g.m(true);
            }
            this.f63676g.j(aVar.n());
            p(aVar, z);
        }
        this.f63676g.p(false);
        this.f63676g.notifyDataSetChanged();
        if (k()) {
            r(false);
        }
    }

    public void f(boolean z, String str, boolean z2) {
        this.f63670a.closeLoadingDialog();
        if (str != null) {
            this.f63670a.showToast(str);
        }
        if (z2) {
            t();
        }
        this.f63676g.notifyDataSetChanged();
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f63670a.getPageContext().getPageActivity()).createNormalConfig(d.b.c.e.m.b.f(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void m() {
        this.f63676g.notifyDataSetChanged();
    }

    public void n(int i) {
        SkinManager.setBackgroundColor(this.f63677h, R.color.CAM_X0201);
        g gVar = this.f63674e;
        if (gVar != null) {
            gVar.I(i);
        }
        m();
        NoDataView noDataView = this.f63675f;
        if (noDataView != null) {
            noDataView.f(this.f63670a.getPageContext(), i);
            SkinManager.setBackgroundColor(this.f63675f, R.color.CAM_X0201);
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
            d.b.c.e.m.e.a().removeCallbacks(this.l);
        }
        e eVar = this.f63676g;
        if (eVar != null) {
            eVar.i();
        }
    }

    public void p(d.b.i0.w1.g.a aVar, boolean z) {
        if (aVar == null) {
            s();
        } else if (aVar.m() > 0) {
            this.f63675f.setVisibility(8);
            this.f63672c.removeHeaderView(this.f63675f);
            this.f63676g.notifyDataSetChanged();
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
        this.f63675f.d(this.f63670a.getPageContext());
        this.f63672c.removeHeaderView(this.f63675f);
        this.f63672c.addHeaderView(this.f63675f);
        this.f63675f.setVisibility(0);
    }

    public final void t() {
        if (this.j == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f63670a.getPageContext().getPageActivity());
            this.j = aVar;
            aVar.setTitle(this.f63670a.getPageContext().getString(R.string.sync_mark_fail));
            this.j.setMessage(this.f63670a.getPageContext().getString(R.string.neterror));
            if (this.k != null) {
                this.j.setPositiveButton(this.f63670a.getPageContext().getString(R.string.retry_rightnow), this.k);
            }
            this.j.setNegativeButton(this.f63670a.getPageContext().getString(R.string.confirm), new b(this));
            this.j.create(this.f63670a.getPageContext());
            this.j.setCanceledOnTouchOutside(true);
        }
        this.j.show();
    }

    public void u() {
        this.i.setVisibility(0);
    }

    public void v(int i) {
        if (i == 0) {
            this.f63672c.F();
            return;
        }
        this.f63676g.p(true);
        this.f63676g.notifyDataSetChanged();
    }

    public void w(ArrayList<MarkData> arrayList) {
        this.f63676g.j(arrayList);
    }

    public void x() {
        if (this.f63675f.isShown()) {
            this.f63675f.d(this.f63670a.getPageContext());
        }
    }
}
