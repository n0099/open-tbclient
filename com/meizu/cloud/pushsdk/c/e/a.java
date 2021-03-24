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
    public static String f37752a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f37753b;

    /* renamed from: c  reason: collision with root package name */
    public String f37754c;

    /* renamed from: d  reason: collision with root package name */
    public String f37755d;

    /* renamed from: e  reason: collision with root package name */
    public int f37756e;

    /* renamed from: f  reason: collision with root package name */
    public String f37757f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f37758g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f37759h;
    public long i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f37754c = null;
        this.f37756e = 0;
        this.i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f37753b = obj;
                this.f37756e = intValue;
                this.f37754c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f37752a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f37752a, "Tracker Session Object created.", new Object[0]);
        }
        this.f37753b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f37752a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f37755d = this.f37754c;
        this.f37754c = e.b();
        this.f37756e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f37752a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f37752a, " + Session ID: %s", this.f37754c);
        com.meizu.cloud.pushsdk.c.f.c.b(f37752a, " + Previous Session ID: %s", this.f37755d);
        com.meizu.cloud.pushsdk.c.f.c.b(f37752a, " + Session Index: %s", Integer.valueOf(this.f37756e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f37759h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f37752a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f37752a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f37759h, System.currentTimeMillis(), this.f37758g.get() ? this.j : this.i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f37753b);
        hashMap.put("sessionId", this.f37754c);
        hashMap.put("previousSessionId", this.f37755d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f37756e));
        hashMap.put("storageMechanism", this.f37757f);
        return hashMap;
    }
}
