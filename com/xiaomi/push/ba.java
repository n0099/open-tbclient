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
import com.heytap.openid.IOpenID;
import java.security.MessageDigest;
/* loaded from: classes10.dex */
public class ba implements at {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    public Context f135a;

    /* renamed from: a  reason: collision with other field name */
    public ServiceConnection f136a;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f134a = 0;

    /* renamed from: a  reason: collision with other field name */
    public volatile a f137a = null;

    /* renamed from: a  reason: collision with other field name */
    public final Object f138a = new Object();

    /* loaded from: classes10.dex */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        public String f139a;
        public String b;
        public String c;
        public String d;

        public a() {
            this.f139a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (ba.this.f137a != null) {
                return;
            }
            new Thread(new bc(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
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

    public ba(Context context) {
        this.f135a = context;
        a();
    }

    private void a() {
        boolean z;
        this.f136a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            z = this.f135a.bindService(intent, this.f136a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f134a = z ? 1 : 2;
    }

    private void a(String str) {
        if (this.f134a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f138a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m180a("oppo's " + str + " wait...");
                this.f138a.wait(3000L);
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
                a = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        try {
            Signature[] signatureArr = this.f135a.getPackageManager().getPackageInfo(this.f135a.getPackageName(), 64).signatures;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b  reason: collision with other method in class */
    public void m286b() {
        ServiceConnection serviceConnection = this.f136a;
        if (serviceConnection != null) {
            try {
                this.f135a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public String mo265a() {
        a("getOAID");
        if (this.f137a == null) {
            return null;
        }
        return this.f137a.b;
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public boolean mo266a() {
        return a;
    }
}
