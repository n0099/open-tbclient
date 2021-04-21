package d.b.j0.g3.f;

import android.app.Application;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.tencent.open.SocialConstants;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes5.dex */
public class a {
    public static RemindRecommendMessage a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            RemindRecommendMessage remindRecommendMessage = new RemindRecommendMessage();
            JSONObject jSONObject = new JSONObject(str);
            remindRecommendMessage.title = jSONObject.optString("title");
            remindRecommendMessage.url = jSONObject.optString("url");
            remindRecommendMessage.picture = jSONObject.optString(SocialConstants.PARAM_AVATAR_URI);
            remindRecommendMessage.name = jSONObject.optString("name");
            remindRecommendMessage.isLocal = false;
            return remindRecommendMessage;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static long b() {
        return c(System.currentTimeMillis());
    }

    public static long c(long j) {
        int i;
        int i2;
        int i3;
        String loadString = TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_dialog_time", "12:05:00");
        String[] split = (TextUtils.isEmpty(loadString) ? "12:05:00" : loadString).split(":");
        int i4 = 5;
        if (split == null || split.length != 3) {
            i = 0;
            i2 = 12;
            i3 = 5;
        } else {
            i2 = d.b.c.e.m.b.d(split[0], 12);
            i3 = d.b.c.e.m.b.d(split[1], 5);
            i = d.b.c.e.m.b.d(split[2], 0);
        }
        if (i2 < 0 || i2 > 23 || i3 < 0 || i3 > 59 || i < 0 || i > 59) {
            i = 0;
            i2 = 12;
        } else {
            i4 = i3;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(12, i4);
        calendar.set(13, i);
        Application app = TbadkCoreApplication.getInst().getApp();
        if (app != null && app.getContentResolver() != null && DateFormat.is24HourFormat(app)) {
            calendar.set(11, i2);
        } else {
            if (i2 >= 12) {
                i2 -= 12;
                calendar.set(9, 1);
            } else {
                calendar.set(9, 0);
            }
            calendar.set(10, i2);
        }
        return calendar.getTimeInMillis();
    }

    public static boolean d() {
        StringBuilder sb = new StringBuilder();
        sb.append(TbadkCoreApplication.getCurrentAccount());
        sb.append("remind_recommend_server_switch");
        return TbadkSettings.getInst().loadInt(sb.toString(), 1) == 1;
    }

    public static boolean e() {
        return d.b.i0.r.d0.b.j().k("sync_local_dialog", 1) == 1;
    }

    public static boolean f(long j) {
        Time time = new Time();
        time.set(j);
        int i = time.year;
        int i2 = time.month;
        int i3 = time.monthDay;
        time.set(System.currentTimeMillis());
        return i == time.year && i2 == time.month && i3 == time.monthDay;
    }

    public static String g(DataRes dataRes) {
        if (dataRes != null && dataRes.local_dialog != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("title", dataRes.local_dialog.title);
                jSONObject.put(SocialConstants.PARAM_AVATAR_URI, dataRes.local_dialog.picture);
                jSONObject.put("url", dataRes.local_dialog.url);
                jSONObject.put("name", dataRes.local_dialog.name);
                return jSONObject.toString();
            } catch (JSONException unused) {
            }
        }
        return null;
    }
}
