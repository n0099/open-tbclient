package com.yy.mobile.framework.revenuesdk.baseapi.data;

import java.util.ArrayList;
/* loaded from: classes8.dex */
public interface IRevenueDataSender {
    void cancelAllRequest(int i2, int i3);

    void sendData(int i2, int i3, String str, ArrayList<Integer> arrayList, byte[] bArr);
}
