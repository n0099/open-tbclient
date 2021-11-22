package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f68462a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f68463b;

    /* renamed from: c  reason: collision with root package name */
    public String f68464c;

    /* renamed from: d  reason: collision with root package name */
    public String f68465d;

    /* renamed from: e  reason: collision with root package name */
    public int f68466e;

    /* renamed from: f  reason: collision with root package name */
    public String f68467f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f68468g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f68469h;

    /* renamed from: i  reason: collision with root package name */
    public long f68470i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f68464c = null;
        this.f68466e = 0;
        this.f68470i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f68463b = obj;
                this.f68466e = intValue;
                this.f68464c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f68462a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f68462a, "Tracker Session Object created.", new Object[0]);
        }
        this.f68463b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f68462a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f68465d = this.f68464c;
        this.f68464c = e.b();
        this.f68466e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f68462a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f68462a, " + Session ID: %s", this.f68464c);
        com.meizu.cloud.pushsdk.c.f.c.b(f68462a, " + Previous Session ID: %s", this.f68465d);
        com.meizu.cloud.pushsdk.c.f.c.b(f68462a, " + Session Index: %s", Integer.valueOf(this.f68466e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f68469h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f68462a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f68462a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f68469h, System.currentTimeMillis(), this.f68468g.get() ? this.j : this.f68470i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f68463b);
        hashMap.put("sessionId", this.f68464c);
        hashMap.put("previousSessionId", this.f68465d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f68466e));
        hashMap.put("storageMechanism", this.f68467f);
        return hashMap;
    }
}
