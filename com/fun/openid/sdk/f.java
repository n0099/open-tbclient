package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.fun.openid.sdk.g;
import com.fun.openid.sdk.h;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class f implements h {

    /* loaded from: classes3.dex */
    public static final class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5244a = false;
        public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>();

        public IBinder a() {
            if (this.f5244a) {
                throw new IllegalStateException();
            }
            this.f5244a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    @Override // com.fun.openid.sdk.h
    public void a(Context context, h.a aVar) {
        a aVar2 = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            if (!context.bindService(intent, aVar2, 1)) {
                ((g.a) aVar).a(false, null);
                return;
            }
            try {
                IBinder a2 = aVar2.a();
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    a2.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    ((g.a) aVar).a(true, obtain2.readString());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            } catch (Exception e) {
                e.printStackTrace();
                ((g.a) aVar).a(true, null);
            }
        } finally {
            context.unbindService(aVar2);
        }
    }
}
