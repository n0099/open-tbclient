package com.yy.mobile.framework.revenuesdk.baseapi.data;
/* loaded from: classes3.dex */
public interface IRevenueDataParser {
    void onRequestError(int i2, int i3, String str, int i4, int i5, String str2);

    void parserRevenueBroadcastData(RevenueBroadcastData revenueBroadcastData);

    void parserRevenueResponseData(int i2, int i3, byte[] bArr);

    void parserRevenueUnicastData(RevenueUnicastData revenueUnicastData);
}
