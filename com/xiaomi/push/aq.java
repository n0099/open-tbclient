package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
/* loaded from: classes10.dex */
public class aq implements at {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    public Context f110a;

    /* renamed from: a  reason: collision with other field name */
    public ServiceConnection f111a;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f109a = 0;

    /* renamed from: a  reason: collision with other field name */
    public volatile String f113a = null;

    /* renamed from: b  reason: collision with other field name */
    public volatile boolean f114b = false;
    public volatile String b = null;

    /* renamed from: a  reason: collision with other field name */
    public final Object f112a = new Object();

    /* loaded from: classes10.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            new Thread(new as(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static String a(IBinder iBinder) {
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
        public static boolean m264a(IBinder iBinder) {
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

    public aq(Context context) {
        this.f110a = context;
        a();
    }

    private void a() {
        boolean z;
        this.f111a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            z = this.f110a.bindService(intent, this.f111a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f109a = z ? 1 : 2;
    }

    private void a(String str) {
        if (this.f109a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f112a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m177a("huawei's " + str + " wait...");
                this.f112a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f111a;
        if (serviceConnection != null) {
            try {
                this.f110a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a  reason: collision with other method in class */
    public String mo262a() {
        a("getOAID");
        return this.f113a;
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo263a() {
        return a;
    }
}
