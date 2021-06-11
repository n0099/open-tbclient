package d.a.n0.d1.f;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import d.a.c.e.p.k;
import d.a.n0.d1.a.j;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.c.a.d<RelateTopicForumActivity> {

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f56340a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f56341b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f56342c;

    /* renamed from: d  reason: collision with root package name */
    public View f56343d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f56344e;

    /* renamed from: f  reason: collision with root package name */
    public j f56345f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f56346g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f56347h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f56348i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            RelateForumItemData relateForumItemData;
            if (i2 < 0 || (relateForumItemData = (RelateForumItemData) d.this.f56346g.get(i2)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.a.n0.d1.c.k.f56283a).param("topic_id", d.this.f56340a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f56340a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.f56341b = null;
        this.f56343d = null;
        this.f56344e = null;
        this.f56346g = null;
        this.f56348i = new a();
        this.f56340a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f56346g = list.subList(0, 20);
            } else {
                this.f56346g = list;
            }
        }
        i();
    }

    public j f() {
        return this.f56345f;
    }

    public void h() {
        BdListView bdListView = this.f56344e;
        if (bdListView == null || this.f56347h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f56347h.i();
    }

    public final void i() {
        RelateTopicForumActivity relateTopicForumActivity = this.f56340a;
        if (relateTopicForumActivity == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f56340a.findViewById(R.id.topic_list_root_view);
        this.f56343d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f56341b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56341b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f56342c = (NoNetworkView) this.f56343d.findViewById(R.id.view_no_network);
        this.f56344e = (BdListView) this.f56343d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f56340a.getActivity(), this.f56344e, BdListViewHelper.HeadType.DEFAULT);
        this.f56345f = new j(this.f56340a);
        PbListView pbListView = new PbListView(this.f56340a.getPageContext().getPageActivity());
        this.f56347h = pbListView;
        pbListView.a();
        this.f56347h.o(R.color.CAM_X0201);
        this.f56344e.setAdapter((ListAdapter) this.f56345f);
        this.f56345f.d(this.f56346g, this.f56340a.getTopicId());
        this.f56344e.setOnItemClickListener(this.f56348i);
    }

    public void k() {
        PbListView pbListView;
        BdListView bdListView = this.f56344e;
        if (bdListView == null || (pbListView = this.f56347h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f56347h.f();
        this.f56347h.A(this.f56340a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        this.f56340a.getLayoutMode().k(i2 == 1);
        this.f56340a.getLayoutMode().j(this.f56343d);
        this.f56341b.onChangeSkinType(this.f56340a.getPageContext(), i2);
        this.f56342c.c(this.f56340a.getPageContext(), i2);
        this.f56347h.d(i2);
    }
}
