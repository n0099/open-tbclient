package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes3.dex */
class ad {
    int a = 0;
    String b = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ad)) {
            ad adVar = (ad) obj;
            if (!TextUtils.isEmpty(adVar.b) && adVar.b.equals(this.b)) {
                return true;
            }
        }
        return false;
    }
}
