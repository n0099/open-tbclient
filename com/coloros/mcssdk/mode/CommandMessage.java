package com.coloros.mcssdk.mode;

import android.text.TextUtils;
import com.coloros.mcssdk.c.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommandMessage extends Message {
    public static final String APP_KEY = "appKey";
    public static final String APP_SECRET = "appSecret";
    public static final String CODE = "code";
    public static final String COMMAND = "command";
    public static final int COMMAND_BASE = 12288;
    public static final int COMMAND_CLEAR_ALL_NOTIFICATION = 12305;
    public static final int COMMAND_CLEAR_NOTIFICATION = 12304;
    public static final int COMMAND_CLEAR_NOTIFICATION_TYPE = 12308;
    public static final int COMMAND_GET_ACCOUNTS = 12302;
    public static final int COMMAND_GET_ALIAS = 12293;
    public static final int COMMAND_GET_NOTIFICATION_STATUS = 12309;
    public static final int COMMAND_GET_PUSH_STATUS = 12306;
    public static final int COMMAND_GET_TAGS = 12296;
    public static final int COMMAND_PAUSE_PUSH = 12299;
    public static final int COMMAND_REGISTER = 12289;
    public static final int COMMAND_RESUME_PUSH = 12300;
    public static final int COMMAND_SET_ACCOUNTS = 12301;
    public static final int COMMAND_SET_ALIAS = 12292;
    public static final int COMMAND_SET_NOTIFICATION_SETTINGS = 12310;
    public static final int COMMAND_SET_NOTIFICATION_TYPE = 12307;
    public static final int COMMAND_SET_PUSH_TIME = 12298;
    public static final int COMMAND_SET_TAGS = 12295;
    public static final int COMMAND_STATISTIC = 12291;
    public static final int COMMAND_UNREGISTER = 12290;
    public static final int COMMAND_UNSET_ACCOUNTS = 12303;
    public static final int COMMAND_UNSET_ALIAS = 12294;
    public static final int COMMAND_UNSET_TAGS = 12297;
    public static final String PARAMS = "params";
    public static final String REGISTER_ID = "registerID";
    public static final String SDK_VERSION = "sdkVersion";
    private static final String SPLITER = "&";
    public static final String TYPE_ALIAS = "alias";
    public static final String TYPE_NULL = null;
    public static final String TYPE_TAGS = "tags";
    private String appKey;
    private String appSecret;
    private int command;
    private String content;
    private String params;
    private String registerID;
    private int responseCode = -2;
    private String sdkVersion;

    public static List<String> parseToList(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(SPLITER)) == null || split.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            if (!TextUtils.isEmpty(split[i])) {
                arrayList.add(split[i]);
            }
        }
        return arrayList;
    }

    public static <T> String parseToString(List<T> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next() + SPLITER);
        }
        return sb.toString();
    }

    public static List<SubscribeResult> parseToSubscribeResultList(String str, String str2, String str3, String str4) {
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
                    SubscribeResult subscribeResult = new SubscribeResult();
                    subscribeResult.setContent(jSONObject.getString(str4));
                    subscribeResult.setSubscribeId(jSONObject.getString(str3));
                    arrayList.add(subscribeResult);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    d.a("parseToSubscribeResultList--" + arrayList);
                    return arrayList;
                }
            }
        } catch (JSONException e3) {
            arrayList = null;
            e = e3;
        }
        d.a("parseToSubscribeResultList--" + arrayList);
        return arrayList;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public int getCommand() {
        return this.command;
    }

    public String getContent() {
        return this.content;
    }

    public String getParams() {
        return this.params;
    }

    public String getRegisterID() {
        return this.registerID;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    @Override // com.coloros.mcssdk.mode.Message
    public int getType() {
        return 4105;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setAppSecret(String str) {
        this.appSecret = str;
    }

    public void setCommand(int i) {
        this.command = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setRegisterID(String str) {
        this.registerID = str;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }

    public String toString() {
        return "type:4105,messageID:" + this.messageID + ",taskID:" + this.taskID + ",appPackage:" + this.appPackage + ",appKey:" + this.appKey + ",appSecret:" + this.appSecret + ",registerID:" + this.registerID + ",sdkVersion:" + this.sdkVersion + ",command:" + this.command + ",params:" + this.params + ",responseCode:" + this.responseCode + ",content:" + this.content;
    }
}
