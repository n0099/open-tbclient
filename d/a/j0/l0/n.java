package d.a.j0.l0;

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
import d.a.i0.r.f0.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FaceShopActivity> f56408a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f56409b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f56410c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f56411d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f56412e;

    /* renamed from: f  reason: collision with root package name */
    public final m f56413f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f56414g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.i0.r.f0.g f56415h;

    /* renamed from: i  reason: collision with root package name */
    public final a f56416i;
    public final h j;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.j.e.b {

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f56417f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f56418g = null;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f56419h = null;

        /* renamed from: i  reason: collision with root package name */
        public View f56420i = null;
        public View j;

        public a(n nVar, TbPageContext<?> tbPageContext) {
            this.f56417f = tbPageContext;
        }

        @Override // d.a.c.j.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f56417f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.f56420i = inflate;
            inflate.setPadding(0, this.f56417f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f56417f.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.f56418g = (TextView) this.f56420i.findViewById(R.id.pb_more_text);
            View findViewById = this.f56420i.findViewById(R.id.pb_more_view);
            this.j = findViewById;
            findViewById.setVisibility(8);
            this.f56419h = (ProgressBar) this.f56420i.findViewById(R.id.progress);
            h(TbadkApplication.getInst().getSkinType());
            this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.f56420i;
        }

        @Override // d.a.c.j.e.b
        public void c() {
        }

        public void d() {
            this.f56420i.setVisibility(0);
        }

        public void e() {
            this.f56420i.setVisibility(8);
        }

        public void f() {
            this.f56419h.setVisibility(8);
            this.f56418g.setText(R.string.load_more);
        }

        public void g() {
            this.f56419h.setVisibility(0);
            this.f56418g.setText(this.f56417f.getPageActivity().getText(R.string.loading));
            this.j.setVisibility(0);
        }

        public void h(int i2) {
            TbPageContext<?> tbPageContext = this.f56417f;
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                this.f56417f.getLayoutMode().j(this.j);
            }
        }
    }

    public n(TbPageContext<FaceShopActivity> tbPageContext) {
        this.f56408a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f56409b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f56410c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f56410c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f56410c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f56411d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f56414g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f56412e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f56415h = new d.a.i0.r.f0.g(tbPageContext);
        this.f56413f = new m(tbPageContext.getOrignalPage());
        this.f56416i = new a(this, tbPageContext);
        this.f56412e.setAdapter((ListAdapter) this.f56413f);
        this.f56412e.setPullRefresh(this.f56415h);
        this.f56412e.setNextPage(this.f56416i);
        try {
            this.f56411d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new h(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        this.f56414g.a(bVar);
    }

    public void b() {
        this.f56416i.f();
        this.f56412e.A(0L);
    }

    public m c() {
        return this.f56413f;
    }

    public TextView d() {
        return this.f56411d;
    }

    public void e() {
        h hVar = this.j;
        if (hVar != null) {
            d.a.c.e.m.g.b(hVar, this.f56408a);
        }
    }

    public void f() {
        a aVar = this.f56416i;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void g(int i2) {
        d.a.i0.r.c layoutMode = this.f56408a.getLayoutMode();
        layoutMode.k(i2 == 1);
        layoutMode.j(this.f56409b);
        NavigationBar navigationBar = this.f56410c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56408a, i2);
        }
        d.a.i0.r.f0.g gVar = this.f56415h;
        if (gVar != null) {
            gVar.I(i2);
        }
        a aVar = this.f56416i;
        if (aVar != null) {
            aVar.h(i2);
        }
        NoNetworkView noNetworkView = this.f56414g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f56408a, i2);
        }
    }

    public void h() {
        NoNetworkView noNetworkView = this.f56414g;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && d.a.c.e.p.j.z()) {
            this.f56414g.e(false);
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
        this.f56414g.d(bVar);
    }

    public void l() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        this.f56412e.setOnItemClickListener(onItemClickListener);
    }

    public void n() {
        this.f56416i.g();
    }

    public void o(f.g gVar) {
        this.f56415h.a(gVar);
    }

    public void p(BdListView.p pVar) {
        this.f56412e.setOnSrollToBottomListener(pVar);
    }

    public void q() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.d();
            d.a.c.e.m.g.j(this.j, this.f56408a);
        }
    }

    public void r() {
        a aVar = this.f56416i;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void s() {
        this.f56412e.F();
    }
}
