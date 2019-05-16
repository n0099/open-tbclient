package com.xiaomi.push.service.awake.module;

import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes3.dex */
public enum e {
    ACTIVITY(PushConstants.INTENT_ACTIVITY_NAME),
    SERVICE_ACTION("service_action"),
    SERVICE_COMPONENT("service_component"),
    PROVIDER("provider");
    
    public String e;

    e(String str) {
        this.e = str;
    }
}
