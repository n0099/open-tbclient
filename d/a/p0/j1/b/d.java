package d.a.p0.j1.b;

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
import d.a.c.a.f;
import d.a.p0.j1.b.f.b;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends d.a.c.a.d<AtMessageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.g0.f.d<FeedData, d.a.o0.g0.d.b, d.a.p0.j1.b.a> f58953a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f58954b;

    /* renamed from: c  reason: collision with root package name */
    public View f58955c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f58956d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r.f0.g f58957e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.g0.g.a f58958f;

    /* renamed from: g  reason: collision with root package name */
    public View f58959g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f58960h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f58961i;
    public List<FeedData> j;

    /* loaded from: classes8.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f58962e;

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
            this.f58962e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f58962e.l(z);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f58963e;

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
            this.f58963e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void p(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f58963e.f58956d.loadMoreData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f58964a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f58965b;

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
            this.f58965b = dVar;
            this.f58964a = feedData;
        }

        @Override // d.a.p0.j1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f58965b.j)) {
                return;
            }
            this.f58965b.j.remove(this.f58964a);
            if (this.f58965b.f58953a != null) {
                this.f58965b.f58953a.k(this.f58965b.j);
            }
        }
    }

    /* renamed from: d.a.p0.j1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1495d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f58966e;

        public RunnableC1495d(d dVar) {
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
            this.f58966e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58966e.f58954b.F();
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
        this.f58956d = atMessageActivity;
    }

    public void g(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        d.a.p0.j1.b.f.a aVar = new d.a.p0.j1.b.f.a();
        aVar.f58987a = 2;
        aVar.f58988b = d.a.c.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f58989c = d.a.c.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f58990d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        d.a.p0.j1.b.f.b bVar = new d.a.p0.j1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void h() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f58954b) == null) {
            return;
        }
        bdListView.A(0L);
    }

    public void j(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            d.a.o0.g0.f.d<FeedData, d.a.o0.g0.d.b, d.a.p0.j1.b.a> dVar = this.f58953a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            d.a.o0.g0.g.a aVar = this.f58958f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            d.a.o0.r.f0.g gVar = this.f58957e;
            if (gVar != null) {
                gVar.I(i2);
            }
            this.f58960h.onChangeSkinType(tbPageContext, i2);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f58956d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f58955c = inflate;
            this.f58956d.setContentView(inflate);
            this.f58954b = (BdListView) this.f58955c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f58955c.findViewById(R.id.view_navigation_bar);
            this.f58960h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f58960h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f58960h.showBottomLine();
            d.a.o0.r.f0.g gVar = new d.a.o0.r.f0.g(this.f58956d.getPageContext());
            this.f58957e = gVar;
            gVar.a0(this.f58956d.getUniqueId());
            this.f58957e.a(this.f58956d);
            d.a.o0.g0.g.a aVar = new d.a.o0.g0.g.a(this.f58956d);
            this.f58958f = aVar;
            aVar.a();
            this.f58959g = new TextView(this.f58956d.getPageContext().getPageActivity());
            this.f58959g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.a.c.e.p.l.g(this.f58956d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f58959g, BdListViewHelper.HeadType.DEFAULT, d.a.c.e.p.j.z());
            this.f58954b.setPullRefresh(this.f58957e);
            this.f58954b.x(this.f58959g, 0);
            this.f58954b.setNextPage(this.f58958f);
            this.f58954b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f58955c.findViewById(R.id.no_networkview);
            this.f58961i = noNetworkView;
            noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f58961i.a(new a(this));
            this.f58954b.setExOnSrollToBottomListener(new b(this));
            d.a.o0.g0.f.d<FeedData, d.a.o0.g0.d.b, d.a.p0.j1.b.a> dVar = new d.a.o0.g0.f.d<>(this.f58956d.getPageContext(), d.a.p0.j1.b.a.class, R.layout.mention_atme_item, this.f58956d.getEventCenter());
            this.f58953a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f58956d)), NoDataViewFactory.e.d(null, this.f58956d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f58954b.setAdapter((ListAdapter) this.f58953a);
            return this.f58955c;
        }
        return (View) invokeV.objValue;
    }

    public void l(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f58959g, BdListViewHelper.HeadType.DEFAULT, d.a.c.e.p.j.z());
            if (z && (bdListView = this.f58954b) != null && bdListView.getWrappedAdapter() != null && this.f58954b.getWrappedAdapter().getCount() <= 0) {
                d.a.c.e.m.e.a().post(new RunnableC1495d(this));
            }
        }
    }

    public void m(d.a.o0.g0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.j = gVar.a();
            d.a.o0.g0.f.d<FeedData, d.a.o0.g0.d.b, d.a.p0.j1.b.a> dVar = this.f58953a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void n(d.a.o0.g0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof d.a.o0.g0.d.a)) {
            d.a.o0.g0.d.a aVar = (d.a.o0.g0.d.a) bVar;
            if (this.f58958f != null) {
                if (aVar.d()) {
                    this.f58958f.d();
                    if (aVar.b()) {
                        this.f58958f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f58958f.f(R.string.loading);
                    } else {
                        this.f58958f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f58958f.e();
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
            d.a.o0.r.f0.g gVar = this.f58957e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f58954b;
            if (bdListView != null) {
                bdListView.F();
            }
            d.a.o0.r.f0.g gVar2 = this.f58957e;
            if (gVar2 != null) {
                gVar2.a(this.f58956d);
            }
        }
    }
}
