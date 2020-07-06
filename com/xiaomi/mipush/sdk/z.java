package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes8.dex */
class z {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f94a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            if (!TextUtils.isEmpty(zVar.f94a) && zVar.f94a.equals(this.f94a)) {
                return true;
            }
        }
        return false;
    }
}
