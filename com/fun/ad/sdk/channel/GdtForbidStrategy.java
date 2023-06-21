package com.fun.ad.sdk.channel;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.z4b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.IAdForbidStrategy;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.comm.constants.ErrorCode;
/* loaded from: classes9.dex */
public class GdtForbidStrategy implements IAdForbidStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long FORBID_TIME_ANTI_SPAM = 3600000;
    public static final long FORBID_TIME_TO_MACH = 3600000;
    public transient /* synthetic */ FieldHolder $fh;

    public GdtForbidStrategy() {
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

    @Override // com.fun.ad.sdk.internal.api.IAdForbidStrategy
    public synchronized int checkForbidStatus(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                LogPrinter.d("开始判断是否需要拦截当前请求，广告位：" + str, new Object[0]);
                SharedPreferences sharedPreferences = z4b.a;
                long j = sharedPreferences.getLong(str + SubPbActivityConfig.KEY_ANTI, 0L);
                LogPrinter.d("上次出现5004错误的时间：" + j, new Object[0]);
                if (j != 0) {
                    if (currentTimeMillis - j < 3600000) {
                        LogPrinter.d("gdt还没有超出5004错误的限制时间，广告位：" + str + " 不发起load", new Object[0]);
                        return 5004;
                    }
                    SharedPreferences.Editor editor = z4b.b;
                    editor.remove(str + SubPbActivityConfig.KEY_ANTI).apply();
                }
                long j2 = sharedPreferences.getLong(str, 0L);
                LogPrinter.d("上次出现109502错误的时间：" + j2, new Object[0]);
                if (j2 != 0) {
                    if (currentTimeMillis - j2 < 3600000) {
                        LogPrinter.d("还没有超出109502错误的限制拦截时间，直接不发起load", new Object[0]);
                        return ErrorCode.ServerError.REQUEST_FREQUENTLY;
                    }
                    LogPrinter.d("该广告位 " + str + " 的109502错误的限制时间已经过去了", new Object[0]);
                    z4b.b.remove(str).apply();
                }
                LogPrinter.d("不需要拦截，广告位" + str, new Object[0]);
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Override // com.fun.ad.sdk.internal.api.IAdForbidStrategy
    public synchronized void setErrInfo(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, str2) == null) {
            synchronized (this) {
                LogPrinter.d("gdt发生了错误，错误码为：" + i + "  广告位：" + str, new Object[0]);
                if (i == 109502) {
                    LogPrinter.d("记录109502出现的时间" + System.currentTimeMillis(), new Object[0]);
                    z4b.b.putLong(str, System.currentTimeMillis()).apply();
                } else if (i == 5004) {
                    LogPrinter.d("记录错误码5004出现的时间" + System.currentTimeMillis(), new Object[0]);
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences.Editor editor = z4b.b;
                    editor.putLong(str + SubPbActivityConfig.KEY_ANTI, currentTimeMillis).apply();
                }
            }
        }
    }
}
