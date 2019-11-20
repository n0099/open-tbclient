package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes3.dex */
class ab {
    int a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f32a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ab)) {
            ab abVar = (ab) obj;
            if (!TextUtils.isEmpty(abVar.f32a) && abVar.f32a.equals(this.f32a)) {
                return true;
            }
        }
        return false;
    }
}
