package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public int b;

    public yq8(TbPageContext<?> tbPageContext) {
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
        this.a = tbPageContext;
    }

    public final boolean a(DressItemData dressItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dressItemData)) == null) ? TbadkCoreApplication.getCurrentMemberType() == 1 && dressItemData.getFreeUserLevel() == 1 : invokeL.booleanValue;
    }

    public void b(DressItemData dressItemData, boolean z) {
        String string;
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dressItemData, z) == null) || dressItemData == null) {
            return;
        }
        boolean a = iq8.a(dressItemData);
        if (!a) {
            a = a(dressItemData);
        }
        if (a) {
            this.b = dressItemData.getPropsId();
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_BUBBLE_SET);
            httpMessage.setExtra(Integer.valueOf(this.b));
            httpMessage.addParam("bcode", String.valueOf(this.b));
            MessageManager.getInstance().sendMessage(httpMessage);
        } else if (dressItemData.getFreeUserLevel() == 100) {
            if (dressItemData.getActivityFinish() == 0) {
                iq8.b(this.a, 5, dressItemData.getActivityUrl());
            }
        } else {
            if (dressItemData.getFreeUserLevel() == 101) {
                str = this.a.getString(R.string.obfuscated_res_0x7f0f02f4);
                i = 9;
            } else {
                if (dressItemData.getFreeUserLevel() > 1) {
                    string = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f02fa), Integer.valueOf(dressItemData.getFreeUserLevel()));
                } else {
                    string = this.a.getString(R.string.obfuscated_res_0x7f0f02f6);
                }
                str = string;
                i = 0;
            }
            iq8.d(this.a, 5, str, i, z ? MemberPayStatistic.REFER_PAGE_POST_BUBBLE : MemberPayStatistic.REFER_PAGE_ALL_BUBBLE, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_RENEWWALFEE_BUTTON);
        }
    }
}
