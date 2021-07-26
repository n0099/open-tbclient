package d.a.q0.j1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionImageUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.AtMessageActivity;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.q0.j1.b.f.b;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends d.a.d.a.d<AtMessageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.p0.i0.f.d<FeedData, d.a.p0.i0.d.b, d.a.q0.j1.b.a> f59567a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f59568b;

    /* renamed from: c  reason: collision with root package name */
    public View f59569c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f59570d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.s.f0.g f59571e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.i0.g.a f59572f;

    /* renamed from: g  reason: collision with root package name */
    public View f59573g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f59574h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f59575i;
    public List<FeedData> j;

    /* loaded from: classes8.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59576e;

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
            this.f59576e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f59576e.l(z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59577e;

        public b(d dVar) {
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
            this.f59577e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void p(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f59577e.f59570d.loadMoreData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f59578a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f59579b;

        public c(d dVar, FeedData feedData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, feedData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59579b = dVar;
            this.f59578a = feedData;
        }

        @Override // d.a.q0.j1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f59579b.j)) {
                return;
            }
            this.f59579b.j.remove(this.f59578a);
            if (this.f59579b.f59567a != null) {
                this.f59579b.f59567a.k(this.f59579b.j);
            }
        }
    }

    /* renamed from: d.a.q0.j1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1500d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f59580e;

        public RunnableC1500d(d dVar) {
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
            this.f59580e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59580e.f59568b.F();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atMessageActivity};
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
        this.f59570d = atMessageActivity;
    }

    public void g(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        d.a.q0.j1.b.f.a aVar = new d.a.q0.j1.b.f.a();
        aVar.f59601a = 2;
        aVar.f59602b = d.a.d.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f59603c = d.a.d.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f59604d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        d.a.q0.j1.b.f.b bVar = new d.a.q0.j1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void h() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f59568b) == null) {
            return;
        }
        bdListView.A(0L);
    }

    public void j(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            d.a.p0.i0.f.d<FeedData, d.a.p0.i0.d.b, d.a.q0.j1.b.a> dVar = this.f59567a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            d.a.p0.i0.g.a aVar = this.f59572f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            d.a.p0.s.f0.g gVar = this.f59571e;
            if (gVar != null) {
                gVar.I(i2);
            }
            this.f59574h.onChangeSkinType(tbPageContext, i2);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f59570d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f59569c = inflate;
            this.f59570d.setContentView(inflate);
            this.f59568b = (BdListView) this.f59569c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f59569c.findViewById(R.id.view_navigation_bar);
            this.f59574h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f59574h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f59574h.showBottomLine();
            d.a.p0.s.f0.g gVar = new d.a.p0.s.f0.g(this.f59570d.getPageContext());
            this.f59571e = gVar;
            gVar.a0(this.f59570d.getUniqueId());
            this.f59571e.a(this.f59570d);
            d.a.p0.i0.g.a aVar = new d.a.p0.i0.g.a(this.f59570d);
            this.f59572f = aVar;
            aVar.a();
            this.f59573g = new TextView(this.f59570d.getPageContext().getPageActivity());
            this.f59573g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.a.d.e.p.l.g(this.f59570d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f59573g, BdListViewHelper.HeadType.DEFAULT, d.a.d.e.p.j.z());
            this.f59568b.setPullRefresh(this.f59571e);
            this.f59568b.x(this.f59573g, 0);
            this.f59568b.setNextPage(this.f59572f);
            this.f59568b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f59569c.findViewById(R.id.no_networkview);
            this.f59575i = noNetworkView;
            noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f59575i.a(new a(this));
            this.f59568b.setExOnSrollToBottomListener(new b(this));
            d.a.p0.i0.f.d<FeedData, d.a.p0.i0.d.b, d.a.q0.j1.b.a> dVar = new d.a.p0.i0.f.d<>(this.f59570d.getPageContext(), d.a.q0.j1.b.a.class, R.layout.mention_atme_item, this.f59570d.getEventCenter());
            this.f59567a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f59570d)), NoDataViewFactory.e.d(null, this.f59570d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f59568b.setAdapter((ListAdapter) this.f59567a);
            return this.f59569c;
        }
        return (View) invokeV.objValue;
    }

    public void l(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f59573g, BdListViewHelper.HeadType.DEFAULT, d.a.d.e.p.j.z());
            if (z && (bdListView = this.f59568b) != null && bdListView.getWrappedAdapter() != null && this.f59568b.getWrappedAdapter().getCount() <= 0) {
                d.a.d.e.m.e.a().post(new RunnableC1500d(this));
            }
        }
    }

    public void m(d.a.p0.i0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.j = gVar.a();
            d.a.p0.i0.f.d<FeedData, d.a.p0.i0.d.b, d.a.q0.j1.b.a> dVar = this.f59567a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void n(d.a.p0.i0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof d.a.p0.i0.d.a)) {
            d.a.p0.i0.d.a aVar = (d.a.p0.i0.d.a) bVar;
            if (this.f59572f != null) {
                if (aVar.d()) {
                    this.f59572f.d();
                    if (aVar.b()) {
                        this.f59572f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f59572f.f(R.string.loading);
                    } else {
                        this.f59572f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f59572f.e();
                }
            }
            if (aVar.c()) {
                o();
            } else {
                h();
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.p0.s.f0.g gVar = this.f59571e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f59568b;
            if (bdListView != null) {
                bdListView.F();
            }
            d.a.p0.s.f0.g gVar2 = this.f59571e;
            if (gVar2 != null) {
                gVar2.a(this.f59570d);
            }
        }
    }
}
