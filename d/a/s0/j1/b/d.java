package d.a.s0.j1.b;

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
import d.a.s0.j1.b.f.b;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends d.a.c.a.d<AtMessageActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.r0.g0.f.d<FeedData, d.a.r0.g0.d.b, d.a.s0.j1.b.a> f62188a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f62189b;

    /* renamed from: c  reason: collision with root package name */
    public View f62190c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f62191d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.r.f0.g f62192e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.r0.g0.g.a f62193f;

    /* renamed from: g  reason: collision with root package name */
    public View f62194g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f62195h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f62196i;
    public List<FeedData> j;

    /* loaded from: classes9.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62197e;

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
            this.f62197e = dVar;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f62197e.l(z);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62198e;

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
            this.f62198e = dVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void g(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                this.f62198e.f62191d.loadMoreData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f62199a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f62200b;

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
            this.f62200b = dVar;
            this.f62199a = feedData;
        }

        @Override // d.a.s0.j1.b.f.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f62200b.j)) {
                return;
            }
            this.f62200b.j.remove(this.f62199a);
            if (this.f62200b.f62188a != null) {
                this.f62200b.f62188a.k(this.f62200b.j);
            }
        }
    }

    /* renamed from: d.a.s0.j1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC1539d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62201e;

        public RunnableC1539d(d dVar) {
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
            this.f62201e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62201e.f62189b.F();
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
        this.f62191d = atMessageActivity;
    }

    public void g(FeedData feedData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, feedData) == null) || feedData == null) {
            return;
        }
        d.a.s0.j1.b.f.a aVar = new d.a.s0.j1.b.f.a();
        aVar.f62222a = 2;
        aVar.f62223b = d.a.c.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f62224c = d.a.c.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f62225d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        d.a.s0.j1.b.f.b bVar = new d.a.s0.j1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(this, feedData));
        bVar.i();
    }

    public void h() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdListView = this.f62189b) == null) {
            return;
        }
        bdListView.A(0L);
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            d.a.r0.g0.f.d<FeedData, d.a.r0.g0.d.b, d.a.s0.j1.b.a> dVar = this.f62188a;
            if (dVar != null) {
                dVar.onChangeSkinType(tbPageContext, i2);
            }
            d.a.r0.g0.g.a aVar = this.f62193f;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            d.a.r0.r.f0.g gVar = this.f62192e;
            if (gVar != null) {
                gVar.I(i2);
            }
            this.f62195h.onChangeSkinType(tbPageContext, i2);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = this.f62191d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
            this.f62190c = inflate;
            this.f62191d.setContentView(inflate);
            this.f62189b = (BdListView) this.f62190c.findViewById(R.id.atme_lv);
            NavigationBar navigationBar = (NavigationBar) this.f62190c.findViewById(R.id.view_navigation_bar);
            this.f62195h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f62195h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
            this.f62195h.showBottomLine();
            d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(this.f62191d.getPageContext());
            this.f62192e = gVar;
            gVar.a0(this.f62191d.getUniqueId());
            this.f62192e.a(this.f62191d);
            d.a.r0.g0.g.a aVar = new d.a.r0.g0.g.a(this.f62191d);
            this.f62193f = aVar;
            aVar.a();
            this.f62194g = new TextView(this.f62191d.getPageContext().getPageActivity());
            this.f62194g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.a.c.e.p.l.g(this.f62191d.getPageContext().getPageActivity(), R.dimen.ds88)));
            BdListViewHelper.c(this.f62194g, BdListViewHelper.HeadType.DEFAULT, d.a.c.e.p.j.z());
            this.f62189b.setPullRefresh(this.f62192e);
            this.f62189b.x(this.f62194g, 0);
            this.f62189b.setNextPage(this.f62193f);
            this.f62189b.setDividerHeight(0);
            NoNetworkView noNetworkView = (NoNetworkView) this.f62190c.findViewById(R.id.no_networkview);
            this.f62196i = noNetworkView;
            noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f62196i.a(new a(this));
            this.f62189b.setExOnSrollToBottomListener(new b(this));
            d.a.r0.g0.f.d<FeedData, d.a.r0.g0.d.b, d.a.s0.j1.b.a> dVar = new d.a.r0.g0.f.d<>(this.f62191d.getPageContext(), d.a.s0.j1.b.a.class, R.layout.mention_atme_item, this.f62191d.getEventCenter());
            this.f62188a = dVar;
            dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f62191d)), NoDataViewFactory.e.d(null, this.f62191d.getResources().getString(R.string.mention_atme_nodata)), null, null);
            this.f62189b.setAdapter((ListAdapter) this.f62188a);
            return this.f62190c;
        }
        return (View) invokeV.objValue;
    }

    public void l(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            BdListViewHelper.c(this.f62194g, BdListViewHelper.HeadType.DEFAULT, d.a.c.e.p.j.z());
            if (z && (bdListView = this.f62189b) != null && bdListView.getWrappedAdapter() != null && this.f62189b.getWrappedAdapter().getCount() <= 0) {
                d.a.c.e.m.e.a().post(new RunnableC1539d(this));
            }
        }
    }

    public void m(d.a.r0.g0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) && (aVar instanceof g)) {
            g gVar = (g) aVar;
            this.j = gVar.a();
            d.a.r0.g0.f.d<FeedData, d.a.r0.g0.d.b, d.a.s0.j1.b.a> dVar = this.f62188a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void n(d.a.r0.g0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) && (bVar instanceof d.a.r0.g0.d.a)) {
            d.a.r0.g0.d.a aVar = (d.a.r0.g0.d.a) bVar;
            if (this.f62193f != null) {
                if (aVar.d()) {
                    this.f62193f.d();
                    if (aVar.b()) {
                        this.f62193f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f62193f.f(R.string.loading);
                    } else {
                        this.f62193f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f62193f.e();
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
            d.a.r0.r.f0.g gVar = this.f62192e;
            if (gVar != null) {
                gVar.a(null);
            }
            BdListView bdListView = this.f62189b;
            if (bdListView != null) {
                bdListView.F();
            }
            d.a.r0.r.f0.g gVar2 = this.f62192e;
            if (gVar2 != null) {
                gVar2.a(this.f62191d);
            }
        }
    }
}
