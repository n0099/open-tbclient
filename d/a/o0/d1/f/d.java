package d.a.o0.d1.f;

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
import d.a.o0.d1.a.j;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.c.a.d<RelateTopicForumActivity> {

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f56465a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f56466b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f56467c;

    /* renamed from: d  reason: collision with root package name */
    public View f56468d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f56469e;

    /* renamed from: f  reason: collision with root package name */
    public j f56470f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f56471g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f56472h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f56473i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            RelateForumItemData relateForumItemData;
            if (i2 < 0 || (relateForumItemData = (RelateForumItemData) d.this.f56471g.get(i2)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.a.o0.d1.c.k.f56408a).param("topic_id", d.this.f56465a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f56465a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.f56466b = null;
        this.f56468d = null;
        this.f56469e = null;
        this.f56471g = null;
        this.f56473i = new a();
        this.f56465a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f56471g = list.subList(0, 20);
            } else {
                this.f56471g = list;
            }
        }
        i();
    }

    public j f() {
        return this.f56470f;
    }

    public void h() {
        BdListView bdListView = this.f56469e;
        if (bdListView == null || this.f56472h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f56472h.i();
    }

    public final void i() {
        RelateTopicForumActivity relateTopicForumActivity = this.f56465a;
        if (relateTopicForumActivity == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f56465a.findViewById(R.id.topic_list_root_view);
        this.f56468d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f56466b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56466b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f56467c = (NoNetworkView) this.f56468d.findViewById(R.id.view_no_network);
        this.f56469e = (BdListView) this.f56468d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f56465a.getActivity(), this.f56469e, BdListViewHelper.HeadType.DEFAULT);
        this.f56470f = new j(this.f56465a);
        PbListView pbListView = new PbListView(this.f56465a.getPageContext().getPageActivity());
        this.f56472h = pbListView;
        pbListView.a();
        this.f56472h.o(R.color.CAM_X0201);
        this.f56469e.setAdapter((ListAdapter) this.f56470f);
        this.f56470f.d(this.f56471g, this.f56465a.getTopicId());
        this.f56469e.setOnItemClickListener(this.f56473i);
    }

    public void k() {
        PbListView pbListView;
        BdListView bdListView = this.f56469e;
        if (bdListView == null || (pbListView = this.f56472h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f56472h.f();
        this.f56472h.A(this.f56465a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        this.f56465a.getLayoutMode().k(i2 == 1);
        this.f56465a.getLayoutMode().j(this.f56468d);
        this.f56466b.onChangeSkinType(this.f56465a.getPageContext(), i2);
        this.f56467c.c(this.f56465a.getPageContext(), i2);
        this.f56472h.d(i2);
    }
}
