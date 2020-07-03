package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes8.dex */
class z {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f93a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            if (!TextUtils.isEmpty(zVar.f93a) && zVar.f93a.equals(this.f93a)) {
                return true;
            }
        }
        return false;
    }
}
