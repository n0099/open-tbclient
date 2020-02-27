package com.meizu.cloud.pushsdk.platform.message;

import android.text.TextUtils;
import com.meizu.cloud.a.a;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class BasicPushStatus implements Serializable {
    public static final String SUCCESS_CODE = "200";
    public static final String TAG = "BasicPushStatus";
    public String code;
    public String message;

    public BasicPushStatus() {
    }

    public BasicPushStatus(String str) {
        JSONObject parse = parse(str);
        if (parse == null || !SUCCESS_CODE.equals(this.code) || parse.isNull("value")) {
            return;
        }
        try {
            parseValueData(parse.getJSONObject("value"));
        } catch (JSONException e) {
            a.e(TAG, "parse value data error " + e.getMessage() + " json " + str);
        }
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    protected JSONObject parse(String str) {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                try {
                    if (!jSONObject.isNull("code")) {
                        setCode(jSONObject.getString("code"));
                    }
                    if (jSONObject.isNull("message")) {
                        return jSONObject;
                    }
                    setMessage(jSONObject.getString("message"));
                    return jSONObject;
                } catch (JSONException e2) {
                    e = e2;
                    a.e(TAG, "covert json error " + e.getMessage());
                    return jSONObject;
                }
            }
            return jSONObject;
        } catch (JSONException e3) {
            jSONObject = null;
            e = e3;
        }
    }

    public abstract void parseValueData(JSONObject jSONObject) throws JSONException;

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "BasicPushStatus{code='" + this.code + "', message='" + this.message + "'}";
    }
}
