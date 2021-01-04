package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.b;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.c;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.f;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes4.dex */
public class BinderPoolService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private Binder f7642a = new a();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        u.b("MultiProcess", "BinderPoolService has been created ! ");
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        u.b("MultiProcess", "BinderPoolService onBind ! ");
        return this.f7642a;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        u.b("MultiProcess", "BinderPoolService is destroy ! ");
    }

    /* loaded from: classes4.dex */
    public static class a extends IBinderPool.Stub {
        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i) throws RemoteException {
            u.c("MultiProcess", "queryBinder...........binderCode=" + i);
            switch (i) {
                case 0:
                    return f.a();
                case 1:
                    return e.a();
                case 2:
                    return c.a();
                case 3:
                    return b.a();
                case 4:
                    return d.a();
                default:
                    return null;
            }
        }
    }
}
