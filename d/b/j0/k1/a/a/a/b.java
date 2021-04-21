package d.b.j0.k1.a.a.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.AlarmReceiver;
import d.b.i0.c.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public class b extends d.b.i0.c.a {
    @Override // d.b.i0.c.a, d.b.i0.c.d
    public f b(Object obj, HashMap<String, String> hashMap, String str) {
        Map.Entry<String, String> next;
        Context context = TbadkCoreApplication.getInst().getContext();
        f fVar = new f();
        if (obj instanceof d.b.j0.j1.o.j.a) {
            d.b.j0.j1.o.j.a aVar = (d.b.j0.j1.o.j.a) obj;
            boolean c2 = aVar.c();
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
            StatisticItem statisticItem = new StatisticItem(aVar.i());
            statisticItem.param("obj_id", "");
            if (c2) {
                statisticItem.param("obj_type", "2");
                BdToast.c(context, context.getString(R.string.interview_close_tip)).q();
                PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, 536870912);
                if (broadcast != null) {
                    alarmManager.cancel(broadcast);
                    broadcast.cancel();
                }
                fVar.f50789a = false;
            } else {
                statisticItem.param("obj_type", "1");
                BdToast.c(context, context.getString(R.string.interview_open_tip)).q();
                alarmManager.set(0, j, PendingIntent.getBroadcast(context, i, intent, 134217728));
                fVar.f50789a = true;
            }
            TiebaStatic.log(statisticItem);
            aVar.l(fVar.f50789a);
        }
        return fVar;
    }

    @Override // d.b.i0.c.a
    public String c() {
        return "interview/registerInterviewNotice";
    }
}
