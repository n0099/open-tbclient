package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes6.dex */
public abstract class c<T extends BasicPushStatus> {

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f37758d;

    /* renamed from: e  reason: collision with root package name */
    public Context f37759e;

    /* renamed from: f  reason: collision with root package name */
    public String f37760f;

    /* renamed from: g  reason: collision with root package name */
    public String f37761g;

    /* renamed from: h  reason: collision with root package name */
    public String f37762h;

    /* renamed from: i  reason: collision with root package name */
    public volatile String f37763i;
    public com.meizu.cloud.pushsdk.platform.a.a j;
    public boolean k = true;
    public boolean l = true;

    /* renamed from: a  reason: collision with root package name */
    public String f37757a = null;

    public c(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this.f37758d = scheduledExecutorService;
        this.f37759e = context;
        this.f37760f = str;
        this.f37761g = str2;
        this.j = aVar;
    }

    private boolean a(int i2) {
        return i2 >= 110000 && i2 <= 200000;
    }

    private boolean b(T t) {
        int intValue = Integer.valueOf(t.getCode()).intValue();
        return (intValue > 200 && intValue < 600) || (intValue > 1000 && intValue < 2000) || intValue == 0;
    }

    private boolean h() {
        return this.l && !this.f37759e.getPackageName().equals(this.f37757a);
    }

    public String a(Context context, String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(str), 0);
            if (queryIntentServices != null) {
                Iterator<ResolveInfo> it = queryIntentServices.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    if ("com.meizu.cloud".equals(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        this.f37757a = serviceInfo.packageName;
                        str2 = serviceInfo.name;
                        break;
                    }
                }
                if (TextUtils.isEmpty(str2) && queryIntentServices.size() > 0) {
                    this.f37757a = queryIntentServices.get(0).serviceInfo.packageName;
                    str2 = queryIntentServices.get(0).serviceInfo.name;
                }
            }
        }
        d.h.a.a.a.d("Strategy", "current process packageName " + this.f37757a);
        return str2;
    }

    public void a(Intent intent) {
        try {
            intent.setPackage(this.f37757a);
            intent.setAction(PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION);
            this.f37759e.startService(intent);
        } catch (Exception e2) {
            d.h.a.a.a.b("Strategy", "start RemoteService error " + e2.getMessage());
        }
    }

    public abstract void a(T t);

    public void a(boolean z) {
        this.k = z;
    }

    public abstract boolean a();

    public abstract T b();

    public void b(String str) {
        this.f37760f = str;
    }

    public abstract Intent c();

    public void c(String str) {
        this.f37761g = str;
    }

    public void d(String str) {
        this.f37762h = str;
    }

    public Intent[] d() {
        return null;
    }

    public abstract T e();

    public abstract T f();

    public abstract int g();

    public boolean k() {
        return this.l && this.k && !TextUtils.isEmpty(a(this.f37759e, PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION));
    }

    public boolean l() {
        return 2 == g() || 32 == g();
    }

    public boolean m() {
        ScheduledExecutorService scheduledExecutorService = this.f37758d;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.n();
                }
            });
            return true;
        }
        return n();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n() {
        T t;
        String str;
        if (a()) {
            if (k()) {
                d.h.a.a.a.d("Strategy", "send message to remote service");
                if (l()) {
                    t = null;
                } else {
                    t = f();
                    if (t != null) {
                        d.h.a.a.a.b("Strategy", "local response " + t);
                        a((c<T>) t);
                    }
                }
                Intent c2 = c();
                if (c2 != null) {
                    a(c2);
                }
                Intent[] d2 = d();
                if (d2 != null) {
                    d.h.a.a.a.b("Strategy", "send sendRpcRequests length " + d2.length);
                    for (Intent intent : d2) {
                        a(intent);
                    }
                }
                MzSystemUtils.sendMessageFromBroadcast(this.f37759e, new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START"), null, this.f37759e.getPackageName());
            } else {
                t = e();
                d.h.a.a.a.d("Strategy", "real response status " + t);
                if (t != null) {
                    if (l() && "20000".equals(t.getCode())) {
                        return true;
                    }
                    if (h()) {
                        str = "response all request in local app";
                    } else {
                        String code = t.getCode();
                        if (TextUtils.isEmpty(code)) {
                            code = "0";
                        }
                        if ("200".equals(t.getCode())) {
                            a((c<T>) t);
                        }
                        int intValue = Integer.valueOf(code).intValue();
                        if (a(intValue)) {
                            str = "service error so notify pushManager invoker code=" + intValue + " message " + t.getMessage();
                        }
                    }
                    d.h.a.a.a.b("Strategy", str);
                }
            }
            if (t == null) {
                d.h.a.a.a.b("Strategy", "current status code " + t.getCode());
                return true ^ b((c<T>) t);
            }
            return true;
        }
        d.h.a.a.a.b("Strategy", "Missing required parameters");
        t = b();
        a((c<T>) t);
        if (t == null) {
        }
    }

    public String o() {
        if (TextUtils.isEmpty(this.f37763i)) {
            this.f37763i = MzSystemUtils.getDeviceId(this.f37759e);
            d.h.a.a.a.b("Strategy", "deviceId " + this.f37763i);
        }
        return this.f37763i;
    }
}
