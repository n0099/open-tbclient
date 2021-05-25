package d.a.n0.r1.s;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.searchbox.live.interfaces.service.ShareService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ShareService {

    /* renamed from: a  reason: collision with root package name */
    public ShareService.IOnSocialListener f59926a = null;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f59927b = new a(2921550);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Integer)) {
                return;
            }
            Integer num = (Integer) customResponsedMessage.getData();
            if (d.this.f59926a != null) {
                if (num.intValue() == 1) {
                    d.this.f59926a.onComplete("");
                } else if (num.intValue() == 2) {
                    d.this.f59926a.onError("");
                } else if (num.intValue() == 3) {
                    d.this.f59926a.onCancel("");
                }
                d.this.f59926a = null;
            }
            MessageManager.getInstance().unRegisterListener(d.this.f59927b);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public boolean canShareInLandScreen() {
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public void clean() {
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public boolean isShowing() {
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public void startShare(Context context, View view, String str, String str2, String str3, String str4, String str5, ShareService.IOnSocialListener iOnSocialListener) {
        ShareItem shareItem = new ShareItem();
        shareItem.r = str;
        shareItem.s = str2;
        shareItem.w = str4;
        shareItem.t = str3;
        try {
            JSONObject jSONObject = new JSONObject(str5);
            String optString = jSONObject.optString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID);
            if (TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("liveId");
                String optString3 = jSONObject.optString("userId");
                shareItem.q = optString2;
                shareItem.k0 = optString3;
            } else {
                if (jSONObject.optInt("yy_show_tieba_entrance", 1) == 1) {
                    shareItem.z = optString;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f59926a = iOnSocialListener;
        MessageManager.getInstance().registerListener(this.f59927b);
        if (context == null) {
            context = TbadkCoreApplication.getInst();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaSDKShareEmptyActivityConfig(context, shareItem, 0, 1)));
    }
}
