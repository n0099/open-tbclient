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
    public static String f37753a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f37754b;

    /* renamed from: c  reason: collision with root package name */
    public String f37755c;

    /* renamed from: d  reason: collision with root package name */
    public String f37756d;

    /* renamed from: e  reason: collision with root package name */
    public int f37757e;

    /* renamed from: f  reason: collision with root package name */
    public String f37758f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f37759g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f37760h;
    public long i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f37755c = null;
        this.f37757e = 0;
        this.i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f37754b = obj;
                this.f37757e = intValue;
                this.f37755c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f37753a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f37753a, "Tracker Session Object created.", new Object[0]);
        }
        this.f37754b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f37753a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f37756d = this.f37755c;
        this.f37755c = e.b();
        this.f37757e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f37753a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f37753a, " + Session ID: %s", this.f37755c);
        com.meizu.cloud.pushsdk.c.f.c.b(f37753a, " + Previous Session ID: %s", this.f37756d);
        com.meizu.cloud.pushsdk.c.f.c.b(f37753a, " + Session Index: %s", Integer.valueOf(this.f37757e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f37760h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f37753a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f37753a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f37760h, System.currentTimeMillis(), this.f37759g.get() ? this.j : this.i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f37754b);
        hashMap.put("sessionId", this.f37755c);
        hashMap.put("previousSessionId", this.f37756d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f37757e));
        hashMap.put("storageMechanism", this.f37758f);
        return hashMap;
    }
}
