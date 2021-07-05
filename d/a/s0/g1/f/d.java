package d.a.s0.g1.f;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.p.k;
import d.a.s0.g1.a.j;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends d.a.c.a.d<RelateTopicForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f59752a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f59753b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f59754c;

    /* renamed from: d  reason: collision with root package name */
    public View f59755d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f59756e;

    /* renamed from: f  reason: collision with root package name */
    public j f59757f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f59758g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f59759h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f59760i;

    /* loaded from: classes9.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59761e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59761e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            RelateForumItemData relateForumItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || (relateForumItemData = (RelateForumItemData) this.f59761e.f59758g.get(i2)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.a.s0.g1.c.k.f59695a).param("topic_id", this.f59761e.f59752a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f59761e.f59752a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {relateTopicForumActivity, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59753b = null;
        this.f59755d = null;
        this.f59756e = null;
        this.f59758g = null;
        this.f59760i = new a(this);
        this.f59752a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f59758g = list.subList(0, 20);
            } else {
                this.f59758g = list;
            }
        }
        i();
    }

    public j f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59757f : (j) invokeV.objValue;
    }

    public void h() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f59756e) == null || this.f59759h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f59759h.i();
    }

    public final void i() {
        RelateTopicForumActivity relateTopicForumActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (relateTopicForumActivity = this.f59752a) == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f59752a.findViewById(R.id.topic_list_root_view);
        this.f59755d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f59753b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59753b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f59754c = (NoNetworkView) this.f59755d.findViewById(R.id.view_no_network);
        this.f59756e = (BdListView) this.f59755d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f59752a.getActivity(), this.f59756e, BdListViewHelper.HeadType.DEFAULT);
        this.f59757f = new j(this.f59752a);
        PbListView pbListView = new PbListView(this.f59752a.getPageContext().getPageActivity());
        this.f59759h = pbListView;
        pbListView.a();
        this.f59759h.o(R.color.CAM_X0201);
        this.f59756e.setAdapter((ListAdapter) this.f59757f);
        this.f59757f.d(this.f59758g, this.f59752a.getTopicId());
        this.f59756e.setOnItemClickListener(this.f59760i);
    }

    public void k() {
        BdListView bdListView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdListView = this.f59756e) == null || (pbListView = this.f59759h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f59759h.f();
        this.f59759h.A(this.f59752a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f59752a.getLayoutMode().k(i2 == 1);
            this.f59752a.getLayoutMode().j(this.f59755d);
            this.f59753b.onChangeSkinType(this.f59752a.getPageContext(), i2);
            this.f59754c.c(this.f59752a.getPageContext(), i2);
            this.f59759h.d(i2);
        }
    }
}
