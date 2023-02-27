package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.d.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class b {
    public static final String a = "b";
    public String b;
    public String c;
    public String d;
    public int e;
    public final String f = "SQLITE";
    public final AtomicBoolean g = new AtomicBoolean(false);
    public long h;
    public final long i;
    public final long j;
    public final Context k;

    public b(long j, long j2, TimeUnit timeUnit, Context context) {
        this.c = null;
        this.e = 0;
        this.i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f = f();
        if (f != null) {
            try {
                String obj = f.get("userId").toString();
                String obj2 = f.get("sessionId").toString();
                int intValue = ((Integer) f.get("sessionIndex")).intValue();
                this.b = obj;
                this.e = intValue;
                this.c = obj2;
            } catch (Exception e) {
                com.meizu.cloud.pushsdk.d.f.c.a(a, "Exception occurred retrieving session info from file: %s", e.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.d.f.c.c(a, "Tracker Session Object created.", new Object[0]);
        }
        this.b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.d = this.c;
        this.c = e.b();
        this.e++;
        com.meizu.cloud.pushsdk.d.f.c.b(a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.d.f.c.b(a, " + Session ID: %s", this.c);
        com.meizu.cloud.pushsdk.d.f.c.b(a, " + Previous Session ID: %s", this.d);
        com.meizu.cloud.pushsdk.d.f.c.b(a, " + Session Index: %s", Integer.valueOf(this.e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.d.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.d.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.d.a.b a() {
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.d.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.d.f.c.b(a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.h, System.currentTimeMillis(), this.g.get() ? this.j : this.i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap(8);
        hashMap.put("userId", this.b);
        hashMap.put("sessionId", this.c);
        hashMap.put("previousSessionId", this.d);
        hashMap.put("sessionIndex", Integer.valueOf(this.e));
        getClass();
        hashMap.put("storageMechanism", "SQLITE");
        return hashMap;
    }
}
