package d.a.o0.x1;

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
    public static b f67072b;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f67073a = false;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(b bVar, int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
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
            d.a.n0.r.d0.b.j().x("collect_update_time_key", new JSONArray((Collection) list).toString());
            b.b().g();
        }
    }

    /* renamed from: d.a.o0.x1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1798b implements Comparator<Calendar> {
        public C1798b(b bVar) {
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
        d.a.o0.e3.d0.a.g(309117, GetStoreRemindTimeSocketResponseMessage.class, false, SocketMessageTask.DupLicateMode.REMOVE_ME, true);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STORE_REMIND_TIME, d.a.o0.e3.d0.a.a("c/f/livegroup/getStoreRemindTime", 309117));
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(GetStoreRemindTimeHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static b b() {
        if (f67072b == null) {
            synchronized (b.class) {
                if (f67072b == null) {
                    f67072b = new b();
                }
            }
        }
        return f67072b;
    }

    public boolean a() {
        long l = d.a.n0.r.d0.b.j().l("collect_request_time_key", -1L);
        if (l == -1) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - l;
        return currentTimeMillis > 0 && TimeUnit.MILLISECONDS.toDays(currentTimeMillis) >= 1;
    }

    public final Calendar c() {
        String p = d.a.n0.r.d0.b.j().p("collect_update_time_key", null);
        if (TextUtils.isEmpty(p)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        try {
            JSONArray jSONArray = new JSONArray(p);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String optString = jSONArray.optString(i2);
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
        Collections.sort(arrayList, new C1798b(this));
        Calendar calendar3 = (Calendar) arrayList.get(0);
        Calendar calendar4 = (Calendar) arrayList.get(arrayList.size() - 1);
        if (arrayList.size() == 1 || calendar3.after(calendar) || calendar4.before(calendar)) {
            return calendar3;
        }
        for (int i3 = 1; i3 < arrayList.size(); i3++) {
            Calendar calendar5 = (Calendar) arrayList.get(i3);
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
        if (this.f67073a) {
            z = false;
        }
        d.a.n0.r.d0.b.j().t("collect_update_flag_key" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void f(boolean z) {
        this.f67073a = z;
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
        d.a.n0.r.d0.b.j().w("collect_request_time_key", System.currentTimeMillis());
    }
}
