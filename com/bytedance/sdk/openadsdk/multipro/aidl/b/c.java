package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
/* loaded from: classes6.dex */
public class c extends IFullScreenVideoAdInteractionListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f29674a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f29675b = new Handler(Looper.getMainLooper());

    public c(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f29674a = fullScreenVideoAdInteractionListener;
    }

    private Handler b() {
        Handler handler = this.f29675b;
        if (handler == null) {
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.f29675b = handler2;
            return handler2;
        }
        return handler;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29674a != null) {
                    c.this.f29674a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29674a != null) {
                    c.this.f29674a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29674a != null) {
                    c.this.f29674a.onAdVideoBarClick();
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
                if (c.this.f29674a != null) {
                    c.this.f29674a.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f29674a != null) {
                    c.this.f29674a.onVideoComplete();
                }
            }
        });
    }

    private void a() {
        this.f29674a = null;
        this.f29675b = null;
    }
}
