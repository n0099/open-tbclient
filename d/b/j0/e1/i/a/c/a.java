package d.b.j0.e1.i.a.c;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.view.ForumBroadcastMajorQuestionDialogView;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidubce.util.StringUtils;
import d.b.c.e.p.j;
import d.b.i0.z0.l;
import d.b.j0.d3.h0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<?> f55775a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.j0.e1.i.a.a f55776b;

    /* renamed from: c  reason: collision with root package name */
    public View f55777c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f55778d;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f55779e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f55780f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55781g;

    /* renamed from: h  reason: collision with root package name */
    public FroumBroadMajorHistoryAdapter f55782h;
    public ImageView j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public String n;
    public String o;
    public d.b.i0.d0.h p;
    public RelativeLayout q;
    public boolean r;
    public ScreenTopToast s;
    public List<d.b.j0.e1.i.a.b.b> i = new ArrayList();
    public BdListView.p t = new C1284a();
    public d.b.i0.m.f<d.b.j0.e1.i.a.b.b> u = new b();
    public View.OnClickListener v = new d();
    public View.OnClickListener w = new e();
    public View.OnClickListener x = new f();
    public View.OnClickListener y = new g();

    /* renamed from: d.b.j0.e1.i.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1284a implements BdListView.p {
        public C1284a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f55779e != null) {
                a.this.f55779e.stopScroll();
            }
            a.this.p();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.m.f<d.b.j0.e1.i.a.b.b> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: b */
        public void c(View view, d.b.j0.e1.i.a.b.b bVar, int i, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.m.f
        /* renamed from: d */
        public void a(View view, d.b.j0.e1.i.a.b.b bVar, int i, long j) {
            if (bVar == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13875").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", a.this.n).param("tid", bVar.j() != null ? bVar.j().tid.longValue() : 0L));
            String str = "";
            if (view.getId() == R.id.forum_fail_edit) {
                if (l.a()) {
                    return;
                }
                if (a.this.r) {
                    a.this.q();
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f55775a.getPageActivity());
                String str2 = bVar.b() + "";
                String str3 = a.this.o;
                String str4 = a.this.n;
                if (bVar.j() != null) {
                    str = bVar.j().tid + "";
                }
                forumBroadcastHelper.jumpFlutterEditRelease(str2, str3, str4, str, bVar.k(), bVar.c(), bVar.f(), ForumBroadcastHelper.VALUE_PARMARS_BCAST_FROM_EDIT, "2");
                forumBroadcastHelper.start();
            } else if (bVar.j() != null && bVar.j().is_deleted.intValue() != 1) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.f55775a.getPageActivity());
                pbActivityConfig.createNormalCfg(bVar.j().tid + "", null, null);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            } else {
                BdTopToast bdTopToast = new BdTopToast(a.this.f55775a.getPageActivity());
                bdTopToast.i(false);
                bdTopToast.h(a.this.f55775a.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted));
                bdTopToast.j((ViewGroup) a.this.f55777c.findViewById(R.id.forum_major_history));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("_forumId", a.this.n);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.f55775a.getPageActivity(), "ForumGradePage", hashMap)));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13873").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.t();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.a()) {
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f55775a.getPageActivity());
            forumBroadcastHelper.jumpFlutterEditGenear(a.this.n, a.this.o, "2");
            forumBroadcastHelper.start();
            TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            if (l.a()) {
                return;
            }
            a.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55779e != null) {
                a.this.f55779e.stopScroll();
            }
            if (a.this.f55780f == null || a.this.f55776b == null || !j.z()) {
                return;
            }
            a.this.f55780f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f55780f.z(null);
            if (a.this.f55781g) {
                a.this.f55780f.L();
                a.this.f55776b.loadMore();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || a.this.f55776b == null) {
                return;
            }
            a.this.k();
            a.this.f55776b.refresh();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f55791e;

        public i(a aVar, d.b.i0.r.s.a aVar2) {
            this.f55791e = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.r.s.a aVar = this.f55791e;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, d.b.j0.e1.i.a.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.f55775a = tbPageContext;
        this.f55776b = aVar;
        this.n = str;
        this.o = str2;
        l(view, str3);
        TiebaStatic.log(new StatisticItem("c13872").param("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void k() {
        d.b.i0.d0.h hVar = this.p;
        if (hVar != null) {
            hVar.dettachView(this.q);
            this.p = null;
        }
    }

    public final void l(View view, String str) {
        this.f55777c = view;
        this.f55778d = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.q = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.f55778d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j = (ImageView) this.f55778d.getCenterImgBox();
        LinearLayout linearLayout = (LinearLayout) this.f55778d.getCenterImgBoxLayout();
        this.k = linearLayout;
        linearLayout.setGravity(16);
        int g2 = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int g3 = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ImageView imageView = this.j;
        int i2 = R.drawable.ic_icon_creation_question16_svg;
        SkinManager.setNavbarIconSrc(imageView, i2, i2);
        this.f55778d.showBottomLine();
        this.m = this.f55778d.setCenterTextTitle(this.f55775a.getResources().getString(R.string.subscribe_bar_title));
        this.j.setPadding(g2, g2, g2, g2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.leftMargin = g2;
        layoutParams.rightMargin = 0;
        this.m.setLayoutParams(layoutParams);
        int i3 = g3 + g2 + g2;
        layoutParams2.width = i3;
        layoutParams2.height = i3;
        this.j.setLayoutParams(layoutParams2);
        this.j.setVisibility(0);
        this.j.setOnClickListener(this.v);
        BdRecyclerView bdRecyclerView = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
        this.f55779e = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f55775a.getPageActivity()));
        this.f55779e.setOverScrollMode(2);
        this.f55779e.setOnSrollToBottomListener(this.t);
        SkinManager.setBackgroundColor(this.f55779e, R.color.CAM_X0204);
        FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter = new FroumBroadMajorHistoryAdapter(this.f55775a.getPageActivity());
        this.f55782h = froumBroadMajorHistoryAdapter;
        froumBroadMajorHistoryAdapter.g(this.u);
        this.f55779e.setAdapter(this.f55782h);
        PbListView pbListView = new PbListView(this.f55775a.getPageActivity());
        this.f55780f = pbListView;
        pbListView.b();
        this.f55780f.o(R.color.CAM_X0204);
        this.f55780f.r(d.b.c.e.p.l.g(this.f55775a.getPageActivity(), R.dimen.tbds182));
        this.f55780f.v();
        this.f55780f.E(R.dimen.tbfontsize33);
        this.f55780f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f55780f.y(R.color.CAM_X0110);
        this.f55780f.q();
        this.f55780f.z(this.y);
        if (ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(str)) {
            s();
            int g4 = d.b.c.a.b.f().g();
            Activity e2 = d.b.c.a.b.f().e(g4 - 2);
            Activity e3 = d.b.c.a.b.f().e(g4 - 3);
            if (e2 == null || e3 == null || !"FlutterPageActivity".equals(e2.getClass().getSimpleName()) || !"ForumBroadCastMajorHistoryActivity".equals(e3.getClass().getSimpleName())) {
                return;
            }
            e3.finish();
        }
    }

    public void m(int i2) {
        this.f55778d.onChangeSkinType(this.f55775a, i2);
        SkinManager.setBackgroundColor(this.f55779e, R.color.CAM_X0204);
        this.f55780f.d(i2);
        this.f55782h.notifyDataSetChanged();
    }

    public void n() {
        this.i = null;
        this.s = null;
    }

    public void o(d.b.j0.e1.i.a.b.a aVar) {
        BdRecyclerView bdRecyclerView;
        if (aVar == null || aVar.b() == null) {
            return;
        }
        if (!ListUtils.isEmpty(aVar.b()) && StringUtils.isEmpty(this.n)) {
            d.b.j0.e1.i.a.b.b bVar = aVar.b().get(0);
            if (bVar.e() != null) {
                this.n = bVar.e().forum_id + "";
            }
        }
        this.f55781g = aVar.a();
        if (aVar.c()) {
            if (!ListUtils.isEmpty(aVar.b())) {
                this.i.clear();
                this.i.addAll(aVar.b());
            }
        } else if (!ListUtils.isEmpty(aVar.b())) {
            this.i.addAll(aVar.b());
        }
        this.f55782h.h(this.i);
        if (!aVar.c() || (bdRecyclerView = this.f55779e) == null || bdRecyclerView.getChildCount() <= 0) {
            return;
        }
        this.f55779e.scrollToPosition(0);
    }

    public void p() {
        if (this.f55780f == null || this.f55776b == null) {
            return;
        }
        if (j.z()) {
            this.f55779e.setNextPage(this.f55780f);
            this.f55780f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f55780f.z(null);
            if (this.f55781g) {
                this.f55780f.L();
                this.f55776b.loadMore();
                return;
            }
            this.f55780f.A(this.f55775a.getResources().getString(R.string.list_has_no_more));
            this.f55780f.f();
            return;
        }
        this.f55779e.setNextPage(null);
    }

    public void q() {
        ScreenTopToast screenTopToast = this.s;
        if (screenTopToast == null || !screenTopToast.g()) {
            ScreenTopToast screenTopToast2 = new ScreenTopToast(this.f55775a.getPageActivity());
            screenTopToast2.m(this.f55775a.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint));
            screenTopToast2.k(this.f55775a.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn));
            screenTopToast2.j(new c());
            this.s = screenTopToast2;
            screenTopToast2.n((ViewGroup) this.f55777c.findViewById(R.id.forum_major_history));
        }
    }

    public void r(String str, boolean z) {
        d.b.i0.d0.h hVar = this.p;
        if (hVar == null || !hVar.isViewAttached()) {
            if (this.p == null) {
                this.p = new d.b.i0.d0.h(this.f55775a.getPageActivity(), new h());
            }
            this.p.l(null);
            this.p.j(this.f55775a.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.p.attachView(this.q, false);
            this.p.o();
        }
    }

    public void s() {
        if (this.f55777c != null) {
            BdTopToast bdTopToast = new BdTopToast(this.f55775a.getPageActivity());
            bdTopToast.i(true);
            bdTopToast.h(this.f55775a.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip));
            bdTopToast.j((ViewGroup) this.f55777c.findViewById(R.id.forum_major_history));
        }
    }

    public final void t() {
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f55775a.getPageActivity());
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.f55775a.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new i(this, aVar));
        aVar.setContentView(forumBroadcastMajorQuestionDialogView);
        aVar.create(this.f55775a).show();
    }

    public void u(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.l != null) {
            return;
        }
        if (forumBroadcastMajorResidueData == null) {
            TextView addTextButton = this.f55778d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f55775a.getString(R.string.dynamic_publish), this.w);
            this.l = addTextButton;
            SkinManager.setViewTextColorSelector(addTextButton, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        } else if (forumBroadcastMajorResidueData.t() >= forumBroadcastMajorResidueData.s()) {
            this.r = true;
            TextView addTextButton2 = this.f55778d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f55775a.getString(R.string.dynamic_publish), this.x);
            this.l = addTextButton2;
            SkinManager.setViewTextColorSelector(addTextButton2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            this.l.setAlpha(0.33f);
        } else {
            TextView addTextButton3 = this.f55778d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f55775a.getString(R.string.dynamic_publish), this.w);
            this.l = addTextButton3;
            SkinManager.setViewTextColorSelector(addTextButton3, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        }
    }
}
