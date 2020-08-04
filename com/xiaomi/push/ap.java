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
/* loaded from: classes9.dex */
public class ap implements ar {
    private static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private Context f111a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f112a;

    /* renamed from: a  reason: collision with other field name */
    private volatile int f110a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile String f114a = null;

    /* renamed from: b  reason: collision with other field name */
    private volatile boolean f115b = false;
    private volatile String b = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f113a = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a implements ServiceConnection {
        private a() {
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ap.this.f114a = b.a(iBinder);
                ap.this.f115b = b.m131a(iBinder);
                ap.this.b();
                ap.this.f110a = 2;
                synchronized (ap.this.f113a) {
                    try {
                        ap.this.f113a.notifyAll();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                ap.this.b();
                ap.this.f110a = 2;
                synchronized (ap.this.f113a) {
                    try {
                        ap.this.f113a.notifyAll();
                    } catch (Exception e3) {
                    }
                }
            } catch (Throwable th) {
                ap.this.b();
                ap.this.f110a = 2;
                synchronized (ap.this.f113a) {
                    try {
                        ap.this.f113a.notifyAll();
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

    /* loaded from: classes9.dex */
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
        static boolean m131a(IBinder iBinder) {
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
        this.f111a = context;
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
        this.f112a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        boolean z = false;
        try {
            z = this.f111a.bindService(intent, this.f112a, 1);
        } catch (Exception e) {
        }
        this.f110a = z ? 1 : 2;
    }

    private void a(String str) {
        if (this.f110a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f113a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m49a("huawei's " + str + " wait...");
                this.f113a.wait(3000L);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m129a(Context context) {
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
        if (this.f112a != null) {
            try {
                this.f111a.unbindService(this.f112a);
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
    public String mo130b() {
        a("getOAID");
        return this.f114a;
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
                    this.b = a(this.f111a);
                }
            }
        }
        return this.b;
    }
}
