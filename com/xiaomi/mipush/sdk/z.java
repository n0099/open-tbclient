package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes6.dex */
class z {

    /* renamed from: a  reason: collision with root package name */
    int f14145a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f168a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            if (!TextUtils.isEmpty(zVar.f168a) && zVar.f168a.equals(this.f168a)) {
                return true;
            }
        }
        return false;
    }
}
