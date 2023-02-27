package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes8.dex */
public abstract class c<T extends BasicPushStatus> {
    public final Context a;
    public String b;
    public String c;
    public String d;
    public final com.meizu.cloud.pushsdk.platform.a.a e;
    public ScheduledExecutorService h;
    public boolean f = true;
    public boolean g = true;
    public String i = null;

    public c(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this.h = scheduledExecutorService;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.e = aVar;
    }

    private boolean a(int i) {
        return i >= 110000 && i <= 200000;
    }

    private boolean b(T t) {
        int intValue = Integer.valueOf(t.getCode()).intValue();
        return (intValue > 200 && intValue < 600) || (intValue > 1000 && intValue < 2000) || intValue == 0;
    }

    private boolean h() {
        return this.g && !this.a.getPackageName().equals(this.i);
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
                    if (PushConstants.PUSH_PACKAGE_NAME.equals(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        this.i = serviceInfo.packageName;
                        str2 = serviceInfo.name;
                        break;
                    }
                }
                if (TextUtils.isEmpty(str2) && queryIntentServices.size() > 0) {
                    this.i = queryIntentServices.get(0).serviceInfo.packageName;
                    str2 = queryIntentServices.get(0).serviceInfo.name;
                }
            }
        }
        DebugLogger.i("Strategy", "current process packageName " + this.i);
        return str2;
    }

    public void a(Intent intent) {
        try {
            intent.setPackage(this.i);
            intent.setAction(PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION);
            this.a.startService(intent);
        } catch (Exception e) {
            DebugLogger.e("Strategy", "start RemoteService error " + e.getMessage());
        }
    }

    public abstract void a(T t);

    public void a(boolean z) {
        this.f = z;
    }

    public abstract boolean a();

    public abstract T b();

    public void b(String str) {
        this.b = str;
    }

    public abstract Intent c();

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public Intent[] d() {
        return null;
    }

    public abstract T e();

    public abstract T f();

    public abstract int g();

    public boolean k() {
        return this.g && this.f && !TextUtils.isEmpty(a(this.a, PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION));
    }

    public boolean l() {
        return 2 == g() || 32 == g();
    }

    public boolean m() {
        ScheduledExecutorService scheduledExecutorService = this.h;
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

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n() {
        T t;
        String str;
        if (a()) {
            if (k()) {
                DebugLogger.i("Strategy", "send message to remote service");
                if (l()) {
                    t = null;
                } else {
                    t = f();
                    if (t != null) {
                        DebugLogger.e("Strategy", "local response " + t);
                        a((c<T>) t);
                    }
                }
                Intent c = c();
                if (c != null) {
                    a(c);
                }
                Intent[] d = d();
                if (d != null) {
                    DebugLogger.e("Strategy", "send sendRpcRequests length " + d.length);
                    for (Intent intent : d) {
                        a(intent);
                    }
                }
                com.meizu.cloud.pushsdk.a.a(this.a);
            } else {
                t = e();
                DebugLogger.i("Strategy", "real response status " + t);
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
                        if (BasicPushStatus.SUCCESS_CODE.equals(t.getCode())) {
                            a((c<T>) t);
                        }
                        int intValue = Integer.valueOf(code).intValue();
                        if (a(intValue)) {
                            str = "service error so notify pushManager invoker code=" + intValue + " message " + t.getMessage();
                        }
                    }
                    DebugLogger.e("Strategy", str);
                }
            }
            if (t == null) {
                DebugLogger.e("Strategy", "current status code " + t.getCode());
                return true ^ b((c<T>) t);
            }
            return true;
        }
        DebugLogger.e("Strategy", "Missing required parameters");
        t = b();
        a((c<T>) t);
        if (t == null) {
        }
    }
}
