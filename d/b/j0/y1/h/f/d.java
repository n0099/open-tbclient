package d.b.j0.y1.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import d.b.c.e.p.l;
import d.b.i0.b1.e.a;
import d.b.i0.d0.g;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements Object<List<EmotionPackageData>> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f64605e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDragSortListView f64606f;

    /* renamed from: g  reason: collision with root package name */
    public View f64607g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.y1.h.d.a f64608h;
    public d.b.j0.y1.h.f.b i;
    public g j;
    public FrameLayout k;
    public boolean l = false;
    public d.b.j0.y1.h.b.a m;
    public NoDataView n;
    public NoNetworkView o;

    /* loaded from: classes3.dex */
    public class a implements a.i {
        public a() {
        }

        @Override // d.b.i0.b1.e.a.i
        public void drop(int i, int i2) {
            d.this.f64608h.a(i, i2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f64610e;

        public b(List list) {
            this.f64610e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.j();
            if (d.this.f64608h == null || this.f64610e == null) {
                return;
            }
            d.this.f64608h.c(this.f64610e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64608h != null) {
                d.this.f64608h.b();
            }
        }
    }

    public d(TbPageContext tbPageContext) {
        this.f64605e = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_my_emotions, (ViewGroup) null, false);
        this.f64607g = inflate;
        this.k = (FrameLayout) inflate.findViewById(R.id.my_emotion_loading);
        this.o = (NoNetworkView) this.f64607g.findViewById(R.id.view_no_network);
        this.i = new d.b.j0.y1.h.f.b(this.f64607g.findViewById(R.id.emotion_my_emotion_empty), tbPageContext.getString(R.string.emotion_empty_mine));
        SimpleDragSortListView simpleDragSortListView = (SimpleDragSortListView) this.f64607g.findViewById(R.id.my_emotion_list);
        this.f64606f = simpleDragSortListView;
        simpleDragSortListView.setDivider(null);
        this.f64606f.setOverScrollMode(2);
        this.f64606f.setVerticalScrollBarEnabled(false);
        k();
        this.f64608h = new d.b.j0.y1.h.d.a(tbPageContext, this.f64606f, this.m);
        l();
        this.o.a(this);
    }

    public void b(boolean z) {
        if (z) {
            l();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
        }
    }

    public View d() {
        return this.f64607g;
    }

    public void e() {
        FrameLayout frameLayout;
        if (this.j == null || (frameLayout = this.k) == null) {
            return;
        }
        frameLayout.setVisibility(8);
        this.j.dettachView(this.k);
        this.j = null;
    }

    public final void f() {
        NoDataView noDataView = this.n;
        if (noDataView == null || noDataView.getParent() != this.k) {
            return;
        }
        this.n.setVisibility(8);
        this.k.removeView(this.n);
        this.k.setVisibility(8);
    }

    public void g(int i) {
        d.b.j0.y1.h.f.b bVar = this.i;
        if (bVar != null) {
            bVar.b(i);
        }
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i);
        }
        d.b.j0.y1.h.f.b bVar2 = this.i;
        if (bVar2 != null) {
            SkinManager.setBackgroundColor(bVar2.a(), R.color.CAM_X0201, i);
        }
        SimpleDragSortListView simpleDragSortListView = this.f64606f;
        if (simpleDragSortListView != null) {
            SkinManager.setBackgroundColor(simpleDragSortListView, R.color.CAM_X0201, i);
        }
        NoNetworkView noNetworkView = this.o;
        if (noNetworkView != null) {
            noNetworkView.c(this.f64605e, i);
        }
    }

    public void h() {
        d.b.c.e.m.e.a().post(new c());
    }

    public final void i() {
        e();
        f();
    }

    public final void j() {
        d.b.j0.y1.h.f.b bVar;
        SimpleDragSortListView simpleDragSortListView = this.f64606f;
        if (simpleDragSortListView == null || this.l || (bVar = this.i) == null) {
            return;
        }
        this.l = true;
        simpleDragSortListView.setEmptyView(bVar.a());
    }

    public final void k() {
        d.b.j0.y1.h.b.a aVar = new d.b.j0.y1.h.b.a(this.f64606f);
        this.m = aVar;
        aVar.c(new a());
    }

    public final void l() {
        if (this.f64605e == null || this.k == null) {
            return;
        }
        i();
        this.k.setVisibility(0);
        g gVar = new g(this.f64605e.getPageActivity());
        this.j = gVar;
        gVar.attachView(this.k, true);
        this.j.onChangeSkinType();
    }

    public void m() {
        if (this.f64605e == null || this.k == null) {
            return;
        }
        i();
        this.k.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.f64605e.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f64605e.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f64605e.getString(R.string.emotion_error_net_tip)), null, true);
        this.n = b2;
        b2.setVisibility(0);
        this.n.d(this.f64605e);
    }

    public void n(List<EmotionPackageData> list) {
        d.b.c.e.m.e.a().post(new b(list));
    }
}
