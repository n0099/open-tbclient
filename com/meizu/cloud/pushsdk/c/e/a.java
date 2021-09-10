package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f74835a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f74836b;

    /* renamed from: c  reason: collision with root package name */
    public String f74837c;

    /* renamed from: d  reason: collision with root package name */
    public String f74838d;

    /* renamed from: e  reason: collision with root package name */
    public int f74839e;

    /* renamed from: f  reason: collision with root package name */
    public String f74840f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f74841g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f74842h;

    /* renamed from: i  reason: collision with root package name */
    public long f74843i;

    /* renamed from: j  reason: collision with root package name */
    public long f74844j;
    public Context k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f74837c = null;
        this.f74839e = 0;
        this.f74843i = timeUnit.toMillis(j2);
        this.f74844j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f74836b = obj;
                this.f74839e = intValue;
                this.f74837c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f74835a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f74835a, "Tracker Session Object created.", new Object[0]);
        }
        this.f74836b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f74835a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f74838d = this.f74837c;
        this.f74837c = e.b();
        this.f74839e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f74835a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f74835a, " + Session ID: %s", this.f74837c);
        com.meizu.cloud.pushsdk.c.f.c.b(f74835a, " + Previous Session ID: %s", this.f74838d);
        com.meizu.cloud.pushsdk.c.f.c.b(f74835a, " + Session Index: %s", Integer.valueOf(this.f74839e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f74842h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f74835a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f74835a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f74842h, System.currentTimeMillis(), this.f74841g.get() ? this.f74844j : this.f74843i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f74836b);
        hashMap.put("sessionId", this.f74837c);
        hashMap.put("previousSessionId", this.f74838d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f74839e));
        hashMap.put("storageMechanism", this.f74840f);
        return hashMap;
    }
}
