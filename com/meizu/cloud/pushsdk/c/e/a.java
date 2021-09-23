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
    public static String f75154a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f75155b;

    /* renamed from: c  reason: collision with root package name */
    public String f75156c;

    /* renamed from: d  reason: collision with root package name */
    public String f75157d;

    /* renamed from: e  reason: collision with root package name */
    public int f75158e;

    /* renamed from: f  reason: collision with root package name */
    public String f75159f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f75160g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f75161h;

    /* renamed from: i  reason: collision with root package name */
    public long f75162i;

    /* renamed from: j  reason: collision with root package name */
    public long f75163j;
    public Context k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f75156c = null;
        this.f75158e = 0;
        this.f75162i = timeUnit.toMillis(j2);
        this.f75163j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f75155b = obj;
                this.f75158e = intValue;
                this.f75156c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f75154a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f75154a, "Tracker Session Object created.", new Object[0]);
        }
        this.f75155b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f75154a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f75157d = this.f75156c;
        this.f75156c = e.b();
        this.f75158e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f75154a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f75154a, " + Session ID: %s", this.f75156c);
        com.meizu.cloud.pushsdk.c.f.c.b(f75154a, " + Previous Session ID: %s", this.f75157d);
        com.meizu.cloud.pushsdk.c.f.c.b(f75154a, " + Session Index: %s", Integer.valueOf(this.f75158e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f75161h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f75154a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f75154a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f75161h, System.currentTimeMillis(), this.f75160g.get() ? this.f75163j : this.f75162i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f75155b);
        hashMap.put("sessionId", this.f75156c);
        hashMap.put("previousSessionId", this.f75157d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f75158e));
        hashMap.put("storageMechanism", this.f75159f);
        return hashMap;
    }
}
