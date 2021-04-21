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
    public static String f38137a = "a";

    /* renamed from: b  reason: collision with root package name */
    public String f38138b;

    /* renamed from: c  reason: collision with root package name */
    public String f38139c;

    /* renamed from: d  reason: collision with root package name */
    public String f38140d;

    /* renamed from: e  reason: collision with root package name */
    public int f38141e;

    /* renamed from: f  reason: collision with root package name */
    public String f38142f = "SQLITE";

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f38143g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    public long f38144h;
    public long i;
    public long j;
    public Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.f38139c = null;
        this.f38141e = 0;
        this.i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f2 = f();
        if (f2 != null) {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.f38138b = obj;
                this.f38141e = intValue;
                this.f38139c = obj2;
            } catch (Exception e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(f38137a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
            }
            d();
            g();
            com.meizu.cloud.pushsdk.c.f.c.c(f38137a, "Tracker Session Object created.", new Object[0]);
        }
        this.f38138b = e.b();
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f38137a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.f38140d = this.f38139c;
        this.f38139c = e.b();
        this.f38141e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f38137a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f38137a, " + Session ID: %s", this.f38139c);
        com.meizu.cloud.pushsdk.c.f.c.b(f38137a, " + Previous Session ID: %s", this.f38140d);
        com.meizu.cloud.pushsdk.c.f.c.b(f38137a, " + Session Index: %s", Integer.valueOf(this.f38141e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.f38144h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f38137a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f38137a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.f38144h, System.currentTimeMillis(), this.f38143g.get() ? this.j : this.i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.f38138b);
        hashMap.put("sessionId", this.f38139c);
        hashMap.put("previousSessionId", this.f38140d);
        hashMap.put("sessionIndex", Integer.valueOf(this.f38141e));
        hashMap.put("storageMechanism", this.f38142f);
        return hashMap;
    }
}
