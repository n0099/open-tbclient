package d.b.i0.d1.i.b;

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
import d.b.b.a.d;
import d.b.h0.r.s.a;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class a extends d<ForumDetailActivity> {
    public static final int p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);

    /* renamed from: a  reason: collision with root package name */
    public ForumDetailActivity f53849a;

    /* renamed from: b  reason: collision with root package name */
    public View f53850b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f53851c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f53852d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f53853e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f53854f;

    /* renamed from: g  reason: collision with root package name */
    public CustomScrollView f53855g;

    /* renamed from: h  reason: collision with root package name */
    public ItemHeaderView f53856h;
    public ItemInfoView i;
    public ItemMsgManage j;
    public ItemEmotionView k;
    public ItemHotThreadView l;
    public ItemFootNavView m;
    public d.b.h0.r.s.a n;
    public View.OnClickListener o;

    /* renamed from: d.b.i0.d1.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1199a implements a.e {
        public C1199a() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            a.this.n.dismiss();
            a.this.f53849a.clearHistory();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            a.this.n.dismiss();
        }
    }

    /* loaded from: classes3.dex */
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

        public /* synthetic */ c(a aVar, C1199a c1199a) {
            this();
        }
    }

    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        this.f53849a = forumDetailActivity;
        initUI();
    }

    public NoNetworkView h() {
        return this.f53853e;
    }

    public void i() {
        this.f53849a.hideLoadingView(this.f53850b);
    }

    public final void initUI() {
        this.f53851c = (LinearLayout) this.f53849a.findViewById(R.id.scoll_view_ll);
        TextView textView = new TextView(this.f53849a.getActivity());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
        this.f53851c.addView(textView, 0);
        NavigationBar navigationBar = (NavigationBar) this.f53849a.findViewById(R.id.view_navigation_bar);
        this.f53852d = navigationBar;
        navigationBar.setCenterTextTitle(this.f53849a.getPageContext().getString(R.string.forum_detail_title));
        this.f53852d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53852d.showBottomLine();
        this.f53853e = (NoNetworkView) this.f53849a.findViewById(R.id.no_network_view);
        CustomScrollView customScrollView = (CustomScrollView) this.f53849a.findViewById(R.id.scoll_view);
        this.f53855g = customScrollView;
        customScrollView.setOnTouchListener(new c(this, null));
        this.f53856h = (ItemHeaderView) this.f53849a.findViewById(R.id.item_header);
        this.i = (ItemInfoView) this.f53849a.findViewById(R.id.item_info);
        this.j = (ItemMsgManage) this.f53849a.findViewById(R.id.item_msg_manage);
        this.k = (ItemEmotionView) this.f53849a.findViewById(R.id.item_emotion_manage);
        this.l = (ItemHotThreadView) this.f53849a.findViewById(R.id.item_hot_thread);
        ItemFootNavView itemFootNavView = (ItemFootNavView) this.f53849a.findViewById(R.id.item_foot_nav);
        this.m = itemFootNavView;
        itemFootNavView.setClickable(true);
        this.f53850b = this.f53849a.findViewById(R.id.root_rl);
        this.j.setMsgOnClickListener(this.f53849a);
        this.k.setEmotionOnClickListener(this.f53849a);
        this.j.setSwitchChangeListener(this.f53849a);
    }

    public void k() {
        NoDataView noDataView = this.f53854f;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public void l() {
        this.m.n(this.f53849a);
    }

    public void m(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        this.k.setEmotionData(forumEmotionData);
    }

    public void n(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        this.f53856h.setData(recommendForumInfo);
        this.i.setData(recommendForumInfo);
        this.j.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
        this.m.setData(recommendForumInfo, this.f53849a);
    }

    public void o(RecommendForumInfo recommendForumInfo, boolean z) {
        this.j.setShowState(recommendForumInfo, z);
    }

    public void onChangeSkinType(int i) {
        this.f53849a.getLayoutMode().k(i == 1);
        this.f53849a.getLayoutMode().j(this.f53850b);
        this.f53852d.onChangeSkinType(getPageContext(), i);
        this.f53853e.c(getPageContext(), i);
        this.f53856h.b(this.f53849a, i);
        this.i.b(this.f53849a, i);
        this.j.b(this.f53849a, i);
        this.l.d(this.f53849a, i);
        this.m.m(this.f53849a, i);
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
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f53849a.getPageContext().getPageActivity());
            this.n = aVar;
            aVar.setMessageId(R.string.officical_bar_info_clean_alert);
            this.n.setPositiveButton(R.string.alert_yes_button, new C1199a());
            this.n.setNegativeButton(R.string.cancel, new b());
        }
        this.n.create(getPageContext()).show();
    }

    public void v() {
        this.f53849a.showLoadingView(this.f53850b);
    }

    public void w(int i) {
        if (this.f53854f == null) {
            NoDataView a2 = NoDataViewFactory.a(this.f53849a.getPageContext().getPageActivity(), this.f53851c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, p), NoDataViewFactory.e.d(null, this.f53849a.getResources().getString(i)), null);
            this.f53854f = a2;
            a2.setOnClickListener(this.o);
        }
        this.f53854f.setTextOption(NoDataViewFactory.e.d(null, this.f53849a.getResources().getString(i)));
        this.f53854f.f(this.f53849a.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f53854f.setVisibility(0);
    }

    public void x(RecommendForumInfo recommendForumInfo, boolean z) {
        this.m.r(z);
        this.j.setShowState(recommendForumInfo, z);
    }
}
