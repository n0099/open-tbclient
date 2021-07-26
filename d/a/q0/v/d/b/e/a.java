package d.a.q0.v.d.b.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.k.e.n;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import d.a.p0.s.q.b2;
import d.a.q0.v.d.b.a.b;
import d.a.q0.v.d.g.b.c;
import d.a.q0.v.d.g.d.f;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64922a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f64923b;

    /* renamed from: c  reason: collision with root package name */
    public g f64924c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f64925d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f64926e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f64927f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f64928g;

    /* renamed from: h  reason: collision with root package name */
    public b f64929h;

    /* renamed from: i  reason: collision with root package name */
    public int f64930i;
    public f j;

    /* renamed from: d.a.q0.v.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1756a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64931a;

        public C1756a(a aVar) {
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
            this.f64931a = aVar;
        }

        @Override // d.a.q0.v.d.g.d.f
        public void a(int i2, String str, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, b2Var) == null) {
                TiebaStatic.log(d.a.q0.v.d.d.a.c().e(this.f64931a.f64930i, "c12118", i2, str, b2Var));
                a aVar = this.f64931a;
                aVar.h(aVar.f64922a, b2Var, str);
            }
        }

        @Override // d.a.q0.v.d.g.d.f
        public void b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            }
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new C1756a(this);
        this.f64922a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f64926e = linearLayout;
        linearLayout.setOrientation(1);
        this.f64927f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f64927f.setVisibility(8);
        }
        this.f64926e.addView(this.f64927f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f64925d = frameLayout;
        this.f64926e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f64926e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f64922a.getPageActivity());
        this.f64923b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f64925d.addView(this.f64923b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f64922a);
        this.f64924c = gVar;
        gVar.a0(bdUniqueId);
        this.f64923b.setPullRefresh(this.f64924c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f64928g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f64923b);
        this.f64929h = bVar;
        bVar.c(this.j);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f64923b.z();
        }
    }

    public FrameLayout e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64925d : (FrameLayout) invokeV.objValue;
    }

    public BdTypeListView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64923b : (BdTypeListView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64926e : (View) invokeV.objValue;
    }

    public final void h(TbPageContext<?> tbPageContext, b2 b2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, tbPageContext, b2Var, str) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.h1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = b2Var.H().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(b2Var.h1());
        alaLiveInfoCoreData.userName = b2Var.H().getUserName();
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_LIVE, str2, z, str, null)));
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f64928g.o(R.color.CAM_X0204);
            this.f64928g.d(i2);
            this.f64924c.I(i2);
            this.f64929h.b();
            SkinManager.setBackgroundColor(this.f64926e, R.color.CAM_X0201);
            this.f64927f.c(this.f64922a, i2);
        }
    }

    public void j(List<n> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (list == null) {
                list = new LinkedList<>();
            }
            this.f64930i = i2;
            this.f64929h.d(list);
            this.f64929h.e(i2);
            if (z) {
                p();
            } else {
                q();
            }
        }
    }

    public void k(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.f64924c.a(gVar);
        }
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onScrollListener) == null) {
            this.f64923b.setOnScrollListener(onScrollListener);
        }
    }

    public void m(BdListView.o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, oVar, i2) == null) {
            this.f64923b.setOnScrollStopDelayedListener(oVar, i2);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            this.f64923b.setOnSrollToBottomListener(pVar);
        }
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iAlaSquareTabController) == null) {
            this.f64929h.f(iAlaSquareTabController);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (pbListView = this.f64928g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f64923b.setNextPage(this.f64928g);
        }
        this.f64928g.M();
        this.f64928g.O();
    }

    public void q() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f64928g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f64923b.setNextPage(this.f64928g);
        }
        this.f64928g.A(this.f64922a.getResources().getString(R.string.list_no_more));
        this.f64928g.f();
    }
}
