package com.yy.mobile.framework.revenuesdk.baseapi.data;

import android.os.Handler;
import android.os.HandlerThread;
import com.xiaomi.mipush.sdk.Constants;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageBroadcast;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageUnicast;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public enum RevenueDataParser implements IRevenueDataParser {
    INSTANCE;
    
    public static final String TAG = "RevenueDataParser";
    public Handler parserHandler;
    public List<IRevenueDataReceiver> revenueDataReceivers = new ArrayList();

    RevenueDataParser() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.parserHandler = new Handler(handlerThread.getLooper());
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataParser
    public void onRequestError(final int i2, final String str, final int i3, final int i4, final String str2) {
        this.parserHandler.post(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser.4
            @Override // java.lang.Runnable
            public void run() {
                RLog.info(RevenueDataParser.TAG, "onRequestError appId = %d, seq = %s, message = %s", Integer.valueOf(i2), str, str2);
                for (IRevenueDataReceiver iRevenueDataReceiver : RevenueDataParser.this.revenueDataReceivers) {
                    iRevenueDataReceiver.onRequestError(i2, str, i3, i4, str2);
                }
            }
        });
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataParser
    public void parserRevenueBroadcastData(final RevenueBroadcastData revenueBroadcastData) {
        this.parserHandler.post(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser.3
            @Override // java.lang.Runnable
            public void run() {
                PSCIMessageBroadcast pSCIMessageBroadcast = new PSCIMessageBroadcast(revenueBroadcastData.jsonData);
                RLog.info(RevenueDataParser.TAG, "RevenueBroadcastData = %s", pSCIMessageBroadcast.toString());
                RLog.info(RevenueDataParser.TAG, "RevenueBroadcastData: jsonData = %s", pSCIMessageBroadcast.getJsonData());
                pSCIMessageBroadcast.setUri(revenueBroadcastData.cmd);
                int optInt = pSCIMessageBroadcast.getData().optInt(Constants.APP_ID, 0);
                for (IRevenueDataReceiver iRevenueDataReceiver : RevenueDataParser.this.revenueDataReceivers) {
                    iRevenueDataReceiver.onBroadcastData(optInt, pSCIMessageBroadcast);
                }
            }
        });
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataParser
    public void parserRevenueResponseData(final int i2, final byte[] bArr) {
        this.parserHandler.post(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser.1
            @Override // java.lang.Runnable
            public void run() {
                PSCIMessageResponse pSCIMessageResponse = new PSCIMessageResponse(bArr);
                RLog.debug(RevenueDataParser.TAG, "parserRevenueResponseData: %s", pSCIMessageResponse.toString());
                for (IRevenueDataReceiver iRevenueDataReceiver : RevenueDataParser.this.revenueDataReceivers) {
                    iRevenueDataReceiver.onResponseData(i2, pSCIMessageResponse);
                }
            }
        });
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataParser
    public void parserRevenueUnicastData(final RevenueUnicastData revenueUnicastData) {
        this.parserHandler.post(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.data.RevenueDataParser.2
            @Override // java.lang.Runnable
            public void run() {
                PSCIMessageUnicast pSCIMessageUnicast = new PSCIMessageUnicast(revenueUnicastData.jsonData);
                RLog.debug(RevenueDataParser.TAG, "RevenueUnicastData = %s", pSCIMessageUnicast.toString());
                RLog.debug(RevenueDataParser.TAG, "RevenueUnicastData: jsonData = %s", pSCIMessageUnicast.getJsonData());
                pSCIMessageUnicast.setUri(revenueUnicastData.cmd);
                for (IRevenueDataReceiver iRevenueDataReceiver : RevenueDataParser.this.revenueDataReceivers) {
                    iRevenueDataReceiver.onUnicastData(pSCIMessageUnicast.getAppId(), pSCIMessageUnicast);
                }
            }
        });
    }

    public void registerDataReceivers(IRevenueDataReceiver iRevenueDataReceiver) {
        if (this.revenueDataReceivers.contains(iRevenueDataReceiver)) {
            return;
        }
        this.revenueDataReceivers.add(iRevenueDataReceiver);
    }
}
