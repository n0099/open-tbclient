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
import com.repackage.gu4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class nm7 implements mm7, gu4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NearbyFriendsActivity a;
    public lm7 b;
    public NavigationBar c;
    public FrameLayout d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public hu4 g;
    public PbListView h;
    public im7 i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm7 a;

        public a(nm7 nm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                if (!(this.a.h == null && this.a.a == null && this.a.b == null) && ni.z()) {
                    this.a.h.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.h.B(null);
                    if (this.a.b.a()) {
                        this.a.h.N();
                        this.a.b.b();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nm7 a;

        public b(nm7 nm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nm7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                this.a.C();
            }
        }
    }

    public nm7(NearbyFriendsActivity nearbyFriendsActivity) {
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

    public final void A() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (nearbyFriendsActivity = this.a) == null || this.e == null) {
            return;
        }
        hu4 hu4Var = new hu4(nearbyFriendsActivity.getPageContext());
        this.g = hu4Var;
        hu4Var.f(this);
        this.e.setProgressView(this.g);
    }

    public final void B() {
        BdTypeRecyclerView bdTypeRecyclerView;
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.f) == null || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(nearbyFriendsActivity));
        this.f.setFadingEdgeLength(0);
        this.f.setOverScrollMode(2);
        this.f.setOnSrollToBottomListener(x());
        ArrayList arrayList = new ArrayList();
        im7 im7Var = new im7(this.a, q05.l, 2);
        this.i = im7Var;
        arrayList.add(im7Var);
        this.f.a(arrayList);
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.h == null || this.b == null || this.a == null) {
            return;
        }
        if (!ni.z()) {
            this.f.setNextPage(null);
            return;
        }
        this.f.setNextPage(this.h);
        this.h.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.h.B(null);
        if (this.b.a()) {
            this.h.q(false);
            this.h.N();
            this.b.b();
            return;
        }
        this.h.q(true);
        this.h.C(this.a.getString(R.string.obfuscated_res_0x7f0f0c0d));
        this.h.f();
    }

    @Override // com.repackage.mm7
    public void a() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.d) == null) {
            return;
        }
        nearbyFriendsActivity.showLoadingView(frameLayout);
    }

    @Override // com.repackage.mm7
    public void c(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (bdSwipeRefreshLayout = this.e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setRefreshing(z);
    }

    @Override // com.repackage.mm7
    public void d() {
        lm7 lm7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (lm7Var = this.b) == null || this.a == null) {
            return;
        }
        lm7Var.reload();
    }

    @Override // com.repackage.gu4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.b.refresh();
        }
    }

    @Override // com.repackage.mm7
    public void g(boolean z, List<nn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048583, this, z, list) == null) || this.f == null || list == null) {
            return;
        }
        im7 im7Var = this.i;
        if (im7Var != null) {
            im7Var.i0(z);
        }
        this.f.setData(list);
    }

    @Override // com.repackage.mm7
    public void h(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (pbListView = this.h) == null) {
            return;
        }
        pbListView.C(str);
        this.h.B(w());
    }

    @Override // com.repackage.mm7
    public void j(int i) {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        NavigationBar navigationBar = this.c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(nearbyFriendsActivity.getPageContext(), i);
        }
        hu4 hu4Var = this.g;
        if (hu4Var != null) {
            hu4Var.H(i);
        }
        PbListView pbListView = this.h;
        if (pbListView != null) {
            pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
            this.h.d(i);
        }
    }

    @Override // com.repackage.mm7
    public void k() {
        im7 im7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (im7Var = this.i) == null) {
            return;
        }
        im7Var.i0(false);
    }

    @Override // com.repackage.mm7
    public void l(int i) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (bdSwipeRefreshLayout = this.e) == null) {
            return;
        }
        bdSwipeRefreshLayout.setVisibility(i);
    }

    @Override // com.repackage.mm7
    public void m() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.d) == null) {
            return;
        }
        nearbyFriendsActivity.hideLoadingView(frameLayout);
    }

    @Override // com.repackage.mm7
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            C();
        }
    }

    @Override // com.repackage.mm7
    public void o(lm7 lm7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, lm7Var) == null) {
            this.b = lm7Var;
        }
    }

    @Override // com.repackage.mm7
    public void onCreate() {
        NearbyFriendsActivity nearbyFriendsActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (nearbyFriendsActivity = this.a) == null) {
            return;
        }
        this.c = (NavigationBar) nearbyFriendsActivity.findViewById(R.id.obfuscated_res_0x7f091568);
        this.d = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0906a3);
        this.e = (BdSwipeRefreshLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091a9b);
        this.f = (BdTypeRecyclerView) this.a.findViewById(R.id.obfuscated_res_0x7f09157e);
        z();
        B();
        A();
        y();
        this.b.reload();
    }

    @Override // com.repackage.mm7
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            hu4 hu4Var = this.g;
            if (hu4Var != null) {
                hu4Var.f(null);
            }
            PbListView pbListView = this.h;
            if (pbListView != null) {
                pbListView.B(null);
            }
            this.a = null;
        }
    }

    @Override // com.repackage.mm7
    public void p() {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.d) == null) {
            return;
        }
        nearbyFriendsActivity.hideNetRefreshView(frameLayout);
    }

    @Override // com.repackage.mm7
    public void q(String str) {
        NearbyFriendsActivity nearbyFriendsActivity;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (nearbyFriendsActivity = this.a) == null || (frameLayout = this.d) == null) {
            return;
        }
        nearbyFriendsActivity.showNetRefreshView(frameLayout, str, false);
    }

    public final View.OnClickListener w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new a(this) : (View.OnClickListener) invokeV.objValue;
    }

    public final BdListView.p x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? new b(this) : (BdListView.p) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.a == null) {
            return;
        }
        PbListView pbListView = new PbListView(this.a);
        this.h = pbListView;
        pbListView.b();
        this.h.p(R.color.transparent);
        this.h.t(pi.f(this.a, R.dimen.tbds182));
        this.h.x();
        this.h.G(R.dimen.tbfontsize36);
        this.h.E(SkinManager.getColor(R.color.CAM_X0107));
        this.h.A(R.color.CAM_X0110);
        this.h.s();
        this.h.B(w());
    }

    public final void z() {
        NearbyFriendsActivity nearbyFriendsActivity;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (nearbyFriendsActivity = this.a) == null || (navigationBar = this.c) == null) {
            return;
        }
        navigationBar.setCenterTextTitle(nearbyFriendsActivity.getString(R.string.obfuscated_res_0x7f0f0c08));
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }
}
