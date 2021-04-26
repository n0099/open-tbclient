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
    public static String f35693a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f35694b;

    /* renamed from: c  reason: collision with root package name */
    public String f35695c;

    /* renamed from: d  reason: collision with root package name */
    public String f35696d;

    /* renamed from: e  reason: collision with root package name */
    public int f35697e;

    /* renamed from: f  reason: collision with root package name */
    public String f35698f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f35699g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f35700h;

    /* renamed from: i  reason: collision with root package name */
    public long f35701i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f35695c = null;
        this.f35697e = 0;
        this.f35701i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f35694b = obj;
                this.f35697e = intValue;
                this.f35695c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f35693a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f35693a, "Tracker Session Object created.", new Object[0]);
        }
        this.f35694b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f35693a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f35696d = this.f35695c;
        this.f35695c = e.b();
        this.f35697e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f35693a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f35693a, " + Session ID: %s", this.f35695c);
        com.meizu.cloud.pushsdk.c.f.c.b(f35693a, " + Previous Session ID: %s", this.f35696d);
        com.meizu.cloud.pushsdk.c.f.c.b(f35693a, " + Session Index: %s", Integer.valueOf(this.f35697e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f35700h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f35693a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f35693a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f35700h, System.currentTimeMillis(), this.f35699g.get() ? this.j : this.f35701i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f35694b);
        hashMap.put("sessionId", this.f35695c);
        hashMap.put("previousSessionId", this.f35696d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f35697e));
        hashMap.put("storageMechanism", this.f35698f);
        return hashMap;
    }
}
