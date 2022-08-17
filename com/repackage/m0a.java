package com.repackage;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import java.util.Map;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes6.dex */
public interface m0a {
    void a(Activity activity, PayFlowType payFlowType, z1a z1aVar, w1a w1aVar, AppCustomExpand appCustomExpand, Map<String, String> map, IPayCallback iPayCallback, String str);
}
