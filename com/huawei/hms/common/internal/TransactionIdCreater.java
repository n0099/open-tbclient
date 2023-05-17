package com.huawei.hms.common.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.utils.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes9.dex */
public class TransactionIdCreater {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int API_SIZE = 6;
    public static final int APPID_SIZE = 9;
    public static final char FILL_BYTE = '0';
    public transient /* synthetic */ FieldHolder $fh;

    public TransactionIdCreater() {
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

    public static String getId(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            return StringUtil.addByteForNum(str, 9, FILL_BYTE) + StringUtil.addByteForNum(str2, 6, FILL_BYTE) + new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH).format(new Date()) + String.format(Locale.ENGLISH, "%06d", Integer.valueOf(new Random().nextInt(1000000)));
        }
        return (String) invokeLL.objValue;
    }
}
