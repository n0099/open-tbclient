package com.repackage;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.VideoClickTabData;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class vo8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final wn8 b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo8 a;

        public a(vo8 vo8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vo8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vo8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.isFinishing()) {
                return;
            }
            vo8 vo8Var = this.a;
            vo8Var.c(vo8Var.a.getIntent());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vo8(MainTabActivity mainTabActivity, wn8 wn8Var) {
        super(2007002);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, wn8Var};
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
        this.b = wn8Var;
        setPriority(100);
    }

    public final void c(Intent intent) {
        wn8 wn8Var;
        int a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null || (wn8Var = this.b) == null || wn8Var.z() == null) {
            return;
        }
        try {
            if (intent.hasExtra("locate_type")) {
                a2 = intent.getIntExtra("locate_type", 1);
            } else {
                a2 = this.a.mAppEntranceModel.a();
            }
            this.b.z().setCurrentTabByType(a2);
        } catch (Throwable th) {
            BdLog.e(th);
            this.a.finish();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<m45> b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null || (b = ((o45) customResponsedMessage.getData()).b()) == null || b.size() == 0) {
            return;
        }
        this.b.A(b);
        MainTabActivity mainTabActivity = this.a;
        if (mainTabActivity.isUseCurrType) {
            if (mainTabActivity.reloginGotoType != 23) {
                wn8 wn8Var = this.b;
                if (wn8Var != null && wn8Var.z() != null) {
                    this.b.z().setCurrentTabByType(this.a.reloginGotoType);
                }
            } else {
                VideoClickTabData videoClickTabData = new VideoClickTabData();
                Bundle reloginVideoMiddleBundle = TbSingleton.getInstance().getReloginVideoMiddleBundle();
                TbSingleton.getInstance().setReloginVideoMiddleBundle(null);
                reloginVideoMiddleBundle.remove(VideoPlayActivityConfig.VIDEO_VIEW_RECT);
                videoClickTabData.setVideoMiddleBundle(reloginVideoMiddleBundle);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921610, videoClickTabData));
            }
        } else {
            wn8 wn8Var2 = this.b;
            if (wn8Var2 != null && wn8Var2.z() != null) {
                if (this.a.getIntent() != null && this.a.getIntent().getDataString() != null && this.a.getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                    this.b.z().setCurrentTabByType(2);
                } else {
                    pg.a().postDelayed(new a(this), 300L);
                }
            }
        }
        this.a.isUseCurrType = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921567, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, 0));
    }
}
