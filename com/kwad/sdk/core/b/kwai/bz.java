package com.kwad.sdk.core.b.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.response.model.SdkConfigData;
/* loaded from: classes5.dex */
public final class bz {
    @InvokeBy(invokerClass = cz.class, methodId = "registerHolder")
    public static void a() {
        cz.a().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new cr());
        cz.a().put(SdkConfigData.TemplateConfigMap.class, new fj());
        cz.a().put(com.kwad.sdk.core.response.model.a.class, new ed());
        cz.a().put(ActivityInfo.class, new e());
        cz.a().put(h.a.class, new cq());
        cz.a().put(f.a.class, new cp());
        cz.a().put(SdkConfigData.CouponActiveConfig.class, new bf());
    }
}
