package d.a.j0.y1.h.f;

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
import d.a.c.e.p.l;
import d.a.i0.b1.e.a;
import d.a.i0.d0.g;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements Object<List<EmotionPackageData>> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f62886e;

    /* renamed from: f  reason: collision with root package name */
    public SimpleDragSortListView f62887f;

    /* renamed from: g  reason: collision with root package name */
    public View f62888g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.y1.h.d.a f62889h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.y1.h.f.b f62890i;
    public g j;
    public FrameLayout k;
    public boolean l = false;
    public d.a.j0.y1.h.b.a m;
    public NoDataView n;
    public NoNetworkView o;

    /* loaded from: classes3.dex */
    public class a implements a.i {
        public a() {
        }

        @Override // d.a.i0.b1.e.a.i
        public void drop(int i2, int i3) {
            d.this.f62889h.a(i2, i3);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f62892e;

        public b(List list) {
            this.f62892e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.j();
            if (d.this.f62889h == null || this.f62892e == null) {
                return;
            }
            d.this.f62889h.c(this.f62892e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f62889h != null) {
                d.this.f62889h.b();
            }
        }
    }

    public d(TbPageContext tbPageContext) {
        this.f62886e = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_my_emotions, (ViewGroup) null, false);
        this.f62888g = inflate;
        this.k = (FrameLayout) inflate.findViewById(R.id.my_emotion_loading);
        this.o = (NoNetworkView) this.f62888g.findViewById(R.id.view_no_network);
        this.f62890i = new d.a.j0.y1.h.f.b(this.f62888g.findViewById(R.id.emotion_my_emotion_empty), tbPageContext.getString(R.string.emotion_empty_mine));
        SimpleDragSortListView simpleDragSortListView = (SimpleDragSortListView) this.f62888g.findViewById(R.id.my_emotion_list);
        this.f62887f = simpleDragSortListView;
        simpleDragSortListView.setDivider(null);
        this.f62887f.setOverScrollMode(2);
        this.f62887f.setVerticalScrollBarEnabled(false);
        k();
        this.f62889h = new d.a.j0.y1.h.d.a(tbPageContext, this.f62887f, this.m);
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
        return this.f62888g;
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

    public void g(int i2) {
        d.a.j0.y1.h.f.b bVar = this.f62890i;
        if (bVar != null) {
            bVar.b(i2);
        }
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i2);
        }
        d.a.j0.y1.h.f.b bVar2 = this.f62890i;
        if (bVar2 != null) {
            SkinManager.setBackgroundColor(bVar2.a(), R.color.CAM_X0201, i2);
        }
        SimpleDragSortListView simpleDragSortListView = this.f62887f;
        if (simpleDragSortListView != null) {
            SkinManager.setBackgroundColor(simpleDragSortListView, R.color.CAM_X0201, i2);
        }
        NoNetworkView noNetworkView = this.o;
        if (noNetworkView != null) {
            noNetworkView.c(this.f62886e, i2);
        }
    }

    public void h() {
        d.a.c.e.m.e.a().post(new c());
    }

    public final void i() {
        e();
        f();
    }

    public final void j() {
        d.a.j0.y1.h.f.b bVar;
        SimpleDragSortListView simpleDragSortListView = this.f62887f;
        if (simpleDragSortListView == null || this.l || (bVar = this.f62890i) == null) {
            return;
        }
        this.l = true;
        simpleDragSortListView.setEmptyView(bVar.a());
    }

    public final void k() {
        d.a.j0.y1.h.b.a aVar = new d.a.j0.y1.h.b.a(this.f62887f);
        this.m = aVar;
        aVar.c(new a());
    }

    public final void l() {
        if (this.f62886e == null || this.k == null) {
            return;
        }
        i();
        this.k.setVisibility(0);
        g gVar = new g(this.f62886e.getPageActivity());
        this.j = gVar;
        gVar.attachView(this.k, true);
        this.j.onChangeSkinType();
    }

    public void m() {
        if (this.f62886e == null || this.k == null) {
            return;
        }
        i();
        this.k.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.f62886e.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f62886e.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f62886e.getString(R.string.emotion_error_net_tip)), null, true);
        this.n = b2;
        b2.setVisibility(0);
        this.n.d(this.f62886e);
    }

    public void n(List<EmotionPackageData> list) {
        d.a.c.e.m.e.a().post(new b(list));
    }
}
