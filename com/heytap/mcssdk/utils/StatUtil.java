package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class StatUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COUNT = "count";
    public static final int MCS_SUPPORT_VERSION = 1017;
    public static final String STAT_LIST = "list";
    public static final String TYPE = "type";
    public transient /* synthetic */ FieldHolder $fh;

    public StatUtil() {
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

    public static boolean isSupportStatisticByMcs(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String mcsPackageName = PushService.getInstance().getMcsPackageName(context);
            return Utils.isExistPackage(context, mcsPackageName) && Utils.getVersionCode(context, mcsPackageName) >= 1017;
        }
        return invokeL.booleanValue;
    }

    public static void statisticMessage(Context context, MessageStat messageStat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, messageStat) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(messageStat);
            statisticMessage(context, linkedList);
        }
    }

    public static boolean statisticMessage(Context context, List<MessageStat> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, list)) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            d.b("isSupportStatisticByMcs:" + isSupportStatisticByMcs(context) + ",list size:" + linkedList.size());
            if (linkedList.size() <= 0 || !isSupportStatisticByMcs(context)) {
                return false;
            }
            return statisticMessageByMcs(context, linkedList);
        }
        return invokeLL.booleanValue;
    }

    public static boolean statisticMessageByMcs(Context context, List<MessageStat> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, list)) == null) {
            try {
                Intent intent = new Intent();
                intent.setAction(PushService.getInstance().getReceiveSdkAction(context));
                intent.setPackage(PushService.getInstance().getMcsPackageName(context));
                intent.putExtra("appPackage", context.getPackageName());
                intent.putExtra("type", MessageConstant.CommandId.COMMAND_STATISTIC);
                intent.putExtra("count", list.size());
                ArrayList<String> arrayList = new ArrayList<>();
                for (MessageStat messageStat : list) {
                    arrayList.add(messageStat.toJsonObject());
                }
                intent.putStringArrayListExtra("list", arrayList);
                context.startService(intent);
                return true;
            } catch (Exception e) {
                d.e("statisticMessage--Exception" + e.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
