package d.a.n0.r0.i2.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.sportspage.notification.AlarmReceiver;
import d.a.m0.r.d0.b;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58755a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f58756b;

    /* renamed from: d.a.n0.r0.i2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1500a extends CustomMessageListener {
        public C1500a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject((String) customResponsedMessage.getData());
                String optString = jSONObject.optString("gameId");
                String optString2 = jSONObject.optString("gameName");
                String optString3 = jSONObject.optString("gameTime");
                String optString4 = jSONObject.optString("gameType");
                String p = b.j().p("key_match_id_list_" + optString4, "");
                String str2 = "match_id_" + optString4 + "_" + optString;
                if (TextUtils.isEmpty(p)) {
                    str = str2;
                } else {
                    str = "," + str2;
                }
                if (TextUtils.isEmpty(p) || !p.contains(str2)) {
                    b.j().x("key_match_id_list_" + optString4, p + str);
                }
                Intent intent = new Intent(a.this.f58755a.getPageActivity(), AlarmReceiver.class);
                intent.putExtra("KEY_MATCH_NAME", optString2);
                intent.putExtra("KEY_MATCH_TYPE", optString4);
                intent.putExtra("KEY_MATCH_ID", optString);
                PendingIntent broadcast = PendingIntent.getBroadcast(a.this.f58755a.getPageActivity(), 0, intent, 0);
                Calendar calendar = Calendar.getInstance();
                long currentTimeMillis = System.currentTimeMillis();
                calendar.setTimeInMillis(currentTimeMillis);
                long f2 = (d.a.c.e.m.b.f(optString3, 0L) * 1000) - currentTimeMillis;
                if (f2 > 0) {
                    calendar.add(14, (int) f2);
                }
                ((AlarmManager) a.this.f58755a.getPageActivity().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, calendar.getTimeInMillis(), broadcast);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        C1500a c1500a = new C1500a(2921404);
        this.f58756b = c1500a;
        this.f58755a = tbPageContext;
        tbPageContext.registerListener(c1500a);
    }
}
