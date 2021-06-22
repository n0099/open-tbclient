package d.a.o0.f1.i.b;

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
import d.a.c.a.d;
import d.a.n0.r.s.a;
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
    public ForumDetailActivity f58360a;

    /* renamed from: b  reason: collision with root package name */
    public View f58361b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f58362c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58363d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f58364e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f58365f;

    /* renamed from: g  reason: collision with root package name */
    public CustomScrollView f58366g;

    /* renamed from: h  reason: collision with root package name */
    public ItemHeaderView f58367h;

    /* renamed from: i  reason: collision with root package name */
    public ItemInfoView f58368i;
    public ItemMsgManage j;
    public ItemEmotionView k;
    public ItemHotThreadView l;
    public ItemFootNavView m;
    public d.a.n0.r.s.a n;
    public View.OnClickListener o;

    /* renamed from: d.a.o0.f1.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1374a implements a.e {
        public C1374a() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            a.this.n.dismiss();
            a.this.f58360a.clearHistory();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
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

        public /* synthetic */ c(a aVar, C1374a c1374a) {
            this();
        }
    }

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.f58360a = forumDetailActivity;
        initUI();
    }

    public NoNetworkView h() {
        return this.f58364e;
    }

    public void i() {
        this.f58360a.hideLoadingView(this.f58361b);
    }

    public final void initUI() {
        this.f58362c = (LinearLayout) this.f58360a.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.f58360a.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f58362c.addView(textView, 0);
        NavigationBar navigationBar = (NavigationBar) this.f58360a.findViewById(R.id.view_navigation_bar);
        this.f58363d = navigationBar;
        navigationBar.setCenterTextTitle(this.f58360a.getPageContext().getString(R.string.forum_detail_title));
        this.f58363d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58363d.showBottomLine();
        this.f58364e = (NoNetworkView) this.f58360a.findViewById(R.id.no_network_view);
        CustomScrollView customScrollView = (CustomScrollView) this.f58360a.findViewById(R.id.scoll_view);
        this.f58366g = customScrollView;
        customScrollView.setOnTouchListener(new c(this, null));
        this.f58367h = (ItemHeaderView) this.f58360a.findViewById(R.id.item_header);
        this.f58368i = (ItemInfoView) this.f58360a.findViewById(R.id.item_info);
        this.j = (ItemMsgManage) this.f58360a.findViewById(R.id.item_msg_manage);
        this.k = (ItemEmotionView) this.f58360a.findViewById(R.id.item_emotion_manage);
        this.l = (ItemHotThreadView) this.f58360a.findViewById(R.id.item_hot_thread);
        ItemFootNavView itemFootNavView = (ItemFootNavView) this.f58360a.findViewById(R.id.item_foot_nav);
        this.m = itemFootNavView;
        itemFootNavView.setClickable(true);
        this.f58361b = this.f58360a.findViewById(R.id.root_rl);
        this.j.setMsgOnClickListener(this.f58360a);
        this.k.setEmotionOnClickListener(this.f58360a);
        this.j.setSwitchChangeListener(this.f58360a);
    }

    public void k() {
        NoDataView noDataView = this.f58365f;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public void l() {
        this.m.n(this.f58360a);
    }

    public void m(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.k.setEmotionData(forumEmotionData);
    }

    public void n(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.f58367h.setData(recommendForumInfo);
        this.f58368i.setData(recommendForumInfo);
        this.j.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.m.setData(recommendForumInfo, this.f58360a);
    }

    public void o(RecommendForumInfo recommendForumInfo, boolean z) {
        this.j.setShowState(recommendForumInfo, z);
    }

    public void onChangeSkinType(int i2) {
        this.f58360a.getLayoutMode().k(i2 == 1);
        this.f58360a.getLayoutMode().j(this.f58361b);
        this.f58363d.onChangeSkinType(getPageContext(), i2);
        this.f58364e.c(getPageContext(), i2);
        this.f58367h.b(this.f58360a, i2);
        this.f58368i.b(this.f58360a, i2);
        this.j.b(this.f58360a, i2);
        this.l.d(this.f58360a, i2);
        this.m.m(this.f58360a, i2);
    }

    public void p(View.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    public void q(boolean z) {
        this.j.setSwitch(z);
    }

    public void r(List<SimpleThreadInfo> list) {
        this.l.setData(list);
    }

    public void s() {
        if (this.n == null) {
            d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f58360a.getPageContext().getPageActivity());
            this.n = aVar;
            aVar.setMessageId(R.string.officical_bar_info_clean_alert);
            this.n.setPositiveButton(R.string.alert_yes_button, new C1374a());
            this.n.setNegativeButton(R.string.cancel, new b());
        }
        this.n.create(getPageContext()).show();
    }

    public void t() {
        this.f58360a.showLoadingView(this.f58361b);
    }

    public void u(int i2) {
        if (this.f58365f == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f58360a.getPageContext().getPageActivity(), this.f58362c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, p), NoDataViewFactory.e.d(null, this.f58360a.getResources().getString(i2)), null);
            this.f58365f = a2;
            a2.setOnClickListener(this.o);
        }
        this.f58365f.setTextOption(NoDataViewFactory.e.d(null, this.f58360a.getResources().getString(i2)));
        this.f58365f.f(this.f58360a.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f58365f.setVisibility(0);
    }

    public void v(RecommendForumInfo recommendForumInfo, boolean z) {
        this.m.r(z);
        this.j.setShowState(recommendForumInfo, z);
    }
}
