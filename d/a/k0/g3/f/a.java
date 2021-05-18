package d.a.k0.g3.f;

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
        int i2;
        int i3;
        int i4;
        String loadString = TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_dialog_time", "12:05:00");
        String[] split = (TextUtils.isEmpty(loadString) ? "12:05:00" : loadString).split(":");
        int i5 = 5;
        if (split == null || split.length != 3) {
            i2 = 0;
            i3 = 12;
            i4 = 5;
        } else {
            i3 = d.a.c.e.m.b.d(split[0], 12);
            i4 = d.a.c.e.m.b.d(split[1], 5);
            i2 = d.a.c.e.m.b.d(split[2], 0);
        }
        if (i3 < 0 || i3 > 23 || i4 < 0 || i4 > 59 || i2 < 0 || i2 > 59) {
            i2 = 0;
            i3 = 12;
        } else {
            i5 = i4;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(12, i5);
        calendar.set(13, i2);
        Application app = TbadkCoreApplication.getInst().getApp();
        if (app != null && app.getContentResolver() != null && DateFormat.is24HourFormat(app)) {
            calendar.set(11, i3);
        } else {
            if (i3 >= 12) {
                i3 -= 12;
                calendar.set(9, 1);
            } else {
                calendar.set(9, 0);
            }
            calendar.set(10, i3);
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
        return d.a.j0.r.d0.b.j().k("sync_local_dialog", 1) == 1;
    }

    public static boolean f(long j) {
        Time time = new Time();
        time.set(j);
        int i2 = time.year;
        int i3 = time.month;
        int i4 = time.monthDay;
        time.set(System.currentTimeMillis());
        return i2 == time.year && i3 == time.month && i4 == time.monthDay;
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
