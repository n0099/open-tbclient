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
import com.baidu.android.imsdk.internal.IMConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class ap implements ar {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4567a;

    /* renamed from: a  reason: collision with other field name */
    private Context f107a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f108a;

    /* renamed from: a  reason: collision with other field name */
    private volatile int f106a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile String f110a = null;

    /* renamed from: b  reason: collision with other field name */
    private volatile boolean f111b = false;
    private volatile String b = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f109a = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a implements ServiceConnection {
        private a() {
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ap.this.f110a = b.a(iBinder);
                ap.this.f111b = b.m129a(iBinder);
                ap.this.b();
                ap.this.f106a = 2;
                synchronized (ap.this.f109a) {
                    try {
                        ap.this.f109a.notifyAll();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                ap.this.b();
                ap.this.f106a = 2;
                synchronized (ap.this.f109a) {
                    try {
                        ap.this.f109a.notifyAll();
                    } catch (Exception e3) {
                    }
                }
            } catch (Throwable th) {
                ap.this.b();
                ap.this.f106a = 2;
                synchronized (ap.this.f109a) {
                    try {
                        ap.this.f109a.notifyAll();
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

    /* loaded from: classes18.dex */
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
        static boolean m129a(IBinder iBinder) {
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
        this.f107a = context;
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
        this.f108a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        boolean z = false;
        try {
            z = this.f107a.bindService(intent, this.f108a, 1);
        } catch (Exception e) {
        }
        this.f106a = z ? 1 : 2;
    }

    private void a(String str) {
        if (this.f106a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f109a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m47a("huawei's " + str + " wait...");
                this.f109a.wait(IMConnection.RETRY_DELAY_TIMES);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m127a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
            f4567a = packageInfo.versionCode >= 20602000;
            if (z) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f108a != null) {
            try {
                this.f107a.unbindService(this.f108a);
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
        return f4567a;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b  reason: collision with other method in class */
    public String mo128b() {
        a("getOAID");
        return this.f110a;
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
                    this.b = a(this.f107a);
                }
            }
        }
        return this.b;
    }
}
