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
    public static String f34867a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f34868b;

    /* renamed from: c  reason: collision with root package name */
    public String f34869c;

    /* renamed from: d  reason: collision with root package name */
    public String f34870d;

    /* renamed from: e  reason: collision with root package name */
    public int f34871e;

    /* renamed from: f  reason: collision with root package name */
    public String f34872f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f34873g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f34874h;

    /* renamed from: i  reason: collision with root package name */
    public long f34875i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f34869c = null;
        this.f34871e = 0;
        this.f34875i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f34868b = obj;
                this.f34871e = intValue;
                this.f34869c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f34867a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f34867a, "Tracker Session Object created.", new Object[0]);
        }
        this.f34868b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f34867a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f34870d = this.f34869c;
        this.f34869c = e.b();
        this.f34871e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f34867a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f34867a, " + Session ID: %s", this.f34869c);
        com.meizu.cloud.pushsdk.c.f.c.b(f34867a, " + Previous Session ID: %s", this.f34870d);
        com.meizu.cloud.pushsdk.c.f.c.b(f34867a, " + Session Index: %s", Integer.valueOf(this.f34871e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f34874h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f34867a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f34867a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f34874h, System.currentTimeMillis(), this.f34873g.get() ? this.j : this.f34875i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f34868b);
        hashMap.put("sessionId", this.f34869c);
        hashMap.put("previousSessionId", this.f34870d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f34871e));
        hashMap.put("storageMechanism", this.f34872f);
        return hashMap;
    }
}
