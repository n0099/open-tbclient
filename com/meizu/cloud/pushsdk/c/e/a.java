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
    public String f58772b;

    /* renamed from: c  reason: collision with root package name */
    public String f58773c;

    /* renamed from: d  reason: collision with root package name */
    public String f58774d;

    /* renamed from: e  reason: collision with root package name */
    public int f58775e;

    /* renamed from: f  reason: collision with root package name */
    public String f58776f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f58777g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f58778h;

    /* renamed from: i  reason: collision with root package name */
    public long f58779i;

    /* renamed from: j  reason: collision with root package name */
    public long f58780j;
    public Context k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f58773c = null;
        this.f58775e = 0;
        this.f58779i = timeUnit.toMillis(j2);
        this.f58780j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f58772b = obj;
                this.f58775e = intValue;
                this.f58773c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
        }
        this.f58772b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f58774d = this.f58773c;
        this.f58773c = e.b();
        this.f58775e++;
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session ID: %s", this.f58773c);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Previous Session ID: %s", this.f58774d);
        com.meizu.cloud.pushsdk.c.f.c.b(a, " + Session Index: %s", Integer.valueOf(this.f58775e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f58778h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f58778h, System.currentTimeMillis(), this.f58777g.get() ? this.f58780j : this.f58779i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f58772b);
        hashMap.put("sessionId", this.f58773c);
        hashMap.put("previousSessionId", this.f58774d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f58775e));
        hashMap.put("storageMechanism", this.f58776f);
        return hashMap;
    }
}
