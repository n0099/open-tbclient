package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f74655a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f74656b;

    /* renamed from: c  reason: collision with root package name */
    public String f74657c;

    /* renamed from: d  reason: collision with root package name */
    public String f74658d;

    /* renamed from: e  reason: collision with root package name */
    public int f74659e;

    /* renamed from: f  reason: collision with root package name */
    public String f74660f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f74661g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f74662h;

    /* renamed from: i  reason: collision with root package name */
    public long f74663i;

    /* renamed from: j  reason: collision with root package name */
    public long f74664j;
    public Context k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f74657c = null;
        this.f74659e = 0;
        this.f74663i = timeUnit.toMillis(j2);
        this.f74664j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f74656b = obj;
                this.f74659e = intValue;
                this.f74657c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f74655a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f74655a, "Tracker Session Object created.", new Object[0]);
        }
        this.f74656b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f74655a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f74658d = this.f74657c;
        this.f74657c = e.b();
        this.f74659e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f74655a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f74655a, " + Session ID: %s", this.f74657c);
        com.meizu.cloud.pushsdk.c.f.c.b(f74655a, " + Previous Session ID: %s", this.f74658d);
        com.meizu.cloud.pushsdk.c.f.c.b(f74655a, " + Session Index: %s", Integer.valueOf(this.f74659e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f74662h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f74655a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f74655a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f74662h, System.currentTimeMillis(), this.f74661g.get() ? this.f74664j : this.f74663i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f74656b);
        hashMap.put("sessionId", this.f74657c);
        hashMap.put("previousSessionId", this.f74658d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f74659e));
        hashMap.put("storageMechanism", this.f74660f);
        return hashMap;
    }
}
