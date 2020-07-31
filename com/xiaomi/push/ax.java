package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class ax {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public String f117a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f118a = new HashMap();

    public String a() {
        return this.f117a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.a), this.f118a.toString(), this.f117a);
    }
}
