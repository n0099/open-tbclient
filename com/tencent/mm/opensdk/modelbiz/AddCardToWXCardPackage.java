package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;
/* loaded from: classes6.dex */
public class AddCardToWXCardPackage {
    public static final String TAG = "MicroMsg.AddCardToWXCardPackage";

    /* loaded from: classes6.dex */
    public static class Req extends BaseReq {
        public List<WXCardItem> cardArrary;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            String str2;
            List<WXCardItem> list = this.cardArrary;
            if (list == null || list.size() == 0 || this.cardArrary.size() > 40) {
                return false;
            }
            for (WXCardItem wXCardItem : this.cardArrary) {
                if (wXCardItem == null || (str = wXCardItem.cardId) == null || str.length() > 1024 || ((str2 = wXCardItem.cardExtMsg) != null && str2.length() > 1024)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 9;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key(PersonalCardDetailActivityConfig.CARD_ID);
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Exception e2) {
                Log.e(AddCardToWXCardPackage.TAG, "Req.toBundle exception:" + e2.getMessage());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }
    }

    /* loaded from: classes6.dex */
    public static class Resp extends BaseResp {
        public List<WXCardItem> cardArrary;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            List<WXCardItem> list = this.cardArrary;
            return (list == null || list.size() == 0) ? false : true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            if (this.cardArrary == null) {
                this.cardArrary = new LinkedList();
            }
            String string = bundle.getString("_wxapi_add_card_to_wx_card_list");
            if (string == null || string.length() <= 0) {
                return;
            }
            try {
                JSONArray jSONArray = ((JSONObject) new JSONTokener(string).nextValue()).getJSONArray("card_list");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    WXCardItem wXCardItem = new WXCardItem();
                    wXCardItem.cardId = jSONObject.optString(PersonalCardDetailActivityConfig.CARD_ID);
                    wXCardItem.cardExtMsg = jSONObject.optString("card_ext");
                    wXCardItem.cardState = jSONObject.optInt("is_succ");
                    this.cardArrary.add(wXCardItem);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 9;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key(PersonalCardDetailActivityConfig.CARD_ID);
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                    jSONStringer.key("is_succ");
                    jSONStringer.value(wXCardItem.cardState);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Exception e2) {
                Log.e(AddCardToWXCardPackage.TAG, "Resp.toBundle exception:" + e2.getMessage());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
        }
    }

    /* loaded from: classes6.dex */
    public static final class WXCardItem {
        public String cardExtMsg;
        public String cardId;
        public int cardState;
    }
}
