package d.r.b.a.a.j.d.e;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.payapi.request.QueryRechargeHistoryReqParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class x implements d.r.b.a.a.j.d.f.b {

    /* renamed from: a  reason: collision with root package name */
    public QueryRechargeHistoryReqParams f68058a;

    public x(QueryRechargeHistoryReqParams queryRechargeHistoryReqParams) {
        this.f68058a = queryRechargeHistoryReqParams;
    }

    @Override // d.r.b.a.a.j.d.f.b
    public String getProtocol() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cmd", 1054);
        jSONObject.put("uid", this.f68058a.getUid());
        jSONObject.put("usedChannel", this.f68058a.getUsedChannel());
        jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f68058a.getAppId());
        jSONObject.put(IAdRequestParam.SEQ, this.f68058a.getSeq());
        jSONObject.put("status", this.f68058a.getStatus());
        jSONObject.put("pagesize", this.f68058a.getPagesize());
        jSONObject.put("page", this.f68058a.getPage());
        jSONObject.put("startTime", this.f68058a.getStartTime());
        jSONObject.put("endTime", this.f68058a.getEndTime());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jMsg.toString()");
        return jSONObject2;
    }
}
