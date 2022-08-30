package com.kwad.sdk.core.b.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.g;
import com.kwad.sdk.core.config.item.i;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes7.dex */
public final class cb {
    @InvokeBy(invokerClass = dd.class, methodId = "registerHolder")
    public static void tl() {
        dd.tm().put(ActivityInfo.class, new e());
        dd.tm().put(SdkConfigData.CouponActiveConfig.class, new bg());
        dd.tm().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new ct());
        dd.tm().put(com.kwad.sdk.core.response.model.a.class, new ej());
        dd.tm().put(SdkConfigData.TemplateConfigMap.class, new fr());
        dd.tm().put(i.a.class, new cs());
        dd.tm().put(g.a.class, new cr());
    }
}
