package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final al8 b;
    public final nl8 c;

    public sl8(MainTabActivity mainTabActivity, al8 al8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, al8Var};
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
        this.b = al8Var;
        this.c = mainTabActivity.f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            al8 al8Var = this.b;
            if (al8Var != null && al8Var.A() != null && this.b.A().getAnimationView() != null && this.b.A().getAnimationView().getVisibility() != 0) {
                this.b.A().setLottieView(false);
            }
            if (TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                    String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                    if (!StringUtils.isNull(h5Url)) {
                        xt4 k = xt4.k();
                        if (k.h("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{h5Url}, true);
                            xt4 k2 = xt4.k();
                            k2.u("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                }
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                    if (!StringUtils.isNull(myTabText)) {
                        al8 al8Var2 = this.b;
                        if (al8Var2 != null) {
                            al8Var2.P(myTabText);
                        }
                    } else {
                        al8 al8Var3 = this.b;
                        if (al8Var3 != null) {
                            al8Var3.P(null);
                        }
                    }
                } else {
                    al8 al8Var4 = this.b;
                    if (al8Var4 != null) {
                        al8Var4.P(null);
                    }
                }
            } else {
                al8 al8Var5 = this.b;
                if (al8Var5 != null) {
                    al8Var5.P(null);
                }
            }
            if (TbSingleton.getInstance().canShowPermDialog()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921360, this.b));
            }
            kn4.b().l("1", "");
            nl8 nl8Var = this.c;
            if (nl8Var == null || nl8Var.i() == null) {
                return;
            }
            this.c.i().a();
        }
    }
}
