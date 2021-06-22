package d.a.o0.f1.i.a.c;

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
import d.a.c.e.p.j;
import d.a.n0.z0.l;
import d.a.o0.e3.h0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<?> f58342a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.o0.f1.i.a.a f58343b;

    /* renamed from: c  reason: collision with root package name */
    public View f58344c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58345d;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f58346e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f58347f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58348g;

    /* renamed from: h  reason: collision with root package name */
    public FroumBroadMajorHistoryAdapter f58349h;
    public ImageView j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public String n;
    public String o;
    public d.a.n0.d0.h p;
    public RelativeLayout q;
    public boolean r;
    public ScreenTopToast s;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.o0.f1.i.a.b.b> f58350i = new ArrayList();
    public BdListView.p t = new C1373a();
    public d.a.n0.m.f<d.a.o0.f1.i.a.b.b> u = new b();
    public View.OnClickListener v = new d();
    public View.OnClickListener w = new e();
    public View.OnClickListener x = new f();
    public View.OnClickListener y = new g();

    /* renamed from: d.a.o0.f1.i.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1373a implements BdListView.p {
        public C1373a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f58346e != null) {
                a.this.f58346e.stopScroll();
            }
            a.this.p();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.n0.m.f<d.a.o0.f1.i.a.b.b> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: b */
        public void c(View view, d.a.o0.f1.i.a.b.b bVar, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: d */
        public void a(View view, d.a.o0.f1.i.a.b.b bVar, int i2, long j) {
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
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f58342a.getPageActivity());
                String str2 = bVar.b() + "";
                String str3 = a.this.o;
                String str4 = a.this.n;
                if (bVar.j() != null) {
                    str = bVar.j().tid + "";
                }
                forumBroadcastHelper.jumpFlutterEditRelease(str2, str3, str4, str, bVar.k(), bVar.c(), bVar.f(), ForumBroadcastHelper.VALUE_PARMARS_BCAST_FROM_EDIT, "2");
                forumBroadcastHelper.start();
            } else if (bVar.j() != null && bVar.j().is_deleted.intValue() != 1) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.f58342a.getPageActivity());
                pbActivityConfig.createNormalCfg(bVar.j().tid + "", null, null);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            } else {
                BdTopToast bdTopToast = new BdTopToast(a.this.f58342a.getPageActivity());
                bdTopToast.i(false);
                bdTopToast.h(a.this.f58342a.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted));
                bdTopToast.j((ViewGroup) a.this.f58344c.findViewById(R.id.forum_major_history));
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.f58342a.getPageActivity(), "ForumGradePage", hashMap)));
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
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f58342a.getPageActivity());
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
            if (a.this.f58346e != null) {
                a.this.f58346e.stopScroll();
            }
            if (a.this.f58347f == null || a.this.f58343b == null || !j.z()) {
                return;
            }
            a.this.f58347f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f58347f.z(null);
            if (a.this.f58348g) {
                a.this.f58347f.L();
                a.this.f58343b.loadMore();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || a.this.f58343b == null) {
                return;
            }
            a.this.k();
            a.this.f58343b.refresh();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f58359e;

        public i(a aVar, d.a.n0.r.s.a aVar2) {
            this.f58359e = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.r.s.a aVar = this.f58359e;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, d.a.o0.f1.i.a.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.f58342a = tbPageContext;
        this.f58343b = aVar;
        this.n = str;
        this.o = str2;
        l(view, str3);
        TiebaStatic.log(new StatisticItem("c13872").param("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void k() {
        d.a.n0.d0.h hVar = this.p;
        if (hVar != null) {
            hVar.dettachView(this.q);
            this.p = null;
        }
    }

    public final void l(View view, String str) {
        this.f58344c = view;
        this.f58345d = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.q = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.f58345d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j = (ImageView) this.f58345d.getCenterImgBox();
        LinearLayout linearLayout = (LinearLayout) this.f58345d.getCenterImgBoxLayout();
        this.k = linearLayout;
        linearLayout.setGravity(16);
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ImageView imageView = this.j;
        int i2 = R.drawable.ic_icon_creation_question16_svg;
        SkinManager.setNavbarIconSrc(imageView, i2, i2);
        this.f58345d.showBottomLine();
        this.m = this.f58345d.setCenterTextTitle(this.f58342a.getResources().getString(R.string.subscribe_bar_title));
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
        this.f58346e = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f58342a.getPageActivity()));
        this.f58346e.setOverScrollMode(2);
        this.f58346e.setOnSrollToBottomListener(this.t);
        SkinManager.setBackgroundColor(this.f58346e, R.color.CAM_X0204);
        FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter = new FroumBroadMajorHistoryAdapter(this.f58342a.getPageActivity());
        this.f58349h = froumBroadMajorHistoryAdapter;
        froumBroadMajorHistoryAdapter.g(this.u);
        this.f58346e.setAdapter(this.f58349h);
        PbListView pbListView = new PbListView(this.f58342a.getPageActivity());
        this.f58347f = pbListView;
        pbListView.b();
        this.f58347f.o(R.color.CAM_X0204);
        this.f58347f.r(d.a.c.e.p.l.g(this.f58342a.getPageActivity(), R.dimen.tbds182));
        this.f58347f.v();
        this.f58347f.E(R.dimen.tbfontsize33);
        this.f58347f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f58347f.y(R.color.CAM_X0110);
        this.f58347f.q();
        this.f58347f.z(this.y);
        if (ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(str)) {
            s();
            int g4 = d.a.c.a.b.f().g();
            Activity e2 = d.a.c.a.b.f().e(g4 - 2);
            Activity e3 = d.a.c.a.b.f().e(g4 - 3);
            if (e2 == null || e3 == null || !"FlutterPageActivity".equals(e2.getClass().getSimpleName()) || !"ForumBroadCastMajorHistoryActivity".equals(e3.getClass().getSimpleName())) {
                return;
            }
            e3.finish();
        }
    }

    public void m(int i2) {
        this.f58345d.onChangeSkinType(this.f58342a, i2);
        SkinManager.setBackgroundColor(this.f58346e, R.color.CAM_X0204);
        this.f58347f.d(i2);
        this.f58349h.notifyDataSetChanged();
    }

    public void n() {
        this.f58350i = null;
        this.s = null;
    }

    public void o(d.a.o0.f1.i.a.b.a aVar) {
        BdRecyclerView bdRecyclerView;
        if (aVar == null || aVar.b() == null) {
            return;
        }
        if (!ListUtils.isEmpty(aVar.b()) && StringUtils.isEmpty(this.n)) {
            d.a.o0.f1.i.a.b.b bVar = aVar.b().get(0);
            if (bVar.e() != null) {
                this.n = bVar.e().forum_id + "";
            }
        }
        this.f58348g = aVar.a();
        if (aVar.c()) {
            if (!ListUtils.isEmpty(aVar.b())) {
                this.f58350i.clear();
                this.f58350i.addAll(aVar.b());
            }
        } else if (!ListUtils.isEmpty(aVar.b())) {
            this.f58350i.addAll(aVar.b());
        }
        this.f58349h.h(this.f58350i);
        if (!aVar.c() || (bdRecyclerView = this.f58346e) == null || bdRecyclerView.getChildCount() <= 0) {
            return;
        }
        this.f58346e.scrollToPosition(0);
    }

    public void p() {
        if (this.f58347f == null || this.f58343b == null) {
            return;
        }
        if (j.z()) {
            this.f58346e.setNextPage(this.f58347f);
            this.f58347f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f58347f.z(null);
            if (this.f58348g) {
                this.f58347f.L();
                this.f58343b.loadMore();
                return;
            }
            this.f58347f.A(this.f58342a.getResources().getString(R.string.list_has_no_more));
            this.f58347f.f();
            return;
        }
        this.f58346e.setNextPage(null);
    }

    public void q() {
        ScreenTopToast screenTopToast = this.s;
        if (screenTopToast == null || !screenTopToast.g()) {
            ScreenTopToast screenTopToast2 = new ScreenTopToast(this.f58342a.getPageActivity());
            screenTopToast2.m(this.f58342a.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint));
            screenTopToast2.k(this.f58342a.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn));
            screenTopToast2.j(new c());
            this.s = screenTopToast2;
            screenTopToast2.n((ViewGroup) this.f58344c.findViewById(R.id.forum_major_history));
        }
    }

    public void r(String str, boolean z) {
        d.a.n0.d0.h hVar = this.p;
        if (hVar == null || !hVar.isViewAttached()) {
            if (this.p == null) {
                this.p = new d.a.n0.d0.h(this.f58342a.getPageActivity(), new h());
            }
            this.p.l(null);
            this.p.j(this.f58342a.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.p.attachView(this.q, false);
            this.p.o();
        }
    }

    public void s() {
        if (this.f58344c != null) {
            BdTopToast bdTopToast = new BdTopToast(this.f58342a.getPageActivity());
            bdTopToast.i(true);
            bdTopToast.h(this.f58342a.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip));
            bdTopToast.j((ViewGroup) this.f58344c.findViewById(R.id.forum_major_history));
        }
    }

    public final void t() {
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f58342a.getPageActivity());
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.f58342a.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new i(this, aVar));
        aVar.setContentView(forumBroadcastMajorQuestionDialogView);
        aVar.create(this.f58342a).show();
    }

    public void u(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.l != null) {
            return;
        }
        if (forumBroadcastMajorResidueData == null) {
            TextView addTextButton = this.f58345d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f58342a.getString(R.string.dynamic_publish), this.w);
            this.l = addTextButton;
            SkinManager.setViewTextColorSelector(addTextButton, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        } else if (forumBroadcastMajorResidueData.x() >= forumBroadcastMajorResidueData.w()) {
            this.r = true;
            TextView addTextButton2 = this.f58345d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f58342a.getString(R.string.dynamic_publish), this.x);
            this.l = addTextButton2;
            SkinManager.setViewTextColorSelector(addTextButton2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            this.l.setAlpha(0.33f);
        } else {
            TextView addTextButton3 = this.f58345d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f58342a.getString(R.string.dynamic_publish), this.w);
            this.l = addTextButton3;
            SkinManager.setViewTextColorSelector(addTextButton3, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        }
    }
}
