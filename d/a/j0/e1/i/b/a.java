package d.a.j0.e1.i.b;

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
import d.a.i0.r.s.a;
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
    public ForumDetailActivity f53649a;

    /* renamed from: b  reason: collision with root package name */
    public View f53650b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f53651c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f53652d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f53653e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f53654f;

    /* renamed from: g  reason: collision with root package name */
    public CustomScrollView f53655g;

    /* renamed from: h  reason: collision with root package name */
    public ItemHeaderView f53656h;

    /* renamed from: i  reason: collision with root package name */
    public ItemInfoView f53657i;
    public ItemMsgManage j;
    public ItemEmotionView k;
    public ItemHotThreadView l;
    public ItemFootNavView m;
    public d.a.i0.r.s.a n;
    public View.OnClickListener o;

    /* renamed from: d.a.j0.e1.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1224a implements a.e {
        public C1224a() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            a.this.n.dismiss();
            a.this.f53649a.clearHistory();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
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

        public /* synthetic */ c(a aVar, C1224a c1224a) {
            this();
        }
    }

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.f53649a = forumDetailActivity;
        initUI();
    }

    public NoNetworkView g() {
        return this.f53653e;
    }

    public void h() {
        this.f53649a.hideLoadingView(this.f53650b);
    }

    public final void initUI() {
        this.f53651c = (LinearLayout) this.f53649a.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.f53649a.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f53651c.addView(textView, 0);
        NavigationBar navigationBar = (NavigationBar) this.f53649a.findViewById(R.id.view_navigation_bar);
        this.f53652d = navigationBar;
        navigationBar.setCenterTextTitle(this.f53649a.getPageContext().getString(R.string.forum_detail_title));
        this.f53652d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53652d.showBottomLine();
        this.f53653e = (NoNetworkView) this.f53649a.findViewById(R.id.no_network_view);
        CustomScrollView customScrollView = (CustomScrollView) this.f53649a.findViewById(R.id.scoll_view);
        this.f53655g = customScrollView;
        customScrollView.setOnTouchListener(new c(this, null));
        this.f53656h = (ItemHeaderView) this.f53649a.findViewById(R.id.item_header);
        this.f53657i = (ItemInfoView) this.f53649a.findViewById(R.id.item_info);
        this.j = (ItemMsgManage) this.f53649a.findViewById(R.id.item_msg_manage);
        this.k = (ItemEmotionView) this.f53649a.findViewById(R.id.item_emotion_manage);
        this.l = (ItemHotThreadView) this.f53649a.findViewById(R.id.item_hot_thread);
        ItemFootNavView itemFootNavView = (ItemFootNavView) this.f53649a.findViewById(R.id.item_foot_nav);
        this.m = itemFootNavView;
        itemFootNavView.setClickable(true);
        this.f53650b = this.f53649a.findViewById(R.id.root_rl);
        this.j.setMsgOnClickListener(this.f53649a);
        this.k.setEmotionOnClickListener(this.f53649a);
        this.j.setSwitchChangeListener(this.f53649a);
    }

    public void j() {
        NoDataView noDataView = this.f53654f;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public void k() {
        this.m.n(this.f53649a);
    }

    public void l(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.k.setEmotionData(forumEmotionData);
    }

    public void m(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.f53656h.setData(recommendForumInfo);
        this.f53657i.setData(recommendForumInfo);
        this.j.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.m.setData(recommendForumInfo, this.f53649a);
    }

    public void n(RecommendForumInfo recommendForumInfo, boolean z) {
        this.j.setShowState(recommendForumInfo, z);
    }

    public void o(View.OnClickListener onClickListener) {
        this.o = onClickListener;
    }

    public void onChangeSkinType(int i2) {
        this.f53649a.getLayoutMode().k(i2 == 1);
        this.f53649a.getLayoutMode().j(this.f53650b);
        this.f53652d.onChangeSkinType(getPageContext(), i2);
        this.f53653e.c(getPageContext(), i2);
        this.f53656h.b(this.f53649a, i2);
        this.f53657i.b(this.f53649a, i2);
        this.j.b(this.f53649a, i2);
        this.l.d(this.f53649a, i2);
        this.m.m(this.f53649a, i2);
    }

    public void p(boolean z) {
        this.j.setSwitch(z);
    }

    public void q(List<SimpleThreadInfo> list) {
        this.l.setData(list);
    }

    public void r() {
        if (this.n == null) {
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f53649a.getPageContext().getPageActivity());
            this.n = aVar;
            aVar.setMessageId(R.string.officical_bar_info_clean_alert);
            this.n.setPositiveButton(R.string.alert_yes_button, new C1224a());
            this.n.setNegativeButton(R.string.cancel, new b());
        }
        this.n.create(getPageContext()).show();
    }

    public void s() {
        this.f53649a.showLoadingView(this.f53650b);
    }

    public void t(int i2) {
        if (this.f53654f == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f53649a.getPageContext().getPageActivity(), this.f53651c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, p), NoDataViewFactory.e.d(null, this.f53649a.getResources().getString(i2)), null);
            this.f53654f = a2;
            a2.setOnClickListener(this.o);
        }
        this.f53654f.setTextOption(NoDataViewFactory.e.d(null, this.f53649a.getResources().getString(i2)));
        this.f53654f.f(this.f53649a.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f53654f.setVisibility(0);
    }

    public void u(RecommendForumInfo recommendForumInfo, boolean z) {
        this.m.r(z);
        this.j.setShowState(recommendForumInfo, z);
    }
}
