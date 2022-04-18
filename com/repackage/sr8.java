package com.repackage;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
/* loaded from: classes7.dex */
public class sr8 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public UEGCancelModel a;
    public UEGCancelModel.b b;
    public int c;

    /* loaded from: classes7.dex */
    public class a implements UEGCancelModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr8 a;

        public a(sr8 sr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr8Var;
        }

        @Override // com.baidu.tieba.ueg.UEGCancelModel.b
        public void a(BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, blockPopInfoData) == null) || blockPopInfoData == null || sr8.d) {
                return;
            }
            this.a.d(blockPopInfoData);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfoData a;
        public final /* synthetic */ sr8 b;

        public b(sr8 sr8Var, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr8Var, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sr8Var;
            this.a = blockPopInfoData;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", this.b.c).param("obj_type", this.a.win_type));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfoData a;
        public final /* synthetic */ sr8 b;

        public c(sr8 sr8Var, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr8Var, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sr8Var;
            this.a = blockPopInfoData;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.b.e(this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", this.b.c).param("obj_type", this.a.win_type));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755310824, "Lcom/repackage/sr8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755310824, "Lcom/repackage/sr8;");
        }
    }

    public sr8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_COLD_BOOT;
        this.a = new UEGCancelModel();
        if (this.b == null) {
            this.b = new a(this);
        }
        this.a.A(this.b);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c = i;
            this.a.z();
        }
    }

    public final void d(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, blockPopInfoData) == null) || blockPopInfoData == null || x8.f().b() == null) {
            return;
        }
        String str = blockPopInfoData.block_id_code;
        int i = blockPopInfoData.win_type;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str2 = blockPopInfoData.ahead_url;
        String str3 = blockPopInfoData.ok_info;
        String str4 = blockPopInfoData.ahead_info;
        String str5 = blockPopInfoData.block_info;
        if ((i != 1 && i != 2 && i != 3 && i != 4) || ni.isEmpty(currentAccount) || ni.isEmpty(str)) {
            return;
        }
        vt4 k = vt4.k();
        boolean z = false;
        boolean h = k.h(str + i + currentAccount, false);
        if ((!ni.isEmpty(str2) || i == 4) && !ni.isEmpty(str3) && ((!ni.isEmpty(str4) || i == 4) && !ni.isEmpty(str5))) {
            z = true;
        }
        if (h || !z) {
            return;
        }
        vt4 k2 = vt4.k();
        k2.u(str + i + currentAccount, true);
        h(blockPopInfoData);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", this.c).param("obj_type", i));
    }

    public final void e(BlockPopInfoData blockPopInfoData) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, blockPopInfoData) == null) || blockPopInfoData == null || (b2 = x8.f().b()) == null) {
            return;
        }
        AntiHelper.p(b2, blockPopInfoData.ahead_url);
    }

    public void f() {
        UEGCancelModel uEGCancelModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (uEGCancelModel = this.a) == null) {
            return;
        }
        uEGCancelModel.onDestroy();
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            d = z;
        }
    }

    public final void h(BlockPopInfoData blockPopInfoData) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, blockPopInfoData) == null) || blockPopInfoData == null || (b2 = x8.f().b()) == null) {
            return;
        }
        cr4 cr4Var = new cr4(b2);
        cr4Var.setMessage(blockPopInfoData.block_info);
        cr4Var.setNegativeButton(blockPopInfoData.ok_info, new b(this, blockPopInfoData));
        cr4Var.setPositiveButton(blockPopInfoData.ahead_info, new c(this, blockPopInfoData));
        cr4Var.create(((c9) b2).getPageContext());
        cr4Var.show();
    }
}
