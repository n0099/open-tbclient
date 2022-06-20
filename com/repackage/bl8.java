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
/* loaded from: classes5.dex */
public class bl8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final dk8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl8(MainTabActivity mainTabActivity, dk8 dk8Var) {
        super(2007002);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, dk8Var};
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
        this.b = dk8Var;
        setPriority(100);
    }

    public final void a(Intent intent) {
        dk8 dk8Var;
        int a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null || (dk8Var = this.b) == null || dk8Var.z() == null) {
            return;
        }
        try {
            if (intent.hasExtra("locate_type")) {
                a = intent.getIntExtra("locate_type", 1);
            } else {
                a = this.a.p.a();
            }
            this.b.z().setCurrentTabByType(a);
        } catch (Throwable th) {
            BdLog.e(th);
            this.a.finish();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList<n45> b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null || (b = ((p45) customResponsedMessage.getData()).b()) == null || b.size() == 0) {
            return;
        }
        this.b.A(b);
        MainTabActivity mainTabActivity = this.a;
        if (mainTabActivity.c) {
            if (mainTabActivity.b != 23) {
                dk8 dk8Var = this.b;
                if (dk8Var != null && dk8Var.z() != null) {
                    this.b.z().setCurrentTabByType(this.a.b);
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
            dk8 dk8Var2 = this.b;
            if (dk8Var2 != null && dk8Var2.z() != null) {
                if (this.a.getIntent() != null && this.a.getIntent().getDataString() != null && this.a.getIntent().getDataString().startsWith(UrlSchemaHelper.SCHEMA_TYPE_DEEPLINK_TOPIC)) {
                    this.b.z().setCurrentTabByType(2);
                } else {
                    a(this.a.getIntent());
                }
            }
        }
        this.a.c = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921567, null));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921579, 0));
    }
}
