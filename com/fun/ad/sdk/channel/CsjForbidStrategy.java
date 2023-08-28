package com.fun.ad.sdk.channel;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.anb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.IAdForbidStrategy;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes9.dex */
public class CsjForbidStrategy implements IAdForbidStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long FORBID_TIME_ANTI_SPAM = 21600000;
    public static final long FORBID_TIME_TO_FAST = 10000;
    public static final long FORBID_TIME_TO_MACH = 3600000;
    public transient /* synthetic */ FieldHolder $fh;
    public long lastAntiSpamErrTime;
    public long lastToFastErrTime;

    public CsjForbidStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lastAntiSpamErrTime = anb.a();
    }

    @Override // com.fun.ad.sdk.internal.api.IAdForbidStrategy
    public synchronized int checkForbidStatus(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                LogPrinter.d("开始判断是否需要拦截当前请求，广告位：" + str + "  当前时间为:" + currentTimeMillis, new Object[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("上次出现228错误的时间：");
                sb.append(this.lastAntiSpamErrTime);
                LogPrinter.d(sb.toString(), new Object[0]);
                if (currentTimeMillis - this.lastAntiSpamErrTime < FORBID_TIME_ANTI_SPAM) {
                    LogPrinter.d("csj还没有超出228错误的限制时间，不发起load", new Object[0]);
                    return 228;
                }
                long j = anb.a.getLong(str, 0L);
                LogPrinter.d("上次出现112错误的时间：" + j, new Object[0]);
                if (j != 0) {
                    if (currentTimeMillis - j < 3600000) {
                        LogPrinter.d("csj还没有超出112错误的限制时间，不发起load, 广告位为：" + str, new Object[0]);
                        return 112;
                    }
                    LogPrinter.d("该广告位 " + str + " 的112错误的限制时间已经过去了", new Object[0]);
                    anb.b.remove(str).apply();
                }
                LogPrinter.d("上次出现-8错误的时间：" + this.lastToFastErrTime, new Object[0]);
                if (currentTimeMillis - this.lastToFastErrTime < 10000) {
                    i = -8;
                }
                return i;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.fun.ad.sdk.internal.api.IAdForbidStrategy
    public synchronized void setErrInfo(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, str2) == null) {
            synchronized (this) {
                LogPrinter.d("csj发生了错误，错误码为：" + i + "   广告位：" + str, new Object[0]);
                if (i == -8) {
                    this.lastToFastErrTime = System.currentTimeMillis();
                    LogPrinter.d("记录-8出现的时间" + this.lastToFastErrTime, new Object[0]);
                } else if (str2 == null) {
                } else {
                    if (str2.contains("112")) {
                        LogPrinter.d("记录112出现的时间" + System.currentTimeMillis(), new Object[0]);
                        anb.b.putLong(str, System.currentTimeMillis()).apply();
                        return;
                    }
                    if (str2.contains("228")) {
                        this.lastAntiSpamErrTime = System.currentTimeMillis();
                        LogPrinter.d("记录228出现的时间" + this.lastAntiSpamErrTime, new Object[0]);
                        anb.b.putLong("key_ad_anti_spam_time", this.lastAntiSpamErrTime).apply();
                    }
                }
            }
        }
    }
}
