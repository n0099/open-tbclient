package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f38042a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f38043b;

    /* renamed from: c  reason: collision with root package name */
    public String f38044c;

    /* renamed from: d  reason: collision with root package name */
    public String f38045d;

    /* renamed from: e  reason: collision with root package name */
    public int f38046e;

    /* renamed from: f  reason: collision with root package name */
    public String f38047f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f38048g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f38049h;
    public long i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f38044c = null;
        this.f38046e = 0;
        this.i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f38043b = obj;
                this.f38046e = intValue;
                this.f38044c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f38042a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f38042a, "Tracker Session Object created.", new Object[0]);
        }
        this.f38043b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f38042a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f38045d = this.f38044c;
        this.f38044c = e.b();
        this.f38046e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f38042a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f38042a, " + Session ID: %s", this.f38044c);
        com.meizu.cloud.pushsdk.c.f.c.b(f38042a, " + Previous Session ID: %s", this.f38045d);
        com.meizu.cloud.pushsdk.c.f.c.b(f38042a, " + Session Index: %s", Integer.valueOf(this.f38046e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f38049h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f38042a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f38042a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f38049h, System.currentTimeMillis(), this.f38048g.get() ? this.j : this.i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f38043b);
        hashMap.put("sessionId", this.f38044c);
        hashMap.put("previousSessionId", this.f38045d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f38046e));
        hashMap.put("storageMechanism", this.f38047f);
        return hashMap;
    }
}
