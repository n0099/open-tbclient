package com.coloros.mcssdk.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends c {
    public static final String hXb = null;
    private int adY;
    private String content;
    private String hXc;
    private String hXd;
    private String hXe;
    private String hXf;
    private String params;
    private int responseCode = -2;

    public static List<e> q(String str, String str2, String str3, String str4) {
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
                    eVar.vs(jSONObject.getString(str3));
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

    public int kI() {
        return this.adY;
    }

    public void setAppKey(String str) {
        this.hXc = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "type:4105,messageID:" + this.hXg + ",taskID:" + this.hXh + ",appPackage:" + this.appPackage + ",appKey:" + this.hXc + ",appSecret:" + this.hXd + ",registerID:" + this.hXe + ",sdkVersion:" + this.hXf + ",command:" + this.adY + ",params:" + this.params + ",responseCode:" + this.responseCode + ",content:" + this.content;
    }

    public void vo(String str) {
        this.hXd = str;
    }

    public void zs(int i) {
        this.adY = i;
    }

    public void zt(int i) {
        this.responseCode = i;
    }
}
