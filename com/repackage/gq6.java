package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.slideLoadingLayout.AdvancedAdSlideLoadingLayout;
import com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class gq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public AdvancedAdSlideLoadingLayout b;
    public AppBarLayout c;
    public BdTypeRecyclerView d;
    public xd6 e;
    public String f;
    public List<String> g;
    public int h;
    public boolean i;
    public nv4 j;
    public mv4 k;
    public lv4 l;
    public Runnable m;

    /* loaded from: classes6.dex */
    public class a implements nv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(gq6 gq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nv4
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq6 a;

        public b(gq6 gq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq6Var;
        }

        @Override // com.repackage.mv4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.mv4
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.i();
                this.a.i = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921680, 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements lv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq6 a;

        public c(gq6 gq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq6Var;
        }

        @Override // com.repackage.lv4
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.repackage.lv4
        public void b(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.repackage.lv4
        public void c(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.repackage.lv4
        public void d(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
                if (this.a.e != null) {
                    this.a.e.D();
                }
                if (this.a.i) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921680, 2));
                }
                this.a.i = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gq6 a;

        public d(gq6 gq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.o();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends TypeToken<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(gq6 gq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public gq6(@NonNull FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = "999999";
        this.j = new a(this);
        this.k = new b(this);
        this.l = new c(this);
        this.m = new d(this);
        this.a = frsFragment;
        View K2 = frsFragment.K2();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) K2.findViewById(R.id.obfuscated_res_0x7f090ade);
        this.b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.k(this.j);
        this.b.j(this.k);
        this.b.i(this.l);
        this.b.n();
        this.c = (AppBarLayout) K2.findViewById(R.id.obfuscated_res_0x7f090abf);
        this.d = (BdTypeRecyclerView) K2.findViewById(R.id.obfuscated_res_0x7f090b79);
    }

    public void f(co4 co4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, co4Var) == null) {
            if (co4Var != null && !li.isEmpty(co4Var.b) && !li.isEmpty(co4Var.a) && co4Var.c >= 0) {
                if (this.b.v()) {
                    this.b.o();
                }
                this.b.X(co4Var, (ViewGroup) this.a.getActivity().getWindow().getDecorView());
                this.b.setAdvancedAdStyle(true);
                this.b.setNavigationBar((NavigationBar) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f0923fd));
                return;
            }
            this.b.setAdvancedAdStyle(false);
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = false;
            if (this.b.getData() != null && this.b.b0()) {
                co4 data = this.b.getData();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = this.f;
                }
                String str = currentAccount + data.i;
                List<String> list = (List) new Gson().fromJson(iu4.k().q("key_uid_adid", ""), new e(this).getType());
                this.g = list;
                if (list == null) {
                    this.g = new ArrayList();
                }
                Iterator<String> it = this.g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringHelper.isTaday(iu4.k().m(next, 0L))) {
                        iu4.k().D(next);
                        it.remove();
                    }
                }
                if (!StringHelper.isTaday(iu4.k().m(str, 0L))) {
                    this.g.add(str);
                    iu4.k().x(str, System.currentTimeMillis());
                    z = true;
                }
                iu4.k().y("key_uid_adid", this.g.toString());
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (advancedAdSlideLoadingLayout = this.b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.Z();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ng.a().postDelayed(this.m, 5000L);
            xd6 xd6Var = this.e;
            if (xd6Var != null) {
                xd6Var.k0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public xd6 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (xd6) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b.getLoadingVewMaxHeight() : invokeV.intValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b.v() : invokeV.booleanValue;
    }

    public BaseSlideLoadingLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (BaseSlideLoadingLayout) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View findViewById = this.a.K2().findViewById(R.id.obfuscated_res_0x7f090d1e);
            TbImageView tbImageView = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090d1d);
            tbImageView.setPlaceHolder(2);
            TbVideoView tbVideoView = (TbVideoView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092370);
            TbImageView tbImageView2 = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f09236a);
            View findViewById2 = this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f09236f);
            View findViewById3 = this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090d35);
            if (findViewById == null) {
                return;
            }
            this.b.setBgView(findViewById);
            this.b.l(tbImageView2);
            this.b.l(tbVideoView);
            this.b.l(findViewById2);
            int A2 = this.a.A2();
            if (findViewById3.getVisibility() == 0) {
                A2 -= this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            }
            if (A2 <= 0) {
                A2 = findViewById.getLayoutParams().height;
            }
            this.b.setAdvancedAdView(tbImageView, A2, mi.k(this.a.getContext()));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.m(this.a.K2().findViewById(R.id.obfuscated_res_0x7f090b22), 0);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.o();
            ng.a().removeCallbacks(this.m);
        }
    }

    public void q() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (findViewById = this.a.K2().findViewById(R.id.obfuscated_res_0x7f090d1e)) == null || findViewById.getLayoutParams() == null || this.b == null) {
            return;
        }
        this.b.m(findViewById, findViewById.getLayoutParams().height);
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h = i;
        }
    }

    public void s(xd6 xd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, xd6Var) == null) {
            this.e = xd6Var;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.b.setEnableSlideLoading(z);
        }
    }

    public void u(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && i == this.h) {
            if (z) {
                x();
                return;
            }
            this.d.getAdapter().notifyDataSetChanged();
            y();
        }
    }

    public void v(boolean z) {
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (advancedAdSlideLoadingLayout = this.b) == null) {
            return;
        }
        advancedAdSlideLoadingLayout.setEnable(z);
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && g()) {
            this.b.e0();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = this.b;
            if (advancedAdSlideLoadingLayout != null || advancedAdSlideLoadingLayout.u()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.d;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                AppBarLayout appBarLayout = this.c;
                if (appBarLayout != null) {
                    appBarLayout.setExpanded(true);
                }
                this.b.H();
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.b.v()) {
            this.b.o();
            ng.a().removeCallbacks(this.m);
        }
    }
}
