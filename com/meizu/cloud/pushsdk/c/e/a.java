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
    public String f58727b;

    /* renamed from: c  reason: collision with root package name */
    public String f58728c;

    /* renamed from: d  reason: collision with root package name */
    public String f58729d;

    /* renamed from: e  reason: collision with root package name */
    public int f58730e;

    /* renamed from: f  reason: collision with root package name */
    public String f58731f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f58732g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f58733h;

    /* renamed from: i  reason: collision with root package name */
    public long f58734i;

    /* renamed from: j  reason: collision with root package name */
    public long f58735j;
    public Context k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f58728c = null;
        this.f58730e = 0;
        this.f58734i = timeUnit.toMillis(j2);
        this.f58735j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f58727b = obj;
                this.f58730e = intValue;
                this.f58728c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
        }
        this.f58727b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f58729d = this.f58728c;
        this.f58728c = e.b();
        this.f58730e++;
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session ID: %s", this.f58728c);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Previous Session ID: %s", this.f58729d);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session Index: %s", Integer.valueOf(this.f58730e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f58733h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f58733h, System.currentTimeMillis(), this.f58732g.get() ? this.f58735j : this.f58734i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f58727b);
        hashMap.put("sessionId", this.f58728c);
        hashMap.put("previousSessionId", this.f58729d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f58730e));
        hashMap.put("storageMechanism", this.f58731f);
        return hashMap;
    }
}
