package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.z;
/* loaded from: classes3.dex */
public class i implements RVADI {

    /* renamed from: a  reason: collision with root package name */
    private RVADI f12706a;

    /* renamed from: b  reason: collision with root package name */
    private String f12707b;

    public i(Context context, String str, String str2, ADListener aDListener) {
        if (com.qq.e.comm.plugin.r.a.d.a(context).b(str2)) {
            this.f12706a = new k(context, str, str2, aDListener);
        } else {
            this.f12706a = new j(context, str, str2, aDListener);
        }
        this.f12707b = str2;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getAdNetWorkName() {
        ai.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f12706a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getECPM() {
        ai.a("gdt_tag_callback", "getECPM()");
        return this.f12706a.getECPM();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getECPMLevel() {
        ai.a("gdt_tag_callback", "getECPMLevel()");
        return this.f12706a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public long getExpireTimestamp() {
        ai.a("gdt_tag_callback", "getExpireTimestamp()");
        return this.f12706a.getExpireTimestamp();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getRewardAdType() {
        ai.a("gdt_tag_callback", "getRewardAdType()");
        return this.f12706a.getRewardAdType();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getVideoDuration() {
        ai.a("gdt_tag_callback", "getVideoDuration()");
        return this.f12706a.getVideoDuration();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public boolean hasShown() {
        ai.a("gdt_tag_callback", "hasShown()");
        return this.f12706a.hasShown();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void loadAD() {
        ai.a("gdt_tag_callback", "loadAD()");
        this.f12706a.loadAD();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        ai.a("gdt_tag_callback", "setLoadAdParams(loadAdParams)");
        this.f12706a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setVolumeOn(boolean z) {
        ai.a("gdt_tag_callback", "setVolumeOn(volumeOn)");
        this.f12706a.setVolumeOn(z);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD() {
        ai.a("gdt_tag_callback", "showAD()");
        z.a().a(this.f12707b);
        this.f12706a.showAD();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD(Activity activity) {
        ai.a("gdt_tag_callback", "showAD(activity)");
        z.a().a(this.f12707b);
        this.f12706a.showAD(activity);
    }
}
