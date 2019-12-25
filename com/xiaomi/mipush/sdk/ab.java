package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes5.dex */
class ab {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f37a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ab)) {
            ab abVar = (ab) obj;
            if (!TextUtils.isEmpty(abVar.f37a) && abVar.f37a.equals(this.f37a)) {
                return true;
            }
        }
        return false;
    }
}
