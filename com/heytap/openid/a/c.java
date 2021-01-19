package com.heytap.openid.a;

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
import com.baidu.android.imsdk.internal.IMConnection;
import com.heytap.openid.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
public class c {
    public com.heytap.openid.a pNk = null;

    /* renamed from: b  reason: collision with root package name */
    public String f7903b = null;
    public String c = null;
    public final Object d = new Object();
    public ServiceConnection pbD = new a();

    /* loaded from: classes5.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.this.pNk = a.AbstractBinderC1056a.a(iBinder);
            synchronized (c.this.d) {
                c.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c.this.pNk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {
        public static final c pNl = new c(null);
    }

    public /* synthetic */ c(a aVar) {
    }

    public synchronized String a(Context context, String str) {
        String str2;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.pNk == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.pbD, 1)) {
                    synchronized (this.d) {
                        try {
                            this.d.wait(IMConnection.RETRY_DELAY_TIMES);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (this.pNk == null) {
                    str2 = "";
                } else {
                    try {
                        str2 = b(context, str);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        str2 = "";
                    }
                }
            } else {
                try {
                    str2 = b(context, str);
                } catch (RemoteException e3) {
                    e3.printStackTrace();
                    str2 = "";
                }
            }
        }
        throw new IllegalStateException("Cannot run on MainThread");
        return str2;
    }

    public boolean a(Context context) {
        boolean z = true;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT >= 28) {
                if (packageInfo == null || packageInfo.getLongVersionCode() < 1) {
                    z = false;
                }
            } else if (packageInfo == null || packageInfo.versionCode < 1) {
                z = false;
            }
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        String str2 = null;
        if (TextUtils.isEmpty(this.f7903b)) {
            this.f7903b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.c)) {
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f7903b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
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
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
            }
            this.c = str2;
        }
        String a2 = ((a.AbstractBinderC1056a.C1057a) this.pNk).a(this.f7903b, this.c, str);
        return TextUtils.isEmpty(a2) ? "" : a2;
    }
}
