package d.a.q0.g1.f;

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
import d.a.d.a.f;
import d.a.d.e.p.k;
import d.a.q0.g1.a.j;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends d.a.d.a.d<RelateTopicForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f57038a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f57039b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f57040c;

    /* renamed from: d  reason: collision with root package name */
    public View f57041d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f57042e;

    /* renamed from: f  reason: collision with root package name */
    public j f57043f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f57044g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f57045h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f57046i;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57047e;

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
            this.f57047e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            RelateForumItemData relateForumItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || (relateForumItemData = (RelateForumItemData) this.f57047e.f57044g.get(i2)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.a.q0.g1.c.k.f56981a).param("topic_id", this.f57047e.f57038a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57047e.f57038a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
        this.f57039b = null;
        this.f57041d = null;
        this.f57042e = null;
        this.f57044g = null;
        this.f57046i = new a(this);
        this.f57038a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f57044g = list.subList(0, 20);
            } else {
                this.f57044g = list;
            }
        }
        h();
    }

    public j f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57043f : (j) invokeV.objValue;
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f57042e) == null || this.f57045h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f57045h.i();
    }

    public final void h() {
        RelateTopicForumActivity relateTopicForumActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (relateTopicForumActivity = this.f57038a) == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f57038a.findViewById(R.id.topic_list_root_view);
        this.f57041d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f57039b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57039b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f57040c = (NoNetworkView) this.f57041d.findViewById(R.id.view_no_network);
        this.f57042e = (BdListView) this.f57041d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f57038a.getActivity(), this.f57042e, BdListViewHelper.HeadType.DEFAULT);
        this.f57043f = new j(this.f57038a);
        PbListView pbListView = new PbListView(this.f57038a.getPageContext().getPageActivity());
        this.f57045h = pbListView;
        pbListView.a();
        this.f57045h.o(R.color.CAM_X0201);
        this.f57042e.setAdapter((ListAdapter) this.f57043f);
        this.f57043f.d(this.f57044g, this.f57038a.getTopicId());
        this.f57042e.setOnItemClickListener(this.f57046i);
    }

    public void j() {
        BdListView bdListView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdListView = this.f57042e) == null || (pbListView = this.f57045h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f57045h.f();
        this.f57045h.A(this.f57038a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f57038a.getLayoutMode().k(i2 == 1);
            this.f57038a.getLayoutMode().j(this.f57041d);
            this.f57039b.onChangeSkinType(this.f57038a.getPageContext(), i2);
            this.f57040c.c(this.f57038a.getPageContext(), i2);
            this.f57045h.d(i2);
        }
    }
}
