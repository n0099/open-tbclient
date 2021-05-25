package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
/* loaded from: classes6.dex */
public class c extends IFullScreenVideoAdInteractionListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f29603a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f29604b = new Handler(Looper.getMainLooper());

    public c(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f29603a = fullScreenVideoAdInteractionListener;
    }

    private Handler b() {
        Handler handler = this.f29604b;
        if (handler == null) {
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.f29604b = handler2;
            return handler2;
        }
        return handler;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29603a != null) {
                    c.this.f29603a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29603a != null) {
                    c.this.f29603a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29603a != null) {
                    c.this.f29603a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29603a != null) {
                    c.this.f29603a.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29603a != null) {
                    c.this.f29603a.onVideoComplete();
                }
            }
        });
    }

    private void a() {
        this.f29603a = null;
        this.f29604b = null;
    }
}
