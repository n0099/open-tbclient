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
    UIADI f12105a;

    /* renamed from: b  reason: collision with root package name */
    private String f12106b;

    public d(Activity activity, String str, String str2, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        if (!com.qq.e.comm.plugin.r.a.d.a(activity).b(str2) || SDKStatus.getSDKVersionCode() < 70) {
            this.f12105a = new e(activity, str, str2, unifiedInterstitialADListener);
        } else {
            this.f12105a = new f(activity, str, str2, unifiedInterstitialADListener);
        }
        this.f12106b = str2;
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void close() {
        ai.a("gdt_tag_callback", "close()");
        this.f12105a.close();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void destory() {
        ai.a("gdt_tag_callback", "destory()");
        this.f12105a.destory();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getAdNetWorkName() {
        ai.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f12105a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getAdPatternType() {
        ai.a("gdt_tag_callback", "getAdPatternType()");
        return this.f12105a.getAdPatternType();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public int getECPM() {
        ai.a("gdt_tag_callback", "getECPM()");
        return this.f12105a.getECPM();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public String getECPMLevel() {
        ai.a("gdt_tag_callback", "getECPMLevel()");
        return this.f12105a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public boolean isValid() {
        ai.a("gdt_tag_callback", "isValid()");
        return this.f12105a.isValid();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadAd() {
        ai.a("gdt_tag_callback", "loadAd()");
        this.f12105a.loadAd();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void loadFullScreenAD() {
        ai.a("gdt_tag_callback", "loadFullScreenAD()");
        this.f12105a.loadFullScreenAD();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        ai.a("gdt_tag_callback", "setDownAPPConfirmPolicy(policy)");
        this.f12105a.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMaxVideoDuration(int i) {
        ai.a("gdt_tag_callback", "setMaxVideoDuration(maxVideoDuration)");
        this.f12105a.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        ai.a("gdt_tag_callback", "setMediaListener(listener)");
        this.f12105a.setMediaListener(unifiedInterstitialMediaListener);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setMinVideoDuration(int i) {
        ai.a("gdt_tag_callback", "setMinVideoDuration(minVideoDuration)");
        this.f12105a.setMinVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoOption(VideoOption videoOption) {
        ai.a("gdt_tag_callback", "setVideoOption(videoOption)");
        this.f12105a.setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void setVideoPlayPolicy(int i) {
        ai.a("gdt_tag_callback", "setVideoPlayPolicy(videoPlayPolicy)");
        this.f12105a.setVideoPlayPolicy(i);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show() {
        ai.a("gdt_tag_callback", "show()");
        z.a().a(this.f12106b);
        this.f12105a.show();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void show(Activity activity) {
        ai.a("gdt_tag_callback", "show(activity)");
        z.a().a(this.f12106b);
        this.f12105a.show(activity);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showAsPopupWindow() {
        ai.a("gdt_tag_callback", "showAsPopupWindow()");
        z.a().a(this.f12106b);
        this.f12105a.showAsPopupWindow();
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showAsPopupWindow(Activity activity) {
        ai.a("gdt_tag_callback", "showAsPopupWindow(activity)");
        z.a().a(this.f12106b);
        this.f12105a.showAsPopupWindow(activity);
    }

    @Override // com.qq.e.comm.pi.UIADI
    public void showFullScreenAD(Activity activity) {
        ai.a("gdt_tag_callback", "showFullScreenAD(activity)");
        z.a().a(this.f12106b);
        this.f12105a.showFullScreenAD(activity);
    }
}
