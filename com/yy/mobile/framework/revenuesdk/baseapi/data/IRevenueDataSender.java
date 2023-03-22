package com.yy.mobile.framework.revenuesdk.baseapi.data;

import java.util.ArrayList;
/* loaded from: classes9.dex */
public interface IRevenueDataSender {
    void cancelAllRequest(int i, int i2);

    void sendData(int i, int i2, String str, ArrayList<Integer> arrayList, byte[] bArr);
}
