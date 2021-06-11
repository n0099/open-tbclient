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
/* loaded from: classes7.dex */
public final class a extends aa {

    /* renamed from: c  reason: collision with root package name */
    public static a f40358c;

    /* renamed from: f  reason: collision with root package name */
    public static final List<Integer> f40359f = Arrays.asList(3);

    /* renamed from: d  reason: collision with root package name */
    public Handler f40360d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    public String f40361e;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f40358c == null) {
                f40358c = new a();
            }
            aVar = f40358c;
        }
        return aVar;
    }

    public final void b() {
        this.f40361e = null;
    }

    @Override // com.vivo.push.aa
    public final void b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent != null && this.f40190a != null) {
            int intExtra = intent.getIntExtra("command", -1);
            if (intExtra < 0) {
                intExtra = intent.getIntExtra("method", -1);
            }
            String packageName = this.f40190a.getPackageName();
            if (f40359f.contains(Integer.valueOf(intExtra)) && s.b(this.f40190a, packageName) && !s.d(this.f40190a)) {
                return;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(this.f40361e)) {
                String a2 = a(this.f40190a, packageName, action);
                this.f40361e = a2;
                if (TextUtils.isEmpty(a2)) {
                    p.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                    intent.setPackage(packageName);
                    this.f40190a.sendBroadcast(intent);
                    return;
                }
            }
            try {
                Class<?> cls = Class.forName(this.f40361e);
                Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                Method method = cls.getMethod("onReceive", Context.class, Intent.class);
                intent.setClassName(packageName, this.f40361e);
                this.f40360d.post(new b(this, method, newInstance, new Object[]{this.f40190a.getApplicationContext(), intent}));
                return;
            } catch (Exception e2) {
                p.b("CommandWorker", "reflect e: ", e2);
                return;
            }
        }
        p.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f40190a);
    }

    public final void a(Intent intent) {
        if (intent != null && this.f40190a != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            a(obtain);
            return;
        }
        p.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f40190a);
    }

    public static String a(Context context, String str, String str2) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e2) {
            p.a("CommandWorker", "error  " + e2.getMessage());
            return null;
        }
    }
}
