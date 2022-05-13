package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nr4;
/* loaded from: classes6.dex */
public class jk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) || nr4Var == null) {
                return;
            }
            nr4Var.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ BlockPopInfoData b;

        public b(TbPageContext tbPageContext, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = blockPopInfoData;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                UrlManager.getInstance().dealOneLink(this.a, new String[]{this.b.ahead_url});
                if (nr4Var == null) {
                    return;
                }
                nr4Var.dismiss();
            }
        }
    }

    public static boolean a(TbPageContext<?> tbPageContext, FrsViewData frsViewData) {
        InterceptResult invokeLL;
        String fixedText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, frsViewData)) == null) {
            if (tbPageContext != null && frsViewData != null) {
                if (!ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
                    return true;
                }
                AntiData anti = frsViewData.getAnti();
                if (anti != null) {
                    if (b(tbPageContext, anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (StringHelper.getRealSize(forbid_info) > 14) {
                            forbid_info = StringHelper.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast i = BdToast.i(tbPageContext.getPageActivity(), forbid_info, R.drawable.obfuscated_res_0x7f0809be, true);
                        i.k(1.25f);
                        i.q();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(TbPageContext<?> tbPageContext, int i, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, tbPageContext, i, blockPopInfoData)) == null) {
            if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            String string = StringUtils.isNull(blockPopInfoData.block_info) ? tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f06ca) : blockPopInfoData.block_info;
            if (i != 1 && i != 2) {
                BdToast i2 = BdToast.i(tbPageContext.getPageActivity(), string, R.drawable.obfuscated_res_0x7f0809be, true);
                i2.k(1.25f);
                i2.q();
                return false;
            }
            nr4 nr4Var = new nr4(tbPageContext.getPageActivity());
            nr4Var.setMessage(StringHelper.getFixedText(string, 50, true));
            nr4Var.setNegativeButton(StringHelper.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f07e0) : blockPopInfoData.ok_info, 4, true), new a());
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                nr4Var.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new b(tbPageContext, blockPopInfoData));
            }
            nr4Var.create(tbPageContext).show();
            return true;
        }
        return invokeLIL.booleanValue;
    }
}
