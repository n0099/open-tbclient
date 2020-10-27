package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    public int f4800a;

    /* renamed from: a  reason: collision with other field name */
    public String f113a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f114a = new HashMap();

    public String a() {
        return this.f113a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f4800a), this.f114a.toString(), this.f113a);
    }
}
