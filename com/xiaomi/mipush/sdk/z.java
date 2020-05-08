package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes8.dex */
class z {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f87a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            if (!TextUtils.isEmpty(zVar.f87a) && zVar.f87a.equals(this.f87a)) {
                return true;
            }
        }
        return false;
    }
}
