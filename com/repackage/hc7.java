package com.repackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.AlarmReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class hc7 extends kj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hc7() {
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

    @Override // com.repackage.kj4, com.repackage.nj4
    public pj4 b(Object obj, HashMap<String, String> hashMap, String str) {
        InterceptResult invokeLLL;
        Map.Entry<String, String> next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, hashMap, str)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            pj4 pj4Var = new pj4();
            if (obj instanceof ab7) {
                ab7 ab7Var = (ab7) obj;
                boolean c = ab7Var.c();
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent(context, AlarmReceiver.class);
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                intent.putExtra("uid", TbadkCoreApplication.getCurrentAccount());
                intent.setData(Uri.parse(currentAccount));
                long j = 0;
                Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
                int i = 0;
                while (it.hasNext() && (next = it.next()) != null) {
                    intent.putExtra(next.getKey(), next.getValue());
                    if ("task_id".equals(next.getKey())) {
                        i = Integer.parseInt(next.getValue());
                    } else if ("s_time".equals(next.getKey())) {
                        j = Long.parseLong(next.getValue()) * 1000;
                    }
                }
                StatisticItem statisticItem = new StatisticItem(ab7Var.i());
                statisticItem.param("obj_id", "");
                if (c) {
                    statisticItem.param("obj_type", "2");
                    BdToast.c(context, context.getString(R.string.obfuscated_res_0x7f0f092e)).n();
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                    if (broadcast != null) {
                        alarmManager.cancel(broadcast);
                        broadcast.cancel();
                    }
                    pj4Var.a = false;
                } else {
                    statisticItem.param("obj_type", "1");
                    BdToast.c(context, context.getString(R.string.obfuscated_res_0x7f0f0939)).n();
                    alarmManager.set(0, j, PendingIntent.getBroadcast(context, i, intent, 134217728));
                    pj4Var.a = true;
                }
                TiebaStatic.log(statisticItem);
                ab7Var.l(pj4Var.a);
            }
            return pj4Var;
        }
        return (pj4) invokeLLL.objValue;
    }

    @Override // com.repackage.kj4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "interview/registerInterviewNotice" : (String) invokeV.objValue;
    }
}
