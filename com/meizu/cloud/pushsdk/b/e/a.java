package com.meizu.cloud.pushsdk.b.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {
    private static String a = a.class.getSimpleName();
    private String b;
    private String c;
    private String d;
    private int e;
    private String f = "SQLITE";
    private AtomicBoolean g = new AtomicBoolean(false);
    private long h;
    private long i;
    private long j;
    private Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.c = null;
        this.e = 0;
        this.i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f = f();
        if (f == null) {
            this.b = e.b();
        } else {
            try {
                String obj = f.get("userId").toString();
                String obj2 = f.get("sessionId").toString();
                int intValue = ((Integer) f.get("sessionIndex")).intValue();
                this.b = obj;
                this.e = intValue;
                this.c = obj2;
            } catch (Exception e) {
                com.meizu.cloud.pushsdk.b.f.c.a(a, "Exception occurred retrieving session info from file: %s", e.getMessage());
                this.b = e.b();
            }
        }
        d();
        g();
        com.meizu.cloud.pushsdk.b.f.c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    public com.meizu.cloud.pushsdk.b.a.b a() {
        com.meizu.cloud.pushsdk.b.f.c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.b.a.b("client_session", c());
    }

    public void b() {
        long j;
        com.meizu.cloud.pushsdk.b.f.c.b(a, "Checking and updating session information.", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.g.get()) {
            j = this.j;
        } else {
            j = this.i;
        }
        if (!e.a(this.h, currentTimeMillis, j)) {
            d();
            g();
        }
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.b);
        hashMap.put("sessionId", this.c);
        hashMap.put("previousSessionId", this.d);
        hashMap.put("sessionIndex", Integer.valueOf(this.e));
        hashMap.put("storageMechanism", this.f);
        return hashMap;
    }

    private void d() {
        this.d = this.c;
        this.c = e.b();
        this.e++;
        com.meizu.cloud.pushsdk.b.f.c.b(a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.b.f.c.b(a, " + Session ID: %s", this.c);
        com.meizu.cloud.pushsdk.b.f.c.b(a, " + Previous Session ID: %s", this.d);
        com.meizu.cloud.pushsdk.b.f.c.b(a, " + Session Index: %s", Integer.valueOf(this.e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.b.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.b.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.h = System.currentTimeMillis();
    }
}
