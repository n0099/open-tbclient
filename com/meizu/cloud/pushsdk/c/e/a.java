package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f38546a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f38547b;

    /* renamed from: c  reason: collision with root package name */
    public String f38548c;

    /* renamed from: d  reason: collision with root package name */
    public String f38549d;

    /* renamed from: e  reason: collision with root package name */
    public int f38550e;

    /* renamed from: f  reason: collision with root package name */
    public String f38551f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f38552g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f38553h;

    /* renamed from: i  reason: collision with root package name */
    public long f38554i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f38548c = null;
        this.f38550e = 0;
        this.f38554i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f38547b = obj;
                this.f38550e = intValue;
                this.f38548c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f38546a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f38546a, "Tracker Session Object created.", new Object[0]);
        }
        this.f38547b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f38546a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f38549d = this.f38548c;
        this.f38548c = e.b();
        this.f38550e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f38546a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f38546a, " + Session ID: %s", this.f38548c);
        com.meizu.cloud.pushsdk.c.f.c.b(f38546a, " + Previous Session ID: %s", this.f38549d);
        com.meizu.cloud.pushsdk.c.f.c.b(f38546a, " + Session Index: %s", Integer.valueOf(this.f38550e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f38553h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f38546a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f38546a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f38553h, System.currentTimeMillis(), this.f38552g.get() ? this.j : this.f38554i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f38547b);
        hashMap.put("sessionId", this.f38548c);
        hashMap.put("previousSessionId", this.f38549d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f38550e));
        hashMap.put("storageMechanism", this.f38551f);
        return hashMap;
    }
}
