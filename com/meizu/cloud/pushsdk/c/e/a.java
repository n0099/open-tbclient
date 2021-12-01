package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {
    public static String a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f60456b;

    /* renamed from: c  reason: collision with root package name */
    public String f60457c;

    /* renamed from: d  reason: collision with root package name */
    public String f60458d;

    /* renamed from: e  reason: collision with root package name */
    public int f60459e;

    /* renamed from: f  reason: collision with root package name */
    public String f60460f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f60461g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f60462h;

    /* renamed from: i  reason: collision with root package name */
    public long f60463i;

    /* renamed from: j  reason: collision with root package name */
    public long f60464j;

    /* renamed from: k  reason: collision with root package name */
    public Context f60465k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f60457c = null;
        this.f60459e = 0;
        this.f60463i = timeUnit.toMillis(j2);
        this.f60464j = timeUnit.toMillis(j3);
        this.f60465k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f60456b = obj;
                this.f60459e = intValue;
                this.f60457c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
        }
        this.f60456b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f60458d = this.f60457c;
        this.f60457c = e.b();
        this.f60459e++;
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session ID: %s", this.f60457c);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Previous Session ID: %s", this.f60458d);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session Index: %s", Integer.valueOf(this.f60459e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.f60465k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.f60465k);
    }

    private void g() {
        this.f60462h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f60462h, System.currentTimeMillis(), this.f60461g.get() ? this.f60464j : this.f60463i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f60456b);
        hashMap.put("sessionId", this.f60457c);
        hashMap.put("previousSessionId", this.f60458d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f60459e));
        hashMap.put("storageMechanism", this.f60460f);
        return hashMap;
    }
}
