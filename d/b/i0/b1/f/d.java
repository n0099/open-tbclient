package d.b.i0.b1.f;

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
import d.b.b.e.p.k;
import d.b.i0.b1.a.j;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.b.a.d<RelateTopicForumActivity> {

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f52181a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f52182b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f52183c;

    /* renamed from: d  reason: collision with root package name */
    public View f52184d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f52185e;

    /* renamed from: f  reason: collision with root package name */
    public j f52186f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f52187g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f52188h;
    public AdapterView.OnItemClickListener i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            RelateForumItemData relateForumItemData;
            if (i < 0 || (relateForumItemData = (RelateForumItemData) d.this.f52187g.get(i)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.b.i0.b1.c.k.f52129a).param("topic_id", d.this.f52181a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f52181a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.f52182b = null;
        this.f52184d = null;
        this.f52185e = null;
        this.f52187g = null;
        this.i = new a();
        this.f52181a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f52187g = list.subList(0, 20);
            } else {
                this.f52187g = list;
            }
        }
        i();
    }

    public j f() {
        return this.f52186f;
    }

    public void h() {
        BdListView bdListView = this.f52185e;
        if (bdListView == null || this.f52188h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f52188h.i();
    }

    public final void i() {
        RelateTopicForumActivity relateTopicForumActivity = this.f52181a;
        if (relateTopicForumActivity == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f52181a.findViewById(R.id.topic_list_root_view);
        this.f52184d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f52182b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f52182b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f52183c = (NoNetworkView) this.f52184d.findViewById(R.id.view_no_network);
        this.f52185e = (BdListView) this.f52184d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f52181a.getActivity(), this.f52185e, BdListViewHelper.HeadType.DEFAULT);
        this.f52186f = new j(this.f52181a);
        PbListView pbListView = new PbListView(this.f52181a.getPageContext().getPageActivity());
        this.f52188h = pbListView;
        pbListView.a();
        this.f52188h.o(R.color.CAM_X0201);
        this.f52185e.setAdapter((ListAdapter) this.f52186f);
        this.f52186f.d(this.f52187g, this.f52181a.getTopicId());
        this.f52185e.setOnItemClickListener(this.i);
    }

    public void k() {
        PbListView pbListView;
        BdListView bdListView = this.f52185e;
        if (bdListView == null || (pbListView = this.f52188h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f52188h.f();
        this.f52188h.A(this.f52181a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i) {
        this.f52181a.getLayoutMode().k(i == 1);
        this.f52181a.getLayoutMode().j(this.f52184d);
        this.f52182b.onChangeSkinType(this.f52181a.getPageContext(), i);
        this.f52183c.c(this.f52181a.getPageContext(), i);
        this.f52188h.d(i);
    }
}
