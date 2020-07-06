package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ap implements ar {
    private static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private Context f112a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f113a;

    /* renamed from: a  reason: collision with other field name */
    private volatile int f111a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile String f115a = null;

    /* renamed from: b  reason: collision with other field name */
    private volatile boolean f116b = false;
    private volatile String b = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f114a = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements ServiceConnection {
        private a() {
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ap.this.f115a = b.a(iBinder);
                ap.this.f116b = b.m130a(iBinder);
                ap.this.b();
                ap.this.f111a = 2;
                synchronized (ap.this.f114a) {
                    try {
                        ap.this.f114a.notifyAll();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                ap.this.b();
                ap.this.f111a = 2;
                synchronized (ap.this.f114a) {
                    try {
                        ap.this.f114a.notifyAll();
                    } catch (Exception e3) {
                    }
                }
            } catch (Throwable th) {
                ap.this.b();
                ap.this.f111a = 2;
                synchronized (ap.this.f114a) {
                    try {
                        ap.this.f114a.notifyAll();
                    } catch (Exception e4) {
                    }
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes8.dex */
    private static class b {
        static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        static boolean m130a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public ap(Context context) {
        this.f112a = context;
        a();
    }

    private static String a(Context context) {
        String string;
        String str = null;
        if (Build.VERSION.SDK_INT < 24 || (string = context.createDeviceProtectedStorageContext().getSharedPreferences("aaid", 0).getString("aaid", null)) == null) {
            str = context.getSharedPreferences("aaid", 0).getString("aaid", null);
            return str == null ? "" : str;
        }
        return string;
    }

    private void a() {
        this.f113a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        boolean z = false;
        try {
            z = this.f112a.bindService(intent, this.f113a, 1);
        } catch (Exception e) {
        }
        this.f111a = z ? 1 : 2;
    }

    private void a(String str) {
        if (this.f111a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f114a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m48a("huawei's " + str + " wait...");
                this.f114a.wait(3000L);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m128a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
            a = packageInfo.versionCode >= 20602000;
            if (z) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f113a != null) {
            try {
                this.f112a.unbindService(this.f113a);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return null;
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return a;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b  reason: collision with other method in class */
    public String mo129b() {
        a("getOAID");
        return this.f115a;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return null;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    this.b = a(this.f112a);
                }
            }
        }
        return this.b;
    }
}
