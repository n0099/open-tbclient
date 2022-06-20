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
import com.repackage.ge6;
import com.repackage.yq4;
/* loaded from: classes6.dex */
public class ge6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public AcceleratorNetModel b;
    public iv8 c;
    public hv8 d;
    public AcceleratorNetModel.b e;
    public he6 f;
    public yq4.e g;
    public AcceleratorData h;
    public int i;
    public int j;
    public boolean k;

    /* loaded from: classes6.dex */
    public class a implements hv8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ge6 a;

        public a(ge6 ge6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge6Var;
        }

        @Override // com.repackage.hv8
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

        @Override // com.repackage.hv8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                dp6.h(this.a.a.getActivity(), new View.OnClickListener() { // from class: com.repackage.ce6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            ge6.a.this.c(view2);
                        }
                    }
                }, new View.OnClickListener() { // from class: com.repackage.de6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            ge6.a.this.d(view2);
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
        public final /* synthetic */ ge6 a;

        public b(ge6 ge6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ge6Var;
        }

        @Override // com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel.b
        public void a(AcceleratorData acceleratorData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, acceleratorData) == null) {
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
                    ge6 ge6Var = this.a;
                    ge6Var.f = he6.c(ge6Var.a.getPageContext());
                    String[] b = re6.b(this.a.h.getAvailableTornadoNodeInfoList(), this.a.h.getAvailableNodesNum());
                    String str = b[0];
                    if (this.a.h.getItemData() != null) {
                        String acceleratorServer = TbSingleton.getInstance().getAcceleratorServer(String.valueOf(this.a.h.getItemData().itemId));
                        if (!StringUtils.isNull(acceleratorServer)) {
                            str = acceleratorServer;
                        }
                    }
                    this.a.f.d(str);
                    he6 he6Var = this.a.f;
                    he6Var.e(this.a.g);
                    he6Var.f(b);
                    he6Var.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0062));
                    he6Var.h();
                    return;
                }
                BdToast.c(this.a.a.getContext(), this.a.h.getTokenInfo().getFailContent()).n();
            }
        }

        @Override // com.baidu.tieba.frs.accelerator.model.AcceleratorNetModel.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.o();
                if (this.a.a != null) {
                    BdToast.c(this.a.a.getContext(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0061)).n();
                }
            }
        }
    }

    public ge6(FrsFragment frsFragment) {
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
        this.c = iv8.c(this.a);
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
            if (frsFragment == null || frsFragment.P0() == null || this.a.P0().itemInfo == null) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                BdToast.c(this.a.getContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0063)).n();
            } else if (TbSingleton.getInstance().acceleratorItemId != this.a.P0().itemInfo.id.intValue() && TbSingleton.getInstance().acceleratorItemId != -1) {
                dp6.e(this.a.getActivity(), new View.OnClickListener() { // from class: com.repackage.fe6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            ge6.this.x(view2);
                        }
                    }
                });
            } else if (TbSingleton.getInstance().acceleratorItemId == this.a.P0().itemInfo.id.intValue()) {
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
            he6 he6Var = this.f;
            if (he6Var != null) {
                he6Var.b();
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

    public iv8 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c : (iv8) invokeV.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b bVar = new b(this);
            this.e = bVar;
            this.b.C(bVar);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g = new yq4.e() { // from class: com.repackage.ee6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.yq4.e
                public final void W(yq4 yq4Var, int i, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, yq4Var, i, view2) == null) {
                        ge6.this.w(yq4Var, i, view2);
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
            he6 he6Var = this.f;
            if (he6Var != null) {
                he6Var.b();
            }
            PkgNameAndNodeInfoData pkgNameAndNodeInfoData = re6.a(this.h.getAvailableTornadoNodeInfoList()).get(Integer.valueOf(this.i));
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

    public /* synthetic */ void w(yq4 yq4Var, int i, View view2) {
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (frsFragment = this.a) == null || frsFragment.P0() == null || this.a.P0().itemInfo == null) {
            return;
        }
        A();
        this.b.B(this.a.P0().itemInfo.id.intValue());
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c.b(this.d);
        }
    }
}
