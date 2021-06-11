package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.UserCouponStore;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetUserCouponStoreResponse implements IBaseJsonResponse {
    public int appId;
    public boolean hasMore;
    public String message;
    public int result;
    public String seq;
    public long serverCurrentTime;
    public long uid;
    public int cmd = RevenueServerConst.GetUserCouponStoreResponse;
    public List<UserCouponStore> userCouponStoreList = new ArrayList();

    public GetUserCouponStoreResponse(String str) {
        parserResponse(str);
    }

    private List<UserCouponStore> optUserCouponStore(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                UserCouponStore userCouponStore = new UserCouponStore();
                userCouponStore.id = optJSONObject.optInt("id");
                userCouponStore.uid = optJSONObject.optLong("uid");
                userCouponStore.appid = optJSONObject.optInt("appid");
                userCouponStore.acquireTime = optJSONObject.optLong("acquireTime");
                userCouponStore.validStartTime = optJSONObject.optLong("validStartTime");
                userCouponStore.validEndTime = optJSONObject.optLong("validEndTime");
                userCouponStore.lockReleaseTime = optJSONObject.optLong("lockReleaseTime");
                userCouponStore.status = optJSONObject.optInt("status");
                userCouponStore.couponId = optJSONObject.optInt("couponId");
                userCouponStore.couponType = optJSONObject.optInt("couponType");
                userCouponStore.couponName = optJSONObject.optString("couponName");
                userCouponStore.couponLimitAmount = optJSONObject.optDouble("couponLimitAmount");
                userCouponStore.couponAmount = optJSONObject.optDouble("couponAmount");
                userCouponStore.couponUseWay = optJSONObject.optInt("couponUseWay");
                userCouponStore.couponUseWayInfo = optJSONObject.optString("couponUseWayInfo");
                userCouponStore.srcType = optJSONObject.optInt("srcType");
                userCouponStore.humanId = optJSONObject.optString("humanId");
                arrayList.add(userCouponStore);
            }
        }
        return arrayList;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        if (str != null && !"".equals(str.trim())) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.cmd == optInt) {
                    this.uid = jSONObject.optLong("uid");
                    this.seq = jSONObject.optString(IAdRequestParam.SEQ);
                    this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    this.result = jSONObject.optInt("result");
                    this.message = jSONObject.optString("message");
                    this.serverCurrentTime = jSONObject.optLong("serverCurrentTime");
                    this.userCouponStoreList.addAll(optUserCouponStore(jSONObject.optJSONArray("userCouponList")));
                    this.hasMore = jSONObject.optBoolean("hasMore");
                    return;
                }
                throw new Exception(this.cmd + " != " + optInt);
            } catch (JSONException e2) {
                RLog.error("GetUserAccountHistoryResponse", "parserResponse error.", e2);
                return;
            } catch (Exception e3) {
                RLog.error("GetUserAccountHistoryResponse", "parserResponse error.", e3);
                return;
            }
        }
        RLog.error("GetUserCouponStoreResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
    }
}
