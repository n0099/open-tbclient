package com.yy.mobile.framework.revenuesdk.payapi.payservice;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaySignInfo;
/* loaded from: classes10.dex */
public interface IPayAliSignMethod {
    boolean isSupported(Activity activity);

    void requestSign(Activity activity, PaySignInfo paySignInfo, IPaySignCallback iPaySignCallback);
}
