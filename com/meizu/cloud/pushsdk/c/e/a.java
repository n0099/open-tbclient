package com.meizu.cloud.pushsdk.c.e;

import android.content.Context;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.meizu.cloud.pushsdk.c.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f4398a = a.class.getSimpleName();
    private String b;
    private String c;
    private String d;
    private int e;
    private String f = "SQLITE";
    private AtomicBoolean g = new AtomicBoolean(false);
    private long h;
    private long i;
    private long j;
    private Context k;

    public a(long j, long j2, TimeUnit timeUnit, Context context) {
        this.c = null;
        this.e = 0;
        this.i = timeUnit.toMillis(j);
        this.j = timeUnit.toMillis(j2);
        this.k = context;
        Map f = f();
        if (f == null) {
            this.b = e.b();
        } else {
            try {
                String obj = f.get(TbEnum.SystemMessage.KEY_USER_ID).toString();
                String obj2 = f.get("sessionId").toString();
                int intValue = ((Integer) f.get("sessionIndex")).intValue();
                this.b = obj;
                this.e = intValue;
                this.c = obj2;
            } catch (Exception e) {
                com.meizu.cloud.pushsdk.c.f.c.a(f4398a, "Exception occurred retrieving session info from file: %s", e.getMessage());
                this.b = e.b();
            }
        }
        d();
        g();
        com.meizu.cloud.pushsdk.c.f.c.c(f4398a, "Tracker Session Object created.", new Object[0]);
    }

    private void d() {
        this.d = this.c;
        this.c = e.b();
        this.e++;
        com.meizu.cloud.pushsdk.c.f.c.b(f4398a, "Session information is updated:", new Object[0]);
        com.meizu.cloud.pushsdk.c.f.c.b(f4398a, " + Session ID: %s", this.c);
        com.meizu.cloud.pushsdk.c.f.c.b(f4398a, " + Previous Session ID: %s", this.d);
        com.meizu.cloud.pushsdk.c.f.c.b(f4398a, " + Session Index: %s", Integer.valueOf(this.e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.c.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.h = System.currentTimeMillis();
    }

    public com.meizu.cloud.pushsdk.c.a.b a() {
        com.meizu.cloud.pushsdk.c.f.c.c(f4398a, "Getting session context...", new Object[0]);
        g();
        return new com.meizu.cloud.pushsdk.c.a.b("client_session", c());
    }

    public void b() {
        com.meizu.cloud.pushsdk.c.f.c.b(f4398a, "Checking and updating session information.", new Object[0]);
        if (e.a(this.h, System.currentTimeMillis(), this.g.get() ? this.j : this.i)) {
            return;
        }
        d();
        g();
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put(TbEnum.SystemMessage.KEY_USER_ID, this.b);
        hashMap.put("sessionId", this.c);
        hashMap.put("previousSessionId", this.d);
        hashMap.put("sessionIndex", Integer.valueOf(this.e));
        hashMap.put("storageMechanism", this.f);
        return hashMap;
    }
}
