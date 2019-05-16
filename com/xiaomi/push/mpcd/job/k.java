package com.xiaomi.push.mpcd.job;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes3.dex */
public class k extends g {
    private SharedPreferences a;

    public k(Context context, int i) {
        super(context, i);
        this.a = context.getSharedPreferences("mipush_extra", 0);
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 9;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        String str;
        String str2;
        try {
            ActivityManager activityManager = (ActivityManager) this.d.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
            if (Build.VERSION.SDK_INT < 21) {
                str = activityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.add(5, -1);
                long timeInMillis = calendar.getTimeInMillis();
                calendar.add(5, 1);
                List<UsageStats> queryUsageStats = ((UsageStatsManager) this.d.getSystemService("usagestats")).queryUsageStats(0, timeInMillis, calendar.getTimeInMillis());
                if (com.xiaomi.channel.commonutils.misc.c.a(queryUsageStats)) {
                    return null;
                }
                long j = 0;
                str = "";
                int i = 0;
                while (i < queryUsageStats.size()) {
                    UsageStats usageStats = queryUsageStats.get(i);
                    if (usageStats.getLastTimeStamp() > j) {
                        j = usageStats.getLastTimeStamp();
                        str2 = usageStats.getPackageName();
                    } else {
                        str2 = str;
                    }
                    i++;
                    str = str2;
                }
            }
        } catch (Throwable th) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.equals(str, this.a.getString("ltapn", null))) {
            return "^";
        }
        this.a.edit().putString("ltapn", str).commit();
        return str;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.TopApp;
    }
}
