package d.a.q0.u0.i2.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.sportspage.notification.AlarmReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.d0.b;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63578a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f63579b;

    /* renamed from: d.a.q0.u0.i2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1679a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63580a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1679a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63580a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
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
                    Intent intent = new Intent(this.f63580a.f63578a.getPageActivity(), AlarmReceiver.class);
                    intent.putExtra("KEY_MATCH_NAME", optString2);
                    intent.putExtra("KEY_MATCH_TYPE", optString4);
                    intent.putExtra("KEY_MATCH_ID", optString);
                    PendingIntent broadcast = PendingIntent.getBroadcast(this.f63580a.f63578a.getPageActivity(), 0, intent, 0);
                    Calendar calendar = Calendar.getInstance();
                    long currentTimeMillis = System.currentTimeMillis();
                    calendar.setTimeInMillis(currentTimeMillis);
                    long f2 = (d.a.d.e.m.b.f(optString3, 0L) * 1000) - currentTimeMillis;
                    if (f2 > 0) {
                        calendar.add(14, (int) f2);
                    }
                    ((AlarmManager) this.f63580a.f63578a.getPageActivity().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, calendar.getTimeInMillis(), broadcast);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C1679a c1679a = new C1679a(this, 2921404);
        this.f63579b = c1679a;
        this.f63578a = tbPageContext;
        tbPageContext.registerListener(c1679a);
    }
}
