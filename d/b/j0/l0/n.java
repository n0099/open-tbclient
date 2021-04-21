package d.b.j0.l0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FacePackageData;
import com.baidu.tieba.faceshop.FaceShopActivity;
import com.baidu.tieba.faceshop.FaceShopData;
import com.baidu.tieba.faceshop.QueryDownloadMessage;
import d.b.i0.r.f0.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FaceShopActivity> f58405a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f58406b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f58407c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f58408d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f58409e;

    /* renamed from: f  reason: collision with root package name */
    public final m f58410f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f58411g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.i0.r.f0.g f58412h;
    public final a i;
    public final h j;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.j.e.b {

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f58413f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f58414g = null;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f58415h = null;
        public View i = null;
        public View j;

        public a(n nVar, TbPageContext<?> tbPageContext) {
            this.f58413f = tbPageContext;
        }

        @Override // d.b.c.j.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f58413f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.i = inflate;
            inflate.setPadding(0, this.f58413f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f58413f.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.f58414g = (TextView) this.i.findViewById(R.id.pb_more_text);
            View findViewById = this.i.findViewById(R.id.pb_more_view);
            this.j = findViewById;
            findViewById.setVisibility(8);
            this.f58415h = (ProgressBar) this.i.findViewById(R.id.progress);
            h(TbadkApplication.getInst().getSkinType());
            this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.i;
        }

        @Override // d.b.c.j.e.b
        public void c() {
        }

        public void d() {
            this.i.setVisibility(0);
        }

        public void e() {
            this.i.setVisibility(8);
        }

        public void f() {
            this.f58415h.setVisibility(8);
            this.f58414g.setText(R.string.load_more);
        }

        public void g() {
            this.f58415h.setVisibility(0);
            this.f58414g.setText(this.f58413f.getPageActivity().getText(R.string.loading));
            this.j.setVisibility(0);
        }

        public void h(int i) {
            TbPageContext<?> tbPageContext = this.f58413f;
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i == 1);
                this.f58413f.getLayoutMode().j(this.j);
            }
        }
    }

    public n(TbPageContext<FaceShopActivity> tbPageContext) {
        this.f58405a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f58406b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f58407c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f58407c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f58407c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f58408d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f58411g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f58409e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f58412h = new d.b.i0.r.f0.g(tbPageContext);
        this.f58410f = new m(tbPageContext.getOrignalPage());
        this.i = new a(this, tbPageContext);
        this.f58409e.setAdapter((ListAdapter) this.f58410f);
        this.f58409e.setPullRefresh(this.f58412h);
        this.f58409e.setNextPage(this.i);
        try {
            this.f58408d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new h(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        this.f58411g.a(bVar);
    }

    public void b() {
        this.i.f();
        this.f58409e.A(0L);
    }

    public m c() {
        return this.f58410f;
    }

    public TextView d() {
        return this.f58408d;
    }

    public void e() {
        h hVar = this.j;
        if (hVar != null) {
            d.b.c.e.m.g.b(hVar, this.f58405a);
        }
    }

    public void f() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void g(int i) {
        d.b.i0.r.c layoutMode = this.f58405a.getLayoutMode();
        layoutMode.k(i == 1);
        layoutMode.j(this.f58406b);
        NavigationBar navigationBar = this.f58407c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58405a, i);
        }
        d.b.i0.r.f0.g gVar = this.f58412h;
        if (gVar != null) {
            gVar.I(i);
        }
        a aVar = this.i;
        if (aVar != null) {
            aVar.h(i);
        }
        NoNetworkView noNetworkView = this.f58411g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f58405a, i);
        }
    }

    public void h() {
        NoNetworkView noNetworkView = this.f58411g;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && d.b.c.e.p.j.z()) {
            this.f58411g.e(false);
        }
    }

    public void i(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
    }

    public void j(FaceShopData faceShopData) {
        ArrayList<FacePackageData> arrayList;
        b();
        if (faceShopData == null || (arrayList = faceShopData.pack_list) == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<FacePackageData> it = faceShopData.pack_list.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(it.next().pid));
        }
        i(arrayList2);
    }

    public void k(NoNetworkView.b bVar) {
        this.f58411g.d(bVar);
    }

    public void l() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        this.f58409e.setOnItemClickListener(onItemClickListener);
    }

    public void n() {
        this.i.g();
    }

    public void o(f.g gVar) {
        this.f58412h.b(gVar);
    }

    public void p(BdListView.p pVar) {
        this.f58409e.setOnSrollToBottomListener(pVar);
    }

    public void q() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.d();
            d.b.c.e.m.g.j(this.j, this.f58405a);
        }
    }

    public void r() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void s() {
        this.f58409e.F();
    }
}
