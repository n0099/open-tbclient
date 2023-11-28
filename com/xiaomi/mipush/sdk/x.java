package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class x {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f86a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return !TextUtils.isEmpty(xVar.f86a) && xVar.f86a.equals(this.f86a);
    }
}
