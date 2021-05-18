package com.xiaomi.mipush.sdk;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public int f37354a = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f95a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return !TextUtils.isEmpty(wVar.f95a) && wVar.f95a.equals(this.f95a);
    }
}
