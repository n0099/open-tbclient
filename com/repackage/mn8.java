package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.switchs.CreateCenterTipSwitch;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final tm8 b;
    public final gn8 c;

    public mn8(MainTabActivity mainTabActivity, tm8 tm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, tm8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = tm8Var;
        this.c = mainTabActivity.mLogicController;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && CreateCenterTipSwitch.isOn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921538));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            tm8 tm8Var = this.b;
            if (tm8Var != null && tm8Var.y() != null && this.b.y().getAnimationView() != null && this.b.y().getAnimationView().getVisibility() != 0) {
                this.b.y().setLottieView(false);
            }
            if (TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                    String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                    if (!StringUtils.isNull(h5Url)) {
                        iu4 k = iu4.k();
                        if (k.h("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{h5Url}, true);
                            iu4 k2 = iu4.k();
                            k2.u("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                }
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                    if (!StringUtils.isNull(myTabText)) {
                        tm8 tm8Var2 = this.b;
                        if (tm8Var2 != null) {
                            tm8Var2.N(myTabText);
                        }
                    } else {
                        tm8 tm8Var3 = this.b;
                        if (tm8Var3 != null) {
                            tm8Var3.N(null);
                        }
                    }
                } else {
                    tm8 tm8Var4 = this.b;
                    if (tm8Var4 != null) {
                        tm8Var4.N(null);
                    }
                }
            } else {
                tm8 tm8Var5 = this.b;
                if (tm8Var5 != null) {
                    tm8Var5.N(null);
                }
            }
            if (TbSingleton.getInstance().canShowPermDialog()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921360, this.b));
            }
            wn4.b().l("1", "");
            gn8 gn8Var = this.c;
            if (gn8Var != null && gn8Var.j() != null) {
                this.c.j().a();
            }
            a();
        }
    }
}
