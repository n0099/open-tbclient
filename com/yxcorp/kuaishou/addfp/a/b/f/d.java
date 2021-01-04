package com.yxcorp.kuaishou.addfp.a.b.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class d {
    private Context e;
    private com.yxcorp.kuaishou.addfp.a.b.b qeA;
    public a qez = null;

    /* renamed from: b  reason: collision with root package name */
    private String f14658b = null;
    private String c = null;
    private CountDownLatch f = new CountDownLatch(1);
    private ServiceConnection g = new e(this);
    private boolean h = false;

    private void a(boolean z) {
        try {
            if (z) {
                this.qeA.a(this.qez);
            } else {
                this.qeA.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    private static boolean b(Context context) {
        boolean z = true;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT >= 28) {
                if (packageInfo == null || packageInfo.getLongVersionCode() < 1) {
                    z = false;
                }
            } else if (packageInfo == null || packageInfo.versionCode <= 0) {
                z = false;
            }
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(e);
            return false;
        }
    }

    public final String a(Context context, String str) {
        String str2 = null;
        try {
            if (this.h) {
                if (TextUtils.isEmpty(this.f14658b)) {
                    this.f14658b = context.getPackageName();
                }
                if (TextUtils.isEmpty(this.c)) {
                    Signature[] signatureArr = context.getPackageManager().getPackageInfo(this.f14658b, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] byteArray = signatureArr[0].toByteArray();
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : digest) {
                                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    }
                    this.c = str2;
                }
                if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f14658b)) {
                    return "";
                }
                String a2 = this.qez.a(this.f14658b, this.c, str);
                return TextUtils.isEmpty(a2) ? "" : a2;
            }
            return "";
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return "";
        }
    }

    public final void a(Context context) {
        if (this.g == null || context == null) {
            return;
        }
        context.unbindService(this.g);
    }

    public final void a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.qeA = bVar;
            this.e = context;
            this.h = b(context);
            if (this.h) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.g, 1)) {
                    this.f.await(IMConnection.RETRY_DELAY_TIMES, TimeUnit.MILLISECONDS);
                    if (this.qez != null) {
                        a(true);
                    } else {
                        a(false);
                    }
                } else {
                    a(false);
                }
            } else {
                a(false);
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            a(false);
        }
    }

    public final boolean a() {
        return this.h;
    }
}
