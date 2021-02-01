package com.win.opensdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.win.opensdk.java;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes3.dex */
public class as {
    private static final String java = as.class.getSimpleName();

    /* loaded from: classes3.dex */
    public static class a {
        String java;
        private boolean qiQ;

        public a(String str, boolean z) {
            this.java = str;
            this.qiQ = z;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements ServiceConnection {
        private Context qiN;
        boolean qiQ = false;
        final BlockingQueue<IBinder> qki = new LinkedBlockingQueue();

        public b(Context context) {
            this.qiN = context;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.qki.put(iBinder);
                String java = java.AbstractBinderC1277java.java(iBinder).java();
                if (!TextUtils.isEmpty(java)) {
                    az.bI(this.qiN, java);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static a iQ(Context context) {
        Intent intent;
        if (!(RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER)) || Build.VERSION.SDK_INT < 23) {
            return null;
        }
        b bVar = new b(context);
        try {
            intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context.unbindService(bVar);
        }
        if (context.bindService(intent, bVar, 1)) {
            if (bVar.qiQ) {
                throw new IllegalStateException("Binder already consumed");
            }
            IBinder take = bVar.qki.take();
            if (take != null) {
                bVar.qiQ = true;
            }
            java java2 = java.AbstractBinderC1277java.java(take);
            return new a(java2.java(), java2.m78java());
        }
        return null;
    }
}
