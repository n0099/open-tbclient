package d.a.j0.y.a;

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
import d.a.i0.d0.g;
import d.a.i0.d0.h;
import d.a.i0.r.f0.f;
import d.a.i0.r.s.a;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class b extends d.a.c.a.d<ChosenPostActivity> {

    /* renamed from: a  reason: collision with root package name */
    public ChosenPostActivity f62669a;

    /* renamed from: b  reason: collision with root package name */
    public View f62670b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62671c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f62672d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.y.a.a f62673e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.g0.g.a f62674f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62675g;

    /* renamed from: h  reason: collision with root package name */
    public g f62676h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f62677i;
    public h j;
    public int k;
    public int l;
    public d.a.i0.r.f0.g m;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            b.this.f62669a.getModelController().B(z);
        }
    }

    /* renamed from: d.a.j0.y.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1671b implements AdapterView.OnItemClickListener {
        public C1671b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            tinfo item = b.this.f62673e.getItem(i2);
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
            public final /* synthetic */ d.a.i0.r.s.a f62681e;

            public a(c cVar, d.a.i0.r.s.a aVar) {
                this.f62681e = aVar;
            }

            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                this.f62681e.dismiss();
            }
        }

        /* renamed from: d.a.j0.y.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1672b implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.r.s.a f62682e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f62683f;

            public C1672b(d.a.i0.r.s.a aVar, int i2) {
                this.f62682e = aVar;
                this.f62683f = i2;
            }

            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                this.f62682e.dismiss();
                d.a.i0.g0.c.b bVar = new d.a.i0.g0.c.b(4101, null, null, null);
                bVar.g(b.this.f62673e.getItem(this.f62683f));
                bVar.i(b.this.f62669a.getUniqueId());
                b.this.f62669a.getEventCenter().dispatchMvcEvent(bVar);
            }
        }

        public c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(b.this.getActivity());
            aVar.setMessage(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
            aVar.setNegativeButton(R.string.cancel, new a(this, aVar));
            aVar.setPositiveButton(R.string.confirm, new C1672b(aVar, i2));
            aVar.create(b.this.f62669a.getPageContext());
            aVar.show();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.q {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void q(BdListView bdListView) {
            if (l.D()) {
                b.this.f62669a.getModelController().y();
            } else if (b.this.f62674f != null) {
                b.this.f62674f.d();
                b.this.f62674f.g(R.string.no_more_msg);
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
            b.this.f62676h.attachView(b.this.m(), true);
            b.this.v();
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this();
        }
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.f62675g = false;
        this.f62669a = chosenPostActivity;
    }

    public Activity getActivity() {
        return this.f62669a.getPageContext().getPageActivity();
    }

    public BdListView k() {
        return this.f62672d;
    }

    public d.a.i0.r.f0.g l() {
        if (this.m == null) {
            this.m = new d.a.i0.r.f0.g(this.f62669a.getPageContext());
        }
        return this.m;
    }

    public View m() {
        return this.f62670b;
    }

    public final void n(d.a.i0.g0.c.b bVar) {
        Object c2 = bVar.c();
        if (c2 instanceof Long) {
            this.f62673e.p(((Long) c2).longValue());
            if (this.f62673e.getCount() <= 5) {
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
        g gVar = this.f62676h;
        if (gVar != null) {
            gVar.dettachView(m());
        }
        if (errorData != null && this.f62673e.c() <= 0) {
            w(m(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.f62672d.A(0L);
        d.a.i0.g0.g.a aVar = this.f62674f;
        if (aVar != null) {
            aVar.g(R.string.no_more_msg);
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i2) {
        NavigationBar navigationBar = this.f62671c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(tbPageContext, i2);
        }
        d.a.j0.y.a.a aVar = this.f62673e;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i2);
        }
        d.a.i0.g0.g.a aVar2 = this.f62674f;
        if (aVar2 != null) {
            aVar2.onChangeSkinType(tbPageContext, i2);
        }
        NoNetworkView noNetworkView = this.f62677i;
        if (noNetworkView != null) {
            noNetworkView.c(tbPageContext, i2);
        }
        d.a.i0.r.f0.g gVar = this.m;
        if (gVar != null) {
            gVar.I(i2);
        }
    }

    public View q() {
        View inflate = this.f62669a.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        this.f62670b = inflate;
        return inflate;
    }

    public boolean r(d.a.i0.g0.c.b bVar) {
        int b2 = bVar.b();
        if (b2 != 4102) {
            switch (b2) {
                case 4097:
                    this.f62675g = false;
                    break;
                case 4098:
                    this.f62675g = true;
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
        this.k = this.f62669a.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.l = this.f62669a.getResources().getDimensionPixelSize(R.dimen.ds150);
        NavigationBar navigationBar = (NavigationBar) m().findViewById(R.id.chosen_post_navigation_bar);
        this.f62671c = navigationBar;
        navigationBar.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.f62671c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62672d = (BdListView) m().findViewById(R.id.chosen_post_list);
        this.f62677i = (NoNetworkView) m().findViewById(R.id.view_no_network);
        d.a.j0.y.a.a aVar = new d.a.j0.y.a.a(this.f62669a.getPageContext(), new Class[]{d.a.j0.y.a.c.c.class, d.a.j0.y.a.c.b.class, d.a.j0.y.a.c.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.f62669a.getEventCenter());
        this.f62673e = aVar;
        this.f62672d.setAdapter((ListAdapter) aVar);
        d.a.i0.r.f0.g l = l();
        this.m = l;
        this.f62672d.setPullRefresh(l);
        this.m.a(new a());
        this.f62672d.setOnItemClickListener(new C1671b());
        this.f62672d.setOnItemLongClickListener(new c());
        this.f62672d.setExOnSrollToBottomListener(new d());
        d.a.i0.g0.g.a aVar2 = new d.a.i0.g0.g.a(this.f62669a);
        this.f62674f = aVar2;
        aVar2.a();
        k().setNextPage(this.f62674f);
        g gVar = new g(getActivity());
        this.f62676h = gVar;
        gVar.onChangeSkinType();
        this.f62676h.attachView(m(), true);
        this.f62669a.getModelController().w();
    }

    public void t(d.a.i0.g0.b.a aVar) {
        if (aVar instanceof d.a.j0.y.a.d.b) {
            List<tinfo> a2 = ((d.a.j0.y.a.d.b) aVar).a();
            if (a2 != null && a2.size() > 0) {
                this.f62672d.setVisibility(0);
            }
            g gVar = this.f62676h;
            if (gVar != null) {
                gVar.dettachView(m());
            }
            if (this.f62675g) {
                this.f62673e.i(a2);
                return;
            }
            this.f62673e.k(a2);
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

    public void u(d.a.i0.g0.d.b bVar) {
        if (bVar instanceof d.a.i0.g0.d.a) {
            d.a.i0.g0.d.a aVar = (d.a.i0.g0.d.a) bVar;
            if (aVar.d()) {
                this.f62674f.d();
                if (aVar.b()) {
                    this.f62674f.f(R.string.loading);
                } else if (!aVar.a()) {
                    this.f62674f.g(R.string.no_more_msg);
                }
            } else {
                this.f62674f.e();
            }
            if (aVar.c()) {
                return;
            }
            this.f62672d.A(0L);
        }
    }

    public final void v() {
        d.a.i0.g0.c.b bVar = new d.a.i0.g0.c.b(4100, null, null, null);
        bVar.i(this.f62669a.getUniqueId());
        this.f62669a.getEventCenter().dispatchMvcEvent(bVar);
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
