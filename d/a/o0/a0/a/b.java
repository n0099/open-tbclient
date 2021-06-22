package d.a.o0.a0.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
import d.a.c.e.p.l;
import d.a.n0.d0.g;
import d.a.n0.d0.h;
import d.a.n0.r.f0.f;
import d.a.n0.r.s.a;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class b extends d.a.c.a.d<ChosenPostActivity> {

    /* renamed from: a  reason: collision with root package name */
    public ChosenPostActivity f54911a;

    /* renamed from: b  reason: collision with root package name */
    public View f54912b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54913c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f54914d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.a0.a.a f54915e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.g0.g.a f54916f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54917g;

    /* renamed from: h  reason: collision with root package name */
    public g f54918h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f54919i;
    public h j;
    public int k;
    public int l;
    public d.a.n0.r.f0.g m;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            b.this.f54911a.getModelController().F(z);
        }
    }

    /* renamed from: d.a.o0.a0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1234b implements AdapterView.OnItemClickListener {
        public C1234b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            tinfo item = b.this.f54915e.getItem(i2);
            if (item == null) {
                return;
            }
            TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AdapterView.OnItemLongClickListener {

        /* loaded from: classes4.dex */
        public class a implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.r.s.a f54923e;

            public a(c cVar, d.a.n0.r.s.a aVar) {
                this.f54923e = aVar;
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                this.f54923e.dismiss();
            }
        }

        /* renamed from: d.a.o0.a0.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1235b implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.n0.r.s.a f54924e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f54925f;

            public C1235b(d.a.n0.r.s.a aVar, int i2) {
                this.f54924e = aVar;
                this.f54925f = i2;
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                this.f54924e.dismiss();
                d.a.n0.g0.c.b bVar = new d.a.n0.g0.c.b(4101, null, null, null);
                bVar.g(b.this.f54915e.getItem(this.f54925f));
                bVar.i(b.this.f54911a.getUniqueId());
                b.this.f54911a.getEventCenter().dispatchMvcEvent(bVar);
            }
        }

        public c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(b.this.getActivity());
            aVar.setMessage(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
            aVar.setNegativeButton(R.string.cancel, new a(this, aVar));
            aVar.setPositiveButton(R.string.confirm, new C1235b(aVar, i2));
            aVar.create(b.this.f54911a.getPageContext());
            aVar.show();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.q {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void g(BdListView bdListView) {
            if (l.D()) {
                b.this.f54911a.getModelController().C();
            } else if (b.this.f54916f != null) {
                b.this.f54916f.d();
                b.this.f54916f.g(R.string.no_more_msg);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            bVar.o(bVar.m());
            b.this.f54918h.attachView(b.this.m(), true);
            b.this.v();
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this();
        }
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.f54917g = false;
        this.f54911a = chosenPostActivity;
    }

    public Activity getActivity() {
        return this.f54911a.getPageContext().getPageActivity();
    }

    public BdListView k() {
        return this.f54914d;
    }

    public d.a.n0.r.f0.g l() {
        if (this.m == null) {
            this.m = new d.a.n0.r.f0.g(this.f54911a.getPageContext());
        }
        return this.m;
    }

    public View m() {
        return this.f54912b;
    }

    public final void n(d.a.n0.g0.c.b bVar) {
        Object c2 = bVar.c();
        if (c2 instanceof Long) {
            this.f54915e.p(((Long) c2).longValue());
            if (this.f54915e.getCount() <= 5) {
                v();
            }
        }
    }

    public final void o(View view) {
        h hVar = this.j;
        if (hVar != null) {
            hVar.dettachView(view);
        }
    }

    public void onServerError(ErrorData errorData) {
        g gVar = this.f54918h;
        if (gVar != null) {
            gVar.dettachView(m());
        }
        if (errorData != null && this.f54915e.c() <= 0) {
            w(m(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.f54914d.A(0L);
        d.a.n0.g0.g.a aVar = this.f54916f;
        if (aVar != null) {
            aVar.g(R.string.no_more_msg);
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i2) {
        NavigationBar navigationBar = this.f54913c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(tbPageContext, i2);
        }
        d.a.o0.a0.a.a aVar = this.f54915e;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i2);
        }
        d.a.n0.g0.g.a aVar2 = this.f54916f;
        if (aVar2 != null) {
            aVar2.onChangeSkinType(tbPageContext, i2);
        }
        NoNetworkView noNetworkView = this.f54919i;
        if (noNetworkView != null) {
            noNetworkView.c(tbPageContext, i2);
        }
        d.a.n0.r.f0.g gVar = this.m;
        if (gVar != null) {
            gVar.I(i2);
        }
    }

    public View q() {
        View inflate = this.f54911a.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        this.f54912b = inflate;
        return inflate;
    }

    public boolean r(d.a.n0.g0.c.b bVar) {
        int b2 = bVar.b();
        if (b2 != 4102) {
            switch (b2) {
                case 4097:
                    this.f54917g = false;
                    break;
                case 4098:
                    this.f54917g = true;
                    break;
                case 4099:
                    t(bVar.a());
                    break;
            }
        } else {
            n(bVar);
        }
        return false;
    }

    public void s() {
        this.k = this.f54911a.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.l = this.f54911a.getResources().getDimensionPixelSize(R.dimen.ds150);
        NavigationBar navigationBar = (NavigationBar) m().findViewById(R.id.chosen_post_navigation_bar);
        this.f54913c = navigationBar;
        navigationBar.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.f54913c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54914d = (BdListView) m().findViewById(R.id.chosen_post_list);
        this.f54919i = (NoNetworkView) m().findViewById(R.id.view_no_network);
        d.a.o0.a0.a.a aVar = new d.a.o0.a0.a.a(this.f54911a.getPageContext(), new Class[]{d.a.o0.a0.a.c.c.class, d.a.o0.a0.a.c.b.class, d.a.o0.a0.a.c.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.f54911a.getEventCenter());
        this.f54915e = aVar;
        this.f54914d.setAdapter((ListAdapter) aVar);
        d.a.n0.r.f0.g l = l();
        this.m = l;
        this.f54914d.setPullRefresh(l);
        this.m.a(new a());
        this.f54914d.setOnItemClickListener(new C1234b());
        this.f54914d.setOnItemLongClickListener(new c());
        this.f54914d.setExOnSrollToBottomListener(new d());
        d.a.n0.g0.g.a aVar2 = new d.a.n0.g0.g.a(this.f54911a);
        this.f54916f = aVar2;
        aVar2.a();
        k().setNextPage(this.f54916f);
        g gVar = new g(getActivity());
        this.f54918h = gVar;
        gVar.onChangeSkinType();
        this.f54918h.attachView(m(), true);
        this.f54911a.getModelController().A();
    }

    public void t(d.a.n0.g0.b.a aVar) {
        if (aVar instanceof d.a.o0.a0.a.d.b) {
            List<tinfo> a2 = ((d.a.o0.a0.a.d.b) aVar).a();
            if (a2 != null && a2.size() > 0) {
                this.f54914d.setVisibility(0);
            }
            g gVar = this.f54918h;
            if (gVar != null) {
                gVar.dettachView(m());
            }
            if (this.f54917g) {
                this.f54915e.i(a2);
                return;
            }
            this.f54915e.k(a2);
            if (a2 == null) {
                return;
            }
            BdToast d2 = BdToast.d(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(a2.size())}), 0);
            d2.l(48);
            d2.n(this.k);
            d2.o(this.l);
            d2.a();
            d2.q();
        }
    }

    public void u(d.a.n0.g0.d.b bVar) {
        if (bVar instanceof d.a.n0.g0.d.a) {
            d.a.n0.g0.d.a aVar = (d.a.n0.g0.d.a) bVar;
            if (aVar.d()) {
                this.f54916f.d();
                if (aVar.b()) {
                    this.f54916f.f(R.string.loading);
                } else if (!aVar.a()) {
                    this.f54916f.g(R.string.no_more_msg);
                }
            } else {
                this.f54916f.e();
            }
            if (aVar.c()) {
                return;
            }
            this.f54914d.A(0L);
        }
    }

    public final void v() {
        d.a.n0.g0.c.b bVar = new d.a.n0.g0.c.b(4100, null, null, null);
        bVar.i(this.f54911a.getUniqueId());
        this.f54911a.getEventCenter().dispatchMvcEvent(bVar);
    }

    public final void w(View view, String str, boolean z) {
        if (this.j == null) {
            this.j = new h(getPageContext().getPageActivity(), new e(this, null));
        }
        this.j.l(str);
        this.j.attachView(view, z);
        this.j.o();
    }
}
