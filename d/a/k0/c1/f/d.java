package d.a.k0.c1.f;

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
import d.a.k0.c1.a.j;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.c.a.d<RelateTopicForumActivity> {

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f52471a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f52472b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f52473c;

    /* renamed from: d  reason: collision with root package name */
    public View f52474d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f52475e;

    /* renamed from: f  reason: collision with root package name */
    public j f52476f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f52477g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f52478h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f52479i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            RelateForumItemData relateForumItemData;
            if (i2 < 0 || (relateForumItemData = (RelateForumItemData) d.this.f52477g.get(i2)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.a.k0.c1.c.k.f52414a).param("topic_id", d.this.f52471a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f52471a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.f52472b = null;
        this.f52474d = null;
        this.f52475e = null;
        this.f52477g = null;
        this.f52479i = new a();
        this.f52471a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f52477g = list.subList(0, 20);
            } else {
                this.f52477g = list;
            }
        }
        h();
    }

    public j f() {
        return this.f52476f;
    }

    public void g() {
        BdListView bdListView = this.f52475e;
        if (bdListView == null || this.f52478h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f52478h.i();
    }

    public final void h() {
        RelateTopicForumActivity relateTopicForumActivity = this.f52471a;
        if (relateTopicForumActivity == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f52471a.findViewById(R.id.topic_list_root_view);
        this.f52474d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f52472b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f52472b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f52473c = (NoNetworkView) this.f52474d.findViewById(R.id.view_no_network);
        this.f52475e = (BdListView) this.f52474d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f52471a.getActivity(), this.f52475e, BdListViewHelper.HeadType.DEFAULT);
        this.f52476f = new j(this.f52471a);
        PbListView pbListView = new PbListView(this.f52471a.getPageContext().getPageActivity());
        this.f52478h = pbListView;
        pbListView.a();
        this.f52478h.o(R.color.CAM_X0201);
        this.f52475e.setAdapter((ListAdapter) this.f52476f);
        this.f52476f.d(this.f52477g, this.f52471a.getTopicId());
        this.f52475e.setOnItemClickListener(this.f52479i);
    }

    public void j() {
        PbListView pbListView;
        BdListView bdListView = this.f52475e;
        if (bdListView == null || (pbListView = this.f52478h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f52478h.f();
        this.f52478h.A(this.f52471a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        this.f52471a.getLayoutMode().k(i2 == 1);
        this.f52471a.getLayoutMode().j(this.f52474d);
        this.f52472b.onChangeSkinType(this.f52471a.getPageContext(), i2);
        this.f52473c.c(this.f52471a.getPageContext(), i2);
        this.f52478h.d(i2);
    }
}
