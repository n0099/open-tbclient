package d.b.j0.c1.f;

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
import d.b.j0.c1.a.j;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.c.a.d<RelateTopicForumActivity> {

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f54004a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f54005b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f54006c;

    /* renamed from: d  reason: collision with root package name */
    public View f54007d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f54008e;

    /* renamed from: f  reason: collision with root package name */
    public j f54009f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f54010g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f54011h;
    public AdapterView.OnItemClickListener i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            RelateForumItemData relateForumItemData;
            if (i < 0 || (relateForumItemData = (RelateForumItemData) d.this.f54010g.get(i)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.b.j0.c1.c.k.f53952a).param("topic_id", d.this.f54004a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f54004a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.f54005b = null;
        this.f54007d = null;
        this.f54008e = null;
        this.f54010g = null;
        this.i = new a();
        this.f54004a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f54010g = list.subList(0, 20);
            } else {
                this.f54010g = list;
            }
        }
        i();
    }

    public j f() {
        return this.f54009f;
    }

    public void h() {
        BdListView bdListView = this.f54008e;
        if (bdListView == null || this.f54011h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f54011h.i();
    }

    public final void i() {
        RelateTopicForumActivity relateTopicForumActivity = this.f54004a;
        if (relateTopicForumActivity == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f54004a.findViewById(R.id.topic_list_root_view);
        this.f54007d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f54005b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54005b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f54006c = (NoNetworkView) this.f54007d.findViewById(R.id.view_no_network);
        this.f54008e = (BdListView) this.f54007d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f54004a.getActivity(), this.f54008e, BdListViewHelper.HeadType.DEFAULT);
        this.f54009f = new j(this.f54004a);
        PbListView pbListView = new PbListView(this.f54004a.getPageContext().getPageActivity());
        this.f54011h = pbListView;
        pbListView.a();
        this.f54011h.o(R.color.CAM_X0201);
        this.f54008e.setAdapter((ListAdapter) this.f54009f);
        this.f54009f.d(this.f54010g, this.f54004a.getTopicId());
        this.f54008e.setOnItemClickListener(this.i);
    }

    public void k() {
        PbListView pbListView;
        BdListView bdListView = this.f54008e;
        if (bdListView == null || (pbListView = this.f54011h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f54011h.f();
        this.f54011h.A(this.f54004a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.f54004a.getLayoutMode().k(i == 1);
        this.f54004a.getLayoutMode().j(this.f54007d);
        this.f54005b.onChangeSkinType(this.f54004a.getPageContext(), i);
        this.f54006c.c(this.f54004a.getPageContext(), i);
        this.f54011h.d(i);
    }
}
