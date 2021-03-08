package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* loaded from: classes6.dex */
public class d extends IRewardAdInteractionListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    private TTRewardVideoAd.RewardAdInteractionListener f4902a;
    private Handler b = new Handler(Looper.getMainLooper());

    public d(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f4902a = rewardAdInteractionListener;
    }

    private void a() {
        this.f4902a = null;
        this.b = null;
    }

    private Handler b() {
        if (this.b == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.b = handler;
            return handler;
        }
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f4902a != null) {
                    d.this.f4902a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f4902a != null) {
                    d.this.f4902a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f4902a != null) {
                    d.this.f4902a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f4902a != null) {
                    d.this.f4902a.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoError() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f4902a != null) {
                    d.this.f4902a.onVideoError();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f4902a != null) {
                    d.this.f4902a.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f4902a != null) {
                    d.this.f4902a.onRewardVerify(z, i, str, i2, str2);
                }
            }
        });
    }
}
