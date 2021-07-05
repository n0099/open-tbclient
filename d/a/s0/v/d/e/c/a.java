package d.a.s0.v.d.e.c;

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
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import d.a.s0.v.d.e.a.c;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlaRecentHistoryActivity f67716a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f67717b;

    /* renamed from: c  reason: collision with root package name */
    public View f67718c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f67719d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f67720e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f67721f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f67722g;

    /* renamed from: h  reason: collision with root package name */
    public g f67723h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.v.d.e.a.a f67724i;
    public int j;
    public d.a.s0.v.d.e.b.b k;
    public CustomMessageListener l;

    /* renamed from: d.a.s0.v.d.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1805a implements c.InterfaceC1804c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67725a;

        public C1805a(a aVar) {
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
            this.f67725a = aVar;
        }

        @Override // d.a.s0.v.d.e.a.c.InterfaceC1804c
        public void a(d.a.s0.v.d.e.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                this.f67725a.k = bVar;
                this.f67725a.m(bVar.f67710a.H(), bVar.f67711b);
            }
        }
    }

    /* loaded from: classes9.dex */
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
                d.a.s0.v.d.d.a.c().g();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67726a;

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
            this.f67726a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().f12802c) || this.f67726a.k == null) {
                    return;
                }
                if (updateAttentionMessage.getData().f12802c.equals(String.valueOf((this.f67726a.k.f67710a == null || this.f67726a.k.f67710a.H() == null) ? -100L : this.f67726a.k.f67710a.H().getUserIdLong()))) {
                    if (updateAttentionMessage.getData().f12800a) {
                        this.f67726a.k.f67711b = true;
                        if (this.f67726a.f67724i instanceof d.a.s0.v.d.e.a.c) {
                            this.f67726a.f67724i.notifyDataSetChanged();
                            return;
                        }
                        return;
                    }
                    this.f67726a.k.f67711b = false;
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
        this.f67717b = tbPageContext;
        this.f67716a = (AlaRecentHistoryActivity) tbPageContext.getPageActivity();
        this.j = i2;
        j();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67720e.z();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.j;
            if (i2 == 0) {
                this.f67724i = new d.a.s0.v.d.e.a.b(this.f67717b);
            } else if (1 == i2) {
                this.f67724i = new d.a.s0.v.d.e.a.c(this.f67717b);
                n();
                ((d.a.s0.v.d.e.a.c) this.f67724i).i(new C1805a(this));
            }
            this.f67720e.setAdapter((ListAdapter) this.f67724i);
            this.f67720e.setOnScrollListener(new b(this));
        }
    }

    public ViewGroup g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67719d : (ViewGroup) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67718c : (View) invokeV.objValue;
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
            View inflate = LayoutInflater.from(this.f67716a).inflate(R.layout.square_recent_history_view, (ViewGroup) null);
            this.f67718c = inflate;
            inflate.setPadding(0, (int) this.f67716a.getResources().getDimension(R.dimen.ds80), 0, 0);
            this.f67719d = (FrameLayout) this.f67718c.findViewById(R.id.square_recent_history_container);
            this.f67720e = (BdListView) this.f67718c.findViewById(R.id.square_recent_history_listview);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                colorDrawable = new ColorDrawable(this.f67716a.getPageContext().getResources().getColor(R.color.CAM_X0204_1));
            } else {
                colorDrawable = new ColorDrawable(this.f67716a.getPageContext().getResources().getColor(R.color.CAM_X0204));
            }
            this.f67720e.setDivider(colorDrawable);
            this.f67720e.setDividerHeight(this.f67716a.getActivity().getResources().getDimensionPixelSize(R.dimen.ds1));
            this.f67721f = (NoNetworkView) this.f67718c.findViewById(R.id.square_recent_history_network);
            g gVar = new g(this.f67717b);
            this.f67723h = gVar;
            gVar.a0(this.f67716a.getUniqueId());
            this.f67720e.setPullRefresh(this.f67723h);
            PbListView pbListView = new PbListView(this.f67716a);
            this.f67722g = pbListView;
            pbListView.a();
            i();
        }
    }

    public void k(int i2) {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (noNetworkView = this.f67721f) == null) {
            return;
        }
        noNetworkView.c(this.f67717b, i2);
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
                ViewHelper.skipToLoginActivity(this.f67717b.getPageActivity());
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

    public void o(List<d.a.s0.v.d.e.b.b> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            d.a.s0.v.d.e.a.a aVar = this.f67724i;
            if (aVar instanceof d.a.s0.v.d.e.a.b) {
                aVar.c(list);
            } else if (aVar instanceof d.a.s0.v.d.e.a.c) {
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
            this.f67723h.a(gVar);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f67720e.setNextPage(null);
        }
    }

    public void r(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pVar) == null) {
            this.f67720e.setOnSrollToBottomListener(pVar);
        }
    }

    public final void s() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (pbListView = this.f67722g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f67720e.setNextPage(this.f67722g);
        }
        this.f67722g.M();
        this.f67722g.O();
    }

    public final void t() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbListView = this.f67722g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f67720e.setNextPage(this.f67722g);
        }
        this.f67722g.A(this.f67716a.getPageContext().getResources().getString(R.string.list_no_more));
        this.f67722g.f();
    }
}
