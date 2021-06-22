package d.a.n0.t;

import org.json.JSONObject;
import tbclient.BusinessAccountInfo;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54557a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f54558b;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f54557a = jSONObject.optInt("is_business_account") == 1;
        this.f54558b = jSONObject.optInt("is_forum_business_account") == 1;
        jSONObject.optString("business_name");
        jSONObject.optString("identifi_explain");
    }

    public void b(BusinessAccountInfo businessAccountInfo) {
        if (businessAccountInfo == null) {
            return;
        }
        this.f54557a = businessAccountInfo.is_business_account.intValue() == 1;
        this.f54558b = businessAccountInfo.is_forum_business_account.intValue() == 1;
        String str = businessAccountInfo.business_name;
        String str2 = businessAccountInfo.identifi_explain;
    }
}
