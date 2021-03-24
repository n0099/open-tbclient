package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
/* loaded from: classes6.dex */
public class e extends ITTAppDownloadListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    public volatile TTAppDownloadListener f29851a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f29852b = new Handler(Looper.getMainLooper());

    public e(TTAppDownloadListener tTAppDownloadListener) {
        this.f29851a = tTAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return this.f29851a != null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadActive(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f29851a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.2
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f29851a.onDownloadActive(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFailed(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f29851a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.4
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f29851a.onDownloadFailed(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFinished(final long j, final String str, final String str2) throws RemoteException {
        if (this.f29851a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.5
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f29851a.onDownloadFinished(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadPaused(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f29851a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f29851a.onDownloadPaused(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onIdle() throws RemoteException {
        if (this.f29851a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f29851a.onIdle();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onInstalled(final String str, final String str2) throws RemoteException {
        if (this.f29851a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.6
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f29851a.onInstalled(str, str2);
                    }
                }
            });
        }
    }

    private Handler b() {
        Handler handler = this.f29852b;
        if (handler == null) {
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.f29852b = handler2;
            return handler2;
        }
        return handler;
    }

    public void a() {
        this.f29851a = null;
        this.f29852b = null;
    }
}
