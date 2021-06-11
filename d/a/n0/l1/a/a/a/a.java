package d.a.n0.l1.a.a.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.AlarmReceiver;
import d.a.m0.c.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public class a extends d.a.m0.c.a {
    @Override // d.a.m0.c.a, d.a.m0.c.d
    public f b(Object obj, HashMap<String, String> hashMap, String str) {
        Map.Entry<String, String> next;
        Context baseContext = TbadkCoreApplication.getInst().getBaseContext();
        f fVar = new f();
        if (obj instanceof d.a.n0.k1.o.j.a) {
            d.a.n0.k1.o.j.a aVar = (d.a.n0.k1.o.j.a) obj;
            Intent intent = new Intent(baseContext, AlarmReceiver.class);
            Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext() && (next = it.next()) != null) {
                intent.putExtra(next.getKey(), next.getValue());
                if ("task_id".equals(next.getKey())) {
                    i2 = Integer.parseInt(next.getValue());
                }
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            intent.setData(Uri.parse(currentAccount));
            fVar.f52888a = PendingIntent.getBroadcast(baseContext, i2, intent, 536870912) != null;
            aVar.m(true);
            aVar.l(fVar.f52888a);
        }
        return fVar;
    }

    @Override // d.a.m0.c.a
    public String c() {
        return "interview/checkInterviewNoticeStatus";
    }
}
