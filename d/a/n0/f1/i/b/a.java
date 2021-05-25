package d.a.n0.f1.i.b;

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
import d.a.m0.r.s.a;
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
    public ForumDetailActivity f54546a;

    /* renamed from: b  reason: collision with root package name */
    public View f54547b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f54548c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f54549d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f54550e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f54551f;

    /* renamed from: g  reason: collision with root package name */
    public CustomScrollView f54552g;

    /* renamed from: h  reason: collision with root package name */
    public ItemHeaderView f54553h;

    /* renamed from: i  reason: collision with root package name */
    public ItemInfoView f54554i;
    public ItemMsgManage j;
    public ItemEmotionView k;
    public ItemHotThreadView l;
    public ItemFootNavView m;
    public d.a.m0.r.s.a n;
    public View.OnClickListener o;

    /* renamed from: d.a.n0.f1.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1314a implements a.e {
        public C1314a() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            a.this.n.dismiss();
            a.this.f54546a.clearHistory();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
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

        public /* synthetic */ c(a aVar, C1314a c1314a) {
            this();
        }
    }

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.f54546a = forumDetailActivity;
        initUI();
    }

    public NoNetworkView g() {
        return this.f54550e;
    }

    public void h() {
        this.f54546a.hideLoadingView(this.f54547b);
    }

    public final void initUI() {
        this.f54548c = (LinearLayout) this.f54546a.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.f54546a.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f54548c.addView(textView, 0);
        NavigationBar navigationBar = (NavigationBar) this.f54546a.findViewById(R.id.view_navigation_bar);
        this.f54549d = navigationBar;
        navigationBar.setCenterTextTitle(this.f54546a.getPageContext().getString(R.string.forum_detail_title));
        this.f54549d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54549d.showBottomLine();
        this.f54550e = (NoNetworkView) this.f54546a.findViewById(R.id.no_network_view);
        CustomScrollView customScrollView = (CustomScrollView) this.f54546a.findViewById(R.id.scoll_view);
        this.f54552g = customScrollView;
        customScrollView.setOnTouchListener(new c(this, null));
        this.f54553h = (ItemHeaderView) this.f54546a.findViewById(R.id.item_header);
        this.f54554i = (ItemInfoView) this.f54546a.findViewById(R.id.item_info);
        this.j = (ItemMsgManage) this.f54546a.findViewById(R.id.item_msg_manage);
        this.k = (ItemEmotionView) this.f54546a.findViewById(R.id.item_emotion_manage);
        this.l = (ItemHotThreadView) this.f54546a.findViewById(R.id.item_hot_thread);
        ItemFootNavView itemFootNavView = (ItemFootNavView) this.f54546a.findViewById(R.id.item_foot_nav);
        this.m = itemFootNavView;
        itemFootNavView.setClickable(true);
        this.f54547b = this.f54546a.findViewById(R.id.root_rl);
        this.j.setMsgOnClickListener(this.f54546a);
        this.k.setEmotionOnClickListener(this.f54546a);
        this.j.setSwitchChangeListener(this.f54546a);
    }

    public void j() {
        NoDataView noDataView = this.f54551f;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public void k() {
        this.m.n(this.f54546a);
    }

    public void l(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.k.setEmotionData(forumEmotionData);
    }

    public void m(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.f54553h.setData(recommendForumInfo);
        this.f54554i.setData(recommendForumInfo);
        this.j.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.m.setData(recommendForumInfo, this.f54546a);
    }

    public void n(RecommendForumInfo recommendForumInfo, boolean z) {
        this.j.setShowState(recommendForumInfo, z);
    }

    public void o(View.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    public void onChangeSkinType(int i2) {
        this.f54546a.getLayoutMode().k(i2 == 1);
        this.f54546a.getLayoutMode().j(this.f54547b);
        this.f54549d.onChangeSkinType(getPageContext(), i2);
        this.f54550e.c(getPageContext(), i2);
        this.f54553h.b(this.f54546a, i2);
        this.f54554i.b(this.f54546a, i2);
        this.j.b(this.f54546a, i2);
        this.l.d(this.f54546a, i2);
        this.m.m(this.f54546a, i2);
    }

    public void p(boolean z) {
        this.j.setSwitch(z);
    }

    public void q(List<SimpleThreadInfo> list) {
        this.l.setData(list);
    }

    public void r() {
        if (this.n == null) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f54546a.getPageContext().getPageActivity());
            this.n = aVar;
            aVar.setMessageId(R.string.officical_bar_info_clean_alert);
            this.n.setPositiveButton(R.string.alert_yes_button, new C1314a());
            this.n.setNegativeButton(R.string.cancel, new b());
        }
        this.n.create(getPageContext()).show();
    }

    public void s() {
        this.f54546a.showLoadingView(this.f54547b);
    }

    public void t(int i2) {
        if (this.f54551f == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f54546a.getPageContext().getPageActivity(), this.f54548c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, p), NoDataViewFactory.e.d(null, this.f54546a.getResources().getString(i2)), null);
            this.f54551f = a2;
            a2.setOnClickListener(this.o);
        }
        this.f54551f.setTextOption(NoDataViewFactory.e.d(null, this.f54546a.getResources().getString(i2)));
        this.f54551f.f(this.f54546a.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f54551f.setVisibility(0);
    }

    public void u(RecommendForumInfo recommendForumInfo, boolean z) {
        this.m.r(z);
        this.j.setShowState(recommendForumInfo, z);
    }
}
