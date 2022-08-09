package com.yy.mobile.framework.revenuesdk.baseapi.data;

import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
/* loaded from: classes8.dex */
public interface IRevenueDataReceiver {
    void onRequestError(int i, int i2, String str, int i3, int i4, String str2);

    void onResponseData(int i, int i2, PSCIMessageResponse pSCIMessageResponse);
}
