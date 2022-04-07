package com.yy.mobile.framework.revenuesdk.baseapi.data;
/* loaded from: classes8.dex */
public interface IRevenueDataParser {
    void onRequestError(int i, int i2, String str, int i3, int i4, String str2);

    void parserRevenueBroadcastData(RevenueBroadcastData revenueBroadcastData);

    void parserRevenueResponseData(int i, int i2, byte[] bArr);

    void parserRevenueUnicastData(RevenueUnicastData revenueUnicastData);
}
