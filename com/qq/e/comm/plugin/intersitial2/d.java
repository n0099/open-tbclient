package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.z;
/* loaded from: classes3.dex */
public class d implements UIADI {

    /* renamed from: a  reason: collision with root package name */
    UIADI f12404a;

    /* renamed from: b  reason: collision with root package name */
    private String f12405b;

    public d(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        if (!com.qq.e.comm.plugin.r.a.d.a(activity).b(str2) || SDKStatus.getSDKVersionCode() < 70) {
            this.f12404a = new e(activity, str, str2, unifiedInterstitialADListener);
        } else {
            this.f12404a = new f(activity, str, str2, unifiedInterstitialADListener);
        }
        this.f12405b = str2;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void close() {
        ai.a("gdt_tag_callback", "close()");
        this.f12404a.close();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void destory() {
        ai.a("gdt_tag_callback", "destory()");
        this.f12404a.destory();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getAdNetWorkName() {
        ai.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f12404a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getAdPatternType() {
        ai.a("gdt_tag_callback", "getAdPatternType()");
        return this.f12404a.getAdPatternType();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getECPM() {
        ai.a("gdt_tag_callback", "getECPM()");
        return this.f12404a.getECPM();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getECPMLevel() {
        ai.a("gdt_tag_callback", "getECPMLevel()");
        return this.f12404a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public boolean isValid() {
        ai.a("gdt_tag_callback", "isValid()");
        return this.f12404a.isValid();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadAd() {
        ai.a("gdt_tag_callback", "loadAd()");
        this.f12404a.loadAd();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadFullScreenAD() {
        ai.a("gdt_tag_callback", "loadFullScreenAD()");
        this.f12404a.loadFullScreenAD();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        ai.a("gdt_tag_callback", "setDownAPPConfirmPolicy(policy)");
        this.f12404a.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMaxVideoDuration(int i) {
        ai.a("gdt_tag_callback", "setMaxVideoDuration(maxVideoDuration)");
        this.f12404a.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        ai.a("gdt_tag_callback", "setMediaListener(listener)");
        this.f12404a.setMediaListener(unifiedInterstitialMediaListener);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMinVideoDuration(int i) {
        ai.a("gdt_tag_callback", "setMinVideoDuration(minVideoDuration)");
        this.f12404a.setMinVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoOption(VideoOption videoOption) {
        ai.a("gdt_tag_callback", "setVideoOption(videoOption)");
        this.f12404a.setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoPlayPolicy(int i) {
        ai.a("gdt_tag_callback", "setVideoPlayPolicy(videoPlayPolicy)");
        this.f12404a.setVideoPlayPolicy(i);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show() {
        ai.a("gdt_tag_callback", "show()");
        z.a().a(this.f12405b);
        this.f12404a.show();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show(Activity activity) {
        ai.a("gdt_tag_callback", "show(activity)");
        z.a().a(this.f12405b);
        this.f12404a.show(activity);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showAsPopupWindow() {
        ai.a("gdt_tag_callback", "showAsPopupWindow()");
        z.a().a(this.f12405b);
        this.f12404a.showAsPopupWindow();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showAsPopupWindow(Activity activity) {
        ai.a("gdt_tag_callback", "showAsPopupWindow(activity)");
        z.a().a(this.f12405b);
        this.f12404a.showAsPopupWindow(activity);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showFullScreenAD(Activity activity) {
        ai.a("gdt_tag_callback", "showFullScreenAD(activity)");
        z.a().a(this.f12405b);
        this.f12404a.showFullScreenAD(activity);
    }
}
