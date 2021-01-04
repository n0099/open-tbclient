package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.util.ai;
import java.util.List;
/* loaded from: classes3.dex */
public class j implements NUADI {

    /* renamed from: a  reason: collision with root package name */
    private NUADI f12612a;

    public j(Context context, String str, String str2, ADListener aDListener) {
        if (com.qq.e.comm.plugin.r.a.d.a(context).b(str2)) {
            this.f12612a = new k(context, str, str2, aDListener);
        } else {
            this.f12612a = new i(context, str, str2, aDListener);
        }
    }

    @Override // com.qq.e.comm.pi.NUADI
    public String getAdNetWorkName() {
        ai.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f12612a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i) {
        ai.a("gdt_tag_callback", "loadData(count)");
        this.f12612a.loadData(i);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i, LoadAdParams loadAdParams) {
        ai.a("gdt_tag_callback", "loadData(count, params)");
        this.f12612a.loadData(i, loadAdParams);
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setBrowserType(int i) {
        ai.a("gdt_tag_callback", "setBrowserType(value)");
        this.f12612a.setBrowserType(i);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setCategories(List<String> list) {
        ai.a("gdt_tag_callback", "setCategories(categories)");
        this.f12612a.setCategories(list);
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        ai.a("gdt_tag_callback", "setDownAPPConfirmPolicy(policy)");
        this.f12612a.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMaxVideoDuration(int i) {
        ai.a("gdt_tag_callback", "setMaxVideoDuration(maxVideoDuration)");
        this.f12612a.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMinVideoDuration(int i) {
        ai.a("gdt_tag_callback", "setMinVideoDuration(minVideoDuration)");
        this.f12612a.setMinVideoDuration(i);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVastClassName(String str) {
        ai.a("gdt_tag_callback", "setVastClassName(className)");
        this.f12612a.setVastClassName(str);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVideoADContainerRender(int i) {
        ai.a("gdt_tag_callback", "setVideoADContainerRender(videoADContainerRender)");
        this.f12612a.setVideoADContainerRender(i);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVideoPlayPolicy(int i) {
        ai.a("gdt_tag_callback", "setVideoPlayPolicy(videoPlayPolicy)");
        this.f12612a.setVideoPlayPolicy(i);
    }
}
