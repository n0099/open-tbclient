package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f67550a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f67551b;

    /* renamed from: c  reason: collision with root package name */
    public String f67552c;

    /* renamed from: d  reason: collision with root package name */
    public String f67553d;

    /* renamed from: e  reason: collision with root package name */
    public int f67554e;

    /* renamed from: f  reason: collision with root package name */
    public String f67555f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f67556g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f67557h;

    /* renamed from: i  reason: collision with root package name */
    public long f67558i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f67552c = null;
        this.f67554e = 0;
        this.f67558i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f67551b = obj;
                this.f67554e = intValue;
                this.f67552c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f67550a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f67550a, "Tracker Session Object created.", new Object[0]);
        }
        this.f67551b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f67550a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f67553d = this.f67552c;
        this.f67552c = e.b();
        this.f67554e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f67550a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f67550a, " + Session ID: %s", this.f67552c);
        com.meizu.cloud.pushsdk.c.f.c.b(f67550a, " + Previous Session ID: %s", this.f67553d);
        com.meizu.cloud.pushsdk.c.f.c.b(f67550a, " + Session Index: %s", Integer.valueOf(this.f67554e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f67557h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f67550a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f67550a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f67557h, System.currentTimeMillis(), this.f67556g.get() ? this.j : this.f67558i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f67551b);
        hashMap.put("sessionId", this.f67552c);
        hashMap.put("previousSessionId", this.f67553d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f67554e));
        hashMap.put("storageMechanism", this.f67555f);
        return hashMap;
    }
}
