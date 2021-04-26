package com.yy.mobile.framework.revenuesdk;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.giftapi.IGiftService;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import d.r.b.a.a.f.f.b;
@Keep
/* loaded from: classes7.dex */
public interface IRevenue {
    IAppPayService getAppPayService();

    IGiftService getGiftService();

    b getSDKReporter();

    void sendHeartBeat(long j, String str);

    void updateConfig(d.r.b.a.a.b bVar);
}
