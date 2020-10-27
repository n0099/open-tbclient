package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes12.dex */
class z {

    /* renamed from: a  reason: collision with root package name */
    int f4782a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f86a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            if (!TextUtils.isEmpty(zVar.f86a) && zVar.f86a.equals(this.f86a)) {
                return true;
            }
        }
        return false;
    }
}
