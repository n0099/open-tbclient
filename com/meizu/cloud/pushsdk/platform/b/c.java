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
/* loaded from: classes10.dex */
public abstract class c<T extends BasicPushStatus> {

    /* renamed from: d  reason: collision with root package name */
    public ScheduledExecutorService f74608d;

    /* renamed from: e  reason: collision with root package name */
    public Context f74609e;

    /* renamed from: f  reason: collision with root package name */
    public String f74610f;

    /* renamed from: g  reason: collision with root package name */
    public String f74611g;

    /* renamed from: h  reason: collision with root package name */
    public String f74612h;

    /* renamed from: i  reason: collision with root package name */
    public volatile String f74613i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.a.a f74614j;
    public boolean k = true;
    public boolean l = true;

    /* renamed from: a  reason: collision with root package name */
    public String f74607a = null;

    public c(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this.f74608d = scheduledExecutorService;
        this.f74609e = context;
        this.f74610f = str;
        this.f74611g = str2;
        this.f74614j = aVar;
    }

    private boolean a(int i2) {
        return i2 >= 110000 && i2 <= 200000;
    }

    private boolean b(T t) {
        int intValue = Integer.valueOf(t.getCode()).intValue();
        return (intValue > 200 && intValue < 600) || (intValue > 1000 && intValue < 2000) || intValue == 0;
    }

    private boolean h() {
        return this.l && !this.f74609e.getPackageName().equals(this.f74607a);
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
                        this.f74607a = serviceInfo.packageName;
                        str2 = serviceInfo.name;
                        break;
                    }
                }
                if (TextUtils.isEmpty(str2) && queryIntentServices.size() > 0) {
                    this.f74607a = queryIntentServices.get(0).serviceInfo.packageName;
                    str2 = queryIntentServices.get(0).serviceInfo.name;
                }
            }
        }
        c.l.a.a.a.d("Strategy", "current process packageName " + this.f74607a);
        return str2;
    }

    public void a(Intent intent) {
        try {
            intent.setPackage(this.f74607a);
            intent.setAction(PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION);
            this.f74609e.startService(intent);
        } catch (Exception e2) {
            c.l.a.a.a.b("Strategy", "start RemoteService error " + e2.getMessage());
        }
    }

    public abstract void a(T t);

    public void a(boolean z) {
        this.k = z;
    }

    public abstract boolean a();

    public abstract T b();

    public void b(String str) {
        this.f74610f = str;
    }

    public abstract Intent c();

    public void c(String str) {
        this.f74611g = str;
    }

    public void d(String str) {
        this.f74612h = str;
    }

    public Intent[] d() {
        return null;
    }

    public abstract T e();

    public abstract T f();

    public abstract int g();

    public boolean k() {
        return this.l && this.k && !TextUtils.isEmpty(a(this.f74609e, PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION));
    }

    public boolean l() {
        return 2 == g() || 32 == g();
    }

    public boolean m() {
        ScheduledExecutorService scheduledExecutorService = this.f74608d;
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
                c.l.a.a.a.d("Strategy", "send message to remote service");
                if (l()) {
                    t = null;
                } else {
                    t = f();
                    if (t != null) {
                        c.l.a.a.a.b("Strategy", "local response " + t);
                        a((c<T>) t);
                    }
                }
                Intent c2 = c();
                if (c2 != null) {
                    a(c2);
                }
                Intent[] d2 = d();
                if (d2 != null) {
                    c.l.a.a.a.b("Strategy", "send sendRpcRequests length " + d2.length);
                    for (Intent intent : d2) {
                        a(intent);
                    }
                }
                MzSystemUtils.sendMessageFromBroadcast(this.f74609e, new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START"), null, this.f74609e.getPackageName());
            } else {
                t = e();
                c.l.a.a.a.d("Strategy", "real response status " + t);
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
                    c.l.a.a.a.b("Strategy", str);
                }
            }
            if (t == null) {
                c.l.a.a.a.b("Strategy", "current status code " + t.getCode());
                return true ^ b((c<T>) t);
            }
            return true;
        }
        c.l.a.a.a.b("Strategy", "Missing required parameters");
        t = b();
        a((c<T>) t);
        if (t == null) {
        }
    }

    public String o() {
        if (TextUtils.isEmpty(this.f74613i)) {
            this.f74613i = MzSystemUtils.getDeviceId(this.f74609e);
            c.l.a.a.a.b("Strategy", "deviceId " + this.f74613i);
        }
        return this.f74613i;
    }
}
