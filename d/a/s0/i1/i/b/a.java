package d.a.s0.i1.i.b;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.detail.BarEmotionResponseMessage;
import com.baidu.tieba.im.forum.detail.ForumDetailActivity;
import com.baidu.tieba.im.forum.detail.ItemEmotionView;
import com.baidu.tieba.im.forum.detail.ItemFootNavView;
import com.baidu.tieba.im.forum.detail.ItemHeaderView;
import com.baidu.tieba.im.forum.detail.ItemHotThreadView;
import com.baidu.tieba.im.forum.detail.ItemInfoView;
import com.baidu.tieba.im.forum.detail.ItemMsgManage;
import com.baidu.tieba.view.CustomScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.d;
import d.a.c.a.f;
import d.a.r0.r.s.a;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes9.dex */
public class a extends d<ForumDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumDetailActivity f61703a;

    /* renamed from: b  reason: collision with root package name */
    public View f61704b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f61705c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61706d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f61707e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f61708f;

    /* renamed from: g  reason: collision with root package name */
    public CustomScrollView f61709g;

    /* renamed from: h  reason: collision with root package name */
    public ItemHeaderView f61710h;

    /* renamed from: i  reason: collision with root package name */
    public ItemInfoView f61711i;
    public ItemMsgManage j;
    public ItemEmotionView k;
    public ItemHotThreadView l;
    public ItemFootNavView m;
    public d.a.r0.r.s.a n;
    public View.OnClickListener o;

    /* renamed from: d.a.s0.i1.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1508a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61712e;

        public C1508a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61712e = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f61712e.n.dismiss();
                this.f61712e.f61703a.clearHistory();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61713e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61713e = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f61713e.n.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61714e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61714e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f61714e.m.o(false);
                } else if (action == 1) {
                    this.f61714e.m.o(true);
                } else if (action == 2) {
                    this.f61714e.m.o(false);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ c(a aVar, C1508a c1508a) {
            this(aVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1163112583, "Ld/a/s0/i1/i/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1163112583, "Ld/a/s0/i1/i/b/a;");
                return;
            }
        }
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds364);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ForumDetailActivity forumDetailActivity) {
        super(forumDetailActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumDetailActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61703a = forumDetailActivity;
        initUI();
    }

    public NoNetworkView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61707e : (NoNetworkView) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f61703a.hideLoadingView(this.f61704b);
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f61705c = (LinearLayout) this.f61703a.findViewById(R.id.scoll_view_ll);
            TextView textView = new TextView(this.f61703a.getActivity());
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)));
            this.f61705c.addView(textView, 0);
            NavigationBar navigationBar = (NavigationBar) this.f61703a.findViewById(R.id.view_navigation_bar);
            this.f61706d = navigationBar;
            navigationBar.setCenterTextTitle(this.f61703a.getPageContext().getString(R.string.forum_detail_title));
            this.f61706d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f61706d.showBottomLine();
            this.f61707e = (NoNetworkView) this.f61703a.findViewById(R.id.no_network_view);
            CustomScrollView customScrollView = (CustomScrollView) this.f61703a.findViewById(R.id.scoll_view);
            this.f61709g = customScrollView;
            customScrollView.setOnTouchListener(new c(this, null));
            this.f61710h = (ItemHeaderView) this.f61703a.findViewById(R.id.item_header);
            this.f61711i = (ItemInfoView) this.f61703a.findViewById(R.id.item_info);
            this.j = (ItemMsgManage) this.f61703a.findViewById(R.id.item_msg_manage);
            this.k = (ItemEmotionView) this.f61703a.findViewById(R.id.item_emotion_manage);
            this.l = (ItemHotThreadView) this.f61703a.findViewById(R.id.item_hot_thread);
            ItemFootNavView itemFootNavView = (ItemFootNavView) this.f61703a.findViewById(R.id.item_foot_nav);
            this.m = itemFootNavView;
            itemFootNavView.setClickable(true);
            this.f61704b = this.f61703a.findViewById(R.id.root_rl);
            this.j.setMsgOnClickListener(this.f61703a);
            this.k.setEmotionOnClickListener(this.f61703a);
            this.j.setSwitchChangeListener(this.f61703a);
        }
    }

    public void k() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (noDataView = this.f61708f) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m.n(this.f61703a);
        }
    }

    public void m(BarEmotionResponseMessage.ForumEmotionData forumEmotionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, forumEmotionData) == null) {
            this.k.setEmotionData(forumEmotionData);
        }
    }

    public void n(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab, BzApplySwitch bzApplySwitch) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{recommendForumInfo, Boolean.valueOf(z), Boolean.valueOf(z2), managerApplyInfo, priManagerApplyInfo, managerElectionTab, bzApplySwitch}) == null) {
            this.f61710h.setData(recommendForumInfo);
            this.f61711i.setData(recommendForumInfo);
            this.j.setData(recommendForumInfo, z, z2, managerApplyInfo, priManagerApplyInfo, managerElectionTab);
            this.m.setData(recommendForumInfo, this.f61703a);
        }
    }

    public void o(RecommendForumInfo recommendForumInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, recommendForumInfo, z) == null) {
            this.j.setShowState(recommendForumInfo, z);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f61703a.getLayoutMode().k(i2 == 1);
            this.f61703a.getLayoutMode().j(this.f61704b);
            this.f61706d.onChangeSkinType(getPageContext(), i2);
            this.f61707e.c(getPageContext(), i2);
            this.f61710h.b(this.f61703a, i2);
            this.f61711i.b(this.f61703a, i2);
            this.j.b(this.f61703a, i2);
            this.l.d(this.f61703a, i2);
            this.m.m(this.f61703a, i2);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.j.setSwitch(z);
        }
    }

    public void r(List<SimpleThreadInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.l.setData(list);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.n == null) {
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f61703a.getPageContext().getPageActivity());
                this.n = aVar;
                aVar.setMessageId(R.string.officical_bar_info_clean_alert);
                this.n.setPositiveButton(R.string.alert_yes_button, new C1508a(this));
                this.n.setNegativeButton(R.string.cancel, new b(this));
            }
            this.n.create(getPageContext()).show();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f61703a.showLoadingView(this.f61704b);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (this.f61708f == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f61703a.getPageContext().getPageActivity(), this.f61705c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, p), NoDataViewFactory.e.d(null, this.f61703a.getResources().getString(i2)), null);
                this.f61708f = a2;
                a2.setOnClickListener(this.o);
            }
            this.f61708f.setTextOption(NoDataViewFactory.e.d(null, this.f61703a.getResources().getString(i2)));
            this.f61708f.f(this.f61703a.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.f61708f.setVisibility(0);
        }
    }

    public void v(RecommendForumInfo recommendForumInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, recommendForumInfo, z) == null) {
            this.m.r(z);
            this.j.setShowState(recommendForumInfo, z);
        }
    }
}
