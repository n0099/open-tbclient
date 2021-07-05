package d.a.s0.b0.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.d0.g;
import d.a.r0.d0.h;
import d.a.r0.r.f0.f;
import d.a.r0.r.s.a;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes9.dex */
public class b extends d.a.c.a.d<ChosenPostActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ChosenPostActivity f57763a;

    /* renamed from: b  reason: collision with root package name */
    public View f57764b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f57765c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f57766d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.b0.a.a f57767e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.r0.g0.g.a f57768f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57769g;

    /* renamed from: h  reason: collision with root package name */
    public g f57770h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f57771i;
    public h j;
    public int k;
    public int l;
    public d.a.r0.r.f0.g m;

    /* loaded from: classes9.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57772e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57772e = bVar;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f57772e.f57763a.getModelController().F(z);
            }
        }
    }

    /* renamed from: d.a.s0.b0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1331b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57773e;

        public C1331b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57773e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            tinfo item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (item = this.f57773e.f57767e.getItem(i2)) == null) {
                return;
            }
            TiebaStatic.eventStat(this.f57773e.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            this.f57773e.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f57773e.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57774e;

        /* loaded from: classes9.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.r0.r.s.a f57775e;

            public a(c cVar, d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57775e = aVar;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f57775e.dismiss();
                }
            }
        }

        /* renamed from: d.a.s0.b0.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1332b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.r0.r.s.a f57776e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f57777f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f57778g;

            public C1332b(c cVar, d.a.r0.r.s.a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57778g = cVar;
                this.f57776e = aVar;
                this.f57777f = i2;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f57776e.dismiss();
                    d.a.r0.g0.c.b bVar = new d.a.r0.g0.c.b(4101, null, null, null);
                    bVar.g(this.f57778g.f57774e.f57767e.getItem(this.f57777f));
                    bVar.i(this.f57778g.f57774e.f57763a.getUniqueId());
                    this.f57778g.f57774e.f57763a.getEventCenter().dispatchMvcEvent(bVar);
                }
            }
        }

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57774e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f57774e.getActivity());
                aVar.setMessage(this.f57774e.getActivity().getString(R.string.chosen_post_dialog_text));
                aVar.setNegativeButton(R.string.cancel, new a(this, aVar));
                aVar.setPositiveButton(R.string.confirm, new C1332b(this, aVar, i2));
                aVar.create(this.f57774e.f57763a.getPageContext());
                aVar.show();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57779e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57779e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void g(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                if (l.D()) {
                    this.f57779e.f57763a.getModelController().C();
                } else if (this.f57779e.f57768f != null) {
                    this.f57779e.f57768f.d();
                    this.f57779e.f57768f.g(R.string.no_more_msg);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57780e;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57780e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f57780e;
                bVar.o(bVar.m());
                this.f57780e.f57770h.attachView(this.f57780e.m(), true);
                this.f57780e.v();
            }
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chosenPostActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57769g = false;
        this.f57763a = chosenPostActivity;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57763a.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public BdListView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57766d : (BdListView) invokeV.objValue;
    }

    public d.a.r0.r.f0.g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m == null) {
                this.m = new d.a.r0.r.f0.g(this.f57763a.getPageContext());
            }
            return this.m;
        }
        return (d.a.r0.r.f0.g) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57764b : (View) invokeV.objValue;
    }

    public final void n(d.a.r0.g0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            Object c2 = bVar.c();
            if (c2 instanceof Long) {
                this.f57767e.p(((Long) c2).longValue());
                if (this.f57767e.getCount() <= 5) {
                    v();
                }
            }
        }
    }

    public final void o(View view) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || (hVar = this.j) == null) {
            return;
        }
        hVar.dettachView(view);
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, errorData) == null) {
            g gVar = this.f57770h;
            if (gVar != null) {
                gVar.dettachView(m());
            }
            if (errorData != null && this.f57767e.c() <= 0) {
                w(m(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
            }
            this.f57766d.A(0L);
            d.a.r0.g0.g.a aVar = this.f57768f;
            if (aVar != null) {
                aVar.g(R.string.no_more_msg);
            }
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            NavigationBar navigationBar = this.f57765c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i2);
            }
            d.a.s0.b0.a.a aVar = this.f57767e;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            d.a.r0.g0.g.a aVar2 = this.f57768f;
            if (aVar2 != null) {
                aVar2.onChangeSkinType(tbPageContext, i2);
            }
            NoNetworkView noNetworkView = this.f57771i;
            if (noNetworkView != null) {
                noNetworkView.c(tbPageContext, i2);
            }
            d.a.r0.r.f0.g gVar = this.m;
            if (gVar != null) {
                gVar.I(i2);
            }
        }
    }

    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View inflate = this.f57763a.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
            this.f57764b = inflate;
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public boolean r(d.a.r0.g0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            int b2 = bVar.b();
            if (b2 != 4102) {
                switch (b2) {
                    case 4097:
                        this.f57769g = false;
                        break;
                    case 4098:
                        this.f57769g = true;
                        break;
                    case 4099:
                        t(bVar.a());
                        break;
                }
            } else {
                n(bVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.k = this.f57763a.getResources().getDimensionPixelSize(R.dimen.ds108);
            this.l = this.f57763a.getResources().getDimensionPixelSize(R.dimen.ds150);
            NavigationBar navigationBar = (NavigationBar) m().findViewById(R.id.chosen_post_navigation_bar);
            this.f57765c = navigationBar;
            navigationBar.setTitleText(R.string.recommend_frs_hot_thread_title);
            this.f57765c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f57766d = (BdListView) m().findViewById(R.id.chosen_post_list);
            this.f57771i = (NoNetworkView) m().findViewById(R.id.view_no_network);
            d.a.s0.b0.a.a aVar = new d.a.s0.b0.a.a(this.f57763a.getPageContext(), new Class[]{d.a.s0.b0.a.c.c.class, d.a.s0.b0.a.c.b.class, d.a.s0.b0.a.c.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.f57763a.getEventCenter());
            this.f57767e = aVar;
            this.f57766d.setAdapter((ListAdapter) aVar);
            d.a.r0.r.f0.g l = l();
            this.m = l;
            this.f57766d.setPullRefresh(l);
            this.m.a(new a(this));
            this.f57766d.setOnItemClickListener(new C1331b(this));
            this.f57766d.setOnItemLongClickListener(new c(this));
            this.f57766d.setExOnSrollToBottomListener(new d(this));
            d.a.r0.g0.g.a aVar2 = new d.a.r0.g0.g.a(this.f57763a);
            this.f57768f = aVar2;
            aVar2.a();
            k().setNextPage(this.f57768f);
            g gVar = new g(getActivity());
            this.f57770h = gVar;
            gVar.onChangeSkinType();
            this.f57770h.attachView(m(), true);
            this.f57763a.getModelController().A();
        }
    }

    public void t(d.a.r0.g0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) && (aVar instanceof d.a.s0.b0.a.d.b)) {
            List<tinfo> a2 = ((d.a.s0.b0.a.d.b) aVar).a();
            if (a2 != null && a2.size() > 0) {
                this.f57766d.setVisibility(0);
            }
            g gVar = this.f57770h;
            if (gVar != null) {
                gVar.dettachView(m());
            }
            if (this.f57769g) {
                this.f57767e.i(a2);
                return;
            }
            this.f57767e.k(a2);
            if (a2 == null) {
                return;
            }
            BdToast d2 = BdToast.d(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(a2.size())}), 0);
            d2.l(48);
            d2.n(this.k);
            d2.o(this.l);
            d2.a();
            d2.q();
        }
    }

    public void u(d.a.r0.g0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) && (bVar instanceof d.a.r0.g0.d.a)) {
            d.a.r0.g0.d.a aVar = (d.a.r0.g0.d.a) bVar;
            if (aVar.d()) {
                this.f57768f.d();
                if (aVar.b()) {
                    this.f57768f.f(R.string.loading);
                } else if (!aVar.a()) {
                    this.f57768f.g(R.string.no_more_msg);
                }
            } else {
                this.f57768f.e();
            }
            if (aVar.c()) {
                return;
            }
            this.f57766d.A(0L);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.r0.g0.c.b bVar = new d.a.r0.g0.c.b(4100, null, null, null);
            bVar.i(this.f57763a.getUniqueId());
            this.f57763a.getEventCenter().dispatchMvcEvent(bVar);
        }
    }

    public final void w(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, view, str, z) == null) {
            if (this.j == null) {
                this.j = new h(getPageContext().getPageActivity(), new e(this, null));
            }
            this.j.l(str);
            this.j.attachView(view, z);
            this.j.o();
        }
    }
}
