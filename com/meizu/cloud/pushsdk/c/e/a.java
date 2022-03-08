package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class a {
    public static String a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f57289b;

    /* renamed from: c  reason: collision with root package name */
    public String f57290c;

    /* renamed from: d  reason: collision with root package name */
    public String f57291d;

    /* renamed from: e  reason: collision with root package name */
    public int f57292e;

    /* renamed from: f  reason: collision with root package name */
    public String f57293f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f57294g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f57295h;

    /* renamed from: i  reason: collision with root package name */
    public long f57296i;

    /* renamed from: j  reason: collision with root package name */
    public long f57297j;
    public Context k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f57290c = null;
        this.f57292e = 0;
        this.f57296i = timeUnit.toMillis(j2);
        this.f57297j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f57289b = obj;
                this.f57292e = intValue;
                this.f57290c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
        }
        this.f57289b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f57291d = this.f57290c;
        this.f57290c = e.b();
        this.f57292e++;
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session ID: %s", this.f57290c);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Previous Session ID: %s", this.f57291d);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session Index: %s", Integer.valueOf(this.f57292e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f57295h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f57295h, System.currentTimeMillis(), this.f57294g.get() ? this.f57297j : this.f57296i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f57289b);
        hashMap.put("sessionId", this.f57290c);
        hashMap.put("previousSessionId", this.f57291d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f57292e));
        hashMap.put("storageMechanism", this.f57293f);
        return hashMap;
    }
}
