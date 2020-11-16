package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    public int f4802a;

    /* renamed from: a  reason: collision with other field name */
    public String f118a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f119a = new HashMap();

    public String a() {
        return this.f118a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f4802a), this.f119a.toString(), this.f118a);
    }
}
