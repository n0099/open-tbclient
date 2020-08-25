package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes7.dex */
class z {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f90a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            if (!TextUtils.isEmpty(zVar.f90a) && zVar.f90a.equals(this.f90a)) {
                return true;
            }
        }
        return false;
    }
}
