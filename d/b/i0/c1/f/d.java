package d.b.i0.c1.f;

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
import d.b.c.e.p.k;
import d.b.i0.c1.a.j;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.c.a.d<RelateTopicForumActivity> {

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f53583a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f53584b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f53585c;

    /* renamed from: d  reason: collision with root package name */
    public View f53586d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f53587e;

    /* renamed from: f  reason: collision with root package name */
    public j f53588f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f53589g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f53590h;
    public AdapterView.OnItemClickListener i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            RelateForumItemData relateForumItemData;
            if (i < 0 || (relateForumItemData = (RelateForumItemData) d.this.f53589g.get(i)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.b.i0.c1.c.k.f53531a).param("topic_id", d.this.f53583a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f53583a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.f53584b = null;
        this.f53586d = null;
        this.f53587e = null;
        this.f53589g = null;
        this.i = new a();
        this.f53583a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f53589g = list.subList(0, 20);
            } else {
                this.f53589g = list;
            }
        }
        i();
    }

    public j f() {
        return this.f53588f;
    }

    public void h() {
        BdListView bdListView = this.f53587e;
        if (bdListView == null || this.f53590h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f53590h.i();
    }

    public final void i() {
        RelateTopicForumActivity relateTopicForumActivity = this.f53583a;
        if (relateTopicForumActivity == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f53583a.findViewById(R.id.topic_list_root_view);
        this.f53586d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f53584b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53584b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f53585c = (NoNetworkView) this.f53586d.findViewById(R.id.view_no_network);
        this.f53587e = (BdListView) this.f53586d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f53583a.getActivity(), this.f53587e, BdListViewHelper.HeadType.DEFAULT);
        this.f53588f = new j(this.f53583a);
        PbListView pbListView = new PbListView(this.f53583a.getPageContext().getPageActivity());
        this.f53590h = pbListView;
        pbListView.a();
        this.f53590h.o(R.color.CAM_X0201);
        this.f53587e.setAdapter((ListAdapter) this.f53588f);
        this.f53588f.d(this.f53589g, this.f53583a.getTopicId());
        this.f53587e.setOnItemClickListener(this.i);
    }

    public void k() {
        PbListView pbListView;
        BdListView bdListView = this.f53587e;
        if (bdListView == null || (pbListView = this.f53590h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f53590h.f();
        this.f53590h.A(this.f53583a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.f53583a.getLayoutMode().k(i == 1);
        this.f53583a.getLayoutMode().j(this.f53586d);
        this.f53584b.onChangeSkinType(this.f53583a.getPageContext(), i);
        this.f53585c.c(this.f53583a.getPageContext(), i);
        this.f53590h.d(i);
    }
}
