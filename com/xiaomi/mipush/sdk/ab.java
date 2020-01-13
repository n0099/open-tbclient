package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes6.dex */
class ab {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f35a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ab)) {
            ab abVar = (ab) obj;
            if (!TextUtils.isEmpty(abVar.f35a) && abVar.f35a.equals(this.f35a)) {
                return true;
            }
        }
        return false;
    }
}
