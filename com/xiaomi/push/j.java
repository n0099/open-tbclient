package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes18.dex */
final class j {

    /* loaded from: classes18.dex */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f4763a;

        /* renamed from: a  reason: collision with other field name */
        private final boolean f767a;

        a(String str, boolean z) {
            this.f4763a = str;
            this.f767a = z;
        }

        public String a() {
            return this.f4763a;
        }
    }

    /* loaded from: classes18.dex */
    private static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f4764a;

        /* renamed from: a  reason: collision with other field name */
        boolean f768a;

        private b() {
            this.f768a = false;
            this.f4764a = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (this.f768a) {
                throw new IllegalStateException();
            }
            this.f768a = true;
            return this.f4764a.poll(30000L, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f4764a.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes18.dex */
    private static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f4765a;

        public c(IBinder iBinder) {
            this.f4765a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f4765a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f4765a;
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
