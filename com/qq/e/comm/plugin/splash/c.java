package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.z;
/* loaded from: classes15.dex */
public class c implements NSPVI {

    /* renamed from: a  reason: collision with root package name */
    private NSPVI f12505a;

    /* renamed from: b  reason: collision with root package name */
    private String f12506b;

    public c(Context context, String str, String str2) {
        if (com.qq.e.comm.plugin.r.a.d.a(context).b(str2)) {
            this.f12505a = new d(context, str, str2);
        } else {
            this.f12505a = new b(context, str, str2);
        }
        this.f12506b = str2;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAdOnly() {
        ai.a("gdt_tag_callback", "fetchAdOnly()");
        this.f12505a.fetchAdOnly();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        ai.a("gdt_tag_callback", "fetchAndShowIn(container)");
        this.f12505a.fetchAndShowIn(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getAdNetWorkName() {
        ai.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f12505a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getECPMLevel() {
        return this.f12505a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void preload() {
        ai.a("gdt_tag_callback", "preload()");
        this.f12505a.preload();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdListener(ADListener aDListener) {
        ai.a("gdt_tag_callback", "setAdListener(listener)");
        this.f12505a.setAdListener(aDListener);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdLogoMargin(int i, int i2) {
        ai.a("gdt_tag_callback", "setAdLogoMargin(topMargin, leftMargin)");
        this.f12505a.setAdLogoMargin(i, i2);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFetchDelay(int i) {
        ai.a("gdt_tag_callback", "setFetchDelay(fetchDelay)");
        this.f12505a.setFetchDelay(i);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFloatView(View view) {
        ai.a("gdt_tag_callback", "setFloatView(view)");
        this.f12505a.setFloatView(view);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        ai.a("gdt_tag_callback", "setLoadAdParams(params)");
        this.f12505a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setPreloadView(View view) {
        ai.a("gdt_tag_callback", "setPreloadView(view)");
        this.f12505a.setPreloadView(view);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSkipView(View view) {
        ai.a("gdt_tag_callback", "setSkipView(view)");
        this.f12505a.setSkipView(view);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showAd(ViewGroup viewGroup) {
        ai.a("gdt_tag_callback", "showAd(container)");
        z.a().a(this.f12506b);
        this.f12505a.showAd(viewGroup);
    }
}
