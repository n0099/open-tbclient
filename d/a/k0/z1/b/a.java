package d.a.k0.z1.b;

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
import d.a.j0.b.d;
import d.a.k0.z1.c.c;
import d.a.k0.z1.e.b;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f63663e;

    /* renamed from: f  reason: collision with root package name */
    public final b f63664f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f63665g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f63666h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f63667i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public BdListView.p m = new C1759a();

    /* renamed from: d.a.k0.z1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1759a implements BdListView.p {
        public C1759a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f63664f.i()) {
                a.this.f63664f.h();
                a.this.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.f63663e = interestedForumFragment;
        this.f63665g = bdRecyclerView;
        this.f63664f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
        f();
        g();
    }

    @Override // d.a.k0.z1.e.b.c
    public void a() {
        if (d.l()) {
            this.f63663e.getActivity().setResult(-1);
            this.f63663e.getActivity().finish();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
    }

    @Override // d.a.k0.z1.e.b.d
    public void b(c cVar) {
        List<d.a.k0.z1.c.a> list;
        if (cVar != null && (list = cVar.f63677a) != null && !ListUtils.isEmpty(list)) {
            if (this.f63665g.getVisibility() == 8) {
                this.f63665g.setVisibility(0);
            }
            this.f63666h.m(cVar.f63677a);
            this.f63663e.H0();
        }
        if (this.f63664f.i()) {
            return;
        }
        j();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void c(int i2, boolean z) {
        if (i2 > 0 && !this.k.isEnabled()) {
            this.k.setEnabled(true);
            this.k.setText(this.f63665g.getResources().getString(R.string.start_the_trip));
        } else if (i2 == 0) {
            this.k.setEnabled(false);
            this.k.setText(this.f63665g.getResources().getString(R.string.try_to_select));
        }
        d.a.j0.r.f0.m.b bVar = new d.a.j0.r.f0.m.b();
        if (!z) {
            this.j.setText(this.l.getString(R.string.select_all));
            this.j.setConfig(bVar);
            return;
        }
        this.j.setText(this.l.getString(R.string.unselect_all));
        bVar.r(R.color.CAM_X0109);
        this.j.setConfig(bVar);
    }

    public void e(List<d.a.k0.z1.c.b> list) {
        this.f63664f.m(list);
        this.f63664f.h();
    }

    public final void f() {
        this.f63666h = new InterestedForumAdapter();
        BdRecyclerView bdRecyclerView = this.f63665g;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
        this.f63665g.setAdapter(this.f63666h);
        PbListView pbListView = new PbListView(this.f63665g.getContext());
        this.f63667i = pbListView;
        pbListView.a();
        this.f63667i.o(R.color.CAM_X0205);
        this.f63667i.v();
        this.f63667i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f63667i.E(R.dimen.tbfontsize33);
        this.f63667i.y(R.color.CAM_X0110);
        this.f63665g.setNextPage(this.f63667i);
        i();
    }

    public final void g() {
        this.f63665g.setOnSrollToBottomListener(this.m);
        this.f63664f.o(this);
        this.f63664f.n(this);
        this.f63666h.v(this);
        this.k.setOnClickListener(this);
    }

    public void h() {
        this.f63666h.s();
    }

    public void i() {
        this.f63667i.H();
        this.f63667i.O();
        this.f63667i.A(this.f63665g.getContext().getString(R.string.list_loading));
        this.f63667i.J(l.g(this.f63665g.getContext(), R.dimen.tbds217));
    }

    public void j() {
        this.f63667i.B(this.f63665g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f63665g.getContext(), R.dimen.tbds178));
        this.f63667i.E(R.dimen.tbds36);
        this.f63667i.y(R.color.CAM_X0109);
        this.f63667i.f();
        this.f63667i.J(l.g(this.f63665g.getContext(), R.dimen.tbds217));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            try {
                this.f63664f.e(this.f63666h.n());
                d.a.k0.z1.d.a.a(2, 1, this.f63663e.E0());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.k0.z1.e.b.d
    public void onError(int i2, String str) {
        this.f63663e.I0(str);
    }
}
