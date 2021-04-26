package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
/* loaded from: classes5.dex */
public class e extends ITTAppDownloadListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    public volatile TTAppDownloadListener f30450a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f30451b = new Handler(Looper.getMainLooper());

    public e(TTAppDownloadListener tTAppDownloadListener) {
        this.f30450a = tTAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return this.f30450a != null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadActive(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f30450a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.2
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f30450a.onDownloadActive(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFailed(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f30450a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.4
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f30450a.onDownloadFailed(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFinished(final long j, final String str, final String str2) throws RemoteException {
        if (this.f30450a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.5
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f30450a.onDownloadFinished(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadPaused(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f30450a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f30450a.onDownloadPaused(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onIdle() throws RemoteException {
        if (this.f30450a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f30450a.onIdle();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onInstalled(final String str, final String str2) throws RemoteException {
        if (this.f30450a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.6
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f30450a.onInstalled(str, str2);
                    }
                }
            });
        }
    }

    private Handler b() {
        Handler handler = this.f30451b;
        if (handler == null) {
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.f30451b = handler2;
            return handler2;
        }
        return handler;
    }

    public void a() {
        this.f30450a = null;
        this.f30451b = null;
    }
}
