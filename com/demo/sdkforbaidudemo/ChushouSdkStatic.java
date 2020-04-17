package com.demo.sdkforbaidudemo;

import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.kascend.cstvsdk.CSTVSdk;
/* loaded from: classes5.dex */
public class ChushouSdkStatic {
    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.demo.sdkforbaidudemo.ChushouSdkStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (CSTVSdk.INSTANCE.getInitialized()) {
                    if (TbadkCoreApplication.isLogin()) {
                        CSTVSdk.INSTANCE.onLoginStatusChanged(1);
                    } else {
                        CSTVSdk.INSTANCE.onLoginStatusChanged(2);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.demo.sdkforbaidudemo.ChushouSdkStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData) && CSTVSdk.INSTANCE.getInitialized()) {
                    CSTVSdk.INSTANCE.onLoginStatusChanged(2);
                }
            }
        });
        ba.aOY().a(new ba.a() { // from class: com.demo.sdkforbaidudemo.ChushouSdkStatic.3
            @Override // com.baidu.tbadk.core.util.ba.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null) {
                    return 3;
                }
                if (strArr[0].startsWith("tiebachushou://liveroom") || strArr[0].startsWith("https://chushou.tv") || strArr[0].startsWith("https://vchushou.com")) {
                    if ((b.aNV().getInt("chushou_game_tab", 1) == 1) && CSTVSdk.INSTANCE != null && !CSTVSdk.INSTANCE.getInitialized()) {
                        ChushouSdkInit.testInit(TbadkCoreApplication.getInst());
                    }
                    if (strArr[0].startsWith("tiebachushou://liveroom")) {
                        try {
                            Uri parse = Uri.parse(strArr[0]);
                            ChushouSdkInit.testStartLiveRoom(tbPageContext.getPageActivity(), parse.getQueryParameter(LogConfig.LOG_ROOMID), parse.getQueryParameter("livetype"));
                            return 1;
                        } catch (Exception e) {
                            return 3;
                        }
                    } else if (strArr[0].startsWith("https://chushou.tv") || strArr[0].startsWith("https://vchushou.com")) {
                        CSTVSdk.INSTANCE.startH5(tbPageContext.getPageActivity(), strArr[0]);
                        return 1;
                    } else {
                        return 3;
                    }
                }
                return 3;
            }
        });
    }
}
