package d.b.i0.d1.i.a.c;

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
import d.b.b.e.p.j;
import d.b.h0.z0.l;
import d.b.i0.c3.h0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<?> f53832a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.i0.d1.i.a.a f53833b;

    /* renamed from: c  reason: collision with root package name */
    public View f53834c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f53835d;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f53836e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f53837f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53838g;

    /* renamed from: h  reason: collision with root package name */
    public FroumBroadMajorHistoryAdapter f53839h;
    public ImageView j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public String n;
    public String o;
    public d.b.h0.d0.h p;
    public RelativeLayout q;
    public boolean r;
    public ScreenTopToast s;
    public List<d.b.i0.d1.i.a.b.b> i = new ArrayList();
    public BdListView.p t = new C1198a();
    public d.b.h0.m.f<d.b.i0.d1.i.a.b.b> u = new b();
    public View.OnClickListener v = new d();
    public View.OnClickListener w = new e();
    public View.OnClickListener x = new f();
    public View.OnClickListener y = new g();

    /* renamed from: d.b.i0.d1.i.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1198a implements BdListView.p {
        public C1198a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f53836e != null) {
                a.this.f53836e.stopScroll();
            }
            a.this.p();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.m.f<d.b.i0.d1.i.a.b.b> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: b */
        public void c(View view, d.b.i0.d1.i.a.b.b bVar, int i, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: d */
        public void a(View view, d.b.i0.d1.i.a.b.b bVar, int i, long j) {
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
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f53832a.getPageActivity());
                String str2 = bVar.b() + "";
                String str3 = a.this.o;
                String str4 = a.this.n;
                if (bVar.j() != null) {
                    str = bVar.j().tid + "";
                }
                forumBroadcastHelper.jumpFlutterEditRelease(str2, str3, str4, str, bVar.k(), bVar.c(), bVar.f(), ForumBroadcastHelper.VALUE_PARMARS_BCAST_FROM_EDIT, "2");
                forumBroadcastHelper.start();
            } else if (bVar.j() != null && bVar.j().is_deleted.intValue() != 1) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(a.this.f53832a.getPageActivity());
                pbActivityConfig.createNormalCfg(bVar.j().tid + "", null, null);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            } else {
                BdTopToast bdTopToast = new BdTopToast(a.this.f53832a.getPageActivity());
                bdTopToast.i(false);
                bdTopToast.h(a.this.f53832a.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted));
                bdTopToast.j((ViewGroup) a.this.f53834c.findViewById(R.id.forum_major_history));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HashMap hashMap = new HashMap();
            hashMap.put("_forumId", a.this.n);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.f53832a.getPageActivity(), "ForumGradePage", hashMap)));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c13873").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            a.this.t();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l.a()) {
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f53832a.getPageActivity());
            forumBroadcastHelper.jumpFlutterEditGenear(a.this.n, a.this.o, "2");
            forumBroadcastHelper.start();
            TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f53836e != null) {
                a.this.f53836e.stopScroll();
            }
            if (a.this.f53837f == null || a.this.f53833b == null || !j.z()) {
                return;
            }
            a.this.f53837f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            a.this.f53837f.z(null);
            if (a.this.f53838g) {
                a.this.f53837f.L();
                a.this.f53833b.loadMore();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.A() || a.this.f53833b == null) {
                return;
            }
            a.this.k();
            a.this.f53833b.refresh();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f53848e;

        public i(a aVar, d.b.h0.r.s.a aVar2) {
            this.f53848e = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.s.a aVar = this.f53848e;
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    public a(TbPageContext<?> tbPageContext, d.b.i0.d1.i.a.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        this.f53832a = tbPageContext;
        this.f53833b = aVar;
        this.n = str;
        this.o = str2;
        l(view, str3);
        TiebaStatic.log(new StatisticItem("c13872").param("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void k() {
        d.b.h0.d0.h hVar = this.p;
        if (hVar != null) {
            hVar.dettachView(this.q);
            this.p = null;
        }
    }

    public final void l(View view, String str) {
        this.f53834c = view;
        this.f53835d = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
        this.q = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
        this.f53835d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j = (ImageView) this.f53835d.getCenterImgBox();
        LinearLayout linearLayout = (LinearLayout) this.f53835d.getCenterImgBoxLayout();
        this.k = linearLayout;
        linearLayout.setGravity(16);
        int g2 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        int g3 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
        ImageView imageView = this.j;
        int i2 = R.drawable.ic_icon_creation_question16_svg;
        SkinManager.setNavbarIconSrc(imageView, i2, i2);
        this.f53835d.showBottomLine();
        this.m = this.f53835d.setCenterTextTitle(this.f53832a.getResources().getString(R.string.subscribe_bar_title));
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
        this.f53836e = bdRecyclerView;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f53832a.getPageActivity()));
        this.f53836e.setOverScrollMode(2);
        this.f53836e.setOnSrollToBottomListener(this.t);
        SkinManager.setBackgroundColor(this.f53836e, R.color.CAM_X0204);
        FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter = new FroumBroadMajorHistoryAdapter(this.f53832a.getPageActivity());
        this.f53839h = froumBroadMajorHistoryAdapter;
        froumBroadMajorHistoryAdapter.g(this.u);
        this.f53836e.setAdapter(this.f53839h);
        PbListView pbListView = new PbListView(this.f53832a.getPageActivity());
        this.f53837f = pbListView;
        pbListView.b();
        this.f53837f.o(R.color.CAM_X0204);
        this.f53837f.r(d.b.b.e.p.l.g(this.f53832a.getPageActivity(), R.dimen.tbds182));
        this.f53837f.v();
        this.f53837f.E(R.dimen.tbfontsize33);
        this.f53837f.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f53837f.y(R.color.CAM_X0110);
        this.f53837f.q();
        this.f53837f.z(this.y);
        if (ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(str)) {
            s();
            int g4 = d.b.b.a.b.f().g();
            Activity e2 = d.b.b.a.b.f().e(g4 - 2);
            Activity e3 = d.b.b.a.b.f().e(g4 - 3);
            if (e2 == null || e3 == null || !"FlutterPageActivity".equals(e2.getClass().getSimpleName()) || !"ForumBroadCastMajorHistoryActivity".equals(e3.getClass().getSimpleName())) {
                return;
            }
            e3.finish();
        }
    }

    public void m(int i2) {
        this.f53835d.onChangeSkinType(this.f53832a, i2);
        SkinManager.setBackgroundColor(this.f53836e, R.color.CAM_X0204);
        this.f53837f.d(i2);
        this.f53839h.notifyDataSetChanged();
    }

    public void n() {
        this.i = null;
        this.s = null;
    }

    public void o(d.b.i0.d1.i.a.b.a aVar) {
        BdRecyclerView bdRecyclerView;
        if (aVar == null || aVar.b() == null) {
            return;
        }
        if (!ListUtils.isEmpty(aVar.b()) && StringUtils.isEmpty(this.n)) {
            d.b.i0.d1.i.a.b.b bVar = aVar.b().get(0);
            if (bVar.e() != null) {
                this.n = bVar.e().forum_id + "";
            }
        }
        this.f53838g = aVar.a();
        if (aVar.c()) {
            if (!ListUtils.isEmpty(aVar.b())) {
                this.i.clear();
                this.i.addAll(aVar.b());
            }
        } else if (!ListUtils.isEmpty(aVar.b())) {
            this.i.addAll(aVar.b());
        }
        this.f53839h.h(this.i);
        if (!aVar.c() || (bdRecyclerView = this.f53836e) == null || bdRecyclerView.getChildCount() <= 0) {
            return;
        }
        this.f53836e.scrollToPosition(0);
    }

    public void p() {
        if (this.f53837f == null || this.f53833b == null) {
            return;
        }
        if (j.z()) {
            this.f53836e.setNextPage(this.f53837f);
            this.f53837f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f53837f.z(null);
            if (this.f53838g) {
                this.f53837f.L();
                this.f53833b.loadMore();
                return;
            }
            this.f53837f.A(this.f53832a.getResources().getString(R.string.list_has_no_more));
            this.f53837f.f();
            return;
        }
        this.f53836e.setNextPage(null);
    }

    public void q() {
        ScreenTopToast screenTopToast = this.s;
        if (screenTopToast == null || !screenTopToast.g()) {
            ScreenTopToast screenTopToast2 = new ScreenTopToast(this.f53832a.getPageActivity());
            screenTopToast2.m(this.f53832a.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint));
            screenTopToast2.k(this.f53832a.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn));
            screenTopToast2.j(new c());
            this.s = screenTopToast2;
            screenTopToast2.n((ViewGroup) this.f53834c.findViewById(R.id.forum_major_history));
        }
    }

    public void r(String str, boolean z) {
        d.b.h0.d0.h hVar = this.p;
        if (hVar == null || !hVar.isViewAttached()) {
            if (this.p == null) {
                this.p = new d.b.h0.d0.h(this.f53832a.getPageActivity(), new h());
            }
            this.p.l(null);
            this.p.j(this.f53832a.getResources().getDimensionPixelSize(R.dimen.ds272));
            this.p.attachView(this.q, false);
            this.p.o();
        }
    }

    public void s() {
        if (this.f53834c != null) {
            BdTopToast bdTopToast = new BdTopToast(this.f53832a.getPageActivity());
            bdTopToast.i(true);
            bdTopToast.h(this.f53832a.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip));
            bdTopToast.j((ViewGroup) this.f53834c.findViewById(R.id.forum_major_history));
        }
    }

    public final void t() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f53832a.getPageActivity());
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(false);
        ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.f53832a.getPageActivity());
        forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new i(this, aVar));
        aVar.setContentView(forumBroadcastMajorQuestionDialogView);
        aVar.create(this.f53832a).show();
    }

    public void u(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        if (this.l != null) {
            return;
        }
        if (forumBroadcastMajorResidueData == null) {
            TextView addTextButton = this.f53835d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f53832a.getString(R.string.dynamic_publish), this.w);
            this.l = addTextButton;
            SkinManager.setViewTextColorSelector(addTextButton, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        } else if (forumBroadcastMajorResidueData.t() >= forumBroadcastMajorResidueData.s()) {
            this.r = true;
            TextView addTextButton2 = this.f53835d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f53832a.getString(R.string.dynamic_publish), this.x);
            this.l = addTextButton2;
            SkinManager.setViewTextColorSelector(addTextButton2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            this.l.setAlpha(0.33f);
        } else {
            TextView addTextButton3 = this.f53835d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f53832a.getString(R.string.dynamic_publish), this.w);
            this.l = addTextButton3;
            SkinManager.setViewTextColorSelector(addTextButton3, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        }
    }
}
