package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class ay implements ar {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41109a;

    /* renamed from: a  reason: collision with other field name */
    public Context f137a;

    /* renamed from: a  reason: collision with other field name */
    public ServiceConnection f138a;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f136a = 0;

    /* renamed from: a  reason: collision with other field name */
    public volatile a f139a = null;

    /* renamed from: a  reason: collision with other field name */
    public final Object f140a = new Object();

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        public String f141a;

        /* renamed from: b  reason: collision with root package name */
        public String f41111b;

        /* renamed from: c  reason: collision with root package name */
        public String f41112c;

        /* renamed from: d  reason: collision with root package name */
        public String f41113d;

        public a() {
            this.f141a = null;
            this.f41111b = null;
            this.f41112c = null;
            this.f41113d = null;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (ay.this.f139a != null) {
                return;
            }
            new Thread(new ba(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public ay(Context context) {
        this.f137a = context;
        a();
    }

    private void a() {
        boolean z;
        this.f138a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            z = this.f137a.bindService(intent, this.f138a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f136a = z ? 1 : 2;
    }

    private void a(String str) {
        if (this.f136a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f140a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m56a("oppo's " + str + " wait...");
                this.f140a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                f41109a = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f138a;
        if (serviceConnection != null) {
            try {
                this.f137a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        try {
            Signature[] signatureArr = this.f137a.getPackageManager().getPackageInfo(this.f137a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        a("getUDID");
        if (this.f139a == null) {
            return null;
        }
        return this.f139a.f141a;
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return f41109a;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo135b() {
        a("getOAID");
        if (this.f139a == null) {
            return null;
        }
        return this.f139a.f41111b;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        a("getVAID");
        if (this.f139a == null) {
            return null;
        }
        return this.f139a.f41112c;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        a("getAAID");
        if (this.f139a == null) {
            return null;
        }
        return this.f139a.f41113d;
    }
}
