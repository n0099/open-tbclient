package d.a.i0.r.y.s;

import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import d.a.i0.r.y.l;
import d.a.i0.r.y.n;
import d.a.i0.r.y.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends n {

    /* renamed from: c  reason: collision with root package name */
    public l f49517c;

    public d(l lVar) {
        super(lVar);
        this.f49517c = lVar;
    }

    @Override // d.a.i0.r.y.n
    public String g() {
        return "TBHY_COMMON_SHOW_SHARE_DIALOG";
    }

    @o(isAsync = false, value = "showShareDialog")
    public void showShareDialog(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("content");
        String optString3 = jSONObject.optString("imgUrl");
        String optString4 = jSONObject.optString("shareUrl");
        ShareItem shareItem = new ShareItem();
        shareItem.r = optString;
        shareItem.s = optString2;
        if (optString3 == null) {
            shareItem.v = null;
        } else {
            shareItem.v = Uri.parse(optString3);
        }
        shareItem.t = optString4;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f49517c.f(), shareItem, true);
        shareDialogConfig.setIsSupportNightMode(true);
        shareDialogConfig.setIsCopyLink(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
