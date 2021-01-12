package com.qq.e.comm.plugin.ad;

import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.qq.e.comm.pi.AdData;
/* loaded from: classes3.dex */
public class n implements AdData, com.qq.e.comm.plugin.r.a {

    /* renamed from: a  reason: collision with root package name */
    private p f11902a;

    /* renamed from: b  reason: collision with root package name */
    private AdData.VideoPlayer f11903b;

    public n(p pVar) {
        this.f11902a = pVar == null ? new o() : pVar;
    }

    public void a(AdData.VideoPlayer videoPlayer) {
        this.f11903b = videoPlayer;
    }

    @Override // com.qq.e.comm.pi.AdData
    public boolean equalsAdData(AdData adData) {
        if (this != adData) {
            if (adData == null) {
                return false;
            }
            String property = getProperty(LegoListActivityConfig.AD_ID);
            String property2 = adData.getProperty(LegoListActivityConfig.AD_ID);
            if (property != null) {
                return property.equals(property2);
            }
            if (property2 != null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getAdPatternType() {
        return this.f11902a.b("ad_pattern_type");
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getDesc() {
        return this.f11902a.a("ad_desc");
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getECPM() {
        return this.f11902a.b("ad_ecpm");
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getECPMLevel() {
        return this.f11902a.a("ad_ecpm_level");
    }

    @Override // com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        return this.f11902a.b("ad_mp");
    }

    @Override // com.qq.e.comm.pi.AdData
    public <T> T getProperty(Class<T> cls) {
        if (cls == AdData.VideoPlayer.class) {
            return (T) this.f11903b;
        }
        if (cls == p.class) {
            return (T) this.f11902a;
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getProperty(String str) {
        return this.f11902a.a(str);
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getTitle() {
        return this.f11902a.a("ad_title");
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getVideoDuration() {
        return this.f11902a.b("ad_video_duration");
    }

    @Override // com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        return this.f11902a.c("ad_contract_ad");
    }
}
