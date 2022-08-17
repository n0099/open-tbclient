package com.repackage;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.myCollection.ThreadFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur4;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class vn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public NavigationBarShadowView b;
    public BdListView c;
    public View d;
    public bv4 e;
    public NoDataView f;
    public un7 g;
    public RelativeLayout h;
    public ProgressBar i;
    public ur4 j;
    public ur4.e k;
    public c l;
    public boolean m;
    public AbsListView.OnScrollListener n;

    /* loaded from: classes7.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn7 a;

        public a(vn7 vn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn7Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && i == 0) {
                View childAt = absListView.getChildAt(0);
                if (this.a.b == null || childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.a.b.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            NavigationBarShadowView navigationBarShadowView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && (navigationBarShadowView = this.a.b) != null && i == 1) {
                navigationBarShadowView.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(vn7 vn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wn7 a;

        public c(wn7 wn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            wn7 wn7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (wn7Var = this.a) == null) {
                return;
            }
            wn7Var.w(Boolean.TRUE);
        }
    }

    public vn7(ThreadFragment threadFragment, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadFragment, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = false;
        this.n = new a(this);
        this.a = threadFragment.getBaseFragmentActivity();
        this.b = (NavigationBarShadowView) view2.findViewById(R.id.obfuscated_res_0x7f091612);
        this.i = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f091a78);
        this.h = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09175b);
        this.f = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.COLLECTION, qi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07027b)), NoDataViewFactory.e.b(R.string.obfuscated_res_0x7f0f0a97, R.string.obfuscated_res_0x7f0f0a98), null);
        un7 un7Var = new un7(threadFragment.getPageContext());
        this.g = un7Var;
        un7Var.notifyDataSetChanged();
        this.e = new bv4(threadFragment.getPageContext());
        BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f091308);
        this.c = bdListView;
        bdListView.setPullRefresh(this.e);
        this.e.f(threadFragment);
        this.d = new TextView(this.a.getActivity());
        this.d.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + qi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070306)));
        this.c.x(this.d, 0);
        this.c.setAdapter((ListAdapter) this.g);
        this.c.setOnSrollToBottomListener(threadFragment);
        this.c.setOnItemClickListener(threadFragment);
        this.c.setOnScrollListener(this.n);
        this.g.k(threadFragment);
        this.g.r(threadFragment);
        this.g.q(threadFragment);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.g.l(z);
            this.g.notifyDataSetChanged();
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.d, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdListView = this.c) == null) {
            return;
        }
        bdListView.A(0L);
    }

    public void d(boolean z, String str, wn7 wn7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, wn7Var}) == null) {
            if (z) {
                BaseFragmentActivity baseFragmentActivity = this.a;
                baseFragmentActivity.showToast(baseFragmentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f04b9));
                if (wn7Var != null && wn7Var.n() != null) {
                    this.g.j(wn7Var.n());
                    if (wn7Var.n().size() == 0) {
                        if (this.l == null) {
                            this.l = new c(wn7Var);
                        } else {
                            rg.a().removeCallbacks(this.l);
                        }
                        rg.a().postDelayed(this.l, 600L);
                    }
                } else {
                    this.i.setVisibility(8);
                    return;
                }
            } else {
                this.a.showToast(str);
            }
            this.g.m(false);
            this.i.setVisibility(8);
        }
    }

    public void e(String str, wn7 wn7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, str, wn7Var, z) == null) {
            this.g.p(true);
            if (str != null) {
                this.a.showToast(str);
            }
            if (wn7Var != null) {
                if (wn7Var.p() < 20) {
                    this.g.n(false);
                    this.g.m(true);
                } else {
                    this.g.n(true);
                    this.g.m(true);
                }
                this.g.j(wn7Var.n());
                p(wn7Var, z);
            }
            this.g.p(false);
            this.g.notifyDataSetChanged();
            if (k()) {
                r(false);
            }
        }
    }

    public void f(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.a.closeLoadingDialog();
            if (str != null) {
                this.a.showToast(str);
            }
            if (z2) {
                t();
            }
            this.g.notifyDataSetChanged();
        }
    }

    public int g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) ? z ? R.id.obfuscated_res_0x7f091e3a : R.id.obfuscated_res_0x7f090d73 : invokeZ.intValue;
    }

    public int h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) ? z ? R.id.obfuscated_res_0x7f091e3c : R.id.obfuscated_res_0x7f091496 : invokeZ.intValue;
    }

    public int i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) ? z ? R.id.obfuscated_res_0x7f091e3b : R.id.obfuscated_res_0x7f090d75 : invokeZ.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.i.setVisibility(8);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void l(MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, markData) == null) || markData == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.getPageContext().getPageActivity()).createNormalConfig(og.g(markData.getUesrId(), 0L), false, markData.isGod())));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g.notifyDataSetChanged();
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            bv4 bv4Var = this.e;
            if (bv4Var != null) {
                bv4Var.H(i);
            }
            m();
            NoDataView noDataView = this.f;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i);
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ur4 ur4Var = this.j;
            if (ur4Var != null) {
                ur4Var.dismiss();
                this.j = null;
            }
            ProgressBar progressBar = this.i;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (this.l != null) {
                rg.a().removeCallbacks(this.l);
            }
            un7 un7Var = this.g;
            if (un7Var != null) {
                un7Var.i();
            }
        }
    }

    public void p(wn7 wn7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, wn7Var, z) == null) {
            if (wn7Var == null) {
                s();
            } else if (wn7Var.m() > 0) {
                this.f.setVisibility(8);
                this.c.removeHeaderView(this.f);
                this.g.notifyDataSetChanged();
            } else if (wn7Var.m() != 0 || z) {
            } else {
                s();
            }
        }
    }

    public void q(ur4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.m = z;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f.d(this.a.getPageContext());
            this.c.removeHeaderView(this.f);
            this.c.addHeaderView(this.f);
            this.f.setVisibility(0);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.j == null) {
                ur4 ur4Var = new ur4(this.a.getPageContext().getPageActivity());
                this.j = ur4Var;
                ur4Var.setTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f133d));
                this.j.setMessage(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c3d));
                if (this.k != null) {
                    this.j.setPositiveButton(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f100c), this.k);
                }
                this.j.setNegativeButton(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0431), new b(this));
                this.j.create(this.a.getPageContext());
                this.j.setCanceledOnTouchOutside(true);
            }
            this.j.show();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.i.setVisibility(0);
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            if (i == 0) {
                this.c.F();
                return;
            }
            this.g.p(true);
            this.g.notifyDataSetChanged();
        }
    }

    public void w(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) {
            this.g.j(arrayList);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.f.isShown()) {
            this.f.d(this.a.getPageContext());
        }
    }
}
