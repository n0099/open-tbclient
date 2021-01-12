package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.z;
/* loaded from: classes3.dex */
public class c implements NSPVI {

    /* renamed from: a  reason: collision with root package name */
    private NSPVI f12503a;

    /* renamed from: b  reason: collision with root package name */
    private String f12504b;

    public c(Context context, String str, String str2) {
        if (com.qq.e.comm.plugin.r.a.d.a(context).b(str2)) {
            this.f12503a = new d(context, str, str2);
        } else {
            this.f12503a = new b(context, str, str2);
        }
        this.f12504b = str2;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAdOnly() {
        ai.a("gdt_tag_callback", "fetchAdOnly()");
        this.f12503a.fetchAdOnly();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        ai.a("gdt_tag_callback", "fetchAndShowIn(container)");
        this.f12503a.fetchAndShowIn(viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getAdNetWorkName() {
        ai.a("gdt_tag_callback", "getAdNetWorkName()");
        return this.f12503a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getECPMLevel() {
        return this.f12503a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void preload() {
        ai.a("gdt_tag_callback", "preload()");
        this.f12503a.preload();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdListener(ADListener aDListener) {
        ai.a("gdt_tag_callback", "setAdListener(listener)");
        this.f12503a.setAdListener(aDListener);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdLogoMargin(int i, int i2) {
        ai.a("gdt_tag_callback", "setAdLogoMargin(topMargin, leftMargin)");
        this.f12503a.setAdLogoMargin(i, i2);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFetchDelay(int i) {
        ai.a("gdt_tag_callback", "setFetchDelay(fetchDelay)");
        this.f12503a.setFetchDelay(i);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFloatView(View view) {
        ai.a("gdt_tag_callback", "setFloatView(view)");
        this.f12503a.setFloatView(view);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        ai.a("gdt_tag_callback", "setLoadAdParams(params)");
        this.f12503a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setPreloadView(View view) {
        ai.a("gdt_tag_callback", "setPreloadView(view)");
        this.f12503a.setPreloadView(view);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSkipView(View view) {
        ai.a("gdt_tag_callback", "setSkipView(view)");
        this.f12503a.setSkipView(view);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showAd(ViewGroup viewGroup) {
        ai.a("gdt_tag_callback", "showAd(container)");
        z.a().a(this.f12504b);
        this.f12503a.showAd(viewGroup);
    }
}
