package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a {
    public static String a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f61037b;

    /* renamed from: c  reason: collision with root package name */
    public String f61038c;

    /* renamed from: d  reason: collision with root package name */
    public String f61039d;

    /* renamed from: e  reason: collision with root package name */
    public int f61040e;

    /* renamed from: f  reason: collision with root package name */
    public String f61041f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f61042g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f61043h;

    /* renamed from: i  reason: collision with root package name */
    public long f61044i;

    /* renamed from: j  reason: collision with root package name */
    public long f61045j;

    /* renamed from: k  reason: collision with root package name */
    public Context f61046k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f61038c = null;
        this.f61040e = 0;
        this.f61044i = timeUnit.toMillis(j2);
        this.f61045j = timeUnit.toMillis(j3);
        this.f61046k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f61037b = obj;
                this.f61040e = intValue;
                this.f61038c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
        }
        this.f61037b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f61039d = this.f61038c;
        this.f61038c = e.b();
        this.f61040e++;
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session ID: %s", this.f61038c);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Previous Session ID: %s", this.f61039d);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session Index: %s", Integer.valueOf(this.f61040e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.f61046k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.f61046k);
    }

    private void g() {
        this.f61043h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f61043h, System.currentTimeMillis(), this.f61042g.get() ? this.f61045j : this.f61044i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f61037b);
        hashMap.put("sessionId", this.f61038c);
        hashMap.put("previousSessionId", this.f61039d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f61040e));
        hashMap.put("storageMechanism", this.f61041f);
        return hashMap;
    }
}
