package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes18.dex */
class z {

    /* renamed from: a  reason: collision with root package name */
    int f4784a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f91a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            if (!TextUtils.isEmpty(zVar.f91a) && zVar.f91a.equals(this.f91a)) {
                return true;
            }
        }
        return false;
    }
}
