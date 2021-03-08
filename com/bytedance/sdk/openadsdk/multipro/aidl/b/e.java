package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
/* loaded from: classes6.dex */
public class e extends ITTAppDownloadListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    private volatile TTAppDownloadListener f4910a;
    private Handler b = new Handler(Looper.getMainLooper());

    private Handler b() {
        if (this.b == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.b = handler;
            return handler;
        }
        return this.b;
    }

    public e(TTAppDownloadListener tTAppDownloadListener) {
        this.f4910a = tTAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return this.f4910a != null;
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onIdle() throws RemoteException {
        if (this.f4910a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f4910a.onIdle();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadActive(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f4910a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.2
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f4910a.onDownloadActive(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadPaused(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f4910a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f4910a.onDownloadPaused(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFailed(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.f4910a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.4
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f4910a.onDownloadFailed(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onDownloadFinished(final long j, final String str, final String str2) throws RemoteException {
        if (this.f4910a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.5
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f4910a.onDownloadFinished(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
    public void onInstalled(final String str, final String str2) throws RemoteException {
        if (this.f4910a != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.e.6
                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.c()) {
                        e.this.f4910a.onInstalled(str, str2);
                    }
                }
            });
        }
    }

    public void a() {
        this.f4910a = null;
        this.b = null;
    }
}
