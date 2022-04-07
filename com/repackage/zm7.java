package com.repackage;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.nearby.NearbyFriendsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.du4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zm7 implements ym7, du4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NearbyFriendsActivity a;
    public xm7 b;
    public NavigationBar c;
    public FrameLayout d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public eu4 g;
    public PbListView h;
    public um7 i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm7 a;

        public a(zm7 zm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zm7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                if (!(this.a.h == null && this.a.a == null && this.a.b == null) && mi.z()) {
                    this.a.h.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.h.B(null);
                    if (this.a.b.hasMore()) {
                        this.a.h.N();
                        this.a.b.loadMore();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm7 a;

        public b(zm7 zm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zm7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                this.a.z();
            }
        }
    }

    public zm7(NearbyFriendsActivity nearbyFriendsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nearbyFriendsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = nearbyFriendsActivity;
    }

    @Override // com.repackage.ym7
    public void a() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.d) == null) {
            return;
        }
        nearbyFriendsActivity.showLoadingView(frameLayout);
    }

    @Override // com.repackage.ym7
    public void b(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (bdSwipeRefreshLayout = this.e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    @Override // com.repackage.ym7
    public void d() {
        xm7 xm7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (xm7Var = this.b) == null || this.a == null) {
            return;
        }
        xm7Var.reload();
    }

    @Override // com.repackage.ym7
    public void e(boolean z, List<uo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048579, this, z, list) == null) || this.f == null || list == null) {
            return;
        }
        um7 um7Var = this.i;
        if (um7Var != null) {
            um7Var.i0(z);
        }
        this.f.setData(list);
    }

    @Override // com.repackage.ym7
    public void f(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.C(str);
        this.h.B(t());
    }

    @Override // com.repackage.ym7
    public void g() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.d) == null) {
            return;
        }
        nearbyFriendsActivity.hideLoadingView(frameLayout);
    }

    @Override // com.repackage.ym7
    public void h(int i) {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        NavigationBar navigationBar = this.c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(nearbyFriendsActivity.getPageContext(), i);
        }
        eu4 eu4Var = this.g;
        if (eu4Var != null) {
            eu4Var.H(i);
        }
        PbListView pbListView = this.h;
        if (pbListView != null) {
            pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
            this.h.d(i);
        }
    }

    @Override // com.repackage.ym7
    public void i() {
        um7 um7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (um7Var = this.i) == null) {
            return;
        }
        um7Var.i0(false);
    }

    @Override // com.repackage.ym7
    public void j(int i) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (bdSwipeRefreshLayout = this.e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(i);
    }

    @Override // com.repackage.ym7
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            z();
        }
    }

    @Override // com.repackage.ym7
    public void l(xm7 xm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xm7Var) == null) {
            this.b = xm7Var;
        }
    }

    @Override // com.repackage.ym7
    public void m() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.d) == null) {
            return;
        }
        nearbyFriendsActivity.hideNetRefreshView(frameLayout);
    }

    @Override // com.repackage.ym7
    public void n(String str) {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.d) == null) {
            return;
        }
        nearbyFriendsActivity.showNetRefreshView(frameLayout, str, false);
    }

    @Override // com.repackage.ym7
    public void onCreate() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        this.c = (NavigationBar) nearbyFriendsActivity.findViewById(R.id.obfuscated_res_0x7f091514);
        this.d = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0906d6);
        this.e = (BdSwipeRefreshLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091a1e);
        this.f = (BdTypeRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f09152b);
        w();
        y();
        x();
        v();
        this.b.reload();
    }

    @Override // com.repackage.ym7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            eu4 eu4Var = this.g;
            if (eu4Var != null) {
                eu4Var.f(null);
            }
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.B(null);
            }
            this.a = null;
        }
    }

    @Override // com.repackage.du4.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.b.refresh();
        }
    }

    public final View.OnClickListener t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? new a(this) : (View.OnClickListener) invokeV.objValue;
    }

    public final BdListView.p u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new b(this) : (BdListView.p) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.a == null) {
            return;
        }
        PbListView pbListView = new PbListView(this.a);
        this.h = pbListView;
        pbListView.b();
        this.h.p(R.color.transparent);
        this.h.t(oi.f(this.a, R.dimen.tbds182));
        this.h.x();
        this.h.G(R.dimen.tbfontsize36);
        this.h.E(SkinManager.getColor(R.color.CAM_X0107));
        this.h.A(R.color.CAM_X0110);
        this.h.s();
        this.h.B(t());
    }

    public final void w() {
        NearbyFriendsActivity nearbyFriendsActivity;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (nearbyFriendsActivity = this.a) == null || (navigationBar = this.c) == null) {
            return;
        }
        navigationBar.setCenterTextTitle(nearbyFriendsActivity.getString(R.string.obfuscated_res_0x7f0f0c0b));
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public final void x() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (nearbyFriendsActivity = this.a) == null || this.e == null) {
            return;
        }
        eu4 eu4Var = new eu4(nearbyFriendsActivity.getPageContext());
        this.g = eu4Var;
        eu4Var.f(this);
        this.e.setProgressView(this.g);
    }

    public final void y() {
        BdTypeRecyclerView bdTypeRecyclerView;
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (bdTypeRecyclerView = this.f) == null || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(nearbyFriendsActivity));
        this.f.setFadingEdgeLength(0);
        this.f.setOverScrollMode(2);
        this.f.setOnSrollToBottomListener(u());
        ArrayList arrayList = new ArrayList();
        um7 um7Var = new um7(this.a, qz4.l, 2);
        this.i = um7Var;
        arrayList.add(um7Var);
        this.f.a(arrayList);
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.h == null || this.b == null || this.a == null) {
            return;
        }
        if (!mi.z()) {
            this.f.setNextPage(null);
            return;
        }
        this.f.setNextPage(this.h);
        this.h.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.h.B(null);
        if (this.b.hasMore()) {
            this.h.q(false);
            this.h.N();
            this.b.loadMore();
            return;
        }
        this.h.q(true);
        this.h.C(this.a.getString(R.string.obfuscated_res_0x7f0f0c10));
        this.h.f();
    }
}
