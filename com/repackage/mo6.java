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
public class mo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public AdvancedAdSlideLoadingLayout b;
    public AppBarLayout c;
    public BdTypeRecyclerView d;
    public nc6 e;
    public String f;
    public List<String> g;
    public int h;
    public boolean i;
    public du4 j;
    public cu4 k;
    public bu4 l;
    public Runnable m;

    /* loaded from: classes6.dex */
    public class a implements du4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(mo6 mo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.du4
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements cu4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mo6 a;

        public b(mo6 mo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mo6Var;
        }

        @Override // com.repackage.cu4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.cu4
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
    public class c implements bu4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mo6 a;

        public c(mo6 mo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mo6Var;
        }

        @Override // com.repackage.bu4
        public void a(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.repackage.bu4
        public void b(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.repackage.bu4
        public void c(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // com.repackage.bu4
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
        public final /* synthetic */ mo6 a;

        public d(mo6 mo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mo6Var;
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

        public e(mo6 mo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mo6Var};
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

    public mo6(@NonNull FrsFragment frsFragment) {
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
        View L2 = frsFragment.L2();
        AdvancedAdSlideLoadingLayout advancedAdSlideLoadingLayout = (AdvancedAdSlideLoadingLayout) L2.findViewById(R.id.obfuscated_res_0x7f090acb);
        this.b = advancedAdSlideLoadingLayout;
        advancedAdSlideLoadingLayout.k(this.j);
        this.b.j(this.k);
        this.b.i(this.l);
        this.b.n();
        this.c = (AppBarLayout) L2.findViewById(R.id.obfuscated_res_0x7f090aac);
        this.d = (BdTypeRecyclerView) L2.findViewById(R.id.obfuscated_res_0x7f090b62);
    }

    public void f(rm4 rm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rm4Var) == null) {
            if (rm4Var != null && !ki.isEmpty(rm4Var.b) && !ki.isEmpty(rm4Var.a) && rm4Var.c >= 0) {
                if (this.b.v()) {
                    this.b.o();
                }
                this.b.X(rm4Var, (ViewGroup) this.a.getActivity().getWindow().getDecorView());
                this.b.setAdvancedAdStyle(true);
                this.b.setNavigationBar((NavigationBar) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f0923a2));
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
                rm4 data = this.b.getData();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = this.f;
                }
                String str = currentAccount + data.i;
                List<String> list = (List) new Gson().fromJson(ys4.k().q("key_uid_adid", ""), new e(this).getType());
                this.g = list;
                if (list == null) {
                    this.g = new ArrayList();
                }
                Iterator<String> it = this.g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringHelper.isTaday(ys4.k().m(next, 0L))) {
                        ys4.k().D(next);
                        it.remove();
                    }
                }
                if (!StringHelper.isTaday(ys4.k().m(str, 0L))) {
                    this.g.add(str);
                    ys4.k().x(str, System.currentTimeMillis());
                    z = true;
                }
                ys4.k().y("key_uid_adid", this.g.toString());
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
            mg.a().postDelayed(this.m, 5000L);
            nc6 nc6Var = this.e;
            if (nc6Var != null) {
                nc6Var.m0();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            }
        }
    }

    public nc6 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (nc6) invokeV.objValue;
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
            View findViewById = this.a.L2().findViewById(R.id.obfuscated_res_0x7f090ce2);
            TbImageView tbImageView = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090ce1);
            tbImageView.setPlaceHolder(2);
            TbVideoView tbVideoView = (TbVideoView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092315);
            TbImageView tbImageView2 = (TbImageView) this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f09230f);
            View findViewById2 = this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f092314);
            View findViewById3 = this.a.getActivity().findViewById(R.id.obfuscated_res_0x7f090cfa);
            if (findViewById == null) {
                return;
            }
            this.b.setBgView(findViewById);
            this.b.l(tbImageView2);
            this.b.l(tbVideoView);
            this.b.l(findViewById2);
            int B2 = this.a.B2();
            if (findViewById3.getVisibility() == 0) {
                B2 -= this.a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            }
            if (B2 <= 0) {
                B2 = findViewById.getLayoutParams().height;
            }
            this.b.setAdvancedAdView(tbImageView, B2, li.k(this.a.getContext()));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.m(this.a.L2().findViewById(R.id.obfuscated_res_0x7f090b0b), 0);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.o();
            mg.a().removeCallbacks(this.m);
        }
    }

    public void q() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (findViewById = this.a.L2().findViewById(R.id.obfuscated_res_0x7f090ce2)) == null || findViewById.getLayoutParams() == null || this.b == null) {
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

    public void s(nc6 nc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, nc6Var) == null) {
            this.e = nc6Var;
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
            mg.a().removeCallbacks(this.m);
        }
    }
}
