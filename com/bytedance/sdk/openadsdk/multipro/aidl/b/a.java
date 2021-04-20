package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes5.dex */
public class a extends ICommonDialogListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    public Handler f29506a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public g.a f29507b;

    public a(g.a aVar) {
        this.f29507b = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonDialogListener
    public void onDialogBtnNo() throws RemoteException {
        u.b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogBtnNo");
        a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f29507b != null) {
                    a.this.f29507b.b();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonDialogListener
    public void onDialogBtnYes() throws RemoteException {
        u.b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogBtnYes");
        a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f29507b != null) {
                    a.this.f29507b.a();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ICommonDialogListener
    public void onDialogCancel() throws RemoteException {
        u.b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogCancel");
        a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f29507b != null) {
                    a.this.f29507b.c();
                }
            }
        });
    }

    private void a(Runnable runnable) {
        this.f29506a.post(runnable);
    }
}
