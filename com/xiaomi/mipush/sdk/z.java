package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes6.dex */
class z {

    /* renamed from: a  reason: collision with root package name */
    int f13847a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f167a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            if (!TextUtils.isEmpty(zVar.f167a) && zVar.f167a.equals(this.f167a)) {
                return true;
            }
        }
        return false;
    }
}
