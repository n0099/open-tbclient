package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes8.dex */
class ab {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f33a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ab)) {
            ab abVar = (ab) obj;
            if (!TextUtils.isEmpty(abVar.f33a) && abVar.f33a.equals(this.f33a)) {
                return true;
            }
        }
        return false;
    }
}
