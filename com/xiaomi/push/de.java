package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
/* loaded from: classes2.dex */
public class de implements LoggerInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LoggerInterface f70791a;

    /* renamed from: b  reason: collision with root package name */
    public LoggerInterface f70792b;

    public de(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {loggerInterface, loggerInterface2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70791a = null;
        this.f70792b = null;
        this.f70791a = loggerInterface;
        this.f70792b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            LoggerInterface loggerInterface = this.f70791a;
            if (loggerInterface != null) {
                loggerInterface.log(str);
            }
            LoggerInterface loggerInterface2 = this.f70792b;
            if (loggerInterface2 != null) {
                loggerInterface2.log(str);
            }
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th) == null) {
            LoggerInterface loggerInterface = this.f70791a;
            if (loggerInterface != null) {
                loggerInterface.log(str, th);
            }
            LoggerInterface loggerInterface2 = this.f70792b;
            if (loggerInterface2 != null) {
                loggerInterface2.log(str, th);
            }
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }
}
