package com.qq.e.comm.plugin.ad;

import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.qq.e.comm.pi.AdData;
/* loaded from: classes3.dex */
public class n implements AdData, com.qq.e.comm.plugin.r.a {

    /* renamed from: a  reason: collision with root package name */
    private p f12201a;

    /* renamed from: b  reason: collision with root package name */
    private AdData.VideoPlayer f12202b;

    public n(p pVar) {
        this.f12201a = pVar == null ? new o() : pVar;
    }

    public void a(AdData.VideoPlayer videoPlayer) {
        this.f12202b = videoPlayer;
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
        return this.f12201a.b("ad_pattern_type");
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getDesc() {
        return this.f12201a.a("ad_desc");
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getECPM() {
        return this.f12201a.b("ad_ecpm");
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getECPMLevel() {
        return this.f12201a.a("ad_ecpm_level");
    }

    @Override // com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        return this.f12201a.b("ad_mp");
    }

    @Override // com.qq.e.comm.pi.AdData
    public <T> T getProperty(Class<T> cls) {
        if (cls == AdData.VideoPlayer.class) {
            return (T) this.f12202b;
        }
        if (cls == p.class) {
            return (T) this.f12201a;
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getProperty(String str) {
        return this.f12201a.a(str);
    }

    @Override // com.qq.e.comm.pi.AdData
    public String getTitle() {
        return this.f12201a.a("ad_title");
    }

    @Override // com.qq.e.comm.pi.AdData
    public int getVideoDuration() {
        return this.f12201a.b("ad_video_duration");
    }

    @Override // com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        return this.f12201a.c("ad_contract_ad");
    }
}
