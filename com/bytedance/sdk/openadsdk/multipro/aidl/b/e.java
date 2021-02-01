package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
/* loaded from: classes6.dex */
public class e extends ITTAppDownloadListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    private volatile TTAppDownloadListener f7387a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f7388b = new Handler(Looper.getMainLooper());

    private Handler b() {
        if (this.f7388b == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.f7388b = handler;
            return handler;
        }
        return this.f7388b;
    }

    public e(TTAppDownloadListener tTAppDownloadListener) {
        this.f7387a = tTAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return this.f7387a != null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onIdle() throws RemoteException {
        if (this.f7387a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f7387a.onIdle();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadActive(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f7387a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.2
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f7387a.onDownloadActive(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadPaused(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f7387a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f7387a.onDownloadPaused(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFailed(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f7387a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.4
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f7387a.onDownloadFailed(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFinished(final long j, final String str, final String str2) throws RemoteException {
        if (this.f7387a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.5
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f7387a.onDownloadFinished(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onInstalled(final String str, final String str2) throws RemoteException {
        if (this.f7387a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.6
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f7387a.onInstalled(str, str2);
                    }
                }
            });
        }
    }

    public void a() {
        this.f7387a = null;
        this.f7388b = null;
    }
}
