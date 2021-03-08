package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes5.dex */
class z {

    /* renamed from: a  reason: collision with root package name */
    int f8247a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f88a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            if (!TextUtils.isEmpty(zVar.f88a) && zVar.f88a.equals(this.f88a)) {
                return true;
            }
        }
        return false;
    }
}
