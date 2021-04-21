package d.b.j0.e1.i.b;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailActivity;
import com.baidu.tieba.im.forum.detail.ItemEmotionView;
import com.baidu.tieba.im.forum.detail.ItemFootNavView;
import com.baidu.tieba.im.forum.detail.ItemHeaderView;
import com.baidu.tieba.im.forum.detail.ItemHotThreadView;
import com.baidu.tieba.im.forum.detail.ItemInfoView;
import com.baidu.tieba.im.forum.detail.ItemMsgManage;
import com.baidu.tieba.view.CustomScrollView;
import d.b.c.a.d;
import d.b.i0.r.s.a;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes4.dex */
public class a extends d<ForumDetailActivity> {
    public static final int p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);

    /* renamed from: a  reason: collision with root package name */
    public ForumDetailActivity f55792a;

    /* renamed from: b  reason: collision with root package name */
    public View f55793b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f55794c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f55795d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f55796e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f55797f;

    /* renamed from: g  reason: collision with root package name */
    public CustomScrollView f55798g;

    /* renamed from: h  reason: collision with root package name */
    public ItemHeaderView f55799h;
    public ItemInfoView i;
    public ItemMsgManage j;
    public ItemEmotionView k;
    public ItemHotThreadView l;
    public ItemFootNavView m;
    public d.b.i0.r.s.a n;
    public View.OnClickListener o;

    /* renamed from: d.b.j0.e1.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1285a implements a.e {
        public C1285a() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            a.this.n.dismiss();
            a.this.f55792a.clearHistory();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            a.this.n.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a.this.m.o(false);
            } else if (action == 1) {
                a.this.m.o(true);
            } else if (action == 2) {
                a.this.m.o(false);
            }
            return false;
        }

        public /* synthetic */ c(a aVar, C1285a c1285a) {
            this();
        }
    }

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.f55792a = forumDetailActivity;
        initUI();
    }

    public NoNetworkView h() {
        return this.f55796e;
    }

    public void i() {
        this.f55792a.hideLoadingView(this.f55793b);
    }

    public final void initUI() {
        this.f55794c = (LinearLayout) this.f55792a.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.f55792a.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f55794c.addView(textView, 0);
        NavigationBar navigationBar = (NavigationBar) this.f55792a.findViewById(R.id.view_navigation_bar);
        this.f55795d = navigationBar;
        navigationBar.setCenterTextTitle(this.f55792a.getPageContext().getString(R.string.forum_detail_title));
        this.f55795d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f55795d.showBottomLine();
        this.f55796e = (NoNetworkView) this.f55792a.findViewById(R.id.no_network_view);
        CustomScrollView customScrollView = (CustomScrollView) this.f55792a.findViewById(R.id.scoll_view);
        this.f55798g = customScrollView;
        customScrollView.setOnTouchListener(new c(this, null));
        this.f55799h = (ItemHeaderView) this.f55792a.findViewById(R.id.item_header);
        this.i = (ItemInfoView) this.f55792a.findViewById(R.id.item_info);
        this.j = (ItemMsgManage) this.f55792a.findViewById(R.id.item_msg_manage);
        this.k = (ItemEmotionView) this.f55792a.findViewById(R.id.item_emotion_manage);
        this.l = (ItemHotThreadView) this.f55792a.findViewById(R.id.item_hot_thread);
        ItemFootNavView itemFootNavView = (ItemFootNavView) this.f55792a.findViewById(R.id.item_foot_nav);
        this.m = itemFootNavView;
        itemFootNavView.setClickable(true);
        this.f55793b = this.f55792a.findViewById(R.id.root_rl);
        this.j.setMsgOnClickListener(this.f55792a);
        this.k.setEmotionOnClickListener(this.f55792a);
        this.j.setSwitchChangeListener(this.f55792a);
    }

    public void k() {
        NoDataView noDataView = this.f55797f;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public void l() {
        this.m.n(this.f55792a);
    }

    public void m(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.k.setEmotionData(forumEmotionData);
    }

    public void n(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.f55799h.setData(recommendForumInfo);
        this.i.setData(recommendForumInfo);
        this.j.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.m.setData(recommendForumInfo, this.f55792a);
    }

    public void o(RecommendForumInfo recommendForumInfo, boolean z) {
        this.j.setShowState(recommendForumInfo, z);
    }

    public void onChangeSkinType(int i) {
        this.f55792a.getLayoutMode().k(i == 1);
        this.f55792a.getLayoutMode().j(this.f55793b);
        this.f55795d.onChangeSkinType(getPageContext(), i);
        this.f55796e.c(getPageContext(), i);
        this.f55799h.b(this.f55792a, i);
        this.i.b(this.f55792a, i);
        this.j.b(this.f55792a, i);
        this.l.d(this.f55792a, i);
        this.m.m(this.f55792a, i);
    }

    public void q(View.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    public void r(boolean z) {
        this.j.setSwitch(z);
    }

    public void s(List<SimpleThreadInfo> list) {
        this.l.setData(list);
    }

    public void u() {
        if (this.n == null) {
            d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f55792a.getPageContext().getPageActivity());
            this.n = aVar;
            aVar.setMessageId(R.string.officical_bar_info_clean_alert);
            this.n.setPositiveButton(R.string.alert_yes_button, new C1285a());
            this.n.setNegativeButton(R.string.cancel, new b());
        }
        this.n.create(getPageContext()).show();
    }

    public void v() {
        this.f55792a.showLoadingView(this.f55793b);
    }

    public void w(int i) {
        if (this.f55797f == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f55792a.getPageContext().getPageActivity(), this.f55794c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, p), NoDataViewFactory.e.d(null, this.f55792a.getResources().getString(i)), null);
            this.f55797f = a2;
            a2.setOnClickListener(this.o);
        }
        this.f55797f.setTextOption(NoDataViewFactory.e.d(null, this.f55792a.getResources().getString(i)));
        this.f55797f.f(this.f55792a.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f55797f.setVisibility(0);
    }

    public void x(RecommendForumInfo recommendForumInfo, boolean z) {
        this.m.r(z);
        this.j.setShowState(recommendForumInfo, z);
    }
}
