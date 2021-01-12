package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
/* loaded from: classes4.dex */
public class c extends IFullScreenVideoAdInteractionListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f7368a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f7369b = new Handler(Looper.getMainLooper());

    public c(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f7368a = fullScreenVideoAdInteractionListener;
    }

    private void a() {
        this.f7368a = null;
        this.f7369b = null;
    }

    private Handler b() {
        if (this.f7369b == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.f7369b = handler;
            return handler;
        }
        return this.f7369b;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f7368a != null) {
                    c.this.f7368a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f7368a != null) {
                    c.this.f7368a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f7368a != null) {
                    c.this.f7368a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.4
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f7368a != null) {
                    c.this.f7368a.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f7368a != null) {
                    c.this.f7368a.onSkippedVideo();
                }
            }
        });
    }
}
