package com.qq.e.comm.plugin.m.a;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.util.o;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.qq.e.comm.plugin.ab.f.a.b {
    @Override // com.qq.e.comm.plugin.ab.f.a.b
    public String a() {
        return "getAppInfo";
    }

    @Override // com.qq.e.comm.plugin.ab.f.a.b
    public void a(e eVar, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkEdition", SDKStatus.getSDKVersion());
            jSONObject.put("appVersion", GDTADManager.getInstance().getAppStatus().getAPPVersion());
            jSONObject.put("netType", GDTADManager.getInstance().getDeviceStatus().getPhoneNet());
            jSONObject.put("appName", GDTADManager.getInstance().getAppStatus().getAPPRealName());
            jSONObject.put("supportList", new JSONArray((Collection) eVar.a()));
            jSONObject.put("muid", o.l());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", 0);
            jSONObject2.put("data", jSONObject);
            eVar.a(str3, 0, jSONObject2.toString(), 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
