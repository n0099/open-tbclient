package d.b.i0.q1.q;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.searchbox.live.interfaces.service.ShareService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements ShareService {
    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public boolean canShareInLandScreen() {
        return false;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ShareService
    public void clean() {
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
            String optString = jSONObject.optString("liveId");
            String optString2 = jSONObject.optString("userId");
            shareItem.q = optString;
            shareItem.i0 = optString2;
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (context == null) {
            context = TbadkCoreApplication.getInst();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaSDKShareEmptyActivityConfig(context, shareItem, 0, 1)));
    }
}
