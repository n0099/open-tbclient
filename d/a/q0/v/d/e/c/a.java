package d.a.q0.v.d.e.c;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaAttentionData;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.AlaRecentHistoryActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import d.a.q0.v.d.e.a.c;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlaRecentHistoryActivity f65143a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f65144b;

    /* renamed from: c  reason: collision with root package name */
    public View f65145c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f65146d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f65147e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f65148f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f65149g;

    /* renamed from: h  reason: collision with root package name */
    public g f65150h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.v.d.e.a.a f65151i;
    public int j;
    public d.a.q0.v.d.e.b.b k;
    public CustomMessageListener l;

    /* renamed from: d.a.q0.v.d.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1766a implements c.InterfaceC1765c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65152a;

        public C1766a(a aVar) {
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
            this.f65152a = aVar;
        }

        @Override // d.a.q0.v.d.e.a.c.InterfaceC1765c
        public void a(d.a.q0.v.d.e.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f65152a.k = bVar;
                this.f65152a.m(bVar.f65137a.H(), bVar.f65138b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && i2 == 0) {
                d.a.q0.v.d.d.a.c().g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65153a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65153a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12868c) || this.f65153a.k == null) {
                    return;
                }
                if (updateAttentionMessage.getData().f12868c.equals(String.valueOf((this.f65153a.k.f65137a == null || this.f65153a.k.f65137a.H() == null) ? -100L : this.f65153a.k.f65137a.H().getUserIdLong()))) {
                    if (updateAttentionMessage.getData().f12866a) {
                        this.f65153a.k.f65138b = true;
                        if (this.f65153a.f65151i instanceof d.a.q0.v.d.e.a.c) {
                            this.f65153a.f65151i.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    this.f65153a.k.f65138b = false;
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65144b = tbPageContext;
        this.f65143a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.j = i2;
        j();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f65147e.z();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.j;
            if (i2 == 0) {
                this.f65151i = new d.a.q0.v.d.e.a.b(this.f65144b);
            } else if (1 == i2) {
                this.f65151i = new d.a.q0.v.d.e.a.c(this.f65144b);
                n();
                ((d.a.q0.v.d.e.a.c) this.f65151i).i(new C1766a(this));
            }
            this.f65147e.setAdapter((ListAdapter) this.f65151i);
            this.f65147e.setOnScrollListener(new b(this));
        }
    }

    public ViewGroup g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65146d : (ViewGroup) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f65145c : (View) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f();
        }
    }

    public void j() {
        ColorDrawable colorDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.f65143a).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
            this.f65145c = inflate;
            inflate.setPadding(0, (int) this.f65143a.getResources().getDimension(R.dimen.ds80), 0, 0);
            this.f65146d = (FrameLayout) this.f65145c.findViewById(R.id.square_recent_history_container);
            this.f65147e = (BdListView) this.f65145c.findViewById(R.id.square_recent_history_listview);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                colorDrawable = new ColorDrawable(this.f65143a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
            } else {
                colorDrawable = new ColorDrawable(this.f65143a.getPageContext().getResources().getColor(R.color.CAM_X0204));
            }
            this.f65147e.setDivider(colorDrawable);
            this.f65147e.setDividerHeight(this.f65143a.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
            this.f65148f = (NoNetworkView) this.f65145c.findViewById(R.id.square_recent_history_network);
            g gVar = new g(this.f65144b);
            this.f65150h = gVar;
            gVar.a0(this.f65143a.getUniqueId());
            this.f65147e.setPullRefresh(this.f65150h);
            PbListView pbListView = new PbListView(this.f65143a);
            this.f65149g = pbListView;
            pbListView.a();
            i();
        }
    }

    public void k(int i2) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (noNetworkView = this.f65148f) == null) {
            return;
        }
        noNetworkView.c(this.f65144b, i2);
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.l == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void m(MetaData metaData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, metaData, z) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.f65144b.getPageActivity());
                return;
            }
            String valueOf = String.valueOf(metaData.getUserId());
            AlaAttentionManager.getInstance().updateAttention(valueOf, new AlaAttentionData(metaData.getPortrait(), valueOf, "1", !z, null));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l = new c(this, 2001115);
            MessageManager.getInstance().registerListener(this.l);
        }
    }

    public void o(List<d.a.q0.v.d.e.b.b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            d.a.q0.v.d.e.a.a aVar = this.f65151i;
            if (aVar instanceof d.a.q0.v.d.e.a.b) {
                aVar.c(list);
            } else if (aVar instanceof d.a.q0.v.d.e.a.c) {
                aVar.c(list);
            }
            if (z) {
                s();
            } else {
                t();
            }
        }
    }

    public void p(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.f65150h.a(gVar);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f65147e.setNextPage(null);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pVar) == null) {
            this.f65147e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f65149g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f65147e.setNextPage(this.f65149g);
        }
        this.f65149g.M();
        this.f65149g.O();
    }

    public final void t() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f65149g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f65147e.setNextPage(this.f65149g);
        }
        this.f65149g.A(this.f65143a.getPageContext().getResources().getString(R.string.list_no_more));
        this.f65149g.f();
    }
}
