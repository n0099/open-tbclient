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
/* loaded from: classes8.dex */
public class ba implements at {
    public static boolean a;

    /* renamed from: a  reason: collision with other field name */
    public Context f134a;

    /* renamed from: a  reason: collision with other field name */
    public ServiceConnection f135a;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f133a = 0;

    /* renamed from: a  reason: collision with other field name */
    public volatile a f136a = null;

    /* renamed from: a  reason: collision with other field name */
    public final Object f137a = new Object();

    /* loaded from: classes8.dex */
    public class a {

        /* renamed from: a  reason: collision with other field name */
        public String f138a;
        public String b;
        public String c;
        public String d;

        public a() {
            this.f138a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (ba.this.f136a != null) {
                return;
            }
            new Thread(new bc(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes8.dex */
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
        this.f134a = context;
        a();
    }

    private void a() {
        boolean z;
        this.f135a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            z = this.f134a.bindService(intent, this.f135a, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f133a = z ? 1 : 2;
    }

    private void a(String str) {
        if (this.f133a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f137a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m99a("oppo's " + str + " wait...");
                this.f137a.wait(3000L);
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
            Signature[] signatureArr = this.f134a.getPackageManager().getPackageInfo(this.f134a.getPackageName(), 64).signatures;
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
    public void m205b() {
        ServiceConnection serviceConnection = this.f135a;
        if (serviceConnection != null) {
            try {
                this.f134a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public String mo184a() {
        a("getOAID");
        if (this.f136a == null) {
            return null;
        }
        return this.f136a.b;
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public boolean mo185a() {
        return a;
    }
}
