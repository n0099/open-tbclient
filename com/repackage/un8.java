package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes7.dex */
public class un8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final gn8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public un8(MainTabActivity mainTabActivity) {
        super(2001011);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = mainTabActivity.mLogicController;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean z = false;
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                bl.e();
                bl.h();
                this.a.lastDay = UtilHelper.getCurrentDay();
                iu4.k().x("last_resume_time", TbSingleton.getInstance().getLastResumeTime());
                MainTabActivity mainTabActivity = this.a;
                if (!mainTabActivity.isEnterImageViewActivity) {
                    gn8 gn8Var = this.b;
                    if (gn8Var == null || gn8Var.k() == null) {
                        return;
                    }
                    this.b.k().b();
                    return;
                }
                mainTabActivity.isEnterImageViewActivity = false;
                return;
            }
            String currentDay = UtilHelper.getCurrentDay();
            if (!StringUtils.isNull(currentDay) && !currentDay.equals(this.a.lastDay)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005009, null));
            }
            MainTabActivity mainTabActivity2 = this.a;
            if (mainTabActivity2.mCancelController == null) {
                mainTabActivity2.mCancelController = new pq8();
            }
            pq8 pq8Var = this.a.mCancelController;
            pq8Var.c(pq8Var.c);
            this.a.mCancelController.c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_HOT_BOOT;
            if (jh5.d()) {
                int i = Calendar.getInstance().get(11);
                jh5.a = (i >= 23 || i < 7) ? true : true;
                gn8 gn8Var2 = this.b;
                if (gn8Var2 == null || gn8Var2.k() == null) {
                    return;
                }
                this.b.k().b();
                this.b.k().a();
            }
        }
    }
}
