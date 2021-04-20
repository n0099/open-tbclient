package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes5.dex */
public enum w {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    public static w a(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.equals("protected", lowerCase)) {
            return PROTECTED;
        }
        if (TextUtils.equals(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, lowerCase)) {
            return PRIVATE;
        }
        return PUBLIC;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == PRIVATE ? PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE : this == PROTECTED ? "protected" : "public";
    }
}
