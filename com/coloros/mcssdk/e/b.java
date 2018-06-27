package com.coloros.mcssdk.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c {
    public static final String hDq = null;
    private String content;
    private String hDr;
    private String hDs;
    private String hDt;
    private String hDu;
    private String params;
    private int responseCode = -2;
    private int uG;

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
                    eVar.wx(jSONObject.getString(str3));
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
        return this.uG;
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
        this.hDr = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "type:4105,messageID:" + this.hDv + ",taskID:" + this.hDw + ",appPackage:" + this.appPackage + ",appKey:" + this.hDr + ",appSecret:" + this.hDs + ",registerID:" + this.hDt + ",sdkVersion:" + this.hDu + ",command:" + this.uG + ",params:" + this.params + ",responseCode:" + this.responseCode + ",content:" + this.content;
    }

    public void vV(int i) {
        this.uG = i;
    }

    public void vW(int i) {
        this.responseCode = i;
    }

    public void ws(String str) {
        this.hDs = str;
    }
}
