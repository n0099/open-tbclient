package d.a.q0.b0.a;

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
import d.a.d.e.p.l;
import d.a.p0.f0.g;
import d.a.p0.f0.h;
import d.a.p0.s.f0.f;
import d.a.p0.s.s.a;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class b extends d.a.d.a.d<ChosenPostActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ChosenPostActivity f55052a;

    /* renamed from: b  reason: collision with root package name */
    public View f55053b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f55054c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f55055d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.b0.a.a f55056e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.i0.g.a f55057f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55058g;

    /* renamed from: h  reason: collision with root package name */
    public g f55059h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f55060i;
    public h j;
    public int k;
    public int l;
    public d.a.p0.s.f0.g m;

    /* loaded from: classes7.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f55061e;

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
            this.f55061e = bVar;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f55061e.f55052a.getModelController().F(z);
            }
        }
    }

    /* renamed from: d.a.q0.b0.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1294b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f55062e;

        public C1294b(b bVar) {
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
            this.f55062e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            tinfo item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (item = this.f55062e.f55056e.getItem(i2)) == null) {
                return;
            }
            TiebaStatic.eventStat(this.f55062e.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            this.f55062e.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f55062e.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f55063e;

        /* loaded from: classes7.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.p0.s.s.a f55064e;

            public a(c cVar, d.a.p0.s.s.a aVar) {
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
                this.f55064e = aVar;
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f55064e.dismiss();
                }
            }
        }

        /* renamed from: d.a.q0.b0.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1295b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.p0.s.s.a f55065e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f55066f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c f55067g;

            public C1295b(c cVar, d.a.p0.s.s.a aVar, int i2) {
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
                this.f55067g = cVar;
                this.f55065e = aVar;
                this.f55066f = i2;
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f55065e.dismiss();
                    d.a.p0.i0.c.b bVar = new d.a.p0.i0.c.b(4101, null, null, null);
                    bVar.g(this.f55067g.f55063e.f55056e.getItem(this.f55066f));
                    bVar.i(this.f55067g.f55063e.f55052a.getUniqueId());
                    this.f55067g.f55063e.f55052a.getEventCenter().dispatchMvcEvent(bVar);
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
            this.f55063e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f55063e.getActivity());
                aVar.setMessage(this.f55063e.getActivity().getString(R.string.chosen_post_dialog_text));
                aVar.setNegativeButton(R.string.cancel, new a(this, aVar));
                aVar.setPositiveButton(R.string.confirm, new C1295b(this, aVar, i2));
                aVar.create(this.f55063e.f55052a.getPageContext());
                aVar.show();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f55068e;

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
            this.f55068e = bVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void p(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                if (l.D()) {
                    this.f55068e.f55052a.getModelController().C();
                } else if (this.f55068e.f55057f != null) {
                    this.f55068e.f55057f.d();
                    this.f55068e.f55057f.g(R.string.no_more_msg);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f55069e;

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
            this.f55069e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f55069e;
                bVar.o(bVar.m());
                this.f55069e.f55059h.attachView(this.f55069e.m(), true);
                this.f55069e.v();
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
                super((d.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55058g = false;
        this.f55052a = chosenPostActivity;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55052a.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public BdListView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55055d : (BdListView) invokeV.objValue;
    }

    public d.a.p0.s.f0.g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m == null) {
                this.m = new d.a.p0.s.f0.g(this.f55052a.getPageContext());
            }
            return this.m;
        }
        return (d.a.p0.s.f0.g) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55053b : (View) invokeV.objValue;
    }

    public final void n(d.a.p0.i0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            Object c2 = bVar.c();
            if (c2 instanceof Long) {
                this.f55056e.p(((Long) c2).longValue());
                if (this.f55056e.getCount() <= 5) {
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
            g gVar = this.f55059h;
            if (gVar != null) {
                gVar.dettachView(m());
            }
            if (errorData != null && this.f55056e.c() <= 0) {
                w(m(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
            }
            this.f55055d.A(0L);
            d.a.p0.i0.g.a aVar = this.f55057f;
            if (aVar != null) {
                aVar.g(R.string.no_more_msg);
            }
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            NavigationBar navigationBar = this.f55054c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i2);
            }
            d.a.q0.b0.a.a aVar = this.f55056e;
            if (aVar != null) {
                aVar.onChangeSkinType(tbPageContext, i2);
            }
            d.a.p0.i0.g.a aVar2 = this.f55057f;
            if (aVar2 != null) {
                aVar2.onChangeSkinType(tbPageContext, i2);
            }
            NoNetworkView noNetworkView = this.f55060i;
            if (noNetworkView != null) {
                noNetworkView.c(tbPageContext, i2);
            }
            d.a.p0.s.f0.g gVar = this.m;
            if (gVar != null) {
                gVar.I(i2);
            }
        }
    }

    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View inflate = this.f55052a.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
            this.f55053b = inflate;
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public boolean r(d.a.p0.i0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            int b2 = bVar.b();
            if (b2 != 4102) {
                switch (b2) {
                    case 4097:
                        this.f55058g = false;
                        break;
                    case 4098:
                        this.f55058g = true;
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
            this.k = this.f55052a.getResources().getDimensionPixelSize(R.dimen.ds108);
            this.l = this.f55052a.getResources().getDimensionPixelSize(R.dimen.ds150);
            NavigationBar navigationBar = (NavigationBar) m().findViewById(R.id.chosen_post_navigation_bar);
            this.f55054c = navigationBar;
            navigationBar.setTitleText(R.string.recommend_frs_hot_thread_title);
            this.f55054c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f55055d = (BdListView) m().findViewById(R.id.chosen_post_list);
            this.f55060i = (NoNetworkView) m().findViewById(R.id.view_no_network);
            d.a.q0.b0.a.a aVar = new d.a.q0.b0.a.a(this.f55052a.getPageContext(), new Class[]{d.a.q0.b0.a.c.c.class, d.a.q0.b0.a.c.b.class, d.a.q0.b0.a.c.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.f55052a.getEventCenter());
            this.f55056e = aVar;
            this.f55055d.setAdapter((ListAdapter) aVar);
            d.a.p0.s.f0.g l = l();
            this.m = l;
            this.f55055d.setPullRefresh(l);
            this.m.a(new a(this));
            this.f55055d.setOnItemClickListener(new C1294b(this));
            this.f55055d.setOnItemLongClickListener(new c(this));
            this.f55055d.setExOnSrollToBottomListener(new d(this));
            d.a.p0.i0.g.a aVar2 = new d.a.p0.i0.g.a(this.f55052a);
            this.f55057f = aVar2;
            aVar2.a();
            k().setNextPage(this.f55057f);
            g gVar = new g(getActivity());
            this.f55059h = gVar;
            gVar.onChangeSkinType();
            this.f55059h.attachView(m(), true);
            this.f55052a.getModelController().A();
        }
    }

    public void t(d.a.p0.i0.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) && (aVar instanceof d.a.q0.b0.a.d.b)) {
            List<tinfo> a2 = ((d.a.q0.b0.a.d.b) aVar).a();
            if (a2 != null && a2.size() > 0) {
                this.f55055d.setVisibility(0);
            }
            g gVar = this.f55059h;
            if (gVar != null) {
                gVar.dettachView(m());
            }
            if (this.f55058g) {
                this.f55056e.i(a2);
                return;
            }
            this.f55056e.k(a2);
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

    public void u(d.a.p0.i0.d.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) && (bVar instanceof d.a.p0.i0.d.a)) {
            d.a.p0.i0.d.a aVar = (d.a.p0.i0.d.a) bVar;
            if (aVar.d()) {
                this.f55057f.d();
                if (aVar.b()) {
                    this.f55057f.f(R.string.loading);
                } else if (!aVar.a()) {
                    this.f55057f.g(R.string.no_more_msg);
                }
            } else {
                this.f55057f.e();
            }
            if (aVar.c()) {
                return;
            }
            this.f55055d.A(0L);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d.a.p0.i0.c.b bVar = new d.a.p0.i0.c.b(4100, null, null, null);
            bVar.i(this.f55052a.getUniqueId());
            this.f55052a.getEventCenter().dispatchMvcEvent(bVar);
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
