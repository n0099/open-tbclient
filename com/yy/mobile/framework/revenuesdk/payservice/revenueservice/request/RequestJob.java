package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.BaseJsonRequest;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.SeqUtil;
import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.IDataSender;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B3\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b-\u0010.J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010(\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RequestJob;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "", "getExtParam", "()Ljava/lang/Object;", "", "getReqCommand", "()I", "", "getReqSeq", "()Ljava/lang/String;", "getRetryCount", "getRetryInterval", "getTimeout", "getTotalRetryCount", "", "run", "()Z", "param", "", "setExtParam", "(Ljava/lang/Object;)V", IntentConfig.STOP, "()V", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "command", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "encoder", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "extParam", "Ljava/lang/Object;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;", "iDataSender", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;", "isRun", "Z", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "params", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "seq", "Ljava/lang/String;", "getSeq", "setSeq", "(Ljava/lang/String;)V", "<init>", "(IILcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;)V", "Companion", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class RequestJob implements IRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final String TAG = "RevenueService-RequestJob";
    public transient /* synthetic */ FieldHolder $fh;
    public final int appId;
    public final int command;
    public final ProtocolEncoder encoder;
    public Object extParam;
    public final IDataSender iDataSender;
    public boolean isRun;
    public final RequestParams params;
    public String seq;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1475970127, "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RequestJob;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1475970127, "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RequestJob;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getRetryInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getTotalRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RequestJob$Companion;", "", "command", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "params", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;", "encoder", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;", "iDataSender", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RequestJob;", "obtain", "(IILcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/ProtocolEncoder;Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/RequestJob;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes8.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RequestJob obtain(int i, int i2, RequestParams requestParams, ProtocolEncoder protocolEncoder, IDataSender iDataSender) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), requestParams, protocolEncoder, iDataSender})) == null) {
                requestParams.setSeq(SeqUtil.increaseSeqId());
                RequestJob requestJob = new RequestJob(i, i2, requestParams, protocolEncoder, iDataSender);
                String seq = requestParams.getSeq();
                if (seq == null) {
                    Intrinsics.throwNpe();
                }
                requestJob.setSeq(seq);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("obtain seq = %s", Arrays.copyOf(new Object[]{requestJob.getSeq()}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                RLog.debug(RequestJob.TAG, format);
                return requestJob;
            }
            return (RequestJob) invokeCommon.objValue;
        }
    }

    public RequestJob(int i, int i2, RequestParams requestParams, ProtocolEncoder protocolEncoder, IDataSender iDataSender) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), requestParams, protocolEncoder, iDataSender};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.command = i;
        this.appId = i2;
        this.params = requestParams;
        this.encoder = protocolEncoder;
        this.iDataSender = iDataSender;
        this.seq = "";
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public Object getExtParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.extParam;
        }
        return invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public int getReqCommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.command;
        }
        return invokeV.intValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public String getReqSeq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.seq;
        }
        return (String) invokeV.objValue;
    }

    public final String getSeq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.seq;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public void stop() {
        IDataSender iDataSender;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (iDataSender = this.iDataSender) != null) {
            iDataSender.cancel(this.command, this.seq, 0, "");
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public boolean run() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.iDataSender == null || this.encoder == null) {
                return false;
            }
            if (this.isRun) {
                return true;
            }
            this.params.setSeq(this.seq);
            BaseJsonRequest encodeProtocol = this.encoder.encodeProtocol(this.command, this.appId, this.params);
            if (encodeProtocol == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return false;
            }
            this.isRun = true;
            IDataSender iDataSender = this.iDataSender;
            String str = this.seq;
            if (encodeProtocol == null) {
                Intrinsics.throwNpe();
            }
            byte[] marshall = encodeProtocol.marshall();
            Intrinsics.checkExpressionValueIsNotNull(marshall, "req!!.marshall()");
            iDataSender.sendData(str, marshall);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest
    public void setExtParam(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
            this.extParam = obj;
        }
    }

    public final void setSeq(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.seq = str;
        }
    }
}
