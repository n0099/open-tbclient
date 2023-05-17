package com.yy.mobile.framework.revenuesdk.payservice.revenueservice;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PSCIMessageResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IRevenueService;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.ProtocolEncoder;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.RequestJob;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.RetryRequestJob;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.ProtocolDecoder;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.ServiceResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010?\u001a\u00020\u0004\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\u0006\u0010:\u001a\u000209\u0012\b\b\u0002\u00103\u001a\u000202¢\u0006\u0004\b@\u0010AJ3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0013\u001a\u00020\u0012\"\b\b\u0000\u0010\u0010*\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014JC\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0012058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010(¨\u0006B"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/RevenueService;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IRevenueService;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IRevenueDataReceiver;", "", "command", "", "seq", "code", "message", "", "cancel", "(ILjava/lang/String;ILjava/lang/String;)V", "cancelAllRequest", "()V", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", ExifInterface.GPS_DIRECTION_TRUE, "params", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "obtainRequest", "(ILcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "userchannel", "cmd", "srvErrorCode", "onRequestError", "(IILjava/lang/String;IILjava/lang/String;)V", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/PSCIMessageResponse;", "responseData", "onResponseData", "(IILcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/PSCIMessageResponse;)V", "", "data", "sendData", "(Ljava/lang/String;[B)V", "req", "sendRequest", "(Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;)V", "TAG", "Ljava/lang/String;", "I", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IRevenueDataSender;", "iDataSender", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IRevenueDataSender;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ProtocolDecoder;", "protocolDecoder", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ProtocolDecoder;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "protocolEncoder", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protocolType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "", "requestJobList", "Ljava/util/Map;", "requestJobListCmd", "", "requestReuse", "Z", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IRevenueService$IRevenueServiceListener;", "serviceListener", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IRevenueService$IRevenueServiceListener;", "useChannel", "<init>", "(IILcom/yy/mobile/framework/revenuesdk/baseapi/data/IRevenueDataSender;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IRevenueService$IRevenueServiceListener;ZLcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class RevenueService implements IRevenueService, IDataSender, IRevenueDataReceiver {
    public final String TAG;
    public final int appId;
    public final IRevenueDataSender iDataSender;
    public ProtocolDecoder protocolDecoder;
    public ProtocolEncoder protocolEncoder;
    public final ProtocolType protocolType;
    public volatile Map<String, IRequest> requestJobList;
    public volatile Map<Integer, IRequest> requestJobListCmd;
    public final boolean requestReuse;
    public final IRevenueService.IRevenueServiceListener serviceListener;
    public final int useChannel;

    public RevenueService(int i, int i2, IRevenueDataSender iRevenueDataSender, IRevenueService.IRevenueServiceListener iRevenueServiceListener, boolean z, ProtocolType protocolType) {
        this.appId = i;
        this.useChannel = i2;
        this.iDataSender = iRevenueDataSender;
        this.serviceListener = iRevenueServiceListener;
        this.requestReuse = z;
        this.protocolType = protocolType;
        this.TAG = "RevenueService";
        this.protocolEncoder = new ProtocolEncoder(protocolType);
        this.protocolDecoder = new ProtocolDecoder();
        this.requestJobListCmd = new ConcurrentHashMap();
        this.requestJobList = new ConcurrentHashMap();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RevenueService(int i, int i2, IRevenueDataSender iRevenueDataSender, IRevenueService.IRevenueServiceListener iRevenueServiceListener, boolean z, ProtocolType protocolType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, r5, r6, z, r8);
        IRevenueDataSender iRevenueDataSender2;
        IRevenueService.IRevenueServiceListener iRevenueServiceListener2;
        ProtocolType protocolType2;
        if ((i3 & 4) != 0) {
            iRevenueDataSender2 = null;
        } else {
            iRevenueDataSender2 = iRevenueDataSender;
        }
        if ((i3 & 8) != 0) {
            iRevenueServiceListener2 = null;
        } else {
            iRevenueServiceListener2 = iRevenueServiceListener;
        }
        if ((i3 & 32) != 0) {
            protocolType2 = ProtocolType.UNKNOW;
        } else {
            protocolType2 = protocolType;
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IRevenueService
    public void sendRequest(final IRequest iRequest) {
        String str = this.TAG;
        RLog.debug(str, "sendRequest requestReuse = " + this.requestReuse);
        ThreadPool.getDefault().networkIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueService$sendRequest$1
            @Override // java.lang.Runnable
            public final void run() {
                String str2;
                boolean z;
                String str3;
                Map map;
                String str4;
                boolean z2;
                Map map2;
                if (iRequest.run()) {
                    z = RevenueService.this.requestReuse;
                    if (z) {
                        str4 = RevenueService.this.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("sendRequest requestReuse = ");
                        z2 = RevenueService.this.requestReuse;
                        sb.append(z2);
                        sb.append(" Command:");
                        sb.append(iRequest.getReqCommand());
                        RLog.debug(str4, sb.toString());
                        map2 = RevenueService.this.requestJobListCmd;
                        map2.put(Integer.valueOf(iRequest.getReqCommand()), iRequest);
                        return;
                    }
                    str3 = RevenueService.this.TAG;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("sendRequest Seq = %s", Arrays.copyOf(new Object[]{iRequest.getReqSeq()}, 1));
                    Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                    RLog.debug(str3, format);
                    map = RevenueService.this.requestJobList;
                    map.put(iRequest.getReqSeq(), iRequest);
                    return;
                }
                str2 = RevenueService.this.TAG;
                RLog.info(str2, "sendRequest run failed Command:" + iRequest.getReqCommand());
            }
        });
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IDataSender
    public void sendData(String str, byte[] bArr) {
        String str2 = this.TAG;
        RLog.debug(str2, "sendData requestReuse = " + this.requestReuse);
        IRevenueDataSender iRevenueDataSender = this.iDataSender;
        if (iRevenueDataSender != null) {
            iRevenueDataSender.sendData(this.appId, this.useChannel, str, null, bArr);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IDataSender
    public void cancel(int i, String str, int i2, String str2) {
        String str3 = this.TAG;
        RLog.debug(str3, "cancel requestReuse = " + this.requestReuse);
        ServiceResponse serviceResponse = new ServiceResponse(i, str, i2, str2);
        if (this.requestReuse) {
            String str4 = this.TAG;
            RLog.debug(str4, "cancel requestReuse = " + this.requestReuse + "Command:" + i);
            serviceResponse.setReq(this.requestJobListCmd.remove(Integer.valueOf(i)));
        } else {
            String str5 = this.TAG;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("cancel seq = %s", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            RLog.error(str5, format, new Object[0]);
            Map<String, IRequest> map = this.requestJobList;
            if (map != null) {
                serviceResponse.setReq((IRequest) TypeIntrinsics.asMutableMap(map).remove(str));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
            }
        }
        IRevenueService.IRevenueServiceListener iRevenueServiceListener = this.serviceListener;
        if (iRevenueServiceListener != null) {
            iRevenueServiceListener.onRevenueResponse(i, serviceResponse);
        }
    }

    public final void cancelAllRequest() {
        int size = this.requestJobList.size();
        for (Map.Entry<String, IRequest> entry : this.requestJobList.entrySet()) {
            IRequest value = entry.getValue();
            String key = entry.getKey();
            String str = this.TAG;
            RLog.info(str, "cancelAllRequest key:" + key + " cmd:" + value.getReqCommand());
            if (value instanceof RequestJob) {
                cancel(value.getReqCommand(), key, ErrorCode.CLIENT_CANCEL_REQUEST, "取消请求");
            }
        }
        int size2 = this.requestJobList.size();
        String str2 = this.TAG;
        RLog.info(str2, "cancelAllRequest sizeBeforeCancel:" + size + " sizeAfterCancel:" + size2);
        IRevenueDataSender iRevenueDataSender = this.iDataSender;
        if (iRevenueDataSender != null) {
            iRevenueDataSender.cancelAllRequest(this.appId, this.useChannel);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IRevenueService
    public <T extends RequestParams> IRequest obtainRequest(int i, T t) {
        String str = this.TAG;
        RLog.debug(str, "obtainRequest command = " + i + " requestReuse = " + this.requestReuse + " retryCount = " + t.getRetryCount());
        if (this.requestReuse) {
            IRequest iRequest = this.requestJobListCmd.get(Integer.valueOf(i));
            if (iRequest != null) {
                return iRequest;
            }
            if (t.getRetryCount() > 0) {
                return RetryRequestJob.Companion.obtain(i, this.appId, t, this.protocolEncoder, this, t.getRetryCount(), t.getIntervalMs(), t.getTimeOutMs(), t.getRetryType());
            }
            return RequestJob.Companion.obtain(i, this.appId, t, this.protocolEncoder, this);
        } else if (t.getRetryCount() > 0) {
            return RetryRequestJob.Companion.obtain(i, this.appId, t, this.protocolEncoder, this, t.getRetryCount(), t.getIntervalMs(), t.getTimeOutMs(), t.getRetryType());
        } else {
            return RequestJob.Companion.obtain(i, this.appId, t, this.protocolEncoder, this);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onRequestError(int i, int i2, String str, int i3, int i4, String str2) {
        String str3 = this.TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onRequestError appId = %d, errCode = %d, seq = %s, message = %s", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i4), str, str2}, 4));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        RLog.error(str3, format, new Object[0]);
        if (this.requestReuse) {
            String str4 = this.TAG;
            RLog.debug(str4, "onRequestError requestReuse = " + this.requestReuse + "Command:" + i3);
            IRequest iRequest = this.requestJobListCmd.get(Integer.valueOf(i3));
            if (iRequest != null) {
                if (iRequest instanceof RetryRequestJob) {
                    ((RetryRequestJob) iRequest).onRequestError(i4, str2);
                    return;
                } else {
                    cancel(iRequest.getReqCommand(), str, i4, str2);
                    return;
                }
            }
            return;
        }
        IRequest iRequest2 = this.requestJobList.get(str);
        if (iRequest2 != null) {
            if (iRequest2 instanceof RetryRequestJob) {
                ((RetryRequestJob) iRequest2).onRequestError(i4, str2);
            } else {
                cancel(iRequest2.getReqCommand(), str, i4, str2);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver
    public void onResponseData(int i, int i2, PSCIMessageResponse pSCIMessageResponse) {
        String str = this.TAG;
        RLog.debug(str, "onResponseData requestReuse = " + this.requestReuse);
        if (pSCIMessageResponse != null) {
            ProtocolDecoder protocolDecoder = this.protocolDecoder;
            int i3 = pSCIMessageResponse.cmd;
            String targetJson = pSCIMessageResponse.targetJson(this.protocolType);
            Intrinsics.checkExpressionValueIsNotNull(targetJson, "responseData.targetJson(protocolType)");
            ServiceResponse decode = protocolDecoder.decode(i3, targetJson);
            if (decode != null) {
                int command = decode.getCommand();
                if (this.requestReuse) {
                    decode.setReq(this.requestJobListCmd.get(Integer.valueOf(command)));
                    this.requestJobListCmd.remove(Integer.valueOf(command));
                    String str2 = this.TAG;
                    RLog.debug(str2, "onResponseData requestReuse = " + this.requestReuse + "Command:" + command);
                } else {
                    String str3 = this.TAG;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    boolean z = true;
                    String format = String.format("onResponseData seq = %s", Arrays.copyOf(new Object[]{decode.getSeq()}, 1));
                    Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                    RLog.debug(str3, format);
                    String seq = decode.getSeq();
                    if (seq != null && seq.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        decode.setReq(this.requestJobList.get(decode.getSeq()));
                        Map<String, IRequest> map = this.requestJobList;
                        String seq2 = decode.getSeq();
                        if (map != null) {
                            TypeIntrinsics.asMutableMap(map).remove(seq2);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                        }
                    }
                }
                IRevenueService.IRevenueServiceListener iRevenueServiceListener = this.serviceListener;
                if (iRevenueServiceListener != null) {
                    iRevenueServiceListener.onRevenueResponse(command, decode);
                }
            }
        }
    }
}
