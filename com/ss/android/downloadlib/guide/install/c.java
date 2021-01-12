package com.ss.android.downloadlib.guide.install;

import android.content.SharedPreferences;
import android.util.Pair;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.downloader.m.g;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static void a(JSONObject jSONObject) {
        boolean z = false;
        if (jSONObject != null && jSONObject.has("hijack")) {
            z = jSONObject.optInt("hijack") == 1;
        }
        a(z);
    }

    public static void a() {
        a(true);
    }

    private static void a(boolean z) {
        String b2 = b(System.currentTimeMillis());
        SharedPreferences sharedPreferences = j.a().getSharedPreferences("sp_install_guide", 0);
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString(b2, "{}"));
            jSONObject.putOpt("key_install_finish", Integer.valueOf(jSONObject.optInt("key_install_finish") + 1));
            if (z) {
                jSONObject.putOpt("key_install_finish_hijack", Integer.valueOf(jSONObject.optInt("key_install_finish_hijack") + 1));
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(b2, jSONObject.toString());
            edit.apply();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void b() {
        SharedPreferences.Editor edit = j.a().getSharedPreferences("sp_install_guide", 0).edit();
        edit.putLong("guide_last_show_time", System.currentTimeMillis());
        edit.apply();
    }

    public static boolean a(int i) {
        return b(i) && c(i) && d(i);
    }

    private static boolean b(int i) {
        if (com.ss.android.downloadlib.f.d.a(i)) {
            if (g.b() && com.ss.android.downloadlib.f.d.d(i)) {
                return true;
            }
            if (g.d() && com.ss.android.downloadlib.f.d.e(i)) {
                return true;
            }
            if (g.c() && com.ss.android.downloadlib.f.d.b(i)) {
                return true;
            }
            return g.a() && com.ss.android.downloadlib.f.d.c(i);
        }
        return false;
    }

    private static boolean c(int i) {
        return System.currentTimeMillis() - j.a().getSharedPreferences("sp_install_guide", 0).getLong("guide_last_show_time", 0L) >= ((long) (com.ss.android.downloadlib.f.d.fC(i) * 86400000));
    }

    private static boolean d(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i2 = 0;
        int i3 = 0;
        for (int fD = com.ss.android.downloadlib.f.d.fD(i); fD > 0; fD--) {
            Pair<Integer, Integer> jd = jd(calendar.getTimeInMillis());
            i3 += ((Integer) jd.first).intValue();
            i2 += ((Integer) jd.second).intValue();
            calendar.setTimeInMillis(calendar.getTimeInMillis() - 86400000);
        }
        return ((double) i2) >= ((double) i3) * com.ss.android.downloadlib.f.d.QC(i);
    }

    private static Pair<Integer, Integer> jd(long j) {
        try {
            JSONObject jSONObject = new JSONObject(j.a().getSharedPreferences("sp_install_guide", 0).getString(b(j), "{}"));
            return new Pair<>(Integer.valueOf(jSONObject.optInt("key_install_finish")), Integer.valueOf(jSONObject.optInt("key_install_finish_hijack")));
        } catch (JSONException e) {
            e.printStackTrace();
            return new Pair<>(0, 0);
        }
    }

    private static String b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        return i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + calendar.get(5);
    }
}
