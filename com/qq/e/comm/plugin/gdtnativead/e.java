package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.util.ai;
/* loaded from: classes15.dex */
public class e implements NEADI {

    /* renamed from: a  reason: collision with root package name */
    NEADI f12017a;

    public e(Context context, ADSize aDSize, String str, String str2, ADListener aDListener) {
        if (!com.qq.e.comm.plugin.r.a.d.a(context).b(str2) || SDKStatus.getSDKVersionCode() < 80) {
            this.f12017a = new f(context, aDSize, str, str2, aDListener);
        } else {
            this.f12017a = new g(context, aDSize, str, str2, aDListener);
        }
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        ai.a("gdt_tag_callback", "loadUrl(count)");
        this.f12017a.loadAd(i);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i, LoadAdParams loadAdParams) {
        ai.a("gdt_tag_callback", "loadUrl(count, params)");
        this.f12017a.loadAd(i, loadAdParams);
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setBrowserType(int i) {
        ai.a("gdt_tag_callback", "setBrowserType(value)");
        this.f12017a.setBrowserType(i);
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        ai.a("gdt_tag_callback", "setDownAPPConfirmPolicy(policy)");
        this.f12017a.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMaxVideoDuration(int i) {
        ai.a("gdt_tag_callback", "setMaxVideoDuration(maxVideoDuration)");
        this.f12017a.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMinVideoDuration(int i) {
        ai.a("gdt_tag_callback", "setMinVideoDuration(minVideoDuration)");
        this.f12017a.setMinVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoOption(VideoOption videoOption) {
        ai.a("gdt_tag_callback", "setVideoOption(videoOption)");
        this.f12017a.setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoPlayPolicy(int i) {
        ai.a("gdt_tag_callback", "setVideoPlayPolicy(videoPlayPolicy)");
        this.f12017a.setVideoPlayPolicy(i);
    }
}
