package com.huawei.android.hms.pps;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Keep;
import com.huawei.android.hms.pps.a.a;
import com.huawei.android.hms.pps.a.b;
import java.io.IOException;
@Keep
/* loaded from: classes6.dex */
public class AdvertisingIdClient {

    @Keep
    /* loaded from: classes6.dex */
    public static final class Info {
        public final String advertisingId;
        public final boolean limitAdTrackingEnabled;

        public Info(String str, boolean z) {
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
        String tag = getTag();
        Log.i(tag, "getAdvertisingIdInfo " + System.currentTimeMillis());
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
                    try {
                        if (aVar.f31387a) {
                            throw new IllegalStateException();
                        }
                        aVar.f31387a = true;
                        b.a.C0363a c0363a = new b.a.C0363a(aVar.f31388b.take());
                        return new Info(c0363a.a(), c0363a.b());
                    } catch (RemoteException unused) {
                        Log.e(getTag(), "bind hms service RemoteException");
                        throw new IOException("bind hms service RemoteException");
                    }
                } catch (InterruptedException unused2) {
                    Log.e(getTag(), "bind hms service InterruptedException");
                    throw new IOException("bind hms service InterruptedException");
                }
            } finally {
                context.unbindService(aVar);
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w(getTag(), "HMS not found");
            throw new IOException("Service not found");
        }
    }

    public static String getTag() {
        return "AdId";
    }
}
