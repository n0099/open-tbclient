package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {
    public static String a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f58939b;

    /* renamed from: c  reason: collision with root package name */
    public String f58940c;

    /* renamed from: d  reason: collision with root package name */
    public String f58941d;

    /* renamed from: e  reason: collision with root package name */
    public int f58942e;

    /* renamed from: f  reason: collision with root package name */
    public String f58943f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f58944g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f58945h;

    /* renamed from: i  reason: collision with root package name */
    public long f58946i;

    /* renamed from: j  reason: collision with root package name */
    public long f58947j;
    public Context k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f58940c = null;
        this.f58942e = 0;
        this.f58946i = timeUnit.toMillis(j2);
        this.f58947j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f58939b = obj;
                this.f58942e = intValue;
                this.f58940c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
        }
        this.f58939b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f58941d = this.f58940c;
        this.f58940c = e.b();
        this.f58942e++;
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session ID: %s", this.f58940c);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Previous Session ID: %s", this.f58941d);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session Index: %s", Integer.valueOf(this.f58942e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f58945h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f58945h, System.currentTimeMillis(), this.f58944g.get() ? this.f58947j : this.f58946i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f58939b);
        hashMap.put("sessionId", this.f58940c);
        hashMap.put("previousSessionId", this.f58941d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f58942e));
        hashMap.put("storageMechanism", this.f58943f);
        return hashMap;
    }
}
