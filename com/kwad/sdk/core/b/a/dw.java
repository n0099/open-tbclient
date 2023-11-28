package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes10.dex */
public final class dw {
    @InvokeBy(invokerClass = fr.class, methodId = "registerHolder")
    public static void Cp() {
        fr.Cq().put(SdkConfigData.CouponActiveConfig.class, new cm());
        fr.Cq().put(com.kwad.sdk.core.response.model.a.class, new hr());
        fr.Cq().put(ActivityInfo.class, new f());
        fr.Cq().put(SdkConfigData.TemplateConfigMap.class, new jw());
        fr.Cq().put(j.a.class, new fa());
        fr.Cq().put(h.a.class, new ex());
        fr.Cq().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new fb());
    }
}
