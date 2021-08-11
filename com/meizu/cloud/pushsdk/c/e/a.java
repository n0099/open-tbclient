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
    public static String f74455a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f74456b;

    /* renamed from: c  reason: collision with root package name */
    public String f74457c;

    /* renamed from: d  reason: collision with root package name */
    public String f74458d;

    /* renamed from: e  reason: collision with root package name */
    public int f74459e;

    /* renamed from: f  reason: collision with root package name */
    public String f74460f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f74461g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f74462h;

    /* renamed from: i  reason: collision with root package name */
    public long f74463i;

    /* renamed from: j  reason: collision with root package name */
    public long f74464j;
    public Context k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f74457c = null;
        this.f74459e = 0;
        this.f74463i = timeUnit.toMillis(j2);
        this.f74464j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f74456b = obj;
                this.f74459e = intValue;
                this.f74457c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f74455a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f74455a, "Tracker Session Object created.", new Object[0]);
        }
        this.f74456b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f74455a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f74458d = this.f74457c;
        this.f74457c = e.b();
        this.f74459e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f74455a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f74455a, " + Session ID: %s", this.f74457c);
        com.meizu.cloud.pushsdk.c.f.c.b(f74455a, " + Previous Session ID: %s", this.f74458d);
        com.meizu.cloud.pushsdk.c.f.c.b(f74455a, " + Session Index: %s", Integer.valueOf(this.f74459e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f74462h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f74455a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f74455a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f74462h, System.currentTimeMillis(), this.f74461g.get() ? this.f74464j : this.f74463i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f74456b);
        hashMap.put("sessionId", this.f74457c);
        hashMap.put("previousSessionId", this.f74458d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f74459e));
        hashMap.put("storageMechanism", this.f74460f);
        return hashMap;
    }
}
