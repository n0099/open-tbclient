package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>BS\u0012\u0006\u0010\"\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010/\u001a\u00020.\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u00104\u001a\u00020\t\u0012\u0006\u0010+\u001a\u00020\t\u0012\u0006\u0010;\u001a\u00020\t\u0012\u0006\u00105\u001a\u00020\t¢\u0006\u0004\b<\u0010=J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0005R\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010,\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010!R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010!R\"\u00106\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010!¨\u0006?"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RetryRequestJob;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/DefaultRetryPolicy;", "", QueryResponse.Options.CANCEL, "()V", "", "getExtParam", "()Ljava/lang/Object;", "", "getReqCommand", "()I", "", "getReqSeq", "()Ljava/lang/String;", "getRetryCount", "getRetryInterval", "getTimeout", "getTotalRetryCount", "srvErrorCode", "message", "onRequestError", "(ILjava/lang/String;)V", "onRetry", "retryCountExhaust", "", "run", "()Z", "param", "setExtParam", "(Ljava/lang/Object;)V", IntentConfig.STOP, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "command", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "encoder", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "extParam", "Ljava/lang/Object;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;", "iDataSender", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;", "intervalMs", "isRun", "Z", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "params", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", ContentUtil.REQ_KEY_REQ, "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/BaseJsonRequest;", "retryCount", "retryType", "seq", "Ljava/lang/String;", "getSeq", "setSeq", "(Ljava/lang/String;)V", "timeOutMs", "<init>", "(IILcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;IIII)V", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class RetryRequestJob extends DefaultRetryPolicy implements IRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String TAG = "RevenueService-RetryRequestJob";
    public transient /* synthetic */ FieldHolder $fh;
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
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final RetryRequestJob obtain(int i2, int i3, RequestParams requestParams, ProtocolEncoder protocolEncoder, IDataSender iDataSender, int i4, int i5, int i6, int i7) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), requestParams, protocolEncoder, iDataSender, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
                requestParams.setSeq(SeqUtil.increaseSeqId());
                RetryRequestJob retryRequestJob = new RetryRequestJob(i2, i3, requestParams, protocolEncoder, iDataSender, i4, i5, i6, i7);
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
            return (RetryRequestJob) invokeCommon.objValue;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2054993313, "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RetryRequestJob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2054993313, "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RetryRequestJob;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryRequestJob(int i2, int i3, RequestParams requestParams, ProtocolEncoder protocolEncoder, IDataSender iDataSender, int i4, int i5, int i6, int i7) {
        super(new Handler(Looper.getMainLooper()), i6, i4, i5, i7);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), requestParams, protocolEncoder, iDataSender, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Handler) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.command = i2;
        this.appId = i3;
        this.params = requestParams;
        this.encoder = protocolEncoder;
        this.iDataSender = iDataSender;
        this.retryCount = i4;
        this.intervalMs = i5;
        this.timeOutMs = i6;
        this.retryType = i7;
        this.seq = "";
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy, com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public Object getExtParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.extParam : invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getReqCommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.command : invokeV.intValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public String getReqSeq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.seq : (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.getCurrentRetryCount() : invokeV.intValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getRetryInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.intervalMs : invokeV.intValue;
    }

    public final String getSeq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.seq : (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.timeOutMs : invokeV.intValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getTotalRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.retryCount : invokeV.intValue;
    }

    public final void onRequestError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            switch (i2) {
                case 408:
                case 504:
                case 110001:
                case 110003:
                case 200408:
                case 200504:
                    retry();
                    return;
                default:
                    IDataSender iDataSender = this.iDataSender;
                    if (iDataSender != null) {
                        iDataSender.cancel(this.command, this.seq, i2, str);
                    }
                    done();
                    return;
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy
    public void onRetry() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy
    public void retryCountExhaust() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("retryCountExhaust command = %d, appId = %d, seq = %s", Arrays.copyOf(new Object[]{Integer.valueOf(this.command), Integer.valueOf(this.appId), this.seq}, 3));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            RLog.error(TAG, format, new Object[0]);
            IDataSender iDataSender = this.iDataSender;
            if (iDataSender != null) {
                iDataSender.cancel(this.command, this.seq, RetryPolicy.Status.RETRY_COUNT_EXHAUST.getCode(), RetryPolicy.Status.RETRY_COUNT_EXHAUST.getMessage());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public boolean run() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
                return false;
            }
            this.isRun = true;
            call();
            return this.isRun;
        }
        return invokeV.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public void setExtParam(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            this.extParam = obj;
        }
    }

    public final void setSeq(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.seq = str;
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            cancel();
        }
    }
}
