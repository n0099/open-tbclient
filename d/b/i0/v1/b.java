package d.b.i0.v1;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.myCollection.CollectUpdateReceiver;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeHttpResponseMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeRequestMessage;
import com.baidu.tieba.myCollection.message.GetStoreRemindTimeSocketResponseMessage;
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
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f61984b;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f61985a = false;

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(b bVar, int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            List<String> list = Collections.EMPTY_LIST;
            if (responsedMessage instanceof GetStoreRemindTimeHttpResponseMessage) {
                list = ((GetStoreRemindTimeHttpResponseMessage) responsedMessage).getTimeList();
            } else if (responsedMessage instanceof GetStoreRemindTimeSocketResponseMessage) {
                list = ((GetStoreRemindTimeSocketResponseMessage) responsedMessage).getTimeList();
            }
            if (list.isEmpty()) {
                return;
            }
            d.b.h0.r.d0.b.i().w("collect_update_time_key", new JSONArray((Collection) list).toString());
            b.b().g();
        }
    }

    /* renamed from: d.b.i0.v1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1637b implements Comparator<Calendar> {
        public C1637b(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Calendar calendar, Calendar calendar2) {
            return calendar.before(calendar2) ? -1 : 1;
        }
    }

    public b() {
        MessageManager.getInstance().registerListener(new a(this, CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, 309117));
        d.b.i0.c3.d0.a.g(309117, GetStoreRemindTimeSocketResponseMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, d.b.i0.c3.d0.a.a("c/f/livegroup/getStoreRemindTime", 309117));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(GetStoreRemindTimeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static b b() {
        if (f61984b == null) {
            synchronized (b.class) {
                if (f61984b == null) {
                    f61984b = new b();
                }
            }
        }
        return f61984b;
    }

    public boolean a() {
        long k = d.b.h0.r.d0.b.i().k("collect_request_time_key", -1L);
        if (k == -1) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - k;
        return currentTimeMillis > 0 && TimeUnit.MILLISECONDS.toDays(currentTimeMillis) >= 1;
    }

    public final Calendar c() {
        String o = d.b.h0.r.d0.b.i().o("collect_update_time_key", null);
        if (TextUtils.isEmpty(o)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        try {
            JSONArray jSONArray = new JSONArray(o);
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
        } catch (ParseException e2) {
            BdLog.e(e2.getMessage());
            e2.printStackTrace();
            return null;
        } catch (JSONException e3) {
            BdLog.e(e3.getMessage());
            return null;
        } catch (Exception e4) {
            BdLog.e(e4.getMessage());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Collections.sort(arrayList, new C1637b(this));
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

    public void d() {
        if (a()) {
            MessageManager.getInstance().sendMessage(new GetStoreRemindTimeRequestMessage());
            h();
        }
    }

    public void e(boolean z) {
        if (this.f61985a) {
            z = false;
        }
        d.b.h0.r.d0.b.i().s("collect_update_flag_key" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void f(boolean z) {
        this.f61985a = z;
    }

    public void g() {
        Context context;
        Calendar c2 = c();
        if (c2 == null || (context = TbadkCoreApplication.getInst().getContext()) == null) {
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(CollectUpdateReceiver.ACTION_NAME);
        intent.setPackage(context.getPackageName());
        Calendar calendar = Calendar.getInstance();
        calendar.set(14, 0);
        if (c2.before(calendar)) {
            c2.set(6, calendar.get(6) + 1);
        }
        alarmManager.set(1, c2.getTimeInMillis(), PendingIntent.getBroadcast(context, 0, intent, 134217728));
    }

    public void h() {
        d.b.h0.r.d0.b.i().v("collect_request_time_key", System.currentTimeMillis());
    }
}
