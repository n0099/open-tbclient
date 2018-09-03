package com.coloros.mcssdk.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c {
    public static final String hDX = null;
    private String content;
    private String hDY;
    private String hDZ;
    private String hEa;
    private String hEb;
    private String params;
    private int responseCode = -2;
    private int uz;

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
                    eVar.wD(jSONObject.getString(str3));
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

    public int fA() {
        return this.uz;
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
        this.hDY = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String toString() {
        return "type:4105,messageID:" + this.hEc + ",taskID:" + this.hEd + ",appPackage:" + this.appPackage + ",appKey:" + this.hDY + ",appSecret:" + this.hDZ + ",registerID:" + this.hEa + ",sdkVersion:" + this.hEb + ",command:" + this.uz + ",params:" + this.params + ",responseCode:" + this.responseCode + ",content:" + this.content;
    }

    public void vS(int i) {
        this.uz = i;
    }

    public void vT(int i) {
        this.responseCode = i;
    }

    public void wy(String str) {
        this.hDZ = str;
    }
}
