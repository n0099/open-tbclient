package d.a.j0.c1.f;

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
import d.a.j0.c1.a.j;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.c.a.d<RelateTopicForumActivity> {

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f51772a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f51773b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f51774c;

    /* renamed from: d  reason: collision with root package name */
    public View f51775d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f51776e;

    /* renamed from: f  reason: collision with root package name */
    public j f51777f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f51778g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f51779h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f51780i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            RelateForumItemData relateForumItemData;
            if (i2 < 0 || (relateForumItemData = (RelateForumItemData) d.this.f51778g.get(i2)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.a.j0.c1.c.k.f51715a).param("topic_id", d.this.f51772a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f51772a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.f51773b = null;
        this.f51775d = null;
        this.f51776e = null;
        this.f51778g = null;
        this.f51780i = new a();
        this.f51772a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f51778g = list.subList(0, 20);
            } else {
                this.f51778g = list;
            }
        }
        h();
    }

    public j f() {
        return this.f51777f;
    }

    public void g() {
        BdListView bdListView = this.f51776e;
        if (bdListView == null || this.f51779h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f51779h.i();
    }

    public final void h() {
        RelateTopicForumActivity relateTopicForumActivity = this.f51772a;
        if (relateTopicForumActivity == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f51772a.findViewById(R.id.topic_list_root_view);
        this.f51775d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f51773b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f51773b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f51774c = (NoNetworkView) this.f51775d.findViewById(R.id.view_no_network);
        this.f51776e = (BdListView) this.f51775d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f51772a.getActivity(), this.f51776e, BdListViewHelper.HeadType.DEFAULT);
        this.f51777f = new j(this.f51772a);
        PbListView pbListView = new PbListView(this.f51772a.getPageContext().getPageActivity());
        this.f51779h = pbListView;
        pbListView.a();
        this.f51779h.o(R.color.CAM_X0201);
        this.f51776e.setAdapter((ListAdapter) this.f51777f);
        this.f51777f.d(this.f51778g, this.f51772a.getTopicId());
        this.f51776e.setOnItemClickListener(this.f51780i);
    }

    public void j() {
        PbListView pbListView;
        BdListView bdListView = this.f51776e;
        if (bdListView == null || (pbListView = this.f51779h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f51779h.f();
        this.f51779h.A(this.f51772a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        this.f51772a.getLayoutMode().k(i2 == 1);
        this.f51772a.getLayoutMode().j(this.f51775d);
        this.f51773b.onChangeSkinType(this.f51772a.getPageContext(), i2);
        this.f51774c.c(this.f51772a.getPageContext(), i2);
        this.f51779h.d(i2);
    }
}
