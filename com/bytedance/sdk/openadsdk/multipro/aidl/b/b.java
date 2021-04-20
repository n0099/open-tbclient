package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.utils.h;
/* loaded from: classes5.dex */
public class b extends ICommonPermissionListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    public Handler f29511a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public h.a f29512b;

    public b(h.a aVar) {
        this.f29512b = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonPermissionListener
    public void onDenied(final String str) throws RemoteException {
        a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f29512b != null) {
                    b.this.f29512b.a(str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonPermissionListener
    public void onGranted() throws RemoteException {
        a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f29512b != null) {
                    b.this.f29512b.a();
                }
            }
        });
    }

    private void a(Runnable runnable) {
        if (this.f29511a == null) {
            this.f29511a = new Handler(Looper.getMainLooper());
        }
        this.f29511a.post(runnable);
    }
}
