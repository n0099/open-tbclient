package d.b.i0.l0;

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
import d.b.h0.r.f0.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FaceShopActivity> f56577a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f56578b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f56579c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f56580d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f56581e;

    /* renamed from: f  reason: collision with root package name */
    public final m f56582f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f56583g;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.h0.r.f0.g f56584h;
    public final a i;
    public final h j;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.j.e.b {

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f56585f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f56586g = null;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f56587h = null;
        public View i = null;
        public View j;

        public a(n nVar, TbPageContext<?> tbPageContext) {
            this.f56585f = tbPageContext;
        }

        @Override // d.b.b.j.e.b
        public View a() {
            View inflate = LayoutInflater.from(this.f56585f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.i = inflate;
            inflate.setPadding(0, this.f56585f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f56585f.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.f56586g = (TextView) this.i.findViewById(R.id.pb_more_text);
            View findViewById = this.i.findViewById(R.id.pb_more_view);
            this.j = findViewById;
            findViewById.setVisibility(8);
            this.f56587h = (ProgressBar) this.i.findViewById(R.id.progress);
            h(TbadkApplication.getInst().getSkinType());
            this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.i;
        }

        @Override // d.b.b.j.e.b
        public void c() {
        }

        public void d() {
            this.i.setVisibility(0);
        }

        public void e() {
            this.i.setVisibility(8);
        }

        public void f() {
            this.f56587h.setVisibility(8);
            this.f56586g.setText(R.string.load_more);
        }

        public void g() {
            this.f56587h.setVisibility(0);
            this.f56586g.setText(this.f56585f.getPageActivity().getText(R.string.loading));
            this.j.setVisibility(0);
        }

        public void h(int i) {
            TbPageContext<?> tbPageContext = this.f56585f;
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i == 1);
                this.f56585f.getLayoutMode().j(this.j);
            }
        }
    }

    public n(TbPageContext<FaceShopActivity> tbPageContext) {
        this.f56577a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f56578b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f56579c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f56579c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f56579c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f56580d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f56583g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f56581e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f56584h = new d.b.h0.r.f0.g(tbPageContext);
        this.f56582f = new m(tbPageContext.getOrignalPage());
        this.i = new a(this, tbPageContext);
        this.f56581e.setAdapter((ListAdapter) this.f56582f);
        this.f56581e.setPullRefresh(this.f56584h);
        this.f56581e.setNextPage(this.i);
        try {
            this.f56580d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new h(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        this.f56583g.a(bVar);
    }

    public void b() {
        this.i.f();
        this.f56581e.A(0L);
    }

    public m c() {
        return this.f56582f;
    }

    public TextView d() {
        return this.f56580d;
    }

    public void e() {
        h hVar = this.j;
        if (hVar != null) {
            d.b.b.e.m.g.b(hVar, this.f56577a);
        }
    }

    public void f() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void g(int i) {
        d.b.h0.r.c layoutMode = this.f56577a.getLayoutMode();
        layoutMode.k(i == 1);
        layoutMode.j(this.f56578b);
        NavigationBar navigationBar = this.f56579c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56577a, i);
        }
        d.b.h0.r.f0.g gVar = this.f56584h;
        if (gVar != null) {
            gVar.I(i);
        }
        a aVar = this.i;
        if (aVar != null) {
            aVar.h(i);
        }
        NoNetworkView noNetworkView = this.f56583g;
        if (noNetworkView != null) {
            noNetworkView.c(this.f56577a, i);
        }
    }

    public void h() {
        NoNetworkView noNetworkView = this.f56583g;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && d.b.b.e.p.j.z()) {
            this.f56583g.e(false);
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
        this.f56583g.d(bVar);
    }

    public void l() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        this.f56581e.setOnItemClickListener(onItemClickListener);
    }

    public void n() {
        this.i.g();
    }

    public void o(f.g gVar) {
        this.f56584h.b(gVar);
    }

    public void p(BdListView.p pVar) {
        this.f56581e.setOnSrollToBottomListener(pVar);
    }

    public void q() {
        h hVar = this.j;
        if (hVar != null) {
            hVar.d();
            d.b.b.e.m.g.j(this.j, this.f56577a);
        }
    }

    public void r() {
        a aVar = this.i;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void s() {
        this.f56581e.F();
    }
}
