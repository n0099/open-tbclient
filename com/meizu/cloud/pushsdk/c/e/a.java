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
    public static String f38644a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f38645b;

    /* renamed from: c  reason: collision with root package name */
    public String f38646c;

    /* renamed from: d  reason: collision with root package name */
    public String f38647d;

    /* renamed from: e  reason: collision with root package name */
    public int f38648e;

    /* renamed from: f  reason: collision with root package name */
    public String f38649f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f38650g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f38651h;

    /* renamed from: i  reason: collision with root package name */
    public long f38652i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f38646c = null;
        this.f38648e = 0;
        this.f38652i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f38645b = obj;
                this.f38648e = intValue;
                this.f38646c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f38644a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f38644a, "Tracker Session Object created.", new Object[0]);
        }
        this.f38645b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f38644a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f38647d = this.f38646c;
        this.f38646c = e.b();
        this.f38648e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f38644a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f38644a, " + Session ID: %s", this.f38646c);
        com.meizu.cloud.pushsdk.c.f.c.b(f38644a, " + Previous Session ID: %s", this.f38647d);
        com.meizu.cloud.pushsdk.c.f.c.b(f38644a, " + Session Index: %s", Integer.valueOf(this.f38648e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f38651h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f38644a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f38644a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f38651h, System.currentTimeMillis(), this.f38650g.get() ? this.j : this.f38652i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f38645b);
        hashMap.put("sessionId", this.f38646c);
        hashMap.put("previousSessionId", this.f38647d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f38648e));
        hashMap.put("storageMechanism", this.f38649f);
        return hashMap;
    }
}
