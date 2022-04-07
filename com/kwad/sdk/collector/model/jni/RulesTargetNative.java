package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.d;
import com.kwad.sdk.crash.a;
import com.kwad.sdk.utils.t;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
@Keep
/* loaded from: classes5.dex */
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
    public void parseJson(@Nullable JSONObject jSONObject) {
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
            a.a(e);
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "packageName", AppStatusNative.rulesTargetGetPackageName(this));
        t.a(jSONObject, "paths", Arrays.asList(AppStatusNative.rulesTargetGetPaths(this)));
        return jSONObject;
    }
}
