package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request;

import android.os.Handler;
import android.os.Looper;
import com.baidu.sapi2.activity.BaseActivity;
import com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy;
import com.yy.mobile.framework.revenuesdk.baseapi.ServiceFailResult;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.BaseJsonRequest;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.SeqUtil;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IDataSender;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>BS\u0012\u0006\u0010\"\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010/\u001a\u00020.\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u00104\u001a\u00020\t\u0012\u0006\u0010+\u001a\u00020\t\u0012\u0006\u0010;\u001a\u00020\t\u0012\u0006\u00105\u001a\u00020\t¢\u0006\u0004\b<\u0010=J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0005R\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010,\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010!R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010!R\"\u00106\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010!¨\u0006?"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RetryRequestJob;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/DefaultRetryPolicy;", "", "cancel", "()V", "", "getExtParam", "()Ljava/lang/Object;", "", "getReqCommand", "()I", "", "getReqSeq", "()Ljava/lang/String;", "getRetryCount", "getRetryInterval", "getTimeout", "getTotalRetryCount", "srvErrorCode", "message", "onRequestError", "(ILjava/lang/String;)V", "onRetry", "retryCountExhaust", "", "run", "()Z", "param", "setExtParam", "(Ljava/lang/Object;)V", "stop", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "command", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "encoder", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "extParam", "Ljava/lang/Object;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;", "iDataSender", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;", "intervalMs", "isRun", "Z", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "params", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "req", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "retryCount", "retryType", "seq", "Ljava/lang/String;", "getSeq", "setSeq", "(Ljava/lang/String;)V", "timeOutMs", "<init>", "(IILcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;IIII)V", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class RetryRequestJob extends DefaultRetryPolicy implements IRequest {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "RevenueService-RetryRequestJob";
    public final int appId;
    public final int command;
    public final ProtocolEncoder encoder;
    public Object extParam;
    public final IDataSender iDataSender;
    public int intervalMs;
    public boolean isRun;
    public final RequestParams params;
    public BaseJsonRequest req;
    public int retryCount;
    public int retryType;
    public String seq;
    public int timeOutMs;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JU\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RetryRequestJob$Companion;", "", "command", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "params", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "encoder", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;", "iDataSender", "retryCount", "intervalMs", "timeOutMs", "retryType", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RetryRequestJob;", "obtain", "(IILcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;IIII)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RetryRequestJob;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RetryRequestJob obtain(int i, int i2, RequestParams requestParams, ProtocolEncoder protocolEncoder, IDataSender iDataSender, int i3, int i4, int i5, int i6) {
            requestParams.setSeq(SeqUtil.increaseSeqId());
            RetryRequestJob retryRequestJob = new RetryRequestJob(i, i2, requestParams, protocolEncoder, iDataSender, i3, i4, i5, i6);
            String seq = requestParams.getSeq();
            if (seq == null) {
                Intrinsics.throwNpe();
            }
            retryRequestJob.setSeq(seq);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("obtain seq = %s", Arrays.copyOf(new Object[]{retryRequestJob.getSeq()}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            RLog.debug(RetryRequestJob.TAG, format);
            return retryRequestJob;
        }
    }

    public RetryRequestJob(int i, int i2, RequestParams requestParams, ProtocolEncoder protocolEncoder, IDataSender iDataSender, int i3, int i4, int i5, int i6) {
        super(new Handler(Looper.getMainLooper()), i5, i3, i4, i6);
        this.command = i;
        this.appId = i2;
        this.params = requestParams;
        this.encoder = protocolEncoder;
        this.iDataSender = iDataSender;
        this.retryCount = i3;
        this.intervalMs = i4;
        this.timeOutMs = i5;
        this.retryType = i6;
        this.seq = "";
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy, com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy
    public void cancel() {
        super.cancel();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("cancel command = %d, appId = %d, seq = %s", Arrays.copyOf(new Object[]{Integer.valueOf(this.command), Integer.valueOf(this.appId), this.seq}, 3));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        RLog.error(TAG, format, new Object[0]);
        IDataSender iDataSender = this.iDataSender;
        if (iDataSender != null) {
            iDataSender.cancel(this.command, this.seq, RetryPolicy.Status.RETRY_CANCEL.getCode(), RetryPolicy.Status.RETRY_CANCEL.getMessage());
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy
    public void onRetry() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("onRetry command = %d, appId = %d, seq = %s", Arrays.copyOf(new Object[]{Integer.valueOf(this.command), Integer.valueOf(this.appId), this.seq}, 3));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        RLog.info(TAG, format);
        IDataSender iDataSender = this.iDataSender;
        if (iDataSender == null) {
            Intrinsics.throwNpe();
        }
        String str = this.seq;
        BaseJsonRequest baseJsonRequest = this.req;
        if (baseJsonRequest == null) {
            Intrinsics.throwNpe();
        }
        byte[] marshall = baseJsonRequest.marshall();
        Intrinsics.checkExpressionValueIsNotNull(marshall, "req!!.marshall()");
        iDataSender.sendData(str, marshall);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy
    public void retryCountExhaust() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("retryCountExhaust command = %d, appId = %d, seq = %s", Arrays.copyOf(new Object[]{Integer.valueOf(this.command), Integer.valueOf(this.appId), this.seq}, 3));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        RLog.error(TAG, format, new Object[0]);
        IDataSender iDataSender = this.iDataSender;
        if (iDataSender != null) {
            iDataSender.cancel(this.command, this.seq, RetryPolicy.Status.RETRY_COUNT_EXHAUST.getCode(), RetryPolicy.Status.RETRY_COUNT_EXHAUST.getMessage());
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public Object getExtParam() {
        return this.extParam;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getReqCommand() {
        return this.command;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public String getReqSeq() {
        return this.seq;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getRetryCount() {
        return super.getCurrentRetryCount();
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getRetryInterval() {
        return this.intervalMs;
    }

    public final String getSeq() {
        return this.seq;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getTimeout() {
        return this.timeOutMs;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getTotalRetryCount() {
        return this.retryCount;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public void stop() {
        cancel();
    }

    public final void onRequestError(int i, String str) {
        switch (i) {
            case 408:
            case 504:
            case 110001:
            case ServiceFailResult.Code.SDK_TIMEOUT /* 110003 */:
            case 200408:
            case ServiceFailResult.Code.SVR_GATEWAYTIMEOUT /* 200504 */:
                retry();
                return;
            default:
                IDataSender iDataSender = this.iDataSender;
                if (iDataSender != null) {
                    iDataSender.cancel(this.command, this.seq, i, str);
                }
                done();
                return;
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public boolean run() {
        boolean z;
        if (this.iDataSender == null || this.encoder == null) {
            return false;
        }
        if (this.isRun) {
            return true;
        }
        this.params.setSeq(this.seq);
        BaseJsonRequest encodeProtocol = this.encoder.encodeProtocol(this.command, this.appId, this.params);
        this.req = encodeProtocol;
        if (encodeProtocol == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        this.isRun = true;
        call();
        return this.isRun;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public void setExtParam(Object obj) {
        this.extParam = obj;
    }

    public final void setSeq(String str) {
        this.seq = str;
    }
}
