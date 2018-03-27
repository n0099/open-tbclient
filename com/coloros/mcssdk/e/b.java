package com.coloros.mcssdk.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends c {
    public static final String hOO = null;
    private int adQ;
    private String content;
    private String hOP;
    private String hOQ;
    private String hOR;
    private String hOS;
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
                    eVar.va(jSONObject.getString(str3));
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
        return this.adQ;
    }

    public void setAppKey(String str) {
        this.hOP = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "type:4105,messageID:" + this.hOT + ",taskID:" + this.hOU + ",appPackage:" + this.appPackage + ",appKey:" + this.hOP + ",appSecret:" + this.hOQ + ",registerID:" + this.hOR + ",sdkVersion:" + this.hOS + ",command:" + this.adQ + ",params:" + this.params + ",responseCode:" + this.responseCode + ",content:" + this.content;
    }

    public void uW(String str) {
        this.hOQ = str;
    }

    public void xV(int i) {
        this.adQ = i;
    }

    public void xW(int i) {
        this.responseCode = i;
    }
}
