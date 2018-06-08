package com.coloros.mcssdk.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c {
    public static final String hzj = null;
    private String content;
    private String hzk;
    private String hzl;
    private String hzm;
    private String hzn;
    private String params;
    private int responseCode = -2;
    private int uI;

    public static List<e> r(String str, String str2, String str3, String str4) {
        ArrayList arrayList;
        JSONException e;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(str2);
            arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    e eVar = new e();
                    eVar.setContent(jSONObject.getString(str4));
                    eVar.wA(jSONObject.getString(str3));
                    arrayList.add(eVar);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    com.coloros.mcssdk.c.c.a("parseToSubscribeResultList--" + arrayList);
                    return arrayList;
                }
            }
        } catch (JSONException e3) {
            arrayList = null;
            e = e3;
        }
        com.coloros.mcssdk.c.c.a("parseToSubscribeResultList--" + arrayList);
        return arrayList;
    }

    public int fB() {
        return this.uI;
    }

    public String getContent() {
        return this.content;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    @Override // com.coloros.mcssdk.e.c
    public int getType() {
        return 4105;
    }

    public void setAppKey(String str) {
        this.hzk = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "type:4105,messageID:" + this.hzo + ",taskID:" + this.hzp + ",appPackage:" + this.appPackage + ",appKey:" + this.hzk + ",appSecret:" + this.hzl + ",registerID:" + this.hzm + ",sdkVersion:" + this.hzn + ",command:" + this.uI + ",params:" + this.params + ",responseCode:" + this.responseCode + ",content:" + this.content;
    }

    public void vM(int i) {
        this.uI = i;
    }

    public void vN(int i) {
        this.responseCode = i;
    }

    public void ww(String str) {
        this.hzl = str;
    }
}
