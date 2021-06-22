package d.a.o0.r1.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.account.utils.SocialEncodeUtils;
import com.baidu.searchbox.live.interfaces.data.UserAccount;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class b implements AccountManagerService {

    /* renamed from: a  reason: collision with root package name */
    public AccountManagerService.AccountStatusChangedListener f63696a;

    /* renamed from: b  reason: collision with root package name */
    public AccountManagerService.LoginResultListener f63697b;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            if (b.this.f63697b != null) {
                b.this.f63697b.onResult(b.this.isLogin(2) ? 0 : -2);
            }
            if (b.this.f63696a != null) {
                b.this.f63696a.onAccountStatusChanged(false);
            }
        }
    }

    public b() {
        MessageManager.getInstance().registerListener(new a(2005016));
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public void addLoginStatusChangedListener(AccountManagerService.AccountStatusChangedListener accountStatusChangedListener) {
        this.f63696a = accountStatusChangedListener;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public UserAccount getAccount() {
        UserAccount userAccount = new UserAccount();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            userAccount.setDisplayname(currentAccountInfo.getAccountNameShow());
            userAccount.setBduss(currentAccountInfo.getBDUSS());
            userAccount.setUid(currentAccountInfo.getID());
            userAccount.setProtrait(TbConfig.getBigPhotoAdress() + currentAccountInfo.getPortrait());
            userAccount.setNickName(currentAccountInfo.getAccountNameShow());
            userAccount.setUk(getSocialEncryption(currentAccountInfo.getID(), "baiduuid_"));
        }
        return userAccount;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public String getSocialDecrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return SocialEncodeUtils.getSocialDecrypt(str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public String getSocialEncryption(String str, String str2) {
        String str3 = "";
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            str3 = SocialEncodeUtils.getSocialEncryption(str, str2);
            return URLEncoder.encode(str3, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str3;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public String getUid() {
        UserAccount account = getAccount();
        return account != null ? account.getUid() : "";
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public boolean isLogin(int i2) {
        return TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public void login(Context context, AccountManagerService.LoginResultListener loginResultListener) {
        this.f63697b = loginResultListener;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AccountManagerService
    public void removeLoginStatusChangedListener(AccountManagerService.AccountStatusChangedListener accountStatusChangedListener) {
        this.f63696a = null;
    }
}
