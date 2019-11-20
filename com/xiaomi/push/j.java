package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
final class j {

    /* loaded from: classes3.dex */
    static final class a {
        private final String a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f789a;

        a(String str, boolean z) {
            this.a = str;
            this.f789a = z;
        }

        public String a() {
            return this.a;
        }
    }

    /* loaded from: classes3.dex */
    private static final class b implements ServiceConnection {
        private final LinkedBlockingQueue<IBinder> a;

        /* renamed from: a  reason: collision with other field name */
        boolean f790a;

        private b() {
            this.f790a = false;
            this.a = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (this.f790a) {
                throw new IllegalStateException();
            }
            this.f790a = true;
            return this.a.poll(StatisticConfig.MIN_UPLOAD_INTERVAL, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.a.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes3.dex */
    private static final class c implements IInterface {
        private IBinder a;

        public c(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }
    }

    public static a a(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, bVar, 1)) {
                try {
                    try {
                        IBinder a2 = bVar.a();
                        if (a2 != null) {
                            return new a(new c(a2).a(), false);
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } finally {
                    context.unbindService(bVar);
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Exception e2) {
            throw e2;
        }
    }
}
