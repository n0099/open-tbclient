package com.repackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.myCollection.CollectUpdateReceiver;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeHttpResponseMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeRequestMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class sn7 {
    public static /* synthetic */ Interceptable $ic;
    public static sn7 b;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* loaded from: classes7.dex */
    public class a extends ab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sn7 sn7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.repackage.ab
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                List<String> list = Collections.EMPTY_LIST;
                if (responsedMessage instanceof GetStoreRemindTimeHttpResponseMessage) {
                    list = ((GetStoreRemindTimeHttpResponseMessage) responsedMessage).getTimeList();
                } else if (responsedMessage instanceof GetStoreRemindTimeSocketResponseMessage) {
                    list = ((GetStoreRemindTimeSocketResponseMessage) responsedMessage).getTimeList();
                }
                if (list.isEmpty()) {
                    return;
                }
                ru4.k().y("collect_update_time_key", new JSONArray((Collection) list).toString());
                sn7.b().g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Comparator<Calendar> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(sn7 sn7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sn7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Calendar calendar, Calendar calendar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, calendar, calendar2)) == null) ? calendar.before(calendar2) ? -1 : 1 : invokeLL.intValue;
        }
    }

    public sn7() {
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
        this.a = false;
        MessageManager.getInstance().registerListener(new a(this, CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, 309117));
        kk8.g(309117, GetStoreRemindTimeSocketResponseMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, kk8.a("c/f/livegroup/getStoreRemindTime", 309117));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(GetStoreRemindTimeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static sn7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (sn7.class) {
                    if (b == null) {
                        b = new sn7();
                    }
                }
            }
            return b;
        }
        return (sn7) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long m = ru4.k().m("collect_request_time_key", -1L);
            if (m == -1) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis() - m;
            return currentTimeMillis > 0 && TimeUnit.MILLISECONDS.toDays(currentTimeMillis) >= 1;
        }
        return invokeV.booleanValue;
    }

    public final Calendar c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String q = ru4.k().q("collect_update_time_key", null);
            if (TextUtils.isEmpty(q)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Calendar calendar = Calendar.getInstance();
            try {
                JSONArray jSONArray = new JSONArray(q);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        Calendar calendar2 = (Calendar) calendar.clone();
                        calendar2.setTime(simpleDateFormat.parse(optString));
                        calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5));
                        arrayList.add(calendar2);
                    }
                }
            } catch (ParseException e) {
                BdLog.e(e.getMessage());
                e.printStackTrace();
                return null;
            } catch (JSONException e2) {
                BdLog.e(e2.getMessage());
                return null;
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            Collections.sort(arrayList, new b(this));
            Calendar calendar3 = (Calendar) arrayList.get(0);
            Calendar calendar4 = (Calendar) arrayList.get(arrayList.size() - 1);
            if (arrayList.size() == 1 || calendar3.after(calendar) || calendar4.before(calendar)) {
                return calendar3;
            }
            for (int i2 = 1; i2 < arrayList.size(); i2++) {
                Calendar calendar5 = (Calendar) arrayList.get(i2);
                if (!calendar5.before(calendar)) {
                    return calendar5;
                }
            }
            return null;
        }
        return (Calendar) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && a()) {
            MessageManager.getInstance().sendMessage(new GetStoreRemindTimeRequestMessage());
            h();
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (this.a) {
                z = false;
            }
            ru4.k().u("collect_update_flag_key" + TbadkCoreApplication.getCurrentAccount(), z);
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a = z;
        }
    }

    public void g() {
        Calendar c;
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (c = c()) == null || (context = TbadkCoreApplication.getInst().getContext()) == null) {
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(CollectUpdateReceiver.ACTION_NAME);
        intent.setPackage(context.getPackageName());
        Calendar calendar = Calendar.getInstance();
        calendar.set(14, 0);
        if (c.before(calendar)) {
            c.set(6, calendar.get(6) + 1);
        }
        alarmManager.set(1, c.getTimeInMillis(), PendingIntent.getBroadcast(context, 0, intent, 134217728));
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ru4.k().x("collect_request_time_key", System.currentTimeMillis());
        }
    }
}
