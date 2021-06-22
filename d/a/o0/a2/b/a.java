package d.a.o0.a2.b;

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
import d.a.n0.b.d;
import d.a.o0.a2.c.c;
import d.a.o0.a2.e.b;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes5.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f54956e;

    /* renamed from: f  reason: collision with root package name */
    public final b f54957f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f54958g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f54959h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f54960i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m = false;
    public BdListView.p n = new C1239a();

    /* renamed from: d.a.o0.a2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1239a implements BdListView.p {
        public C1239a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f54957f.k()) {
                a.this.f54957f.j();
                a.this.j();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.f54956e = interestedForumFragment;
        this.f54958g = bdRecyclerView;
        this.f54957f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
        f();
        h();
    }

    @Override // d.a.o0.a2.e.b.c
    public void a() {
        if (!this.m) {
            this.m = true;
        } else if (d.l()) {
            this.f54956e.getActivity().setResult(-1);
            this.f54956e.getActivity().finish();
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
        }
    }

    @Override // d.a.o0.a2.e.b.d
    public void b(c cVar) {
        List<d.a.o0.a2.c.a> list;
        if (cVar != null && (list = cVar.f54970a) != null && !ListUtils.isEmpty(list)) {
            if (this.f54958g.getVisibility() == 8) {
                this.f54958g.setVisibility(0);
            }
            this.f54959h.m(cVar.f54970a);
            this.f54956e.K0();
        }
        if (this.f54957f.k()) {
            return;
        }
        k();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void c(int i2, boolean z) {
        if (i2 > 0 && !this.k.isEnabled()) {
            this.k.setEnabled(true);
            this.k.setText(this.f54958g.getResources().getString(R.string.start_the_trip));
        } else if (i2 == 0) {
            this.k.setEnabled(false);
            this.k.setText(this.f54958g.getResources().getString(R.string.try_to_select));
        }
        d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
        if (!z) {
            this.j.setText(this.l.getString(R.string.select_all));
            this.j.setConfig(bVar);
            return;
        }
        this.j.setText(this.l.getString(R.string.unselect_all));
        bVar.r(R.color.CAM_X0109);
        this.j.setConfig(bVar);
    }

    public void e(List<d.a.o0.a2.c.b> list) {
        this.f54957f.o(list);
        this.f54957f.j();
        this.f54957f.e();
    }

    public final void f() {
        this.f54959h = new InterestedForumAdapter();
        BdRecyclerView bdRecyclerView = this.f54958g;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
        this.f54958g.setAdapter(this.f54959h);
        PbListView pbListView = new PbListView(this.f54958g.getContext());
        this.f54960i = pbListView;
        pbListView.a();
        this.f54960i.o(R.color.CAM_X0205);
        this.f54960i.v();
        this.f54960i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f54960i.E(R.dimen.tbfontsize33);
        this.f54960i.y(R.color.CAM_X0110);
        this.f54958g.setNextPage(this.f54960i);
        j();
    }

    public final void h() {
        this.f54958g.setOnSrollToBottomListener(this.n);
        this.f54957f.q(this);
        this.f54957f.p(this);
        this.f54959h.v(this);
        this.k.setOnClickListener(this);
    }

    public void i() {
        this.f54959h.s();
    }

    public void j() {
        this.f54960i.H();
        this.f54960i.O();
        this.f54960i.A(this.f54958g.getContext().getString(R.string.list_loading));
        this.f54960i.J(l.g(this.f54958g.getContext(), R.dimen.tbds217));
    }

    public void k() {
        this.f54960i.B(this.f54958g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f54958g.getContext(), R.dimen.tbds178));
        this.f54960i.E(R.dimen.tbds36);
        this.f54960i.y(R.color.CAM_X0109);
        this.f54960i.f();
        this.f54960i.J(l.g(this.f54958g.getContext(), R.dimen.tbds217));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            try {
                this.f54957f.f(this.f54959h.n());
                d.a.o0.a2.d.a.a(2, 1, this.f54956e.H0());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.o0.a2.e.b.d
    public void onError(int i2, String str) {
        this.f54956e.L0(str);
    }
}
