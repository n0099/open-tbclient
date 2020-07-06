package com.xiaomi.push;

import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes8.dex */
public enum es {
    ACTIVITY(PushConstants.INTENT_ACTIVITY_NAME),
    SERVICE_ACTION("service_action"),
    SERVICE_COMPONENT("service_component"),
    PROVIDER("provider");
    

    /* renamed from: a  reason: collision with other field name */
    public String f315a;

    es(String str) {
        this.f315a = str;
    }
}
