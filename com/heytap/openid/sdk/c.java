package com.heytap.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.heytap.openid.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public com.heytap.openid.a f31380a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f31381b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f31382c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f31383d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f31384e = new a();

    /* loaded from: classes6.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.this.f31380a = a.AbstractBinderC0361a.a(iBinder);
            synchronized (c.this.f31383d) {
                c.this.f31383d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.f31380a = null;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final c f31386a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
    }

    public synchronized String a(Context context, String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.f31380a != null) {
                try {
                    return b(context, str);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.f31384e, 1)) {
                synchronized (this.f31383d) {
                    try {
                        this.f31383d.wait(3000L);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            if (this.f31380a == null) {
                return "";
            }
            try {
                return b(context, str);
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return "";
            }
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }

    public boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode >= 1;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f31381b)) {
            this.f31381b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f31382c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f31381b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                }
            }
            this.f31382c = str2;
        }
        String a2 = ((a.AbstractBinderC0361a.C0362a) this.f31380a).a(this.f31381b, this.f31382c, str);
        return TextUtils.isEmpty(a2) ? "" : a2;
    }
}
