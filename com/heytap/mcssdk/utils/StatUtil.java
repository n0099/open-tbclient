package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.MessageStat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class StatUtil {
    public static final String COUNT = "count";
    public static final int MCS_SUPPORT_VERSION = 1017;
    public static final String STAT_LIST = "list";
    public static final String TYPE = "type";

    public static boolean isSupportStatisticByMcs(Context context) {
        String mcsPackageName = PushManager.getMcsPackageName(context);
        return Utils.isExistPackage(context, mcsPackageName) && Utils.getVersionCode(context, mcsPackageName) >= 1017;
    }

    public static void statisticMessage(Context context, MessageStat messageStat) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(messageStat);
        statisticMessage(context, linkedList);
    }

    public static void statisticMessage(Context context, List<MessageStat> list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        LogUtil.d("isSupportStatisticByMcs:" + isSupportStatisticByMcs(context) + ",list size:" + linkedList.size());
        if (linkedList.size() <= 0 || !isSupportStatisticByMcs(context)) {
            return;
        }
        statisticMessageByMcs(context, linkedList);
    }

    public static void statisticMessageByMcs(Context context, List<MessageStat> list) {
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
