package d.a.s0.v.d.b.e;

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
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import d.a.r0.r.q.b2;
import d.a.s0.v.d.b.a.b;
import d.a.s0.v.d.g.b.c;
import d.a.s0.v.d.g.d.f;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f67495a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f67496b;

    /* renamed from: c  reason: collision with root package name */
    public g f67497c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f67498d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f67499e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f67500f;

    /* renamed from: g  reason: collision with root package name */
    public PbListView f67501g;

    /* renamed from: h  reason: collision with root package name */
    public b f67502h;

    /* renamed from: i  reason: collision with root package name */
    public int f67503i;
    public f j;

    /* renamed from: d.a.s0.v.d.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1795a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67504a;

        public C1795a(a aVar) {
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
            this.f67504a = aVar;
        }

        @Override // d.a.s0.v.d.g.d.f
        public void a(int i2, String str, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, b2Var) == null) {
                TiebaStatic.log(d.a.s0.v.d.d.a.c().e(this.f67504a.f67503i, "c12118", i2, str, b2Var));
                a aVar = this.f67504a;
                aVar.h(aVar.f67495a, b2Var, str);
            }
        }

        @Override // d.a.s0.v.d.g.d.f
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
        this.j = new C1795a(this);
        this.f67495a = tbPageContext;
        LinearLayout linearLayout = new LinearLayout(tbPageContext.getPageActivity());
        this.f67499e = linearLayout;
        linearLayout.setOrientation(1);
        this.f67500f = new NoNetworkView(tbPageContext.getPageActivity());
        if (j.z()) {
            this.f67500f.setVisibility(8);
        }
        this.f67499e.addView(this.f67500f);
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getPageActivity());
        this.f67498d = frameLayout;
        this.f67499e.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.f67499e.setPadding(0, 0, 0, 0);
        BdTypeListView bdTypeListView = new BdTypeListView(this.f67495a.getPageActivity());
        this.f67496b = bdTypeListView;
        bdTypeListView.setDivider(null);
        this.f67498d.addView(this.f67496b, new FrameLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f67495a);
        this.f67497c = gVar;
        gVar.a0(bdUniqueId);
        this.f67496b.setPullRefresh(this.f67497c);
        PbListView pbListView = new PbListView(tbPageContext.getPageActivity());
        this.f67501g = pbListView;
        pbListView.a();
        b bVar = new b(tbPageContext, this.f67496b);
        this.f67502h = bVar;
        bVar.c(this.j);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f67496b.z();
        }
    }

    public FrameLayout e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67498d : (FrameLayout) invokeV.objValue;
    }

    public BdTypeListView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67496b : (BdTypeListView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67499e : (View) invokeV.objValue;
    }

    public final void h(TbPageContext<?> tbPageContext, b2 b2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, tbPageContext, b2Var, str) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.g1() == null) {
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
        alaLiveInfoCoreData.fillWithInfoData(b2Var.g1());
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
            this.f67501g.o(R.color.CAM_X0204);
            this.f67501g.d(i2);
            this.f67497c.I(i2);
            this.f67502h.b();
            SkinManager.setBackgroundColor(this.f67499e, R.color.CAM_X0201);
            this.f67500f.c(this.f67495a, i2);
        }
    }

    public void j(List<n> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (list == null) {
                list = new LinkedList<>();
            }
            this.f67503i = i2;
            this.f67502h.d(list);
            this.f67502h.e(i2);
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
            this.f67497c.a(gVar);
        }
    }

    public void l(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onScrollListener) == null) {
            this.f67496b.setOnScrollListener(onScrollListener);
        }
    }

    public void m(BdListView.o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, oVar, i2) == null) {
            this.f67496b.setOnScrollStopDelayedListener(oVar, i2);
        }
    }

    public void n(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pVar) == null) {
            this.f67496b.setOnSrollToBottomListener(pVar);
        }
    }

    public void o(IAlaSquareTabController iAlaSquareTabController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iAlaSquareTabController) == null) {
            this.f67502h.f(iAlaSquareTabController);
        }
    }

    public void p() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (pbListView = this.f67501g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f67496b.setNextPage(this.f67501g);
        }
        this.f67501g.M();
        this.f67501g.O();
    }

    public void q() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f67501g) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f67496b.setNextPage(this.f67501g);
        }
        this.f67501g.A(this.f67495a.getResources().getString(R.string.list_no_more));
        this.f67501g.f();
    }
}
