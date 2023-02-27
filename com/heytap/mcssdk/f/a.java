package com.heytap.mcssdk.f;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MessageStat(context.getPackageName(), str));
            return StatUtil.statisticMessage(context, arrayList);
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str, DataMessage dataMessage) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, dataMessage)) == null) {
            ArrayList arrayList = new ArrayList();
            String packageName = context.getPackageName();
            arrayList.add(dataMessage == null ? new MessageStat(packageName, str) : new MessageStat(dataMessage.getMessageType(), packageName, dataMessage.getGlobalId(), dataMessage.getTaskID(), str, null, dataMessage.getStatisticsExtra(), dataMessage.getDataExtra()));
            return StatUtil.statisticMessage(context, arrayList);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean a(Context context, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, list)) == null) {
            ArrayList arrayList = new ArrayList();
            String packageName = context.getPackageName();
            if (list != null && list.size() != 0) {
                for (String str : list) {
                    arrayList.add(new MessageStat(packageName, str));
                }
            }
            return StatUtil.statisticMessage(context, arrayList);
        }
        return invokeLL.booleanValue;
    }
}
