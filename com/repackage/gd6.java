package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AcceleratorActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.accelerator.AcceleratorData;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gd6;
import com.repackage.oq4;
/* loaded from: classes6.dex */
public class gd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public AcceleratorNetModel b;
    public av8 c;
    public zu8 d;
    public AcceleratorNetModel.b e;
    public hd6 f;
    public oq4.e g;
    public AcceleratorData h;
    public int i;
    public int j;
    public boolean k;

    /* loaded from: classes6.dex */
    public class a implements zu8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd6 a;

        public a(gd6 gd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gd6Var;
        }

        @Override // com.repackage.zu8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (1 == this.a.j || 3 == this.a.j) {
                    this.a.y();
                } else if (2 == this.a.j) {
                    this.a.v();
                }
            }
        }

        @Override // com.repackage.zu8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ao6.h(this.a.a.getActivity(), new View.OnClickListener() { // from class: com.repackage.cd6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            gd6.a.this.c(view2);
                        }
                    }
                }, new View.OnClickListener() { // from class: com.repackage.dd6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            gd6.a.this.d(view2);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void c(View view2) {
            this.a.c.b(this.a.d);
        }

        public /* synthetic */ void d(View view2) {
            if (this.a.f != null) {
                this.a.f.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AcceleratorNetModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd6 a;

        public b(gd6 gd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gd6Var;
        }

        @Override // com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o();
                if (this.a.a != null) {
                    BdToast.c(this.a.a.getContext(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0061)).n();
                }
            }
        }

        @Override // com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel.b
        public void b(AcceleratorData acceleratorData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, acceleratorData) == null) {
                this.a.o();
                this.a.h = acceleratorData;
                if (this.a.a == null || this.a.h == null || this.a.h.getTokenInfo() == null || !StringUtils.isNull(this.a.h.getTokenInfo().getToken())) {
                    if (2 != this.a.j || this.a.a == null || this.a.h == null || ListUtils.isEmpty(this.a.h.getAvailableTornadoNodeInfoList())) {
                        if (3 == this.a.j || 1 == this.a.j) {
                            this.a.v();
                            return;
                        }
                        return;
                    }
                    this.a.t();
                    gd6 gd6Var = this.a;
                    gd6Var.f = hd6.c(gd6Var.a.getPageContext());
                    String[] b = rd6.b(this.a.h.getAvailableTornadoNodeInfoList(), this.a.h.getAvailableNodesNum());
                    String str = b[0];
                    if (this.a.h.getItemData() != null) {
                        String acceleratorServer = TbSingleton.getInstance().getAcceleratorServer(String.valueOf(this.a.h.getItemData().itemId));
                        if (!StringUtils.isNull(acceleratorServer)) {
                            str = acceleratorServer;
                        }
                    }
                    this.a.f.d(str);
                    hd6 hd6Var = this.a.f;
                    hd6Var.e(this.a.g);
                    hd6Var.f(b);
                    hd6Var.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0062));
                    hd6Var.h();
                    return;
                }
                BdToast.c(this.a.a.getContext(), this.a.h.getTokenInfo().getFailContent()).n();
            }
        }
    }

    public gd6(FrsFragment frsFragment) {
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
        this.i = 0;
        this.a = frsFragment;
        this.b = new AcceleratorNetModel();
        this.c = av8.c(this.a);
        s();
        u();
    }

    public final void A() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (frsFragment = this.a) != null && (frsFragment.getActivity() instanceof FrsActivity)) {
            ((FrsActivity) this.a.getActivity()).showLoadingDialog(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0060));
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.j = i;
            FrsFragment frsFragment = this.a;
            if (frsFragment == null || frsFragment.h0() == null || this.a.h0().itemInfo == null) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                BdToast.c(this.a.getContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0063)).n();
            } else if (TbSingleton.getInstance().acceleratorItemId != this.a.h0().itemInfo.id.intValue() && TbSingleton.getInstance().acceleratorItemId != -1) {
                ao6.e(this.a.getActivity(), new View.OnClickListener() { // from class: com.repackage.fd6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            gd6.this.x(view2);
                        }
                    }
                });
            } else if (TbSingleton.getInstance().acceleratorItemId == this.a.h0().itemInfo.id.intValue()) {
                this.k = false;
                q();
            } else if (TbSingleton.getInstance().acceleratorItemId == -1) {
                this.k = true;
                q();
            }
        }
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.j;
            if (i == 2 || i == 1) {
                return 1;
            }
            return i == 3 ? 2 : 0;
        }
        return invokeV.intValue;
    }

    public final void o() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (frsFragment = this.a) != null && (frsFragment.getActivity() instanceof FrsActivity)) {
            ((FrsActivity) this.a.getActivity()).closeLoadingDialog();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            AcceleratorNetModel acceleratorNetModel = this.b;
            if (acceleratorNetModel != null) {
                acceleratorNetModel.destroy();
            }
            hd6 hd6Var = this.f;
            if (hd6Var != null) {
                hd6Var.b();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i = this.j;
            if (1 == i || 3 == i) {
                z();
            } else if (2 == i) {
                y();
            }
        }
    }

    public av8 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (av8) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b bVar = new b(this);
            this.e = bVar;
            this.b.B(bVar);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g = new oq4.e() { // from class: com.repackage.ed6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.oq4.e
                public final void onItemClick(oq4 oq4Var, int i, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                        gd6.this.w(oq4Var, i, view2);
                    }
                }
            };
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d = new a(this);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            hd6 hd6Var = this.f;
            if (hd6Var != null) {
                hd6Var.b();
            }
            PkgNameAndNodeInfoData pkgNameAndNodeInfoData = rd6.a(this.h.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(this.i));
            if (this.j == 2 && pkgNameAndNodeInfoData != null && !pkgNameAndNodeInfoData.compare(TbSingleton.getInstance().acceleratorData)) {
                this.k = true;
            }
            if (!this.k) {
                pkgNameAndNodeInfoData = TbSingleton.getInstance().acceleratorData;
            }
            AcceleratorActivityConfig acceleratorActivityConfig = new AcceleratorActivityConfig(this.a.getContext());
            acceleratorActivityConfig.setAcceleratorData(this.h).setCurrentNodeInfo(pkgNameAndNodeInfoData).setFid(this.a.l).setSource(n()).setIsNewItem(this.k);
            acceleratorActivityConfig.start();
        }
    }

    public /* synthetic */ void w(oq4 oq4Var, int i, View view2) {
        this.i = i;
        z();
    }

    public /* synthetic */ void x(View view2) {
        this.k = true;
        q();
    }

    public final void y() {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (frsFragment = this.a) == null || frsFragment.h0() == null || this.a.h0().itemInfo == null) {
            return;
        }
        A();
        this.b.A(this.a.h0().itemInfo.id.intValue());
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c.b(this.d);
        }
    }
}
