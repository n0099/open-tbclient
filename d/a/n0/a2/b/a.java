package d.a.n0.a2.b;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.adapter.InterestedForumAdapter;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import d.a.c.e.p.l;
import d.a.m0.b.d;
import d.a.n0.a2.c.c;
import d.a.n0.a2.e.b;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f51154e;

    /* renamed from: f  reason: collision with root package name */
    public final b f51155f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f51156g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f51157h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f51158i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public BdListView.p m = new C1179a();

    /* renamed from: d.a.n0.a2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1179a implements BdListView.p {
        public C1179a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f51155f.i()) {
                a.this.f51155f.h();
                a.this.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.f51154e = interestedForumFragment;
        this.f51156g = bdRecyclerView;
        this.f51155f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
        f();
        g();
    }

    @Override // d.a.n0.a2.e.b.c
    public void a() {
        if (d.l()) {
            this.f51154e.getActivity().setResult(-1);
            this.f51154e.getActivity().finish();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
    }

    @Override // d.a.n0.a2.e.b.d
    public void b(c cVar) {
        List<d.a.n0.a2.c.a> list;
        if (cVar != null && (list = cVar.f51168a) != null && !ListUtils.isEmpty(list)) {
            if (this.f51156g.getVisibility() == 8) {
                this.f51156g.setVisibility(0);
            }
            this.f51157h.m(cVar.f51168a);
            this.f51154e.H0();
        }
        if (this.f51155f.i()) {
            return;
        }
        j();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void c(int i2, boolean z) {
        if (i2 > 0 && !this.k.isEnabled()) {
            this.k.setEnabled(true);
            this.k.setText(this.f51156g.getResources().getString(R.string.start_the_trip));
        } else if (i2 == 0) {
            this.k.setEnabled(false);
            this.k.setText(this.f51156g.getResources().getString(R.string.try_to_select));
        }
        d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
        if (!z) {
            this.j.setText(this.l.getString(R.string.select_all));
            this.j.setConfig(bVar);
            return;
        }
        this.j.setText(this.l.getString(R.string.unselect_all));
        bVar.r(R.color.CAM_X0109);
        this.j.setConfig(bVar);
    }

    public void e(List<d.a.n0.a2.c.b> list) {
        this.f51155f.m(list);
        this.f51155f.h();
    }

    public final void f() {
        this.f51157h = new InterestedForumAdapter();
        BdRecyclerView bdRecyclerView = this.f51156g;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
        this.f51156g.setAdapter(this.f51157h);
        PbListView pbListView = new PbListView(this.f51156g.getContext());
        this.f51158i = pbListView;
        pbListView.a();
        this.f51158i.o(R.color.CAM_X0205);
        this.f51158i.v();
        this.f51158i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f51158i.E(R.dimen.tbfontsize33);
        this.f51158i.y(R.color.CAM_X0110);
        this.f51156g.setNextPage(this.f51158i);
        i();
    }

    public final void g() {
        this.f51156g.setOnSrollToBottomListener(this.m);
        this.f51155f.o(this);
        this.f51155f.n(this);
        this.f51157h.v(this);
        this.k.setOnClickListener(this);
    }

    public void h() {
        this.f51157h.s();
    }

    public void i() {
        this.f51158i.H();
        this.f51158i.O();
        this.f51158i.A(this.f51156g.getContext().getString(R.string.list_loading));
        this.f51158i.J(l.g(this.f51156g.getContext(), R.dimen.tbds217));
    }

    public void j() {
        this.f51158i.B(this.f51156g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f51156g.getContext(), R.dimen.tbds178));
        this.f51158i.E(R.dimen.tbds36);
        this.f51158i.y(R.color.CAM_X0109);
        this.f51158i.f();
        this.f51158i.J(l.g(this.f51156g.getContext(), R.dimen.tbds217));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            try {
                this.f51155f.e(this.f51157h.n());
                d.a.n0.a2.d.a.a(2, 1, this.f51154e.E0());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.n0.a2.e.b.d
    public void onError(int i2, String str) {
        this.f51154e.I0(str);
    }
}
