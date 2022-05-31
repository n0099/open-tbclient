package com.repackage;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.VideoClickTabData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class am8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final uj8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am8(MainTabActivity mainTabActivity, uj8 uj8Var) {
        super(2921610);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, uj8Var};
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
        this.b = uj8Var;
        setPriority(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        uj8 uj8Var;
        VideoClickTabData videoClickTabData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921610 || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof VideoClickTabData) || (uj8Var = this.b) == null || uj8Var.z() == null || (videoClickTabData = (VideoClickTabData) customResponsedMessage.getData()) == null) {
            return;
        }
        MainTabActivity mainTabActivity = this.a;
        if (mainTabActivity.isResumed || mainTabActivity.reloginGotoType == 23) {
            TbSingleton.getInstance().setFromFeedVideoClick(true);
            this.b.z().t(true, videoClickTabData.getMiddleFragment());
            TbSingleton.getInstance().setVideoChannelAttentionRedIcon(TbSingleton.getInstance().getVideoChannelAttentionRedIcon());
            this.b.z().setCurrentTabByType(22);
        }
    }
}
