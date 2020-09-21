package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes3.dex */
public abstract class c<T extends BasicPushStatus> {
    protected ScheduledExecutorService d;
    protected Context e;
    protected String f;
    protected String g;
    protected String h;
    protected volatile String i;
    protected com.meizu.cloud.pushsdk.platform.a.a j;
    protected boolean k = true;
    protected boolean l = true;
    private String a = null;

    public c(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this.d = scheduledExecutorService;
        this.e = context;
        this.f = str;
        this.g = str2;
        this.j = aVar;
    }

    private boolean a(int i) {
        return i >= 110000 && i <= 200000;
    }

    private boolean b(T t) {
        int intValue = Integer.valueOf(t.getCode()).intValue();
        return (intValue > 200 && intValue < 600) || (intValue > 1000 && intValue < 2000) || intValue == 0;
    }

    private boolean h() {
        return this.l && !this.e.getPackageName().equals(this.a);
    }

    protected String a(Context context, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(str), 0);
            if (queryIntentServices != null) {
                Iterator<ResolveInfo> it = queryIntentServices.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str2 = null;
                        break;
                    }
                    ResolveInfo next = it.next();
                    if ("com.meizu.cloud".equals(next.serviceInfo.packageName)) {
                        this.a = next.serviceInfo.packageName;
                        str2 = next.serviceInfo.name;
                        break;
                    }
                }
                if (TextUtils.isEmpty(str2) && queryIntentServices.size() > 0) {
                    this.a = queryIntentServices.get(0).serviceInfo.packageName;
                    str2 = queryIntentServices.get(0).serviceInfo.name;
                }
                com.meizu.cloud.a.a.i("Strategy", "current process packageName " + this.a);
                return str2;
            }
        }
        str2 = null;
        com.meizu.cloud.a.a.i("Strategy", "current process packageName " + this.a);
        return str2;
    }

    protected void a(Intent intent) {
        try {
            intent.setPackage(this.a);
            intent.setAction(PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION);
            this.e.startService(intent);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e("Strategy", "start RemoteService error " + e.getMessage());
        }
    }

    protected abstract void a(T t);

    public void a(boolean z) {
        this.k = z;
    }

    protected abstract boolean a();

    protected abstract T b();

    public void b(String str) {
        this.f = str;
    }

    protected abstract Intent c();

    public void c(String str) {
        this.g = str;
    }

    public void d(String str) {
        this.h = str;
    }

    protected Intent[] d() {
        return null;
    }

    protected abstract T e();

    protected abstract T f();

    protected abstract int g();

    protected boolean k() {
        return this.l && this.k && !TextUtils.isEmpty(a(this.e, PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION));
    }

    protected boolean l() {
        return 2 == g() || 32 == g();
    }

    public boolean m() {
        if (this.d != null) {
            this.d.execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.n();
                }
            });
            return true;
        }
        return n();
    }

    public boolean n() {
        T t;
        boolean z;
        if (!a()) {
            com.meizu.cloud.a.a.e("Strategy", "Missing required parameters");
            t = b();
            a((c<T>) t);
        } else if (k()) {
            com.meizu.cloud.a.a.i("Strategy", "send message to remote service");
            if (l()) {
                t = null;
            } else {
                t = f();
                if (t != null) {
                    com.meizu.cloud.a.a.e("Strategy", "local response " + t);
                    a((c<T>) t);
                }
            }
            Intent c = c();
            if (c != null) {
                a(c);
            }
            Intent[] d = d();
            if (d != null) {
                com.meizu.cloud.a.a.e("Strategy", "send sendRpcRequests length " + d.length);
                for (Intent intent : d) {
                    a(intent);
                }
            }
            MzSystemUtils.sendMessageFromBroadcast(this.e, new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START"), null, this.e.getPackageName());
        } else {
            T e = e();
            com.meizu.cloud.a.a.i("Strategy", "real response status " + e);
            if (e == null) {
                t = e;
            } else if (l() && "20000".equals(e.getCode())) {
                return true;
            } else {
                if (h()) {
                    com.meizu.cloud.a.a.e("Strategy", "response all request in local app");
                    a((c<T>) e);
                    t = e;
                } else {
                    String code = e.getCode();
                    if (TextUtils.isEmpty(code)) {
                        code = "0";
                    }
                    if (BasicPushStatus.SUCCESS_CODE.equals(e.getCode())) {
                        a((c<T>) e);
                    }
                    int intValue = Integer.valueOf(code).intValue();
                    if (a(intValue)) {
                        com.meizu.cloud.a.a.e("Strategy", "service error so notify pushManager invoker code=" + intValue + " message " + e.getMessage());
                        a((c<T>) e);
                    }
                    t = e;
                }
            }
        }
        if (t != null) {
            com.meizu.cloud.a.a.e("Strategy", "current status code " + t.getCode());
            z = !b((c<T>) t);
        } else {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String o() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = MzSystemUtils.getDeviceId(this.e);
            com.meizu.cloud.a.a.e("Strategy", "deviceId " + this.i);
        }
        return this.i;
    }
}
