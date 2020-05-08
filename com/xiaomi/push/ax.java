package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ax {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public String f114a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f115a = new HashMap();

    public String a() {
        return this.f114a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.f115a.toString(), this.f114a);
    }
}
