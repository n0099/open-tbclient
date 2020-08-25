package com.demo.sdkforbaidudemo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.util.bg;
import com.kascend.cstvsdk.bean.LoginParam;
import com.kascend.cstvsdk.bean.LoginResp;
import com.kascend.cstvsdk.bean.ShareParam;
import com.kascend.cstvsdk.interfaces.Callback;
import com.kascend.cstvsdk.interfaces.ShareListener;
import com.kascend.cstvsdk.interfaces.ThirdParty;
import tv.chushou.common.player.a;
import tv.chushou.sdk.tieba.player.TiebaPlayer;
/* loaded from: classes6.dex */
public class ChushouSdkThirdParty implements ThirdParty {
    private final CustomMessageListener RechargeSucceedListener = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.demo.sdkforbaidudemo.ChushouSdkThirdParty.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };

    @Override // com.kascend.cstvsdk.interfaces.ThirdParty
    public a createPlayer() {
        return new TiebaPlayer();
    }

    @Override // com.kascend.cstvsdk.interfaces.ThirdParty
    public boolean isLogined() {
        return TbadkCoreApplication.isLogin();
    }

    @Override // com.kascend.cstvsdk.interfaces.ThirdParty
    public void jumpToLogin(Context context, LoginParam loginParam, Callback<LoginResp> callback) {
        if (!isLogined()) {
            gotoLogin(context);
        }
    }

    @Override // com.kascend.cstvsdk.interfaces.ThirdParty
    public void jumpToRecharge(Context context, Callback<Object> callback) {
        if (isLogined()) {
            gotoRecharge(context);
        }
    }

    @Override // com.kascend.cstvsdk.interfaces.ThirdParty
    public void onEnterLiveRoom(Activity activity) {
    }

    @Override // com.kascend.cstvsdk.interfaces.ThirdParty
    public void onExitLiveRoom(Activity activity) {
    }

    @Override // com.kascend.cstvsdk.interfaces.ThirdParty
    public void share(Context context, ShareParam shareParam, ShareListener shareListener) {
    }

    @Override // tv.chushou.basis.d.a
    public void init(Application application) {
    }

    public void destroy() {
    }

    private void gotoRecharge(Context context) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(context, 0L)));
    }

    private void gotoLogin(Context context) {
        bg.skipToLoginActivity(context);
    }
}
