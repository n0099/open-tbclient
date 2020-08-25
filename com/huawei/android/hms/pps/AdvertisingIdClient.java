package com.huawei.android.hms.pps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.util.Log;
import com.huawei.android.hms.pps.a.a;
import com.huawei.android.hms.pps.a.b;
import java.io.IOException;
@Keep
/* loaded from: classes11.dex */
public class AdvertisingIdClient {

    @Keep
    /* loaded from: classes11.dex */
    public static final class Info {
        private final String advertisingId;
        private final boolean limitAdTrackingEnabled;

        Info(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        @Keep
        public final String getId() {
            return this.advertisingId;
        }

        @Keep
        public final boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    @Keep
    public static Info getAdvertisingIdInfo(Context context) {
        Log.i(getTag(), "getAdvertisingIdInfo " + System.currentTimeMillis());
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.w(getTag(), "Cannot be called from the main thread");
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            a aVar = new a();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (!context.bindService(intent, aVar, 1)) {
                Log.w(getTag(), "bind failed");
                throw new IOException("bind failed");
            }
            Log.i(getTag(), "bind ok");
            try {
                try {
                    if (aVar.a) {
                        throw new IllegalStateException();
                    }
                    aVar.a = true;
                    b.a.C0881a c0881a = new b.a.C0881a(aVar.b.take());
                    return new Info(c0881a.a(), c0881a.b());
                } catch (RemoteException e) {
                    Log.e(getTag(), "bind hms service RemoteException");
                    throw new IOException("bind hms service RemoteException");
                } catch (InterruptedException e2) {
                    Log.e(getTag(), "bind hms service InterruptedException");
                    throw new IOException("bind hms service InterruptedException");
                }
            } finally {
                context.unbindService(aVar);
            }
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w(getTag(), "HMS not found");
            throw new IOException("Service not found");
        }
    }

    private static String getTag() {
        return "AdId";
    }
}
