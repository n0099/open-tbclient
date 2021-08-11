package com.yy.mobile.framework.revenuesdk.baseapi.data;
/* loaded from: classes10.dex */
public interface IRevenueDataParser {
    void onRequestError(int i2, String str, int i3, int i4, String str2);

    void parserRevenueBroadcastData(RevenueBroadcastData revenueBroadcastData);

    void parserRevenueResponseData(int i2, byte[] bArr);

    void parserRevenueUnicastData(RevenueUnicastData revenueUnicastData);
}
