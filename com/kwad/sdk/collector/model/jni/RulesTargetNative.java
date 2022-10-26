package com.kwad.sdk.collector.model.jni;

import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.d;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.service.a;
import com.kwad.sdk.utils.r;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class RulesTargetNative extends NativeObject implements d {
    public static final long serialVersionUID = -4726982809581153390L;

    public RulesTargetNative() {
        this.mPtr = AppStatusNative.nativeCreateRulesTarget();
    }

    public RulesTargetNative(long j) {
        this.mPtr = j;
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            AppStatusNative.nativeDeleteRulesTarget(j);
            this.mPtr = 0L;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            AppStatusNative.rulesTargetSetPackageName(this, jSONObject.optString("packageName"));
            JSONArray optJSONArray = jSONObject.optJSONArray("paths");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = optJSONArray.getString(i);
                }
                AppStatusNative.rulesTargetSetPaths(this, strArr);
            }
        } catch (Exception e) {
            a.gatherException(e);
            b.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "packageName", AppStatusNative.rulesTargetGetPackageName(this));
        r.putValue(jSONObject, "paths", Arrays.asList(AppStatusNative.rulesTargetGetPaths(this)));
        return jSONObject;
    }
}
