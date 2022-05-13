package com.repackage;

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
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public CustomMessageListener b;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fo6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fo6 fo6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fo6Var;
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
                    String q = iu4.k().q("key_match_id_list_" + optString4, "");
                    String str2 = "match_id_" + optString4 + "_" + optString;
                    if (TextUtils.isEmpty(q)) {
                        str = str2;
                    } else {
                        str = "," + str2;
                    }
                    if (TextUtils.isEmpty(q) || !q.contains(str2)) {
                        iu4.k().y("key_match_id_list_" + optString4, q + str);
                    }
                    Intent intent = new Intent(this.a.a.getPageActivity(), AlarmReceiver.class);
                    intent.putExtra("KEY_MATCH_NAME", optString2);
                    intent.putExtra("KEY_MATCH_TYPE", optString4);
                    intent.putExtra("KEY_MATCH_ID", optString);
                    PendingIntent broadcast = PendingIntent.getBroadcast(this.a.a.getPageActivity(), 0, intent, 0);
                    Calendar calendar = Calendar.getInstance();
                    long currentTimeMillis = System.currentTimeMillis();
                    calendar.setTimeInMillis(currentTimeMillis);
                    long g = (kg.g(optString3, 0L) * 1000) - currentTimeMillis;
                    if (g > 0) {
                        calendar.add(14, (int) g);
                    }
                    ((AlarmManager) this.a.a.getPageActivity().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, calendar.getTimeInMillis(), broadcast);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public fo6(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this, 2921404);
        this.b = aVar;
        this.a = tbPageContext;
        tbPageContext.registerListener(aVar);
    }
}
