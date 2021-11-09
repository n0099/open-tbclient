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
    public static String f67549a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f67550b;

    /* renamed from: c  reason: collision with root package name */
    public String f67551c;

    /* renamed from: d  reason: collision with root package name */
    public String f67552d;

    /* renamed from: e  reason: collision with root package name */
    public int f67553e;

    /* renamed from: f  reason: collision with root package name */
    public String f67554f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f67555g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f67556h;

    /* renamed from: i  reason: collision with root package name */
    public long f67557i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f67551c = null;
        this.f67553e = 0;
        this.f67557i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f67550b = obj;
                this.f67553e = intValue;
                this.f67551c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f67549a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f67549a, "Tracker Session Object created.", new Object[0]);
        }
        this.f67550b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f67549a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f67552d = this.f67551c;
        this.f67551c = e.b();
        this.f67553e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f67549a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f67549a, " + Session ID: %s", this.f67551c);
        com.meizu.cloud.pushsdk.c.f.c.b(f67549a, " + Previous Session ID: %s", this.f67552d);
        com.meizu.cloud.pushsdk.c.f.c.b(f67549a, " + Session Index: %s", Integer.valueOf(this.f67553e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f67556h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f67549a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f67549a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f67556h, System.currentTimeMillis(), this.f67555g.get() ? this.j : this.f67557i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f67550b);
        hashMap.put("sessionId", this.f67551c);
        hashMap.put("previousSessionId", this.f67552d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f67553e));
        hashMap.put("storageMechanism", this.f67554f);
        return hashMap;
    }
}
