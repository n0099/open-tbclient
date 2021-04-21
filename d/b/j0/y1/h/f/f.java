package d.b.j0.y1.h.f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import d.b.c.e.p.l;
import d.b.i0.d0.g;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements Object<List<EmotionPackageData>> {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f64618e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f64619f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.y1.h.d.b f64620g;

    /* renamed from: h  reason: collision with root package name */
    public b f64621h;
    public View i;
    public g j;
    public FrameLayout k;
    public NoDataView l;
    public boolean m = false;
    public NoNetworkView n;

    public f(TbPageContext tbPageContext) {
        this.f64618e = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.fragment_single_thread_emotions, (ViewGroup) null, false);
        this.i = inflate;
        NoNetworkView noNetworkView = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        this.n = noNetworkView;
        noNetworkView.a(this);
        this.k = (FrameLayout) this.i.findViewById(R.id.single_emotion_loading);
        this.f64619f = (BdListView) this.i.findViewById(R.id.emotion_single_thread_list);
        this.f64621h = new b(this.i.findViewById(R.id.emotion_single_thread_empty), tbPageContext.getString(R.string.emotion_empty_single_thread));
        this.f64619f.setDivider(null);
        this.f64619f.setOverScrollMode(2);
        this.f64619f.setVerticalScrollBarEnabled(false);
        this.f64620g = new d.b.j0.y1.h.d.b(tbPageContext, this.f64619f);
        h();
    }

    public View a() {
        return this.i;
    }

    public void b(boolean z) {
        if (z) {
            h();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    public void c() {
        FrameLayout frameLayout;
        if (this.j == null || (frameLayout = this.k) == null) {
            return;
        }
        frameLayout.setVisibility(8);
        this.j.dettachView(this.k);
        this.j = null;
    }

    public final void d() {
        NoDataView noDataView = this.l;
        if (noDataView == null || noDataView.getParent() != this.k) {
            return;
        }
        this.l.setVisibility(8);
        this.k.removeView(this.l);
        this.k.setVisibility(8);
    }

    public void e(int i) {
        View view = this.i;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.cp_bg_line_d_alpha90, i);
        }
        BdListView bdListView = this.f64619f;
        if (bdListView != null) {
            SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0201, i);
        }
        b bVar = this.f64621h;
        if (bVar != null) {
            bVar.b(i);
        }
        NoNetworkView noNetworkView = this.n;
        if (noNetworkView != null) {
            noNetworkView.c(this.f64618e, i);
        }
        FrameLayout frameLayout = this.k;
        if (frameLayout != null) {
            SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i);
        }
    }

    public final void f() {
        c();
        d();
    }

    public final void g() {
        b bVar;
        BdListView bdListView = this.f64619f;
        if (bdListView == null || this.m || (bVar = this.f64621h) == null) {
            return;
        }
        this.m = true;
        bdListView.setEmptyView(bVar.a());
    }

    public final void h() {
        if (this.f64618e == null || this.k == null) {
            return;
        }
        f();
        this.k.setVisibility(0);
        if (this.j == null) {
            this.j = new g(this.f64618e.getPageActivity());
        }
        this.j.attachView(this.k, true);
        this.j.onChangeSkinType();
    }

    public void i() {
        if (this.f64618e == null || this.k == null) {
            return;
        }
        f();
        this.k.setVisibility(0);
        NoDataView b2 = NoDataViewFactory.b(this.f64618e.getPageActivity(), this.k, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, l.g(this.f64618e.getPageActivity(), R.dimen.ds110)), NoDataViewFactory.e.d(null, this.f64618e.getString(R.string.emotion_error_net_tip)), null, true);
        this.l = b2;
        b2.setVisibility(0);
        this.l.d(this.f64618e);
    }

    public void j(List<EmotionPackageData> list) {
        d.b.j0.y1.h.d.b bVar;
        g();
        if (list == null || (bVar = this.f64620g) == null) {
            return;
        }
        bVar.a(list);
    }
}
