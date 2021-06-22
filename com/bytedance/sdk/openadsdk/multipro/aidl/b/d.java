package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes6.dex */
public class d extends IRewardAdInteractionListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f29795a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f29796b = new Handler(Looper.getMainLooper());

    public d(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f29795a = rewardAdInteractionListener;
    }

    private Handler b() {
        Handler handler = this.f29796b;
        if (handler == null) {
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.f29796b = handler2;
            return handler2;
        }
        return handler;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f29795a != null) {
                    d.this.f29795a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f29795a != null) {
                    d.this.f29795a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f29795a != null) {
                    d.this.f29795a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(final boolean z, final int i2, final String str, final int i3, final String str2) throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f29795a != null) {
                    d.this.f29795a.onRewardVerify(z, i2, str, i3, str2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f29795a != null) {
                    d.this.f29795a.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f29795a != null) {
                    d.this.f29795a.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoError() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f29795a != null) {
                    d.this.f29795a.onVideoError();
                }
            }
        });
    }

    private void a() {
        this.f29795a = null;
        this.f29796b = null;
    }
}
