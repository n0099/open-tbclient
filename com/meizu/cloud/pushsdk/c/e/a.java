package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f40407a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f40408b;

    /* renamed from: c  reason: collision with root package name */
    public String f40409c;

    /* renamed from: d  reason: collision with root package name */
    public String f40410d;

    /* renamed from: e  reason: collision with root package name */
    public int f40411e;

    /* renamed from: f  reason: collision with root package name */
    public String f40412f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f40413g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f40414h;

    /* renamed from: i  reason: collision with root package name */
    public long f40415i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f40409c = null;
        this.f40411e = 0;
        this.f40415i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f40408b = obj;
                this.f40411e = intValue;
                this.f40409c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f40407a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f40407a, "Tracker Session Object created.", new Object[0]);
        }
        this.f40408b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f40407a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f40410d = this.f40409c;
        this.f40409c = e.b();
        this.f40411e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f40407a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f40407a, " + Session ID: %s", this.f40409c);
        com.meizu.cloud.pushsdk.c.f.c.b(f40407a, " + Previous Session ID: %s", this.f40410d);
        com.meizu.cloud.pushsdk.c.f.c.b(f40407a, " + Session Index: %s", Integer.valueOf(this.f40411e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f40414h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f40407a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f40407a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f40414h, System.currentTimeMillis(), this.f40413g.get() ? this.j : this.f40415i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f40408b);
        hashMap.put("sessionId", this.f40409c);
        hashMap.put("previousSessionId", this.f40410d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f40411e));
        hashMap.put("storageMechanism", this.f40412f);
        return hashMap;
    }
}
