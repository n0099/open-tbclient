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
    public static String f75189a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f75190b;

    /* renamed from: c  reason: collision with root package name */
    public String f75191c;

    /* renamed from: d  reason: collision with root package name */
    public String f75192d;

    /* renamed from: e  reason: collision with root package name */
    public int f75193e;

    /* renamed from: f  reason: collision with root package name */
    public String f75194f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f75195g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f75196h;

    /* renamed from: i  reason: collision with root package name */
    public long f75197i;

    /* renamed from: j  reason: collision with root package name */
    public long f75198j;
    public Context k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.f75191c = null;
        this.f75193e = 0;
        this.f75197i = timeUnit.toMillis(j2);
        this.f75198j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f75190b = obj;
                this.f75193e = intValue;
                this.f75191c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f75189a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f75189a, "Tracker Session Object created.", new Object[0]);
        }
        this.f75190b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f75189a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f75192d = this.f75191c;
        this.f75191c = e.b();
        this.f75193e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f75189a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f75189a, " + Session ID: %s", this.f75191c);
        com.meizu.cloud.pushsdk.c.f.c.b(f75189a, " + Previous Session ID: %s", this.f75192d);
        com.meizu.cloud.pushsdk.c.f.c.b(f75189a, " + Session Index: %s", Integer.valueOf(this.f75193e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f75196h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f75189a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f75189a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f75196h, System.currentTimeMillis(), this.f75195g.get() ? this.f75198j : this.f75197i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f75190b);
        hashMap.put("sessionId", this.f75191c);
        hashMap.put("previousSessionId", this.f75192d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f75193e));
        hashMap.put("storageMechanism", this.f75194f);
        return hashMap;
    }
}
