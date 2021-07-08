package com.yy.mobile.framework.revenuesdk.payapi.request;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u0000B\u0007¢\u0006\u0004\bZ\u0010[J\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0007\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\"\u0010*\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0007\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0007\u001a\u0004\b<\u0010\t\"\u0004\b=\u0010\u000bR\"\u0010>\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0007\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR$\u0010A\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0015\u001a\u0004\bB\u0010\u0017\"\u0004\bC\u0010\u0019R\"\u0010D\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0007\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000bR$\u0010G\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010\u0015\u001a\u0004\bH\u0010\u0017\"\u0004\bI\u0010\u0019R$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0015\u001a\u0004\bR\u0010\u0017\"\u0004\bS\u0010\u0019R\"\u0010T\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u00106\u001a\u0004\bU\u00108\"\u0004\bV\u0010:R\"\u0010W\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0007\u001a\u0004\bX\u0010\t\"\u0004\bY\u0010\u000b¨\u0006\\"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "other", "", "clone", "(Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;)V", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "getAppId", "()I", "setAppId", "(I)V", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;", "callback", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;", "getCallback", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;", "setCallback", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)V", "", "clientVersion", "Ljava/lang/String;", "getClientVersion", "()Ljava/lang/String;", "setClientVersion", "(Ljava/lang/String;)V", "cmd", "getCmd", "setCmd", "Landroid/app/Activity;", "context", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "setContext", "(Landroid/app/Activity;)V", "expand", "getExpand", "setExpand", "form", "getForm", "setForm", "intervalMs", "getIntervalMs", "setIntervalMs", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protocolType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "getProtocolType", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "setProtocolType", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "", "requestTime", "J", "getRequestTime", "()J", "setRequestTime", "(J)V", "retryCount", "getRetryCount", "setRetryCount", "retryType", "getRetryType", "setRetryType", IAdRequestParam.SEQ, "getSeq", "setSeq", "timeOutMs", "getTimeOutMs", "setTimeOutMs", "token", "getToken", "setToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "tokenCallback", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "getTokenCallback", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "setTokenCallback", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)V", "traceid", "getTraceid", "setTraceid", "uid", "getUid", "setUid", "usedChannel", "getUsedChannel", "setUsedChannel", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public class RequestParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public IResult<?> callback;
    public String clientVersion;
    public int cmd;
    public Activity context;
    public String expand;
    public int form;
    public int intervalMs;
    public ProtocolType protocolType;
    public long requestTime;
    public int retryCount;
    public int retryType;
    public String seq;
    public int timeOutMs;
    public String token;
    public IToken tokenCallback;
    public String traceid;
    public long uid;
    public int usedChannel;

    public RequestParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.usedChannel = 10002;
        this.clientVersion = "";
        this.expand = "";
        this.traceid = "";
        this.protocolType = ProtocolType.UNKNOW;
    }

    public final void clone(RequestParams requestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, requestParams) == null) {
            this.retryCount = requestParams.retryCount;
            this.intervalMs = requestParams.intervalMs;
            this.timeOutMs = requestParams.timeOutMs;
            this.callback = requestParams.callback;
            this.appId = requestParams.appId;
            this.uid = requestParams.uid;
            this.token = requestParams.token;
            this.expand = requestParams.expand;
            this.seq = requestParams.seq;
            this.usedChannel = requestParams.usedChannel;
            this.clientVersion = requestParams.clientVersion;
            this.context = requestParams.context;
            this.tokenCallback = requestParams.tokenCallback;
            this.form = requestParams.form;
            this.traceid = requestParams.traceid;
            this.protocolType = requestParams.protocolType;
        }
    }

    public final int getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appId : invokeV.intValue;
    }

    public final IResult<?> getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.callback : (IResult) invokeV.objValue;
    }

    public final String getClientVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.clientVersion : (String) invokeV.objValue;
    }

    public final int getCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cmd : invokeV.intValue;
    }

    public final Activity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.context : (Activity) invokeV.objValue;
    }

    public final String getExpand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.expand : (String) invokeV.objValue;
    }

    public final int getForm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.form : invokeV.intValue;
    }

    public final int getIntervalMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.intervalMs : invokeV.intValue;
    }

    public final ProtocolType getProtocolType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.protocolType : (ProtocolType) invokeV.objValue;
    }

    public final long getRequestTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.requestTime : invokeV.longValue;
    }

    public final int getRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.retryCount : invokeV.intValue;
    }

    public final int getRetryType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.retryType : invokeV.intValue;
    }

    public final String getSeq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.seq : (String) invokeV.objValue;
    }

    public final int getTimeOutMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.timeOutMs : invokeV.intValue;
    }

    public final String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.token : (String) invokeV.objValue;
    }

    public final IToken getTokenCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.tokenCallback : (IToken) invokeV.objValue;
    }

    public final String getTraceid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.traceid : (String) invokeV.objValue;
    }

    public final long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.uid : invokeV.longValue;
    }

    public final int getUsedChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.usedChannel : invokeV.intValue;
    }

    public final void setAppId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.appId = i2;
        }
    }

    public final void setCallback(IResult<?> iResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, iResult) == null) {
            this.callback = iResult;
        }
    }

    public final void setClientVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.clientVersion = str;
        }
    }

    public final void setCmd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.cmd = i2;
        }
    }

    public final void setContext(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, activity) == null) {
            this.context = activity;
        }
    }

    public final void setExpand(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.expand = str;
        }
    }

    public final void setForm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.form = i2;
        }
    }

    public final void setIntervalMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.intervalMs = i2;
        }
    }

    public final void setProtocolType(ProtocolType protocolType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, protocolType) == null) {
            this.protocolType = protocolType;
        }
    }

    public final void setRequestTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j) == null) {
            this.requestTime = j;
        }
    }

    public final void setRetryCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.retryCount = i2;
        }
    }

    public final void setRetryType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.retryType = i2;
        }
    }

    public final void setSeq(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.seq = str;
        }
    }

    public final void setTimeOutMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.timeOutMs = i2;
        }
    }

    public final void setToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.token = str;
        }
    }

    public final void setTokenCallback(IToken iToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, iToken) == null) {
            this.tokenCallback = iToken;
        }
    }

    public final void setTraceid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.traceid = str;
        }
    }

    public final void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
            this.uid = j;
        }
    }

    public final void setUsedChannel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.usedChannel = i2;
        }
    }
}
