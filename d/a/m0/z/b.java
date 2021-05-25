package d.a.m0.z;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.getUserInfo.GetUserInfoHttpResponseMessage;
import com.baidu.tbadk.getUserInfo.GetUserInfoRequstData;
import com.baidu.tbadk.getUserInfo.GetUserInfoSocketResponseMessage;
import d.a.c.e.m.h;
import d.a.c.e.p.l;
import d.a.m0.r.l.c;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f50973b;

    /* renamed from: a  reason: collision with root package name */
    public UserData f50974a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f50975e;

        public a(b bVar, AccountData accountData) {
            this.f50975e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.g(this.f50975e);
        }
    }

    public static b a() {
        if (f50973b == null) {
            synchronized (b.class) {
                if (f50973b == null) {
                    f50973b = new b();
                }
            }
        }
        return f50973b;
    }

    public UserData b() {
        return this.f50974a;
    }

    public void c() {
        d.a.n0.e3.d0.a.h(303024, GetUserInfoSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(303024, CmdConfigHttp.CMD_GET_USER_INFO, TbConfig.GET_USER_INFO, GetUserInfoHttpResponseMessage.class, false, false, false, false);
    }

    public void d() {
        GetUserInfoRequstData getUserInfoRequstData = new GetUserInfoRequstData(CmdConfigHttp.CMD_GET_USER_INFO, 303024);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            getUserInfoRequstData.setUid(d.a.c.e.m.b.f(currentAccountObj.getID(), 0L));
        }
        getUserInfoRequstData.setScreenWidth(l.k(TbadkCoreApplication.getInst().getApp()));
        MessageManager.getInstance().sendMessage(getUserInfoRequstData);
    }

    public void e(UserData userData) {
        this.f50974a = userData;
        if (userData == null) {
            return;
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = new AccountData();
        }
        if (!StringUtils.isNull(userData.getUserName())) {
            currentAccountObj.setAccount(userData.getUserName());
        }
        if (!StringUtils.isNull(userData.getPortrait())) {
            currentAccountObj.setPortrait(userData.getPortrait());
        }
        if (userData.getBaijiahaoInfo() != null && !StringUtils.isNull(userData.getBaijiahaoInfo().avatar)) {
            currentAccountObj.setBjhAvatar(userData.getBaijiahaoInfo().avatar);
        }
        currentAccountObj.setSex(userData.getSex());
        currentAccountObj.setMemberType(userData.getIsMem());
        currentAccountObj.setVipInfo(userData.getUserVipInfo());
        currentAccountObj.setPersonalBgUrl(userData.getBg_pic());
        if (userData.getGodUserData() != null) {
            currentAccountObj.setGodType(userData.getGodUserData().getType());
        }
        if (userData.getNewGodData() != null) {
            currentAccountObj.setNewGodStatus(userData.getNewGodData().getStatus());
        }
        if (!TextUtils.isEmpty(userData.getUk())) {
            currentAccountObj.setUk(userData.getUk());
        }
        currentAccountObj.setIsBigV(userData.isBigV());
        currentAccountObj.setNameShow(userData.getName_show());
        if (!StringUtils.isNull(userData.getBimg_url())) {
            TbadkCoreApplication.getInst().setDefaultBubble(userData.getBimg_url());
        }
        PayMemberInfoData payMemberInfoData = userData.getPayMemberInfoData();
        if (currentAccountObj.getVipInfo() != null) {
            currentAccountObj.setMemberIconUrl(currentAccountObj.getVipInfo().getVipIconUrl());
        } else {
            currentAccountObj.setMemberIconUrl(null);
        }
        CloseAdData closeAdData = userData.getCloseAdData();
        if (closeAdData != null) {
            currentAccountObj.setMemberCloseAdIsOpen(closeAdData.s());
            currentAccountObj.setMemberCloseAdVipClose(closeAdData.t());
        }
        currentAccountObj.setUserIcons(userData.getIconInfo());
        currentAccountObj.setIsSelectTail(userData.getIsSelectTail());
        h.a().c(new a(this, currentAccountObj));
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247, payMemberInfoData));
    }
}
