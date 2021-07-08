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
    public static String f37421a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f37422b;

    /* renamed from: c  reason: collision with root package name */
    public String f37423c;

    /* renamed from: d  reason: collision with root package name */
    public String f37424d;

    /* renamed from: e  reason: collision with root package name */
    public int f37425e;

    /* renamed from: f  reason: collision with root package name */
    public String f37426f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f37427g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f37428h;

    /* renamed from: i  reason: collision with root package name */
    public long f37429i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f37423c = null;
        this.f37425e = 0;
        this.f37429i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f37422b = obj;
                this.f37425e = intValue;
                this.f37423c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f37421a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f37421a, "Tracker Session Object created.", new Object[0]);
        }
        this.f37422b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f37421a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f37424d = this.f37423c;
        this.f37423c = e.b();
        this.f37425e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f37421a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f37421a, " + Session ID: %s", this.f37423c);
        com.meizu.cloud.pushsdk.c.f.c.b(f37421a, " + Previous Session ID: %s", this.f37424d);
        com.meizu.cloud.pushsdk.c.f.c.b(f37421a, " + Session Index: %s", Integer.valueOf(this.f37425e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f37428h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f37421a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f37421a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f37428h, System.currentTimeMillis(), this.f37427g.get() ? this.j : this.f37429i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f37422b);
        hashMap.put("sessionId", this.f37423c);
        hashMap.put("previousSessionId", this.f37424d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f37425e));
        hashMap.put("storageMechanism", this.f37426f);
        return hashMap;
    }
}
