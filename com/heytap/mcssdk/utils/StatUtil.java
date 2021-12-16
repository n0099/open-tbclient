package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.MessageStat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isSupportStatisticByMcs(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String mcsPackageName = PushManager.getMcsPackageName(context);
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

    public static void statisticMessage(Context context, List<MessageStat> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, list) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(list);
            LogUtil.d("isSupportStatisticByMcs:" + isSupportStatisticByMcs(context) + ",list size:" + linkedList.size());
            if (linkedList.size() <= 0 || !isSupportStatisticByMcs(context)) {
                return;
            }
            statisticMessageByMcs(context, linkedList);
        }
    }

    public static void statisticMessageByMcs(Context context, List<MessageStat> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, list) == null) {
            try {
                Intent intent = new Intent();
                intent.setAction(PushManager.getReceiveSdkAction(context));
                intent.setPackage(PushManager.getMcsPackageName(context));
                intent.putExtra("appPackage", context.getPackageName());
                intent.putExtra("type", CommandMessage.COMMAND_STATISTIC);
                intent.putExtra("count", list.size());
                ArrayList<String> arrayList = new ArrayList<>();
                for (MessageStat messageStat : list) {
                    arrayList.add(messageStat.toJsonObject());
                }
                intent.putStringArrayListExtra("list", arrayList);
                context.startService(intent);
            } catch (Exception e2) {
                LogUtil.e("statisticMessage--Exception" + e2.getMessage());
            }
        }
    }
}
