package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class d implements f {

    /* loaded from: classes6.dex */
    public static final class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public boolean f30888a = false;

        /* renamed from: b  reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f30889b = new LinkedBlockingQueue<>();

        public IBinder a() {
            if (this.f30888a) {
                throw new IllegalStateException();
            }
            this.f30888a = true;
            return this.f30889b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f30889b.put(iBinder);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    @Override // com.fun.openid.sdk.f
    public void a(Context context, f.a aVar) {
        a aVar2 = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            if (!context.bindService(intent, aVar2, 1)) {
                ((e.a) aVar).a(false, null);
                return;
            }
            try {
                IBinder a2 = aVar2.a();
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                    a2.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    ((e.a) aVar).a(true, obtain2.readString());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                ((e.a) aVar).a(true, null);
            }
        } finally {
            context.unbindService(aVar2);
        }
    }
}
