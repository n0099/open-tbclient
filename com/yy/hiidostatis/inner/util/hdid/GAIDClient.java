package com.yy.hiidostatis.inner.util.hdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes8.dex */
public class GAIDClient {
    public static AdInfo mAdInfo;

    /* loaded from: classes8.dex */
    public static final class AdInfo {
        public final String advertisingId;
        public final boolean limitAdTrackingEnabled;

        public AdInfo(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTrackingEnabled = z;
        }

        public String getId() {
            return this.advertisingId;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    /* loaded from: classes8.dex */
    public static final class AdvertisingConnection implements ServiceConnection {
        public final LinkedBlockingQueue<IBinder> queue;
        public boolean retrieved;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        public AdvertisingConnection() {
            this.retrieved = false;
            this.queue = new LinkedBlockingQueue<>(1);
        }

        public IBinder getBinder() throws InterruptedException {
            if (!this.retrieved) {
                this.retrieved = true;
                return this.queue.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.queue.put(iBinder);
            } catch (InterruptedException e) {
                L.debug(this, e.getMessage(), new Object[0]);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class AdvertisingInterface implements IInterface {
        public IBinder binder;

        public AdvertisingInterface(IBinder iBinder) {
            this.binder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.binder;
        }

        public String getId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isLimitAdTrackingEnabled(boolean z) throws RemoteException {
            int i;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z2 = true;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                obtain.writeInt(i);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                return z2;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, CONSTRUCTOR, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static AdInfo getAdvertisingIdInfo(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                AdvertisingConnection advertisingConnection = new AdvertisingConnection();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, advertisingConnection, 1)) {
                    try {
                        AdvertisingInterface advertisingInterface = new AdvertisingInterface(advertisingConnection.getBinder());
                        return new AdInfo(advertisingInterface.getId(), advertisingInterface.isLimitAdTrackingEnabled(true));
                    } finally {
                    }
                } else {
                    throw new IOException("Google Play connection failed");
                }
            } finally {
                Exception exc = new Exception(th);
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    public static AdInfo getAdvertisingIdInfoReflect(Context context) {
        try {
            Object invoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
            if (invoke != null) {
                Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                return new AdInfo((String) cls.getMethod("getId", new Class[0]).invoke(invoke, new Object[0]), ((Boolean) cls.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, null)).booleanValue());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AdInfo init(Context context) {
        AdInfo adInfo;
        try {
            adInfo = getAdvertisingIdInfoReflect(context);
            try {
                if (adInfo == null) {
                    adInfo = getAdvertisingIdInfo(context);
                    if (adInfo != null) {
                        L.brief("getAdvertisingIdInfo succeed. gaid=%s,isLimitAdTrackingEnabled=%b", adInfo.getId(), Boolean.valueOf(adInfo.isLimitAdTrackingEnabled()));
                    }
                } else {
                    L.brief("getAdvertisingIdInfoReflect succeed. gaid=%s,isLimitAdTrackingEnabled=%b", adInfo.getId(), Boolean.valueOf(adInfo.isLimitAdTrackingEnabled()));
                }
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                if (adInfo != null) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            adInfo = null;
        }
        if (adInfo != null) {
            L.brief("get gaid failed, create null AdInfo ", new Object[0]);
            return new AdInfo(null, false);
        }
        return adInfo;
    }

    public static String getGAID(Context context) {
        AdInfo adInfo = mAdInfo;
        if (adInfo != null) {
            return adInfo.getId();
        }
        synchronized (GAIDClient.class) {
            if (mAdInfo != null) {
                return mAdInfo.advertisingId;
            }
            AdInfo init = init(context);
            mAdInfo = init;
            return init.getId();
        }
    }
}
