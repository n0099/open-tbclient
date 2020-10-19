package com.vivo.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.vivo.push.aa;
import com.vivo.push.util.p;
import com.vivo.push.util.s;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes15.dex */
public final class a extends aa {
    private static a c;
    private static final List<Integer> f = Arrays.asList(3);
    private Handler d = new Handler(Looper.getMainLooper());
    private String e;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public final void b() {
        this.e = null;
    }

    public final void a(Intent intent) {
        if (intent == null || this.f4630a == null) {
            p.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f4630a);
            return;
        }
        Message obtain = Message.obtain();
        obtain.obj = intent;
        a(obtain);
    }

    @Override // com.vivo.push.aa
    public final void b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent == null || this.f4630a == null) {
            p.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f4630a);
            return;
        }
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            intExtra = intent.getIntExtra("method", -1);
        }
        String packageName = this.f4630a.getPackageName();
        if (!f.contains(Integer.valueOf(intExtra)) || !s.b(this.f4630a, packageName) || s.d(this.f4630a)) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(this.e)) {
                this.e = a(this.f4630a, packageName, action);
                if (TextUtils.isEmpty(this.e)) {
                    p.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                    intent.setPackage(packageName);
                    this.f4630a.sendBroadcast(intent);
                    return;
                }
            }
            try {
                Class<?> cls = Class.forName(this.e);
                Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                intent.setClassName(packageName, this.e);
                this.d.post(new b(this, method, newInstance, new Object[]{this.f4630a.getApplicationContext(), intent}));
            } catch (Exception e) {
                p.b("CommandWorker", "reflect e: ", e);
            }
        }
    }

    private static String a(Context context, String str, String str2) {
        String str3;
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            packageManager = context.getPackageManager();
        } catch (Exception e) {
            p.a("CommandWorker", "error  " + e.getMessage());
        }
        if (packageManager != null) {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                str3 = queryBroadcastReceivers.get(0).activityInfo.name;
                return str3;
            }
            str3 = null;
            return str3;
        }
        return null;
    }
}
