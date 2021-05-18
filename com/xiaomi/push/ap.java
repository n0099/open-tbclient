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
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes7.dex */
public class ap implements ar {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f37377a;

    /* renamed from: a  reason: collision with other field name */
    public Context f116a;

    /* renamed from: a  reason: collision with other field name */
    public ServiceConnection f117a;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f115a = 0;

    /* renamed from: a  reason: collision with other field name */
    public volatile String f119a = null;

    /* renamed from: b  reason: collision with other field name */
    public volatile boolean f120b = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile String f37378b = null;

    /* renamed from: a  reason: collision with other field name */
    public final Object f118a = new Object();

    /* loaded from: classes7.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ap.this.f119a = b.a(iBinder);
                ap.this.f120b = b.m137a(iBinder);
                ap.this.b();
                ap.this.f115a = 2;
                synchronized (ap.this.f118a) {
                    try {
                        ap.this.f118a.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                ap.this.b();
                ap.this.f115a = 2;
                synchronized (ap.this.f118a) {
                    try {
                        ap.this.f118a.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                ap.this.b();
                ap.this.f115a = 2;
                synchronized (ap.this.f118a) {
                    try {
                        ap.this.f118a.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public static boolean m137a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
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
        this.f116a = context;
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String str;
        String str2;
        String str3 = null;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                str2 = context.createDeviceProtectedStorageContext().getSharedPreferences("aaid", 0).getString("aaid", null);
                if (str2 != null) {
                    return str2;
                }
            } else {
                str2 = null;
            }
        } catch (Exception unused) {
        }
        try {
            str = context.getSharedPreferences("aaid", 0).getString("aaid", null);
        } catch (Exception unused2) {
            str3 = str2;
            str = str3;
            if (str != null) {
            }
        }
        return str != null ? "" : str;
    }

    private void a() {
        boolean z;
        this.f117a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            z = this.f116a.bindService(intent, this.f117a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f115a = z ? 1 : 2;
    }

    private void a(String str) {
        if (this.f115a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f118a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m57a("huawei's " + str + " wait...");
                this.f118a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m135a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            f37377a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f117a;
        if (serviceConnection != null) {
            try {
                this.f116a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return null;
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return f37377a;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b  reason: collision with other method in class */
    public String mo136b() {
        a("getOAID");
        return this.f119a;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return null;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        if (this.f37378b == null) {
            synchronized (this) {
                if (this.f37378b == null) {
                    this.f37378b = a(this.f116a);
                }
            }
        }
        return this.f37378b;
    }
}
