package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    public int f14167a;

    /* renamed from: a  reason: collision with other field name */
    public String f194a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f195a = new HashMap();

    public String a() {
        return this.f194a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f14167a), this.f195a.toString(), this.f194a);
    }
}
