package com.repackage;

import android.app.Activity;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rm8 extends za {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final nl8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm8(MainTabActivity mainTabActivity, al8 al8Var) {
        super(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, al8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = mainTabActivity.f;
    }

    public final void a() {
        nl8 nl8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (nl8Var = this.b) == null || nl8Var.a() == null || this.a.C != 1) {
            return;
        }
        this.b.a().e();
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        MainTabActivity mainTabActivity = this.a;
        if (currentActivity != mainTabActivity || mainTabActivity.D.intValue() == 1) {
            return;
        }
        this.b.a().h();
    }

    public final void b(ProfileHttpResponseMessage profileHttpResponseMessage) {
        nl8 nl8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileHttpResponseMessage) == null) {
            if (profileHttpResponseMessage != null && profileHttpResponseMessage.GetUser() != null) {
                this.a.C = profileHttpResponseMessage.GetUser().my_like_num.intValue();
                if (this.a.C == 1 && (nl8Var = this.b) != null && nl8Var.a() != null) {
                    this.b.a().e();
                    this.b.a().h();
                }
                a();
                i08.a().c(profileHttpResponseMessage.GetUser().virtual_image_info);
            }
            if (profileHttpResponseMessage == null || profileHttpResponseMessage.getMemberBlockInfo() == null) {
                return;
            }
            this.a.O = profileHttpResponseMessage.getMemberBlockInfo().is_permanent_ban.intValue() == 1;
            this.a.P = profileHttpResponseMessage.getMemberBlockInfo().is_auto_pay.intValue() == 1;
            TbSingleton.getInstance().setUserBan(profileHttpResponseMessage.getMemberBlockInfo().is_ban.intValue() == 1);
        }
    }

    public final void c(ProfileSocketResponseMessage profileSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, profileSocketResponseMessage) == null) {
            if (profileSocketResponseMessage != null && profileSocketResponseMessage.GetUser() != null) {
                this.a.C = profileSocketResponseMessage.GetUser().my_like_num.intValue();
                if (this.a.C == 1) {
                    nl8 nl8Var = this.b;
                    if (nl8Var != null && nl8Var.a() != null) {
                        this.b.a().e();
                    }
                    a();
                }
                i08.a().c(profileSocketResponseMessage.GetUser().virtual_image_info);
            }
            if (profileSocketResponseMessage == null || profileSocketResponseMessage.getMemberBlockInfo() == null) {
                return;
            }
            this.a.O = profileSocketResponseMessage.getMemberBlockInfo().is_permanent_ban.intValue() == 1;
            this.a.P = profileSocketResponseMessage.getMemberBlockInfo().is_auto_pay.intValue() == 1;
            TbSingleton.getInstance().setUserBan(profileSocketResponseMessage.getMemberBlockInfo().is_ban.intValue() == 1);
        }
    }

    @Override // com.repackage.za
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, responsedMessage) == null) {
            boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
            if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                if (z) {
                    c((ProfileSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    b((ProfileHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
