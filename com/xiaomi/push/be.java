package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    public int f40276a;

    /* renamed from: a  reason: collision with other field name */
    public String f146a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f147a = new HashMap();

    public String a() {
        return this.f146a;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f40276a), this.f147a.toString(), this.f146a);
    }
}
