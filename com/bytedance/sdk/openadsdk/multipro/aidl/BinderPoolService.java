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
/* loaded from: classes5.dex */
public class BinderPoolService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public Binder f29485a = new a();

    /* loaded from: classes5.dex */
    public static class a extends IBinderPool.Stub {
        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i) throws RemoteException {
            u.c("MultiProcess", "queryBinder...........binderCode=" + i);
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return d.a();
                        }
                        return b.a();
                    }
                    return c.a();
                }
                return e.a();
            }
            return f.a();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        u.b("MultiProcess", "BinderPoolService onBind ! ");
        return this.f29485a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        u.b("MultiProcess", "BinderPoolService has been created ! ");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        u.b("MultiProcess", "BinderPoolService is destroy ! ");
    }
}
