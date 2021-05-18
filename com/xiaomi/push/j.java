package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class j {

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f38042a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f809a;

        public a(String str, boolean z) {
            this.f38042a = str;
            this.f809a = z;
        }

        public String a() {
            return this.f38042a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f38043a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f810a;

        public b() {
            this.f810a = false;
            this.f38043a = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (this.f810a) {
                throw new IllegalStateException();
            }
            this.f810a = true;
            return this.f38043a.poll(StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f38043a.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        public IBinder f38044a;

        public c(IBinder iBinder) {
            this.f38044a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f38044a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f38044a;
        }
    }

    public static a a(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
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
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } finally {
                        context.unbindService(bVar);
                    }
                }
                throw new IOException("Google Play connection failed");
            } catch (Exception e3) {
                throw e3;
            }
        }
        throw new IllegalStateException("Cannot be called from the main thread");
    }
}
