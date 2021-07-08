package d.a.p0.g1.f;

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
import d.a.p0.g1.a.j;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends d.a.c.a.d<RelateTopicForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelateTopicForumActivity f56494a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f56495b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f56496c;

    /* renamed from: d  reason: collision with root package name */
    public View f56497d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f56498e;

    /* renamed from: f  reason: collision with root package name */
    public j f56499f;

    /* renamed from: g  reason: collision with root package name */
    public List<RelateForumItemData> f56500g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f56501h;

    /* renamed from: i  reason: collision with root package name */
    public AdapterView.OnItemClickListener f56502i;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f56503e;

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
            this.f56503e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            RelateForumItemData relateForumItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || (relateForumItemData = (RelateForumItemData) this.f56503e.f56500g.get(i2)) == null || !k.isForumName(relateForumItemData.forumName)) {
                return;
            }
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.a.p0.g1.c.k.f56437a).param("topic_id", this.f56503e.f56494a.getTopicId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f56503e.f56494a.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
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
        this.f56495b = null;
        this.f56497d = null;
        this.f56498e = null;
        this.f56500g = null;
        this.f56502i = new a(this);
        this.f56494a = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.f56500g = list.subList(0, 20);
            } else {
                this.f56500g = list;
            }
        }
        h();
    }

    public j f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56499f : (j) invokeV.objValue;
    }

    public void g() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f56498e) == null || this.f56501h == null) {
            return;
        }
        bdListView.setNextPage(null);
        this.f56501h.i();
    }

    public final void h() {
        RelateTopicForumActivity relateTopicForumActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (relateTopicForumActivity = this.f56494a) == null) {
            return;
        }
        relateTopicForumActivity.setContentView(R.layout.hot_topic_more_activity);
        View findViewById = this.f56494a.findViewById(R.id.topic_list_root_view);
        this.f56497d = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f56495b = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56495b.setTitleText(R.string.hot_topic_list_navigationbar_title);
        this.f56496c = (NoNetworkView) this.f56497d.findViewById(R.id.view_no_network);
        this.f56498e = (BdListView) this.f56497d.findViewById(R.id.hot_topic_more_list);
        BdListViewHelper.d(this.f56494a.getActivity(), this.f56498e, BdListViewHelper.HeadType.DEFAULT);
        this.f56499f = new j(this.f56494a);
        PbListView pbListView = new PbListView(this.f56494a.getPageContext().getPageActivity());
        this.f56501h = pbListView;
        pbListView.a();
        this.f56501h.o(R.color.CAM_X0201);
        this.f56498e.setAdapter((ListAdapter) this.f56499f);
        this.f56499f.d(this.f56500g, this.f56494a.getTopicId());
        this.f56498e.setOnItemClickListener(this.f56502i);
    }

    public void j() {
        BdListView bdListView;
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdListView = this.f56498e) == null || (pbListView = this.f56501h) == null) {
            return;
        }
        bdListView.setNextPage(pbListView);
        this.f56501h.f();
        this.f56501h.A(this.f56494a.getResources().getString(R.string.list_no_more));
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f56494a.getLayoutMode().k(i2 == 1);
            this.f56494a.getLayoutMode().j(this.f56497d);
            this.f56495b.onChangeSkinType(this.f56494a.getPageContext(), i2);
            this.f56496c.c(this.f56494a.getPageContext(), i2);
            this.f56501h.d(i2);
        }
    }
}
