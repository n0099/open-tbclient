package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import java.util.Map;
/* loaded from: classes10.dex */
public interface IWechatProxyCallback {
    void onFail(String str);

    void onSuccess(Map<String, String> map);
}
