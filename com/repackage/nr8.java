package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dr4;
import tbclient.BlockPopInfo;
/* loaded from: classes6.dex */
public class nr8 {
    public static /* synthetic */ Interceptable $ic;
    public static BlockPopInfo c;
    public static BlockPopInfo d;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public CustomMessageListener b;

    /* loaded from: classes6.dex */
    public class a implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(nr8 nr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BlockPopInfo a;
        public final /* synthetic */ nr8 b;

        public b(nr8 nr8Var, BlockPopInfo blockPopInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nr8Var, blockPopInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nr8Var;
            this.a = blockPopInfo;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.b.e(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(nr8 nr8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nr8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            nr8.g(null);
            nr8.f(null);
        }
    }

    public nr8(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c cVar = new c(this, 2005016);
        this.b = cVar;
        this.a = tbPageContext;
        tbPageContext.registerListener(cVar);
    }

    public static void f(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, blockPopInfo) == null) {
            d = blockPopInfo;
        }
    }

    public static void g(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, blockPopInfo) == null) {
            c = blockPopInfo;
        }
    }

    public final boolean b(BlockPopInfo blockPopInfo) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, blockPopInfo)) == null) {
            if (blockPopInfo != null && (num = blockPopInfo.appeal_status) != null && num.intValue() == 1) {
                BdToast.h(this.a.getPageActivity(), blockPopInfo.appeal_msg, R.drawable.obfuscated_res_0x7f0809a5, 3000, false).q();
                return true;
            } else if (blockPopInfo == null || blockPopInfo.can_post.intValue() != 0 || (!(blockPopInfo.ahead_type.intValue() == 1 || blockPopInfo.ahead_type.intValue() == 2) || blockPopInfo.appeal_status.intValue() == 1)) {
                return false;
            } else {
                if (blockPopInfo.ahead_type.intValue() == 1) {
                    String str = blockPopInfo.block_info;
                    String str2 = blockPopInfo.ok_info;
                    if (!ni.isEmpty(str) && !ni.isEmpty(str2)) {
                        h(blockPopInfo);
                    } else {
                        BdToast.h(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0804), R.drawable.obfuscated_res_0x7f0809a5, 3000, false).q();
                    }
                } else if (blockPopInfo.ahead_type.intValue() == 2) {
                    e(blockPopInfo);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b(d) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b(c) : invokeV.booleanValue;
    }

    public final void e(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, blockPopInfo) == null) || blockPopInfo == null) {
            return;
        }
        AntiHelper.p(this.a.getPageActivity(), blockPopInfo.ahead_url);
    }

    public final void h(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, blockPopInfo) == null) || blockPopInfo == null) {
            return;
        }
        dr4 dr4Var = new dr4(this.a.getPageActivity());
        dr4Var.setMessage(blockPopInfo.block_info);
        dr4Var.setNegativeButton(blockPopInfo.ok_info, new a(this));
        dr4Var.setPositiveButton(blockPopInfo.ahead_info, new b(this, blockPopInfo));
        dr4Var.create(this.a).show();
    }
}
