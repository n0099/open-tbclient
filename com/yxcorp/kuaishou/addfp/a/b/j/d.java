package com.yxcorp.kuaishou.addfp.a.b.j;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class d {
    private static String e = "com.mdid.msa";
    private Context d;
    private com.yxcorp.kuaishou.addfp.a.b.b qlC;
    public a qlV = null;

    /* renamed from: b  reason: collision with root package name */
    private String f14379b = null;
    private CountDownLatch f = new CountDownLatch(1);
    private ServiceConnection g = new e(this);

    private void a(boolean z) {
        try {
            if (z) {
                this.qlC.a(this.qlV);
            } else {
                this.qlC.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    private static boolean b(Context context) {
        try {
            context.getPackageManager().getPackageInfo(e, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    public static d eJy() {
        d dVar;
        dVar = f.qlW;
        return dVar;
    }

    public final String a() {
        try {
            if (this.qlV != null) {
                return this.qlV.a();
            }
        } catch (RemoteException e2) {
        }
        return null;
    }

    public final void a(Context context) {
        try {
            if (this.g != null && context != null) {
                context.unbindService(this.g);
            }
            if (this.qlV != null) {
                this.qlV.c();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.qlC = bVar;
            this.d = context;
            if (b(context)) {
                String packageName = context.getPackageName();
                Intent intent = new Intent();
                intent.setClassName(e, "com.mdid.msa.service.MsaKlService");
                intent.setAction("com.bun.msa.action.start.service");
                intent.putExtra("com.bun.msa.param.pkgname", packageName);
                try {
                    intent.putExtra("com.bun.msa.param.runinset", true);
                    if (context.startService(intent) == null) {
                    }
                } catch (Exception e2) {
                    com.yxcorp.kuaishou.addfp.android.b.b.a(e2);
                }
            }
            Intent intent2 = new Intent();
            intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent2.setAction("com.bun.msa.action.bindto.service");
            intent2.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
            if (!context.bindService(intent2, this.g, 1)) {
                com.yxcorp.kuaishou.addfp.android.b.b.b("zte off");
                a(false);
                return;
            }
            this.f.await(2000L, TimeUnit.MILLISECONDS);
            if (this.qlV != null) {
                a(true);
            } else {
                a(false);
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            a(false);
        }
    }

    public final boolean c() {
        try {
            if (this.qlV == null) {
                return false;
            }
            return this.qlV.b();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return false;
        }
    }
}
