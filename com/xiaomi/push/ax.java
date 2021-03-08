package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    public int f8265a;

    /* renamed from: a  reason: collision with other field name */
    public String f115a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f116a = new HashMap();

    public String a() {
        return this.f115a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f8265a), this.f116a.toString(), this.f115a);
    }
}
