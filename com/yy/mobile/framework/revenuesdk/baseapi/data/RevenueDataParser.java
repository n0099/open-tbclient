package com.yy.mobile.framework.revenuesdk.baseapi.data;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public enum RevenueDataParser implements IRevenueDataParser {
    INSTANCE;
    
    public static final String TAG = "RevenueDataParser";
    public List<IRevenueDataReceiver> revenueDataReceivers = new ArrayList();

    RevenueDataParser() {
    }

    public void registerDataReceivers(IRevenueDataReceiver iRevenueDataReceiver) {
        if (!this.revenueDataReceivers.contains(iRevenueDataReceiver)) {
            this.revenueDataReceivers.add(iRevenueDataReceiver);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataParser
    public void onRequestError(final int i, final int i2, final String str, final int i3, final int i4, final String str2) {
        ThreadPool.getDefault().networkIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser.2
            @Override // java.lang.Runnable
            public void run() {
                RLog.info(RevenueDataParser.TAG, "onRequestError appId = %d, seq = %s, message = %s", Integer.valueOf(i), str, str2);
                for (IRevenueDataReceiver iRevenueDataReceiver : RevenueDataParser.this.revenueDataReceivers) {
                    iRevenueDataReceiver.onRequestError(i, i2, str, i3, i4, str2);
                }
            }
        });
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataParser
    public void parserRevenueResponseData(final int i, final int i2, final byte[] bArr) {
        ThreadPool.getDefault().networkIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser.1
            @Override // java.lang.Runnable
            public void run() {
                PSCIMessageResponse pSCIMessageResponse = new PSCIMessageResponse(bArr);
                RLog.debug(RevenueDataParser.TAG, "parserRevenueResponseData: %s", pSCIMessageResponse.toString());
                for (IRevenueDataReceiver iRevenueDataReceiver : RevenueDataParser.this.revenueDataReceivers) {
                    iRevenueDataReceiver.onResponseData(i, i2, pSCIMessageResponse);
                }
            }
        });
    }
}
